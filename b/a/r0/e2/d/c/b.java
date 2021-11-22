package b.a.r0.e2.d.c;

import android.view.View;
import android.view.ViewGroup;
import b.a.e.m.e.n;
import b.a.e.m.e.s;
import b.a.e.m.e.w;
import b.a.l.l0;
import b.a.l.n0;
import b.a.l.w0.a;
import b.a.q0.s.q.d2;
import b.a.r0.b0.d0;
import b.a.r0.b0.v;
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
/* loaded from: classes4.dex */
public class b extends b.a.r0.e2.d.c.a<d2, ThreadCardViewHolder<d2>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId o;
    public TbPageContext<?> p;
    public NEGFeedBackView.b q;
    public s r;
    public d0<d2> s;

    /* loaded from: classes4.dex */
    public class a extends d0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f17259b;

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
            this.f17259b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.d0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) {
                v.b().d(true);
                b.a.r0.p.d.c().h("page_recommend", "show_");
                if (view == null || d2Var == null || d2Var.getThreadData() == null || StringUtils.isNull(d2Var.getThreadData().t1())) {
                    return;
                }
                this.f17259b.o0(view, d2Var);
            }
        }
    }

    /* renamed from: b.a.r0.e2.d.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0868b implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17260e;

        public C0868b(b bVar) {
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
            this.f17260e = bVar;
        }

        @Override // b.a.e.m.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                this.f17260e.l0(view, nVar);
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

    public final void l0(View view, n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, nVar) == null) && (nVar instanceof b.a.r0.b0.f0.e) && (view.getTag() instanceof ThreadCardViewHolder)) {
            ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
            b.a.r0.b0.f0.e eVar = (b.a.r0.b0.f0.e) nVar;
            eVar.k = 1;
            ThreadCardUtils.jumpToPB(eVar, view.getContext(), 17, false, this.n.getOrignalPage().getTopicId(), g0() ? "3" : "2");
            threadCardViewHolder.getCardView().n(new a.C0092a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: m0 */
    public ThreadCardViewHolder<d2> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.p.getPageActivity());
            b.a.l.d dVar = new b.a.l.d(this.p.getPageActivity());
            dVar.s(this.o);
            dVar.u(this.p);
            bVar.o(dVar);
            bVar.n(new b.a.l.b(this.p.getPageActivity()));
            bVar.h(new b.a.l.k(this.p.getPageActivity()));
            n0 n0Var = new n0(this.p.getPageActivity());
            b.a.q0.s.q.f fVar = new b.a.q0.s.q.f();
            fVar.f14080b = 1;
            fVar.f14086h = 1;
            n0Var.u(fVar);
            n0Var.v(1);
            n0Var.z(3);
            n0Var.w(17);
            bVar.m(n0Var);
            l0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.r);
            k.q(17);
            ThreadCardViewHolder<d2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.o);
            c0(new C0868b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: n0 */
    public View Z(int i2, View view, ViewGroup viewGroup, d2 d2Var, ThreadCardViewHolder<d2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, d2Var, threadCardViewHolder})) == null) {
            if (d2Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            d2Var.T1 = D(i2) + 1;
            threadCardViewHolder.getCardView().p(i2);
            threadCardViewHolder.showNEGFeedBackView(true).t(this.q);
            threadCardViewHolder.showUnfollowedDecorItemIfNeed(true, Align.ALIGN_RIGHT_BOTTOM);
            threadCardViewHolder.onBindDataToView(d2Var);
            threadCardViewHolder.getCardView().o(this.s);
            threadCardViewHolder.getCardView().onChangeSkinType(this.p, TbadkCoreApplication.getInst().getSkinType());
            b.a.r0.e2.c.c(this, d2Var);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void o0(View view, d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view, d2Var) == null) {
            b.a.r0.e2.c.b(this, d2Var);
        }
    }

    public void p0(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sVar) == null) {
            this.r = sVar;
        }
    }
}
