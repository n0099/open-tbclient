package b.a.r0.x0.x1.d;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.l.a;
import b.a.l.l0;
import b.a.l.t0;
import b.a.l.v0.a;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.r0.x0.e1;
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
/* loaded from: classes5.dex */
public class z extends b.a.r0.x0.k<c2, AutoVideoCardViewHolder<d2>> implements b.a.r0.b0.a0, b.a.r0.x0.u2.d, b.a.r0.p.f, b.a.r0.b0.b0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public b.a.r0.x0.u2.b B;
    public b.a.r0.b0.c0<d2> C;
    public TbPageContext<?> x;
    public String y;
    public String z;

    /* loaded from: classes5.dex */
    public class a extends b.a.r0.b0.c0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f26687b;

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
            this.f26687b = zVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) || view == null || d2Var == null) {
                return;
            }
            if (this.f26687b.u != null) {
                this.f26687b.u.b(view, d2Var, d2.x3);
            }
            if ("c13010".equals(this.f26687b.z)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 2).param("fid", d2Var.T()).param("tid", d2Var.s1()));
            }
            if (view.getId() == e1.thread_card_root && d2Var.E2()) {
                b.a.r0.x0.u2.c.j().g(this.f26687b.B, d2Var, 1);
                this.f26687b.R0(d2Var);
            } else if (view.getId() == e1.card_home_page_normal_thread_user_icon) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view.getId() == e1.user_name || view.getId() == e1.user_avatar) {
                b.a.r0.x0.u2.c.j().g(this.f26687b.B, d2Var, 2);
            } else if (view.getId() == e1.header_divider) {
                b.a.r0.x0.x2.l.a(this.f26687b.B, d2Var.getRecomReason());
            } else if (view.getId() == e1.operable_video_container) {
                b.a.r0.x0.u2.c.j().g(this.f26687b.B, d2Var, 4);
                this.f26687b.R0(d2Var);
            } else if (view instanceof ThreadGodReplyLayout) {
                this.f26687b.R0(d2Var);
            }
            if (view.getId() == e1.operable_video_container) {
                b.a.r0.x0.u2.a.e(d2Var, 4, this.f26687b.f2423i, this.f26687b.B, this.f26687b.h0());
                b.a.r0.x0.x2.l.g(d2Var, this.f26687b.n, 2);
            } else if (view.getId() == e1.video_play) {
                b.a.r0.x0.u2.a.e(d2Var, 4, this.f26687b.f2423i, this.f26687b.B, this.f26687b.h0());
                b.a.r0.x0.x2.l.g(d2Var, this.f26687b.n, 1);
            } else if (view.getId() != e1.user_name && view.getId() != e1.user_avatar) {
                if (view.getId() == e1.thread_info_commont_container) {
                    b.a.r0.x0.u2.a.e(d2Var, 5, this.f26687b.f2423i, this.f26687b.B, this.f26687b.h0());
                    b.a.r0.x0.x2.l.g(d2Var, this.f26687b.n, 1);
                } else if (view instanceof ThreadGodReplyLayout) {
                    b.a.r0.x0.u2.a.e(d2Var, 15, this.f26687b.f2423i, this.f26687b.B, this.f26687b.h0());
                    b.a.r0.x0.x2.l.g(d2Var, this.f26687b.n, 1);
                } else if (view.getId() != e1.share_num_container) {
                    b.a.r0.x0.x2.l.g(d2Var, this.f26687b.n, 1);
                    b.a.r0.x0.u2.a.e(d2Var, 1, this.f26687b.f2423i, this.f26687b.B, this.f26687b.h0());
                } else {
                    b.a.r0.x0.u2.a.e(d2Var, 14, this.f26687b.f2423i, this.f26687b.B, this.f26687b.h0());
                }
            } else {
                b.a.r0.x0.u2.a.e(d2Var, 2, this.f26687b.f2423i, this.f26687b.B, this.f26687b.h0());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.InterfaceC0088a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f26688a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f26689b;

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
            this.f26689b = zVar;
            this.f26688a = t0Var;
        }

        @Override // b.a.l.a.InterfaceC0088a
        public void a(b.a.q0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f26688a.getVideoContainer());
            if (!(aVar instanceof d2)) {
                ThreadCardUtils.jumpToPB(aVar, this.f26689b.f2419e, this.f26689b.A, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f26689b.f2419e, this.f26689b.A, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements b.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ z f26690e;

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
            this.f26690e = zVar;
        }

        @Override // b.a.e.l.e.w
        public void b(View view, b.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof c2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d2 d2Var = ((c2) nVar).w;
                d2Var.objType = 1;
                if (this.f26690e.C != null) {
                    this.f26690e.C.a(threadCardViewHolder.getView(), d2Var);
                }
                ThreadCardUtils.jumpToPB((b.a.q0.s.q.a) d2Var, view.getContext(), this.f26690e.A, false, b.a.l.e.a((b.a.e.l.e.s) viewGroup, view, i2));
                threadCardViewHolder.getCardView().n(new a.C0090a(1));
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
        this.B = new b.a.r0.x0.u2.b();
        this.C = new a(this);
        this.x = tbPageContext;
    }

    public final b.a.r0.q2.p O0(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d2Var)) == null) {
            if (d2Var == null) {
                return null;
            }
            b.a.r0.q2.p pVar = new b.a.r0.q2.p();
            if (100 == h0().tabType) {
                pVar.f22882a = d2Var.W1() ? "3" : "25";
            } else {
                pVar.f22882a = d2Var.W1() ? "3" : "2";
            }
            if (this.B.f26388d == 501) {
                pVar.f22882a = "frs_tab";
            }
            pVar.f22885d = this.B.f26387c;
            pVar.f22884c = d2Var.s1();
            pVar.f22887f = d2Var.X0;
            pVar.f22888g = d2Var.b1;
            pVar.f22889h = d2Var.Y0;
            pVar.l = d2Var.Z0;
            if (d2Var.q1() != null) {
                pVar.m = d2Var.q1().video_md5;
            }
            return pVar;
        }
        return (b.a.r0.q2.p) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: P0 */
    public AutoVideoCardViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.x.getPageActivity(), false);
            b.a.l.g gVar = new b.a.l.g(this.x.getPageActivity(), true);
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
            autoVideoCardViewHolder.setPageId(this.f2423i);
            k.o(this.C);
            k.q(this.A);
            c0(new c(this));
            autoVideoCardViewHolder.showMultiDelDecorItem(false);
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.x0.k, b.a.e.l.e.a
    /* renamed from: Q0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c2 c2Var, AutoVideoCardViewHolder<d2> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view, viewGroup, c2Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (c2Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder.getCardView() instanceof b.a.r0.p.e) {
                autoVideoCardViewHolder.getCardView().setPage(this.y);
            }
            super.Z(i2, view, viewGroup, c2Var, autoVideoCardViewHolder);
            b.a.r0.x0.j.i(autoVideoCardViewHolder.getCardView().e(), this.n);
            autoVideoCardViewHolder.setVideoStatsData(O0(c2Var.w));
            autoVideoCardViewHolder.getCardView().p(i2);
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
                c2Var.w.w4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
            }
            autoVideoCardViewHolder.onBindDataToView(c2Var.w);
            autoVideoCardViewHolder.getCardView().onChangeSkinType(this.x, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.getCardView().o(this.C);
            if (this.B != null) {
                FrsViewData frsViewData2 = this.n;
                c2Var.w.T1 = (c2Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            b.a.r0.x0.u2.c.j().c(this.B, c2Var.w);
            b.a.r0.x0.u2.c.j().b(c2Var.w);
            b.a.r0.x0.u2.c.j().e(c2Var.w, i0());
            b.a.r0.x0.u2.a.m(c2Var.w, this.f2423i, this.B, h0());
            FrsViewData frsViewData3 = this.n;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                b.a.r0.x0.u2.a.l(c2Var.w, this.n.getForum().getId());
            }
            c2Var.w.O4();
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void R0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, d2Var) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", d2Var.f0()).param("obj_locate", i0() ? 2 : 1).param("obj_id", d2Var.l1() == null ? -1L : d2Var.l1().live_id).param("obj_type", 1));
        }
    }

    @Override // b.a.r0.b0.a0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // b.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.y = str;
        }
    }

    @Override // b.a.r0.x0.u2.d
    public b.a.r0.x0.u2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.B : (b.a.r0.x0.u2.b) invokeV.objValue;
    }

    @Override // b.a.r0.b0.b0
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // b.a.r0.b0.a0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.A = i2;
        }
    }

    @Override // b.a.r0.x0.k, b.a.r0.b0.z
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.z = str;
        }
    }
}
