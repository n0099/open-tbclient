package c.a.p0.q1.i.k;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.o0.a.r;
import c.a.o0.r.r.n0;
import c.a.o0.r.r.o0;
import c.a.p0.h0.e0.k;
import c.a.p0.h0.e0.l;
import c.a.p0.h0.e0.m;
import c.a.p0.h0.e0.q;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final d a;

    /* renamed from: b  reason: collision with root package name */
    public final int f17460b;

    /* renamed from: c  reason: collision with root package name */
    public int f17461c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.q1.i.l.c f17462d;

    /* renamed from: e  reason: collision with root package name */
    public int f17463e;

    /* renamed from: f  reason: collision with root package name */
    public int f17464f;

    /* renamed from: g  reason: collision with root package name */
    public int f17465g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<ThreadInfo> f17466h;
    public ArrayList<App> i;
    public Long j;
    public List<n> k;

    /* loaded from: classes2.dex */
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

    /* renamed from: c.a.p0.q1.i.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1309b extends c.a.o0.e1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.h0.e0.b f17467h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1309b(b bVar, int i, String str, c.a.p0.h0.e0.b bVar2) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i), str, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17467h = bVar2;
        }

        @Override // c.a.o0.e1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view.getContext(), d(), null)));
                c.a.p0.h0.e0.b bVar = this.f17467h;
                if (bVar instanceof k) {
                    statisticItem = ((k) bVar).S();
                } else if (bVar instanceof l) {
                    statisticItem = ((l) bVar).Q(null);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17461c = 0;
        this.f17462d = new c.a.p0.q1.i.l.c();
        this.f17463e = 0;
        this.j = 0L;
        this.a = new d();
        this.f17460b = c.a.o0.r.j0.b.k().l("home_page_max_thread_count", 300);
        this.f17466h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.k = new ArrayList();
    }

    public final c.a.p0.q1.i.j.f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d dVar = this.a;
            if (dVar != null && !ListUtils.isEmpty(dVar.a)) {
                for (n nVar : this.a.a) {
                    if (nVar instanceof c.a.p0.q1.i.j.f) {
                        return (c.a.p0.q1.i.j.f) nVar;
                    }
                }
            }
            return null;
        }
        return (c.a.p0.q1.i.j.f) invokeV.objValue;
    }

    public final c.a.p0.q1.i.j.g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d dVar = this.a;
            if (dVar != null && !ListUtils.isEmpty(dVar.a)) {
                for (n nVar : this.a.a) {
                    if (nVar instanceof c.a.p0.q1.i.j.g) {
                        return (c.a.p0.q1.i.j.g) nVar;
                    }
                }
            }
            return null;
        }
        return (c.a.p0.q1.i.j.g) invokeV.objValue;
    }

    public d c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)})) == null) {
            if (i == 0 || i == 1) {
                if (builder == null) {
                    builder = new DataRes.Builder();
                }
                if (builder2 == null) {
                    builder2 = new DataRes.Builder();
                }
                e.c(builder);
                e.c(builder2);
                p(z, builder, builder2, i);
                List<ThreadInfo> q = q(builder, i, this.f17460b);
                e.n(builder);
                List<q> d2 = e.d(builder);
                s(d2);
                List<n> f2 = f(builder.thread_list, d2, builder2.user_follow_live, i, 0, builder2);
                List<n> f3 = f(q, new ArrayList(), builder2.user_follow_live, i, 1, null);
                this.f17462d.a(f2);
                c.c(builder, f2);
                d dVar = this.a;
                dVar.a = f2;
                dVar.f17469c = f3 == null ? 0 : f3.size();
                return this.a;
            }
            return null;
        }
        return (d) invokeCommon.objValue;
    }

    public List<ThreadInfo> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f17466h : (List) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f17460b : invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<n> f(List<ThreadInfo> list, List<q> list2, UserFollowLive userFollowLive, int i, int i2, DataRes.Builder builder) {
        InterceptResult invokeCommon;
        c.a.p0.q1.i.j.f a2;
        c.a.p0.q1.i.j.g gVar;
        boolean z;
        c.a.p0.h0.e0.b e2;
        k g2;
        ThreadRecommendInfoData threadRecommendInfoData;
        k g3;
        k g4;
        k g5;
        k g6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{list, list2, userFollowLive, Integer.valueOf(i), Integer.valueOf(i2), builder})) == null) {
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
                ThreadData threadData = new ThreadData();
                AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                threadData.isFromHomPage = true;
                threadData.parserProtobuf(threadInfo2);
                arrayList.add(threadData);
            }
            if (builder != null && c.a.p0.q1.d.f.c.q(builder.hot_recomforum, -1)) {
                c.a.p0.q1.d.f.c cVar = new c.a.p0.q1.d.f.c();
                cVar.floorPosition = builder.hot_recomforum.floor.intValue() > 0 ? builder.hot_recomforum.floor.intValue() - 1 : 0;
                if (cVar.k(builder.hot_recomforum.tab_list)) {
                    g(cVar, cVar.floorPosition, arrayList);
                }
            }
            if (i2 == 0 && UbsABTestHelper.isPersonalizeFunAdABTest()) {
                int f2 = c.a.o0.s.c.d.f();
                int e3 = c.a.o0.s.c.d.e();
                if (i == 0) {
                    e3 = c.a.o0.s.c.d.a();
                    this.k.clear();
                }
                h(e3, f2, arrayList);
            }
            LinkedList<n> linkedList = new LinkedList();
            int i3 = 0;
            for (n nVar : arrayList) {
                boolean z2 = nVar instanceof ThreadData;
                if (z2 && ((ThreadData) nVar).isFunAdPlaceHolder()) {
                    linkedList.add(nVar);
                } else if (z2) {
                    ThreadData threadData2 = (ThreadData) nVar;
                    if (!TextUtils.isEmpty(threadData2.getLegoCard())) {
                        o0 o0Var = new o0();
                        o0Var.i(threadData2.getLegoCard());
                        o0Var.position = i3;
                        linkedList.add(o0Var);
                    } else if (c.a.p0.q1.l.c.c.a.N(threadData2)) {
                        if (!StringUtils.isNull(threadData2.getTopicModule().topic_name)) {
                            c.a.p0.q1.l.c.c.a aVar = new c.a.p0.q1.l.c.c.a();
                            aVar.P(threadData2.getTopicModule());
                            aVar.Z = 1;
                            aVar.position = i3;
                            aVar.Q(threadData2);
                            aVar.setSupportType(BaseCardInfo.SupportType.FULL);
                            linkedList.add(aVar);
                        }
                    } else if (!k.W(threadData2) && !l.R(threadData2) && !m.W(threadData2)) {
                        if (c.a.p0.h0.e0.e.W(threadData2) && threadData2.isBJHArticleThreadType()) {
                            c.a.p0.h0.e0.e eVar = new c.a.p0.h0.e0.e(threadData2);
                            eVar.position = i3;
                            linkedList.add(eVar);
                        } else {
                            c.a.p0.h0.e0.b e4 = e.e(threadData2);
                            if (e4 != null) {
                                e4.f15321g = threadData2.getTid();
                                e4.position = i3;
                            }
                            if (e4 != null && e4.isValid()) {
                                linkedList.add(e4);
                            }
                        }
                    } else {
                        k g7 = e.g(threadData2);
                        if (g7 != null) {
                            if (threadData2.showCardEnterFourm()) {
                                if (g7.isValid()) {
                                    g7.f15321g = threadData2.getTid();
                                    g7.position = i3;
                                    e.t(g7);
                                    linkedList.add(g7);
                                }
                            } else {
                                ThreadData threadData3 = g7.a;
                                if (threadData3 != null && threadData3.getForumData() != null && !StringUtils.isNull(threadData3.getForumData().f10991b)) {
                                    g7.f15321g = threadData2.getTid();
                                    g7.position = i3;
                                    e.r(g7);
                                    linkedList.add(g7);
                                    z = true;
                                    e2 = e.e(threadData2);
                                    if (e2 != null) {
                                        e2.f15321g = threadData2.getTid();
                                        e2.position = i3;
                                        if (e2 instanceof k) {
                                            if (threadData2.isBJHNormalThreadType()) {
                                                e.u(e2);
                                            } else if (threadData2.picCount() == 1) {
                                                e.w(e2);
                                                int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                                                e2.j = imageWidthAndHeight[0];
                                                e2.k = imageWidthAndHeight[1];
                                            } else if (threadData2.picCount() >= 2) {
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
                                        e2.a.insertItemToTitleOrAbstractText();
                                        if (!threadData2.isUgcThreadType() && threadData2.getAuthor() != null && z) {
                                            String format = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f029a), threadData2.getAuthor().getName_show());
                                            SpannableString spannableString = new SpannableString(format);
                                            spannableString.setSpan(new C1309b(this, 16, threadData2.getAuthor().getUserId(), e2), 0, format.length() - 1, 33);
                                            e2.a.insertUsernameIntoTitleOrAbstract(spannableString);
                                        }
                                        linkedList.add(e2);
                                    }
                                    if (threadData2.getItem() != null && (g6 = e.g(threadData2)) != null) {
                                        g6.f15321g = threadData2.getTid();
                                        g6.position = i3;
                                        e.A(g6);
                                        if (!k.W(threadData2)) {
                                            g6.L("1");
                                        } else if (l.R(threadData2)) {
                                            g6.L("2");
                                        }
                                        linkedList.add(g6);
                                    }
                                    if ((ListUtils.isEmpty(threadData2.getLinkDataList()) || !ListUtils.isEmpty(threadData2.getGoodsDataList())) && (g2 = e.g(threadData2)) != null) {
                                        g2.f15321g = threadData2.getTid();
                                        g2.position = i3;
                                        if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) != 1) {
                                            e.D(g2);
                                        } else {
                                            e.B(g2);
                                        }
                                        linkedList.add(g2);
                                    }
                                    threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                                    if (threadRecommendInfoData != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason) && (g5 = e.g(threadData2)) != null) {
                                        g5.f15321g = threadData2.getTid();
                                        g5.position = i3;
                                        e.C(g5);
                                        if (g5.isValid()) {
                                            linkedList.add(g5);
                                        }
                                    }
                                    if (threadData2.showCardEnterFourm() && (g4 = e.g(threadData2)) != null) {
                                        g4.f15321g = threadData2.getTid();
                                        g4.position = i3;
                                        e.q(g4);
                                        if (!k.W(threadData2)) {
                                            g4.L("1");
                                        } else if (l.R(threadData2)) {
                                            g4.L("2");
                                        }
                                        if (!threadData2.showCardEnterFourm() && !StringUtils.isNull(threadData2.getForum_name())) {
                                            linkedList.add(g4);
                                        } else if (!StringUtils.isNull(threadData2.getForum_name())) {
                                            linkedList.add(g4);
                                        }
                                    }
                                    if (threadData2.getTopAgreePost() != null) {
                                        k g8 = e.g(threadData2);
                                        if (g8 != null) {
                                            g8.f15321g = threadData2.getTid();
                                            g8.position = i3;
                                            e.s(g8);
                                        }
                                        if (g8 != null && g8.isValid()) {
                                            linkedList.add(g8);
                                        }
                                    }
                                    g3 = e.g(threadData2);
                                    if (g3 != null) {
                                        g3.f15321g = threadData2.getTid();
                                        g3.position = i3;
                                        e.p(g3);
                                    }
                                    if (g3 != null && g3.isValid()) {
                                        linkedList.add(g3);
                                    }
                                } else if (g7.isValid()) {
                                    g7.f15321g = threadData2.getTid();
                                    g7.position = i3;
                                    e.t(g7);
                                    linkedList.add(g7);
                                }
                            }
                        }
                        z = false;
                        e2 = e.e(threadData2);
                        if (e2 != null) {
                        }
                        if (e2 instanceof m) {
                        }
                        if (e2 != null) {
                            e2.a.insertItemToTitleOrAbstractText();
                            if (!threadData2.isUgcThreadType()) {
                                String format2 = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f029a), threadData2.getAuthor().getName_show());
                                SpannableString spannableString2 = new SpannableString(format2);
                                spannableString2.setSpan(new C1309b(this, 16, threadData2.getAuthor().getUserId(), e2), 0, format2.length() - 1, 33);
                                e2.a.insertUsernameIntoTitleOrAbstract(spannableString2);
                            }
                            linkedList.add(e2);
                        }
                        if (threadData2.getItem() != null) {
                            g6.f15321g = threadData2.getTid();
                            g6.position = i3;
                            e.A(g6);
                            if (!k.W(threadData2)) {
                            }
                            linkedList.add(g6);
                        }
                        if (ListUtils.isEmpty(threadData2.getLinkDataList())) {
                        }
                        g2.f15321g = threadData2.getTid();
                        g2.position = i3;
                        if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) != 1) {
                        }
                        linkedList.add(g2);
                        threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                        if (threadRecommendInfoData != null) {
                            g5.f15321g = threadData2.getTid();
                            g5.position = i3;
                            e.C(g5);
                            if (g5.isValid()) {
                            }
                        }
                        if (threadData2.showCardEnterFourm()) {
                            g4.f15321g = threadData2.getTid();
                            g4.position = i3;
                            e.q(g4);
                            if (!k.W(threadData2)) {
                            }
                            if (!threadData2.showCardEnterFourm()) {
                            }
                            if (!StringUtils.isNull(threadData2.getForum_name())) {
                            }
                        }
                        if (threadData2.getTopAgreePost() != null) {
                        }
                        g3 = e.g(threadData2);
                        if (g3 != null) {
                        }
                        if (g3 != null) {
                            linkedList.add(g3);
                        }
                    }
                    long g9 = c.a.d.f.m.b.g(threadData2.getId(), 0L);
                    if (g9 != 0 && g9 == this.j.longValue()) {
                        if (builder.active_center != null) {
                            gVar = new c.a.p0.q1.i.j.g();
                            gVar.N(builder.active_center);
                        } else {
                            gVar = null;
                        }
                        if (gVar == null) {
                            gVar = b();
                        }
                        if (gVar != null) {
                            i3++;
                            gVar.R = i3;
                            linkedList.add(gVar);
                        }
                    }
                    i3++;
                } else if (nVar instanceof BaseCardInfo) {
                    linkedList.add(nVar);
                } else {
                    linkedList.add(nVar);
                }
                i3++;
            }
            if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
                int i4 = 0;
                int i5 = 0;
                for (int i6 = 0; i6 < ListUtils.getCount(list2); i6++) {
                    q qVar = (q) ListUtils.getItem(list2, i6);
                    if (qVar != null && i4 < linkedList.size()) {
                        while (i4 < linkedList.size() && (!(linkedList.get(i4) instanceof c.a.p0.h0.e0.b) || ((c.a.p0.h0.e0.b) linkedList.get(i4)).position + i5 != qVar.getPosition() - 1)) {
                            i4++;
                        }
                        if (linkedList.size() > i4 && i4 > 0) {
                            linkedList.add(i4, qVar);
                            i5++;
                        }
                    }
                }
                int i7 = 0;
                int i8 = 0;
                for (n nVar2 : linkedList) {
                    if (nVar2 instanceof n0) {
                        ((n0) nVar2).setPosition(i7 + 1);
                        i8++;
                    } else if (nVar2 instanceof BaseCardInfo) {
                        BaseCardInfo baseCardInfo = (BaseCardInfo) nVar2;
                        i7 = baseCardInfo.position + i8;
                        baseCardInfo.position = i7;
                    }
                }
            }
            if (i2 == 0) {
                if (i == 0 && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
                    c.a.p0.q1.i.j.f fVar = new c.a.p0.q1.i.j.f();
                    fVar.i(userFollowLive);
                    linkedList.add(0, fVar);
                    fVar.position = -1;
                } else if (i == 1 && (a2 = a()) != null) {
                    linkedList.add(0, a2);
                    a2.position = -1;
                }
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            return linkedList;
        }
        return (List) invokeCommon.objValue;
    }

    public void g(c.a.o0.r.r.a aVar, int i, List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048582, this, aVar, i, list) == null) || aVar == null || list == null || i <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    aVar.floorPosition = i;
                    ListUtils.add(list, i3, aVar);
                    return;
                }
                i2++;
            }
        }
    }

    public final void h(int i, int i2, List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, list) == null) || ListUtils.isEmpty(list) || i < 0 || i2 < 1) {
            return;
        }
        ListIterator<n> listIterator = list.listIterator();
        int i3 = 0;
        int i4 = 0;
        while (listIterator.hasNext()) {
            if (i3 == i || (i3 > i && (i3 - i) % i2 == 0)) {
                if (i4 < this.k.size()) {
                    listIterator.add(this.k.get(i4));
                } else {
                    ThreadData threadData = new ThreadData();
                    c.a.p0.a4.k0.n nVar = new c.a.p0.a4.k0.n();
                    nVar.k(true);
                    threadData.funAdData = nVar;
                    listIterator.add(threadData);
                    this.k.add(threadData);
                }
                i4++;
            }
            listIterator.next();
            i3++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
        if (r5.size() <= r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
        r5.add(r0, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
        r5.add(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i(List<n> list, c.a.p0.q1.d.f.c cVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, cVar, i) == null) || cVar == null || ListUtils.isEmpty(cVar.g())) {
            return;
        }
        int i2 = 0;
        if (list.size() > 0) {
            int i3 = 0;
            while (i3 < list.size() && ((!(list.get(i3) instanceof c.a.p0.h0.e0.b) || ((c.a.p0.h0.e0.b) list.get(i3)).position + 1 != i) && (!(list.get(i3) instanceof n0) || ((n0) list.get(i3)).h() + 1 != i))) {
                i3++;
            }
        }
        int i4 = 0;
        for (n nVar : list) {
            if (nVar instanceof c.a.p0.q1.d.f.c) {
                ((c.a.p0.q1.d.f.c) nVar).position = i2 + 1;
                i4++;
            } else if (nVar instanceof BaseCardInfo) {
                BaseCardInfo baseCardInfo = (BaseCardInfo) nVar;
                int i5 = baseCardInfo.position + i4;
                baseCardInfo.position = i5;
                i2 = i5;
            }
        }
    }

    public void j(List<n> list, c.a.p0.o3.e.a aVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048585, this, list, aVar, i) == null) || ListUtils.isEmpty(list) || aVar == null) {
            return;
        }
        r(list);
        if (i == 0) {
            i(list, c.a.p0.q1.d.f.c.e(aVar), aVar.a);
            return;
        }
        while (i < list.size() && !(list.get(i) instanceof c.a.p0.h0.e0.b) && !(list.get(i) instanceof n0)) {
            i++;
        }
        if (list.get(i) instanceof c.a.p0.h0.e0.b) {
            i(list, c.a.p0.q1.d.f.c.e(aVar), ((c.a.p0.h0.e0.b) list.get(i)).position + 2);
        } else if (list.get(i) instanceof n0) {
            i(list, c.a.p0.q1.d.f.c.e(aVar), ((n0) list.get(i)).h() + 2);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ArrayList<ThreadInfo> arrayList = this.f17466h;
            return (arrayList == null || ListUtils.isEmpty(arrayList)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f17463e > 0 : invokeV.booleanValue;
    }

    public final void m(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) {
            e.k(z, builder, builder2, i, this.f17461c, this.f17464f, this.f17465g);
        }
    }

    public final void n(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        List<ThreadInfo> list;
        List<ThreadInfo> list2;
        Long l;
        Long l2;
        Long l3;
        Long l4;
        Long l5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) || builder == null || builder2 == null || (list = builder.thread_list) == null || (list2 = builder2.thread_list) == null) {
            return;
        }
        this.f17464f = ListUtils.getCount(list);
        BannerList bannerList = builder.banner_list;
        if (bannerList != null) {
            this.f17465g = ListUtils.getCount(bannerList.app);
        } else {
            this.f17465g = 0;
        }
        int count = ListUtils.getCount(list) + ListUtils.getCount(this.f17466h);
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
        Iterator<ThreadInfo> it = this.f17466h.iterator();
        while (it.hasNext()) {
            ThreadInfo next = it.next();
            if (next != null && !TextUtils.isEmpty(next.lego_card)) {
                hashSet4.add(next.lego_card);
            } else if (next != null && (l4 = next.tid) != null) {
                hashSet3.add(l4);
            }
        }
        if (i == 1) {
            if (!ListUtils.isEmpty(list2)) {
                this.f17462d.b((ThreadInfo) ListUtils.getItem(list2, 0));
            }
            for (ThreadInfo threadInfo2 : list2) {
                if (threadInfo2 != null && !TextUtils.isEmpty(threadInfo2.lego_card)) {
                    if (!hashSet2.contains(threadInfo2.lego_card) && !hashSet4.contains(threadInfo2.lego_card)) {
                        list.add(threadInfo2);
                    }
                } else if (threadInfo2 != null && (l3 = threadInfo2.tid) != null && !hashSet.contains(l3) && !hashSet3.contains(threadInfo2.tid)) {
                    list.add(threadInfo2);
                    JSONObject b2 = c.a.p0.l3.m0.b.b(threadInfo2);
                    if (b2 != null) {
                        arrayList.add(b2);
                    }
                }
            }
        } else {
            this.f17462d.c(z, list);
            if (l()) {
                BannerList bannerList2 = builder.banner_list;
                if (bannerList2 != null && !ListUtils.isEmpty(bannerList2.app)) {
                    this.i.addAll(0, builder.banner_list.app);
                    BannerList.Builder builder3 = new BannerList.Builder(builder.banner_list);
                    builder3.app = new LinkedList();
                    builder.banner_list = builder3.build(false);
                }
                this.f17466h.addAll(0, list);
                list.clear();
                hashSet.clear();
                hashSet2.clear();
                if (ListUtils.getCount(this.f17466h) > this.f17460b) {
                    for (int size = this.f17466h.size() - 1; size >= this.f17460b; size--) {
                        this.f17466h.remove(size);
                    }
                }
                hashSet3.clear();
                hashSet4.clear();
                Iterator<ThreadInfo> it2 = this.f17466h.iterator();
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
                    JSONObject b3 = c.a.p0.l3.m0.b.b(threadInfo3);
                    if (b3 != null) {
                        arrayList.add(0, b3);
                    }
                }
            }
        }
        if (l()) {
            if (!ListUtils.isEmpty(this.i) && builder2.banner_list != null) {
                int count3 = ListUtils.getCount(list2) + ListUtils.getCount(builder2.banner_list.app);
                for (int i2 = 0; i2 < this.i.size(); i2++) {
                    App app = this.i.get(i2);
                    if (app != null) {
                        App.Builder builder4 = new App.Builder(app);
                        c.a.p0.l3.c.c(builder4, count3);
                        App build = builder4.build(false);
                        this.i.remove(i2);
                        this.i.add(i2, build);
                    }
                }
            }
            if (ListUtils.getCount(list) >= this.f17463e) {
                list.addAll(this.f17466h);
                this.f17466h.clear();
                BannerList.Builder builder5 = new BannerList.Builder(builder.banner_list);
                if (builder5.app == null) {
                    builder5.app = new LinkedList();
                }
                builder5.app.addAll(this.i);
                builder.banner_list = builder5.build(false);
                this.i.clear();
            }
        }
        int count4 = (ListUtils.getCount(list) + ListUtils.getCount(this.f17466h)) - count;
        this.a.f17468b = count4;
        this.f17461c = count4;
        c.a.p0.l3.m0.b.f().h("HOME", arrayList);
    }

    public final void o(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, list, list2) == null) || list == null || list2 == null) {
            return;
        }
        list.addAll(list2);
    }

    public final void p(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) || builder == null || builder2 == null) {
            return;
        }
        Integer num = builder2.fresh_ctrl_num;
        int intValue = (num == null || num.intValue() <= 0) ? 0 : builder2.fresh_ctrl_num.intValue();
        this.f17463e = intValue;
        int i2 = this.f17460b;
        if (intValue > i2) {
            intValue = i2;
        }
        this.f17463e = intValue;
        n(z, builder, builder2, i);
        m(z, builder, builder2, i);
        o(builder.thread_personalized, builder2.thread_personalized);
    }

    public final List<ThreadInfo> q(DataRes.Builder builder, int i, int i2) {
        InterceptResult invokeLII;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048592, this, builder, i, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (builder != null && (list = builder.thread_list) != null) {
                if (i == 1) {
                    for (int count = ((ListUtils.getCount(list) - i2) + 30) - 1; count >= 30; count--) {
                        if (list.size() > count) {
                            arrayList.add(list.remove(count));
                        }
                    }
                } else {
                    for (int count2 = ListUtils.getCount(list) - 1; count2 >= i2; count2--) {
                        list.remove(count2);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLII.objValue;
    }

    public final void r(List<n> list) {
        BaseCardInfo baseCardInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            Iterator<n> it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                n next = it.next();
                if ((next instanceof BaseCardInfo) && (i = (baseCardInfo = (BaseCardInfo) next).position) > 0) {
                    baseCardInfo.position = i - i2;
                }
                if (next instanceof c.a.p0.q1.d.f.c) {
                    it.remove();
                    i2++;
                }
            }
        }
    }

    public final void s(List<q> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, list) == null) || list == null) {
            return;
        }
        Collections.sort(list, new a(this));
    }
}
