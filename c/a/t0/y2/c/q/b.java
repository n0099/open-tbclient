package c.a.t0.y2.c.q;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.d.n.e.n;
import c.a.d.n.e.v;
import c.a.l.a;
import c.a.l.g0;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.o0;
import c.a.l.w0.a;
import c.a.t0.g0.d0;
import c.a.t0.g0.f0.k;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b extends c.a.d.n.e.a<k, ThreadCardViewHolder<k>> implements c.a.t0.t.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public int p;
    public int q;
    public boolean r;
    public d0<k> s;

    /* loaded from: classes9.dex */
    public class a extends d0<k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.g0.d0
        /* renamed from: d */
        public void a(View view, k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) || view == null || kVar == null || kVar.getThreadData() == null || view.getId() != c.a.t0.z2.d.forum_name_text) {
                return;
            }
            c.a.t0.y2.a.a(view, kVar, 7);
        }
    }

    /* renamed from: c.a.t0.y2.c.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1545b implements a.InterfaceC0202a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g0 a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f25602b;

        public C1545b(b bVar, g0 g0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, g0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25602b = bVar;
            this.a = g0Var;
        }

        @Override // c.a.l.a.InterfaceC0202a
        public void a(c.a.s0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().z1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.getThreadData().z1, this.f25602b.f3360e, 4);
            c.a.t0.y2.a.a(this.a.f(), aVar, 6);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements a.InterfaceC0202a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o0 a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f25603b;

        public c(b bVar, o0 o0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, o0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25603b = bVar;
            this.a = o0Var;
        }

        @Override // c.a.l.a.InterfaceC0202a
        public void a(c.a.s0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().z1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.getThreadData().z1, this.f25603b.f3360e, 4);
            c.a.t0.y2.a.a(this.a.f(), aVar, 6);
        }
    }

    /* loaded from: classes9.dex */
    public class d implements v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25604e;

        public d(b bVar) {
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
            this.f25604e = bVar;
        }

        @Override // c.a.d.n.e.v
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                k kVar = (k) nVar;
                kVar.k = 1;
                if (this.f25604e.s != null) {
                    this.f25604e.s.a(threadCardViewHolder.getView(), kVar);
                }
                ThreadCardUtils.jumpToPB((c.a.s0.s.q.a) kVar, view.getContext(), 4, false);
                threadCardViewHolder.getCardView().o(new a.C0204a(1));
            }
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
        this.p = 0;
        this.q = 0;
        this.s = new a(this);
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: c0 */
    public ThreadCardViewHolder<k> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity());
            c.a.l.d dVar = new c.a.l.d(this.n.getPageActivity());
            dVar.s(this.m);
            dVar.b(1024);
            dVar.b(32768);
            int i2 = this.p;
            if (i2 > 0) {
                dVar.a(i2);
            }
            dVar.q(false);
            dVar.v(false);
            bVar.o(dVar);
            g0 g0Var = new g0(this.n);
            g0Var.m(Boolean.FALSE);
            g0Var.u(ImageViewerConfig.FROM_CONCERN);
            g0Var.q(c.a.d.f.p.n.f(this.f3360e, c.a.t0.z2.b.tbds9));
            bVar.n(g0Var);
            bVar.l().g(c.a.d.f.p.n.f(this.f3360e, c.a.t0.z2.b.tbds25));
            g0 g0Var2 = new g0(this.n);
            g0Var2.m(Boolean.TRUE);
            g0Var2.u(ImageViewerConfig.FROM_CONCERN);
            g0Var2.x(c.a.s0.b.g.b.b(), UtilHelper.getDimenPixelSize(c.a.t0.z2.b.M_H_X004), c.a.s0.b.g.b.b(), UtilHelper.getDimenPixelSize(c.a.t0.z2.b.M_H_X004));
            g0Var2.v(new C1545b(this, g0Var2));
            bVar.h(g0Var2);
            o0 o0Var = new o0(this.n.getPageActivity());
            o0Var.m(Boolean.TRUE);
            o0Var.t(new c(this, o0Var));
            bVar.h(o0Var);
            bVar.h(new c.a.l.k(this.n.getPageActivity()));
            n0 n0Var = new n0(this.n.getPageActivity());
            c.a.s0.s.q.f fVar = new c.a.s0.s.q.f();
            fVar.f13557b = 3;
            fVar.f13563h = 3;
            n0Var.u(fVar);
            n0Var.v(8);
            n0Var.z(6);
            n0Var.w(4);
            bVar.m(n0Var);
            l0 i3 = bVar.i();
            i3.r(4);
            ThreadCardViewHolder<k> threadCardViewHolder = new ThreadCardViewHolder<>(i3);
            threadCardViewHolder.setPageId(this.m);
            threadCardViewHolder.showPrivateDecorItem(this.q);
            V(new d(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: d0 */
    public View S(int i2, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder<k> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.f17600e == null) {
                return null;
            }
            kVar.K(kVar.position + 1);
            threadCardViewHolder.getCardView().d(this.o);
            if (!this.r) {
                threadCardViewHolder.showThemeAndStarDecorItem();
            }
            threadCardViewHolder.onBindDataToView(kVar);
            threadCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.s);
            c.a.t0.y2.a.b(kVar);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.r = z;
        }
    }

    public void f0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.q = i2;
        }
    }

    @Override // c.a.t0.t.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.o = str;
        }
    }

    public void g0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
        }
    }

    public void h0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.p = i2;
        }
    }
}
