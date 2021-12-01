package com.alipay.sdk.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final e f31408c;

    /* renamed from: d  reason: collision with root package name */
    public static final e f31409d;

    /* renamed from: e  reason: collision with root package name */
    public static final e f31410e;

    /* renamed from: f  reason: collision with root package name */
    public static final e f31411f;

    /* renamed from: g  reason: collision with root package name */
    public static final e f31412g;

    /* renamed from: h  reason: collision with root package name */
    public static final e f31413h;

    /* renamed from: i  reason: collision with root package name */
    public static final e f31414i;

    /* renamed from: j  reason: collision with root package name */
    public static final e f31415j;

    /* renamed from: k  reason: collision with root package name */
    public static final e f31416k;
    public static final e l;
    public static final e m;
    public static final e n;
    public static final e o;
    public static final e p;
    public static final e q;
    public static final e r;
    public static final /* synthetic */ e[] s;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f31417b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1255002915, "Lcom/alipay/sdk/util/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1255002915, "Lcom/alipay/sdk/util/e;");
                return;
            }
        }
        f31408c = new e(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 0, 0, CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING);
        f31409d = new e("NETWORK_TYPE_1", 1, 1, "unicom2G");
        f31410e = new e("NETWORK_TYPE_2", 2, 2, "mobile2G");
        f31411f = new e("NETWORK_TYPE_4", 3, 4, "telecom2G");
        f31412g = new e("NETWORK_TYPE_5", 4, 5, "telecom3G");
        f31413h = new e("NETWORK_TYPE_6", 5, 6, "telecom3G");
        f31414i = new e("NETWORK_TYPE_12", 6, 12, "telecom3G");
        f31415j = new e("NETWORK_TYPE_8", 7, 8, "unicom3G");
        f31416k = new e("NETWORK_TYPE_3", 8, 3, "unicom3G");
        l = new e("NETWORK_TYPE_13", 9, 13, "LTE");
        m = new e("NETWORK_TYPE_11", 10, 11, "IDEN");
        n = new e("NETWORK_TYPE_9", 11, 9, "HSUPA");
        o = new e("NETWORK_TYPE_10", 12, 10, "HSPA");
        p = new e("NETWORK_TYPE_15", 13, 15, "HSPAP");
        q = new e("NETWORK_TYPE_20", 14, 20, "5G");
        e eVar = new e(PolyActivity.NONE_PANEL_TYPE, 15, -1, "none");
        r = eVar;
        s = new e[]{f31408c, f31409d, f31410e, f31411f, f31412g, f31413h, f31414i, f31415j, f31416k, l, m, n, o, p, q, eVar};
    }

    public e(String str, int i2, int i3, String str2) {
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
        this.a = i3;
        this.f31417b = str2;
    }

    public static e valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (e) Enum.valueOf(e.class, str) : (e) invokeL.objValue;
    }

    public static e[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (e[]) s.clone() : (e[]) invokeV.objValue;
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31417b : (String) invokeV.objValue;
    }

    public static e a(int i2) {
        InterceptResult invokeI;
        e[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            for (e eVar : values()) {
                if (eVar.a() == i2) {
                    return eVar;
                }
            }
            return r;
        }
        return (e) invokeI.objValue;
    }
}
