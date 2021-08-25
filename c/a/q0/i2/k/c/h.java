package c.a.q0.i2.k.c;

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
import c.a.q0.a0.b0;
import c.a.q0.a0.d0.l;
import c.a.q0.a0.t;
import c.a.q0.o2.o;
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
/* loaded from: classes3.dex */
public class h extends c.a.e.l.e.a<l, AutoVideoCardViewHolder<l>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public s o;
    public t0 p;
    public b0<l> q;

    /* loaded from: classes3.dex */
    public class a extends b0<l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f19190b;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19190b = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, lVar) == null) {
                t.b().d(true);
                if (lVar == null || lVar.getThreadData() == null || StringUtils.isNull(lVar.getThreadData().q1())) {
                    return;
                }
                if (lVar.getThreadData().t1 <= 0) {
                    this.f19190b.m0(view, lVar);
                } else {
                    TiebaStatic.log(lVar.P(lVar.getThreadData()));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.InterfaceC0094a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f19191a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f19192b;

        public b(h hVar, t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19192b = hVar;
            this.f19191a = t0Var;
        }

        @Override // c.a.l.a.InterfaceC0094a
        public void a(c.a.p0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f19191a.getVideoContainer());
            if (!(aVar instanceof l)) {
                ThreadCardUtils.jumpToPB(aVar, this.f19192b.f2966e, 0, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f19192b.f2966e, 0, false, computeViewArea);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f19193e;

        public c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19193e = hVar;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                l lVar = (l) nVar;
                lVar.k = 1;
                if (this.f19193e.q != null) {
                    this.f19193e.q.a(threadCardViewHolder.getView(), lVar);
                }
                ThreadCardUtils.jumpToPB((c.a.p0.s.q.a) lVar, view.getContext(), lVar.G, false, c.a.l.e.a((s) viewGroup, view, i2));
                threadCardViewHolder.getCardView().o(new a.C0096a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.q = new a(this);
        this.n = tbPageContext;
    }

    public final o l0(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar)) == null) {
            if (lVar != null) {
                o oVar = new o();
                oVar.f23216a = "6";
                oVar.f23218c = lVar.l;
                if (lVar.getThreadData() != null) {
                    oVar.f23219d = String.valueOf(lVar.getThreadData().T());
                    if (lVar.getThreadData().o1() != null) {
                        oVar.m = lVar.getThreadData().o1().video_md5;
                        oVar.p = String.valueOf(lVar.getThreadData().o1().is_vertical);
                    }
                }
                oVar.k = lVar.k();
                oVar.f23221f = lVar.t();
                oVar.l = lVar.g();
                oVar.f23223h = lVar.E();
                oVar.f23220e = TbadkCoreApplication.getCurrentAccount();
                oVar.q = String.valueOf(lVar.q());
                return oVar;
            }
            return null;
        }
        return (o) invokeL.objValue;
    }

    public final void m0(View view, l lVar) {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view, lVar) == null) || (t0Var = this.p) == null || t0Var.o() == null || this.p.o().getMainView() == null) {
            return;
        }
        if (view.getId() == this.p.o().getMainView().getId()) {
            c.a.q0.i2.m.a.m(lVar, 4, this.n);
        } else if (view.getId() == R.id.thread_card_root) {
            c.a.q0.i2.m.a.m(lVar, 1, this.n);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: n0 */
    public AutoVideoCardViewHolder<l> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            bVar.l().i(true);
            c.a.l.g gVar = new c.a.l.g(this.n.getPageActivity());
            gVar.w(this.m);
            gVar.t("pb");
            gVar.u(new b(this, gVar));
            this.p = gVar;
            bVar.n(gVar);
            t0 t0Var = this.p;
            if (t0Var != null) {
                t0Var.x("2002");
            }
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.o);
            AutoVideoCardViewHolder<l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.setPageId(this.m);
            k.p(this.q);
            k.r(0);
            d0(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: o0 */
    public View a0(int i2, View view, ViewGroup viewGroup, l lVar, AutoVideoCardViewHolder<l> autoVideoCardViewHolder) {
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
            lVar.W = 0;
            autoVideoCardViewHolder.setVideoStatsData(l0(lVar));
            autoVideoCardViewHolder.onBindDataToView(lVar);
            autoVideoCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.getCardView().p(this.q);
            c.a.q0.i2.m.a.n(lVar, this.n);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void p0(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sVar) == null) {
            this.o = sVar;
        }
    }
}
