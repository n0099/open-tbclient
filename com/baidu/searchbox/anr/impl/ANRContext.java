package com.baidu.searchbox.anr.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.anr.ioc.IANRContext;
import com.baidu.searchbox.anr.ioc.IANRRegister;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.block.impl.BlockMonitor;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.track.Track;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.tieba.tf1;
@Autowired
/* loaded from: classes3.dex */
public class ANRContext {
    public static final IANRContext ANR_CONTEXT_DEFAULT = new IANRContext() { // from class: com.baidu.searchbox.anr.impl.ANRContext.1
        @Override // com.baidu.searchbox.anr.ioc.IANRContext
        public void onAppNotResponding(Context context, ANRInfo aNRInfo) {
            if (AppConfig.isDebug()) {
                Log.d(BlockMonitor.TAG, "onAppNotResponding");
            }
            tf1<IANRRegister> iANRUploadList = ANRRuntime.getInstance().getIANRUploadList();
            if (iANRUploadList != null && iANRUploadList.getList() != null && aNRInfo != null) {
                if (AppConfig.isDebug()) {
                    Log.i(BlockMonitor.TAG, "ANRInfo = " + aNRInfo.getStackTrace());
                }
                TrackUI lastTrackUI = Track.getInstance().getLastTrackUI();
                if (lastTrackUI != null) {
                    if (!TextUtils.isEmpty(lastTrackUI.getFragmentPage())) {
                        aNRInfo.setCurrentPage(lastTrackUI.getFragmentPage());
                    } else if (!TextUtils.isEmpty(lastTrackUI.getActivityPage())) {
                        aNRInfo.setCurrentPage(lastTrackUI.getActivityPage());
                    }
                }
                aNRInfo.setTrackUIs(Track.getInstance().getAllTrackUIs());
                aNRInfo.setLogId(CommonUtils.getLogId());
                for (IANRRegister iANRRegister : iANRUploadList.getList()) {
                    iANRRegister.onANR(context, aNRInfo);
                }
            }
        }
    };

    @Inject(force = false)
    public static IANRContext getANRContext() {
        return ANR_CONTEXT_DEFAULT;
    }
}
