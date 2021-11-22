package b.a.r0.k2.u.c;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import b.a.e.m.e.n;
import b.a.e.m.e.s;
import b.a.e.m.e.w;
import b.a.l.a;
import b.a.l.l0;
import b.a.l.t0;
import b.a.l.w0.a;
import b.a.r0.b0.d0;
import b.a.r0.b0.f0.l;
import b.a.r0.b0.v;
import b.a.r0.k2.i;
import b.a.r0.q2.p;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class h extends b.a.e.m.e.a<l, AutoVideoCardViewHolder<l>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public s o;
    public t0 p;
    public d0<l> q;

    /* loaded from: classes5.dex */
    public class a extends d0<l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f20414b;

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
            this.f20414b = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.d0
        /* renamed from: d */
        public void a(View view, l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, lVar) == null) {
                v.b().d(true);
                if (lVar == null || lVar.getThreadData() == null || StringUtils.isNull(lVar.getThreadData().t1())) {
                    return;
                }
                if (lVar.getThreadData().w1 <= 0) {
                    this.f20414b.l0(view, lVar);
                } else {
                    TiebaStatic.log(lVar.P(lVar.getThreadData()));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.InterfaceC0090a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f20415a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f20416b;

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
            this.f20416b = hVar;
            this.f20415a = t0Var;
        }

        @Override // b.a.l.a.InterfaceC0090a
        public void a(b.a.q0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f20415a.getVideoContainer());
            if (!(aVar instanceof l)) {
                ThreadCardUtils.jumpToPB(aVar, this.f20416b.f2421e, 0, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f20416b.f2421e, 0, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f20417e;

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
            this.f20417e = hVar;
        }

        @Override // b.a.e.m.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                l lVar = (l) nVar;
                lVar.k = 1;
                if (this.f20417e.q != null) {
                    this.f20417e.q.a(threadCardViewHolder.getView(), lVar);
                }
                ThreadCardUtils.jumpToPB((b.a.q0.s.q.a) lVar, view.getContext(), lVar.H, false, b.a.l.e.a((s) viewGroup, view, i2));
                threadCardViewHolder.getCardView().n(new a.C0092a(1));
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

    public final p k0(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar)) == null) {
            if (lVar != null) {
                p pVar = new p();
                pVar.f24403a = "6";
                pVar.f24405c = lVar.l;
                if (lVar.getThreadData() != null) {
                    pVar.f24406d = String.valueOf(lVar.getThreadData().T());
                    if (lVar.getThreadData().r1() != null) {
                        pVar.m = lVar.getThreadData().r1().video_md5;
                        pVar.p = String.valueOf(lVar.getThreadData().r1().is_vertical);
                    }
                }
                pVar.k = lVar.k();
                pVar.f24408f = lVar.t();
                pVar.l = lVar.g();
                pVar.f24410h = lVar.E();
                pVar.f24407e = TbadkCoreApplication.getCurrentAccount();
                pVar.q = String.valueOf(lVar.q());
                return pVar;
            }
            return null;
        }
        return (p) invokeL.objValue;
    }

    public final void l0(View view, l lVar) {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view, lVar) == null) || (t0Var = this.p) == null || t0Var.o() == null || this.p.o().getMainView() == null) {
            return;
        }
        if (view.getId() == this.p.o().getMainView().getId()) {
            b.a.r0.k2.w.a.m(lVar, 4, this.n);
        } else if (view.getId() == i.thread_card_root) {
            b.a.r0.k2.w.a.m(lVar, 1, this.n);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: m0 */
    public AutoVideoCardViewHolder<l> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            bVar.l().i(true);
            b.a.l.g gVar = new b.a.l.g(this.n.getPageActivity());
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
            k.o(this.q);
            k.q(0);
            c0(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: n0 */
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
            autoVideoCardViewHolder.getCardView().p(i2);
            lVar.Y = 0;
            autoVideoCardViewHolder.setVideoStatsData(k0(lVar));
            autoVideoCardViewHolder.onBindDataToView(lVar);
            autoVideoCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.getCardView().o(this.q);
            b.a.r0.k2.w.a.n(lVar, this.n);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void o0(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sVar) == null) {
            this.o = sVar;
        }
    }
}
