package c.a.r0.p1.j;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.e2;
import c.a.r0.g0.d0;
import c.a.r0.g0.x;
import c.a.r0.p1.l.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h extends c.a.d.m.e.a<c.a.r0.g0.f0.k, CardViewHolder<x>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<HotTopicActivity> m;
    public BdUniqueId n;
    public c.a.r0.g0.f0.k o;
    public x p;
    public d0<e2> q;

    /* loaded from: classes6.dex */
    public class a extends d0<e2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f21057b;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21057b = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.g0.d0
        /* renamed from: d */
        public void a(View view, e2 e2Var) {
            c.a.r0.g0.f0.k kVar;
            d2 d2Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, e2Var) == null) || (kVar = this.f21057b.o) == null || (d2Var = kVar.f17245e) == null || StringUtils.isNull(d2Var.v1())) {
                return;
            }
            int i2 = 1;
            if ((this.f21057b.p.v() == null || view.getId() != this.f21057b.p.v().getId()) && (this.f21057b.p.w() == null || view.getId() != this.f21057b.p.w().getId())) {
                i2 = (this.f21057b.p.q == null || view.getId() != this.f21057b.p.q.getId()) ? 2 : 3;
            }
            String topicName = ((HotTopicActivity) this.f21057b.m.getOrignalPage()).getTopicName();
            String hotTopicId = ((HotTopicActivity) this.f21057b.m.getOrignalPage()).getHotTopicId();
            d2 threadData = kVar.getThreadData();
            TiebaStatic.log(new StatisticItem("c12941").param("obj_type", i2).param("tid", threadData.g0()));
            if ("c10814".equals(kVar.C())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                TiebaStatic.log(new StatisticItem("c10814").param("tid", threadData.g0()).param("obj_name", topicName).param("topic_id", hotTopicId));
            } else if ("c10816".equals(kVar.C())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                TiebaStatic.log(new StatisticItem("c10816").param("post_id", threadData.v1()).param("obj_name", topicName).param("topic_id", hotTopicId));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.m = tbPageContext;
        this.n = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: j0 */
    public CardViewHolder<x> S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            x xVar = new x(this.m);
            this.p = xVar;
            xVar.C(this.n);
            this.p.E(false);
            x xVar2 = this.p;
            xVar2.l = 0;
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = xVar2.r;
            if (threadCommentAndPraiseInfoLayout != null) {
                threadCommentAndPraiseInfoLayout.sourceFromForPb = 0;
            }
            OriginalThreadCardView originalThreadCardView = this.p.q;
            if (originalThreadCardView != null) {
                originalThreadCardView.sourceFormForPb = 0;
            }
            return new CardViewHolder<>(this.p);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: k0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c.a.r0.g0.f0.k kVar, CardViewHolder<x> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, cardViewHolder})) == null) {
            if (kVar == null || cardViewHolder == null || cardViewHolder.getCardView() == null) {
                return null;
            }
            this.o = kVar;
            cardViewHolder.getCardView().k(new e2(kVar.getThreadData()));
            cardViewHolder.getCardView().m(this.q);
            ((x) ((CardViewHolder) this.f2913k).getCardView()).D(!(z(i2 + 1) instanceof n));
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
