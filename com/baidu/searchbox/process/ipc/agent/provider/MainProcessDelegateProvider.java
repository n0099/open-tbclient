package com.baidu.searchbox.process.ipc.agent.provider;

import android.net.Uri;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes2.dex */
public class MainProcessDelegateProvider extends ProcessDelegateBaseProvider {
    private static final String PROVIDER_AUTHORITIES = AppRuntime.getAppContext().getPackageName() + ".AiAppsDelegateProvider";
    public static final Uri PROVIDER_URI = Uri.parse("content://" + PROVIDER_AUTHORITIES);
}
