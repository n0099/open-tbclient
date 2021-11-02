package b.a.r0.h1.h.h;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.l.a;
import b.a.l.l0;
import b.a.l.t0;
import b.a.l.v0.a;
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
/* loaded from: classes4.dex */
public class z extends b.a.e.l.e.a<b.a.r0.b0.e0.l, AutoVideoCardViewHolder<b.a.r0.b0.e0.l>> implements b.a.r0.p.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public b.a.r0.h1.h.k.f o;
    public String p;
    public b.a.e.l.e.s q;
    public t0 r;
    public b.a.r0.b0.c0<b.a.r0.b0.e0.l> s;

    /* loaded from: classes4.dex */
    public class a extends b.a.r0.b0.c0<b.a.r0.b0.e0.l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f17445b;

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
            this.f17445b = zVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, b.a.r0.b0.e0.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, lVar) == null) {
                b.a.r0.b0.u.b().d(true);
                b.a.r0.p.d.c().h("page_recommend", "show_");
                if (this.f17445b.o == null || lVar == null || lVar.getThreadData() == null || StringUtils.isNull(lVar.getThreadData().s1())) {
                    return;
                }
                if (lVar.getThreadData().w1 > 0) {
                    TiebaStatic.log(lVar.P(lVar.getThreadData()));
                    return;
                }
                if ((view.getTag() instanceof String) && !b.a.r0.h1.h.f.b(b.a.e.e.m.b.g(lVar.getThreadData().s1(), 0L))) {
                    b.a.r0.h1.h.f.a(b.a.e.e.m.b.g(lVar.getThreadData().s1(), 0L));
                    this.f17445b.o.e(b.a.e.e.m.b.g(lVar.getThreadData().s1(), 0L), lVar.E(), lVar.t(), lVar.q(), lVar.g(), b.a.e.e.m.b.e((String) view.getTag(), 1), "homepage", lVar.getThreadData().L());
                }
                this.f17445b.m0(view, lVar);
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.InterfaceC0088a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f17446a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f17447b;

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
            this.f17447b = zVar;
            this.f17446a = t0Var;
        }

        @Override // b.a.l.a.InterfaceC0088a
        public void a(b.a.q0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f17446a.getVideoContainer());
            if (!(aVar instanceof b.a.r0.b0.e0.l)) {
                ThreadCardUtils.jumpToPB(aVar, this.f17447b.f2419e, 2, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f17447b.f2419e, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements b.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ z f17448e;

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
            this.f17448e = zVar;
        }

        @Override // b.a.e.l.e.w
        public void b(View view, b.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof b.a.r0.b0.e0.l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view.getTag();
                b.a.r0.b0.e0.l lVar = (b.a.r0.b0.e0.l) nVar;
                lVar.k = 1;
                if (this.f17448e.s != null) {
                    this.f17448e.s.a(autoVideoCardViewHolder.getView(), lVar);
                }
                ThreadCardUtils.jumpToPB((b.a.q0.s.q.a) lVar, view.getContext(), 2, false, b.a.l.e.a((b.a.e.l.e.s) viewGroup, view, i2));
                autoVideoCardViewHolder.getCardView().n(new a.C0090a(1));
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

    @Override // b.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.p = str;
        }
    }

    public final b.a.r0.q2.p l0(b.a.r0.b0.e0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, lVar)) == null) {
            if (lVar != null) {
                b.a.r0.q2.p pVar = new b.a.r0.q2.p();
                pVar.f22882a = "1";
                pVar.f22884c = lVar.l;
                if (lVar.getThreadData() != null) {
                    pVar.f22885d = String.valueOf(lVar.getThreadData().T());
                    pVar.v = lVar.getThreadData().F0();
                    if (lVar.getThreadData().q1() != null) {
                        pVar.m = lVar.getThreadData().q1().video_md5;
                        pVar.p = String.valueOf(lVar.getThreadData().q1().is_vertical);
                    }
                }
                pVar.k = lVar.k();
                pVar.f22887f = lVar.t();
                pVar.l = lVar.g();
                pVar.f22889h = lVar.E();
                pVar.f22886e = TbadkCoreApplication.getCurrentAccount();
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
        return (b.a.r0.q2.p) invokeL.objValue;
    }

    public final void m0(View view, b.a.r0.b0.e0.l lVar) {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, view, lVar) == null) || (t0Var = this.r) == null || t0Var.o() == null || this.r.o().getMainView() == null) {
            return;
        }
        if (view.getId() == this.r.o().getMainView().getId()) {
            b.a.r0.h1.h.m.a.c(lVar.f14748e, this.m, lVar.q(), 4);
            TiebaStatic.log(lVar.R());
            b.a.r0.h1.h.m.a.b(lVar.f14748e, lVar.t(), lVar.q(), 2);
        } else if (view.getId() == R.id.thread_card_root) {
            TiebaStatic.log(lVar.P(lVar.f14748e));
            b.a.r0.h1.h.m.a.b(lVar.f14748e, lVar.t(), lVar.q(), 1);
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b.a.r0.b0.e0.l.Y = "c10708";
            b.a.r0.b0.e0.l.Z = "c10735";
            b.a.r0.b0.e0.l.a0 = "c10709";
            b.a.r0.b0.e0.l.b0 = "c10734";
            b.a.r0.b0.e0.l.c0 = "c11929";
            b.a.r0.b0.e0.l.i0 = "c11928";
            b.a.r0.b0.e0.l.j0 = "c10756";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: o0 */
    public AutoVideoCardViewHolder<b.a.r0.b0.e0.l> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            b.a.r0.h1.h.o.b bVar2 = new b.a.r0.h1.h.o.b(this.n.getPageActivity());
            bVar2.u(new b(this, bVar2));
            this.r = bVar2;
            bVar2.w(this.m);
            this.r.t("index");
            this.r.x("2001");
            bVar.n(this.r);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
            AutoVideoCardViewHolder<b.a.r0.b0.e0.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.setPageId(this.m);
            k.o(this.s);
            k.q(2);
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
    @Override // b.a.e.l.e.a
    /* renamed from: p0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.b0.e0.l lVar, AutoVideoCardViewHolder<b.a.r0.b0.e0.l> autoVideoCardViewHolder) {
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
            lVar.f14748e.T1 = lVar.q();
            autoVideoCardViewHolder.getCardView().p(i2);
            lVar.W = 0;
            b.a.r0.b0.u.b().a(lVar.B());
            autoVideoCardViewHolder.setVideoStatsData(l0(lVar));
            if (autoVideoCardViewHolder.getCardView() != null) {
                autoVideoCardViewHolder.getCardView().setPage(this.p);
            }
            autoVideoCardViewHolder.onBindDataToView(lVar);
            autoVideoCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.getCardView().o(this.s);
            b.a.r0.h1.h.m.a.f(lVar.f14748e, this.m, lVar.q());
            b.a.r0.h1.h.m.a.e(lVar.f14748e, lVar.t(), lVar.q());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void q0(b.a.r0.h1.h.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.o = fVar;
        }
    }

    public void r0(b.a.e.l.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, sVar) == null) {
            this.q = sVar;
        }
    }
}
