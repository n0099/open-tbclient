package c.a.r0.h1.c.e;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import c.a.l.a;
import c.a.l.l0;
import c.a.l.t0;
import c.a.l.v0.a;
import c.a.r0.b0.c0;
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
public class y extends c.a.e.l.e.a<c.a.r0.b0.e0.l, AutoVideoCardViewHolder<c.a.r0.b0.e0.l>> implements c.a.r0.p.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public c.a.e.l.e.s p;
    public t0 q;
    public c0<c.a.r0.b0.e0.l> r;

    /* loaded from: classes3.dex */
    public class a extends c0<c.a.r0.b0.e0.l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ y f18071b;

        public a(y yVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18071b = yVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, c.a.r0.b0.e0.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, lVar) == null) {
                c.a.r0.b0.u.b().d(true);
                c.a.r0.p.d.c().h("page_recommend", "show_");
                if (lVar == null || lVar.getThreadData() == null || StringUtils.isNull(lVar.getThreadData().s1())) {
                    return;
                }
                if (lVar.getThreadData().w1 <= 0) {
                    this.f18071b.m0(view, lVar);
                } else {
                    TiebaStatic.log(lVar.P(lVar.getThreadData()));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.InterfaceC0093a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f18072a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ y f18073b;

        public b(y yVar, t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar, t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18073b = yVar;
            this.f18072a = t0Var;
        }

        @Override // c.a.l.a.InterfaceC0093a
        public void a(c.a.q0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f18072a.getVideoContainer());
            if (!(aVar instanceof c.a.r0.b0.e0.l)) {
                ThreadCardUtils.jumpToPB(aVar, this.f18073b.f2958e, 1, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f18073b.f2958e, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements c.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ y f18074e;

        public c(y yVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18074e = yVar;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, c.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c.a.r0.b0.e0.l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                c.a.r0.b0.e0.l lVar = (c.a.r0.b0.e0.l) nVar;
                lVar.k = 1;
                if (this.f18074e.r != null) {
                    this.f18074e.r.a(threadCardViewHolder.getView(), lVar);
                }
                ThreadCardUtils.jumpToPB((c.a.q0.s.q.a) lVar, view.getContext(), 1, false, c.a.l.e.a((c.a.e.l.e.s) viewGroup, view, i2));
                threadCardViewHolder.getCardView().o(new a.C0095a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.n = tbPageContext;
    }

    @Override // c.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.o = str;
        }
    }

    public final c.a.r0.q2.o l0(c.a.r0.b0.e0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, lVar)) == null) {
            if (lVar != null) {
                c.a.r0.q2.o oVar = new c.a.r0.q2.o();
                oVar.f23997a = "1";
                oVar.f23999c = lVar.l;
                if (lVar.getThreadData() != null) {
                    oVar.f24000d = String.valueOf(lVar.getThreadData().T());
                    if (lVar.getThreadData().q1() != null) {
                        oVar.m = lVar.getThreadData().q1().video_md5;
                        oVar.p = String.valueOf(lVar.getThreadData().q1().is_vertical);
                    }
                }
                oVar.k = lVar.k();
                oVar.f24002f = lVar.t();
                oVar.l = lVar.g();
                oVar.f24004h = lVar.E();
                oVar.f24001e = TbadkCoreApplication.getCurrentAccount();
                oVar.q = String.valueOf(lVar.q());
                return oVar;
            }
            return null;
        }
        return (c.a.r0.q2.o) invokeL.objValue;
    }

    public final void m0(View view, c.a.r0.b0.e0.l lVar) {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, view, lVar) == null) || (t0Var = this.q) == null || t0Var.o() == null || this.q.o().getMainView() == null) {
            return;
        }
        if (view.getId() == this.q.o().getMainView().getId()) {
            c.a.r0.h1.c.c.b(view, lVar, 4);
        } else if (view.getId() == R.id.thread_card_root) {
            c.a.r0.h1.c.c.b(view, lVar, 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: n0 */
    public AutoVideoCardViewHolder<c.a.r0.b0.e0.l> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            c.a.r0.h1.h.o.b bVar2 = new c.a.r0.h1.h.o.b(this.n.getPageActivity());
            bVar2.w(this.m);
            bVar2.t("concern_tab");
            bVar2.u(new b(this, bVar2));
            this.q = bVar2;
            bVar.n(bVar2);
            t0 t0Var = this.q;
            if (t0Var != null) {
                t0Var.x("2001");
            }
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.p);
            AutoVideoCardViewHolder<c.a.r0.b0.e0.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.setPageId(this.m);
            k.p(this.r);
            k.r(1);
            d0(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: o0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.r0.b0.e0.l lVar, AutoVideoCardViewHolder<c.a.r0.b0.e0.l> autoVideoCardViewHolder) {
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
            c.a.r0.b0.u.b().a(lVar.i("c12351"));
            autoVideoCardViewHolder.getCardView().q(i2);
            lVar.W = 0;
            autoVideoCardViewHolder.setVideoStatsData(l0(lVar));
            if (autoVideoCardViewHolder.getCardView() instanceof c.a.r0.p.e) {
                autoVideoCardViewHolder.getCardView().setPage(this.o);
            }
            autoVideoCardViewHolder.onBindDataToView(lVar);
            autoVideoCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.getCardView().p(this.r);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void p0(c.a.e.l.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, sVar) == null) {
            this.p = sVar;
        }
    }
}
