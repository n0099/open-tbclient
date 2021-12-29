package c.a.t0.o1.c.e;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import c.a.l.a;
import c.a.l.l0;
import c.a.l.t0;
import c.a.l.w0.a;
import c.a.t0.g0.d0;
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
/* loaded from: classes7.dex */
public class y extends c.a.d.n.e.a<c.a.t0.g0.f0.l, AutoVideoCardViewHolder<c.a.t0.g0.f0.l>> implements c.a.t0.t.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public c.a.d.n.e.s p;
    public t0 q;
    public d0<c.a.t0.g0.f0.l> r;

    /* loaded from: classes7.dex */
    public class a extends d0<c.a.t0.g0.f0.l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ y f20759b;

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
            this.f20759b = yVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.g0.d0
        /* renamed from: d */
        public void a(View view, c.a.t0.g0.f0.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, lVar) == null) {
                c.a.t0.g0.v.b().d(true);
                c.a.t0.t.d.c().h("page_recommend", "show_");
                if (lVar == null || lVar.getThreadData() == null || StringUtils.isNull(lVar.getThreadData().v1())) {
                    return;
                }
                if (lVar.getThreadData().y1 <= 0) {
                    this.f20759b.e0(view, lVar);
                } else {
                    TiebaStatic.log(lVar.P(lVar.getThreadData()));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.InterfaceC0184a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t0 a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ y f20760b;

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
            this.f20760b = yVar;
            this.a = t0Var;
        }

        @Override // c.a.l.a.InterfaceC0184a
        public void a(c.a.s0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(aVar instanceof c.a.t0.g0.f0.l)) {
                ThreadCardUtils.jumpToPB(aVar, this.f20760b.f3299e, 1, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f20760b.f3299e, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements c.a.d.n.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ y f20761e;

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
            this.f20761e = yVar;
        }

        @Override // c.a.d.n.e.w
        public void b(View view, c.a.d.n.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c.a.t0.g0.f0.l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                c.a.t0.g0.f0.l lVar = (c.a.t0.g0.f0.l) nVar;
                lVar.f18228k = 1;
                if (this.f20761e.r != null) {
                    this.f20761e.r.a(threadCardViewHolder.getView(), lVar);
                }
                ThreadCardUtils.jumpToPB((c.a.s0.s.q.a) lVar, view.getContext(), 1, false, c.a.l.e.a((c.a.d.n.e.s) viewGroup, view, i2));
                threadCardViewHolder.getCardView().o(new a.C0186a(1));
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

    public final c.a.t0.z2.t d0(c.a.t0.g0.f0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar)) == null) {
            if (lVar != null) {
                c.a.t0.z2.t tVar = new c.a.t0.z2.t();
                tVar.a = "7";
                tVar.f26871c = lVar.l;
                if (lVar.getThreadData() != null) {
                    tVar.f26872d = String.valueOf(lVar.getThreadData().U());
                    if (lVar.getThreadData().t1() != null) {
                        tVar.m = lVar.getThreadData().t1().video_md5;
                        tVar.p = String.valueOf(lVar.getThreadData().t1().is_vertical);
                    }
                }
                tVar.f26879k = lVar.k();
                tVar.f26874f = lVar.t();
                tVar.l = lVar.g();
                tVar.f26876h = lVar.E();
                tVar.f26873e = TbadkCoreApplication.getCurrentAccount();
                tVar.q = String.valueOf(lVar.q());
                return tVar;
            }
            return null;
        }
        return (c.a.t0.z2.t) invokeL.objValue;
    }

    public final void e0(View view, c.a.t0.g0.f0.l lVar) {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view, lVar) == null) || (t0Var = this.q) == null || t0Var.o() == null || this.q.o().getMainView() == null) {
            return;
        }
        if (view.getId() == this.q.o().getMainView().getId()) {
            c.a.t0.o1.c.c.b(view, lVar, 4);
        } else if (view.getId() == R.id.thread_card_root) {
            c.a.t0.o1.c.c.b(view, lVar, 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: f0 */
    public AutoVideoCardViewHolder<c.a.t0.g0.f0.l> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            c.a.t0.o1.h.o.b bVar2 = new c.a.t0.o1.h.o.b(this.n.getPageActivity());
            bVar2.w(this.m);
            bVar2.t("concern_tab");
            bVar2.u(new b(this, bVar2));
            this.q = bVar2;
            bVar.n(bVar2);
            t0 t0Var = this.q;
            if (t0Var != null) {
                t0Var.x("2001");
            }
            l0 k2 = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.p);
            AutoVideoCardViewHolder<c.a.t0.g0.f0.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k2);
            autoVideoCardViewHolder.setPageId(this.m);
            k2.p(this.r);
            k2.r(1);
            V(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    @Override // c.a.t0.t.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.o = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: g0 */
    public View S(int i2, View view, ViewGroup viewGroup, c.a.t0.g0.f0.l lVar, AutoVideoCardViewHolder<c.a.t0.g0.f0.l> autoVideoCardViewHolder) {
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
            c.a.t0.g0.v.b().a(lVar.i("c12351"));
            autoVideoCardViewHolder.getCardView().q(i2);
            lVar.Y = 0;
            autoVideoCardViewHolder.setVideoStatsData(d0(lVar));
            if (autoVideoCardViewHolder.getCardView() instanceof c.a.t0.t.e) {
                autoVideoCardViewHolder.getCardView().d(this.o);
            }
            autoVideoCardViewHolder.onBindDataToView(lVar);
            autoVideoCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.getCardView().p(this.r);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void h0(c.a.d.n.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, sVar) == null) {
            this.p = sVar;
        }
    }
}
