package com.baidu.mapapi.utils.poi;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.PanoStateError;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public /* synthetic */ class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f7545a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f7546b;
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
        f7546b = iArr;
        try {
            iArr[HttpClient.HttpStateError.NETWORK_ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7546b[HttpClient.HttpStateError.INNER_ERROR.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[PanoStateError.values().length];
        f7545a = iArr2;
        try {
            iArr2[PanoStateError.f9439b.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f7545a[PanoStateError.f9440c.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f7545a[PanoStateError.f9441d.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f7545a[PanoStateError.f9438a.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
