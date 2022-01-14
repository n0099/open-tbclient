package c.a.t0.o1.h.k;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.e2;
import c.a.t0.g0.f0.j;
import c.a.t0.g0.f0.k;
import c.a.t0.g0.f0.l;
import c.a.t0.g0.f0.m;
import c.a.t0.g0.f0.q;
import c.a.t0.j3.y;
import c.a.t0.w3.b0;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.App;
import tbclient.BannerList;
import tbclient.DiscoverHotForum;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.CardGod;
import tbclient.Personalized.CardTopic;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.Resource;
import tbclient.Personalized.TagStruct;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void A(c.a.t0.g0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, bVar) == null) {
            bVar.z = true;
            bVar.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void B(c.a.t0.g0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, bVar) == null) {
            if (bVar instanceof k) {
                ((k) bVar).B = true;
            } else if (bVar instanceof l) {
                ((l) bVar).B = true;
            } else if (bVar instanceof j) {
                ((j) bVar).B = true;
            }
            bVar.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void C(c.a.t0.g0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bVar) == null) {
            bVar.E = true;
            bVar.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void D(c.a.t0.g0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bVar) == null) {
            if (bVar instanceof k) {
                ((k) bVar).A = true;
            } else if (bVar instanceof l) {
                ((l) bVar).A = true;
            } else if (bVar instanceof j) {
                ((j) bVar).A = true;
            }
            bVar.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void E(BannerList.Builder builder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, builder) == null) || builder == null || ListUtils.isEmpty(builder.app)) {
            return;
        }
        for (int i2 = 0; i2 < builder.app.size(); i2++) {
            App app = builder.app.get(i2);
            if (app != null) {
                App.Builder builder2 = new App.Builder(app);
                builder2.pos = Integer.valueOf(c.a.t0.j3.c.b(app));
                App build = builder2.build(false);
                builder.app.remove(i2);
                builder.app.add(i2, build);
            }
        }
    }

    public static void a(List<App> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, list) == null) || list == null || list.size() <= 1) {
            return;
        }
        int size = list.size() - 1;
        while (true) {
            int i2 = size - 1;
            if (i2 <= 0) {
                return;
            }
            int f2 = f(list.get(size));
            int f3 = f(list.get(i2));
            if (f2 <= 0 || f2 - f3 < 3) {
                ListUtils.remove(list, size);
            }
            size--;
        }
    }

    public static void b(int i2, List<App> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65542, null, i2, list) == null) || list == null) {
            return;
        }
        int i3 = 0;
        Iterator<App> it = list.iterator();
        while (it.hasNext()) {
            App next = it.next();
            if (next != null) {
                int b2 = c.a.t0.j3.c.b(next);
                if (b2 <= 0) {
                    it.remove();
                    c.a.t0.j3.l0.d.i(l(next), 1, 23);
                } else {
                    int i4 = i2 + i3 + 1;
                    if (b2 <= i4) {
                        i3++;
                    } else {
                        it.remove();
                        c.a.t0.j3.l0.d.j(l(next), 1, 2, b2, i4);
                    }
                }
            } else {
                it.remove();
            }
        }
    }

    public static void c(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, builder) == null) || builder == null) {
            return;
        }
        if (builder.thread_list == null) {
            builder.thread_list = new LinkedList();
        }
        if (builder.card_forum == null) {
            builder.card_forum = new LinkedList();
        }
        if (builder.card_topic == null) {
            builder.card_topic = new LinkedList();
        }
        if (builder.resource_list == null) {
            builder.resource_list = new LinkedList();
        }
        if (builder.thread_personalized == null) {
            builder.thread_personalized = new LinkedList();
        }
        if (builder.interestion == null) {
            builder.interestion = new LinkedList();
        }
        if (builder.card_god == null) {
            builder.card_god = new LinkedList();
        }
    }

    public static List<q> d(DataRes.Builder builder) {
        InterceptResult invokeL;
        List<App> list;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, builder)) == null) {
            c.a.t0.o1.h.j.d dVar = null;
            if (builder == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            List<Resource> list2 = builder.resource_list;
            if (list2 != null) {
                for (Resource resource : list2) {
                    c.a.t0.o1.h.j.c cVar = new c.a.t0.o1.h.j.c();
                    cVar.g(resource);
                    linkedList.add(cVar);
                }
            }
            List<CardForum> list3 = builder.card_forum;
            if (list3 != null) {
                for (CardForum cardForum : list3) {
                    if (cardForum != null && c.a.t0.o1.h.j.b.q(cardForum.card_type.intValue()) && dVar == null) {
                        dVar = new c.a.t0.o1.h.j.d();
                        dVar.w(cardForum);
                        if (dVar.t()) {
                            linkedList.add(dVar);
                        }
                    }
                }
            }
            List<AdvertAppInfo> h2 = y.q().h();
            if (h2 != null) {
                h2.clear();
            }
            BannerList bannerList = builder.banner_list;
            if (bannerList != null && (list = bannerList.app) != null) {
                for (App app : list) {
                    c.a.t0.o1.h.j.a aVar = new c.a.t0.o1.h.j.a();
                    aVar.i(app);
                    if (h2 != null && (advertAppInfo = aVar.f17784e) != null) {
                        advertAppInfo.a2 = true;
                        h2.add(advertAppInfo);
                    }
                    AdvertAppInfo g2 = aVar.g();
                    if (g2 == null) {
                        c.a.t0.j3.l0.d.i(aVar.g(), 1, 100);
                    } else {
                        int Y4 = g2.Y4();
                        if (Y4 != 0) {
                            c.a.t0.j3.l0.d.i(aVar.g(), 1, Y4);
                            if (Y4 != 28 && Y4 != 31) {
                                g2.h4 = -1001;
                            }
                        }
                        if (aVar.getPosition() <= 0) {
                            c.a.t0.j3.l0.d.i(aVar.g(), 1, 23);
                            g2.h4 = -1001;
                        }
                        if (g2.V4()) {
                            try {
                                if (TextUtils.isEmpty(g2.x4)) {
                                    c.a.t0.j3.l0.d.i(aVar.g(), 1, 26);
                                } else if (b0.b(TbadkCoreApplication.getInst().getContext(), g2.x4) && c.a.t0.a.h().F()) {
                                    c.a.t0.j3.l0.d.i(aVar.g(), 1, 3);
                                }
                            } catch (Exception unused) {
                                c.a.t0.j3.l0.d.i(aVar.g(), 1, 100);
                            }
                        }
                        linkedList.add(aVar);
                    }
                }
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    public static c.a.t0.g0.f0.b e(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, e2Var)) == null) {
            if (e2Var == null) {
                return null;
            }
            if (e2Var.A1) {
                k kVar = new k();
                kVar.f17778e = e2Var;
                return kVar;
            } else if (m.Y(e2Var)) {
                return new m(e2Var);
            } else {
                if (j.Y(e2Var)) {
                    return new j(e2Var);
                }
                if (!k.Y(e2Var) && !k.Z(e2Var)) {
                    if (l.T(e2Var)) {
                        return new l(e2Var);
                    }
                    return null;
                }
                k kVar2 = new k();
                e2Var.h2();
                e2Var.z2();
                if (!e2Var.h2() && !e2Var.z2()) {
                    e2Var.c2();
                }
                kVar2.f17778e = e2Var;
                return kVar2;
            }
        }
        return (c.a.t0.g0.f0.b) invokeL.objValue;
    }

    public static int f(App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, app)) == null) {
            if (app == null) {
                return -1;
            }
            return c.a.t0.j3.c.b(app);
        }
        return invokeL.intValue;
    }

    public static k g(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, e2Var)) == null) {
            k kVar = new k();
            kVar.f17778e = e2Var;
            e2Var.h2();
            if (!e2Var.h2()) {
                e2Var.c2();
            }
            return kVar;
        }
        return (k) invokeL.objValue;
    }

    public static void h(BannerList.Builder builder, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65548, null, builder, i2) == null) || builder == null || builder.app == null) {
            return;
        }
        for (int i3 = 0; i3 < builder.app.size(); i3++) {
            App app = builder.app.get(i3);
            if (app != null) {
                App.Builder builder2 = new App.Builder(app);
                c.a.t0.j3.c.c(builder2, i2);
                App build = builder2.build(false);
                builder.app.remove(i3);
                builder.app.add(i3, build);
            }
        }
    }

    public static BannerList i(boolean z, BannerList bannerList, BannerList bannerList2, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Boolean.valueOf(z), bannerList, bannerList2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if (i5 <= 0) {
                return bannerList;
            }
            BannerList.Builder builder = new BannerList.Builder(bannerList);
            if (bannerList2 != null && bannerList2.app != null) {
                if (builder.app == null) {
                    builder.app = new LinkedList();
                }
                b(i2, builder.app);
                int i6 = i3 + i4;
                BannerList.Builder builder2 = new BannerList.Builder(bannerList2);
                if (builder2.app == null) {
                    builder2.app = new LinkedList();
                }
                if (z) {
                    E(builder2);
                }
                List<App> list = builder2.app;
                if (list != null) {
                    Iterator<App> it = list.iterator();
                    int i7 = 0;
                    while (it.hasNext()) {
                        App next = it.next();
                        if (next != null) {
                            int b2 = c.a.t0.j3.c.b(next);
                            if (b2 <= 0) {
                                it.remove();
                                c.a.t0.j3.l0.d.i(l(next), 1, 23);
                            } else {
                                int i8 = i5 + i7 + 1;
                                if (b2 <= i8) {
                                    i7++;
                                } else {
                                    it.remove();
                                    c.a.t0.j3.l0.d.j(l(next), 1, 2, b2, i8);
                                }
                            }
                        } else {
                            it.remove();
                        }
                    }
                }
                h(builder2, i6);
                List<App> list2 = builder2.app;
                if (list2 != null) {
                    builder.app.addAll(list2);
                }
                return builder.build(false);
            }
            return builder.build(false);
        }
        return (BannerList) invokeCommon.objValue;
    }

    public static BannerList j(boolean z, BannerList bannerList, BannerList bannerList2, int i2) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Boolean.valueOf(z), bannerList, bannerList2, Integer.valueOf(i2)})) == null) {
            if (i2 <= 0) {
                return bannerList;
            }
            BannerList.Builder builder = new BannerList.Builder(bannerList);
            if (builder.app == null) {
                builder.app = new LinkedList();
            }
            BannerList.Builder builder2 = new BannerList.Builder(bannerList2);
            if (z) {
                E(builder2);
            }
            List<App> list = builder2.app;
            if (list != null) {
                Iterator<App> it = list.iterator();
                i3 = 0;
                while (it.hasNext()) {
                    App next = it.next();
                    if (next != null) {
                        int b2 = c.a.t0.j3.c.b(next);
                        if (b2 <= 0) {
                            it.remove();
                            c.a.t0.j3.l0.d.i(l(next), 1, 23);
                        } else {
                            int i4 = i2 + i3 + 1;
                            if (b2 <= i4) {
                                i3++;
                            } else {
                                it.remove();
                                c.a.t0.j3.l0.d.j(l(next), 1, 2, b2, i4);
                            }
                        }
                    } else {
                        it.remove();
                    }
                }
            } else {
                i3 = 0;
            }
            int i5 = i3 + i2;
            if (i5 <= 0) {
                return builder.build(false);
            }
            h(builder, i5);
            List<App> list2 = builder2.app;
            if (list2 != null) {
                builder.app.addAll(0, list2);
            }
            return builder.build(false);
        }
        return (BannerList) invokeCommon.objValue;
    }

    public static void k(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i2, int i3, int i4, int i5) {
        List<TagStruct> list;
        List<Resource> list2;
        List<CardTopic> list3;
        List<CardForum> list4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || builder2 == null || builder == null) {
            return;
        }
        List<CardForum> list5 = builder2.card_forum;
        if (list5 != null && (list4 = builder.card_forum) != null) {
            list4.addAll(list5);
        }
        List<CardTopic> list6 = builder2.card_topic;
        if (list6 != null && (list3 = builder.card_topic) != null) {
            list3.addAll(list6);
        }
        List<Resource> list7 = builder2.resource_list;
        if (list7 != null && (list2 = builder.resource_list) != null) {
            list2.addAll(list7);
        }
        if (i2 == 0) {
            builder.banner_list = j(z, builder.banner_list, builder2.banner_list, i3);
        } else {
            List<ThreadInfo> list8 = builder.thread_list;
            builder.banner_list = i(z, builder.banner_list, builder2.banner_list, list8 != null ? list8.size() : 0, i4, i5, i3);
        }
        if (builder.age_sex == null) {
            builder.age_sex = builder2.age_sex;
            if (builder2.age_sex != null) {
                c.a.s0.s.h0.b.k().u("has_requested_new_user_guide", true);
            }
        }
        if (builder2.interestion != null && builder != null && (list = builder.interestion) != null && list.size() == 0) {
            builder.interestion.addAll(builder2.interestion);
        }
        List<CardGod> list9 = builder2.card_god;
        if (list9 != null) {
            builder.card_god.addAll(list9);
        }
        DiscoverHotForum discoverHotForum = builder2.hot_recomforum;
        if (discoverHotForum != null) {
            builder.hot_recomforum = discoverHotForum;
        }
    }

    public static AdvertAppInfo l(App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, app)) == null) {
            c.a.t0.o1.h.j.a aVar = new c.a.t0.o1.h.j.a();
            aVar.i(app);
            return aVar.g();
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    public static void m(DataRes.Builder builder) {
        BannerList.Builder builder2;
        List<App> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65553, null, builder) == null) || builder == null) {
            return;
        }
        int count = ListUtils.getCount(builder.thread_list);
        BannerList bannerList = builder.banner_list;
        if (bannerList == null || bannerList.app == null || (list = (builder2 = new BannerList.Builder(bannerList)).app) == null) {
            return;
        }
        a(list);
        for (int size = builder2.app.size() - 1; size >= 0; size--) {
            App app = builder2.app.get(size);
            c.a.t0.o1.h.j.a aVar = new c.a.t0.o1.h.j.a();
            aVar.i(app);
            int b2 = app != null ? c.a.t0.j3.c.b(app) : -1;
            if (b2 < 0) {
                c.a.t0.j3.l0.d.i(aVar.g(), 1, 33);
                builder2.app.remove(size);
            } else {
                int i2 = count + size;
                if (b2 > i2) {
                    c.a.t0.j3.l0.d.j(aVar.m(), 1, 2, b2, i2);
                    builder2.app.remove(size);
                } else {
                    AdvertAppInfo g2 = aVar.g();
                    if (g2 == null) {
                        c.a.t0.j3.l0.d.i(aVar.g(), 1, 100);
                        builder2.app.remove(size);
                    } else {
                        int Y4 = g2.Y4();
                        if (Y4 != 0) {
                            c.a.t0.j3.l0.d.i(aVar.g(), 1, Y4);
                            builder2.app.remove(size);
                        }
                    }
                }
            }
        }
        if (builder2.app.size() != builder.banner_list.app.size()) {
            builder.banner_list = builder2.build(false);
        }
    }

    public static void n(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, builder) == null) {
            m(builder);
            if (builder == null || builder.card_forum == null || builder.card_topic == null || builder.resource_list == null || ListUtils.getCount(builder.thread_list) == 0) {
                return;
            }
            int count = ListUtils.getCount(builder.thread_list);
            for (int size = builder.card_forum.size() - 1; size >= 0; size--) {
                if (builder.card_forum.get(size).position.longValue() > count) {
                    builder.card_forum.remove(size);
                }
            }
            for (int size2 = builder.card_topic.size() - 1; size2 >= 0; size2--) {
                if (builder.card_topic.get(size2).position.intValue() > count) {
                    builder.card_topic.remove(size2);
                }
            }
            for (int size3 = builder.resource_list.size() - 1; size3 >= 0; size3--) {
                if (builder.resource_list.get(size3).position.longValue() > count) {
                    builder.resource_list.remove(size3);
                }
            }
            for (int size4 = builder.card_god.size() - 1; size4 >= 0; size4--) {
                if (builder.card_god.get(size4).position.intValue() > count) {
                    builder.card_god.remove(size4);
                }
            }
        }
    }

    public static void o(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, e2Var) == null) {
            String A0 = e2Var.A0();
            String formatTimeForHomeC = StringHelper.getFormatTimeForHomeC(e2Var.w0() * 1000);
            if (!TextUtils.isEmpty(A0) && !TextUtils.isEmpty(formatTimeForHomeC)) {
                A0 = A0 + TbadkCoreApplication.getInst().getString(R.string.send_post) + "   " + TbadkCoreApplication.getInst().getString(R.string.repley_when) + formatTimeForHomeC;
            }
            e2Var.C4(A0);
        }
    }

    public static void p(c.a.t0.g0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, bVar) == null) {
            if (bVar instanceof m) {
                ((m) bVar).F = true;
            } else if (bVar instanceof k) {
                ((k) bVar).F = true;
            } else if (bVar instanceof l) {
                ((l) bVar).F = true;
            } else if (bVar instanceof j) {
                ((j) bVar).F = true;
            }
            bVar.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public static void q(c.a.t0.g0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, bVar) == null) {
            if (bVar == null || bVar.getThreadData() == null || !bVar.getThreadData().a2 || !bVar.getThreadData().M2()) {
                if (bVar instanceof k) {
                    ((k) bVar).C = true;
                } else if (bVar instanceof l) {
                    ((l) bVar).C = true;
                } else if (bVar instanceof j) {
                    ((j) bVar).C = true;
                }
                bVar.setSupportType(BaseCardInfo.SupportType.EXTEND);
            }
        }
    }

    public static void r(c.a.t0.g0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, bVar) == null) {
            bVar.s = true;
            bVar.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public static void s(c.a.t0.g0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65559, null, bVar) == null) || bVar == null || bVar.getThreadData() == null || bVar.getThreadData().y1() == null || bVar.getThreadData().y1().t() == null || bVar.getThreadData().y1().t().getUserId() == null) {
            return;
        }
        if (bVar instanceof k) {
            ((k) bVar).D = true;
        } else if (bVar instanceof l) {
            ((l) bVar).D = true;
        } else if (bVar instanceof j) {
            ((j) bVar).D = true;
        }
        bVar.setSupportType(BaseCardInfo.SupportType.EXTEND);
    }

    public static void t(c.a.t0.g0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, bVar) == null) {
            if (bVar instanceof m) {
                ((m) bVar).r = true;
            } else if (bVar instanceof k) {
                ((k) bVar).r = true;
            } else if (bVar instanceof l) {
                ((l) bVar).r = true;
            } else if (bVar instanceof j) {
                ((j) bVar).r = true;
            }
            bVar.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public static void u(c.a.t0.g0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, bVar) == null) {
            ((k) bVar).t = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void v(c.a.t0.g0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, bVar) == null) {
            ((k) bVar).v = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void w(c.a.t0.g0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, bVar) == null) {
            ((k) bVar).u = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void x(c.a.t0.g0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, bVar) == null) {
            ((k) bVar).w = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void y(c.a.t0.g0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, null, bVar) == null) {
            ((l) bVar).x = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void z(c.a.t0.g0.f0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, bVar) == null) {
            ((m) bVar).y = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }
}
