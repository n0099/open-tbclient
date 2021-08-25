package c.a.q0.f1.c.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.l.l0;
import c.a.l.v0.a;
import c.a.q0.a0.b0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class g extends c.a.e.l.e.a<c.a.q0.a0.d0.k, ThreadCardViewHolder<c.a.q0.a0.d0.k>> implements c.a.q0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public boolean p;
    public c.a.e.l.e.s q;
    public b0<c.a.q0.a0.d0.k> r;

    /* loaded from: classes3.dex */
    public class a extends b0<c.a.q0.a0.d0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f17323b;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17323b = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, c.a.q0.a0.d0.k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) || view == null || kVar == null || kVar.getThreadData() == null || StringUtils.isNull(kVar.getThreadData().q1())) {
                return;
            }
            this.f17323b.l0(view, kVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f17324e;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17324e = gVar;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, c.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c.a.q0.a0.d0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                c.a.q0.a0.d0.k kVar = (c.a.q0.a0.d0.k) nVar;
                kVar.k = 1;
                if (this.f17324e.r != null) {
                    this.f17324e.r.a(threadCardViewHolder.getView(), kVar);
                }
                ThreadCardUtils.jumpToPB((c.a.p0.s.q.a) kVar, view.getContext(), 1, false);
                threadCardViewHolder.getCardView().o(new a.C0096a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.p = true;
        this.r = new a(this);
        this.n = tbPageContext;
    }

    @Override // c.a.q0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.o = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: j0 */
    public ThreadCardViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            c.a.l.v vVar = new c.a.l.v(this.n.getPageActivity());
            vVar.u(ImageViewerConfig.FROM_CONCERN);
            vVar.v(this.p);
            bVar.n(vVar);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
            k.r(1);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.setPageId(this.m);
            d0(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: k0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.q0.a0.d0.k kVar, ThreadCardViewHolder<c.a.q0.a0.d0.k> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.f15245e == null) {
                return null;
            }
            kVar.K(kVar.position + 1);
            c.a.q0.a0.t.b().a(kVar.i("c12351"));
            threadCardViewHolder.getCardView().q(i2);
            if (threadCardViewHolder.getCardView() instanceof c.a.q0.o.e) {
                threadCardViewHolder.getCardView().setPage(this.o);
            }
            threadCardViewHolder.onBindDataToView(kVar);
            threadCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.r);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void l0(View view, c.a.q0.a0.d0.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view, kVar) == null) {
            if (view.getId() == R.id.thread_card_root) {
                c.a.q0.f1.c.c.b(view, kVar, 2);
            } else if (view instanceof TbImageView) {
                c.a.q0.f1.c.c.b(view, kVar, 3);
            } else if (view.getId() == R.id.thread_card_title || view.getId() == R.id.thread_card_abstract) {
                c.a.q0.f1.c.c.b(view, kVar, 2);
            }
        }
    }

    public void m0(c.a.e.l.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sVar) == null) {
            this.q = sVar;
        }
    }
}
