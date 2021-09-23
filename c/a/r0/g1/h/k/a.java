package c.a.r0.g1.h.k;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.q0.a.r;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.o0;
import c.a.q0.s.q.p0;
import c.a.r0.a0.d0.k;
import c.a.r0.a0.d0.l;
import c.a.r0.a0.d0.p;
import c.a.r0.g1.h.j.g;
import c.a.r0.j3.i0.o;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
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
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.Personalized.UserFollowLive;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c f18370a;

    /* renamed from: b  reason: collision with root package name */
    public final int f18371b;

    /* renamed from: c  reason: collision with root package name */
    public int f18372c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.g1.h.l.c f18373d;

    /* renamed from: e  reason: collision with root package name */
    public int f18374e;

    /* renamed from: f  reason: collision with root package name */
    public int f18375f;

    /* renamed from: g  reason: collision with root package name */
    public int f18376g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<ThreadInfo> f18377h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<App> f18378i;

    /* renamed from: j  reason: collision with root package name */
    public Long f18379j;
    public List<n> k;

    /* renamed from: c.a.r0.g1.h.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0887a implements Comparator<p> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0887a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
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
        public int compare(p pVar, p pVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, pVar, pVar2)) == null) {
                if (pVar != null && pVar2 != null) {
                    if (pVar.getPosition() > pVar2.getPosition()) {
                        return 1;
                    }
                    if (pVar.getPosition() < pVar2.getPosition()) {
                        return -1;
                    }
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c.a.q0.f1.m.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a0.d0.b l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i2, String str, c.a.r0.a0.d0.b bVar) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), str, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = bVar;
        }

        @Override // c.a.q0.f1.m.e, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view.getContext(), d(), null)));
                c.a.r0.a0.d0.b bVar = this.l;
                if (bVar instanceof k) {
                    statisticItem = ((k) bVar).U();
                } else if (bVar instanceof l) {
                    statisticItem = ((l) bVar).S(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18372c = 0;
        this.f18373d = new c.a.r0.g1.h.l.c();
        this.f18374e = 0;
        this.f18379j = 0L;
        this.f18370a = new c();
        this.f18371b = c.a.q0.s.d0.b.j().k("home_page_max_thread_count", 300);
        this.f18377h = new ArrayList<>();
        this.f18378i = new ArrayList<>();
        this.k = new ArrayList();
    }

    public final c.a.r0.g1.h.j.f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c cVar = this.f18370a;
            if (cVar != null && !ListUtils.isEmpty(cVar.f18380a)) {
                for (n nVar : this.f18370a.f18380a) {
                    if (nVar instanceof c.a.r0.g1.h.j.f) {
                        return (c.a.r0.g1.h.j.f) nVar;
                    }
                }
            }
            return null;
        }
        return (c.a.r0.g1.h.j.f) invokeV.objValue;
    }

    public final g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c cVar = this.f18370a;
            if (cVar != null && !ListUtils.isEmpty(cVar.f18380a)) {
                for (n nVar : this.f18370a.f18380a) {
                    if (nVar instanceof g) {
                        return (g) nVar;
                    }
                }
            }
            return null;
        }
        return (g) invokeV.objValue;
    }

    public c c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i2)})) == null) {
            if (i2 == 0 || i2 == 1) {
                if (builder == null) {
                    builder = new DataRes.Builder();
                }
                if (builder2 == null) {
                    builder2 = new DataRes.Builder();
                }
                d.c(builder);
                d.c(builder2);
                n(z, builder, builder2, i2);
                List<ThreadInfo> o = o(builder, i2, this.f18371b);
                d.n(builder);
                List<p> d2 = d.d(builder);
                p(d2);
                List<n> f2 = f(builder.thread_list, d2, builder2.user_follow_live, i2, 0, builder2);
                List<n> f3 = f(o, new ArrayList(), builder2.user_follow_live, i2, 1, null);
                this.f18373d.a(f2);
                c.a.r0.g1.h.k.b.c(builder, f2);
                c cVar = this.f18370a;
                cVar.f18380a = f2;
                cVar.f18382c = f3 == null ? 0 : f3.size();
                return this.f18370a;
            }
            return null;
        }
        return (c) invokeCommon.objValue;
    }

    public List<ThreadInfo> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18377h : (List) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18371b : invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<n> f(List<ThreadInfo> list, List<p> list2, UserFollowLive userFollowLive, int i2, int i3, DataRes.Builder builder) {
        InterceptResult invokeCommon;
        c.a.r0.g1.h.j.f a2;
        g gVar;
        boolean z;
        c.a.r0.a0.d0.b e2;
        k g2;
        ThreadRecommendInfoData threadRecommendInfoData;
        k g3;
        k g4;
        k g5;
        k g6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{list, list2, userFollowLive, Integer.valueOf(i2), Integer.valueOf(i3), builder})) == null) {
            if (list == null) {
                return null;
            }
            if (builder != null && !ListUtils.isEmpty(builder.thread_list) && builder.active_center != null) {
                ThreadInfo threadInfo = builder.thread_list.get(builder.thread_list.size() - 1);
                if (threadInfo.id.longValue() > 0 && r.g().o()) {
                    this.f18379j = threadInfo.id;
                }
            }
            List<n> arrayList = new ArrayList<>(ListUtils.getCount(list));
            for (ThreadInfo threadInfo2 : list) {
                d2 d2Var = new d2();
                c.a.q0.b.f.a.e(d2Var);
                d2Var.a2 = true;
                d2Var.Y2(threadInfo2);
                arrayList.add(d2Var);
            }
            if (builder != null && c.a.r0.g1.c.f.c.p(builder.hot_recomforum, -1)) {
                c.a.r0.g1.c.f.c cVar = new c.a.r0.g1.c.f.c();
                cVar.floorPosition = builder.hot_recomforum.floor.intValue() > 0 ? builder.hot_recomforum.floor.intValue() - 1 : 0;
                if (cVar.k(builder.hot_recomforum.tab_list)) {
                    g(cVar, cVar.floorPosition, arrayList);
                }
            }
            if (i3 == 0 && c.a.q0.b.d.I()) {
                int c2 = c.a.q0.t.c.e.c();
                int b2 = c.a.q0.t.c.e.b();
                if (i2 == 0) {
                    b2 = c.a.q0.t.c.e.a();
                    this.k.clear();
                }
                h(b2, c2, arrayList);
            }
            LinkedList<n> linkedList = new LinkedList();
            int i4 = 0;
            for (n nVar : arrayList) {
                boolean z2 = nVar instanceof d2;
                if (z2 && ((d2) nVar).Y1()) {
                    linkedList.add(nVar);
                } else if (z2) {
                    d2 d2Var2 = (d2) nVar;
                    if (!TextUtils.isEmpty(d2Var2.y0())) {
                        p0 p0Var = new p0();
                        p0Var.k(d2Var2.y0());
                        p0Var.position = i4;
                        linkedList.add(p0Var);
                    } else if (c.a.r0.g1.k.b.c.a.P(d2Var2)) {
                        if (!StringUtils.isNull(d2Var2.x1().topic_name)) {
                            c.a.r0.g1.k.b.c.a aVar = new c.a.r0.g1.k.b.c.a();
                            aVar.R(d2Var2.x1());
                            aVar.c0 = 1;
                            aVar.position = i4;
                            aVar.S(d2Var2);
                            aVar.setSupportType(BaseCardInfo.SupportType.FULL);
                            linkedList.add(aVar);
                        }
                    } else if (!k.Y(d2Var2) && !l.T(d2Var2)) {
                        if (c.a.r0.a0.d0.e.Y(d2Var2) && d2Var2.M1()) {
                            c.a.r0.a0.d0.e eVar = new c.a.r0.a0.d0.e(d2Var2);
                            eVar.position = i4;
                            linkedList.add(eVar);
                        } else {
                            c.a.r0.a0.d0.b e3 = d.e(d2Var2);
                            if (e3 != null) {
                                e3.l = d2Var2.s1();
                                e3.position = i4;
                            }
                            if (e3 != null && e3.isValid()) {
                                linkedList.add(e3);
                            }
                        }
                    } else {
                        k g7 = d.g(d2Var2);
                        if (g7 != null) {
                            if (d2Var2.showCardEnterFourm()) {
                                if (g7.isValid()) {
                                    g7.l = d2Var2.s1();
                                    g7.position = i4;
                                    d.t(g7);
                                    linkedList.add(g7);
                                }
                            } else {
                                d2 d2Var3 = g7.f15571e;
                                if (d2Var3 != null && d2Var3.Y() != null && !StringUtils.isNull(d2Var3.Y().f14374b)) {
                                    g7.l = d2Var2.s1();
                                    g7.position = i4;
                                    d.r(g7);
                                    linkedList.add(g7);
                                    z = true;
                                    e2 = d.e(d2Var2);
                                    if (e2 != null) {
                                        e2.l = d2Var2.s1();
                                        e2.position = i4;
                                        if (e2 instanceof k) {
                                            if (d2Var2.N1()) {
                                                d.u(e2);
                                            } else if (d2Var2.d3() == 1) {
                                                d.w(e2);
                                                int[] g0 = d2Var2.g0();
                                                e2.o = g0[0];
                                                e2.p = g0[1];
                                            } else if (d2Var2.d3() >= 2) {
                                                d.v(e2);
                                            } else {
                                                d.x(e2);
                                            }
                                        } else if (e2 instanceof l) {
                                            d.y(e2);
                                        }
                                    }
                                    if (e2 != null && e2.isValid()) {
                                        e2.f15571e.G1();
                                        if (!d2Var2.D2() && d2Var2.J() != null && z) {
                                            String format = String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), d2Var2.J().getName_show());
                                            SpannableString spannableString = new SpannableString(format);
                                            spannableString.setSpan(new b(this, 16, d2Var2.J().getUserId(), e2), 0, format.length() - 1, 33);
                                            e2.f15571e.H1(spannableString);
                                        }
                                        linkedList.add(e2);
                                    }
                                    if (d2Var2.s0() != null && (g6 = d.g(d2Var2)) != null) {
                                        g6.l = d2Var2.s1();
                                        g6.position = i4;
                                        d.z(g6);
                                        if (!k.Y(d2Var2)) {
                                            g6.N("1");
                                        } else if (l.T(d2Var2)) {
                                            g6.N("2");
                                        }
                                        linkedList.add(g6);
                                    }
                                    if ((ListUtils.isEmpty(d2Var2.A0()) || !ListUtils.isEmpty(d2Var2.c0())) && (g2 = d.g(d2Var2)) != null) {
                                        g2.l = d2Var2.s1();
                                        g2.position = i4;
                                        if (ListUtils.getCount(d2Var2.A0()) + ListUtils.getCount(d2Var2.c0()) != 1) {
                                            d.C(g2);
                                        } else {
                                            d.A(g2);
                                        }
                                        linkedList.add(g2);
                                    }
                                    threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(d2Var2.n1(), 0);
                                    if (threadRecommendInfoData != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason) && (g5 = d.g(d2Var2)) != null) {
                                        g5.l = d2Var2.s1();
                                        g5.position = i4;
                                        d.B(g5);
                                        if (g5.isValid()) {
                                            linkedList.add(g5);
                                        }
                                    }
                                    if (d2Var2.showCardEnterFourm() && (g4 = d.g(d2Var2)) != null) {
                                        g4.l = d2Var2.s1();
                                        g4.position = i4;
                                        d.q(g4);
                                        if (!k.Y(d2Var2)) {
                                            g4.N("1");
                                        } else if (l.T(d2Var2)) {
                                            g4.N("2");
                                        }
                                        if (!d2Var2.showCardEnterFourm() && !StringUtils.isNull(d2Var2.Z())) {
                                            linkedList.add(g4);
                                        } else if (!StringUtils.isNull(d2Var2.Z())) {
                                            linkedList.add(g4);
                                        }
                                    }
                                    if (d2Var2.v1() != null) {
                                        k g8 = d.g(d2Var2);
                                        if (g8 != null) {
                                            g8.l = d2Var2.s1();
                                            g8.position = i4;
                                            d.s(g8);
                                        }
                                        if (g8 != null && g8.isValid()) {
                                            linkedList.add(g8);
                                        }
                                    }
                                    g3 = d.g(d2Var2);
                                    if (g3 != null) {
                                        g3.l = d2Var2.s1();
                                        g3.position = i4;
                                        d.p(g3);
                                    }
                                    if (g3 != null && g3.isValid()) {
                                        linkedList.add(g3);
                                    }
                                } else if (g7.isValid()) {
                                    g7.l = d2Var2.s1();
                                    g7.position = i4;
                                    d.t(g7);
                                    linkedList.add(g7);
                                }
                            }
                        }
                        z = false;
                        e2 = d.e(d2Var2);
                        if (e2 != null) {
                        }
                        if (e2 != null) {
                            e2.f15571e.G1();
                            if (!d2Var2.D2()) {
                                String format2 = String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), d2Var2.J().getName_show());
                                SpannableString spannableString2 = new SpannableString(format2);
                                spannableString2.setSpan(new b(this, 16, d2Var2.J().getUserId(), e2), 0, format2.length() - 1, 33);
                                e2.f15571e.H1(spannableString2);
                            }
                            linkedList.add(e2);
                        }
                        if (d2Var2.s0() != null) {
                            g6.l = d2Var2.s1();
                            g6.position = i4;
                            d.z(g6);
                            if (!k.Y(d2Var2)) {
                            }
                            linkedList.add(g6);
                        }
                        if (ListUtils.isEmpty(d2Var2.A0())) {
                        }
                        g2.l = d2Var2.s1();
                        g2.position = i4;
                        if (ListUtils.getCount(d2Var2.A0()) + ListUtils.getCount(d2Var2.c0()) != 1) {
                        }
                        linkedList.add(g2);
                        threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(d2Var2.n1(), 0);
                        if (threadRecommendInfoData != null) {
                            g5.l = d2Var2.s1();
                            g5.position = i4;
                            d.B(g5);
                            if (g5.isValid()) {
                            }
                        }
                        if (d2Var2.showCardEnterFourm()) {
                            g4.l = d2Var2.s1();
                            g4.position = i4;
                            d.q(g4);
                            if (!k.Y(d2Var2)) {
                            }
                            if (!d2Var2.showCardEnterFourm()) {
                            }
                            if (!StringUtils.isNull(d2Var2.Z())) {
                            }
                        }
                        if (d2Var2.v1() != null) {
                        }
                        g3 = d.g(d2Var2);
                        if (g3 != null) {
                        }
                        if (g3 != null) {
                            linkedList.add(g3);
                        }
                    }
                    long g9 = c.a.e.e.m.b.g(d2Var2.f0(), 0L);
                    if (g9 != 0 && g9 == this.f18379j.longValue()) {
                        if (builder.active_center != null) {
                            gVar = new g();
                            gVar.P(builder.active_center);
                        } else {
                            gVar = null;
                        }
                        if (gVar == null) {
                            gVar = b();
                        }
                        if (gVar != null) {
                            i4++;
                            gVar.U = i4;
                            linkedList.add(gVar);
                        }
                    }
                    i4++;
                } else if (nVar instanceof BaseCardInfo) {
                    linkedList.add(nVar);
                } else {
                    linkedList.add(nVar);
                }
                i4++;
            }
            if (!c.a.q0.b.d.I()) {
                int i5 = 0;
                int i6 = 0;
                for (int i7 = 0; i7 < ListUtils.getCount(list2); i7++) {
                    p pVar = (p) ListUtils.getItem(list2, i7);
                    if (pVar != null && i5 < linkedList.size()) {
                        while (i5 < linkedList.size() && (!(linkedList.get(i5) instanceof c.a.r0.a0.d0.b) || ((c.a.r0.a0.d0.b) linkedList.get(i5)).position + i6 != pVar.getPosition() - 1)) {
                            i5++;
                        }
                        if (linkedList.size() > i5 && i5 > 0) {
                            linkedList.add(i5, pVar);
                            i6++;
                        }
                    }
                }
                int i8 = 0;
                int i9 = 0;
                for (n nVar2 : linkedList) {
                    if (nVar2 instanceof o0) {
                        ((o0) nVar2).setPosition(i8 + 1);
                        i9++;
                    } else if (nVar2 instanceof BaseCardInfo) {
                        BaseCardInfo baseCardInfo = (BaseCardInfo) nVar2;
                        i8 = baseCardInfo.position + i9;
                        baseCardInfo.position = i8;
                    }
                }
            }
            if (i3 == 0) {
                if (i2 == 0 && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
                    c.a.r0.g1.h.j.f fVar = new c.a.r0.g1.h.j.f();
                    fVar.k(userFollowLive);
                    linkedList.add(0, fVar);
                    fVar.position = -1;
                } else if (i2 == 1 && (a2 = a()) != null) {
                    linkedList.add(0, a2);
                    a2.position = -1;
                }
            }
            c.a.q0.b.f.a.d(linkedList);
            return linkedList;
        }
        return (List) invokeCommon.objValue;
    }

    public void g(c.a.q0.s.q.a aVar, int i2, List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048582, this, aVar, i2, list) == null) || aVar == null || list == null || i2 <= 0) {
            return;
        }
        int size = list.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            if (list.get(i4) instanceof d2) {
                if (i2 == i3) {
                    aVar.floorPosition = i2;
                    ListUtils.add(list, i4, aVar);
                    return;
                }
                i3++;
            }
        }
    }

    public final void h(int i2, int i3, List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, list) == null) || ListUtils.isEmpty(list) || i2 < 0 || i3 < 1) {
            return;
        }
        ListIterator<n> listIterator = list.listIterator();
        int i4 = 0;
        int i5 = 0;
        while (listIterator.hasNext()) {
            if (i4 == i2 || (i4 > i2 && (i4 - i2) % i3 == 0)) {
                if (i5 < this.k.size()) {
                    listIterator.add(this.k.get(i5));
                } else {
                    d2 d2Var = new d2();
                    o oVar = new o();
                    oVar.k(true);
                    d2Var.K2 = oVar;
                    listIterator.add(d2Var);
                    this.k.add(d2Var);
                }
                i5++;
            }
            listIterator.next();
            i4++;
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList<ThreadInfo> arrayList = this.f18377h;
            return (arrayList == null || ListUtils.isEmpty(arrayList)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f18374e > 0 : invokeV.booleanValue;
    }

    public final void k(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i2)}) == null) {
            d.k(z, builder, builder2, i2, this.f18372c, this.f18375f, this.f18376g);
        }
    }

    public final void l(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i2) {
        List<ThreadInfo> list;
        List<ThreadInfo> list2;
        Long l;
        Long l2;
        Long l3;
        Long l4;
        Long l5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i2)}) == null) || builder == null || builder2 == null || (list = builder.thread_list) == null || (list2 = builder2.thread_list) == null) {
            return;
        }
        this.f18375f = ListUtils.getCount(list);
        BannerList bannerList = builder.banner_list;
        if (bannerList != null) {
            this.f18376g = ListUtils.getCount(bannerList.app);
        } else {
            this.f18376g = 0;
        }
        int count = ListUtils.getCount(list) + ListUtils.getCount(this.f18377h);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null && !TextUtils.isEmpty(threadInfo.lego_card)) {
                hashSet2.add(threadInfo.lego_card);
            } else if (threadInfo != null && (l5 = threadInfo.tid) != null) {
                hashSet.add(l5);
            }
        }
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        Iterator<ThreadInfo> it = this.f18377h.iterator();
        while (it.hasNext()) {
            ThreadInfo next = it.next();
            if (next != null && !TextUtils.isEmpty(next.lego_card)) {
                hashSet4.add(next.lego_card);
            } else if (next != null && (l4 = next.tid) != null) {
                hashSet3.add(l4);
            }
        }
        if (i2 == 1) {
            if (!ListUtils.isEmpty(list2)) {
                this.f18373d.b((ThreadInfo) ListUtils.getItem(list2, 0));
            }
            for (ThreadInfo threadInfo2 : list2) {
                if (threadInfo2 != null && !TextUtils.isEmpty(threadInfo2.lego_card)) {
                    if (!hashSet2.contains(threadInfo2.lego_card) && !hashSet4.contains(threadInfo2.lego_card)) {
                        list.add(threadInfo2);
                    }
                } else if (threadInfo2 != null && (l3 = threadInfo2.tid) != null && !hashSet.contains(l3) && !hashSet3.contains(threadInfo2.tid)) {
                    list.add(threadInfo2);
                    JSONObject b2 = c.a.r0.y2.l0.b.b(threadInfo2);
                    if (b2 != null) {
                        arrayList.add(b2);
                    }
                }
            }
        } else {
            this.f18373d.c(z, list);
            if (j()) {
                BannerList bannerList2 = builder.banner_list;
                if (bannerList2 != null && !ListUtils.isEmpty(bannerList2.app)) {
                    this.f18378i.addAll(0, builder.banner_list.app);
                    BannerList.Builder builder3 = new BannerList.Builder(builder.banner_list);
                    builder3.app = new LinkedList();
                    builder.banner_list = builder3.build(false);
                }
                this.f18377h.addAll(0, list);
                list.clear();
                hashSet.clear();
                hashSet2.clear();
                if (ListUtils.getCount(this.f18377h) > this.f18371b) {
                    for (int size = this.f18377h.size() - 1; size >= this.f18371b; size--) {
                        this.f18377h.remove(size);
                    }
                }
                hashSet3.clear();
                hashSet4.clear();
                Iterator<ThreadInfo> it2 = this.f18377h.iterator();
                while (it2.hasNext()) {
                    ThreadInfo next2 = it2.next();
                    if (next2 != null && !TextUtils.isEmpty(next2.lego_card)) {
                        hashSet4.add(next2.lego_card);
                    } else if (next2 != null && (l2 = next2.tid) != null) {
                        hashSet3.add(l2);
                    }
                }
            }
            for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                ThreadInfo threadInfo3 = (ThreadInfo) ListUtils.getItem(list2, count2);
                if (threadInfo3 != null && !TextUtils.isEmpty(threadInfo3.lego_card)) {
                    if (!hashSet2.contains(threadInfo3.lego_card) && !hashSet4.contains(threadInfo3.lego_card)) {
                        list.add(0, threadInfo3);
                    }
                } else if (threadInfo3 != null && (l = threadInfo3.tid) != null && !hashSet.contains(l) && !hashSet3.contains(threadInfo3.tid)) {
                    list.add(0, threadInfo3);
                    JSONObject b3 = c.a.r0.y2.l0.b.b(threadInfo3);
                    if (b3 != null) {
                        arrayList.add(0, b3);
                    }
                }
            }
        }
        if (j()) {
            if (!ListUtils.isEmpty(this.f18378i) && builder2.banner_list != null) {
                int count3 = ListUtils.getCount(list2) + ListUtils.getCount(builder2.banner_list.app);
                for (int i3 = 0; i3 < this.f18378i.size(); i3++) {
                    App app = this.f18378i.get(i3);
                    if (app != null) {
                        App.Builder builder4 = new App.Builder(app);
                        c.a.r0.y2.c.c(builder4, count3);
                        App build = builder4.build(false);
                        this.f18378i.remove(i3);
                        this.f18378i.add(i3, build);
                    }
                }
            }
            if (ListUtils.getCount(list) >= this.f18374e) {
                list.addAll(this.f18377h);
                this.f18377h.clear();
                BannerList.Builder builder5 = new BannerList.Builder(builder.banner_list);
                if (builder5.app == null) {
                    builder5.app = new LinkedList();
                }
                builder5.app.addAll(this.f18378i);
                builder.banner_list = builder5.build(false);
                this.f18378i.clear();
            }
        }
        int count4 = (ListUtils.getCount(list) + ListUtils.getCount(this.f18377h)) - count;
        this.f18370a.f18381b = count4;
        this.f18372c = count4;
        c.a.r0.y2.l0.b.f().h("NEWINDEX", arrayList);
    }

    public final void m(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, list, list2) == null) || list == null || list2 == null) {
            return;
        }
        list.addAll(list2);
    }

    public final void n(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i2)}) == null) || builder == null || builder2 == null) {
            return;
        }
        Integer num = builder2.fresh_ctrl_num;
        int intValue = (num == null || num.intValue() <= 0) ? 0 : builder2.fresh_ctrl_num.intValue();
        this.f18374e = intValue;
        int i3 = this.f18371b;
        if (intValue > i3) {
            intValue = i3;
        }
        this.f18374e = intValue;
        l(z, builder, builder2, i2);
        k(z, builder, builder2, i2);
        m(builder.thread_personalized, builder2.thread_personalized);
    }

    public final List<ThreadInfo> o(DataRes.Builder builder, int i2, int i3) {
        InterceptResult invokeLII;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048590, this, builder, i2, i3)) == null) {
            ArrayList arrayList = new ArrayList();
            if (builder != null && (list = builder.thread_list) != null) {
                if (i2 == 1) {
                    for (int count = ((ListUtils.getCount(list) - i3) + 30) - 1; count >= 30; count--) {
                        if (list.size() > count) {
                            arrayList.add(list.remove(count));
                        }
                    }
                } else {
                    for (int count2 = ListUtils.getCount(list) - 1; count2 >= i3; count2--) {
                        list.remove(count2);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLII.objValue;
    }

    public final void p(List<p> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, list) == null) || list == null) {
            return;
        }
        Collections.sort(list, new C0887a(this));
    }
}
