package c.a.o0.a1.c;

import android.view.View;
import android.view.ViewGroup;
import c.a.d.o.e.w;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.w0.a;
import c.a.o0.r.r.a2;
import c.a.p0.h0.b0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c extends d<a2, ThreadCardViewHolder<a2>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b0<a2> o;

    /* loaded from: classes2.dex */
    public class a extends b0<a2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f9755b;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9755b = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.h0.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, a2Var) == null) {
                this.f9755b.b0(view, a2Var);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.d.o.e.w
        public void b(View view, c.a.d.o.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.t0(view, nVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext tbPageContext) {
        super(tbPageContext, ThreadData.TYPE_ARTICLE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this);
    }

    public final void t0(View view, c.a.d.o.e.n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, nVar) == null) && (nVar instanceof a2) && (view.getTag() instanceof ThreadCardViewHolder)) {
            ThreadData threadData = ((a2) nVar).s;
            threadData.objType = 1;
            ThreadCardUtils.jumpToPB((c.a.o0.r.r.a) threadData, view.getContext(), h0(), false);
            ((ThreadCardViewHolder) view.getTag()).c().o(new a.C0196a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: u0 */
    public ThreadCardViewHolder<a2> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.k.getPageActivity());
            c.a.l.d dVar = new c.a.l.d(this.k.getPageActivity());
            dVar.t(this.f2571e);
            dVar.v(this.k);
            bVar.o(dVar);
            bVar.n(new c.a.l.b(this.k.getPageActivity()));
            bVar.h(new c.a.l.k(this.k.getPageActivity()));
            n0 n0Var = new n0(this.k.getPageActivity());
            c.a.o0.r.r.f fVar = new c.a.o0.r.r.f();
            fVar.f10852b = c0();
            fVar.f10858h = d0();
            n0Var.v(fVar);
            n0Var.w(f0());
            n0Var.A(g0());
            n0Var.x(h0());
            bVar.m(n0Var);
            bVar.l().h(c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            bVar.l().b(R.drawable.addresslist_item_bg);
            bVar.l().g(c.a.d.f.p.n.f(this.k.getPageActivity(), R.dimen.tbds17));
            l0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.l);
            k.r(h0());
            ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.f2571e);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: v0 */
    public View S(int i, View view, ViewGroup viewGroup, a2 a2Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view, viewGroup, a2Var, threadCardViewHolder})) == null) {
            if (a2Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            a2Var.s.statFloor = C(i) + 1;
            threadCardViewHolder.c().q(i);
            threadCardViewHolder.g(a2Var);
            threadCardViewHolder.c().p(this.o);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            r0(threadCardViewHolder.b(), a2Var, i, i);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
