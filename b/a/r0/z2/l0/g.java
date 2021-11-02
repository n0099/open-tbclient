package b.a.r0.z2.l0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.l3.j0.p;
import com.baidu.afd.ParseError;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c a(b.a.f.d dVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65536, null, dVar, i2, i3)) == null) {
            if (dVar == null) {
                return null;
            }
            return b(dVar.w(), i2, i3);
        }
        return (c) invokeLII.objValue;
    }

    public static c b(AdvertAppInfo advertAppInfo, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, advertAppInfo, i2, i3)) == null) {
            if (advertAppInfo == null) {
                return null;
            }
            c cVar = new c();
            String str = advertAppInfo.h4;
            if (advertAppInfo.c4) {
                if (i2 == 3) {
                    i2 = 103;
                } else if (i2 == 2) {
                    i2 = 102;
                }
                str = "RETARGET";
            }
            cVar.h(str);
            cVar.i(i2);
            cVar.v(advertAppInfo.e4);
            if ("PB_BANNER".equals(advertAppInfo.h4)) {
                cVar.d(-1);
                cVar.x(-1);
            } else {
                cVar.d(advertAppInfo.position + 1);
                cVar.x(i3);
            }
            return cVar;
        }
        return (c) invokeLII.objValue;
    }

    public static c c(AdvertAppInfo advertAppInfo, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, advertAppInfo, i2, i3)) == null) {
            if (advertAppInfo == null) {
                return null;
            }
            c cVar = new c();
            String str = advertAppInfo.h4;
            if (advertAppInfo.c4) {
                if (i2 == 3) {
                    i2 = 103;
                } else if (i2 == 2) {
                    i2 = 102;
                }
                str = "RETARGET";
            }
            cVar.h(str);
            cVar.i(i2);
            cVar.v(advertAppInfo.e4);
            if ("PB_BANNER".equals(advertAppInfo.h4)) {
                cVar.d(-1);
                cVar.x(-1);
            } else {
                cVar.d(advertAppInfo.position + 1);
                cVar.x(i3);
            }
            return cVar;
        }
        return (c) invokeLII.objValue;
    }

    public static c d(DownloadStaticsData downloadStaticsData, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, downloadStaticsData, i2, i3)) == null) {
            if (downloadStaticsData == null) {
                return null;
            }
            c cVar = new c();
            cVar.t(downloadStaticsData);
            cVar.i(i2);
            cVar.x(i3);
            return cVar;
        }
        return (c) invokeLII.objValue;
    }

    public static c e(p pVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, pVar, i2)) == null) {
            if (pVar == null || pVar.getAdvertAppInfo() == null) {
                return null;
            }
            AdvertAppInfo advertAppInfo = pVar.getAdvertAppInfo();
            String K0 = pVar.K0();
            if (pVar.P0) {
                if (i2 == 3) {
                    i2 = 103;
                } else if (i2 == 2) {
                    i2 = 102;
                }
                K0 = "RETARGET";
            }
            c cVar = new c();
            cVar.v(advertAppInfo.e4);
            if (pVar.H0) {
                cVar.d(-1);
                cVar.x(-1);
            } else {
                cVar.d(pVar.O0 + 1);
                cVar.x(pVar.M0);
            }
            cVar.i(i2);
            cVar.e(pVar.J0);
            cVar.f(pVar.K0);
            cVar.g(pVar.I0);
            cVar.h(K0);
            return cVar;
        }
        return (c) invokeLI.objValue;
    }

    public static c f(@NonNull b.a.f.m.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, aVar)) == null) {
            c cVar = new c();
            cVar.i(aVar.f2770a);
            cVar.d(aVar.f2772c);
            cVar.h(aVar.f2771b);
            cVar.v(aVar.f2773d);
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public static c g(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(AdIconUtil.BAIDU_LOGO_ID, null, i2, i3, i4)) == null) {
            c cVar = new c();
            cVar.i(i2);
            cVar.d(i3);
            cVar.x(i4);
            return cVar;
        }
        return (c) invokeIII.objValue;
    }

    public static c h(AdvertAppInfo advertAppInfo, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65543, null, advertAppInfo, i2, i3, i4)) == null) {
            c b2 = b(advertAppInfo, i2, i3);
            b2.j(i4);
            return b2;
        }
        return (c) invokeLIII.objValue;
    }

    public static c i(AdvertAppInfo advertAppInfo, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65544, null, advertAppInfo, i2, i3, i4)) == null) {
            c c2 = c(advertAppInfo, i2, i3);
            c2.j(i4);
            return c2;
        }
        return (c) invokeLIII.objValue;
    }

    public static c j(String str, int i2, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65545, null, str, i2, str2)) == null) ? k(str, i2, str2, "") : (c) invokeLIL.objValue;
    }

    public static c k(String str, int i2, String str2, String str3) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65546, null, str, i2, str2, str3)) == null) {
            c cVar = new c();
            cVar.i(i2);
            cVar.y(str2);
            cVar.h("HOMEPAGE");
            cVar.v(str);
            cVar.c(str3);
            return cVar;
        }
        return (c) invokeLILL.objValue;
    }

    public static c l(AdvertAppInfo advertAppInfo, int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{advertAppInfo, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            c b2 = b(advertAppInfo, i2, i3);
            b2.j(i4);
            b2.l(Math.round(i6 / 1000.0f));
            b2.n(i5);
            if (i7 != -1 && i2 == 32) {
                b2.r(i7);
            }
            b2.h(advertAppInfo.h4);
            if (i2 == 2) {
                b2.w("video");
            }
            if (i2 == 34) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("duration", i5);
                    jSONObject.put("position", i6);
                    jSONObject.put("start_type", i4);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                b2.z(jSONObject.toString());
            }
            if (i2 == 102) {
                b2.c("replaybtn");
            }
            return b2;
        }
        return (c) invokeCommon.objValue;
    }

    public static c m(b.a.f.d dVar, int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{dVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            c a2 = a(dVar, i2, i3);
            a2.j(i4);
            a2.l(i6);
            a2.n(i5);
            if (i7 != -1 && i2 == 32) {
                a2.r(i7);
            }
            if (dVar != null) {
                a2.h(dVar.w().h4);
            }
            if (i2 == 2) {
                a2.w("video");
            }
            return a2;
        }
        return (c) invokeCommon.objValue;
    }

    public static c n(@NonNull b.a.f.m.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, aVar)) == null) {
            c cVar = new c();
            cVar.i(aVar.f2770a);
            cVar.d(aVar.f2772c);
            cVar.h(aVar.f2771b);
            cVar.v(aVar.f2773d);
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public static c o(b.a.f.d dVar, ParseError parseError) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, dVar, parseError)) == null) {
            if (dVar == null || parseError == null) {
                return null;
            }
            c a2 = a(dVar, 5, dVar.k());
            a2.j(parseError.errorCode);
            return a2;
        }
        return (c) invokeLL.objValue;
    }

    public static c p(@NonNull b.a.f.m.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, aVar)) == null) {
            c cVar = new c();
            cVar.i(aVar.f2770a);
            cVar.d(aVar.f2772c);
            cVar.h(aVar.f2771b);
            cVar.v(aVar.f2773d);
            cVar.j(aVar.k);
            if (!TextUtils.isEmpty(aVar.j)) {
                cVar.u(aVar.j);
            }
            cVar.n(aVar.l);
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public static c q(@NonNull b.a.f.m.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, aVar)) == null) {
            c cVar = new c();
            cVar.i(aVar.f2770a);
            cVar.d(aVar.f2772c);
            cVar.h(aVar.f2771b);
            cVar.v(aVar.f2773d);
            cVar.j(0);
            cVar.l(aVar.f2775f);
            cVar.n(aVar.f2774e);
            cVar.p(aVar.f2776g);
            return cVar;
        }
        return (c) invokeL.objValue;
    }
}
