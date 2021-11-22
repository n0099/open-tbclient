package b.a.r0.h1.c.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.a.q0.s.q.d2;
import b.a.r0.b0.d0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b extends b.a.e.m.e.a<b.a.r0.b0.f0.j, CardViewHolder<b.a.r0.b0.k>> implements b.a.r0.p.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public b.a.r0.b0.k o;
    public String p;
    public d0 q;

    /* loaded from: classes4.dex */
    public class a extends d0<b.a.r0.b0.f0.j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f18419b;

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
                    return;
                }
            }
            this.f18419b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.d0
        /* renamed from: d */
        public void a(View view, b.a.r0.b0.f0.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, jVar) == null) || view == null || this.f18419b.o == null || this.f18419b.o.i() == null || jVar == null || jVar.getThreadData() == null || StringUtils.isNull(jVar.getThreadData().t1())) {
                return;
            }
            b.a.r0.h1.c.c.b(view, jVar, view == this.f18419b.o.Q() ? 1 : 2);
            if (view != this.f18419b.o.p.getCommentContainer() && view != this.f18419b.o.q.getCommentContainer()) {
                if (this.f18419b.o.Q() == null || view.getId() != this.f18419b.o.Q().getId() || jVar.getThreadData() == null || jVar.getThreadData().m1() == null || !jVar.getThreadData().m1().isLegalYYLiveData()) {
                    return;
                }
                d2 threadData = jVar.getThreadData();
                AlaInfoData m1 = threadData.m1();
                int calculateLiveType = YYLiveUtil.calculateLiveType(jVar.getThreadData().m1());
                String str = StringUtils.isNull(jVar.getThreadData().m1().appId) ? null : jVar.getThreadData().m1().appId;
                if (jVar.getThreadData().m1().mYyExtData != null) {
                    str = TiebaStatic.YYValues.YY_LIVE;
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CONCERN_YY_LIVE_AVATER_CLICK);
                statisticItem.param("fid", threadData.T());
                statisticItem.param("fname", threadData.Z());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", threadData.t1());
                statisticItem.param("obj_type", threadData.G1());
                statisticItem.param("obj_param1", calculateLiveType);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                TiebaStaticHelper.addYYParam(statisticItem, m1.mYyExtData);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c12942");
            statisticItem2.param("obj_locate", 7);
            statisticItem2.param("obj_type", 5);
            statisticItem2.param("tid", jVar.getThreadData().t1());
            statisticItem2.param("nid", jVar.getThreadData().F0());
            b.a.q0.m0.c f2 = TbPageExtraHelper.f(view);
            if (f2 != null) {
                statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
            }
            if (TbPageExtraHelper.m() != null) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            TiebaStatic.log(statisticItem2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new a(this);
        this.n = tbPageContext;
    }

    @Override // b.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.p = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: h0 */
    public CardViewHolder<b.a.r0.b0.k> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            b.a.r0.b0.k kVar = new b.a.r0.b0.k(this.n, this.m);
            this.o = kVar;
            kVar.f0(true);
            BdUniqueId bdUniqueId = this.m;
            if (bdUniqueId != null) {
                this.o.e0(bdUniqueId);
            }
            return new CardViewHolder<>(this.o);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: i0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.b0.f0.j jVar, CardViewHolder<b.a.r0.b0.k> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, jVar, cardViewHolder})) == null) {
            if (jVar == null || cardViewHolder == null || cardViewHolder.getCardView() == null) {
                return null;
            }
            jVar.K(i2 + 1);
            int i3 = 0;
            StatisticItem b0 = jVar.b0("c12351");
            if (jVar.getThreadData() != null && jVar.getThreadData().m1() != null) {
                i3 = YYLiveUtil.calculateLiveType(jVar.getThreadData().m1());
                if (jVar.getThreadData().m1().mYyExtData != null) {
                    TiebaStaticHelper.addYYParam(b0, jVar.getThreadData().m1().mYyExtData);
                }
                b0.param(TiebaStatic.Params.OBJ_PARAM3, i3);
            }
            b.a.r0.b0.v.b().a(b0);
            if (cardViewHolder.getCardView() instanceof b.a.r0.p.e) {
                cardViewHolder.getCardView().setPage(this.p);
            }
            cardViewHolder.getCardView().j(jVar);
            cardViewHolder.getCardView().l(this.q);
            if (jVar.getThreadData() != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CONCERN_YY_LIVE_AVATER_SHOW);
                statisticItem.param("fid", jVar.getThreadData().T());
                statisticItem.param("fname", jVar.getThreadData().Z());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", jVar.getThreadData().t1());
                if (jVar.getThreadData().m1() != null) {
                    String str = StringUtils.isNull(jVar.getThreadData().m1().appId) ? null : jVar.getThreadData().m1().appId;
                    if (jVar.getThreadData().m1().mYyExtData != null) {
                        str = TiebaStatic.YYValues.YY_LIVE;
                    }
                    statisticItem.param("obj_param1", i3);
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                    TiebaStaticHelper.addYYParam(statisticItem, jVar.getThreadData().m1().mYyExtData);
                }
                TiebaStatic.log(statisticItem);
            }
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
