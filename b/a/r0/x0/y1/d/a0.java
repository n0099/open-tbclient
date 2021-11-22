package b.a.r0.x0.y1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.l.l0;
import b.a.l.v0;
import b.a.l.w0.a;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.r0.x0.f1;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a0 extends b.a.r0.x0.k<c2, ThreadCardViewHolder<d2>> implements b.a.r0.b0.b0, b.a.r0.x0.v2.d, b.a.r0.p.f, b.a.r0.b0.c0, b.a.e.m.e.w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.r0.b0.d0<d2> A;
    public String x;
    public String y;
    public int z;

    /* loaded from: classes6.dex */
    public class a extends b.a.r0.b0.d0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a0 f28200b;

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
            this.f28200b = a0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.d0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) || view == null || d2Var == null) {
                return;
            }
            if (this.f28200b.u != null) {
                this.f28200b.u.b(view, d2Var, this.f28200b.getType());
            }
            if ("c13010".equals(this.f28200b.x)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", d2Var.T()).param("tid", d2Var.t1()));
            }
            b.a.r0.x0.v2.a.e(d2Var, 1, this.f28200b.f2425i, b.a.r0.x0.v2.d.h0, this.f28200b.h0());
            if (this.f28200b.n != null && this.f28200b.n.getForum() != null) {
                b.a.r0.x0.v2.a.c(d2Var, this.f28200b.n.getForum().getId());
            }
            if (view.getId() == f1.thread_card_root && d2Var.G2()) {
                this.f28200b.D0(d2Var);
            }
            if (view instanceof VoteView) {
                b.a.r0.b0.m.a(d2Var.t1());
            } else {
                b.a.r0.x0.v2.c.j().g(b.a.r0.x0.v2.d.h0, d2Var, 1);
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
        this.f2425i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: B0 */
    public ThreadCardViewHolder<d2> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity(), false);
            v0 v0Var = new v0(this.o.getPageActivity());
            v0Var.w(this.o);
            v0Var.v(3);
            bVar.h(v0Var);
            l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.q);
            k.q(3);
            ThreadCardViewHolder<d2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.f2425i);
            threadCardViewHolder.showMultiDelDecorItem(false);
            c0(this);
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.x0.k, b.a.e.m.e.a
    /* renamed from: C0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c2 c2Var, ThreadCardViewHolder<d2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view, viewGroup, c2Var, threadCardViewHolder})) == null) {
            super.Z(i2, view, viewGroup, c2Var, threadCardViewHolder);
            if (c2Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            threadCardViewHolder.getCardView().setPage(this.y);
            threadCardViewHolder.getCardView().p(i2);
            threadCardViewHolder.onBindDataToView(c2Var.w);
            threadCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().o(this.A);
            c2Var.w.Q4();
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void D0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", d2Var.f0()).param("obj_locate", i0() ? 2 : 1).param("obj_id", d2Var.m1() == null ? -1L : d2Var.m1().live_id).param("obj_type", 1));
        }
    }

    @Override // b.a.r0.b0.b0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // b.a.e.m.e.w
    public void b(View view, b.a.e.m.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof c2) && (view.getTag() instanceof ThreadCardViewHolder)) {
            ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
            d2 d2Var = ((c2) nVar).w;
            d2Var.objType = 1;
            b.a.r0.b0.d0<d2> d0Var = this.A;
            if (d0Var != null) {
                d0Var.a(threadCardViewHolder.getView(), d2Var);
            }
            ThreadCardUtils.jumpToPB((b.a.q0.s.q.a) d2Var, view.getContext(), this.z, false);
            threadCardViewHolder.getCardView().n(new a.C0092a(1));
        }
    }

    @Override // b.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.y = str;
        }
    }

    @Override // b.a.r0.x0.v2.d
    public b.a.r0.x0.v2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? b.a.r0.x0.v2.d.h0 : (b.a.r0.x0.v2.b) invokeV.objValue;
    }

    @Override // b.a.r0.b0.c0
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // b.a.r0.b0.b0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.z = i2;
        }
    }

    @Override // b.a.r0.x0.k, b.a.r0.b0.a0
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.x = str;
        }
    }
}
