package b.a.r0.p2.c.q;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.l;
import b.a.e.m.e.n;
import b.a.e.m.e.w;
import b.a.l.d;
import b.a.l.l0;
import b.a.l.n0;
import b.a.l.w0.a;
import b.a.r0.b0.d0;
import b.a.r0.b0.f0.k;
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
/* loaded from: classes5.dex */
public class a extends b.a.e.m.e.a<b.a.r0.b0.f0.e, ThreadCardViewHolder<b.a.r0.b0.f0.e>> implements b.a.r0.p.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public int p;
    public int q;
    public boolean r;
    public d0<b.a.r0.b0.f0.e> s;

    /* renamed from: b.a.r0.p2.c.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1146a extends d0<b.a.r0.b0.f0.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1146a(a aVar) {
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
        @Override // b.a.r0.b0.d0
        /* renamed from: d */
        public void a(View view, b.a.r0.b0.f0.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, eVar) == null) || view == null || eVar == null || eVar.getThreadData() == null) {
                return;
            }
            int id = view.getId();
            if (id != R.id.thread_card_root && id != R.id.bottom_mask) {
                if (id == R.id.forum_name_text) {
                    b.a.r0.p2.a.a(view, eVar, 7);
                    return;
                }
                return;
            }
            b.a.r0.p2.a.a(view, eVar, 2);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f23649a;

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
            this.f23649a = aVar;
        }

        @Override // b.a.l.d.b
        public void a(b.a.q0.s.q.a aVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, view) == null) {
                this.f23649a.q0(view, aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends d0<b.a.q0.s.q.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f23650b;

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
            this.f23650b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.d0
        /* renamed from: d */
        public void a(View view, b.a.q0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, aVar) == null) {
                this.f23650b.q0(view, aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23651e;

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
            this.f23651e = aVar;
        }

        @Override // b.a.e.m.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                this.f23651e.j0(view, nVar);
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
        this.s = new C1146a(this);
        this.n = tbPageContext;
        i0();
    }

    @Override // b.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.o = str;
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            k.t0 = "c13542";
        }
    }

    public final void j0(View view, n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, view, nVar) == null) && (nVar instanceof b.a.r0.b0.f0.e) && (view.getTag() instanceof ThreadCardViewHolder)) {
            b.a.r0.b0.f0.e eVar = (b.a.r0.b0.f0.e) nVar;
            eVar.k = 1;
            ThreadCardUtils.jumpToPB((b.a.q0.s.q.a) eVar, view.getContext(), 4, false);
            ((ThreadCardViewHolder) view.getTag()).getCardView().n(new a.C0092a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: k0 */
    public ThreadCardViewHolder<b.a.r0.b0.f0.e> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity());
            b.a.l.d dVar = new b.a.l.d(this.n.getPageActivity());
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
            bVar.l().g(l.g(this.f2421e, R.dimen.tbds25));
            b.a.l.b bVar2 = new b.a.l.b(this.n.getPageActivity());
            bVar2.k(new c(this));
            bVar.n(bVar2);
            bVar.h(new b.a.l.k(this.n.getPageActivity()));
            n0 n0Var = new n0(this.n.getPageActivity());
            b.a.q0.s.q.f fVar = new b.a.q0.s.q.f();
            fVar.f14080b = 3;
            fVar.f14086h = 3;
            n0Var.u(fVar);
            n0Var.v(8);
            n0Var.z(6);
            n0Var.w(4);
            bVar.m(n0Var);
            l0 i3 = bVar.i();
            i3.q(4);
            ThreadCardViewHolder<b.a.r0.b0.f0.e> threadCardViewHolder = new ThreadCardViewHolder<>(i3);
            threadCardViewHolder.setPageId(this.m);
            threadCardViewHolder.showPrivateDecorItem(this.q);
            c0(new d(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: l0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.b0.f0.e eVar, ThreadCardViewHolder<b.a.r0.b0.f0.e> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, eVar, threadCardViewHolder})) == null) {
            if (eVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            eVar.K(eVar.position + 1);
            threadCardViewHolder.getCardView().setPage(this.o);
            if (!this.r) {
                threadCardViewHolder.showThemeAndStarDecorItem();
            }
            threadCardViewHolder.onBindDataToView(eVar);
            threadCardViewHolder.getCardView().o(this.s);
            threadCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            b.a.r0.p2.a.b(eVar);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.r = z;
        }
    }

    public void n0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.q = i2;
        }
    }

    public void o0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
        }
    }

    public void p0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.p = i2;
        }
    }

    public final void q0(View view, b.a.q0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, view, aVar) == null) || view == null || aVar == null || view.getId() == -1) {
            return;
        }
        int id = view.getId();
        if (id != R.id.user_name && id != R.id.user_avatar) {
            if (id == R.id.cover_img || id == R.id.bottom_mask) {
                b.a.r0.p2.a.a(view, aVar, 3);
                return;
            }
            return;
        }
        b.a.r0.p2.a.a(view, aVar, 1);
    }
}
