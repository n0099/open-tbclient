package c.a.r0.n1.l.b;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.d.m.e.n;
import c.a.d.m.e.s;
import c.a.d.m.e.w;
import c.a.k.a;
import c.a.k.l0;
import c.a.k.t0;
import c.a.k.w0.a;
import c.a.r0.g0.d0;
import c.a.r0.g0.f0.l;
import c.a.r0.x2.p;
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
/* loaded from: classes6.dex */
public class b extends c.a.d.m.e.a<l, AutoVideoCardViewHolder<l>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public BdUniqueId n;
    public s o;
    public t0 p;
    public c.a.r0.n1.h.k.f q;
    public d0<l> r;

    /* loaded from: classes6.dex */
    public class a extends d0<l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f20735b;

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
                    return;
                }
            }
            this.f20735b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.g0.d0
        /* renamed from: d */
        public void a(View view, l lVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, lVar) == null) || view == null || lVar == null || lVar.getThreadData() == null) {
                return;
            }
            this.f20735b.m0(view, lVar);
            if (this.f20735b.q == null || !(view.getTag() instanceof String) || c.a.r0.n1.h.f.b(c.a.d.f.m.b.g(lVar.getThreadData().v1(), 0L))) {
                return;
            }
            c.a.r0.n1.h.f.a(c.a.d.f.m.b.g(lVar.getThreadData().v1(), 0L));
            this.f20735b.q.e(c.a.d.f.m.b.g(lVar.getThreadData().v1(), 0L), lVar.E(), lVar.t(), lVar.q(), lVar.g(), c.a.d.f.m.b.e("3", 1), "video_tab", lVar.getThreadData().L());
        }
    }

    /* renamed from: c.a.r0.n1.l.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1227b implements a.InterfaceC0129a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t0 a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f20736b;

        public C1227b(b bVar, t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20736b = bVar;
            this.a = t0Var;
        }

        @Override // c.a.k.a.InterfaceC0129a
        public void a(c.a.q0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (aVar instanceof l) {
                aVar.objType = 5;
                c.a.r0.n1.l.d.a.f((c.a.r0.g0.f0.b) aVar);
                c.a.r0.n1.l.d.a.c(aVar, this.f20736b.f2907e, 19, false, computeViewArea);
                return;
            }
            c.a.r0.n1.l.d.a.f((c.a.r0.g0.f0.b) aVar);
            c.a.r0.n1.l.d.a.c(aVar, this.f20736b.f2907e, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20737e;

        public c(b bVar) {
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
            this.f20737e = bVar;
        }

        @Override // c.a.d.m.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                l lVar = (l) nVar;
                lVar.f17251k = 1;
                if (this.f20737e.r != null) {
                    this.f20737e.r.a(threadCardViewHolder.getView(), lVar);
                }
                c.a.r0.n1.l.d.a.c(lVar, view.getContext(), 19, false, c.a.k.e.a((s) viewGroup, view, i2));
                threadCardViewHolder.getCardView().o(new a.C0131a(1));
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
        this.r = new a(this);
        this.m = tbPageContext;
    }

    public final p l0(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar)) == null) {
            if (lVar != null) {
                p pVar = new p();
                pVar.a = com.tencent.connect.common.Constants.VIA_ACT_TYPE_NINETEEN;
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
        return (p) invokeL.objValue;
    }

    public final void m0(View view, l lVar) {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view, lVar) == null) || (t0Var = this.p) == null || t0Var.o() == null || this.p.o().getMainView() == null) {
            return;
        }
        if (view.getId() == this.p.o().getMainView().getId()) {
            c.a.r0.n1.l.d.a.h(lVar);
        } else if (view.getId() == R.id.thread_card_root) {
            c.a.r0.n1.l.d.a.f(lVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: n0 */
    public AutoVideoCardViewHolder<l> S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.m.getPageActivity(), false);
            c.a.k.g gVar = new c.a.k.g(this.m.getPageActivity());
            gVar.u(new C1227b(this, gVar));
            this.p = gVar;
            gVar.w(this.n);
            this.p.t("video_tab");
            this.p.x("2001");
            bVar.n(this.p);
            l0 k2 = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.o);
            AutoVideoCardViewHolder<l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k2);
            autoVideoCardViewHolder.setPageId(this.n);
            k2.p(this.r);
            k2.r(19);
            c0(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: o0 */
    public View Z(int i2, View view, ViewGroup viewGroup, l lVar, AutoVideoCardViewHolder<l> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, lVar, autoVideoCardViewHolder})) == null) {
            if (lVar == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            lVar.K(lVar.position + 1);
            autoVideoCardViewHolder.getCardView().q(i2);
            autoVideoCardViewHolder.setVideoStatsData(l0(lVar));
            c.a.r0.n1.l.d.a.d(lVar);
            autoVideoCardViewHolder.onBindDataToView(lVar);
            autoVideoCardViewHolder.getCardView().onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.getCardView().p(this.r);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void onPause() {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (t0Var = this.p) == null) {
            return;
        }
        t0Var.r();
    }

    public void p0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            this.n = bdUniqueId;
        }
    }

    public void q0(c.a.r0.n1.h.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.q = fVar;
        }
    }

    public void r0(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, sVar) == null) {
            this.o = sVar;
        }
    }
}
