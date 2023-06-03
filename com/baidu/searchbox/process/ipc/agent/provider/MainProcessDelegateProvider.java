package com.baidu.searchbox.process.ipc.agent.provider;

import android.net.Uri;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.downloads.DownloadConstants;
/* loaded from: classes4.dex */
public class MainProcessDelegateProvider extends ProcessDelegateBaseProvider {
    public static final String PROVIDER_AUTHORITIES = AppRuntime.getAppContext().getPackageName() + ".SwanAppDelegateProvider";
    public static final Uri PROVIDER_URI = Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + PROVIDER_AUTHORITIES);
}
