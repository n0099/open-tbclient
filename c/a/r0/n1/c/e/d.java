package c.a.r0.n1.c.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.k.l0;
import c.a.k.n0;
import c.a.k.w0.a;
import c.a.r0.g0.d0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
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
/* loaded from: classes6.dex */
public class d extends c.a.d.m.e.a<c.a.r0.g0.f0.e, ThreadCardViewHolder<c.a.r0.g0.f0.e>> implements c.a.r0.t.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public c.a.d.m.e.s p;
    public d0<c.a.r0.g0.f0.e> q;

    /* loaded from: classes6.dex */
    public class a extends d0<c.a.r0.g0.f0.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f20154b;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20154b = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.g0.d0
        /* renamed from: d */
        public void a(View view, c.a.r0.g0.f0.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, eVar) == null) {
                c.a.r0.g0.v.b().d(true);
                c.a.r0.t.d.c().h("page_recommend", "show_");
                if (view == null || eVar == null || eVar.getThreadData() == null || StringUtils.isNull(eVar.getThreadData().v1())) {
                    return;
                }
                this.f20154b.l0(view, eVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c.a.d.m.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f20155e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20155e = dVar;
        }

        @Override // c.a.d.m.e.w
        public void b(View view, c.a.d.m.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                this.f20155e.i0(view, nVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    @Override // c.a.r0.t.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.o = str;
        }
    }

    public final void i0(View view, c.a.d.m.e.n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, view, nVar) == null) && (nVar instanceof c.a.r0.g0.f0.e) && (view.getTag() instanceof ThreadCardViewHolder)) {
            c.a.r0.g0.f0.e eVar = (c.a.r0.g0.f0.e) nVar;
            eVar.f17251k = 1;
            ThreadCardUtils.jumpToPB((c.a.q0.s.q.a) eVar, view.getContext(), 1, false);
            ((ThreadCardViewHolder) view.getTag()).getCardView().o(new a.C0131a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: j0 */
    public ThreadCardViewHolder<c.a.r0.g0.f0.e> S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity());
            c.a.k.d dVar = new c.a.k.d(this.n.getPageActivity());
            dVar.s(this.m);
            dVar.u(this.n);
            bVar.o(dVar);
            bVar.n(new c.a.k.b(this.n.getPageActivity()));
            bVar.h(new c.a.k.k(this.n.getPageActivity()));
            n0 n0Var = new n0(this.n.getPageActivity());
            c.a.q0.s.q.f fVar = new c.a.q0.s.q.f();
            fVar.f12929b = 1;
            fVar.f12935h = 1;
            n0Var.u(fVar);
            n0Var.v(9);
            n0Var.z(4);
            n0Var.w(1);
            bVar.m(n0Var);
            bVar.l().g(c.a.d.f.p.l.f(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            l0 k2 = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.p);
            k2.r(1);
            ThreadCardViewHolder<c.a.r0.g0.f0.e> threadCardViewHolder = new ThreadCardViewHolder<>(k2);
            threadCardViewHolder.setPageId(this.m);
            c0(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: k0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c.a.r0.g0.f0.e eVar, ThreadCardViewHolder<c.a.r0.g0.f0.e> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, eVar, threadCardViewHolder})) == null) {
            if (eVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            eVar.K(eVar.position + 1);
            threadCardViewHolder.getCardView().q(i2);
            threadCardViewHolder.getCardView().d(this.o);
            threadCardViewHolder.showUnfollowedDecorItemIfNeed(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.showConcernForumDecorItem();
            threadCardViewHolder.onBindDataToView(eVar);
            c.a.r0.g0.v.b().a(eVar.i("c12351"));
            threadCardViewHolder.getCardView().p(this.q);
            threadCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void l0(View view, c.a.r0.g0.f0.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view, eVar) == null) {
            int id = view.getId();
            if (id == R.id.thread_card_root) {
                c.a.r0.n1.c.c.b(view, eVar, 2);
            } else if (id != R.id.user_avatar && id != R.id.user_name) {
                if (id == R.id.cover_img || id == R.id.bottom_mask) {
                    c.a.r0.n1.c.c.b(view, eVar, 3);
                }
            } else {
                c.a.r0.n1.c.c.b(view, eVar, 1);
            }
        }
    }

    public void m0(c.a.d.m.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, sVar) == null) {
            this.p = sVar;
        }
    }
}
