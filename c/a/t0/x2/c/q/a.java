package c.a.t0.x2.c.q;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.d.n.e.n;
import c.a.d.n.e.w;
import c.a.l.d;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.w0.a;
import c.a.t0.g0.d0;
import c.a.t0.g0.f0.k;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a extends c.a.d.n.e.a<c.a.t0.g0.f0.e, ThreadCardViewHolder<c.a.t0.g0.f0.e>> implements c.a.t0.t.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public int p;
    public int q;
    public boolean r;
    public d0<c.a.t0.g0.f0.e> s;

    /* renamed from: c.a.t0.x2.c.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1508a extends d0<c.a.t0.g0.f0.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1508a(a aVar) {
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
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.g0.d0
        /* renamed from: d */
        public void a(View view, c.a.t0.g0.f0.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, eVar) == null) || view == null || eVar == null || eVar.getThreadData() == null) {
                return;
            }
            int id = view.getId();
            if (id != R.id.thread_card_root && id != R.id.bottom_mask) {
                if (id == R.id.forum_name_text) {
                    c.a.t0.x2.a.a(view, eVar, 7);
                    return;
                }
                return;
            }
            c.a.t0.x2.a.a(view, eVar, 2);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
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
            this.a = aVar;
        }

        @Override // c.a.l.d.b
        public void a(c.a.s0.s.q.a aVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, view) == null) {
                this.a.j0(view, aVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends d0<c.a.s0.s.q.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f26089b;

        public c(a aVar) {
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
            this.f26089b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.g0.d0
        /* renamed from: d */
        public void a(View view, c.a.s0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, aVar) == null) {
                this.f26089b.j0(view, aVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26090e;

        public d(a aVar) {
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
            this.f26090e = aVar;
        }

        @Override // c.a.d.n.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                this.f26090e.c0(view, nVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.s = new C1508a(this);
        this.n = tbPageContext;
        b0();
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            k.u0 = "c13542";
        }
    }

    public final void c0(View view, n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, view, nVar) == null) && (nVar instanceof c.a.t0.g0.f0.e) && (view.getTag() instanceof ThreadCardViewHolder)) {
            c.a.t0.g0.f0.e eVar = (c.a.t0.g0.f0.e) nVar;
            eVar.f18228k = 1;
            ThreadCardUtils.jumpToPB((c.a.s0.s.q.a) eVar, view.getContext(), 4, false);
            ((ThreadCardViewHolder) view.getTag()).getCardView().o(new a.C0186a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: d0 */
    public ThreadCardViewHolder<c.a.t0.g0.f0.e> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity());
            c.a.l.d dVar = new c.a.l.d(this.n.getPageActivity());
            dVar.s(this.m);
            dVar.u(this.n);
            dVar.b(32768);
            int i2 = this.p;
            if (i2 > 0) {
                dVar.a(i2);
            }
            dVar.q(false);
            dVar.v(false);
            dVar.r(new b(this));
            bVar.o(dVar);
            bVar.l().g(c.a.d.f.p.n.f(this.f3299e, R.dimen.tbds25));
            c.a.l.b bVar2 = new c.a.l.b(this.n.getPageActivity());
            bVar2.k(new c(this));
            bVar.n(bVar2);
            bVar.h(new c.a.l.k(this.n.getPageActivity()));
            n0 n0Var = new n0(this.n.getPageActivity());
            c.a.s0.s.q.f fVar = new c.a.s0.s.q.f();
            fVar.f13685b = 3;
            fVar.f13691h = 3;
            n0Var.u(fVar);
            n0Var.v(8);
            n0Var.z(6);
            n0Var.w(4);
            bVar.m(n0Var);
            l0 i3 = bVar.i();
            i3.r(4);
            ThreadCardViewHolder<c.a.t0.g0.f0.e> threadCardViewHolder = new ThreadCardViewHolder<>(i3);
            threadCardViewHolder.setPageId(this.m);
            threadCardViewHolder.showPrivateDecorItem(this.q);
            V(new d(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: e0 */
    public View S(int i2, View view, ViewGroup viewGroup, c.a.t0.g0.f0.e eVar, ThreadCardViewHolder<c.a.t0.g0.f0.e> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, eVar, threadCardViewHolder})) == null) {
            if (eVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            eVar.K(eVar.position + 1);
            threadCardViewHolder.getCardView().d(this.o);
            if (!this.r) {
                threadCardViewHolder.showThemeAndStarDecorItem();
            }
            threadCardViewHolder.onBindDataToView(eVar);
            threadCardViewHolder.getCardView().p(this.s);
            threadCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            c.a.t0.x2.a.b(eVar);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.r = z;
        }
    }

    @Override // c.a.t0.t.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.o = str;
        }
    }

    public void g0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.q = i2;
        }
    }

    public void h0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
        }
    }

    public void i0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.p = i2;
        }
    }

    public final void j0(View view, c.a.s0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, view, aVar) == null) || view == null || aVar == null || view.getId() == -1) {
            return;
        }
        int id = view.getId();
        if (id != R.id.user_name && id != R.id.user_avatar) {
            if (id == R.id.cover_img || id == R.id.bottom_mask) {
                c.a.t0.x2.a.a(view, aVar, 3);
                return;
            }
            return;
        }
        c.a.t0.x2.a.a(view, aVar, 1);
    }
}
