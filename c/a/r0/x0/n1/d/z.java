package c.a.r0.x0.n1.d;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.a;
import c.a.l.l0;
import c.a.l.t0;
import c.a.l.v0.a;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
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
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class z extends c.a.r0.x0.k<c2, AutoVideoCardViewHolder<d2>> implements c.a.r0.b0.a0, c.a.r0.x0.k2.d, c.a.r0.p.f, c.a.r0.b0.b0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public c.a.r0.x0.k2.b B;
    public c.a.r0.b0.c0<d2> C;
    public TbPageContext<?> x;
    public String y;
    public String z;

    /* loaded from: classes4.dex */
    public class a extends c.a.r0.b0.c0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f27438b;

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
            this.f27438b = zVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) || view == null || d2Var == null) {
                return;
            }
            if (this.f27438b.u != null) {
                this.f27438b.u.b(view, d2Var, d2.x3);
            }
            if ("c13010".equals(this.f27438b.z)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 2).param("fid", d2Var.T()).param("tid", d2Var.s1()));
            }
            if (view.getId() == R.id.thread_card_root && d2Var.E2()) {
                c.a.r0.x0.k2.c.j().g(this.f27438b.B, d2Var, 1);
                this.f27438b.S0(d2Var);
            } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                c.a.r0.x0.k2.c.j().g(this.f27438b.B, d2Var, 2);
            } else if (view.getId() == R.id.header_divider) {
                c.a.r0.x0.n2.l.a(this.f27438b.B, d2Var.getRecomReason());
            } else if (view.getId() == R.id.operable_video_container) {
                c.a.r0.x0.k2.c.j().g(this.f27438b.B, d2Var, 4);
                this.f27438b.S0(d2Var);
            } else if (view instanceof ThreadGodReplyLayout) {
                this.f27438b.S0(d2Var);
            }
            if (view.getId() == R.id.operable_video_container) {
                c.a.r0.x0.k2.a.e(d2Var, 4, this.f27438b.f2962i, this.f27438b.B, this.f27438b.i0());
                c.a.r0.x0.n2.l.g(d2Var, this.f27438b.n, 2);
            } else if (view.getId() == R.id.video_play) {
                c.a.r0.x0.k2.a.e(d2Var, 4, this.f27438b.f2962i, this.f27438b.B, this.f27438b.i0());
                c.a.r0.x0.n2.l.g(d2Var, this.f27438b.n, 1);
            } else if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    c.a.r0.x0.k2.a.e(d2Var, 5, this.f27438b.f2962i, this.f27438b.B, this.f27438b.i0());
                    c.a.r0.x0.n2.l.g(d2Var, this.f27438b.n, 1);
                } else if (view instanceof ThreadGodReplyLayout) {
                    c.a.r0.x0.k2.a.e(d2Var, 15, this.f27438b.f2962i, this.f27438b.B, this.f27438b.i0());
                    c.a.r0.x0.n2.l.g(d2Var, this.f27438b.n, 1);
                } else if (view.getId() != R.id.share_num_container) {
                    c.a.r0.x0.n2.l.g(d2Var, this.f27438b.n, 1);
                    c.a.r0.x0.k2.a.e(d2Var, 1, this.f27438b.f2962i, this.f27438b.B, this.f27438b.i0());
                } else {
                    c.a.r0.x0.k2.a.e(d2Var, 14, this.f27438b.f2962i, this.f27438b.B, this.f27438b.i0());
                }
            } else {
                c.a.r0.x0.k2.a.e(d2Var, 2, this.f27438b.f2962i, this.f27438b.B, this.f27438b.i0());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.InterfaceC0093a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f27439a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f27440b;

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
            this.f27440b = zVar;
            this.f27439a = t0Var;
        }

        @Override // c.a.l.a.InterfaceC0093a
        public void a(c.a.q0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f27439a.getVideoContainer());
            if (!(aVar instanceof d2)) {
                ThreadCardUtils.jumpToPB(aVar, this.f27440b.f2958e, this.f27440b.A, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f27440b.f2958e, this.f27440b.A, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ z f27441e;

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
            this.f27441e = zVar;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, c.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d2 d2Var = ((c2) nVar).w;
                d2Var.objType = 1;
                if (this.f27441e.C != null) {
                    this.f27441e.C.a(threadCardViewHolder.getView(), d2Var);
                }
                ThreadCardUtils.jumpToPB((c.a.q0.s.q.a) d2Var, view.getContext(), this.f27441e.A, false, c.a.l.e.a((c.a.e.l.e.s) viewGroup, view, i2));
                threadCardViewHolder.getCardView().o(new a.C0095a(1));
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
        this.B = new c.a.r0.x0.k2.b();
        this.C = new a(this);
        this.x = tbPageContext;
    }

    public final c.a.r0.q2.o P0(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d2Var)) == null) {
            if (d2Var == null) {
                return null;
            }
            c.a.r0.q2.o oVar = new c.a.r0.q2.o();
            if (100 == i0().tabType) {
                oVar.f23997a = d2Var.W1() ? "3" : "25";
            } else {
                oVar.f23997a = d2Var.W1() ? "3" : "2";
            }
            if (this.B.f27137d == 501) {
                oVar.f23997a = "frs_tab";
            }
            oVar.f24000d = this.B.f27136c;
            oVar.f23999c = d2Var.s1();
            oVar.f24002f = d2Var.X0;
            oVar.f24003g = d2Var.b1;
            oVar.f24004h = d2Var.Y0;
            oVar.l = d2Var.Z0;
            if (d2Var.q1() != null) {
                oVar.m = d2Var.q1().video_md5;
            }
            return oVar;
        }
        return (c.a.r0.q2.o) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: Q0 */
    public AutoVideoCardViewHolder U(ViewGroup viewGroup) {
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
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.setPageId(this.f2962i);
            k.p(this.C);
            k.r(this.A);
            d0(new c(this));
            autoVideoCardViewHolder.showMultiDelDecorItem(false);
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.x0.k, c.a.e.l.e.a
    /* renamed from: R0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c2 c2Var, AutoVideoCardViewHolder<d2> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view, viewGroup, c2Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (c2Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder.getCardView() instanceof c.a.r0.p.e) {
                autoVideoCardViewHolder.getCardView().setPage(this.y);
            }
            super.a0(i2, view, viewGroup, c2Var, autoVideoCardViewHolder);
            c.a.r0.x0.j.i(autoVideoCardViewHolder.getCardView().e(), this.n);
            autoVideoCardViewHolder.setVideoStatsData(P0(c2Var.w));
            autoVideoCardViewHolder.getCardView().q(i2);
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
                c2Var.w.v4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
            }
            autoVideoCardViewHolder.onBindDataToView(c2Var.w);
            autoVideoCardViewHolder.getCardView().onChangeSkinType(this.x, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.getCardView().p(this.C);
            if (this.B != null) {
                FrsViewData frsViewData2 = this.n;
                c2Var.w.T1 = (c2Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            c.a.r0.x0.k2.c.j().c(this.B, c2Var.w);
            c.a.r0.x0.k2.c.j().b(c2Var.w);
            c.a.r0.x0.k2.c.j().e(c2Var.w, j0());
            c.a.r0.x0.k2.a.m(c2Var.w, this.f2962i, this.B, i0());
            FrsViewData frsViewData3 = this.n;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                c.a.r0.x0.k2.a.l(c2Var.w, this.n.getForum().getId());
            }
            c2Var.w.M4();
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void S0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, d2Var) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", d2Var.f0()).param("obj_locate", j0() ? 2 : 1).param("obj_id", d2Var.l1() == null ? -1L : d2Var.l1().live_id).param("obj_type", 1));
        }
    }

    @Override // c.a.r0.b0.a0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.B : (c.a.r0.x0.k2.b) invokeV.objValue;
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
            this.A = i2;
        }
    }

    @Override // c.a.r0.x0.k, c.a.r0.b0.z
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.z = str;
        }
    }
}
