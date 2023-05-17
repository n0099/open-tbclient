package com.baidu.searchbox.live.nps;

import android.app.Application;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.ToastService;
/* loaded from: classes3.dex */
public class LiveNpsRuntime {
    public static AppInfoService service = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
    public static ToastService toastService = (ToastService) ServiceManager.getService(ToastService.Companion.getSERVICE_REFERENCE());

    public static Application getApplication() {
        AppInfoService appInfoService = service;
        if (appInfoService != null) {
            return appInfoService.getApplication();
        }
        return null;
    }
}
