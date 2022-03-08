package c.a.r0.d1.p1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.l0;
import c.a.l.w0.a;
import c.a.q0.r.r.d2;
import c.a.q0.r.r.e2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class k extends c.a.r0.d1.k<d2, ThreadCardViewHolder<e2>> implements c.a.r0.f0.z, c.a.r0.d1.o2.d, c.a.r0.t.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public c.a.r0.f0.b0<e2> B;
    public String x;
    public String y;
    public boolean z;

    /* loaded from: classes2.dex */
    public class a extends c.a.r0.f0.b0<e2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f15976b;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15976b = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.f0.b0
        /* renamed from: d */
        public void a(View view, e2 e2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, e2Var) == null) || view == null || e2Var == null) {
                return;
            }
            if (this.f15976b.u != null) {
                this.f15976b.u.b(view, e2Var, this.f15976b.getType());
            }
            if ("c13010".equals(this.f15976b.x)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", e2Var.U()).param("tid", e2Var.w1()));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    c.a.r0.d1.o2.a.e(e2Var, 5, this.f15976b.f3080i, c.a.r0.d1.o2.d.p0, this.f15976b.a0());
                    c.a.r0.d1.r2.q.g(e2Var, this.f15976b.n, 1);
                } else if (view.getId() == R.id.share_num_container) {
                    c.a.r0.d1.o2.a.e(e2Var, 14, this.f15976b.f3080i, c.a.r0.d1.o2.d.p0, this.f15976b.a0());
                } else if (view instanceof TbImageView) {
                    if (this.f15976b.B.a instanceof Boolean) {
                        if (((Boolean) this.f15976b.B.a).booleanValue()) {
                            c.a.r0.d1.o2.a.e(e2Var, 1, this.f15976b.f3080i, c.a.r0.d1.o2.d.p0, this.f15976b.a0());
                        } else {
                            c.a.r0.d1.o2.a.e(e2Var, 3, this.f15976b.f3080i, c.a.r0.d1.o2.d.p0, this.f15976b.a0());
                        }
                    }
                    c.a.r0.d1.r2.q.g(e2Var, this.f15976b.n, 2);
                } else if (view instanceof ThreadGodReplyLayout) {
                    c.a.r0.d1.o2.a.e(e2Var, 15, this.f15976b.f3080i, c.a.r0.d1.o2.d.p0, this.f15976b.a0());
                    c.a.r0.d1.r2.q.g(e2Var, this.f15976b.n, 1);
                } else {
                    c.a.r0.d1.o2.a.e(e2Var, 1, this.f15976b.f3080i, c.a.r0.d1.o2.d.p0, this.f15976b.a0());
                    c.a.r0.d1.r2.q.g(e2Var, this.f15976b.n, 1);
                }
            } else {
                c.a.r0.d1.o2.a.e(e2Var, 2, this.f15976b.f3080i, c.a.r0.d1.o2.d.p0, this.f15976b.a0());
            }
            if (view.getId() == R.id.thread_card_root && e2Var.I2()) {
                this.f15976b.F0(e2Var);
            } else if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.card_divider_tv) {
                    c.a.r0.d1.r2.q.a(c.a.r0.d1.o2.d.p0, e2Var.getRecomReason());
                } else if (view instanceof TbImageView) {
                    if (this.f15976b.B.a instanceof Boolean) {
                        if (((Boolean) this.f15976b.B.a).booleanValue()) {
                            c.a.r0.d1.o2.c.k().h(c.a.r0.d1.o2.d.p0, e2Var, 1);
                        } else {
                            c.a.r0.d1.o2.c.k().h(c.a.r0.d1.o2.d.p0, e2Var, 3);
                        }
                    }
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view.getId() == R.id.thread_card_voice) {
                    c.a.r0.d1.o2.c.k().h(c.a.r0.d1.o2.d.p0, e2Var, 5);
                } else if (view instanceof ThreadGodReplyLayout) {
                    int i2 = 6;
                    if (e2Var.z1() != null && e2Var.z1().N() != null && e2Var.z1().N().y() != null && e2Var.z1().N().y().size() > 0) {
                        i2 = e2Var.z1().P ? 9 : 8;
                    }
                    c.a.r0.d1.o2.c.k().h(c.a.r0.d1.o2.d.p0, e2Var, i2);
                } else {
                    c.a.r0.d1.o2.c.k().h(c.a.r0.d1.o2.d.p0, e2Var, 1);
                }
            } else {
                c.a.r0.d1.o2.c.k().h(c.a.r0.d1.o2.d.p0, e2Var, 2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c.a.d.o.e.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f15977e;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15977e = kVar;
        }

        @Override // c.a.d.o.e.v
        public void b(View view, c.a.d.o.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof d2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                e2 e2Var = ((d2) nVar).w;
                e2Var.objType = 1;
                if (this.f15977e.B != null) {
                    this.f15977e.B.a(threadCardViewHolder.getView(), e2Var);
                }
                ThreadCardUtils.jumpToPB((c.a.q0.r.r.a) e2Var, view.getContext(), this.f15977e.A, false);
                threadCardViewHolder.getCardView().o(new a.C0203a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.z = true;
        this.A = 3;
        this.B = new a(this);
        this.o = tbPageContext;
        this.f3080i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: D0 */
    public ThreadCardViewHolder<e2> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity(), false);
            c.a.l.z zVar = new c.a.l.z(this.o.getPageActivity());
            zVar.q("frs");
            zVar.r(this.z);
            if (this.A == 502) {
                zVar.s(false);
            } else {
                zVar.s(true);
            }
            bVar.n(zVar);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
            k.r(3);
            ThreadCardViewHolder<e2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.f3080i);
            threadCardViewHolder.showMultiDelDecorItem(false);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.d1.k, c.a.d.o.e.a
    /* renamed from: E0 */
    public View S(int i2, View view, ViewGroup viewGroup, d2 d2Var, ThreadCardViewHolder<e2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view, viewGroup, d2Var, threadCardViewHolder})) == null) {
            super.S(i2, view, viewGroup, d2Var, threadCardViewHolder);
            if (d2Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            threadCardViewHolder.getCardView().d(this.y);
            threadCardViewHolder.getCardView().q(i2);
            c.a.r0.d1.j.i(threadCardViewHolder.getCardView().f(), this.n);
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
                d2Var.w.B4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
            }
            threadCardViewHolder.onBindDataToView(d2Var.w);
            threadCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.B);
            d2Var.w.T4();
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void F0(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2Var) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", e2Var.h0()).param("obj_locate", b0() ? 2 : 1).param("obj_id", e2Var.p1() == null ? -1L : e2Var.p1().live_id).param("obj_type", 1));
        }
    }

    @Override // c.a.r0.f0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // c.a.r0.t.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.y = str;
        }
    }

    @Override // c.a.r0.d1.o2.d
    public c.a.r0.d1.o2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? c.a.r0.d1.o2.d.p0 : (c.a.r0.d1.o2.b) invokeV.objValue;
    }

    @Override // c.a.r0.f0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.A = i2;
        }
    }

    @Override // c.a.r0.d1.k
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.x = str;
        }
    }

    @Override // c.a.r0.d1.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.z = z;
        }
    }
}
