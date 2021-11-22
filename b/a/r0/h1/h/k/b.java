package b.a.r0.h1.h.k;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.e.m.e.n;
import b.a.q0.a.r;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.o0;
import b.a.q0.s.q.p0;
import b.a.r0.b0.f0.k;
import b.a.r0.b0.f0.l;
import b.a.r0.b0.f0.m;
import b.a.r0.b0.f0.q;
import b.a.r0.m3.j0.o;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d f18942a;

    /* renamed from: b  reason: collision with root package name */
    public final int f18943b;

    /* renamed from: c  reason: collision with root package name */
    public int f18944c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.h1.h.l.c f18945d;

    /* renamed from: e  reason: collision with root package name */
    public int f18946e;

    /* renamed from: f  reason: collision with root package name */
    public int f18947f;

    /* renamed from: g  reason: collision with root package name */
    public int f18948g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<ThreadInfo> f18949h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<App> f18950i;
    public Long j;
    public List<n> k;

    /* loaded from: classes4.dex */
    public class a implements Comparator<q> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
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
        public int compare(q qVar, q qVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, qVar, qVar2)) == null) {
                if (qVar != null && qVar2 != null) {
                    if (qVar.getPosition() > qVar2.getPosition()) {
                        return 1;
                    }
                    if (qVar.getPosition() < qVar2.getPosition()) {
                        return -1;
                    }
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* renamed from: b.a.r0.h1.h.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0959b extends b.a.q0.e1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b.a.r0.b0.f0.b l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0959b(b bVar, int i2, String str, b.a.r0.b0.f0.b bVar2) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), str, bVar2};
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
            this.l = bVar2;
        }

        @Override // b.a.q0.e1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view.getContext(), d(), null)));
                b.a.r0.b0.f0.b bVar = this.l;
                if (bVar instanceof k) {
                    statisticItem = ((k) bVar).U();
                } else if (bVar instanceof l) {
                    statisticItem = ((l) bVar).S(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public b() {
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
        this.f18944c = 0;
        this.f18945d = new b.a.r0.h1.h.l.c();
        this.f18946e = 0;
        this.j = 0L;
        this.f18942a = new d();
        this.f18943b = b.a.q0.s.e0.b.j().k("home_page_max_thread_count", 300);
        this.f18949h = new ArrayList<>();
        this.f18950i = new ArrayList<>();
        this.k = new ArrayList();
    }

    public final b.a.r0.h1.h.j.f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d dVar = this.f18942a;
            if (dVar != null && !ListUtils.isEmpty(dVar.f18951a)) {
                for (n nVar : this.f18942a.f18951a) {
                    if (nVar instanceof b.a.r0.h1.h.j.f) {
                        return (b.a.r0.h1.h.j.f) nVar;
                    }
                }
            }
            return null;
        }
        return (b.a.r0.h1.h.j.f) invokeV.objValue;
    }

    public final b.a.r0.h1.h.j.g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d dVar = this.f18942a;
            if (dVar != null && !ListUtils.isEmpty(dVar.f18951a)) {
                for (n nVar : this.f18942a.f18951a) {
                    if (nVar instanceof b.a.r0.h1.h.j.g) {
                        return (b.a.r0.h1.h.j.g) nVar;
                    }
                }
            }
            return null;
        }
        return (b.a.r0.h1.h.j.g) invokeV.objValue;
    }

    public d c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i2) {
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
                e.c(builder);
                e.c(builder2);
                n(z, builder, builder2, i2);
                List<ThreadInfo> o = o(builder, i2, this.f18943b);
                e.n(builder);
                List<q> d2 = e.d(builder);
                p(d2);
                List<n> f2 = f(builder.thread_list, d2, builder2.user_follow_live, i2, 0, builder2);
                List<n> f3 = f(o, new ArrayList(), builder2.user_follow_live, i2, 1, null);
                this.f18945d.a(f2);
                c.c(builder, f2);
                d dVar = this.f18942a;
                dVar.f18951a = f2;
                dVar.f18953c = f3 == null ? 0 : f3.size();
                return this.f18942a;
            }
            return null;
        }
        return (d) invokeCommon.objValue;
    }

    public List<ThreadInfo> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18949h : (List) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18943b : invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<n> f(List<ThreadInfo> list, List<q> list2, UserFollowLive userFollowLive, int i2, int i3, DataRes.Builder builder) {
        InterceptResult invokeCommon;
        b.a.r0.h1.h.j.f a2;
        b.a.r0.h1.h.j.g gVar;
        boolean z;
        b.a.r0.b0.f0.b e2;
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
                    this.j = threadInfo.id;
                }
            }
            List<n> arrayList = new ArrayList<>(ListUtils.getCount(list));
            for (ThreadInfo threadInfo2 : list) {
                d2 d2Var = new d2();
                b.a.q0.b.f.a.e(d2Var);
                d2Var.a2 = true;
                d2Var.a3(threadInfo2);
                arrayList.add(d2Var);
            }
            if (builder != null && b.a.r0.h1.c.f.c.p(builder.hot_recomforum, -1)) {
                b.a.r0.h1.c.f.c cVar = new b.a.r0.h1.c.f.c();
                cVar.floorPosition = builder.hot_recomforum.floor.intValue() > 0 ? builder.hot_recomforum.floor.intValue() - 1 : 0;
                if (cVar.k(builder.hot_recomforum.tab_list)) {
                    g(cVar, cVar.floorPosition, arrayList);
                }
            }
            if (i3 == 0 && b.a.q0.b.d.M()) {
                int f2 = b.a.q0.t.c.e.f();
                int e3 = b.a.q0.t.c.e.e();
                if (i2 == 0) {
                    e3 = b.a.q0.t.c.e.a();
                    this.k.clear();
                }
                h(e3, f2, arrayList);
            }
            LinkedList<n> linkedList = new LinkedList();
            int i4 = 0;
            for (n nVar : arrayList) {
                boolean z2 = nVar instanceof d2;
                if (z2 && ((d2) nVar).a2()) {
                    linkedList.add(nVar);
                } else if (z2) {
                    d2 d2Var2 = (d2) nVar;
                    if (!TextUtils.isEmpty(d2Var2.y0())) {
                        p0 p0Var = new p0();
                        p0Var.k(d2Var2.y0());
                        p0Var.position = i4;
                        linkedList.add(p0Var);
                    } else if (b.a.r0.h1.k.b.c.a.P(d2Var2)) {
                        if (!StringUtils.isNull(d2Var2.y1().topic_name)) {
                            b.a.r0.h1.k.b.c.a aVar = new b.a.r0.h1.k.b.c.a();
                            aVar.R(d2Var2.y1());
                            aVar.j0 = 1;
                            aVar.position = i4;
                            aVar.S(d2Var2);
                            aVar.setSupportType(BaseCardInfo.SupportType.FULL);
                            linkedList.add(aVar);
                        }
                    } else if (!k.Y(d2Var2) && !l.T(d2Var2) && !m.Y(d2Var2)) {
                        if (b.a.r0.b0.f0.e.Y(d2Var2) && d2Var2.O1()) {
                            b.a.r0.b0.f0.e eVar = new b.a.r0.b0.f0.e(d2Var2);
                            eVar.position = i4;
                            linkedList.add(eVar);
                        } else {
                            b.a.r0.b0.f0.b e4 = e.e(d2Var2);
                            if (e4 != null) {
                                e4.l = d2Var2.t1();
                                e4.position = i4;
                            }
                            if (e4 != null && e4.isValid()) {
                                linkedList.add(e4);
                            }
                        }
                    } else {
                        k g7 = e.g(d2Var2);
                        if (g7 != null) {
                            if (d2Var2.showCardEnterFourm()) {
                                if (g7.isValid()) {
                                    g7.l = d2Var2.t1();
                                    g7.position = i4;
                                    e.t(g7);
                                    linkedList.add(g7);
                                }
                            } else {
                                d2 d2Var3 = g7.f16235e;
                                if (d2Var3 != null && d2Var3.Y() != null && !StringUtils.isNull(d2Var3.Y().f14288b)) {
                                    g7.l = d2Var2.t1();
                                    g7.position = i4;
                                    e.r(g7);
                                    linkedList.add(g7);
                                    z = true;
                                    e2 = e.e(d2Var2);
                                    if (e2 != null) {
                                        e2.l = d2Var2.t1();
                                        e2.position = i4;
                                        if (e2 instanceof k) {
                                            if (d2Var2.P1()) {
                                                e.u(e2);
                                            } else if (d2Var2.f3() == 1) {
                                                e.w(e2);
                                                int[] g0 = d2Var2.g0();
                                                e2.o = g0[0];
                                                e2.p = g0[1];
                                            } else if (d2Var2.f3() >= 2) {
                                                e.v(e2);
                                            } else {
                                                e.x(e2);
                                            }
                                        } else if (e2 instanceof l) {
                                            e.y(e2);
                                        }
                                    }
                                    if (e2 instanceof m) {
                                        e.z(e2);
                                    }
                                    if (e2 != null && e2.isValid()) {
                                        e2.f16235e.I1();
                                        if (!d2Var2.F2() && d2Var2.J() != null && z) {
                                            String format = String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), d2Var2.J().getName_show());
                                            SpannableString spannableString = new SpannableString(format);
                                            spannableString.setSpan(new C0959b(this, 16, d2Var2.J().getUserId(), e2), 0, format.length() - 1, 33);
                                            e2.f16235e.J1(spannableString);
                                        }
                                        linkedList.add(e2);
                                    }
                                    if (d2Var2.s0() != null && (g6 = e.g(d2Var2)) != null) {
                                        g6.l = d2Var2.t1();
                                        g6.position = i4;
                                        e.A(g6);
                                        if (!k.Y(d2Var2)) {
                                            g6.N("1");
                                        } else if (l.T(d2Var2)) {
                                            g6.N("2");
                                        }
                                        linkedList.add(g6);
                                    }
                                    if ((ListUtils.isEmpty(d2Var2.A0()) || !ListUtils.isEmpty(d2Var2.c0())) && (g2 = e.g(d2Var2)) != null) {
                                        g2.l = d2Var2.t1();
                                        g2.position = i4;
                                        if (ListUtils.getCount(d2Var2.A0()) + ListUtils.getCount(d2Var2.c0()) != 1) {
                                            e.D(g2);
                                        } else {
                                            e.B(g2);
                                        }
                                        linkedList.add(g2);
                                    }
                                    threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(d2Var2.o1(), 0);
                                    if (threadRecommendInfoData != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason) && (g5 = e.g(d2Var2)) != null) {
                                        g5.l = d2Var2.t1();
                                        g5.position = i4;
                                        e.C(g5);
                                        if (g5.isValid()) {
                                            linkedList.add(g5);
                                        }
                                    }
                                    if (d2Var2.showCardEnterFourm() && (g4 = e.g(d2Var2)) != null) {
                                        g4.l = d2Var2.t1();
                                        g4.position = i4;
                                        e.q(g4);
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
                                    if (d2Var2.w1() != null) {
                                        k g8 = e.g(d2Var2);
                                        if (g8 != null) {
                                            g8.l = d2Var2.t1();
                                            g8.position = i4;
                                            e.s(g8);
                                        }
                                        if (g8 != null && g8.isValid()) {
                                            linkedList.add(g8);
                                        }
                                    }
                                    g3 = e.g(d2Var2);
                                    if (g3 != null) {
                                        g3.l = d2Var2.t1();
                                        g3.position = i4;
                                        e.p(g3);
                                    }
                                    if (g3 != null && g3.isValid()) {
                                        linkedList.add(g3);
                                    }
                                } else if (g7.isValid()) {
                                    g7.l = d2Var2.t1();
                                    g7.position = i4;
                                    e.t(g7);
                                    linkedList.add(g7);
                                }
                            }
                        }
                        z = false;
                        e2 = e.e(d2Var2);
                        if (e2 != null) {
                        }
                        if (e2 instanceof m) {
                        }
                        if (e2 != null) {
                            e2.f16235e.I1();
                            if (!d2Var2.F2()) {
                                String format2 = String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), d2Var2.J().getName_show());
                                SpannableString spannableString2 = new SpannableString(format2);
                                spannableString2.setSpan(new C0959b(this, 16, d2Var2.J().getUserId(), e2), 0, format2.length() - 1, 33);
                                e2.f16235e.J1(spannableString2);
                            }
                            linkedList.add(e2);
                        }
                        if (d2Var2.s0() != null) {
                            g6.l = d2Var2.t1();
                            g6.position = i4;
                            e.A(g6);
                            if (!k.Y(d2Var2)) {
                            }
                            linkedList.add(g6);
                        }
                        if (ListUtils.isEmpty(d2Var2.A0())) {
                        }
                        g2.l = d2Var2.t1();
                        g2.position = i4;
                        if (ListUtils.getCount(d2Var2.A0()) + ListUtils.getCount(d2Var2.c0()) != 1) {
                        }
                        linkedList.add(g2);
                        threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(d2Var2.o1(), 0);
                        if (threadRecommendInfoData != null) {
                            g5.l = d2Var2.t1();
                            g5.position = i4;
                            e.C(g5);
                            if (g5.isValid()) {
                            }
                        }
                        if (d2Var2.showCardEnterFourm()) {
                            g4.l = d2Var2.t1();
                            g4.position = i4;
                            e.q(g4);
                            if (!k.Y(d2Var2)) {
                            }
                            if (!d2Var2.showCardEnterFourm()) {
                            }
                            if (!StringUtils.isNull(d2Var2.Z())) {
                            }
                        }
                        if (d2Var2.w1() != null) {
                        }
                        g3 = e.g(d2Var2);
                        if (g3 != null) {
                        }
                        if (g3 != null) {
                            linkedList.add(g3);
                        }
                    }
                    long g9 = b.a.e.f.m.b.g(d2Var2.f0(), 0L);
                    if (g9 != 0 && g9 == this.j.longValue()) {
                        if (builder.active_center != null) {
                            gVar = new b.a.r0.h1.h.j.g();
                            gVar.P(builder.active_center);
                        } else {
                            gVar = null;
                        }
                        if (gVar == null) {
                            gVar = b();
                        }
                        if (gVar != null) {
                            i4++;
                            gVar.W = i4;
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
            if (!b.a.q0.b.d.M()) {
                int i5 = 0;
                int i6 = 0;
                for (int i7 = 0; i7 < ListUtils.getCount(list2); i7++) {
                    q qVar = (q) ListUtils.getItem(list2, i7);
                    if (qVar != null && i5 < linkedList.size()) {
                        while (i5 < linkedList.size() && (!(linkedList.get(i5) instanceof b.a.r0.b0.f0.b) || ((b.a.r0.b0.f0.b) linkedList.get(i5)).position + i6 != qVar.getPosition() - 1)) {
                            i5++;
                        }
                        if (linkedList.size() > i5 && i5 > 0) {
                            linkedList.add(i5, qVar);
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
                    b.a.r0.h1.h.j.f fVar = new b.a.r0.h1.h.j.f();
                    fVar.k(userFollowLive);
                    linkedList.add(0, fVar);
                    fVar.position = -1;
                } else if (i2 == 1 && (a2 = a()) != null) {
                    linkedList.add(0, a2);
                    a2.position = -1;
                }
            }
            b.a.q0.b.f.a.d(linkedList);
            return linkedList;
        }
        return (List) invokeCommon.objValue;
    }

    public void g(b.a.q0.s.q.a aVar, int i2, List<n> list) {
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
            ArrayList<ThreadInfo> arrayList = this.f18949h;
            return (arrayList == null || ListUtils.isEmpty(arrayList)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f18946e > 0 : invokeV.booleanValue;
    }

    public final void k(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i2)}) == null) {
            e.k(z, builder, builder2, i2, this.f18944c, this.f18947f, this.f18948g);
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
        this.f18947f = ListUtils.getCount(list);
        BannerList bannerList = builder.banner_list;
        if (bannerList != null) {
            this.f18948g = ListUtils.getCount(bannerList.app);
        } else {
            this.f18948g = 0;
        }
        int count = ListUtils.getCount(list) + ListUtils.getCount(this.f18949h);
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
        Iterator<ThreadInfo> it = this.f18949h.iterator();
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
                this.f18945d.b((ThreadInfo) ListUtils.getItem(list2, 0));
            }
            for (ThreadInfo threadInfo2 : list2) {
                if (threadInfo2 != null && !TextUtils.isEmpty(threadInfo2.lego_card)) {
                    if (!hashSet2.contains(threadInfo2.lego_card) && !hashSet4.contains(threadInfo2.lego_card)) {
                        list.add(threadInfo2);
                    }
                } else if (threadInfo2 != null && (l3 = threadInfo2.tid) != null && !hashSet.contains(l3) && !hashSet3.contains(threadInfo2.tid)) {
                    list.add(threadInfo2);
                    JSONObject b2 = b.a.r0.a3.l0.b.b(threadInfo2);
                    if (b2 != null) {
                        arrayList.add(b2);
                    }
                }
            }
        } else {
            this.f18945d.c(z, list);
            if (j()) {
                BannerList bannerList2 = builder.banner_list;
                if (bannerList2 != null && !ListUtils.isEmpty(bannerList2.app)) {
                    this.f18950i.addAll(0, builder.banner_list.app);
                    BannerList.Builder builder3 = new BannerList.Builder(builder.banner_list);
                    builder3.app = new LinkedList();
                    builder.banner_list = builder3.build(false);
                }
                this.f18949h.addAll(0, list);
                list.clear();
                hashSet.clear();
                hashSet2.clear();
                if (ListUtils.getCount(this.f18949h) > this.f18943b) {
                    for (int size = this.f18949h.size() - 1; size >= this.f18943b; size--) {
                        this.f18949h.remove(size);
                    }
                }
                hashSet3.clear();
                hashSet4.clear();
                Iterator<ThreadInfo> it2 = this.f18949h.iterator();
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
                    JSONObject b3 = b.a.r0.a3.l0.b.b(threadInfo3);
                    if (b3 != null) {
                        arrayList.add(0, b3);
                    }
                }
            }
        }
        if (j()) {
            if (!ListUtils.isEmpty(this.f18950i) && builder2.banner_list != null) {
                int count3 = ListUtils.getCount(list2) + ListUtils.getCount(builder2.banner_list.app);
                for (int i3 = 0; i3 < this.f18950i.size(); i3++) {
                    App app = this.f18950i.get(i3);
                    if (app != null) {
                        App.Builder builder4 = new App.Builder(app);
                        b.a.r0.a3.c.c(builder4, count3);
                        App build = builder4.build(false);
                        this.f18950i.remove(i3);
                        this.f18950i.add(i3, build);
                    }
                }
            }
            if (ListUtils.getCount(list) >= this.f18946e) {
                list.addAll(this.f18949h);
                this.f18949h.clear();
                BannerList.Builder builder5 = new BannerList.Builder(builder.banner_list);
                if (builder5.app == null) {
                    builder5.app = new LinkedList();
                }
                builder5.app.addAll(this.f18950i);
                builder.banner_list = builder5.build(false);
                this.f18950i.clear();
            }
        }
        int count4 = (ListUtils.getCount(list) + ListUtils.getCount(this.f18949h)) - count;
        this.f18942a.f18952b = count4;
        this.f18944c = count4;
        b.a.r0.a3.l0.b.f().h("NEWINDEX", arrayList);
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
        this.f18946e = intValue;
        int i3 = this.f18943b;
        if (intValue > i3) {
            intValue = i3;
        }
        this.f18946e = intValue;
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

    public final void p(List<q> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, list) == null) || list == null) {
            return;
        }
        Collections.sort(list, new a(this));
    }
}
