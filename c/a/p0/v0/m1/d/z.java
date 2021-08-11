package c.a.p0.v0.m1.d;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.a;
import c.a.l.l0;
import c.a.l.t0;
import c.a.l.v0.a;
import c.a.o0.s.q.b2;
import c.a.o0.s.q.c2;
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
public class z extends c.a.p0.v0.k<b2, AutoVideoCardViewHolder<c2>> implements c.a.p0.a0.z, c.a.p0.v0.j2.d, c.a.p0.o.f, c.a.p0.a0.a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public c.a.p0.v0.j2.b B;
    public c.a.p0.a0.b0<c2> C;
    public TbPageContext<?> x;
    public String y;
    public String z;

    /* loaded from: classes4.dex */
    public class a extends c.a.p0.a0.b0<c2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f26146b;

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
            this.f26146b = zVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a0.b0
        /* renamed from: d */
        public void a(View view, c2 c2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, c2Var) == null) || view == null || c2Var == null) {
                return;
            }
            if (this.f26146b.u != null) {
                this.f26146b.u.b(view, c2Var, c2.t3);
            }
            if ("c13010".equals(this.f26146b.z)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 2).param("fid", c2Var.T()).param("tid", c2Var.q1()));
            }
            if (view.getId() == R.id.thread_card_root && c2Var.A2()) {
                c.a.p0.v0.j2.c.j().g(this.f26146b.B, c2Var, 1);
                this.f26146b.S0(c2Var);
            } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                c.a.p0.v0.j2.c.j().g(this.f26146b.B, c2Var, 2);
            } else if (view.getId() == R.id.header_divider) {
                c.a.p0.v0.n2.l.a(this.f26146b.B, c2Var.getRecomReason());
            } else if (view.getId() == R.id.operable_video_container) {
                c.a.p0.v0.j2.c.j().g(this.f26146b.B, c2Var, 4);
                this.f26146b.S0(c2Var);
            } else if (view instanceof ThreadGodReplyLayout) {
                this.f26146b.S0(c2Var);
            }
            if (view.getId() == R.id.operable_video_container) {
                c.a.p0.v0.j2.a.e(c2Var, 4, this.f26146b.f2908i, this.f26146b.B, this.f26146b.i0());
                c.a.p0.v0.n2.l.g(c2Var, this.f26146b.n, 2);
            } else if (view.getId() == R.id.video_play) {
                c.a.p0.v0.j2.a.e(c2Var, 4, this.f26146b.f2908i, this.f26146b.B, this.f26146b.i0());
                c.a.p0.v0.n2.l.g(c2Var, this.f26146b.n, 1);
            } else if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    c.a.p0.v0.j2.a.e(c2Var, 5, this.f26146b.f2908i, this.f26146b.B, this.f26146b.i0());
                    c.a.p0.v0.n2.l.g(c2Var, this.f26146b.n, 1);
                } else if (view instanceof ThreadGodReplyLayout) {
                    c.a.p0.v0.j2.a.e(c2Var, 15, this.f26146b.f2908i, this.f26146b.B, this.f26146b.i0());
                    c.a.p0.v0.n2.l.g(c2Var, this.f26146b.n, 1);
                } else if (view.getId() != R.id.share_num_container) {
                    c.a.p0.v0.n2.l.g(c2Var, this.f26146b.n, 1);
                    c.a.p0.v0.j2.a.e(c2Var, 1, this.f26146b.f2908i, this.f26146b.B, this.f26146b.i0());
                } else {
                    c.a.p0.v0.j2.a.e(c2Var, 14, this.f26146b.f2908i, this.f26146b.B, this.f26146b.i0());
                }
            } else {
                c.a.p0.v0.j2.a.e(c2Var, 2, this.f26146b.f2908i, this.f26146b.B, this.f26146b.i0());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.InterfaceC0086a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f26147a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f26148b;

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
            this.f26148b = zVar;
            this.f26147a = t0Var;
        }

        @Override // c.a.l.a.InterfaceC0086a
        public void a(c.a.o0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f26147a.getVideoContainer());
            if (!(aVar instanceof c2)) {
                ThreadCardUtils.jumpToPB(aVar, this.f26148b.f2904e, this.f26148b.A, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f26148b.f2904e, this.f26148b.A, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.a.e.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ z f26149e;

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
            this.f26149e = zVar;
        }

        @Override // c.a.e.k.e.w
        public void b(View view, c.a.e.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof b2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                c2 c2Var = ((b2) nVar).w;
                c2Var.objType = 1;
                if (this.f26149e.C != null) {
                    this.f26149e.C.a(threadCardViewHolder.getView(), c2Var);
                }
                ThreadCardUtils.jumpToPB((c.a.o0.s.q.a) c2Var, view.getContext(), this.f26149e.A, false, c.a.l.e.a((c.a.e.k.e.s) viewGroup, view, i2));
                threadCardViewHolder.getCardView().o(new a.C0088a(1));
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
        this.B = new c.a.p0.v0.j2.b();
        this.C = new a(this);
        this.x = tbPageContext;
    }

    public final c.a.p0.o2.o P0(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c2Var)) == null) {
            if (c2Var == null) {
                return null;
            }
            c.a.p0.o2.o oVar = new c.a.p0.o2.o();
            oVar.f22884a = c2Var.T1() ? "3" : "2";
            if (this.B.f25940d == 501) {
                oVar.f22884a = "frs_tab";
            }
            oVar.f22887d = this.B.f25939c;
            oVar.f22886c = c2Var.q1();
            oVar.f22889f = c2Var.U0;
            oVar.f22890g = c2Var.Y0;
            oVar.f22891h = c2Var.V0;
            oVar.l = c2Var.W0;
            if (c2Var.o1() != null) {
                oVar.m = c2Var.o1().video_md5;
            }
            return oVar;
        }
        return (c.a.p0.o2.o) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.k.e.a
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
            autoVideoCardViewHolder.setPageId(this.f2908i);
            k.p(this.C);
            k.r(this.A);
            d0(new c(this));
            autoVideoCardViewHolder.showMultiDelDecorItem(false);
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.v0.k, c.a.e.k.e.a
    /* renamed from: R0 */
    public View a0(int i2, View view, ViewGroup viewGroup, b2 b2Var, AutoVideoCardViewHolder<c2> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view, viewGroup, b2Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (b2Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder.getCardView() instanceof c.a.p0.o.e) {
                autoVideoCardViewHolder.getCardView().setPage(this.y);
            }
            super.a0(i2, view, viewGroup, b2Var, autoVideoCardViewHolder);
            c.a.p0.v0.j.i(autoVideoCardViewHolder.getCardView().e(), this.n);
            autoVideoCardViewHolder.setVideoStatsData(P0(b2Var.w));
            autoVideoCardViewHolder.getCardView().q(i2);
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
                b2Var.w.m4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
            }
            autoVideoCardViewHolder.onBindDataToView(b2Var.w);
            autoVideoCardViewHolder.getCardView().onChangeSkinType(this.x, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.getCardView().p(this.C);
            if (this.B != null) {
                FrsViewData frsViewData2 = this.n;
                b2Var.w.Q1 = (b2Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            c.a.p0.v0.j2.c.j().c(this.B, b2Var.w);
            c.a.p0.v0.j2.c.j().b(b2Var.w);
            c.a.p0.v0.j2.c.j().e(b2Var.w, j0());
            c.a.p0.v0.j2.a.m(b2Var.w, this.f2908i, this.B, i0());
            FrsViewData frsViewData3 = this.n;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                c.a.p0.v0.j2.a.l(b2Var.w, this.n.getForum().getId());
            }
            b2Var.w.C4();
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void S0(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, c2Var) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", c2Var.f0()).param("obj_locate", j0() ? 2 : 1).param("obj_id", c2Var.j1() == null ? -1L : c2Var.j1().live_id).param("obj_type", 1));
        }
    }

    @Override // c.a.p0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // c.a.p0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.y = str;
        }
    }

    @Override // c.a.p0.v0.j2.d
    public c.a.p0.v0.j2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.B : (c.a.p0.v0.j2.b) invokeV.objValue;
    }

    @Override // c.a.p0.a0.a0
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // c.a.p0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.A = i2;
        }
    }

    @Override // c.a.p0.v0.k, c.a.p0.a0.y
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.z = str;
        }
    }
}
