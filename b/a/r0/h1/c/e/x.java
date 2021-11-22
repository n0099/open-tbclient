package b.a.r0.h1.c.e;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.l.a;
import b.a.l.l0;
import b.a.l.t0;
import b.a.l.w0.a;
import b.a.r0.b0.d0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
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
public class x extends b.a.e.m.e.a<b.a.r0.b0.f0.l, AutoVideoCardViewHolder<b.a.r0.b0.f0.l>> implements b.a.r0.p.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public BdUniqueId n;
    public TbPageContext<?> o;
    public String p;
    public b.a.e.m.e.s q;
    public t0 r;
    public d0<b.a.r0.b0.f0.l> s;

    /* loaded from: classes4.dex */
    public class a extends d0<b.a.r0.b0.f0.l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ x f18485b;

        public a(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18485b = xVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.d0
        /* renamed from: d */
        public void a(View view, b.a.r0.b0.f0.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, lVar) == null) {
                b.a.r0.b0.v.b().d(true);
                b.a.r0.p.d.c().h("page_recommend", "show_");
                if (lVar == null || lVar.getThreadData() == null || StringUtils.isNull(lVar.getThreadData().t1())) {
                    return;
                }
                if (lVar.getThreadData().w1 <= 0) {
                    this.f18485b.l0(view, lVar);
                } else {
                    TiebaStatic.log(lVar.P(lVar.getThreadData()));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.InterfaceC0090a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f18486a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ x f18487b;

        public b(x xVar, t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar, t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18487b = xVar;
            this.f18486a = t0Var;
        }

        @Override // b.a.l.a.InterfaceC0090a
        public void a(b.a.q0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f18486a.getVideoContainer());
            if (!(aVar instanceof b.a.r0.b0.f0.l)) {
                ThreadCardUtils.jumpToPB(aVar, this.f18487b.f2421e, 1, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f18487b.f2421e, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements b.a.e.m.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ x f18488e;

        public c(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18488e = xVar;
        }

        @Override // b.a.e.m.e.w
        public void b(View view, b.a.e.m.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof b.a.e.m.e.g) && (view.getTag() instanceof ThreadCardViewHolder)) {
                b.a.e.m.e.g gVar = (b.a.e.m.e.g) nVar;
                if (gVar.g() instanceof b.a.r0.b0.f0.l) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    b.a.r0.b0.f0.l lVar = (b.a.r0.b0.f0.l) gVar.g();
                    lVar.k = 1;
                    if (this.f18488e.s != null) {
                        this.f18488e.s.a(threadCardViewHolder.getView(), lVar);
                    }
                    ThreadCardUtils.jumpToPB((b.a.q0.s.q.a) lVar, view.getContext(), 1, false, b.a.l.e.a((b.a.e.m.e.s) viewGroup, view, i2));
                    threadCardViewHolder.getCardView().n(new a.C0092a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
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
        this.o = tbPageContext;
        this.n = bdUniqueId2;
    }

    @Override // b.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.p = str;
        }
    }

    public final b.a.r0.q2.p k0(b.a.r0.b0.f0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, lVar)) == null) {
            if (lVar != null) {
                b.a.r0.q2.p pVar = new b.a.r0.q2.p();
                pVar.f24403a = "1";
                pVar.f24405c = lVar.l;
                if (lVar.getThreadData() != null) {
                    pVar.f24406d = String.valueOf(lVar.getThreadData().T());
                    if (lVar.getThreadData().r1() != null) {
                        pVar.m = lVar.getThreadData().r1().video_md5;
                        pVar.p = String.valueOf(lVar.getThreadData().r1().is_vertical);
                    }
                }
                pVar.k = lVar.k();
                pVar.f24408f = lVar.t();
                pVar.l = lVar.g();
                pVar.f24410h = lVar.E();
                pVar.f24407e = TbadkCoreApplication.getCurrentAccount();
                pVar.q = String.valueOf(lVar.q());
                return pVar;
            }
            return null;
        }
        return (b.a.r0.q2.p) invokeL.objValue;
    }

    public final void l0(View view, b.a.r0.b0.f0.l lVar) {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, view, lVar) == null) || (t0Var = this.r) == null || t0Var.o() == null || this.r.o().getMainView() == null) {
            return;
        }
        if (view.getId() == this.r.o().getMainView().getId()) {
            b.a.r0.h1.c.c.b(view, lVar, 4);
        } else if (view.getId() == R.id.thread_card_root) {
            b.a.r0.h1.c.c.b(view, lVar, 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: m0 */
    public AutoVideoCardViewHolder<b.a.r0.b0.f0.l> Q(ViewGroup viewGroup, b.a.r0.b0.f0.l lVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, viewGroup, lVar)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity(), false);
            b.a.r0.h1.h.o.b bVar2 = new b.a.r0.h1.h.o.b(this.o.getPageActivity());
            bVar2.w(this.m);
            bVar2.t("concern_tab");
            bVar2.u(new b(this, bVar2));
            this.r = bVar2;
            bVar.n(bVar2);
            t0 t0Var = this.r;
            if (t0Var != null) {
                t0Var.x("2001");
            }
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
            AutoVideoCardViewHolder<b.a.r0.b0.f0.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.setPageId(this.m);
            k.o(this.s);
            k.q(1);
            c0(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: n0 */
    public AutoVideoCardViewHolder<b.a.r0.b0.f0.l> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            return null;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: o0 */
    public View W(int i2, View view, ViewGroup viewGroup, b.a.r0.b0.f0.l lVar, AutoVideoCardViewHolder<b.a.r0.b0.f0.l> autoVideoCardViewHolder) {
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
            b.a.r0.b0.v.b().a(lVar.i("c12351"));
            autoVideoCardViewHolder.getCardView().p(i2);
            lVar.Y = 0;
            autoVideoCardViewHolder.setVideoStatsData(k0(lVar));
            if (autoVideoCardViewHolder.getCardView() instanceof b.a.r0.p.e) {
                autoVideoCardViewHolder.getCardView().setPage(this.p);
            }
            autoVideoCardViewHolder.onBindDataToView(lVar);
            autoVideoCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.getCardView().o(this.s);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: p0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.b0.f0.l lVar, AutoVideoCardViewHolder<b.a.r0.b0.f0.l> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), view, viewGroup, lVar, autoVideoCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public void q0(b.a.e.m.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, sVar) == null) {
            this.q = sVar;
        }
    }

    @Override // b.a.e.m.e.a
    public BdUniqueId v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? b.a.r0.b0.f0.b.R : (BdUniqueId) invokeV.objValue;
    }

    @Override // b.a.e.m.e.a
    public BdUniqueId w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? b.a.r0.b0.f0.b.O : (BdUniqueId) invokeV.objValue;
    }

    @Override // b.a.e.m.e.a
    public BdUniqueId x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? b.a.r0.b0.f0.b.Q : (BdUniqueId) invokeV.objValue;
    }

    @Override // b.a.e.m.e.a
    public BdUniqueId y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            BdUniqueId bdUniqueId = this.n;
            return bdUniqueId != null ? bdUniqueId : b.a.r0.b0.f0.b.I;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
