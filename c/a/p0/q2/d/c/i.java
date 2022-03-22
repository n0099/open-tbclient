package c.a.p0.q2.d.c;

import android.view.View;
import android.view.ViewGroup;
import c.a.d.o.e.n;
import c.a.d.o.e.w;
import c.a.l.d;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.p0;
import c.a.l.q0;
import c.a.l.w0.a;
import c.a.p0.h0.b0;
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
/* loaded from: classes2.dex */
public class i extends c.a.p0.q2.d.c.a<c.a.p0.h0.e0.k, ThreadCardViewHolder<c.a.p0.h0.e0.k>> implements c.a.p0.v.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId k;
    public TbPageContext<?> l;
    public String m;
    public boolean n;
    public b0<c.a.p0.h0.e0.k> o;

    /* loaded from: classes2.dex */
    public class a extends b0<c.a.p0.h0.e0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f17647b;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17647b = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.h0.b0
        /* renamed from: d */
        public void a(View view, c.a.p0.h0.e0.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) {
                c.a.p0.q2.c.b(this.f17647b, kVar);
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.l.d.b
        public void a(c.a.o0.r.r.a aVar, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, view) == null) || aVar == null) {
                return;
            }
            if (view.getId() == R.id.obfuscated_res_0x7f0922bb) {
                aVar.objType = 3;
            } else if (view.getId() == R.id.obfuscated_res_0x7f092296) {
                aVar.objType = 4;
            } else {
                aVar.objType = 1;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        public c(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
        }

        @Override // c.a.d.o.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nVar instanceof c.a.p0.h0.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                c.a.p0.h0.e0.k kVar = (c.a.p0.h0.e0.k) nVar;
                kVar.f15320f = 1;
                if (this.a.o != null) {
                    this.a.o.a(threadCardViewHolder.b(), kVar);
                }
                ThreadCardUtils.jumpToPB(kVar, view.getContext(), 17, false, this.a.j.getOrignalPage().getTopicId(), this.a.Z() ? "3" : "2");
                threadCardViewHolder.c().o(new a.C0196a(1));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = true;
        this.o = new a(this);
        this.l = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: d0 */
    public ThreadCardViewHolder<c.a.p0.h0.e0.k> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.l.getPageActivity());
            c.a.l.d dVar = new c.a.l.d(this.l.getPageActivity());
            dVar.t(this.k);
            dVar.b(128);
            dVar.c(1024);
            dVar.s(new b(this));
            bVar.o(dVar);
            q0 q0Var = new q0(this.l.getPageActivity());
            bVar.n(q0Var);
            q0Var.u(2);
            bVar.h(new p0(this.l.getPageActivity()));
            bVar.h(new c.a.l.k(this.l.getPageActivity()));
            c.a.l.n nVar = new c.a.l.n(this.l.getPageActivity());
            nVar.x(this.n);
            nVar.w(ImageViewerConfig.FROM_CONCERN);
            bVar.h(nVar);
            n0 n0Var = new n0(this.l.getPageActivity());
            c.a.o0.r.r.f fVar = new c.a.o0.r.r.f();
            fVar.f10852b = 9;
            fVar.f10858h = 9;
            n0Var.v(fVar);
            n0Var.w(9);
            n0Var.A(4);
            n0Var.x(17);
            bVar.m(n0Var);
            l0 i = bVar.i();
            i.r(17);
            ThreadCardViewHolder<c.a.p0.h0.e0.k> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.k(this.k);
            V(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: e0 */
    public View S(int i, View view, ViewGroup viewGroup, c.a.p0.h0.e0.k kVar, ThreadCardViewHolder<c.a.p0.h0.e0.k> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || kVar.a == null) {
                return null;
            }
            kVar.I(kVar.position + 1);
            threadCardViewHolder.c().e(this.m);
            threadCardViewHolder.u(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.g(kVar);
            threadCardViewHolder.c().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.o);
            c.a.p0.q2.c.c(this, kVar);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.p0.v.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.m = str;
        }
    }
}
