package c.a.t0.p1.f.a.d;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import c.a.d.n.e.n;
import c.a.d.n.e.s;
import c.a.d.n.e.v;
import c.a.l.a;
import c.a.l.l0;
import c.a.l.t0;
import c.a.l.w0.a;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.e2;
import c.a.t0.a3.t;
import c.a.t0.g0.d0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UVEventType;
/* loaded from: classes8.dex */
public class f extends c.a.t0.p1.f.a.d.a<d2, AutoVideoCardViewHolder<e2>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t0 q;
    public d0<e2> r;

    /* loaded from: classes8.dex */
    public class a extends d0<e2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f20666b;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20666b = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.g0.d0
        /* renamed from: d */
        public void a(View view, e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, e2Var) == null) {
                this.f20666b.Z(view, e2Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.InterfaceC0202a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t0 a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f20667b;

        public b(f fVar, t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20667b = fVar;
            this.a = t0Var;
        }

        @Override // c.a.l.a.InterfaceC0202a
        public void a(c.a.s0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(aVar instanceof e2)) {
                ThreadCardUtils.jumpToPB(aVar, this.f20667b.f3360e, 0, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f20667b.f3360e, 0, false, computeViewArea);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f20668e;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20668e = fVar;
        }

        @Override // c.a.d.n.e.v
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof d2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view.getTag();
                e2 e2Var = ((d2) nVar).w;
                e2Var.objType = 1;
                if (this.f20668e.r != null) {
                    this.f20668e.r.a(autoVideoCardViewHolder.getView(), e2Var);
                }
                ThreadCardUtils.jumpToPB((c.a.s0.s.q.a) e2Var, view.getContext(), 0, false, c.a.l.e.a((s) viewGroup, view, i2));
                autoVideoCardViewHolder.getCardView().o(new a.C0204a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), e2.H3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
    }

    public final t h0(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2Var)) == null) {
            if (e2Var != null) {
                t tVar = new t();
                tVar.a = UVEventType.PAY_WALLET_BANNER_SHOW;
                tVar.f15288c = e2Var.E;
                tVar.f15291f = e2Var.Z0;
                tVar.f15292g = e2Var.b1;
                tVar.f15293h = e2Var.a1;
                tVar.f15294i = "14";
                tVar.q = String.valueOf(e2Var.T1);
                if (e2Var.t1() != null) {
                    tVar.k = String.valueOf(e2Var.t1().a);
                }
                if (e2Var.getThreadData() != null) {
                    tVar.f15289d = String.valueOf(e2Var.getThreadData().U());
                    tVar.v = e2Var.getThreadData().H0();
                    if (e2Var.getThreadData().u1() != null) {
                        tVar.m = e2Var.getThreadData().u1().video_md5;
                        tVar.p = String.valueOf(e2Var.getThreadData().u1().is_vertical);
                    }
                }
                tVar.f15290e = TbadkCoreApplication.getCurrentAccount();
                if (e2Var.getThreadData() == null || e2Var.getThreadData().L() == null) {
                    return tVar;
                }
                tVar.t = e2Var.getThreadData().L().oriUgcNid;
                tVar.u = e2Var.getThreadData().L().oriUgcVid;
                return tVar;
            }
            return null;
        }
        return (t) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: i0 */
    public AutoVideoCardViewHolder<e2> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            c.a.l.g gVar = new c.a.l.g(this.n.getPageActivity());
            gVar.u(new b(this, gVar));
            this.q = gVar;
            gVar.w(this.f3364i);
            this.q.t("hot_juhe");
            this.q.x("2001");
            bVar.n(this.q);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.o);
            AutoVideoCardViewHolder<e2> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.setPageId(this.f3364i);
            k.p(this.r);
            k.r(0);
            V(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.p1.f.a.d.a, c.a.d.n.e.a
    /* renamed from: j0 */
    public View S(int i2, View view, ViewGroup viewGroup, d2 d2Var, AutoVideoCardViewHolder<e2> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, d2Var, autoVideoCardViewHolder})) == null) {
            if (d2Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            d2Var.w.T1 = C(i2) + 1;
            autoVideoCardViewHolder.getCardView().q(i2);
            autoVideoCardViewHolder.setVideoStatsData(h0(d2Var.w));
            autoVideoCardViewHolder.onBindDataToView(d2Var.w);
            autoVideoCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.getCardView().p(this.r);
            d0(autoVideoCardViewHolder.getView(), d2Var.w, i2, i2);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
