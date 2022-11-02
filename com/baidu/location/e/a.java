package com.baidu.location.e;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 12000;
    public static int b = 20000;
    public static int c = 1;
    public static int d = 2;
    public static int e = 3;
    public static int f = 4;
    public static int g = 5;
    public static int h = 5120;
    public static int i = 0;
    public static int j = 1;
    public static int k = 2;
    public static int l = 4;
    public static int m = 8;
    public static int n = 16;
    public static int o = 32;
    public static int p = 64;
    public static int q = 128;
    public static int r = 256;
    public static int s = 512;
    public static int t = 1024;
    public static int u = 2048;
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
