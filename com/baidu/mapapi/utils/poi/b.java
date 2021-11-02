package com.baidu.mapapi.utils.poi;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.PanoStateError;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public /* synthetic */ class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f39925a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f39926b;
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
        f39926b = iArr;
        try {
            iArr[HttpClient.HttpStateError.NETWORK_ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f39926b[HttpClient.HttpStateError.INNER_ERROR.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[PanoStateError.values().length];
        f39925a = iArr2;
        try {
            iArr2[PanoStateError.f42046b.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f39925a[PanoStateError.f42047c.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f39925a[PanoStateError.f42048d.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f39925a[PanoStateError.f42045a.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
