package com.baidu.ar.auth;

import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.h.r;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class AuthJni {
    public static /* synthetic */ Interceptable $ic;
    public static volatile AuthJni jC;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean jD;
    public final List<Runnable> jE;

    public AuthJni() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.jE = new ArrayList();
        this.jD = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            for (Runnable runnable : this.jE) {
                runnable.run();
            }
            this.jE.clear();
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) {
            String name = Thread.currentThread().getName();
            HashMap hashMap = new HashMap();
            hashMap.put("event_param", name + "_" + str + "_" + str2);
            hashMap.put("feature_code", str);
            StatisticApi.onEvent("event_authjni_error", hashMap);
        }
    }

    public static void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            jC = new AuthJni();
            com.baidu.ar.libloader.a.require("ardatabasic");
            com.baidu.ar.libloader.a.setLibReadyListener("ardatabasic", new ILibLoader.c() { // from class: com.baidu.ar.auth.AuthJni.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.ar.libloader.ILibLoader.c
                public void onReady() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        r.runOnUiThread(new Runnable(this) { // from class: com.baidu.ar.auth.AuthJni.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 jF;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.jF = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || AuthJni.jC == null) {
                                    return;
                                }
                                try {
                                    AuthJni.jC.nativeInit();
                                    AuthJni.jC.jD = true;
                                    AuthJni.jC.cy();
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                    AuthJni.d(AuthJni.jC.getVersionStr(), th.getMessage());
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public static void release() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, null) == null) || jC == null) {
            return;
        }
        jC.jE.clear();
        r.runOnUiThread(new Runnable() { // from class: com.baidu.ar.auth.AuthJni.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        AuthJni.jC.nativeDestroy();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    AuthJni unused = AuthJni.jC = null;
                }
            }
        });
    }

    public static void setGrantedFeatures(int[] iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, iArr) == null) || jC == null) {
            return;
        }
        Runnable runnable = new Runnable(iArr) { // from class: com.baidu.ar.auth.AuthJni.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int[] jG;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iArr};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.jG = iArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        if (AuthJni.jC != null) {
                            AuthJni.jC.nativeSetGrantedFeatures(this.jG);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    try {
                        if (AuthJni.jC != null) {
                            AuthJni.jC.nativePutGrantedFeatures(this.jG);
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }
        };
        if (jC.jD) {
            r.runOnUiThread(runnable);
        } else {
            jC.jE.add(runnable);
        }
    }

    public String getVersionStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                int nativeGetVersion = nativeGetVersion();
                return "ver-" + nativeGetVersion;
            } catch (Throwable th) {
                th.printStackTrace();
                return "EXCEPTION-UNKNOWN";
            }
        }
        return (String) invokeV.objValue;
    }

    public native void nativeDestroy();

    public native int nativeGetVersion();

    public native void nativeInit();

    public native void nativePutGrantedFeatures(int[] iArr);

    public native void nativeSetGrantedFeatures(int[] iArr);

    public void sendAuthFailMessageFromNative(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            ARAuth.receiveAuthFailMessage(i2);
        }
    }
}
