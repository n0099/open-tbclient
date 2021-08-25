package c.a.q0.h1.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.d2;
import c.a.q0.a0.b0;
import c.a.q0.a0.v;
import c.a.q0.h1.c.n;
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
/* loaded from: classes3.dex */
public class h extends c.a.e.l.e.a<c.a.q0.a0.d0.k, CardViewHolder<v>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<HotTopicActivity> m;
    public BdUniqueId n;
    public c.a.q0.a0.d0.k o;
    public v p;
    public b0<d2> q;

    /* loaded from: classes3.dex */
    public class a extends b0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f18523b;

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
            this.f18523b = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            c.a.q0.a0.d0.k kVar;
            c2 c2Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) || (kVar = this.f18523b.o) == null || (c2Var = kVar.f15245e) == null || StringUtils.isNull(c2Var.q1())) {
                return;
            }
            int i2 = 1;
            if ((this.f18523b.p.v() == null || view.getId() != this.f18523b.p.v().getId()) && (this.f18523b.p.w() == null || view.getId() != this.f18523b.p.w().getId())) {
                i2 = (this.f18523b.p.q == null || view.getId() != this.f18523b.p.q.getId()) ? 2 : 3;
            }
            String topicName = ((HotTopicActivity) this.f18523b.m.getOrignalPage()).getTopicName();
            String hotTopicId = ((HotTopicActivity) this.f18523b.m.getOrignalPage()).getHotTopicId();
            c2 threadData = kVar.getThreadData();
            TiebaStatic.log(new StatisticItem("c12941").param("obj_type", i2).param("tid", threadData.f0()));
            if ("c10814".equals(kVar.C())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                TiebaStatic.log(new StatisticItem("c10814").param("tid", threadData.f0()).param("obj_name", topicName).param("topic_id", hotTopicId));
            } else if ("c10816".equals(kVar.C())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                TiebaStatic.log(new StatisticItem("c10816").param("post_id", threadData.q1()).param("obj_name", topicName).param("topic_id", hotTopicId));
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
    @Override // c.a.e.l.e.a
    /* renamed from: k0 */
    public CardViewHolder<v> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            v vVar = new v(this.m);
            this.p = vVar;
            vVar.D(this.n);
            this.p.K(false);
            v vVar2 = this.p;
            vVar2.l = 0;
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = vVar2.r;
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
    @Override // c.a.e.l.e.a
    /* renamed from: l0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.q0.a0.d0.k kVar, CardViewHolder<v> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, cardViewHolder})) == null) {
            if (kVar == null || cardViewHolder == null || cardViewHolder.getCardView() == null) {
                return null;
            }
            this.o = kVar;
            cardViewHolder.getCardView().k(new d2(kVar.getThreadData()));
            cardViewHolder.getCardView().m(this.q);
            ((v) ((CardViewHolder) this.k).getCardView()).J(!(z(i2 + 1) instanceof n));
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
