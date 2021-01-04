package com.baidu.mapsdkplatform.comapi.map;

import android.app.Application;
import android.content.Context;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.mapsdkplatform.comapi.NativeLoader;
import com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.platform.comjni.engine.NAEngine;
/* loaded from: classes15.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static int f3184a;

    /* renamed from: b  reason: collision with root package name */
    private static Context f3185b = BMapManager.getContext();

    static {
        if (!com.baidu.mapapi.VersionInfo.getApiVersion().equals(VersionInfo.getApiVersion())) {
            throw new BaiduMapSDKException("the version of map is not match with base");
        }
        NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
    }

    public static void a() {
        if (f3184a == 0) {
            if (f3185b == null) {
                throw new IllegalStateException("BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
            }
            com.baidu.platform.comapi.b.a((Application) f3185b, true, false, false, true);
            com.baidu.platform.comapi.b.b();
            com.baidu.platform.comapi.b.c();
            com.baidu.platform.comapi.util.e.a();
            NAEngine.c();
            com.baidu.platform.comapi.c.a.a().b();
            SysUpdateObservable.getInstance().addObserver(new SysUpdateUtil());
            SysUpdateObservable.getInstance().init("");
        }
        f3184a++;
    }

    public static void a(boolean z) {
        d.m(z);
    }

    public static void b() {
        f3184a--;
        if (f3184a == 0) {
            com.baidu.platform.comapi.b.d();
        }
    }
}
