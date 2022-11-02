package com.baidu.mapsdkplatform.comapi.map;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.mapsdkplatform.comapi.NativeLoader;
import com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.platform.comapi.longlink.BNLongLink;
import com.baidu.platform.comjni.engine.NAEngine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static Context b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(724782282, "Lcom/baidu/mapsdkplatform/comapi/map/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(724782282, "Lcom/baidu/mapsdkplatform/comapi/map/j;");
                return;
            }
        }
        b = BMapManager.getContext();
        if (!com.baidu.mapsdkplatform.comapi.c.a()) {
            NativeLoader.getInstance().loadLibrary(com.baidu.mapapi.VersionInfo.getKitName());
        }
        if (com.baidu.mapapi.VersionInfo.getApiVersion().equals(VersionInfo.getApiVersion())) {
            NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
            return;
        }
        throw new BaiduMapSDKException("the version of map is not match with base");
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            if (a == 0) {
                if (b == null) {
                    Log.e("BDMapSDK", "you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
                    return;
                }
                com.baidu.mapsdkplatform.comapi.commonutils.b.a().b();
                com.baidu.platform.comapi.b.a((Application) b, true, false, false, true);
                com.baidu.platform.comapi.b.b();
                com.baidu.platform.comapi.b.a(new a());
                com.baidu.platform.comapi.util.f.a();
                BNLongLink.initLongLink();
                NAEngine.c();
                NAEngine.startRunningRequest();
                SysUpdateObservable.getInstance().addObserver(new SysUpdateUtil());
                SysUpdateObservable.getInstance().init("");
            }
            a++;
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("BasicMap init mRef = " + a);
            }
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            a--;
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("BasicMap destroy mRef = " + a);
            }
            if (a == 0) {
                com.baidu.mapsdkplatform.comapi.commonutils.b.a().c();
                com.baidu.platform.comapi.b.c();
            }
        }
    }
}
