package com.baidu.mapsdkplatform.comapi.map;

import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public static final i a;
    public static final i b;
    public static final i c;
    public static final i d;
    public static final i e;
    public static final i f;
    public static final i g;
    public static final i h;
    public static final i i;
    public static final i j;
    public static final i k;
    public static final i l;
    public static final i m;
    public static final i n;
    public static final /* synthetic */ i[] o;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(724782251, "Lcom/baidu/mapsdkplatform/comapi/map/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(724782251, "Lcom/baidu/mapsdkplatform/comapi/map/i;");
                return;
            }
        }
        a = new i("logo", 0);
        b = new i(MapController.POPUP_LAYER_TAG, 1);
        c = new i("marker", 2);
        d = new i("ground", 3);
        e = new i("text", 4);
        f = new i("arc", 5);
        g = new i("dot", 6);
        h = new i(Config.TRACE_CIRCLE, 7);
        i = new i("polyline", 8);
        j = new i("polygon", 9);
        k = new i("multiPoint", 10);
        l = new i("prism", 11);
        m = new i("BM3DModel", 12);
        i iVar = new i("gradientLine", 13);
        n = iVar;
        o = new i[]{a, b, c, d, e, f, g, h, i, j, k, l, m, iVar};
    }

    public i(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static i valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (i) Enum.valueOf(i.class, str);
        }
        return (i) invokeL.objValue;
    }

    public static i[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (i[]) o.clone();
        }
        return (i[]) invokeV.objValue;
    }
}
