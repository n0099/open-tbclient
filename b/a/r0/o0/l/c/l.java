package b.a.r0.o0.l.c;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import b.a.e.l.e.n;
import b.a.e.l.e.s;
import b.a.e.l.e.w;
import b.a.l.a;
import b.a.l.l0;
import b.a.l.t0;
import b.a.l.v0.a;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.r0.b0.c0;
import b.a.r0.b0.u;
import b.a.r0.q2.p;
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
/* loaded from: classes5.dex */
public class l extends b.a.e.l.e.a<c2, AutoVideoCardViewHolder<d2>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public String n;
    public TbPageContext<?> o;
    public s p;
    public t0 q;
    public c0<d2> r;

    /* loaded from: classes5.dex */
    public class a extends c0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f21789b;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21789b = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) {
                u.b().d(true);
                b.a.r0.o0.a.a(view, d2Var, this.f21789b.n);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.InterfaceC0088a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f21790a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f21791b;

        public b(l lVar, t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21791b = lVar;
            this.f21790a = t0Var;
        }

        @Override // b.a.l.a.InterfaceC0088a
        public void a(b.a.q0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f21790a.getVideoContainer());
            if (!(aVar instanceof d2)) {
                ThreadCardUtils.jumpToPB(aVar, this.f21791b.f2419e, 2, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f21791b.f2419e, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f21792e;

        public c(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21792e = lVar;
        }

        @Override // b.a.e.l.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof c2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view.getTag();
                d2 d2Var = ((c2) nVar).w;
                d2Var.objType = 1;
                if (this.f21792e.r != null) {
                    this.f21792e.r.a(autoVideoCardViewHolder.getView(), d2Var);
                }
                ThreadCardUtils.jumpToPB((b.a.q0.s.q.a) d2Var, view.getContext(), 2, false, b.a.l.e.a((s) viewGroup, view, i2));
                autoVideoCardViewHolder.getCardView().n(new a.C0090a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
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

    public final p k0(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var)) == null) {
            if (d2Var != null) {
                p pVar = new p();
                pVar.f22882a = "20";
                pVar.f22884c = d2Var.E;
                pVar.f22887f = d2Var.X0;
                pVar.f22888g = d2Var.Z0;
                pVar.f22889h = d2Var.Y0;
                pVar.f22890i = "14";
                pVar.s = this.n;
                pVar.q = String.valueOf(d2Var.T1);
                if (d2Var.p1() != null) {
                    pVar.k = String.valueOf(d2Var.p1().f13385a);
                }
                if (d2Var.getThreadData() != null) {
                    pVar.f22885d = String.valueOf(d2Var.getThreadData().T());
                    pVar.v = d2Var.getThreadData().F0();
                    if (d2Var.getThreadData().q1() != null) {
                        pVar.m = d2Var.getThreadData().q1().video_md5;
                        pVar.p = String.valueOf(d2Var.getThreadData().q1().is_vertical);
                    }
                }
                pVar.f22886e = TbadkCoreApplication.getCurrentAccount();
                if (d2Var.getThreadData() == null || d2Var.getThreadData().L() == null) {
                    return pVar;
                }
                pVar.t = d2Var.getThreadData().L().oriUgcNid;
                pVar.u = d2Var.getThreadData().L().oriUgcVid;
                return pVar;
            }
            return null;
        }
        return (p) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: l0 */
    public AutoVideoCardViewHolder<d2> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity(), false);
            b.a.l.g gVar = new b.a.l.g(this.o.getPageActivity());
            gVar.u(new b(this, gVar));
            this.q = gVar;
            gVar.w(this.m);
            this.q.t("14");
            this.q.x("2001");
            bVar.n(this.q);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.p);
            AutoVideoCardViewHolder<d2> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.setPageId(this.m);
            k.o(this.r);
            k.q(2);
            c0(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: m0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c2 c2Var, AutoVideoCardViewHolder<d2> autoVideoCardViewHolder) {
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
            autoVideoCardViewHolder.getCardView().p(i2);
            autoVideoCardViewHolder.setVideoStatsData(k0(c2Var.w));
            autoVideoCardViewHolder.onBindDataToView(c2Var.w);
            autoVideoCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.getCardView().o(this.r);
            b.a.r0.o0.a.b(c2Var, this.n);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void n0(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sVar) == null) {
            this.p = sVar;
        }
    }
}
