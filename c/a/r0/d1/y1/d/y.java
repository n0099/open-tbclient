package c.a.r0.d1.y1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.k.d;
import c.a.k.l0;
import c.a.k.w0.a;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import c.a.r0.d1.f1;
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
/* loaded from: classes5.dex */
public class y extends c.a.r0.d1.k<c2, ThreadCardViewHolder<d2>> implements c.a.r0.g0.b0, c.a.r0.d1.v2.d, c.a.r0.t.f, c.a.r0.g0.c0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.g0.d0<d2> A;
    public String x;
    public String y;
    public int z;

    /* loaded from: classes5.dex */
    public class a extends c.a.r0.g0.d0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ y f16338b;

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
            this.f16338b = yVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.g0.d0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) || view == null || d2Var == null) {
                return;
            }
            if (this.f16338b.u != null) {
                this.f16338b.u.b(view, d2Var, this.f16338b.getType());
            }
            if ("c13010".equals(this.f16338b.x)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", d2Var.U()).param("tid", d2Var.v1()));
            }
            if (view.getId() != f1.user_name && view.getId() != f1.user_avatar) {
                if (view instanceof TbImageView) {
                    if (this.f16338b.A.a instanceof Boolean) {
                        if (((Boolean) this.f16338b.A.a).booleanValue()) {
                            c.a.r0.d1.v2.a.e(d2Var, 1, this.f16338b.f2911i, c.a.r0.d1.v2.d.p0, this.f16338b.h0());
                        } else {
                            c.a.r0.d1.v2.a.e(d2Var, 3, this.f16338b.f2911i, c.a.r0.d1.v2.d.p0, this.f16338b.h0());
                        }
                    }
                    c.a.r0.d1.y2.l.g(d2Var, this.f16338b.n, 2);
                } else if (view instanceof ThreadGodReplyLayout) {
                    c.a.r0.d1.v2.a.e(d2Var, 15, this.f16338b.f2911i, c.a.r0.d1.v2.d.p0, this.f16338b.h0());
                    if (this.f16338b.n != null && this.f16338b.n.getForum() != null) {
                        c.a.r0.d1.v2.a.c(d2Var, this.f16338b.n.getForum().getId());
                    }
                } else {
                    c.a.r0.d1.v2.a.e(d2Var, 1, this.f16338b.f2911i, c.a.r0.d1.v2.d.p0, this.f16338b.h0());
                    if (this.f16338b.n != null && this.f16338b.n.getForum() != null) {
                        c.a.r0.d1.v2.a.c(d2Var, this.f16338b.n.getForum().getId());
                    }
                }
            } else {
                c.a.r0.d1.v2.a.e(d2Var, 2, this.f16338b.f2911i, c.a.r0.d1.v2.d.p0, this.f16338b.h0());
            }
            if (view.getId() == f1.thread_card_root && d2Var.H2()) {
                this.f16338b.N0(d2Var);
            } else if (view.getId() != f1.user_name && view.getId() != f1.user_avatar) {
                if (view.getId() == f1.card_divider_tv) {
                    c.a.r0.d1.y2.l.a(c.a.r0.d1.v2.d.p0, d2Var.getRecomReason());
                } else if (view instanceof TbImageView) {
                    if (this.f16338b.A.a instanceof Boolean) {
                        if (((Boolean) this.f16338b.A.a).booleanValue()) {
                            c.a.r0.d1.v2.c.k().h(c.a.r0.d1.v2.d.p0, d2Var, 1);
                        } else {
                            c.a.r0.d1.v2.c.k().h(c.a.r0.d1.v2.d.p0, d2Var, 3);
                        }
                    }
                } else if (view.getId() == f1.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view.getId() == f1.thread_card_voice) {
                    c.a.r0.d1.v2.c.k().h(c.a.r0.d1.v2.d.p0, d2Var, 5);
                } else if (view instanceof ThreadGodReplyLayout) {
                    int i2 = 6;
                    if (d2Var.y1() != null && d2Var.y1().M() != null && d2Var.y1().M().y() != null && d2Var.y1().M().y().size() > 0) {
                        i2 = d2Var.y1().P ? 9 : 8;
                    }
                    c.a.r0.d1.v2.c.k().h(c.a.r0.d1.v2.d.p0, d2Var, i2);
                } else {
                    c.a.r0.d1.v2.c.k().h(c.a.r0.d1.v2.d.p0, d2Var, 1);
                }
            } else {
                c.a.r0.d1.v2.c.k().h(c.a.r0.d1.v2.d.p0, d2Var, 2);
            }
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // c.a.k.d.b
        public void a(c.a.q0.s.q.a aVar, View view) {
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

    /* loaded from: classes5.dex */
    public class c implements c.a.d.m.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ y f16339e;

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
            this.f16339e = yVar;
        }

        @Override // c.a.d.m.e.w
        public void b(View view, c.a.d.m.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d2 d2Var = ((c2) nVar).w;
                d2Var.objType = 1;
                if (this.f16339e.A != null) {
                    this.f16339e.A.a(threadCardViewHolder.getView(), d2Var);
                }
                ThreadCardUtils.jumpToPB((c.a.q0.s.q.a) d2Var, view.getContext(), this.f16339e.z, false, c.a.k.e.a((c.a.d.m.e.s) viewGroup, view, i2));
                threadCardViewHolder.getCardView().o(new a.C0131a(1));
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
        this.f2911i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: L0 */
    public ThreadCardViewHolder<d2> S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity(), true);
            c.a.k.d dVar = new c.a.k.d(this.o.getPageActivity());
            dVar.a(4280);
            dVar.s(this.f2911i);
            dVar.r(new b(this));
            if (this.w) {
                bVar.l().d(0);
                bVar.l().g(0);
            }
            bVar.o(dVar);
            l0 k2 = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.q);
            k2.r(3);
            ThreadCardViewHolder<d2> threadCardViewHolder = new ThreadCardViewHolder<>(k2);
            threadCardViewHolder.setPageId(this.f2911i);
            threadCardViewHolder.showMultiDelDecorItem(false);
            c0(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.d1.k, c.a.d.m.e.a
    /* renamed from: M0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c2 c2Var, ThreadCardViewHolder<d2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view, viewGroup, c2Var, threadCardViewHolder})) == null) {
            super.Z(i2, view, viewGroup, c2Var, threadCardViewHolder);
            if (c2Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            threadCardViewHolder.getCardView().d(this.y);
            threadCardViewHolder.getCardView().q(i2);
            c.a.r0.d1.j.i(threadCardViewHolder.getCardView().f(), this.n);
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
                c2Var.w.A4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
            }
            threadCardViewHolder.showFollowUserDecorItemIfNeed(c2Var.w.showFollowBtn(), null);
            threadCardViewHolder.showNEGFeedBackViewIfNeed(true, Align.ALIGN_RIGHT_TOP, null);
            if (!c2Var.w.T1() && !c2Var.w.M2() && !CommonStatisticKey.KEY_FRS_ITEM_TAB_COMMENT_CLICK.equals(this.x)) {
                threadCardViewHolder.showThemeAndStarDecorItem();
            } else {
                threadCardViewHolder.removeThemeAndStarDecorItem();
            }
            threadCardViewHolder.onBindDataToView(c2Var.w);
            threadCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.A);
            c2Var.w.S4();
            if (c.a.r0.d1.v2.d.p0 != null) {
                FrsViewData frsViewData2 = this.n;
                c2Var.w.U1 = (c2Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            c.a.r0.d1.v2.c.k().c(c.a.r0.d1.v2.d.p0, c2Var.w);
            c2Var.w.S4();
            c.a.r0.d1.v2.a.m(c2Var.w, this.f2911i, c.a.r0.d1.v2.d.p0, h0());
            FrsViewData frsViewData3 = this.n;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                c.a.r0.d1.v2.a.l(c2Var.w, this.n.getForum().getId());
            }
            if (c2Var != null) {
                c2Var.w.S4();
            }
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void N0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", d2Var.g0()).param("obj_locate", i0() ? 2 : 1).param("obj_id", d2Var.o1() == null ? -1L : d2Var.o1().live_id).param("obj_type", 1));
        }
    }

    @Override // c.a.r0.g0.b0
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

    @Override // c.a.r0.d1.v2.d
    public c.a.r0.d1.v2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? c.a.r0.d1.v2.d.p0 : (c.a.r0.d1.v2.b) invokeV.objValue;
    }

    @Override // c.a.r0.g0.c0
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // c.a.r0.g0.b0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.z = i2;
        }
    }

    @Override // c.a.r0.d1.k
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.x = str;
        }
    }
}
