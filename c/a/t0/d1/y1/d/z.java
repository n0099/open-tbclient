package c.a.t0.d1.y1.d;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.a;
import c.a.l.l0;
import c.a.l.t0;
import c.a.l.w0.a;
import c.a.s0.s.q.c2;
import c.a.s0.s.q.d2;
import c.a.t0.d1.f1;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class z extends c.a.t0.d1.k<c2, AutoVideoCardViewHolder<d2>> implements c.a.t0.g0.b0, c.a.t0.d1.v2.d, c.a.t0.t.f, c.a.t0.g0.c0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public c.a.t0.d1.v2.b B;
    public c.a.t0.g0.d0<d2> C;
    public TbPageContext<?> x;
    public String y;
    public String z;

    /* loaded from: classes7.dex */
    public class a extends c.a.t0.g0.d0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f17245b;

        public a(z zVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17245b = zVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.g0.d0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) || view == null || d2Var == null) {
                return;
            }
            if (this.f17245b.u != null) {
                this.f17245b.u.b(view, d2Var, d2.G3);
            }
            if ("c13010".equals(this.f17245b.z)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 2).param("fid", d2Var.U()).param("tid", d2Var.v1()));
            }
            if (view.getId() == f1.thread_card_root && d2Var.H2()) {
                c.a.t0.d1.v2.c.k().h(this.f17245b.B, d2Var, 1);
                this.f17245b.K0(d2Var);
            } else if (view.getId() == f1.card_home_page_normal_thread_user_icon) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view.getId() == f1.user_name || view.getId() == f1.user_avatar) {
                c.a.t0.d1.v2.c.k().h(this.f17245b.B, d2Var, 2);
            } else if (view.getId() == f1.header_divider) {
                c.a.t0.d1.y2.l.a(this.f17245b.B, d2Var.getRecomReason());
            } else if (view.getId() == f1.operable_video_container) {
                c.a.t0.d1.v2.c.k().h(this.f17245b.B, d2Var, 4);
                this.f17245b.K0(d2Var);
            } else if (view instanceof ThreadGodReplyLayout) {
                this.f17245b.K0(d2Var);
            }
            if (view.getId() == f1.operable_video_container) {
                c.a.t0.d1.v2.a.e(d2Var, 4, this.f17245b.f3303i, this.f17245b.B, this.f17245b.a0());
                c.a.t0.d1.y2.l.g(d2Var, this.f17245b.n, 2);
            } else if (view.getId() == f1.video_play) {
                c.a.t0.d1.v2.a.e(d2Var, 4, this.f17245b.f3303i, this.f17245b.B, this.f17245b.a0());
                c.a.t0.d1.y2.l.g(d2Var, this.f17245b.n, 1);
            } else if (view.getId() != f1.user_name && view.getId() != f1.user_avatar) {
                if (view.getId() == f1.thread_info_commont_container) {
                    c.a.t0.d1.v2.a.e(d2Var, 5, this.f17245b.f3303i, this.f17245b.B, this.f17245b.a0());
                    c.a.t0.d1.y2.l.g(d2Var, this.f17245b.n, 1);
                } else if (view instanceof ThreadGodReplyLayout) {
                    c.a.t0.d1.v2.a.e(d2Var, 15, this.f17245b.f3303i, this.f17245b.B, this.f17245b.a0());
                    c.a.t0.d1.y2.l.g(d2Var, this.f17245b.n, 1);
                } else if (view.getId() != f1.share_num_container) {
                    c.a.t0.d1.y2.l.g(d2Var, this.f17245b.n, 1);
                    c.a.t0.d1.v2.a.e(d2Var, 1, this.f17245b.f3303i, this.f17245b.B, this.f17245b.a0());
                } else {
                    c.a.t0.d1.v2.a.e(d2Var, 14, this.f17245b.f3303i, this.f17245b.B, this.f17245b.a0());
                }
            } else {
                c.a.t0.d1.v2.a.e(d2Var, 2, this.f17245b.f3303i, this.f17245b.B, this.f17245b.a0());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.InterfaceC0184a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t0 a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f17246b;

        public b(z zVar, t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar, t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17246b = zVar;
            this.a = t0Var;
        }

        @Override // c.a.l.a.InterfaceC0184a
        public void a(c.a.s0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(aVar instanceof d2)) {
                ThreadCardUtils.jumpToPB(aVar, this.f17246b.f3299e, this.f17246b.A, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f17246b.f3299e, this.f17246b.A, false, computeViewArea);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements c.a.d.n.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ z f17247e;

        public c(z zVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17247e = zVar;
        }

        @Override // c.a.d.n.e.w
        public void b(View view, c.a.d.n.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d2 d2Var = ((c2) nVar).w;
                d2Var.objType = 1;
                if (this.f17247e.C != null) {
                    this.f17247e.C.a(threadCardViewHolder.getView(), d2Var);
                }
                ThreadCardUtils.jumpToPB((c.a.s0.s.q.a) d2Var, view.getContext(), this.f17247e.A, false, c.a.l.e.a((c.a.d.n.e.s) viewGroup, view, i2));
                threadCardViewHolder.getCardView().o(new a.C0186a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
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
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.A = 3;
        this.B = new c.a.t0.d1.v2.b();
        this.C = new a(this);
        this.x = tbPageContext;
    }

    public final c.a.t0.z2.t H0(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d2Var)) == null) {
            if (d2Var == null) {
                return null;
            }
            c.a.t0.z2.t tVar = new c.a.t0.z2.t();
            if (100 == a0().tabType) {
                tVar.a = d2Var.Z1() ? "3" : "25";
            } else {
                tVar.a = d2Var.Z1() ? "3" : "2";
            }
            if (this.B.f16990d == 501) {
                tVar.a = "frs_tab";
            }
            tVar.f26872d = this.B.f16989c;
            tVar.f26871c = d2Var.v1();
            tVar.f26874f = d2Var.Z0;
            tVar.f26875g = d2Var.d1;
            tVar.f26876h = d2Var.a1;
            tVar.l = d2Var.b1;
            if (d2Var.t1() != null) {
                tVar.m = d2Var.t1().video_md5;
            }
            return tVar;
        }
        return (c.a.t0.z2.t) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: I0 */
    public AutoVideoCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.x.getPageActivity(), false);
            c.a.l.g gVar = new c.a.l.g(this.x.getPageActivity(), true);
            gVar.t("frs");
            gVar.x("2003");
            gVar.u(new b(this, gVar));
            if (this.A == 502) {
                gVar.v(false);
            } else {
                gVar.v(true);
            }
            bVar.n(gVar);
            l0 k2 = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k2);
            autoVideoCardViewHolder.setPageId(this.f3303i);
            k2.p(this.C);
            k2.r(this.A);
            V(new c(this));
            autoVideoCardViewHolder.showMultiDelDecorItem(false);
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.d1.k, c.a.d.n.e.a
    /* renamed from: J0 */
    public View S(int i2, View view, ViewGroup viewGroup, c2 c2Var, AutoVideoCardViewHolder<d2> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view, viewGroup, c2Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (c2Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder.getCardView() instanceof c.a.t0.t.e) {
                autoVideoCardViewHolder.getCardView().d(this.y);
            }
            super.S(i2, view, viewGroup, c2Var, autoVideoCardViewHolder);
            c.a.t0.d1.j.i(autoVideoCardViewHolder.getCardView().f(), this.n);
            autoVideoCardViewHolder.setVideoStatsData(H0(c2Var.w));
            autoVideoCardViewHolder.getCardView().q(i2);
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
                c2Var.w.A4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
            }
            autoVideoCardViewHolder.onBindDataToView(c2Var.w);
            autoVideoCardViewHolder.getCardView().onChangeSkinType(this.x, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.getCardView().p(this.C);
            if (this.B != null) {
                FrsViewData frsViewData2 = this.n;
                c2Var.w.U1 = (c2Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            c.a.t0.d1.v2.c.k().c(this.B, c2Var.w);
            c.a.t0.d1.v2.c.k().b(c2Var.w);
            c.a.t0.d1.v2.c.k().e(c2Var.w, b0());
            c.a.t0.d1.v2.a.m(c2Var.w, this.f3303i, this.B, a0());
            FrsViewData frsViewData3 = this.n;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                c.a.t0.d1.v2.a.l(c2Var.w, this.n.getForum().getId());
            }
            if (100 == a0().tabType) {
                c.a.t0.d1.v2.c.k().f(c2Var.w);
            }
            c2Var.w.S4();
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void K0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, d2Var) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", d2Var.g0()).param("obj_locate", b0() ? 2 : 1).param("obj_id", d2Var.o1() == null ? -1L : d2Var.o1().live_id).param("obj_type", 1));
        }
    }

    @Override // c.a.t0.g0.b0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // c.a.t0.t.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.y = str;
        }
    }

    @Override // c.a.t0.d1.v2.d
    public c.a.t0.d1.v2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.B : (c.a.t0.d1.v2.b) invokeV.objValue;
    }

    @Override // c.a.t0.g0.c0
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // c.a.t0.g0.b0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.A = i2;
        }
    }

    @Override // c.a.t0.d1.k
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.z = str;
        }
    }
}
