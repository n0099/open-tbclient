package c.a.p0.q1.i.h;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.a;
import c.a.l.l0;
import c.a.l.t0;
import c.a.l.w0.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class z extends c.a.d.o.e.a<c.a.p0.h0.e0.l, AutoVideoCardViewHolder<c.a.p0.h0.e0.l>> implements c.a.p0.v.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public c.a.p0.q1.i.k.f k;
    public String l;
    public c.a.d.o.e.s m;
    public t0 n;
    public c.a.p0.h0.b0<c.a.p0.h0.e0.l> o;

    /* loaded from: classes2.dex */
    public class a extends c.a.p0.h0.b0<c.a.p0.h0.e0.l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f17438b;

        public a(z zVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17438b = zVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.h0.b0
        /* renamed from: d */
        public void a(View view, c.a.p0.h0.e0.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, lVar) == null) {
                c.a.p0.h0.u.b().d(true);
                c.a.p0.v.d.c().h("page_recommend", "show_");
                if (this.f17438b.k == null || lVar == null || lVar.getThreadData() == null || StringUtils.isNull(lVar.getThreadData().getTid())) {
                    return;
                }
                if (lVar.getThreadData().middle_page_num > 0) {
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(lVar.N(lVar.getThreadData())));
                    return;
                }
                if ((view.getTag() instanceof String) && !c.a.p0.q1.i.f.b(c.a.d.f.m.b.g(lVar.getThreadData().getTid(), 0L))) {
                    c.a.p0.q1.i.f.a(c.a.d.f.m.b.g(lVar.getThreadData().getTid(), 0L));
                    this.f17438b.k.e(c.a.d.f.m.b.g(lVar.getThreadData().getTid(), 0L), lVar.D(), lVar.r(), lVar.q(), lVar.e(), c.a.d.f.m.b.e((String) view.getTag(), 1), "homepage", lVar.getThreadData().getBaijiahaoData());
                }
                this.f17438b.f0(view, lVar);
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.InterfaceC0194a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t0 a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f17439b;

        public b(z zVar, t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar, t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17439b = zVar;
            this.a = t0Var;
        }

        @Override // c.a.l.a.InterfaceC0194a
        public void a(c.a.o0.r.r.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(aVar instanceof c.a.p0.h0.e0.l)) {
                ThreadCardUtils.jumpToPB(aVar, this.f17439b.a, 2, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f17439b.a, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements c.a.d.o.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z a;

        public c(z zVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zVar;
        }

        @Override // c.a.d.o.e.w
        public void b(View view, c.a.d.o.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nVar instanceof c.a.p0.h0.e0.l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view.getTag();
                c.a.p0.h0.e0.l lVar = (c.a.p0.h0.e0.l) nVar;
                lVar.f15320f = 1;
                if (this.a.o != null) {
                    this.a.o.a(autoVideoCardViewHolder.b(), lVar);
                }
                ThreadCardUtils.jumpToPB((c.a.o0.r.r.a) lVar, view.getContext(), 2, false, c.a.l.e.a((c.a.d.o.e.s) viewGroup, view, i));
                autoVideoCardViewHolder.c().o(new a.C0196a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.o = new a(this);
        this.j = tbPageContext;
        g0();
    }

    public final c.a.p0.c3.u e0(c.a.p0.h0.e0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar)) == null) {
            if (lVar != null) {
                c.a.p0.c3.u uVar = new c.a.p0.c3.u();
                uVar.a = "1";
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
        return (c.a.p0.c3.u) invokeL.objValue;
    }

    public final void f0(View view, c.a.p0.h0.e0.l lVar) {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view, lVar) == null) || (t0Var = this.n) == null || t0Var.o() == null || this.n.o().getMainView() == null) {
            return;
        }
        if (view.getId() == this.n.o().getMainView().getId()) {
            c.a.p0.q1.i.m.a.d(lVar.a, this.i, lVar.q(), 4);
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(lVar.P()));
            c.a.p0.q1.i.m.a.c(lVar.a, lVar.r(), lVar.q(), 2);
        } else if (view.getId() == R.id.obfuscated_res_0x7f091f9a) {
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(lVar.N(lVar.a)));
            c.a.p0.q1.i.m.a.c(lVar.a, lVar.r(), lVar.q(), 1);
        }
    }

    @Override // c.a.p0.v.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.l = str;
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.p0.h0.e0.l.V = "c10708";
            c.a.p0.h0.e0.l.W = "c10735";
            c.a.p0.h0.e0.l.X = "c10709";
            c.a.p0.h0.e0.l.Y = "c10734";
            c.a.p0.h0.e0.l.Z = "c11929";
            c.a.p0.h0.e0.l.g0 = "c11928";
            c.a.p0.h0.e0.l.h0 = "c10756";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: h0 */
    public AutoVideoCardViewHolder<c.a.p0.h0.e0.l> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.j.getPageActivity(), false);
            c.a.p0.q1.i.o.b bVar2 = new c.a.p0.q1.i.o.b(this.j.getPageActivity());
            bVar2.u(new b(this, bVar2));
            this.n = bVar2;
            bVar2.w(this.i);
            this.n.t("index");
            this.n.x("2001");
            bVar.n(this.n);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.m);
            AutoVideoCardViewHolder<c.a.p0.h0.e0.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.k(this.i);
            k.p(this.o);
            k.r(2);
            V(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: i0 */
    public View S(int i, View view, ViewGroup viewGroup, c.a.p0.h0.e0.l lVar, AutoVideoCardViewHolder<c.a.p0.h0.e0.l> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view, viewGroup, lVar, autoVideoCardViewHolder})) == null) {
            if (lVar == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            lVar.I(lVar.position + 1);
            lVar.a.statFloor = lVar.q();
            autoVideoCardViewHolder.c().q(i);
            lVar.T = 0;
            c.a.p0.h0.u.b().a(lVar.B());
            autoVideoCardViewHolder.w(e0(lVar));
            if (autoVideoCardViewHolder.c() != null) {
                autoVideoCardViewHolder.c().e(this.l);
            }
            autoVideoCardViewHolder.g(lVar);
            autoVideoCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.c().p(this.o);
            c.a.p0.q1.i.m.a.h(lVar.a, this.i, lVar.q());
            c.a.p0.q1.i.m.a.g(lVar.a, lVar.r(), lVar.q());
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void j0(c.a.p0.q1.i.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.k = fVar;
        }
    }

    public void k0(c.a.d.o.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, sVar) == null) {
            this.m = sVar;
        }
    }

    public void onPause() {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (t0Var = this.n) == null) {
            return;
        }
        t0Var.r();
    }

    public void onResume() {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (t0Var = this.n) == null) {
            return;
        }
        t0Var.s();
    }
}
