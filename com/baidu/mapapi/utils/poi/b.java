package com.baidu.mapapi.utils.poi;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.PanoStateError;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public /* synthetic */ class b {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f34353b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(512817791, "Lcom/baidu/mapapi/utils/poi/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(512817791, "Lcom/baidu/mapapi/utils/poi/b;");
                return;
            }
        }
        int[] iArr = new int[HttpClient.HttpStateError.values().length];
        f34353b = iArr;
        try {
            iArr[HttpClient.HttpStateError.NETWORK_ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f34353b[HttpClient.HttpStateError.INNER_ERROR.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[PanoStateError.values().length];
        a = iArr2;
        try {
            iArr2[PanoStateError.f36373b.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[PanoStateError.f36374c.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[PanoStateError.f36375d.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[PanoStateError.a.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
