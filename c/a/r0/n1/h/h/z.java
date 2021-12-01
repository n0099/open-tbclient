package c.a.r0.n1.h.h;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.k.a;
import c.a.k.l0;
import c.a.k.t0;
import c.a.k.w0.a;
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
/* loaded from: classes6.dex */
public class z extends c.a.d.m.e.a<c.a.r0.g0.f0.l, AutoVideoCardViewHolder<c.a.r0.g0.f0.l>> implements c.a.r0.t.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public c.a.r0.n1.h.k.f o;
    public String p;
    public c.a.d.m.e.s q;
    public t0 r;
    public c.a.r0.g0.d0<c.a.r0.g0.f0.l> s;

    /* loaded from: classes6.dex */
    public class a extends c.a.r0.g0.d0<c.a.r0.g0.f0.l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f20531b;

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
            this.f20531b = zVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.g0.d0
        /* renamed from: d */
        public void a(View view, c.a.r0.g0.f0.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, lVar) == null) {
                c.a.r0.g0.v.b().d(true);
                c.a.r0.t.d.c().h("page_recommend", "show_");
                if (this.f20531b.o == null || lVar == null || lVar.getThreadData() == null || StringUtils.isNull(lVar.getThreadData().v1())) {
                    return;
                }
                if (lVar.getThreadData().y1 > 0) {
                    TiebaStatic.log(lVar.P(lVar.getThreadData()));
                    return;
                }
                if ((view.getTag() instanceof String) && !c.a.r0.n1.h.f.b(c.a.d.f.m.b.g(lVar.getThreadData().v1(), 0L))) {
                    c.a.r0.n1.h.f.a(c.a.d.f.m.b.g(lVar.getThreadData().v1(), 0L));
                    this.f20531b.o.e(c.a.d.f.m.b.g(lVar.getThreadData().v1(), 0L), lVar.E(), lVar.t(), lVar.q(), lVar.g(), c.a.d.f.m.b.e((String) view.getTag(), 1), "homepage", lVar.getThreadData().L());
                }
                this.f20531b.m0(view, lVar);
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements a.InterfaceC0129a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t0 a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f20532b;

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
            this.f20532b = zVar;
            this.a = t0Var;
        }

        @Override // c.a.k.a.InterfaceC0129a
        public void a(c.a.q0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(aVar instanceof c.a.r0.g0.f0.l)) {
                ThreadCardUtils.jumpToPB(aVar, this.f20532b.f2907e, 2, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f20532b.f2907e, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements c.a.d.m.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ z f20533e;

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
            this.f20533e = zVar;
        }

        @Override // c.a.d.m.e.w
        public void b(View view, c.a.d.m.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c.a.r0.g0.f0.l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view.getTag();
                c.a.r0.g0.f0.l lVar = (c.a.r0.g0.f0.l) nVar;
                lVar.f17251k = 1;
                if (this.f20533e.s != null) {
                    this.f20533e.s.a(autoVideoCardViewHolder.getView(), lVar);
                }
                ThreadCardUtils.jumpToPB((c.a.q0.s.q.a) lVar, view.getContext(), 2, false, c.a.k.e.a((c.a.d.m.e.s) viewGroup, view, i2));
                autoVideoCardViewHolder.getCardView().o(new a.C0131a(1));
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
        n0();
    }

    @Override // c.a.r0.t.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.p = str;
        }
    }

    public final c.a.r0.x2.p l0(c.a.r0.g0.f0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, lVar)) == null) {
            if (lVar != null) {
                c.a.r0.x2.p pVar = new c.a.r0.x2.p();
                pVar.a = "1";
                pVar.f25426c = lVar.l;
                if (lVar.getThreadData() != null) {
                    pVar.f25427d = String.valueOf(lVar.getThreadData().U());
                    pVar.v = lVar.getThreadData().G0();
                    if (lVar.getThreadData().t1() != null) {
                        pVar.m = lVar.getThreadData().t1().video_md5;
                        pVar.p = String.valueOf(lVar.getThreadData().t1().is_vertical);
                    }
                }
                pVar.f25434k = lVar.k();
                pVar.f25429f = lVar.t();
                pVar.l = lVar.g();
                pVar.f25431h = lVar.E();
                pVar.f25428e = TbadkCoreApplication.getCurrentAccount();
                pVar.q = String.valueOf(lVar.q());
                if (lVar.getThreadData() == null || lVar.getThreadData().L() == null) {
                    return pVar;
                }
                pVar.t = lVar.getThreadData().L().oriUgcNid;
                pVar.u = lVar.getThreadData().L().oriUgcVid;
                return pVar;
            }
            return null;
        }
        return (c.a.r0.x2.p) invokeL.objValue;
    }

    public final void m0(View view, c.a.r0.g0.f0.l lVar) {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, view, lVar) == null) || (t0Var = this.r) == null || t0Var.o() == null || this.r.o().getMainView() == null) {
            return;
        }
        if (view.getId() == this.r.o().getMainView().getId()) {
            c.a.r0.n1.h.m.a.c(lVar.f17245e, this.m, lVar.q(), 4);
            TiebaStatic.log(lVar.R());
            c.a.r0.n1.h.m.a.b(lVar.f17245e, lVar.t(), lVar.q(), 2);
        } else if (view.getId() == R.id.thread_card_root) {
            TiebaStatic.log(lVar.P(lVar.f17245e));
            c.a.r0.n1.h.m.a.b(lVar.f17245e, lVar.t(), lVar.q(), 1);
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.r0.g0.f0.l.a0 = "c10708";
            c.a.r0.g0.f0.l.b0 = "c10735";
            c.a.r0.g0.f0.l.c0 = "c10709";
            c.a.r0.g0.f0.l.d0 = "c10734";
            c.a.r0.g0.f0.l.e0 = "c11929";
            c.a.r0.g0.f0.l.f0 = "c11928";
            c.a.r0.g0.f0.l.g0 = "c10756";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: o0 */
    public AutoVideoCardViewHolder<c.a.r0.g0.f0.l> S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            c.a.r0.n1.h.o.b bVar2 = new c.a.r0.n1.h.o.b(this.n.getPageActivity());
            bVar2.u(new b(this, bVar2));
            this.r = bVar2;
            bVar2.w(this.m);
            this.r.t("index");
            this.r.x("2001");
            bVar.n(this.r);
            l0 k2 = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
            AutoVideoCardViewHolder<c.a.r0.g0.f0.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k2);
            autoVideoCardViewHolder.setPageId(this.m);
            k2.p(this.s);
            k2.r(2);
            c0(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    public void onPause() {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (t0Var = this.r) == null) {
            return;
        }
        t0Var.r();
    }

    public void onResume() {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (t0Var = this.r) == null) {
            return;
        }
        t0Var.s();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: p0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c.a.r0.g0.f0.l lVar, AutoVideoCardViewHolder<c.a.r0.g0.f0.l> autoVideoCardViewHolder) {
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
            lVar.f17245e.U1 = lVar.q();
            autoVideoCardViewHolder.getCardView().q(i2);
            lVar.Y = 0;
            c.a.r0.g0.v.b().a(lVar.B());
            autoVideoCardViewHolder.setVideoStatsData(l0(lVar));
            if (autoVideoCardViewHolder.getCardView() != null) {
                autoVideoCardViewHolder.getCardView().d(this.p);
            }
            autoVideoCardViewHolder.onBindDataToView(lVar);
            autoVideoCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.getCardView().p(this.s);
            c.a.r0.n1.h.m.a.f(lVar.f17245e, this.m, lVar.q());
            c.a.r0.n1.h.m.a.e(lVar.f17245e, lVar.t(), lVar.q());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void q0(c.a.r0.n1.h.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.o = fVar;
        }
    }

    public void r0(c.a.d.m.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, sVar) == null) {
            this.q = sVar;
        }
    }
}
