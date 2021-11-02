package b.a.r0.h1.c.e;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import b.a.l.a;
import b.a.l.l0;
import b.a.l.t0;
import b.a.l.v0.a;
import b.a.r0.b0.c0;
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
public class y extends b.a.e.l.e.a<b.a.r0.b0.e0.l, AutoVideoCardViewHolder<b.a.r0.b0.e0.l>> implements b.a.r0.p.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public b.a.e.l.e.s p;
    public t0 q;
    public c0<b.a.r0.b0.e0.l> r;

    /* loaded from: classes4.dex */
    public class a extends c0<b.a.r0.b0.e0.l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ y f17022b;

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
            this.f17022b = yVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, b.a.r0.b0.e0.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, lVar) == null) {
                b.a.r0.b0.u.b().d(true);
                b.a.r0.p.d.c().h("page_recommend", "show_");
                if (lVar == null || lVar.getThreadData() == null || StringUtils.isNull(lVar.getThreadData().s1())) {
                    return;
                }
                if (lVar.getThreadData().w1 <= 0) {
                    this.f17022b.l0(view, lVar);
                } else {
                    TiebaStatic.log(lVar.P(lVar.getThreadData()));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.InterfaceC0088a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f17023a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ y f17024b;

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
            this.f17024b = yVar;
            this.f17023a = t0Var;
        }

        @Override // b.a.l.a.InterfaceC0088a
        public void a(b.a.q0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f17023a.getVideoContainer());
            if (!(aVar instanceof b.a.r0.b0.e0.l)) {
                ThreadCardUtils.jumpToPB(aVar, this.f17024b.f2419e, 1, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f17024b.f2419e, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements b.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ y f17025e;

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
            this.f17025e = yVar;
        }

        @Override // b.a.e.l.e.w
        public void b(View view, b.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof b.a.r0.b0.e0.l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                b.a.r0.b0.e0.l lVar = (b.a.r0.b0.e0.l) nVar;
                lVar.k = 1;
                if (this.f17025e.r != null) {
                    this.f17025e.r.a(threadCardViewHolder.getView(), lVar);
                }
                ThreadCardUtils.jumpToPB((b.a.q0.s.q.a) lVar, view.getContext(), 1, false, b.a.l.e.a((b.a.e.l.e.s) viewGroup, view, i2));
                threadCardViewHolder.getCardView().n(new a.C0090a(1));
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

    @Override // b.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.o = str;
        }
    }

    public final b.a.r0.q2.p k0(b.a.r0.b0.e0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, lVar)) == null) {
            if (lVar != null) {
                b.a.r0.q2.p pVar = new b.a.r0.q2.p();
                pVar.f22882a = "1";
                pVar.f22884c = lVar.l;
                if (lVar.getThreadData() != null) {
                    pVar.f22885d = String.valueOf(lVar.getThreadData().T());
                    if (lVar.getThreadData().q1() != null) {
                        pVar.m = lVar.getThreadData().q1().video_md5;
                        pVar.p = String.valueOf(lVar.getThreadData().q1().is_vertical);
                    }
                }
                pVar.k = lVar.k();
                pVar.f22887f = lVar.t();
                pVar.l = lVar.g();
                pVar.f22889h = lVar.E();
                pVar.f22886e = TbadkCoreApplication.getCurrentAccount();
                pVar.q = String.valueOf(lVar.q());
                return pVar;
            }
            return null;
        }
        return (b.a.r0.q2.p) invokeL.objValue;
    }

    public final void l0(View view, b.a.r0.b0.e0.l lVar) {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, view, lVar) == null) || (t0Var = this.q) == null || t0Var.o() == null || this.q.o().getMainView() == null) {
            return;
        }
        if (view.getId() == this.q.o().getMainView().getId()) {
            b.a.r0.h1.c.c.b(view, lVar, 4);
        } else if (view.getId() == R.id.thread_card_root) {
            b.a.r0.h1.c.c.b(view, lVar, 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: m0 */
    public AutoVideoCardViewHolder<b.a.r0.b0.e0.l> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            b.a.r0.h1.h.o.b bVar2 = new b.a.r0.h1.h.o.b(this.n.getPageActivity());
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
            AutoVideoCardViewHolder<b.a.r0.b0.e0.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.setPageId(this.m);
            k.o(this.r);
            k.q(1);
            c0(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: n0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.b0.e0.l lVar, AutoVideoCardViewHolder<b.a.r0.b0.e0.l> autoVideoCardViewHolder) {
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
            b.a.r0.b0.u.b().a(lVar.i("c12351"));
            autoVideoCardViewHolder.getCardView().p(i2);
            lVar.W = 0;
            autoVideoCardViewHolder.setVideoStatsData(k0(lVar));
            if (autoVideoCardViewHolder.getCardView() instanceof b.a.r0.p.e) {
                autoVideoCardViewHolder.getCardView().setPage(this.o);
            }
            autoVideoCardViewHolder.onBindDataToView(lVar);
            autoVideoCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.getCardView().o(this.r);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void o0(b.a.e.l.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, sVar) == null) {
            this.p = sVar;
        }
    }
}
