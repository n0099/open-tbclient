package c.a.r0.x0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.l0;
import c.a.l.u0;
import c.a.l.v0.a;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a0 extends c.a.r0.x0.k<c2, ThreadCardViewHolder<d2>> implements c.a.r0.b0.a0, c.a.r0.x0.k2.d, c.a.r0.p.f, c.a.r0.b0.b0, c.a.e.l.e.w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.b0.c0<d2> A;
    public String x;
    public String y;
    public int z;

    /* loaded from: classes4.dex */
    public class a extends c.a.r0.b0.c0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a0 f27354b;

        public a(a0 a0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27354b = a0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) || view == null || d2Var == null) {
                return;
            }
            if (this.f27354b.u != null) {
                this.f27354b.u.b(view, d2Var, this.f27354b.K());
            }
            if ("c13010".equals(this.f27354b.x)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", d2Var.T()).param("tid", d2Var.s1()));
            }
            c.a.r0.x0.k2.a.e(d2Var, 1, this.f27354b.f2962i, c.a.r0.x0.k2.d.h0, this.f27354b.i0());
            if (this.f27354b.n != null && this.f27354b.n.getForum() != null) {
                c.a.r0.x0.k2.a.c(d2Var, this.f27354b.n.getForum().getId());
            }
            if (view.getId() == R.id.thread_card_root && d2Var.E2()) {
                this.f27354b.E0(d2Var);
            }
            if (view instanceof VoteView) {
                c.a.r0.b0.m.a(d2Var.s1());
            } else {
                c.a.r0.x0.k2.c.j().g(c.a.r0.x0.k2.d.h0, d2Var, 1);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.z = 3;
        this.A = new a(this);
        this.o = tbPageContext;
        this.f2962i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: C0 */
    public ThreadCardViewHolder<d2> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity(), false);
            u0 u0Var = new u0(this.o.getPageActivity());
            u0Var.w(this.o);
            u0Var.v(3);
            bVar.h(u0Var);
            l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.q);
            k.r(3);
            ThreadCardViewHolder<d2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.f2962i);
            threadCardViewHolder.showMultiDelDecorItem(false);
            d0(this);
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.x0.k, c.a.e.l.e.a
    /* renamed from: D0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c2 c2Var, ThreadCardViewHolder<d2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view, viewGroup, c2Var, threadCardViewHolder})) == null) {
            super.a0(i2, view, viewGroup, c2Var, threadCardViewHolder);
            if (c2Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            threadCardViewHolder.getCardView().setPage(this.y);
            threadCardViewHolder.getCardView().q(i2);
            threadCardViewHolder.onBindDataToView(c2Var.w);
            threadCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.A);
            c2Var.w.M4();
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void E0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", d2Var.f0()).param("obj_locate", j0() ? 2 : 1).param("obj_id", d2Var.l1() == null ? -1L : d2Var.l1().live_id).param("obj_type", 1));
        }
    }

    @Override // c.a.r0.b0.a0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // c.a.e.l.e.w
    public void b(View view, c.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c2) && (view.getTag() instanceof ThreadCardViewHolder)) {
            ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
            d2 d2Var = ((c2) nVar).w;
            d2Var.objType = 1;
            c.a.r0.b0.c0<d2> c0Var = this.A;
            if (c0Var != null) {
                c0Var.a(threadCardViewHolder.getView(), d2Var);
            }
            ThreadCardUtils.jumpToPB((c.a.q0.s.q.a) d2Var, view.getContext(), this.z, false);
            threadCardViewHolder.getCardView().o(new a.C0095a(1));
        }
    }

    @Override // c.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.y = str;
        }
    }

    @Override // c.a.r0.x0.k2.d
    public c.a.r0.x0.k2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? c.a.r0.x0.k2.d.h0 : (c.a.r0.x0.k2.b) invokeV.objValue;
    }

    @Override // c.a.r0.b0.b0
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // c.a.r0.b0.a0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.z = i2;
        }
    }

    @Override // c.a.r0.x0.k, c.a.r0.b0.z
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.x = str;
        }
    }
}
