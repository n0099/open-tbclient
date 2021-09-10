package c.a.r0.g1.c.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.r0.a0.b0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes3.dex */
public class a extends c.a.e.l.e.a<c.a.r0.a0.d0.j, CardViewHolder<c.a.r0.a0.j>> implements c.a.r0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public c.a.r0.a0.j o;
    public String p;
    public b0 q;

    /* renamed from: c.a.r0.g1.c.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0869a extends b0<c.a.r0.a0.d0.j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f17824b;

        public C0869a(a aVar) {
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
                    return;
                }
            }
            this.f17824b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a0.b0
        /* renamed from: d */
        public void a(View view, c.a.r0.a0.d0.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, jVar) == null) || view == null || this.f17824b.o == null || this.f17824b.o.j() == null || jVar == null || jVar.getThreadData() == null || StringUtils.isNull(jVar.getThreadData().s1())) {
                return;
            }
            c.a.r0.g1.c.c.b(view, jVar, view == this.f17824b.o.N() ? 1 : 2);
            if (view == this.f17824b.o.p.getCommentContainer() || view == this.f17824b.o.q.getCommentContainer()) {
                StatisticItem statisticItem = new StatisticItem("c12942");
                statisticItem.param("obj_locate", 7);
                statisticItem.param("obj_type", 5);
                statisticItem.param("tid", jVar.getThreadData().s1());
                statisticItem.param("nid", jVar.getThreadData().F0());
                c.a.q0.m0.c f2 = TbPageExtraHelper.f(view);
                if (f2 != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
                }
                if (TbPageExtraHelper.m() != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.q = new C0869a(this);
        this.n = tbPageContext;
    }

    @Override // c.a.r0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.p = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: i0 */
    public CardViewHolder<c.a.r0.a0.j> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            c.a.r0.a0.j jVar = new c.a.r0.a0.j(this.n, this.m);
            this.o = jVar;
            jVar.V(true);
            BdUniqueId bdUniqueId = this.m;
            if (bdUniqueId != null) {
                this.o.U(bdUniqueId);
            }
            return new CardViewHolder<>(this.o);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: j0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.r0.a0.d0.j jVar, CardViewHolder<c.a.r0.a0.j> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, jVar, cardViewHolder})) == null) {
            if (jVar == null || cardViewHolder == null || cardViewHolder.getCardView() == null) {
                return null;
            }
            jVar.K(i2 + 1);
            StatisticItem b0 = jVar.b0("c12351");
            if (jVar.getThreadData() != null && jVar.getThreadData().l1() != null) {
                int calculateLiveType = YYLiveUtil.calculateLiveType(jVar.getThreadData().l1());
                if (jVar.getThreadData().l1().mYyExtData != null) {
                    TiebaStaticHelper.addYYParam(b0, jVar.getThreadData().l1().mYyExtData);
                }
                b0.param(TiebaStatic.Params.OBJ_PARAM3, calculateLiveType);
            }
            c.a.r0.a0.t.b().a(b0);
            if (cardViewHolder.getCardView() instanceof c.a.r0.o.e) {
                cardViewHolder.getCardView().setPage(this.p);
            }
            cardViewHolder.getCardView().k(jVar);
            cardViewHolder.getCardView().m(this.q);
            if (jVar.getThreadData() != null && jVar.getThreadData().l1() != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_SHOW);
                statisticItem.param("obj_locate", 2);
                statisticItem.param("obj_param1", jVar.getThreadData().l1().live_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
            }
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
