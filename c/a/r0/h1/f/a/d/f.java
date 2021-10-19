package c.a.r0.h1.f.a.d;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import c.a.e.l.e.n;
import c.a.e.l.e.s;
import c.a.e.l.e.w;
import c.a.l.a;
import c.a.l.l0;
import c.a.l.t0;
import c.a.l.v0.a;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import c.a.r0.b0.c0;
import c.a.r0.q2.o;
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
/* loaded from: classes3.dex */
public class f extends c.a.r0.h1.f.a.d.a<c2, AutoVideoCardViewHolder<d2>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t0 q;
    public c0<d2> r;

    /* loaded from: classes3.dex */
    public class a extends c0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f18249b;

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
            this.f18249b = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) {
                this.f18249b.h0(view, d2Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.InterfaceC0093a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f18250a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f18251b;

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
            this.f18251b = fVar;
            this.f18250a = t0Var;
        }

        @Override // c.a.l.a.InterfaceC0093a
        public void a(c.a.q0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f18250a.getVideoContainer());
            if (!(aVar instanceof d2)) {
                ThreadCardUtils.jumpToPB(aVar, this.f18251b.f2958e, 0, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f18251b.f2958e, 0, false, computeViewArea);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f18252e;

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
            this.f18252e = fVar;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view.getTag();
                d2 d2Var = ((c2) nVar).w;
                d2Var.objType = 1;
                if (this.f18252e.r != null) {
                    this.f18252e.r.a(autoVideoCardViewHolder.getView(), d2Var);
                }
                ThreadCardUtils.jumpToPB((c.a.q0.s.q.a) d2Var, view.getContext(), 0, false, c.a.l.e.a((s) viewGroup, view, i2));
                autoVideoCardViewHolder.getCardView().o(new a.C0095a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d2.x3);
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

    public final o p0(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var)) == null) {
            if (d2Var != null) {
                o oVar = new o();
                oVar.f23997a = "20";
                oVar.f23999c = d2Var.E;
                oVar.f24002f = d2Var.X0;
                oVar.f24003g = d2Var.Z0;
                oVar.f24004h = d2Var.Y0;
                oVar.f24005i = "14";
                oVar.q = String.valueOf(d2Var.T1);
                if (d2Var.p1() != null) {
                    oVar.k = String.valueOf(d2Var.p1().f14272a);
                }
                d2Var.getThreadData();
                if (d2Var != null) {
                    d2Var.getThreadData();
                    oVar.f24000d = String.valueOf(d2Var.T());
                    d2Var.getThreadData();
                    oVar.v = d2Var.F0();
                    d2Var.getThreadData();
                    if (d2Var.q1() != null) {
                        d2Var.getThreadData();
                        oVar.m = d2Var.q1().video_md5;
                        d2Var.getThreadData();
                        oVar.p = String.valueOf(d2Var.q1().is_vertical);
                    }
                }
                oVar.f24001e = TbadkCoreApplication.getCurrentAccount();
                d2Var.getThreadData();
                if (d2Var != null) {
                    d2Var.getThreadData();
                    if (d2Var.L() != null) {
                        d2Var.getThreadData();
                        oVar.t = d2Var.L().oriUgcNid;
                        d2Var.getThreadData();
                        oVar.u = d2Var.L().oriUgcVid;
                        return oVar;
                    }
                    return oVar;
                }
                return oVar;
            }
            return null;
        }
        return (o) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: q0 */
    public AutoVideoCardViewHolder<d2> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            c.a.l.g gVar = new c.a.l.g(this.n.getPageActivity());
            gVar.u(new b(this, gVar));
            this.q = gVar;
            gVar.w(this.f2962i);
            this.q.t("hot_juhe");
            this.q.x("2001");
            bVar.n(this.q);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.o);
            AutoVideoCardViewHolder<d2> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.setPageId(this.f2962i);
            k.p(this.r);
            k.r(0);
            d0(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.h1.f.a.d.a, c.a.e.l.e.a
    /* renamed from: r0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c2 c2Var, AutoVideoCardViewHolder<d2> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, c2Var, autoVideoCardViewHolder})) == null) {
            if (c2Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            c2Var.w.T1 = D(i2) + 1;
            autoVideoCardViewHolder.getCardView().q(i2);
            autoVideoCardViewHolder.setVideoStatsData(p0(c2Var.w));
            autoVideoCardViewHolder.onBindDataToView(c2Var.w);
            autoVideoCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.getCardView().p(this.r);
            l0(autoVideoCardViewHolder.getView(), c2Var.w, i2, i2);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
