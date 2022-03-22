package c.a.p0.l3;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.r.a2;
import c.a.o0.r.r.n0;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.l3.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1204a implements Comparator<n0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1204a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(n0 n0Var, n0 n0Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, n0Var, n0Var2)) == null) {
                if (n0Var.d() && n0Var2.d()) {
                    return n0Var.h() - n0Var2.h();
                }
                if (n0Var.d() || n0Var2.d()) {
                    return n0Var.d() ? -1 : 1;
                }
                return (n0Var.o() == null ? -1 : a.g(n0Var.o())) - (n0Var2.o() != null ? a.g(n0Var2.o()) : -1);
            }
            return invokeLL.intValue;
        }
    }

    public static Set<c.a.d.o.e.n> a(List<c.a.d.o.e.n> list, int i, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo o;
        AdvertAppInfo o2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (c.a.p0.b2.o.k.a.e(list)) {
                return hashSet;
            }
            Set<c.a.d.o.e.n> a = c.a.p0.l3.m0.a.a(str);
            if (a == null) {
                a = new HashSet();
            }
            for (c.a.d.o.e.n nVar : list) {
                if (nVar != null) {
                    for (c.a.d.o.e.n nVar2 : a) {
                        if ((nVar instanceof n0) && (o2 = ((n0) nVar).o()) != null && nVar2.hashCode() == o2.hashCode()) {
                            o2.j = ((AdvertAppInfo) nVar2).j;
                        }
                    }
                    if ((nVar instanceof n0) && (o = ((n0) nVar).o()) != null && o.j == null) {
                        c.a.o0.r.r.e eVar = new c.a.o0.r.r.e();
                        o.j = eVar;
                        eVar.a = str;
                        eVar.f10837b = i;
                        eVar.f10843h = o.f29821h;
                        eVar.i = false;
                        hashSet.add(o);
                    }
                }
            }
            a.addAll(hashSet);
            c.a.p0.l3.m0.a.b(str, a);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static int b(@NonNull List<c.a.d.o.e.n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i = 0;
            if (c.a.p0.b2.o.k.a.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int k = c.a.p0.b2.o.k.a.k(list) - 1; k >= 0 && !(c.a.p0.b2.o.k.a.d(list, k) instanceof n0); k--) {
                if (c.a.p0.b2.o.k.a.d(list, k) instanceof a2) {
                    int i3 = ((a2) c.a.p0.b2.o.k.a.d(list, k)).position;
                    if (i3 != i2) {
                        i++;
                        i2 = i3;
                    }
                } else {
                    i++;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static void c(List<c.a.d.o.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, list) == null) || c.a.p0.b2.o.k.a.e(list)) {
            return;
        }
        Iterator<c.a.d.o.e.n> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof n0) {
                it.remove();
            }
        }
    }

    public static void d(String str, List list) {
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, list) == null) || TextUtils.isEmpty(str) || c.a.p0.b2.o.k.a.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean z = next instanceof n0;
            if (z || (next instanceof App)) {
                if (next instanceof App) {
                    str2 = c.a((App) next);
                } else {
                    if (z) {
                        n0 n0Var = (n0) next;
                        if (n0Var.o() != null) {
                            str2 = n0Var.o().a;
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

    public static String e(List<c.a.d.o.e.n> list, boolean z) {
        InterceptResult invokeLZ;
        n0 n0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !c.a.p0.b2.o.k.a.e(list)) {
                int i = 0;
                for (int k = c.a.p0.b2.o.k.a.k(list) - 1; k >= 0 && i < 6; k--) {
                    if ((c.a.p0.b2.o.k.a.d(list, k) instanceof n0) && (n0Var = (n0) c.a.p0.b2.o.k.a.d(list, k)) != null && !n(n0Var.o())) {
                        sb.append(n0Var.h() + 1);
                        sb.append(",");
                        i++;
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
            return "#Nad=" + advertAppInfo.f29821h;
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
            if (TextUtils.isEmpty(advertAppInfo.f29820g)) {
                return -1;
            }
            return c.a.d.f.m.b.e(advertAppInfo.f29820g, -1);
        }
        return invokeL.intValue;
    }

    public static List<n0> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (c.a.p0.b2.o.k.a.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.s(app);
                advertAppInfo.k = str;
                int m = m(advertAppInfo);
                if (m != 0) {
                    r(advertAppInfo, m);
                } else {
                    arrayList.add(advertAppInfo);
                }
            }
            Log.e("frs", "src ad jiaoyan size " + arrayList.size());
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
                if (!c.a.p0.b2.o.k.a.e(list)) {
                    for (App app2 : list) {
                        if (p(app, app2)) {
                            return true;
                        }
                    }
                }
                List<App> list2 = bannerList.app;
                if (!c.a.p0.b2.o.k.a.e(list2)) {
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

    public static List<n0> k(List<n0> list, List<c.a.d.o.e.n> list2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65546, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (c.a.p0.b2.o.k.a.e(list)) {
                return arrayList;
            }
            t(list);
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                n0 n0Var = (n0) c.a.p0.b2.o.k.a.d(list, i3);
                if (n0Var != null && n0Var.o() != null) {
                    int k = c.a.p0.b2.o.k.a.k(list2);
                    int g2 = g(n0Var.o()) - 1;
                    if (g2 < 0) {
                        s(n0Var.o());
                    } else {
                        int h2 = n0Var.d() ? n0Var.h() : g2 + i;
                        if (h2 > k) {
                            s(n0Var.o());
                        } else {
                            n0Var.setPosition(h2);
                            c.a.p0.b2.o.k.a.b(list2, n0Var, h2);
                            arrayList.add(n0Var);
                        }
                    }
                }
            }
            while (i < c.a.p0.b2.o.k.a.k(list2)) {
                c.a.d.o.e.n nVar = list2.get(i);
                if (nVar instanceof n0) {
                    i2++;
                } else if (nVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) nVar).position += i2;
                }
                i++;
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
            int q = advertAppInfo.q();
            if (g(advertAppInfo) < 0) {
                return 23;
            }
            return q;
        }
        return invokeL.intValue;
    }

    public static boolean n(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, advertAppInfo)) == null) ? advertAppInfo.b() : invokeL.booleanValue;
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
            if (app != null && app2 != null && !c.a.p0.b2.o.k.a.e(app.goods_info) && !c.a.p0.b2.o.k.a.e(app2.goods_info)) {
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

    public static void r(AdvertAppInfo advertAppInfo, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65553, null, advertAppInfo, i) == null) {
            c.a.p0.l3.m0.e.b().d(c.a.p0.l3.m0.g.i(advertAppInfo, 5, 1, i));
        }
    }

    public static void s(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, advertAppInfo) == null) {
            r(advertAppInfo, 23);
        }
    }

    public static void t(List<n0> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, list) == null) {
            Collections.sort(list, new C1204a());
        }
    }

    public static void u(List<c.a.d.o.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, list) == null) {
            for (int i = 0; i < c.a.p0.b2.o.k.a.k(list); i++) {
                if (c.a.p0.b2.o.k.a.d(list, i) instanceof n0) {
                    ((n0) c.a.p0.b2.o.k.a.d(list, i)).setPosition(i);
                }
            }
        }
    }
}
