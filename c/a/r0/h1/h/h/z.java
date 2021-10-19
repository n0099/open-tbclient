package c.a.r0.h1.h.h;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.a;
import c.a.l.l0;
import c.a.l.t0;
import c.a.l.v0.a;
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
/* loaded from: classes3.dex */
public class z extends c.a.e.l.e.a<c.a.r0.b0.e0.l, AutoVideoCardViewHolder<c.a.r0.b0.e0.l>> implements c.a.r0.p.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public c.a.r0.h1.h.k.f o;
    public String p;
    public c.a.e.l.e.s q;
    public t0 r;
    public c.a.r0.b0.c0<c.a.r0.b0.e0.l> s;

    /* loaded from: classes3.dex */
    public class a extends c.a.r0.b0.c0<c.a.r0.b0.e0.l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f18511b;

        public a(z zVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18511b = zVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, c.a.r0.b0.e0.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, lVar) == null) {
                c.a.r0.b0.u.b().d(true);
                c.a.r0.p.d.c().h("page_recommend", "show_");
                if (this.f18511b.o == null || lVar == null || lVar.getThreadData() == null || StringUtils.isNull(lVar.getThreadData().s1())) {
                    return;
                }
                if (lVar.getThreadData().w1 > 0) {
                    TiebaStatic.log(lVar.P(lVar.getThreadData()));
                    return;
                }
                if ((view.getTag() instanceof String) && !c.a.r0.h1.h.f.b(c.a.e.e.m.b.g(lVar.getThreadData().s1(), 0L))) {
                    c.a.r0.h1.h.f.a(c.a.e.e.m.b.g(lVar.getThreadData().s1(), 0L));
                    this.f18511b.o.e(c.a.e.e.m.b.g(lVar.getThreadData().s1(), 0L), lVar.E(), lVar.t(), lVar.q(), lVar.g(), c.a.e.e.m.b.e((String) view.getTag(), 1), "homepage", lVar.getThreadData().L());
                }
                this.f18511b.n0(view, lVar);
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.InterfaceC0093a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f18512a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f18513b;

        public b(z zVar, t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar, t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18513b = zVar;
            this.f18512a = t0Var;
        }

        @Override // c.a.l.a.InterfaceC0093a
        public void a(c.a.q0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f18512a.getVideoContainer());
            if (!(aVar instanceof c.a.r0.b0.e0.l)) {
                ThreadCardUtils.jumpToPB(aVar, this.f18513b.f2958e, 2, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f18513b.f2958e, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements c.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ z f18514e;

        public c(z zVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18514e = zVar;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, c.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c.a.r0.b0.e0.l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view.getTag();
                c.a.r0.b0.e0.l lVar = (c.a.r0.b0.e0.l) nVar;
                lVar.k = 1;
                if (this.f18514e.s != null) {
                    this.f18514e.s.a(autoVideoCardViewHolder.getView(), lVar);
                }
                ThreadCardUtils.jumpToPB((c.a.q0.s.q.a) lVar, view.getContext(), 2, false, c.a.l.e.a((c.a.e.l.e.s) viewGroup, view, i2));
                autoVideoCardViewHolder.getCardView().o(new a.C0095a(1));
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
        this.s = new a(this);
        this.n = tbPageContext;
        o0();
    }

    @Override // c.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.p = str;
        }
    }

    public final c.a.r0.q2.o m0(c.a.r0.b0.e0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, lVar)) == null) {
            if (lVar != null) {
                c.a.r0.q2.o oVar = new c.a.r0.q2.o();
                oVar.f23997a = "1";
                oVar.f23999c = lVar.l;
                if (lVar.getThreadData() != null) {
                    oVar.f24000d = String.valueOf(lVar.getThreadData().T());
                    oVar.v = lVar.getThreadData().F0();
                    if (lVar.getThreadData().q1() != null) {
                        oVar.m = lVar.getThreadData().q1().video_md5;
                        oVar.p = String.valueOf(lVar.getThreadData().q1().is_vertical);
                    }
                }
                oVar.k = lVar.k();
                oVar.f24002f = lVar.t();
                oVar.l = lVar.g();
                oVar.f24004h = lVar.E();
                oVar.f24001e = TbadkCoreApplication.getCurrentAccount();
                oVar.q = String.valueOf(lVar.q());
                if (lVar.getThreadData() == null || lVar.getThreadData().L() == null) {
                    return oVar;
                }
                oVar.t = lVar.getThreadData().L().oriUgcNid;
                oVar.u = lVar.getThreadData().L().oriUgcVid;
                return oVar;
            }
            return null;
        }
        return (c.a.r0.q2.o) invokeL.objValue;
    }

    public final void n0(View view, c.a.r0.b0.e0.l lVar) {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, view, lVar) == null) || (t0Var = this.r) == null || t0Var.o() == null || this.r.o().getMainView() == null) {
            return;
        }
        if (view.getId() == this.r.o().getMainView().getId()) {
            c.a.r0.h1.h.m.a.c(lVar.f15721e, this.m, lVar.q(), 4);
            TiebaStatic.log(lVar.R());
            c.a.r0.h1.h.m.a.b(lVar.f15721e, lVar.t(), lVar.q(), 2);
        } else if (view.getId() == R.id.thread_card_root) {
            TiebaStatic.log(lVar.P(lVar.f15721e));
            c.a.r0.h1.h.m.a.b(lVar.f15721e, lVar.t(), lVar.q(), 1);
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.r0.b0.e0.l.Y = "c10708";
            c.a.r0.b0.e0.l.Z = "c10735";
            c.a.r0.b0.e0.l.a0 = "c10709";
            c.a.r0.b0.e0.l.b0 = "c10734";
            c.a.r0.b0.e0.l.c0 = "c11929";
            c.a.r0.b0.e0.l.i0 = "c11928";
            c.a.r0.b0.e0.l.j0 = "c10756";
        }
    }

    public void onPause() {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (t0Var = this.r) == null) {
            return;
        }
        t0Var.r();
    }

    public void onResume() {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (t0Var = this.r) == null) {
            return;
        }
        t0Var.s();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: p0 */
    public AutoVideoCardViewHolder<c.a.r0.b0.e0.l> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            c.a.r0.h1.h.o.b bVar2 = new c.a.r0.h1.h.o.b(this.n.getPageActivity());
            bVar2.u(new b(this, bVar2));
            this.r = bVar2;
            bVar2.w(this.m);
            this.r.t("index");
            this.r.x("2001");
            bVar.n(this.r);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
            AutoVideoCardViewHolder<c.a.r0.b0.e0.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.setPageId(this.m);
            k.p(this.s);
            k.r(2);
            d0(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: q0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.r0.b0.e0.l lVar, AutoVideoCardViewHolder<c.a.r0.b0.e0.l> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), view, viewGroup, lVar, autoVideoCardViewHolder})) == null) {
            if (lVar == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            lVar.K(lVar.position + 1);
            lVar.f15721e.T1 = lVar.q();
            autoVideoCardViewHolder.getCardView().q(i2);
            lVar.W = 0;
            c.a.r0.b0.u.b().a(lVar.B());
            autoVideoCardViewHolder.setVideoStatsData(m0(lVar));
            if (autoVideoCardViewHolder.getCardView() != null) {
                autoVideoCardViewHolder.getCardView().setPage(this.p);
            }
            autoVideoCardViewHolder.onBindDataToView(lVar);
            autoVideoCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.getCardView().p(this.s);
            c.a.r0.h1.h.m.a.f(lVar.f15721e, this.m, lVar.q());
            c.a.r0.h1.h.m.a.e(lVar.f15721e, lVar.t(), lVar.q());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void r0(c.a.r0.h1.h.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.o = fVar;
        }
    }

    public void s0(c.a.e.l.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, sVar) == null) {
            this.q = sVar;
        }
    }
}
