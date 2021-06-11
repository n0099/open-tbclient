package com.baidu;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import d.a.d0.b.f;
import d.a.d0.b.g.g;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class SplashAdFacade {

    /* renamed from: e  reason: collision with root package name */
    public static final SplashAdFacade f2115e = new SplashAdFacade();

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f2116a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.d0.b.a f2117b;

    /* renamed from: c  reason: collision with root package name */
    public long f2118c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f2119d;

    /* loaded from: classes.dex */
    public enum AdLoadState {
        INIT,
        LOADING,
        SUCCEED,
        FAILED
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f2120e;

        public a(int i2) {
            this.f2120e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2120e != 1 || ((float) (System.currentTimeMillis() - SplashAdFacade.this.f2118c)) >= g.c() * 60000.0f) {
                if (SplashAdFacade.this.f2117b == null) {
                    SplashAdFacade.this.f2117b = new d.a.d0.b.a();
                }
                SplashAdFacade.this.f2117b.l(d.a.d0.a.b.a.f43271a.get());
                SplashAdFacade.this.f2118c = System.currentTimeMillis();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void onFailed();

        void onSuccess();
    }

    public SplashAdFacade() {
        AdLoadState adLoadState = AdLoadState.INIT;
        AdLoadState adLoadState2 = AdLoadState.INIT;
        this.f2116a = false;
        new AtomicInteger(0);
        this.f2119d = new Handler(Looper.myLooper());
    }

    public static SplashAdFacade e() {
        return f2115e;
    }

    public void f(d.a.d0.a.b.a aVar) {
        if (aVar == null) {
            Log.e("SplashAdFacade", "appContext is null ,init failed");
            return;
        }
        d.a.d0.a.b.a.f43271a.set(aVar);
        aVar.o().registerActivityLifecycleCallbacks(new f());
        new BDAdConfig.Builder().setAppName(aVar.u()).setAppsid(aVar.r()).build(aVar.o()).init();
        MobadsPermissionSettings.setPermissionReadDeviceID(true);
        MobadsPermissionSettings.setPermissionLocation(true);
        MobadsPermissionSettings.setPermissionStorage(true);
        MobadsPermissionSettings.setPermissionAppList(true);
    }

    public boolean g() {
        return this.f2116a;
    }

    public void h(int i2) {
        if (d.a.d0.a.b.a.f43271a.get() == null) {
            return;
        }
        this.f2119d.postDelayed(new a(i2), 5000L);
    }
}
