package com.baidu.searchbox.ng.ai.apps.scheme.actions.recommend.delegation;

import android.os.Bundle;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes2.dex */
public class ProcessUrlDelegation extends ProviderDelegation {
    public static final String PARAM_URL_KEY = "param_url_key";
    public static final String RESULT_URL_KEY = "result_url_key";

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String processUrl = AiAppsRuntime.getAiAppAccountRuntime().processUrl(bundle.getString(PARAM_URL_KEY));
        Bundle bundle2 = new Bundle();
        bundle2.putString(RESULT_URL_KEY, processUrl);
        return bundle2;
    }
}
