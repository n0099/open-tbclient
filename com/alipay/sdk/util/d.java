package com.alipay.sdk.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final d f1958a;

    /* renamed from: b  reason: collision with root package name */
    public static final d f1959b;

    /* renamed from: c  reason: collision with root package name */
    public static final d f1960c;

    /* renamed from: d  reason: collision with root package name */
    public static final d f1961d;

    /* renamed from: e  reason: collision with root package name */
    public static final d f1962e;

    /* renamed from: f  reason: collision with root package name */
    public static final d f1963f;

    /* renamed from: g  reason: collision with root package name */
    public static final d f1964g;

    /* renamed from: h  reason: collision with root package name */
    public static final d f1965h;

    /* renamed from: i  reason: collision with root package name */
    public static final d f1966i;
    public static final d j;
    public static final d k;
    public static final d l;
    public static final d m;
    public static final d n;
    public static final d o;
    public static final /* synthetic */ d[] r;
    public transient /* synthetic */ FieldHolder $fh;
    public int p;
    public String q;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1255002884, "Lcom/alipay/sdk/util/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1255002884, "Lcom/alipay/sdk/util/d;");
                return;
            }
        }
        f1958a = new d(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 0, 0, CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING);
        f1959b = new d("NETWORK_TYPE_1", 1, 1, "unicom2G");
        f1960c = new d("NETWORK_TYPE_2", 2, 2, "mobile2G");
        f1961d = new d("NETWORK_TYPE_4", 3, 4, "telecom2G");
        f1962e = new d("NETWORK_TYPE_5", 4, 5, "telecom3G");
        f1963f = new d("NETWORK_TYPE_6", 5, 6, "telecom3G");
        f1964g = new d("NETWORK_TYPE_12", 6, 12, "telecom3G");
        f1965h = new d("NETWORK_TYPE_8", 7, 8, "unicom3G");
        f1966i = new d("NETWORK_TYPE_3", 8, 3, "unicom3G");
        j = new d("NETWORK_TYPE_13", 9, 13, "LTE");
        k = new d("NETWORK_TYPE_11", 10, 11, "IDEN");
        l = new d("NETWORK_TYPE_9", 11, 9, "HSUPA");
        m = new d("NETWORK_TYPE_10", 12, 10, "HSPA");
        n = new d("NETWORK_TYPE_15", 13, 15, "HSPAP");
        d dVar = new d("NONE", 14, -1, "none");
        o = dVar;
        r = new d[]{f1958a, f1959b, f1960c, f1961d, f1962e, f1963f, f1964g, f1965h, f1966i, j, k, l, m, n, dVar};
    }

    public d(String str, int i2, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = i3;
        this.q = str2;
    }

    public static d valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (d) Enum.valueOf(d.class, str) : (d) invokeL.objValue;
    }

    public static d[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (d[]) r.clone() : (d[]) invokeV.objValue;
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.p : invokeV.intValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.q : (String) invokeV.objValue;
    }

    public static d a(int i2) {
        InterceptResult invokeI;
        d[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            for (d dVar : values()) {
                if (dVar.a() == i2) {
                    return dVar;
                }
            }
            return o;
        }
        return (d) invokeI.objValue;
    }
}
