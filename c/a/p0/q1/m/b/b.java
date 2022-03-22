package c.a.p0.q1.m.b;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.d.o.e.s;
import c.a.d.o.e.w;
import c.a.l.a;
import c.a.l.l0;
import c.a.l.t0;
import c.a.l.w0.a;
import c.a.p0.c3.u;
import c.a.p0.h0.b0;
import c.a.p0.h0.e0.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b extends c.a.d.o.e.a<l, AutoVideoCardViewHolder<l>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public BdUniqueId j;
    public s k;
    public t0 l;
    public c.a.p0.q1.i.k.f m;
    public b0<l> n;

    /* loaded from: classes2.dex */
    public class a extends b0<l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f17616b;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17616b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.h0.b0
        /* renamed from: d */
        public void a(View view, l lVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, lVar) == null) || view == null || lVar == null || lVar.getThreadData() == null) {
                return;
            }
            this.f17616b.f0(view, lVar);
            if (this.f17616b.m == null || !(view.getTag() instanceof String) || c.a.p0.q1.i.f.b(c.a.d.f.m.b.g(lVar.getThreadData().getTid(), 0L))) {
                return;
            }
            c.a.p0.q1.i.f.a(c.a.d.f.m.b.g(lVar.getThreadData().getTid(), 0L));
            this.f17616b.m.e(c.a.d.f.m.b.g(lVar.getThreadData().getTid(), 0L), lVar.D(), lVar.r(), lVar.q(), lVar.e(), c.a.d.f.m.b.e("3", 1), "video_tab", lVar.getThreadData().getBaijiahaoData());
        }
    }

    /* renamed from: c.a.p0.q1.m.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1320b implements a.InterfaceC0194a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t0 a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f17617b;

        public C1320b(b bVar, t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17617b = bVar;
            this.a = t0Var;
        }

        @Override // c.a.l.a.InterfaceC0194a
        public void a(c.a.o0.r.r.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (aVar instanceof l) {
                aVar.objType = 5;
                c.a.p0.q1.m.d.a.f((c.a.p0.h0.e0.b) aVar);
                c.a.p0.q1.m.d.a.c(aVar, this.f17617b.a, 19, false, computeViewArea);
                return;
            }
            c.a.p0.q1.m.d.a.f((c.a.p0.h0.e0.b) aVar);
            c.a.p0.q1.m.d.a.c(aVar, this.f17617b.a, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.d.o.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                l lVar = (l) nVar;
                lVar.f15320f = 1;
                if (this.a.n != null) {
                    this.a.n.a(threadCardViewHolder.b(), lVar);
                }
                c.a.p0.q1.m.d.a.c(lVar, view.getContext(), 19, false, c.a.l.e.a((s) viewGroup, view, i));
                threadCardViewHolder.c().o(new a.C0196a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
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
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new a(this);
        this.i = tbPageContext;
    }

    public final u e0(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar)) == null) {
            if (lVar != null) {
                u uVar = new u();
                uVar.a = "19";
                uVar.f13504c = lVar.f15321g;
                if (lVar.getThreadData() != null) {
                    uVar.f13505d = String.valueOf(lVar.getThreadData().getFid());
                    uVar.v = lVar.getThreadData().getNid();
                    if (lVar.getThreadData().getThreadVideoInfo() != null) {
                        uVar.m = lVar.getThreadData().getThreadVideoInfo().video_md5;
                        uVar.p = String.valueOf(lVar.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                uVar.k = lVar.i();
                uVar.f13507f = lVar.r();
                uVar.l = lVar.e();
                uVar.f13509h = lVar.D();
                uVar.f13506e = TbadkCoreApplication.getCurrentAccount();
                uVar.q = String.valueOf(lVar.q());
                if (lVar.getThreadData() == null || lVar.getThreadData().getBaijiahaoData() == null) {
                    return uVar;
                }
                uVar.t = lVar.getThreadData().getBaijiahaoData().oriUgcNid;
                uVar.u = lVar.getThreadData().getBaijiahaoData().oriUgcVid;
                return uVar;
            }
            return null;
        }
        return (u) invokeL.objValue;
    }

    public final void f0(View view, l lVar) {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view, lVar) == null) || (t0Var = this.l) == null || t0Var.o() == null || this.l.o().getMainView() == null) {
            return;
        }
        if (view.getId() == this.l.o().getMainView().getId()) {
            c.a.p0.q1.m.d.a.h(lVar);
        } else if (view.getId() == R.id.obfuscated_res_0x7f091f9a) {
            c.a.p0.q1.m.d.a.f(lVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: g0 */
    public AutoVideoCardViewHolder<l> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.i.getPageActivity(), false);
            c.a.l.g gVar = new c.a.l.g(this.i.getPageActivity());
            gVar.u(new C1320b(this, gVar));
            this.l = gVar;
            gVar.w(this.j);
            this.l.t("video_tab");
            this.l.x("2001");
            bVar.n(this.l);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.k);
            AutoVideoCardViewHolder<l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.k(this.j);
            k.p(this.n);
            k.r(19);
            V(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: h0 */
    public View S(int i, View view, ViewGroup viewGroup, l lVar, AutoVideoCardViewHolder<l> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view, viewGroup, lVar, autoVideoCardViewHolder})) == null) {
            if (lVar == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            lVar.I(lVar.position + 1);
            autoVideoCardViewHolder.c().q(i);
            autoVideoCardViewHolder.w(e0(lVar));
            c.a.p0.q1.m.d.a.d(lVar);
            autoVideoCardViewHolder.g(lVar);
            autoVideoCardViewHolder.c().onChangeSkinType(this.i, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.c().p(this.n);
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void i0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.j = bdUniqueId;
        }
    }

    public void j0(c.a.p0.q1.i.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.m = fVar;
        }
    }

    public void k0(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sVar) == null) {
            this.k = sVar;
        }
    }

    public void onPause() {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (t0Var = this.l) == null) {
            return;
        }
        t0Var.r();
    }
}
