package com.baidu;

import android.util.Log;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class SplashAdFacade {

    /* renamed from: b  reason: collision with root package name */
    public static final SplashAdFacade f2102b = new SplashAdFacade();

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f2103a;

    /* loaded from: classes.dex */
    public enum AdLoadState {
        INIT,
        LOADING,
        SUCCEED,
        FAILED
    }

    /* loaded from: classes.dex */
    public interface a {
        void onFailed();

        void onSuccess();
    }

    public SplashAdFacade() {
        AdLoadState adLoadState = AdLoadState.INIT;
        AdLoadState adLoadState2 = AdLoadState.INIT;
        this.f2103a = false;
        new AtomicInteger(0);
    }

    public static SplashAdFacade a() {
        return f2102b;
    }

    public void b(d.a.b0.a.b.a aVar) {
        if (aVar == null) {
            Log.e("SplashAdFacade", "appContext is null ,init failed");
            return;
        }
        d.a.b0.a.b.a.f38533a.set(aVar);
        new BDAdConfig.Builder().setAppName(aVar.u()).setAppsid(aVar.r()).build(aVar.o()).init();
        MobadsPermissionSettings.setPermissionReadDeviceID(true);
        MobadsPermissionSettings.setPermissionLocation(true);
        MobadsPermissionSettings.setPermissionStorage(true);
        MobadsPermissionSettings.setPermissionAppList(true);
    }

    public boolean c() {
        return this.f2103a;
    }
}
