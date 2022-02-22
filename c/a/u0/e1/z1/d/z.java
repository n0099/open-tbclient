package c.a.u0.e1.z1.d;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.a;
import c.a.l.l0;
import c.a.l.t0;
import c.a.l.w0.a;
import c.a.t0.s.r.d2;
import c.a.t0.s.r.e2;
import c.a.u0.e1.f1;
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
/* loaded from: classes8.dex */
public class z extends c.a.u0.e1.k<d2, AutoVideoCardViewHolder<e2>> implements c.a.u0.g0.z, c.a.u0.e1.y2.d, c.a.u0.t.f, c.a.u0.g0.a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public c.a.u0.e1.y2.b B;
    public c.a.u0.g0.b0<e2> C;
    public TbPageContext<?> x;
    public String y;
    public String z;

    /* loaded from: classes8.dex */
    public class a extends c.a.u0.g0.b0<e2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f17436b;

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
            this.f17436b = zVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.u0.g0.b0
        /* renamed from: d */
        public void a(View view, e2 e2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, e2Var) == null) || view == null || e2Var == null) {
                return;
            }
            if (this.f17436b.u != null) {
                this.f17436b.u.b(view, e2Var, e2.H3);
            }
            if ("c13010".equals(this.f17436b.z)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 2).param("fid", e2Var.U()).param("tid", e2Var.w1()));
            }
            if (view.getId() == f1.thread_card_root && e2Var.I2()) {
                c.a.u0.e1.y2.c.k().h(this.f17436b.B, e2Var, 1);
                this.f17436b.K0(e2Var);
            } else if (view.getId() == f1.card_home_page_normal_thread_user_icon) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view.getId() == f1.user_name || view.getId() == f1.user_avatar) {
                c.a.u0.e1.y2.c.k().h(this.f17436b.B, e2Var, 2);
            } else if (view.getId() == f1.header_divider) {
                c.a.u0.e1.b3.q.a(this.f17436b.B, e2Var.getRecomReason());
            } else if (view.getId() == f1.operable_video_container) {
                c.a.u0.e1.y2.c.k().h(this.f17436b.B, e2Var, 4);
                this.f17436b.K0(e2Var);
            } else if (view instanceof ThreadGodReplyLayout) {
                this.f17436b.K0(e2Var);
            }
            if (view.getId() == f1.operable_video_container) {
                c.a.u0.e1.y2.a.e(e2Var, 4, this.f17436b.f2451i, this.f17436b.B, this.f17436b.a0());
                c.a.u0.e1.b3.q.g(e2Var, this.f17436b.n, 2);
            } else if (view.getId() == f1.video_play) {
                c.a.u0.e1.y2.a.e(e2Var, 4, this.f17436b.f2451i, this.f17436b.B, this.f17436b.a0());
                c.a.u0.e1.b3.q.g(e2Var, this.f17436b.n, 1);
            } else if (view.getId() != f1.user_name && view.getId() != f1.user_avatar) {
                if (view.getId() == f1.thread_info_commont_container) {
                    c.a.u0.e1.y2.a.e(e2Var, 5, this.f17436b.f2451i, this.f17436b.B, this.f17436b.a0());
                    c.a.u0.e1.b3.q.g(e2Var, this.f17436b.n, 1);
                } else if (view instanceof ThreadGodReplyLayout) {
                    c.a.u0.e1.y2.a.e(e2Var, 15, this.f17436b.f2451i, this.f17436b.B, this.f17436b.a0());
                    c.a.u0.e1.b3.q.g(e2Var, this.f17436b.n, 1);
                } else if (view.getId() != f1.share_num_container) {
                    c.a.u0.e1.b3.q.g(e2Var, this.f17436b.n, 1);
                    c.a.u0.e1.y2.a.e(e2Var, 1, this.f17436b.f2451i, this.f17436b.B, this.f17436b.a0());
                } else {
                    c.a.u0.e1.y2.a.e(e2Var, 14, this.f17436b.f2451i, this.f17436b.B, this.f17436b.a0());
                }
            } else {
                c.a.u0.e1.y2.a.e(e2Var, 2, this.f17436b.f2451i, this.f17436b.B, this.f17436b.a0());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.InterfaceC0208a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t0 a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f17437b;

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
            this.f17437b = zVar;
            this.a = t0Var;
        }

        @Override // c.a.l.a.InterfaceC0208a
        public void a(c.a.t0.s.r.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(aVar instanceof e2)) {
                ThreadCardUtils.jumpToPB(aVar, this.f17437b.f2447e, this.f17437b.A, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f17437b.f2447e, this.f17437b.A, false, computeViewArea);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements c.a.d.o.e.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ z f17438e;

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
            this.f17438e = zVar;
        }

        @Override // c.a.d.o.e.v
        public void b(View view, c.a.d.o.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof d2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                e2 e2Var = ((d2) nVar).w;
                e2Var.objType = 1;
                if (this.f17438e.C != null) {
                    this.f17438e.C.a(threadCardViewHolder.getView(), e2Var);
                }
                ThreadCardUtils.jumpToPB((c.a.t0.s.r.a) e2Var, view.getContext(), this.f17438e.A, false, c.a.l.e.a((c.a.d.o.e.s) viewGroup, view, i2));
                threadCardViewHolder.getCardView().o(new a.C0210a(1));
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
        this.B = new c.a.u0.e1.y2.b();
        this.C = new a(this);
        this.x = tbPageContext;
    }

    public final c.a.u0.b3.t H0(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e2Var)) == null) {
            if (e2Var == null) {
                return null;
            }
            c.a.u0.b3.t tVar = new c.a.u0.b3.t();
            if (100 == a0().tabType) {
                tVar.a = e2Var.a2() ? "3" : "25";
            } else {
                tVar.a = e2Var.a2() ? "3" : "2";
            }
            if (this.B.f17333e == 501) {
                tVar.a = "frs_tab";
            }
            tVar.f15611d = this.B.f17331c;
            tVar.f15610c = e2Var.w1();
            tVar.f15613f = e2Var.Z0;
            tVar.f15614g = e2Var.d1;
            tVar.f15615h = e2Var.a1;
            tVar.l = e2Var.b1;
            if (e2Var.u1() != null) {
                tVar.m = e2Var.u1().video_md5;
            }
            return tVar;
        }
        return (c.a.u0.b3.t) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
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
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.setPageId(this.f2451i);
            k.p(this.C);
            k.r(this.A);
            V(new c(this));
            autoVideoCardViewHolder.showMultiDelDecorItem(false);
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.u0.e1.k, c.a.d.o.e.a
    /* renamed from: J0 */
    public View S(int i2, View view, ViewGroup viewGroup, d2 d2Var, AutoVideoCardViewHolder<e2> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view, viewGroup, d2Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (d2Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder.getCardView() instanceof c.a.u0.t.e) {
                autoVideoCardViewHolder.getCardView().d(this.y);
            }
            super.S(i2, view, viewGroup, d2Var, autoVideoCardViewHolder);
            c.a.u0.e1.j.i(autoVideoCardViewHolder.getCardView().f(), this.n);
            autoVideoCardViewHolder.setVideoStatsData(H0(d2Var.w));
            autoVideoCardViewHolder.getCardView().q(i2);
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
                d2Var.w.B4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
            }
            autoVideoCardViewHolder.onBindDataToView(d2Var.w);
            autoVideoCardViewHolder.getCardView().onChangeSkinType(this.x, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.getCardView().p(this.C);
            if (this.B != null) {
                FrsViewData frsViewData2 = this.n;
                d2Var.w.T1 = (d2Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            c.a.u0.e1.y2.c.k().c(this.B, d2Var.w);
            c.a.u0.e1.y2.c.k().b(d2Var.w);
            c.a.u0.e1.y2.c.k().e(d2Var.w, b0());
            c.a.u0.e1.y2.a.n(d2Var.w, this.f2451i, this.B, a0());
            FrsViewData frsViewData3 = this.n;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                c.a.u0.e1.y2.a.l(d2Var.w, a0());
                c.a.u0.e1.y2.a.m(d2Var.w, this.n.getForum().getId());
            }
            if (100 == a0().tabType) {
                c.a.u0.e1.y2.c.k().f(d2Var.w);
            }
            d2Var.w.T4();
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void K0(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, e2Var) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", e2Var.h0()).param("obj_locate", b0() ? 2 : 1).param("obj_id", e2Var.p1() == null ? -1L : e2Var.p1().live_id).param("obj_type", 1));
        }
    }

    @Override // c.a.u0.g0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // c.a.u0.t.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.y = str;
        }
    }

    @Override // c.a.u0.e1.y2.d
    public c.a.u0.e1.y2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.B : (c.a.u0.e1.y2.b) invokeV.objValue;
    }

    @Override // c.a.u0.g0.a0
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // c.a.u0.g0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.A = i2;
        }
    }

    @Override // c.a.u0.e1.k
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.z = str;
        }
    }
}
