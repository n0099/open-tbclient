package c.a.q0.f1.j.g;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import c.a.e.l.e.s;
import c.a.e.l.e.w;
import c.a.l.a;
import c.a.l.l0;
import c.a.l.t0;
import c.a.l.v0.a;
import c.a.p0.s.q.b2;
import c.a.p0.s.q.c2;
import c.a.q0.a0.b0;
import c.a.q0.a0.t;
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
public class r extends c.a.e.l.e.a<b2, AutoVideoCardViewHolder<c2>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public String n;
    public TbPageContext<?> o;
    public s p;
    public t0 q;
    public b0<c2> r;

    /* loaded from: classes3.dex */
    public class a extends b0<c2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ r f17907b;

        public a(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17907b = rVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, c2 c2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, c2Var) == null) {
                t.b().d(true);
                c.a.q0.f1.j.c.e(view, c2Var, this.f17907b.n);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.InterfaceC0094a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f17908a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ r f17909b;

        public b(r rVar, t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar, t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17909b = rVar;
            this.f17908a = t0Var;
        }

        @Override // c.a.l.a.InterfaceC0094a
        public void a(c.a.p0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f17908a.getVideoContainer());
            if (!(aVar instanceof c2)) {
                ThreadCardUtils.jumpToPB(aVar, this.f17909b.f2966e, 2, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f17909b.f2966e, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ r f17910e;

        public c(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17910e = rVar;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, c.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof b2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view.getTag();
                c2 c2Var = ((b2) nVar).w;
                c2Var.objType = 1;
                if (this.f17910e.r != null) {
                    this.f17910e.r.a(autoVideoCardViewHolder.getView(), c2Var);
                }
                ThreadCardUtils.jumpToPB((c.a.p0.s.q.a) c2Var, view.getContext(), 0, false, c.a.l.e.a((s) viewGroup, view, i2));
                autoVideoCardViewHolder.getCardView().o(new a.C0096a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2, str};
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
        this.o = tbPageContext;
        this.m = bdUniqueId2;
        this.n = str;
    }

    public final c.a.q0.o2.o l0(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c2Var)) == null) {
            if (c2Var != null) {
                c.a.q0.o2.o oVar = new c.a.q0.o2.o();
                oVar.f23216a = "20";
                oVar.f23218c = c2Var.B;
                oVar.f23221f = c2Var.U0;
                oVar.f23222g = c2Var.W0;
                oVar.f23223h = c2Var.V0;
                oVar.f23224i = "14";
                oVar.s = this.n;
                oVar.q = String.valueOf(c2Var.Q1);
                if (c2Var.n1() != null) {
                    oVar.k = String.valueOf(c2Var.n1().f14281a);
                }
                c2Var.getThreadData();
                if (c2Var != null) {
                    c2Var.getThreadData();
                    oVar.f23219d = String.valueOf(c2Var.T());
                    c2Var.getThreadData();
                    oVar.v = c2Var.D0();
                    c2Var.getThreadData();
                    if (c2Var.o1() != null) {
                        c2Var.getThreadData();
                        oVar.m = c2Var.o1().video_md5;
                        c2Var.getThreadData();
                        oVar.p = String.valueOf(c2Var.o1().is_vertical);
                    }
                }
                oVar.f23220e = TbadkCoreApplication.getCurrentAccount();
                c2Var.getThreadData();
                if (c2Var != null) {
                    c2Var.getThreadData();
                    if (c2Var.L() != null) {
                        c2Var.getThreadData();
                        oVar.t = c2Var.L().oriUgcNid;
                        c2Var.getThreadData();
                        oVar.u = c2Var.L().oriUgcVid;
                        return oVar;
                    }
                    return oVar;
                }
                return oVar;
            }
            return null;
        }
        return (c.a.q0.o2.o) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: m0 */
    public AutoVideoCardViewHolder<c2> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity(), false);
            c.a.l.g gVar = new c.a.l.g(this.o.getPageActivity());
            gVar.u(new b(this, gVar));
            this.q = gVar;
            gVar.w(this.m);
            this.q.t("index");
            this.q.x("2001");
            bVar.n(this.q);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.p);
            AutoVideoCardViewHolder<c2> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.setPageId(this.m);
            k.p(this.r);
            k.r(2);
            d0(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: n0 */
    public View a0(int i2, View view, ViewGroup viewGroup, b2 b2Var, AutoVideoCardViewHolder<c2> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, b2Var, autoVideoCardViewHolder})) == null) {
            if (b2Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            b2Var.w.Q1 = D(i2) + 1;
            autoVideoCardViewHolder.getCardView().q(i2);
            autoVideoCardViewHolder.setVideoStatsData(l0(b2Var.w));
            autoVideoCardViewHolder.onBindDataToView(b2Var.w);
            autoVideoCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.getCardView().p(this.r);
            c.a.q0.f1.j.c.f(b2Var, this.n);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void o0(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sVar) == null) {
            this.p = sVar;
        }
    }
}
