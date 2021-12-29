package c.a.t0.j3;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.c2;
import c.a.s0.s.q.o0;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.GoodsInfo;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.t0.j3.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1127a implements Comparator<o0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1127a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(o0 o0Var, o0 o0Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, o0Var, o0Var2)) == null) {
                if (o0Var.c() && o0Var2.c()) {
                    return o0Var.f() - o0Var2.f();
                }
                if (o0Var.c() || o0Var2.c()) {
                    return o0Var.c() ? -1 : 1;
                }
                return (o0Var.m() == null ? -1 : a.g(o0Var.m())) - (o0Var2.m() != null ? a.g(o0Var2.m()) : -1);
            }
            return invokeLL.intValue;
        }
    }

    public static Set<c.a.d.n.e.n> a(List<c.a.d.n.e.n> list, int i2, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo m;
        AdvertAppInfo m2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i2, str)) == null) {
            HashSet hashSet = new HashSet();
            if (c.a.t0.x1.o.k.a.e(list)) {
                return hashSet;
            }
            Set<c.a.d.n.e.n> a = c.a.t0.j3.l0.a.a(str);
            if (a == null) {
                a = new HashSet();
            }
            for (c.a.d.n.e.n nVar : list) {
                if (nVar != null) {
                    for (c.a.d.n.e.n nVar2 : a) {
                        if ((nVar instanceof o0) && (m2 = ((o0) nVar).m()) != null && nVar2.hashCode() == m2.hashCode()) {
                            m2.o4 = ((AdvertAppInfo) nVar2).o4;
                        }
                    }
                    if ((nVar instanceof o0) && (m = ((o0) nVar).m()) != null && m.o4 == null) {
                        c.a.s0.s.q.e eVar = new c.a.s0.s.q.e();
                        m.o4 = eVar;
                        eVar.a = str;
                        eVar.f13665b = i2;
                        eVar.f13671h = m.m4;
                        eVar.f13672i = false;
                        hashSet.add(m);
                    }
                }
            }
            a.addAll(hashSet);
            c.a.t0.j3.l0.a.b(str, a);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static int b(@NonNull List<c.a.d.n.e.n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i2 = 0;
            if (c.a.t0.x1.o.k.a.e(list)) {
                return 0;
            }
            int i3 = -1;
            for (int k2 = c.a.t0.x1.o.k.a.k(list) - 1; k2 >= 0 && !(c.a.t0.x1.o.k.a.d(list, k2) instanceof o0); k2--) {
                if (c.a.t0.x1.o.k.a.d(list, k2) instanceof c2) {
                    int i4 = ((c2) c.a.t0.x1.o.k.a.d(list, k2)).position;
                    if (i4 != i3) {
                        i2++;
                        i3 = i4;
                    }
                } else {
                    i2++;
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static void c(List<c.a.d.n.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, list) == null) || c.a.t0.x1.o.k.a.e(list)) {
            return;
        }
        Iterator<c.a.d.n.e.n> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof o0) {
                it.remove();
            }
        }
    }

    public static void d(String str, List list) {
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, list) == null) || TextUtils.isEmpty(str) || c.a.t0.x1.o.k.a.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean z = next instanceof o0;
            if (z || (next instanceof App)) {
                if (next instanceof App) {
                    str2 = c.a((App) next);
                } else {
                    if (z) {
                        o0 o0Var = (o0) next;
                        if (o0Var.m() != null) {
                            str2 = o0Var.m().f4;
                        }
                    }
                    str2 = "";
                }
                if (TextUtils.equals(str, str2)) {
                    it.remove();
                }
            }
        }
    }

    public static String e(List<c.a.d.n.e.n> list, boolean z) {
        InterceptResult invokeLZ;
        o0 o0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !c.a.t0.x1.o.k.a.e(list)) {
                int i2 = 0;
                for (int k2 = c.a.t0.x1.o.k.a.k(list) - 1; k2 >= 0 && i2 < 6; k2--) {
                    if ((c.a.t0.x1.o.k.a.d(list, k2) instanceof o0) && (o0Var = (o0) c.a.t0.x1.o.k.a.d(list, k2)) != null && !n(o0Var.m())) {
                        sb.append(o0Var.f() + 1);
                        sb.append(",");
                        i2++;
                    }
                }
                if (sb.length() <= 1) {
                    return sb.toString();
                }
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public static String f(@NonNull AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, advertAppInfo)) == null) {
            return "#Nad=" + advertAppInfo.m4;
        }
        return (String) invokeL.objValue;
    }

    public static int g(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, advertAppInfo)) == null) {
            if (advertAppInfo == null) {
                return 0;
            }
            if (TextUtils.isEmpty(advertAppInfo.l4)) {
                return -1;
            }
            return c.a.d.f.m.b.e(advertAppInfo.l4, -1);
        }
        return invokeL.intValue;
    }

    public static List<o0> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (c.a.t0.x1.o.k.a.e(list)) {
                return arrayList;
            }
            String str2 = "src ad list size " + list.size();
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.a5(app);
                advertAppInfo.p4 = str;
                int m = m(advertAppInfo);
                if (m != 0) {
                    r(advertAppInfo, m);
                } else {
                    arrayList.add(advertAppInfo);
                }
            }
            String str3 = "src ad jiaoyan size " + arrayList.size();
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static int i(@NonNull App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, app)) == null) {
            List<GoodsInfo> list = app.goods_info;
            if (list == null) {
                return -1001;
            }
            for (GoodsInfo goodsInfo : list) {
                if (goodsInfo != null) {
                    return goodsInfo.goods_style.intValue();
                }
            }
            return -1001;
        }
        return invokeL.intValue;
    }

    public static boolean j(App app, BannerList bannerList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, app, bannerList)) == null) {
            if (app != null && bannerList != null) {
                if (p(app, bannerList.pb_banner_ad)) {
                    return true;
                }
                List<App> list = bannerList.video_recommend_ad;
                if (!c.a.t0.x1.o.k.a.e(list)) {
                    for (App app2 : list) {
                        if (p(app, app2)) {
                            return true;
                        }
                    }
                }
                List<App> list2 = bannerList.app;
                if (!c.a.t0.x1.o.k.a.e(list2)) {
                    for (App app3 : list2) {
                        if (p(app, app3)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static List<o0> k(List<o0> list, List<c.a.d.n.e.n> list2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65546, null, list, list2, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (c.a.t0.x1.o.k.a.e(list)) {
                return arrayList;
            }
            t(list);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                o0 o0Var = (o0) c.a.t0.x1.o.k.a.d(list, i4);
                if (o0Var != null && o0Var.m() != null) {
                    int k2 = c.a.t0.x1.o.k.a.k(list2);
                    int g2 = g(o0Var.m()) - 1;
                    if (g2 < 0) {
                        s(o0Var.m());
                    } else {
                        int f2 = o0Var.c() ? o0Var.f() : g2 + i2;
                        if (f2 > k2) {
                            s(o0Var.m());
                        } else {
                            o0Var.setPosition(f2);
                            c.a.t0.x1.o.k.a.b(list2, o0Var, f2);
                            arrayList.add(o0Var);
                        }
                    }
                }
            }
            while (i2 < c.a.t0.x1.o.k.a.k(list2)) {
                c.a.d.n.e.n nVar = list2.get(i2);
                if (nVar instanceof o0) {
                    i3++;
                } else if (nVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) nVar).position += i3;
                }
                i2++;
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    public static boolean l(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("#Nad=");
        }
        return invokeL.booleanValue;
    }

    public static int m(@Nullable AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, advertAppInfo)) == null) {
            int Y4 = advertAppInfo.Y4();
            if (g(advertAppInfo) < 0) {
                return 23;
            }
            return Y4;
        }
        return invokeL.intValue;
    }

    public static boolean n(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, advertAppInfo)) == null) ? advertAppInfo.d() : invokeL.booleanValue;
    }

    public static boolean o(@NonNull App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, app)) == null) {
            List<GoodsInfo> list = app.goods_info;
            if (list == null) {
                return false;
            }
            for (GoodsInfo goodsInfo : list) {
                if (goodsInfo != null && goodsInfo.goods_style.intValue() == 1001) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean p(App app, App app2) {
        InterceptResult invokeLL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, app, app2)) == null) {
            if (app != null && app2 != null && !c.a.t0.x1.o.k.a.e(app.goods_info) && !c.a.t0.x1.o.k.a.e(app2.goods_info)) {
                Iterator<GoodsInfo> it = app.goods_info.iterator();
                while (true) {
                    str = null;
                    if (!it.hasNext()) {
                        str2 = null;
                        break;
                    }
                    GoodsInfo next = it.next();
                    if (next != null) {
                        str2 = next.lego_card;
                        break;
                    }
                }
                Iterator<GoodsInfo> it2 = app2.goods_info.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    GoodsInfo next2 = it2.next();
                    if (next2 != null) {
                        str = next2.lego_card;
                        break;
                    }
                }
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    try {
                        if (TextUtils.equals(new JSONObject(str2).optString("download_key"), new JSONObject(str).optString("download_key"))) {
                            return true;
                        }
                    } catch (JSONException unused) {
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean q(@NonNull App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, app)) == null) {
            List<GoodsInfo> list = app.goods_info;
            if (list == null) {
                return false;
            }
            for (GoodsInfo goodsInfo : list) {
                if (goodsInfo != null && !TextUtils.isEmpty(goodsInfo.lego_card)) {
                    try {
                        JSONObject optJSONObject = new JSONObject(goodsInfo.lego_card).optJSONObject("vertical_video_style");
                        if (optJSONObject != null && !TextUtils.isEmpty(optJSONObject.optString("bottom_picture", ""))) {
                            return true;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void r(AdvertAppInfo advertAppInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65553, null, advertAppInfo, i2) == null) {
            c.a.t0.j3.l0.e.b().d(c.a.t0.j3.l0.g.i(advertAppInfo, 5, 1, i2));
        }
    }

    public static void s(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, advertAppInfo) == null) {
            r(advertAppInfo, 23);
        }
    }

    public static void t(List<o0> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, list) == null) {
            Collections.sort(list, new C1127a());
        }
    }

    public static void u(List<c.a.d.n.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, list) == null) {
            for (int i2 = 0; i2 < c.a.t0.x1.o.k.a.k(list); i2++) {
                if (c.a.t0.x1.o.k.a.d(list, i2) instanceof o0) {
                    ((o0) c.a.t0.x1.o.k.a.d(list, i2)).setPosition(i2);
                }
            }
        }
    }
}
