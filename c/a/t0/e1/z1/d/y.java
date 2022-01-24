package c.a.t0.e1.z1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.d;
import c.a.l.l0;
import c.a.l.w0.a;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.e2;
import c.a.t0.e1.f1;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class y extends c.a.t0.e1.k<d2, ThreadCardViewHolder<e2>> implements c.a.t0.g0.b0, c.a.t0.e1.w2.d, c.a.t0.t.f, c.a.t0.g0.c0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.t0.g0.d0<e2> A;
    public String x;
    public String y;
    public int z;

    /* loaded from: classes7.dex */
    public class a extends c.a.t0.g0.d0<e2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ y f17306b;

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
            this.f17306b = yVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.g0.d0
        /* renamed from: d */
        public void a(View view, e2 e2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, e2Var) == null) || view == null || e2Var == null) {
                return;
            }
            if (this.f17306b.u != null) {
                this.f17306b.u.b(view, e2Var, this.f17306b.getType());
            }
            if ("c13010".equals(this.f17306b.x)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", e2Var.U()).param("tid", e2Var.w1()));
            }
            if (view.getId() != f1.user_name && view.getId() != f1.user_avatar) {
                if (view instanceof TbImageView) {
                    if (this.f17306b.A.a instanceof Boolean) {
                        if (((Boolean) this.f17306b.A.a).booleanValue()) {
                            c.a.t0.e1.w2.a.e(e2Var, 1, this.f17306b.f3364i, c.a.t0.e1.w2.d.p0, this.f17306b.a0());
                        } else {
                            c.a.t0.e1.w2.a.e(e2Var, 3, this.f17306b.f3364i, c.a.t0.e1.w2.d.p0, this.f17306b.a0());
                        }
                    }
                    c.a.t0.e1.z2.q.g(e2Var, this.f17306b.n, 2);
                } else if (view instanceof ThreadGodReplyLayout) {
                    c.a.t0.e1.w2.a.e(e2Var, 15, this.f17306b.f3364i, c.a.t0.e1.w2.d.p0, this.f17306b.a0());
                    if (this.f17306b.n != null && this.f17306b.n.getForum() != null) {
                        c.a.t0.e1.w2.a.c(e2Var, this.f17306b.n.getForum().getId());
                    }
                } else {
                    c.a.t0.e1.w2.a.e(e2Var, 1, this.f17306b.f3364i, c.a.t0.e1.w2.d.p0, this.f17306b.a0());
                    if (this.f17306b.n != null && this.f17306b.n.getForum() != null) {
                        c.a.t0.e1.w2.a.c(e2Var, this.f17306b.n.getForum().getId());
                    }
                }
            } else {
                c.a.t0.e1.w2.a.e(e2Var, 2, this.f17306b.f3364i, c.a.t0.e1.w2.d.p0, this.f17306b.a0());
            }
            if (view.getId() == f1.thread_card_root && e2Var.I2()) {
                this.f17306b.G0(e2Var);
            } else if (view.getId() != f1.user_name && view.getId() != f1.user_avatar) {
                if (view.getId() == f1.card_divider_tv) {
                    c.a.t0.e1.z2.q.a(c.a.t0.e1.w2.d.p0, e2Var.getRecomReason());
                } else if (view instanceof TbImageView) {
                    if (this.f17306b.A.a instanceof Boolean) {
                        if (((Boolean) this.f17306b.A.a).booleanValue()) {
                            c.a.t0.e1.w2.c.k().h(c.a.t0.e1.w2.d.p0, e2Var, 1);
                        } else {
                            c.a.t0.e1.w2.c.k().h(c.a.t0.e1.w2.d.p0, e2Var, 3);
                        }
                    }
                } else if (view.getId() == f1.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view.getId() == f1.thread_card_voice) {
                    c.a.t0.e1.w2.c.k().h(c.a.t0.e1.w2.d.p0, e2Var, 5);
                } else if (view instanceof ThreadGodReplyLayout) {
                    int i2 = 6;
                    if (e2Var.z1() != null && e2Var.z1().N() != null && e2Var.z1().N().y() != null && e2Var.z1().N().y().size() > 0) {
                        i2 = e2Var.z1().P ? 9 : 8;
                    }
                    c.a.t0.e1.w2.c.k().h(c.a.t0.e1.w2.d.p0, e2Var, i2);
                } else {
                    c.a.t0.e1.w2.c.k().h(c.a.t0.e1.w2.d.p0, e2Var, 1);
                }
            } else {
                c.a.t0.e1.w2.c.k().h(c.a.t0.e1.w2.d.p0, e2Var, 2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(y yVar) {
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
                }
            }
        }

        @Override // c.a.l.d.b
        public void a(c.a.s0.s.q.a aVar, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, view) == null) || aVar == null) {
                return;
            }
            if (view.getId() == f1.user_name) {
                aVar.objType = 3;
            } else if (view.getId() == f1.user_avatar) {
                aVar.objType = 4;
            } else {
                aVar.objType = 1;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements c.a.d.n.e.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ y f17307e;

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
            this.f17307e = yVar;
        }

        @Override // c.a.d.n.e.v
        public void b(View view, c.a.d.n.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof d2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                e2 e2Var = ((d2) nVar).w;
                e2Var.objType = 1;
                if (this.f17307e.A != null) {
                    this.f17307e.A.a(threadCardViewHolder.getView(), e2Var);
                }
                ThreadCardUtils.jumpToPB((c.a.s0.s.q.a) e2Var, view.getContext(), this.f17307e.z, false, c.a.l.e.a((c.a.d.n.e.s) viewGroup, view, i2));
                threadCardViewHolder.getCardView().o(new a.C0204a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.f3364i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: E0 */
    public ThreadCardViewHolder<e2> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity(), true);
            c.a.l.d dVar = new c.a.l.d(this.o.getPageActivity());
            dVar.a(4280);
            dVar.s(this.f3364i);
            dVar.r(new b(this));
            if (this.w) {
                bVar.l().d(0);
                bVar.l().g(0);
            }
            bVar.o(dVar);
            l0 k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.q);
            k.r(3);
            ThreadCardViewHolder<e2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.f3364i);
            threadCardViewHolder.showMultiDelDecorItem(false);
            V(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.e1.k, c.a.d.n.e.a
    /* renamed from: F0 */
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
            c.a.t0.e1.j.i(threadCardViewHolder.getCardView().f(), this.n);
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
                d2Var.w.B4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
            }
            threadCardViewHolder.showFollowUserDecorItemIfNeed(d2Var.w.showFollowBtn(), null);
            threadCardViewHolder.showNEGFeedBackViewIfNeed(true, Align.ALIGN_RIGHT_TOP, null);
            if (!d2Var.w.U1() && !d2Var.w.N2() && !CommonStatisticKey.KEY_FRS_ITEM_TAB_COMMENT_CLICK.equals(this.x)) {
                threadCardViewHolder.showThemeAndStarDecorItem();
            } else {
                threadCardViewHolder.removeThemeAndStarDecorItem();
            }
            threadCardViewHolder.onBindDataToView(d2Var.w);
            threadCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.A);
            d2Var.w.T4();
            if (c.a.t0.e1.w2.d.p0 != null) {
                FrsViewData frsViewData2 = this.n;
                d2Var.w.T1 = (d2Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            c.a.t0.e1.w2.c.k().c(c.a.t0.e1.w2.d.p0, d2Var.w);
            d2Var.w.T4();
            c.a.t0.e1.w2.a.n(d2Var.w, this.f3364i, c.a.t0.e1.w2.d.p0, a0());
            FrsViewData frsViewData3 = this.n;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                c.a.t0.e1.w2.a.l(d2Var.w, a0());
                c.a.t0.e1.w2.a.m(d2Var.w, this.n.getForum().getId());
            }
            if (d2Var != null) {
                d2Var.w.T4();
            }
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void G0(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2Var) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", e2Var.h0()).param("obj_locate", b0() ? 2 : 1).param("obj_id", e2Var.p1() == null ? -1L : e2Var.p1().live_id).param("obj_type", 1));
        }
    }

    @Override // c.a.t0.g0.b0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // c.a.t0.t.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.y = str;
        }
    }

    @Override // c.a.t0.e1.w2.d
    public c.a.t0.e1.w2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? c.a.t0.e1.w2.d.p0 : (c.a.t0.e1.w2.b) invokeV.objValue;
    }

    @Override // c.a.t0.g0.c0
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // c.a.t0.g0.b0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.z = i2;
        }
    }

    @Override // c.a.t0.e1.k
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.x = str;
        }
    }
}
