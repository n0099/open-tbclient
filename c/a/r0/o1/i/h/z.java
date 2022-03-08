package c.a.r0.o1.i.h;

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
public class z extends c.a.d.o.e.a<c.a.r0.f0.d0.l, AutoVideoCardViewHolder<c.a.r0.f0.d0.l>> implements c.a.r0.t.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public c.a.r0.o1.i.k.f o;
    public String p;
    public c.a.d.o.e.s q;
    public t0 r;
    public c.a.r0.f0.b0<c.a.r0.f0.d0.l> s;

    /* loaded from: classes2.dex */
    public class a extends c.a.r0.f0.b0<c.a.r0.f0.d0.l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f20080b;

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
            this.f20080b = zVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.f0.b0
        /* renamed from: d */
        public void a(View view, c.a.r0.f0.d0.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, lVar) == null) {
                c.a.r0.f0.u.b().d(true);
                c.a.r0.t.d.c().h("page_recommend", "show_");
                if (this.f20080b.o == null || lVar == null || lVar.getThreadData() == null || StringUtils.isNull(lVar.getThreadData().w1())) {
                    return;
                }
                if (lVar.getThreadData().x1 > 0) {
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(lVar.O(lVar.getThreadData())));
                    return;
                }
                if ((view.getTag() instanceof String) && !c.a.r0.o1.i.f.b(c.a.d.f.m.b.g(lVar.getThreadData().w1(), 0L))) {
                    c.a.r0.o1.i.f.a(c.a.d.f.m.b.g(lVar.getThreadData().w1(), 0L));
                    this.f20080b.o.e(c.a.d.f.m.b.g(lVar.getThreadData().w1(), 0L), lVar.D(), lVar.t(), lVar.q(), lVar.g(), c.a.d.f.m.b.e((String) view.getTag(), 1), "homepage", lVar.getThreadData().L());
                }
                this.f20080b.f0(view, lVar);
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.InterfaceC0201a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t0 a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f20081b;

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
            this.f20081b = zVar;
            this.a = t0Var;
        }

        @Override // c.a.l.a.InterfaceC0201a
        public void a(c.a.q0.r.r.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(aVar instanceof c.a.r0.f0.d0.l)) {
                ThreadCardUtils.jumpToPB(aVar, this.f20081b.f3076e, 2, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f20081b.f3076e, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements c.a.d.o.e.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ z f20082e;

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
            this.f20082e = zVar;
        }

        @Override // c.a.d.o.e.v
        public void b(View view, c.a.d.o.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c.a.r0.f0.d0.l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view.getTag();
                c.a.r0.f0.d0.l lVar = (c.a.r0.f0.d0.l) nVar;
                lVar.f17277j = 1;
                if (this.f20082e.s != null) {
                    this.f20082e.s.a(autoVideoCardViewHolder.getView(), lVar);
                }
                ThreadCardUtils.jumpToPB((c.a.q0.r.r.a) lVar, view.getContext(), 2, false, c.a.l.e.a((c.a.d.o.e.s) viewGroup, view, i2));
                autoVideoCardViewHolder.getCardView().o(new a.C0203a(1));
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
        g0();
    }

    public final c.a.r0.a3.t e0(c.a.r0.f0.d0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar)) == null) {
            if (lVar != null) {
                c.a.r0.a3.t tVar = new c.a.r0.a3.t();
                tVar.a = "1";
                tVar.f14940c = lVar.k;
                if (lVar.getThreadData() != null) {
                    tVar.f14941d = String.valueOf(lVar.getThreadData().U());
                    tVar.v = lVar.getThreadData().H0();
                    if (lVar.getThreadData().u1() != null) {
                        tVar.m = lVar.getThreadData().u1().video_md5;
                        tVar.p = String.valueOf(lVar.getThreadData().u1().is_vertical);
                    }
                }
                tVar.k = lVar.k();
                tVar.f14943f = lVar.t();
                tVar.l = lVar.g();
                tVar.f14945h = lVar.D();
                tVar.f14942e = TbadkCoreApplication.getCurrentAccount();
                tVar.q = String.valueOf(lVar.q());
                if (lVar.getThreadData() == null || lVar.getThreadData().L() == null) {
                    return tVar;
                }
                tVar.t = lVar.getThreadData().L().oriUgcNid;
                tVar.u = lVar.getThreadData().L().oriUgcVid;
                return tVar;
            }
            return null;
        }
        return (c.a.r0.a3.t) invokeL.objValue;
    }

    public final void f0(View view, c.a.r0.f0.d0.l lVar) {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view, lVar) == null) || (t0Var = this.r) == null || t0Var.o() == null || this.r.o().getMainView() == null) {
            return;
        }
        if (view.getId() == this.r.o().getMainView().getId()) {
            c.a.r0.o1.i.m.a.d(lVar.f17272e, this.m, lVar.q(), 4);
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(lVar.Q()));
            c.a.r0.o1.i.m.a.c(lVar.f17272e, lVar.t(), lVar.q(), 2);
        } else if (view.getId() == R.id.thread_card_root) {
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(lVar.O(lVar.f17272e)));
            c.a.r0.o1.i.m.a.c(lVar.f17272e, lVar.t(), lVar.q(), 1);
        }
    }

    @Override // c.a.r0.t.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.p = str;
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.r0.f0.d0.l.Z = "c10708";
            c.a.r0.f0.d0.l.a0 = "c10735";
            c.a.r0.f0.d0.l.b0 = "c10709";
            c.a.r0.f0.d0.l.c0 = "c10734";
            c.a.r0.f0.d0.l.d0 = "c11929";
            c.a.r0.f0.d0.l.e0 = "c11928";
            c.a.r0.f0.d0.l.f0 = "c10756";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: h0 */
    public AutoVideoCardViewHolder<c.a.r0.f0.d0.l> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            c.a.r0.o1.i.o.b bVar2 = new c.a.r0.o1.i.o.b(this.n.getPageActivity());
            bVar2.u(new b(this, bVar2));
            this.r = bVar2;
            bVar2.w(this.m);
            this.r.t("index");
            this.r.x("2001");
            bVar.n(this.r);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
            AutoVideoCardViewHolder<c.a.r0.f0.d0.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.setPageId(this.m);
            k.p(this.s);
            k.r(2);
            V(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: i0 */
    public View S(int i2, View view, ViewGroup viewGroup, c.a.r0.f0.d0.l lVar, AutoVideoCardViewHolder<c.a.r0.f0.d0.l> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), view, viewGroup, lVar, autoVideoCardViewHolder})) == null) {
            if (lVar == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            lVar.J(lVar.position + 1);
            lVar.f17272e.T1 = lVar.q();
            autoVideoCardViewHolder.getCardView().q(i2);
            lVar.X = 0;
            c.a.r0.f0.u.b().a(lVar.B());
            autoVideoCardViewHolder.setVideoStatsData(e0(lVar));
            if (autoVideoCardViewHolder.getCardView() != null) {
                autoVideoCardViewHolder.getCardView().d(this.p);
            }
            autoVideoCardViewHolder.onBindDataToView(lVar);
            autoVideoCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.getCardView().p(this.s);
            c.a.r0.o1.i.m.a.h(lVar.f17272e, this.m, lVar.q());
            c.a.r0.o1.i.m.a.g(lVar.f17272e, lVar.t(), lVar.q());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void j0(c.a.r0.o1.i.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.o = fVar;
        }
    }

    public void k0(c.a.d.o.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, sVar) == null) {
            this.q = sVar;
        }
    }

    public void onPause() {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (t0Var = this.r) == null) {
            return;
        }
        t0Var.r();
    }

    public void onResume() {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (t0Var = this.r) == null) {
            return;
        }
        t0Var.s();
    }
}
