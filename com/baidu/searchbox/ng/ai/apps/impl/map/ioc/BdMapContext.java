package com.baidu.searchbox.ng.ai.apps.impl.map.ioc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.searchbox.bdmapsdk.BdMapLibLoader;
import com.baidu.searchbox.bdmapsdk.ioc.IBdMapContext;
import com.baidu.searchbox.ng.ai.apps.impl.map.aps.AiAppsPreloadMapLibHelper;
import com.baidu.searchbox.ng.ai.apps.impl.map.data.BdMapLibApsInfo;
import com.baidu.searchbox.ng.ai.apps.impl.map.data.BdMapLibApsInfoWrapper;
import com.baidu.searchbox.ng.ai.apps.impl.map.data.BdMapPreLoadDelegation;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.process.ipc.agent.activity.MainProcessDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
/* loaded from: classes4.dex */
public class BdMapContext implements IBdMapContext {
    @Override // com.baidu.searchbox.bdmapsdk.ioc.IBdMapContext
    public void loadBdMapLib(final BdMapLibLoader.OnFetchMapLibCallback onFetchMapLibCallback) {
        BdMapLibApsInfo bdMapLibApsInfo = new BdMapLibApsInfo();
        bdMapLibApsInfo.mIsMainProcess = ProcessUtils.isMainProcess();
        if (ProcessUtils.isMainProcess()) {
            AiAppsPreloadMapLibHelper.processLoadMapLibMessage(BdMapLibApsInfoWrapper.wrapBdMapLibApsInfo(bdMapLibApsInfo, onFetchMapLibCallback));
        } else if (AiApp.get().getActivity() == null) {
            onFetchMapLibCallback.onFailure();
        } else {
            Bundle bundle = new Bundle();
            bundle.putParcelable("ai_apps_data", bdMapLibApsInfo);
            DelegateUtils.callOnMainWithActivity(AiApp.get().getActivity(), MainProcessDelegateActivity.class, BdMapPreLoadDelegation.class, bundle, new DelegateListener() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.ioc.BdMapContext.1
                @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
                public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                    if (!delegateResult.isOk()) {
                        onFetchMapLibCallback.onFailure();
                    } else if (!delegateResult.mResult.getBoolean("ok")) {
                        onFetchMapLibCallback.onFailure();
                    } else {
                        onFetchMapLibCallback.onSuccess();
                    }
                }
            });
        }
    }
}
