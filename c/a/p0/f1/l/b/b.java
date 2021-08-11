package c.a.p0.f1.l.b;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.e.k.e.n;
import c.a.e.k.e.s;
import c.a.e.k.e.w;
import c.a.l.a;
import c.a.l.l0;
import c.a.l.t0;
import c.a.l.v0.a;
import c.a.p0.a0.b0;
import c.a.p0.a0.d0.l;
import c.a.p0.o2.o;
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
/* loaded from: classes3.dex */
public class b extends c.a.e.k.e.a<l, AutoVideoCardViewHolder<l>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public BdUniqueId n;
    public s o;
    public t0 p;
    public c.a.p0.f1.h.k.e q;
    public b0<l> r;

    /* loaded from: classes3.dex */
    public class a extends b0<l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f17707b;

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
            this.f17707b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a0.b0
        /* renamed from: d */
        public void a(View view, l lVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, lVar) == null) || view == null || lVar == null || lVar.getThreadData() == null) {
                return;
            }
            this.f17707b.n0(view, lVar);
            if (this.f17707b.q == null || !(view.getTag() instanceof String) || c.a.p0.f1.h.f.b(c.a.e.e.m.b.f(lVar.getThreadData().q1(), 0L))) {
                return;
            }
            c.a.p0.f1.h.f.a(c.a.e.e.m.b.f(lVar.getThreadData().q1(), 0L));
            this.f17707b.q.e(c.a.e.e.m.b.f(lVar.getThreadData().q1(), 0L), lVar.E(), lVar.t(), lVar.q(), lVar.g(), c.a.e.e.m.b.d("3", 1), "video_tab", lVar.getThreadData().L());
        }
    }

    /* renamed from: c.a.p0.f1.l.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0856b implements a.InterfaceC0086a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f17708a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f17709b;

        public C0856b(b bVar, t0 t0Var) {
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
            this.f17709b = bVar;
            this.f17708a = t0Var;
        }

        @Override // c.a.l.a.InterfaceC0086a
        public void a(c.a.o0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f17708a.getVideoContainer());
            if (aVar instanceof l) {
                aVar.objType = 5;
                c.a.p0.f1.l.d.a.f((c.a.p0.a0.d0.b) aVar);
                c.a.p0.f1.l.d.a.c(aVar, this.f17709b.f2904e, 19, false, computeViewArea);
                return;
            }
            c.a.p0.f1.l.d.a.f((c.a.p0.a0.d0.b) aVar);
            c.a.p0.f1.l.d.a.c(aVar, this.f17709b.f2904e, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17710e;

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
            this.f17710e = bVar;
        }

        @Override // c.a.e.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                l lVar = (l) nVar;
                lVar.k = 1;
                if (this.f17710e.r != null) {
                    this.f17710e.r.a(threadCardViewHolder.getView(), lVar);
                }
                c.a.p0.f1.l.d.a.c(lVar, view.getContext(), 19, false, c.a.l.e.a((s) viewGroup, view, i2));
                threadCardViewHolder.getCardView().o(new a.C0088a(1));
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

    public final o m0(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar)) == null) {
            if (lVar != null) {
                o oVar = new o();
                oVar.f22884a = com.tencent.connect.common.Constants.VIA_ACT_TYPE_NINETEEN;
                oVar.f22886c = lVar.l;
                if (lVar.getThreadData() != null) {
                    oVar.f22887d = String.valueOf(lVar.getThreadData().T());
                    oVar.v = lVar.getThreadData().D0();
                    if (lVar.getThreadData().o1() != null) {
                        oVar.m = lVar.getThreadData().o1().video_md5;
                        oVar.p = String.valueOf(lVar.getThreadData().o1().is_vertical);
                    }
                }
                oVar.k = lVar.k();
                oVar.f22889f = lVar.t();
                oVar.l = lVar.g();
                oVar.f22891h = lVar.E();
                oVar.f22888e = TbadkCoreApplication.getCurrentAccount();
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
        return (o) invokeL.objValue;
    }

    public final void n0(View view, l lVar) {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view, lVar) == null) || (t0Var = this.p) == null || t0Var.o() == null || this.p.o().getMainView() == null) {
            return;
        }
        if (view.getId() == this.p.o().getMainView().getId()) {
            c.a.p0.f1.l.d.a.h(lVar);
        } else if (view.getId() == R.id.thread_card_root) {
            c.a.p0.f1.l.d.a.f(lVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.k.e.a
    /* renamed from: o0 */
    public AutoVideoCardViewHolder<l> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.m.getPageActivity(), false);
            c.a.l.g gVar = new c.a.l.g(this.m.getPageActivity());
            gVar.u(new C0856b(this, gVar));
            this.p = gVar;
            gVar.w(this.n);
            this.p.t("video_tab");
            this.p.x("2001");
            bVar.n(this.p);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.o);
            AutoVideoCardViewHolder<l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.setPageId(this.n);
            k.p(this.r);
            k.r(19);
            d0(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    public void onPause() {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (t0Var = this.p) == null) {
            return;
        }
        t0Var.r();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.k.e.a
    /* renamed from: p0 */
    public View a0(int i2, View view, ViewGroup viewGroup, l lVar, AutoVideoCardViewHolder<l> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, lVar, autoVideoCardViewHolder})) == null) {
            if (lVar == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            lVar.K(lVar.position + 1);
            autoVideoCardViewHolder.getCardView().q(i2);
            autoVideoCardViewHolder.setVideoStatsData(m0(lVar));
            c.a.p0.f1.l.d.a.d(lVar);
            autoVideoCardViewHolder.onBindDataToView(lVar);
            autoVideoCardViewHolder.getCardView().onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.getCardView().p(this.r);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void q0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            this.n = bdUniqueId;
        }
    }

    public void r0(c.a.p0.f1.h.k.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            this.q = eVar;
        }
    }

    public void s0(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, sVar) == null) {
            this.o = sVar;
        }
    }
}
