package c.a.t0.n2.d.c;

import android.view.View;
import android.view.ViewGroup;
import c.a.d.n.e.n;
import c.a.d.n.e.s;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.w0.a;
import c.a.s0.s.q.e2;
import c.a.t0.g0.d0;
import c.a.t0.g0.v;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b extends c.a.t0.n2.d.c.a<e2, ThreadCardViewHolder<e2>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId o;
    public TbPageContext<?> p;
    public NEGFeedBackView.b q;
    public s r;
    public d0<e2> s;

    /* loaded from: classes7.dex */
    public class a extends d0<e2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f19704b;

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
            this.f19704b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.g0.d0
        /* renamed from: d */
        public void a(View view, e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, e2Var) == null) {
                v.b().d(true);
                c.a.t0.t.d.c().h("page_recommend", "show_");
                if (view == null || e2Var == null || e2Var.getThreadData() == null || StringUtils.isNull(e2Var.getThreadData().w1())) {
                    return;
                }
                this.f19704b.h0(view, e2Var);
            }
        }
    }

    /* renamed from: c.a.t0.n2.d.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1227b implements c.a.d.n.e.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19705e;

        public C1227b(b bVar) {
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
            this.f19705e = bVar;
        }

        @Override // c.a.d.n.e.v
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                this.f19705e.e0(view, nVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = new a(this);
        this.p = tbPageContext;
        this.o = bdUniqueId2;
    }

    public final void e0(View view, n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, nVar) == null) && (nVar instanceof c.a.t0.g0.f0.e) && (view.getTag() instanceof ThreadCardViewHolder)) {
            ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
            c.a.t0.g0.f0.e eVar = (c.a.t0.g0.f0.e) nVar;
            eVar.k = 1;
            ThreadCardUtils.jumpToPB(eVar, view.getContext(), 17, false, this.n.getOrignalPage().getTopicId(), Z() ? "3" : "2");
            threadCardViewHolder.getCardView().o(new a.C0204a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: f0 */
    public ThreadCardViewHolder<e2> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.p.getPageActivity());
            c.a.l.d dVar = new c.a.l.d(this.p.getPageActivity());
            dVar.s(this.o);
            dVar.u(this.p);
            bVar.o(dVar);
            bVar.n(new c.a.l.b(this.p.getPageActivity()));
            bVar.h(new c.a.l.k(this.p.getPageActivity()));
            n0 n0Var = new n0(this.p.getPageActivity());
            c.a.s0.s.q.f fVar = new c.a.s0.s.q.f();
            fVar.f13557b = 1;
            fVar.f13563h = 1;
            n0Var.u(fVar);
            n0Var.v(1);
            n0Var.z(3);
            n0Var.w(17);
            bVar.m(n0Var);
            l0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.r);
            k.r(17);
            ThreadCardViewHolder<e2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.o);
            V(new C1227b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: g0 */
    public View S(int i2, View view, ViewGroup viewGroup, e2 e2Var, ThreadCardViewHolder<e2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, e2Var, threadCardViewHolder})) == null) {
            if (e2Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            e2Var.T1 = C(i2) + 1;
            threadCardViewHolder.getCardView().q(i2);
            threadCardViewHolder.showNEGFeedBackView(true).t(this.q);
            threadCardViewHolder.showUnfollowedDecorItemIfNeed(true, Align.ALIGN_RIGHT_BOTTOM);
            threadCardViewHolder.onBindDataToView(e2Var);
            threadCardViewHolder.getCardView().p(this.s);
            threadCardViewHolder.getCardView().onChangeSkinType(this.p, TbadkCoreApplication.getInst().getSkinType());
            c.a.t0.n2.c.c(this, e2Var);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void h0(View view, e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view, e2Var) == null) {
            c.a.t0.n2.c.b(this, e2Var);
        }
    }

    public void i0(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sVar) == null) {
            this.r = sVar;
        }
    }
}
