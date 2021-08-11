package c.a.p0.v0.m1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.d;
import c.a.l.l0;
import c.a.l.v0.a;
import c.a.o0.s.q.b2;
import c.a.o0.s.q.c2;
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
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class y extends c.a.p0.v0.k<b2, ThreadCardViewHolder<c2>> implements c.a.p0.a0.z, c.a.p0.v0.j2.d, c.a.p0.o.f, c.a.p0.a0.a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.a0.b0<c2> A;
    public String x;
    public String y;
    public int z;

    /* loaded from: classes4.dex */
    public class a extends c.a.p0.a0.b0<c2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ y f26144b;

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
            this.f26144b = yVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a0.b0
        /* renamed from: d */
        public void a(View view, c2 c2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, c2Var) == null) || view == null || c2Var == null) {
                return;
            }
            if (this.f26144b.u != null) {
                this.f26144b.u.b(view, c2Var, this.f26144b.K());
            }
            if ("c13010".equals(this.f26144b.x)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", c2Var.T()).param("tid", c2Var.q1()));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view instanceof TbImageView) {
                    if (this.f26144b.A.f14951a instanceof Boolean) {
                        if (((Boolean) this.f26144b.A.f14951a).booleanValue()) {
                            c.a.p0.v0.j2.a.e(c2Var, 1, this.f26144b.f2908i, c.a.p0.v0.j2.d.h0, this.f26144b.i0());
                        } else {
                            c.a.p0.v0.j2.a.e(c2Var, 3, this.f26144b.f2908i, c.a.p0.v0.j2.d.h0, this.f26144b.i0());
                        }
                    }
                    c.a.p0.v0.n2.l.g(c2Var, this.f26144b.n, 2);
                } else if (view instanceof ThreadGodReplyLayout) {
                    c.a.p0.v0.j2.a.e(c2Var, 15, this.f26144b.f2908i, c.a.p0.v0.j2.d.h0, this.f26144b.i0());
                    if (this.f26144b.n != null && this.f26144b.n.getForum() != null) {
                        c.a.p0.v0.j2.a.c(c2Var, this.f26144b.n.getForum().getId());
                    }
                } else {
                    c.a.p0.v0.j2.a.e(c2Var, 1, this.f26144b.f2908i, c.a.p0.v0.j2.d.h0, this.f26144b.i0());
                    if (this.f26144b.n != null && this.f26144b.n.getForum() != null) {
                        c.a.p0.v0.j2.a.c(c2Var, this.f26144b.n.getForum().getId());
                    }
                }
            } else {
                c.a.p0.v0.j2.a.e(c2Var, 2, this.f26144b.f2908i, c.a.p0.v0.j2.d.h0, this.f26144b.i0());
            }
            if (view.getId() == R.id.thread_card_root && c2Var.A2()) {
                this.f26144b.O0(c2Var);
            } else if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.card_divider_tv) {
                    c.a.p0.v0.n2.l.a(c.a.p0.v0.j2.d.h0, c2Var.getRecomReason());
                } else if (view instanceof TbImageView) {
                    if (this.f26144b.A.f14951a instanceof Boolean) {
                        if (((Boolean) this.f26144b.A.f14951a).booleanValue()) {
                            c.a.p0.v0.j2.c.j().g(c.a.p0.v0.j2.d.h0, c2Var, 1);
                        } else {
                            c.a.p0.v0.j2.c.j().g(c.a.p0.v0.j2.d.h0, c2Var, 3);
                        }
                    }
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view.getId() == R.id.thread_card_voice) {
                    c.a.p0.v0.j2.c.j().g(c.a.p0.v0.j2.d.h0, c2Var, 5);
                } else if (view instanceof ThreadGodReplyLayout) {
                    int i2 = 6;
                    if (c2Var.t1() != null && c2Var.t1().K() != null && c2Var.t1().K().y() != null && c2Var.t1().K().y().size() > 0) {
                        i2 = c2Var.t1().N ? 9 : 8;
                    }
                    c.a.p0.v0.j2.c.j().g(c.a.p0.v0.j2.d.h0, c2Var, i2);
                } else {
                    c.a.p0.v0.j2.c.j().g(c.a.p0.v0.j2.d.h0, c2Var, 1);
                }
            } else {
                c.a.p0.v0.j2.c.j().g(c.a.p0.v0.j2.d.h0, c2Var, 2);
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void a(c.a.o0.s.q.a aVar, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, view) == null) || aVar == null) {
                return;
            }
            if (view.getId() == R.id.user_name) {
                aVar.objType = 3;
            } else if (view.getId() == R.id.user_avatar) {
                aVar.objType = 4;
            } else {
                aVar.objType = 1;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.a.e.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ y f26145e;

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
            this.f26145e = yVar;
        }

        @Override // c.a.e.k.e.w
        public void b(View view, c.a.e.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof b2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                c2 c2Var = ((b2) nVar).w;
                c2Var.objType = 1;
                if (this.f26145e.A != null) {
                    this.f26145e.A.a(threadCardViewHolder.getView(), c2Var);
                }
                ThreadCardUtils.jumpToPB((c.a.o0.s.q.a) c2Var, view.getContext(), this.f26145e.z, false, c.a.l.e.a((c.a.e.k.e.s) viewGroup, view, i2));
                threadCardViewHolder.getCardView().o(new a.C0088a(1));
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
        this.f2908i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.k.e.a
    /* renamed from: M0 */
    public ThreadCardViewHolder<c2> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity(), true);
            c.a.l.d dVar = new c.a.l.d(this.o.getPageActivity());
            dVar.a(4280);
            dVar.s(this.f2908i);
            dVar.r(new b(this));
            if (this.w) {
                bVar.l().d(0);
                bVar.l().g(0);
            }
            bVar.o(dVar);
            l0 k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.q);
            k.r(3);
            ThreadCardViewHolder<c2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.f2908i);
            threadCardViewHolder.showMultiDelDecorItem(false);
            d0(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.v0.k, c.a.e.k.e.a
    /* renamed from: N0 */
    public View a0(int i2, View view, ViewGroup viewGroup, b2 b2Var, ThreadCardViewHolder<c2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view, viewGroup, b2Var, threadCardViewHolder})) == null) {
            super.a0(i2, view, viewGroup, b2Var, threadCardViewHolder);
            if (b2Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            threadCardViewHolder.getCardView().setPage(this.y);
            threadCardViewHolder.getCardView().q(i2);
            c.a.p0.v0.j.i(threadCardViewHolder.getCardView().e(), this.n);
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
                b2Var.w.m4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
            }
            threadCardViewHolder.showFollowUserDecorItemIfNeed(b2Var.w.showFollowBtn(), null);
            threadCardViewHolder.showNEGFeedBackViewIfNeed(true, Align.ALIGN_RIGHT_TOP, null);
            if (!b2Var.w.N1() && !b2Var.w.E2() && !CommonStatisticKey.KEY_FRS_ITEM_TAB_COMMENT_CLICK.equals(this.x)) {
                threadCardViewHolder.showThemeAndStarDecorItem();
            } else {
                threadCardViewHolder.removeThemeAndStarDecorItem();
            }
            threadCardViewHolder.onBindDataToView(b2Var.w);
            threadCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.A);
            b2Var.w.C4();
            if (c.a.p0.v0.j2.d.h0 != null) {
                FrsViewData frsViewData2 = this.n;
                b2Var.w.Q1 = (b2Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            c.a.p0.v0.j2.c.j().c(c.a.p0.v0.j2.d.h0, b2Var.w);
            b2Var.w.C4();
            c.a.p0.v0.j2.a.m(b2Var.w, this.f2908i, c.a.p0.v0.j2.d.h0, i0());
            FrsViewData frsViewData3 = this.n;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                c.a.p0.v0.j2.a.l(b2Var.w, this.n.getForum().getId());
            }
            if (b2Var != null) {
                b2Var.w.C4();
            }
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void O0(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c2Var) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", c2Var.f0()).param("obj_locate", j0() ? 2 : 1).param("obj_id", c2Var.j1() == null ? -1L : c2Var.j1().live_id).param("obj_type", 1));
        }
    }

    @Override // c.a.p0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // c.a.p0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.y = str;
        }
    }

    @Override // c.a.p0.v0.j2.d
    public c.a.p0.v0.j2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? c.a.p0.v0.j2.d.h0 : (c.a.p0.v0.j2.b) invokeV.objValue;
    }

    @Override // c.a.p0.a0.a0
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // c.a.p0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.z = i2;
        }
    }

    @Override // c.a.p0.v0.k, c.a.p0.a0.y
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.x = str;
        }
    }
}
