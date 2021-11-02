package b.a.r0.o0.l.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.a.e.l.e.n;
import b.a.e.l.e.s;
import b.a.e.l.e.w;
import b.a.l.l0;
import b.a.l.n0;
import b.a.l.v0.a;
import b.a.q0.s.q.d2;
import b.a.r0.b0.c0;
import b.a.r0.b0.u;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a extends b.a.e.l.e.a<d2, ThreadCardViewHolder<d2>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public String n;
    public TbPageContext<?> o;
    public NEGFeedBackView.b p;
    public s q;
    public c0<d2> r;

    /* renamed from: b.a.r0.o0.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1065a extends c0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f21765b;

        public C1065a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21765b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) {
                u.b().d(true);
                b.a.r0.o0.a.a(view, d2Var, this.f21765b.n);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21766e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21766e = aVar;
        }

        @Override // b.a.e.l.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                this.f21766e.i0(view, nVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
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
        this.r = new C1065a(this);
        this.o = tbPageContext;
        this.m = bdUniqueId2;
        this.n = str;
    }

    public final void i0(View view, n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, nVar) == null) && (nVar instanceof b.a.r0.b0.e0.e) && (view.getTag() instanceof ThreadCardViewHolder)) {
            b.a.r0.b0.e0.e eVar = (b.a.r0.b0.e0.e) nVar;
            eVar.k = 1;
            ThreadCardUtils.jumpToPB((b.a.q0.s.q.a) eVar, view.getContext(), 2, false);
            ((ThreadCardViewHolder) view.getTag()).getCardView().n(new a.C0090a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: j0 */
    public ThreadCardViewHolder<d2> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity());
            b.a.l.d dVar = new b.a.l.d(this.o.getPageActivity());
            dVar.s(this.m);
            dVar.u(this.o);
            bVar.o(dVar);
            bVar.n(new b.a.l.b(this.o.getPageActivity()));
            bVar.h(new b.a.l.k(this.o.getPageActivity()));
            n0 n0Var = new n0(this.o.getPageActivity());
            b.a.q0.s.q.f fVar = new b.a.q0.s.q.f();
            fVar.f13300b = 1;
            fVar.f13306h = 1;
            n0Var.u(fVar);
            n0Var.v(1);
            n0Var.z(3);
            n0Var.w(2);
            bVar.m(n0Var);
            l0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.q);
            k.q(2);
            ThreadCardViewHolder<d2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.m);
            c0(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: k0 */
    public View Z(int i2, View view, ViewGroup viewGroup, d2 d2Var, ThreadCardViewHolder<d2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, d2Var, threadCardViewHolder})) == null) {
            if (d2Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            d2Var.T1 = D(i2) + 1;
            threadCardViewHolder.getCardView().p(i2);
            threadCardViewHolder.showNEGFeedBackView(true).t(this.p);
            threadCardViewHolder.showUnfollowedDecorItemIfNeed(true, Align.ALIGN_RIGHT_BOTTOM);
            threadCardViewHolder.onBindDataToView(d2Var);
            threadCardViewHolder.getCardView().o(this.r);
            threadCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            b.a.r0.o0.a.b(d2Var, this.n);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void l0(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sVar) == null) {
            this.q = sVar;
        }
    }
}
