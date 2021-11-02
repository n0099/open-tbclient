package b.a.r0.j1.j;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.e2;
import b.a.r0.b0.c0;
import b.a.r0.b0.w;
import b.a.r0.j1.l.n;
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
/* loaded from: classes4.dex */
public class h extends b.a.e.l.e.a<b.a.r0.b0.e0.k, CardViewHolder<w>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<HotTopicActivity> m;
    public BdUniqueId n;
    public b.a.r0.b0.e0.k o;
    public w p;
    public c0<e2> q;

    /* loaded from: classes4.dex */
    public class a extends c0<e2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f18353b;

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
            this.f18353b = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, e2 e2Var) {
            b.a.r0.b0.e0.k kVar;
            d2 d2Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, e2Var) == null) || (kVar = this.f18353b.o) == null || (d2Var = kVar.f14748e) == null || StringUtils.isNull(d2Var.s1())) {
                return;
            }
            int i2 = 1;
            if ((this.f18353b.p.u() == null || view.getId() != this.f18353b.p.u().getId()) && (this.f18353b.p.v() == null || view.getId() != this.f18353b.p.v().getId())) {
                i2 = (this.f18353b.p.q == null || view.getId() != this.f18353b.p.q.getId()) ? 2 : 3;
            }
            String topicName = ((HotTopicActivity) this.f18353b.m.getOrignalPage()).getTopicName();
            String hotTopicId = ((HotTopicActivity) this.f18353b.m.getOrignalPage()).getHotTopicId();
            d2 threadData = kVar.getThreadData();
            TiebaStatic.log(new StatisticItem("c12941").param("obj_type", i2).param("tid", threadData.f0()));
            if ("c10814".equals(kVar.C())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                TiebaStatic.log(new StatisticItem("c10814").param("tid", threadData.f0()).param("obj_name", topicName).param("topic_id", hotTopicId));
            } else if ("c10816".equals(kVar.C())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                TiebaStatic.log(new StatisticItem("c10816").param("post_id", threadData.s1()).param("obj_name", topicName).param("topic_id", hotTopicId));
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
    @Override // b.a.e.l.e.a
    /* renamed from: j0 */
    public CardViewHolder<w> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            w wVar = new w(this.m);
            this.p = wVar;
            wVar.B(this.n);
            this.p.I(false);
            w wVar2 = this.p;
            wVar2.l = 0;
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = wVar2.r;
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
    @Override // b.a.e.l.e.a
    /* renamed from: k0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.b0.e0.k kVar, CardViewHolder<w> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, cardViewHolder})) == null) {
            if (kVar == null || cardViewHolder == null || cardViewHolder.getCardView() == null) {
                return null;
            }
            this.o = kVar;
            cardViewHolder.getCardView().j(new e2(kVar.getThreadData()));
            cardViewHolder.getCardView().l(this.q);
            ((w) ((CardViewHolder) this.k).getCardView()).D(!(z(i2 + 1) instanceof n));
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
