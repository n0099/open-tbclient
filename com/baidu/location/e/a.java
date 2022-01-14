package com.baidu.location.e;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "baidu_location_service";

    /* renamed from: b  reason: collision with root package name */
    public static int f35122b = 12000;

    /* renamed from: c  reason: collision with root package name */
    public static int f35123c = 20000;

    /* renamed from: d  reason: collision with root package name */
    public static int f35124d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static int f35125e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static int f35126f = 3;

    /* renamed from: g  reason: collision with root package name */
    public static int f35127g = 4;

    /* renamed from: h  reason: collision with root package name */
    public static int f35128h = 5;

    /* renamed from: i  reason: collision with root package name */
    public static int f35129i = 5120;

    /* renamed from: j  reason: collision with root package name */
    public static int f35130j = 0;
    public static int k = 1;
    public static int l = 2;
    public static int m = 4;
    public static int n = 8;
    public static int o = 16;
    public static int p = 32;
    public static int q = 64;
    public static int r = 128;
    public static int s = 256;
    public static int t = 512;
    public static int u = 1024;
    public static int v = 2048;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1037812656, "Lcom/baidu/location/e/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1037812656, "Lcom/baidu/location/e/a;");
        }
    }
}
