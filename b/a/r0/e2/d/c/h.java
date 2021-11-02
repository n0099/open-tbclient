package b.a.r0.e2.d.c;

import android.view.View;
import android.view.ViewGroup;
import b.a.e.l.e.n;
import b.a.e.l.e.s;
import b.a.e.l.e.w;
import b.a.l.l0;
import b.a.l.n0;
import b.a.l.v0.a;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.r0.b0.c0;
import b.a.r0.b0.u;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class h extends b.a.r0.e2.d.c.a<c2, ThreadCardViewHolder<d2>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId o;
    public TbPageContext<?> p;
    public s q;
    public c0<c2> r;

    /* loaded from: classes4.dex */
    public class a extends c0<c2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f16260b;

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
            this.f16260b = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, c2 c2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, c2Var) == null) || c2Var == null) {
                return;
            }
            u.b().d(true);
            this.f16260b.n0(view, c2Var.w);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f16261e;

        public b(h hVar) {
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
            this.f16261e = hVar;
        }

        @Override // b.a.e.l.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof c2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                c2 c2Var = (c2) nVar;
                d2 d2Var = c2Var.w;
                d2Var.objType = 1;
                if (this.f16261e.r != null) {
                    this.f16261e.r.a(threadCardViewHolder.getView(), c2Var);
                }
                ThreadCardUtils.jumpToPB(d2Var, view.getContext(), 17, false, b.a.l.e.a((s) viewGroup, view, i2), this.f16261e.n.getOrignalPage().getTopicId(), this.f16261e.g0() ? "3" : "2");
                threadCardViewHolder.getCardView().n(new a.C0090a(1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f16262a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f16263b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f16264c;

        public c(h hVar, ViewGroup viewGroup, View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, viewGroup, view, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16262a = viewGroup;
            this.f16263b = view;
            this.f16264c = i2;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(b.a.l.e.a((s) this.f16262a, this.f16263b, this.f16264c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.r = new a(this);
        this.p = tbPageContext;
        this.o = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: l0 */
    public ThreadCardViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.p.getPageActivity(), false);
            n0 n0Var = new n0(this.p.getPageActivity());
            b.a.q0.s.q.f fVar = new b.a.q0.s.q.f();
            fVar.f13300b = 22;
            fVar.f13306h = 19;
            n0Var.u(fVar);
            n0Var.v(18);
            n0Var.A("personalize_page");
            n0Var.z(18);
            n0Var.w(17);
            n0Var.a(32);
            bVar.m(n0Var);
            l0 k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.q);
            k.q(17);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.setPageId(this.o);
            c0(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: m0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c2 c2Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, c2Var, threadCardViewHolder})) == null) {
            if (c2Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || (d2Var = c2Var.w) == null) {
                return null;
            }
            d2Var.T1 = D(i2) + 1;
            threadCardViewHolder.getCardView().p(i2);
            if (threadCardViewHolder.getCardView().e() instanceof n0) {
                ((n0) threadCardViewHolder.getCardView().e()).y(new c(this, viewGroup, view, i2));
            }
            threadCardViewHolder.onBindDataToView(c2Var);
            threadCardViewHolder.getCardView().onChangeSkinType(this.p, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().o(this.r);
            b.a.r0.e2.c.c(this, c2Var);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void n0(View view, d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view, d2Var) == null) {
            b.a.r0.e2.c.b(this, d2Var);
        }
    }

    public void o0(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sVar) == null) {
            this.q = sVar;
        }
    }
}
