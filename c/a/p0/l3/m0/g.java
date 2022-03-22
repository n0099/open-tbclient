package c.a.p0.l3.m0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a4.k0.o;
import com.baidu.afd.ParseError;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c a(c.a.e.d dVar, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65536, null, dVar, i, i2)) == null) {
            if (dVar == null) {
                return null;
            }
            return b(dVar.s(), i, i2);
        }
        return (c) invokeLII.objValue;
    }

    public static c b(AdvertAppInfo advertAppInfo, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, advertAppInfo, i, i2)) == null) {
            if (advertAppInfo == null) {
                return null;
            }
            c cVar = new c();
            String str = advertAppInfo.k;
            if (advertAppInfo.f29819f) {
                if (i == 3) {
                    i = 103;
                } else if (i == 2) {
                    i = 102;
                }
                str = "RETARGET";
            }
            cVar.h(str);
            cVar.i(i);
            cVar.v(advertAppInfo.f29821h);
            if ("PB_BANNER".equals(advertAppInfo.k)) {
                cVar.d(-1);
                cVar.x(-1);
            } else {
                cVar.d(advertAppInfo.position + 1);
                cVar.x(i2);
            }
            return cVar;
        }
        return (c) invokeLII.objValue;
    }

    public static c c(AdvertAppInfo advertAppInfo, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, advertAppInfo, i, i2)) == null) {
            if (advertAppInfo == null) {
                return null;
            }
            c cVar = new c();
            String str = advertAppInfo.k;
            if (advertAppInfo.f29819f) {
                if (i == 3) {
                    i = 103;
                } else if (i == 2) {
                    i = 102;
                }
                str = "RETARGET";
            }
            cVar.h(str);
            cVar.i(i);
            cVar.v(advertAppInfo.f29821h);
            if ("PB_BANNER".equals(advertAppInfo.k)) {
                cVar.d(-1);
                cVar.x(-1);
            } else {
                cVar.d(advertAppInfo.position + 1);
                cVar.x(i2);
            }
            return cVar;
        }
        return (c) invokeLII.objValue;
    }

    public static c d(DownloadStaticsData downloadStaticsData, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, downloadStaticsData, i, i2)) == null) {
            if (downloadStaticsData == null) {
                return null;
            }
            c cVar = new c();
            cVar.t(downloadStaticsData);
            cVar.i(i);
            cVar.x(i2);
            return cVar;
        }
        return (c) invokeLII.objValue;
    }

    public static c e(o oVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, oVar, i)) == null) {
            if (oVar == null || oVar.getAdvertAppInfo() == null) {
                return null;
            }
            AdvertAppInfo advertAppInfo = oVar.getAdvertAppInfo();
            String L0 = oVar.L0();
            if (oVar.N0) {
                if (i == 3) {
                    i = 103;
                } else if (i == 2) {
                    i = 102;
                }
                L0 = "RETARGET";
            }
            c cVar = new c();
            cVar.v(advertAppInfo.f29821h);
            if (oVar.F0) {
                cVar.d(-1);
                cVar.x(-1);
            } else {
                cVar.d(oVar.M0 + 1);
                cVar.x(oVar.K0);
            }
            cVar.i(i);
            cVar.e(oVar.H0);
            cVar.f(oVar.I0);
            cVar.g(oVar.G0);
            cVar.h(L0);
            return cVar;
        }
        return (c) invokeLI.objValue;
    }

    public static c f(@NonNull c.a.e.m.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, aVar)) == null) {
            c cVar = new c();
            cVar.i(aVar.a);
            cVar.d(aVar.f2706c);
            cVar.h(aVar.f2705b);
            cVar.v(aVar.f2707d);
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public static c g(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65542, null, i, i2, i3)) == null) {
            c cVar = new c();
            cVar.i(i);
            cVar.d(i2);
            cVar.x(i3);
            return cVar;
        }
        return (c) invokeIII.objValue;
    }

    public static c h(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65543, null, advertAppInfo, i, i2, i3)) == null) {
            c b2 = b(advertAppInfo, i, i2);
            b2.j(i3);
            return b2;
        }
        return (c) invokeLIII.objValue;
    }

    public static c i(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65544, null, advertAppInfo, i, i2, i3)) == null) {
            c c2 = c(advertAppInfo, i, i2);
            c2.j(i3);
            return c2;
        }
        return (c) invokeLIII.objValue;
    }

    public static c j(String str, int i, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65545, null, str, i, str2)) == null) ? k(str, i, str2, "") : (c) invokeLIL.objValue;
    }

    public static c k(String str, int i, String str2, String str3) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65546, null, str, i, str2, str3)) == null) {
            c cVar = new c();
            cVar.i(i);
            cVar.y(str2);
            cVar.h("HOMEPAGE");
            cVar.v(str);
            cVar.c(str3);
            return cVar;
        }
        return (c) invokeLILL.objValue;
    }

    public static c l(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{advertAppInfo, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            c b2 = b(advertAppInfo, i, i2);
            b2.j(i3);
            b2.l(Math.round(i5 / 1000.0f));
            b2.n(i4);
            if (i6 != -1 && i == 32) {
                b2.r(i6);
            }
            b2.h(advertAppInfo.k);
            if (i == 2) {
                b2.w("video");
            }
            if (i == 34) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("duration", i4);
                    jSONObject.put("position", i5);
                    jSONObject.put("start_type", i3);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                b2.z(jSONObject.toString());
            }
            if (i == 102) {
                b2.c("replaybtn");
            }
            return b2;
        }
        return (c) invokeCommon.objValue;
    }

    public static c m(c.a.e.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{dVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            c a = a(dVar, i, i2);
            a.j(i3);
            a.l(i5);
            a.n(i4);
            if (i6 != -1 && i == 32) {
                a.r(i6);
            }
            if (dVar != null) {
                a.h(dVar.s().k);
            }
            if (i == 2) {
                a.w("video");
            }
            return a;
        }
        return (c) invokeCommon.objValue;
    }

    public static c n(@NonNull c.a.e.m.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, aVar)) == null) {
            c cVar = new c();
            cVar.i(aVar.a);
            cVar.d(aVar.f2706c);
            cVar.h(aVar.f2705b);
            cVar.v(aVar.f2707d);
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public static c o(c.a.e.d dVar, ParseError parseError) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, dVar, parseError)) == null) {
            if (dVar == null || parseError == null) {
                return null;
            }
            c a = a(dVar, 5, dVar.i());
            a.j(parseError.errorCode);
            return a;
        }
        return (c) invokeLL.objValue;
    }

    public static c p(@NonNull c.a.e.m.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, aVar)) == null) {
            c cVar = new c();
            cVar.i(aVar.a);
            cVar.d(aVar.f2706c);
            cVar.h(aVar.f2705b);
            cVar.v(aVar.f2707d);
            cVar.j(aVar.k);
            if (!TextUtils.isEmpty(aVar.j)) {
                cVar.u(aVar.j);
            }
            cVar.n(aVar.l);
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public static c q(@NonNull c.a.e.m.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, aVar)) == null) {
            c cVar = new c();
            cVar.i(aVar.a);
            cVar.d(aVar.f2706c);
            cVar.h(aVar.f2705b);
            cVar.v(aVar.f2707d);
            cVar.j(0);
            cVar.l(aVar.f2709f);
            cVar.n(aVar.f2708e);
            cVar.p(aVar.f2710g);
            return cVar;
        }
        return (c) invokeL.objValue;
    }
}
