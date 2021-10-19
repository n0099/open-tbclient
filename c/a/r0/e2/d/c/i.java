package c.a.r0.e2.d.c;

import android.view.View;
import android.view.ViewGroup;
import c.a.e.l.e.n;
import c.a.e.l.e.w;
import c.a.l.d;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.p0;
import c.a.l.q0;
import c.a.l.v0.a;
import c.a.r0.b0.c0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class i extends c.a.r0.e2.d.c.a<c.a.r0.b0.e0.k, ThreadCardViewHolder<c.a.r0.b0.e0.k>> implements c.a.r0.p.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId o;
    public TbPageContext<?> p;
    public String q;
    public boolean r;
    public c0<c.a.r0.b0.e0.k> s;

    /* loaded from: classes3.dex */
    public class a extends c0<c.a.r0.b0.e0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f17290b;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17290b = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, c.a.r0.b0.e0.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) {
                c.a.r0.e2.c.b(this.f17290b, kVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.l.d.b
        public void a(c.a.q0.s.q.a aVar, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, view) == null) || aVar == null) {
                return;
            }
            if (view.getId() == R.id.user_name) {
                aVar.objType = 3;
            } else if (view.getId() == R.id.user_avatar) {
                aVar.objType = 4;
            } else {
                aVar.objType = 1;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f17291e;

        public c(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17291e = iVar;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c.a.r0.b0.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                c.a.r0.b0.e0.k kVar = (c.a.r0.b0.e0.k) nVar;
                kVar.k = 1;
                if (this.f17291e.s != null) {
                    this.f17291e.s.a(threadCardViewHolder.getView(), kVar);
                }
                ThreadCardUtils.jumpToPB(kVar, view.getContext(), 17, false, this.f17291e.n.getOrignalPage().getTopicId(), this.f17291e.h0() ? "3" : "2");
                threadCardViewHolder.getCardView().o(new a.C0095a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
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
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = true;
        this.s = new a(this);
        this.p = tbPageContext;
    }

    @Override // c.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.q = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: l0 */
    public ThreadCardViewHolder<c.a.r0.b0.e0.k> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.p.getPageActivity());
            c.a.l.d dVar = new c.a.l.d(this.p.getPageActivity());
            dVar.s(this.o);
            dVar.a(128);
            dVar.b(1024);
            dVar.r(new b(this));
            bVar.o(dVar);
            q0 q0Var = new q0(this.p.getPageActivity());
            bVar.n(q0Var);
            q0Var.t(2);
            bVar.h(new p0(this.p.getPageActivity()));
            bVar.h(new c.a.l.k(this.p.getPageActivity()));
            c.a.l.n nVar = new c.a.l.n(this.p.getPageActivity());
            nVar.w(this.r);
            nVar.v(ImageViewerConfig.FROM_CONCERN);
            bVar.h(nVar);
            n0 n0Var = new n0(this.p.getPageActivity());
            c.a.q0.s.q.f fVar = new c.a.q0.s.q.f();
            fVar.f14190b = 9;
            fVar.f14196h = 9;
            n0Var.u(fVar);
            n0Var.v(9);
            n0Var.z(4);
            n0Var.w(17);
            bVar.m(n0Var);
            l0 i2 = bVar.i();
            i2.r(17);
            ThreadCardViewHolder<c.a.r0.b0.e0.k> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
            threadCardViewHolder.setPageId(this.o);
            d0(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: m0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.r0.b0.e0.k kVar, ThreadCardViewHolder<c.a.r0.b0.e0.k> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.f15721e == null) {
                return null;
            }
            kVar.K(kVar.position + 1);
            threadCardViewHolder.getCardView().setPage(this.q);
            threadCardViewHolder.showUnfollowedDecorItemIfNeed(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.onBindDataToView(kVar);
            threadCardViewHolder.getCardView().onChangeSkinType(this.p, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.s);
            c.a.r0.e2.c.c(this, kVar);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
