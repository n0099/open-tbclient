package c.a.r0.o1.d.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.q0.r.r.e2;
import c.a.r0.f0.b0;
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
/* loaded from: classes2.dex */
public class b extends c.a.d.o.e.a<c.a.r0.f0.d0.j, CardViewHolder<c.a.r0.f0.k>> implements c.a.r0.t.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public c.a.r0.f0.k o;
    public String p;
    public b0 q;

    /* loaded from: classes2.dex */
    public class a extends b0<c.a.r0.f0.d0.j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f19702b;

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
            this.f19702b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.f0.b0
        /* renamed from: d */
        public void a(View view, c.a.r0.f0.d0.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, jVar) == null) || view == null || this.f19702b.o == null || this.f19702b.o.j() == null || jVar == null || jVar.getThreadData() == null || StringUtils.isNull(jVar.getThreadData().w1())) {
                return;
            }
            c.a.r0.o1.d.c.b(view, jVar, view == this.f19702b.o.K() ? 1 : 2);
            if (view != this.f19702b.o.p.getCommentContainer() && view != this.f19702b.o.q.getCommentContainer()) {
                if (this.f19702b.o.K() == null || view.getId() != this.f19702b.o.K().getId() || jVar.getThreadData() == null || jVar.getThreadData().p1() == null || !jVar.getThreadData().p1().isLegalYYLiveData()) {
                    return;
                }
                e2 threadData = jVar.getThreadData();
                AlaInfoData p1 = threadData.p1();
                int calculateLiveType = YYLiveUtil.calculateLiveType(jVar.getThreadData().p1());
                String str = StringUtils.isNull(jVar.getThreadData().p1().appId) ? null : jVar.getThreadData().p1().appId;
                if (jVar.getThreadData().p1().mYyExtData != null) {
                    str = TiebaStatic.YYValues.YY_LIVE;
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CONCERN_YY_LIVE_AVATER_CLICK);
                statisticItem.param("fid", threadData.U());
                statisticItem.param("fname", threadData.b0());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", threadData.w1());
                statisticItem.param("obj_type", threadData.I1());
                statisticItem.param("obj_param1", calculateLiveType);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                TiebaStaticHelper.addYYParam(statisticItem, p1.mYyExtData);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c12942");
            statisticItem2.param("obj_locate", 7);
            statisticItem2.param("obj_type", 5);
            statisticItem2.param("tid", jVar.getThreadData().w1());
            statisticItem2.param("nid", jVar.getThreadData().H0());
            c.a.q0.n0.c findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view);
            if (findPageExtraByView != null) {
                statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: a0 */
    public CardViewHolder<c.a.r0.f0.k> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            c.a.r0.f0.k kVar = new c.a.r0.f0.k(this.n, this.m);
            this.o = kVar;
            kVar.X(true);
            BdUniqueId bdUniqueId = this.m;
            if (bdUniqueId != null) {
                this.o.W(bdUniqueId);
            }
            return new CardViewHolder<>(this.o);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: b0 */
    public View S(int i2, View view, ViewGroup viewGroup, c.a.r0.f0.d0.j jVar, CardViewHolder<c.a.r0.f0.k> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, jVar, cardViewHolder})) == null) {
            if (jVar == null || cardViewHolder == null || cardViewHolder.getCardView() == null) {
                return null;
            }
            jVar.J(i2 + 1);
            int i3 = 0;
            StatisticItem a0 = jVar.a0("c12351");
            if (jVar.getThreadData() != null && jVar.getThreadData().p1() != null) {
                i3 = YYLiveUtil.calculateLiveType(jVar.getThreadData().p1());
                if (jVar.getThreadData().p1().mYyExtData != null) {
                    TiebaStaticHelper.addYYParam(a0, jVar.getThreadData().p1().mYyExtData);
                }
                a0.param(TiebaStatic.Params.OBJ_PARAM3, i3);
            }
            c.a.r0.f0.u.b().a(a0);
            if (cardViewHolder.getCardView() instanceof c.a.r0.t.e) {
                cardViewHolder.getCardView().d(this.p);
            }
            cardViewHolder.getCardView().k(jVar);
            cardViewHolder.getCardView().m(this.q);
            if (jVar.getThreadData() != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CONCERN_YY_LIVE_AVATER_SHOW);
                statisticItem.param("fid", jVar.getThreadData().U());
                statisticItem.param("fname", jVar.getThreadData().b0());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", jVar.getThreadData().w1());
                if (jVar.getThreadData().p1() != null) {
                    String str = StringUtils.isNull(jVar.getThreadData().p1().appId) ? null : jVar.getThreadData().p1().appId;
                    if (jVar.getThreadData().p1().mYyExtData != null) {
                        str = TiebaStatic.YYValues.YY_LIVE;
                    }
                    statisticItem.param("obj_param1", i3);
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                    TiebaStaticHelper.addYYParam(statisticItem, jVar.getThreadData().p1().mYyExtData);
                }
                TiebaStatic.log(statisticItem);
            }
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.r0.t.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.p = str;
        }
    }
}
