package c.a.t0.d1.y1.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import c.a.l.d;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.q0;
import c.a.l.w0.a;
import c.a.s0.s.q.c2;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.x0;
import c.a.t0.d1.d1;
import c.a.t0.d1.f1;
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
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes7.dex */
public class x extends c.a.t0.d1.k<c2, ThreadCardViewHolder<d2>> implements c.a.t0.g0.b0, c.a.t0.d1.v2.d, c.a.t0.t.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public boolean B;
    public int C;
    public c.a.t0.d1.v2.b D;
    public c.a.t0.g0.d0<d2> E;
    public NEGFeedBackView.b F;
    public TbPageContext<?> x;
    public HashSet<String> y;
    public String z;

    /* loaded from: classes7.dex */
    public class a extends c.a.t0.g0.d0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ x f17241b;

        public a(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17241b = xVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.g0.d0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) || view == null || d2Var == null) {
                return;
            }
            if ("c13010".equals(this.f17241b.A)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 3).param("fid", d2Var.U()).param("tid", d2Var.v1()));
            }
            if (view.getId() != f1.user_name && view.getId() != f1.user_avatar) {
                if (view.getId() == f1.thread_info_commont_container) {
                    c.a.t0.d1.v2.a.e(d2Var, 5, this.f17241b.f3303i, this.f17241b.D, this.f17241b.a0());
                    if (this.f17241b.n != null && this.f17241b.n.getForum() != null) {
                        c.a.t0.d1.v2.a.c(d2Var, this.f17241b.n.getForum().getId());
                    }
                } else if (view.getId() == f1.share_num_container) {
                    c.a.t0.d1.v2.a.e(d2Var, 14, this.f17241b.f3303i, this.f17241b.D, this.f17241b.a0());
                } else if (view.getId() == f1.img_agree) {
                    c.a.t0.d1.v2.a.e(d2Var, 12, this.f17241b.f3303i, this.f17241b.D, this.f17241b.a0());
                } else if (view.getId() == f1.img_disagree) {
                    c.a.t0.d1.v2.a.e(d2Var, 13, this.f17241b.f3303i, this.f17241b.D, this.f17241b.a0());
                } else {
                    if (view instanceof ThreadGodReplyLayout) {
                        c.a.t0.d1.v2.a.e(d2Var, 15, this.f17241b.f3303i, this.f17241b.D, this.f17241b.a0());
                    } else {
                        c.a.t0.d1.v2.a.e(d2Var, 1, this.f17241b.f3303i, this.f17241b.D, this.f17241b.a0());
                    }
                    if (this.f17241b.n != null && this.f17241b.n.getForum() != null) {
                        c.a.t0.d1.v2.a.c(d2Var, this.f17241b.n.getForum().getId());
                    }
                }
            } else {
                c.a.t0.d1.v2.a.e(d2Var, 2, this.f17241b.f3303i, this.f17241b.D, this.f17241b.a0());
            }
            if (view.getId() == f1.user_name || view.getId() == f1.user_avatar) {
                c.a.t0.d1.v2.c.k().h(this.f17241b.D, d2Var, 2);
            } else if (view.getId() != f1.card_home_page_normal_thread_user_icon) {
                c.a.t0.d1.v2.c.k().h(this.f17241b.D, d2Var, 1);
            } else {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
            if (view.getId() != f1.user_name && view.getId() != f1.user_avatar) {
                if (view instanceof OriginalThreadCardView) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                    statisticItem.param("obj_type", "3");
                    statisticItem.param("tid", d2Var.v1());
                    TiebaStatic.log(statisticItem);
                    return;
                }
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
            statisticItem2.param("obj_type", "1");
            statisticItem2.param("tid", d2Var.v1());
            TiebaStatic.log(statisticItem2);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onCheckedChanged(x0 x0Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, x0Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, x0 x0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, x0Var) == null) || arrayList == null || x0Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                sb.append(arrayList.get(i2) + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", x0Var.c()).param("tid", x0Var.f()).param("nid", x0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", x0Var.l).param("weight", x0Var.f13849k).param("ab_tag", x0Var.p).param("extra", x0Var.m).param("card_type", x0Var.o).param(TiebaStatic.Params.OBJ_FLOOR, x0Var.q));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(x0 x0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x0Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", x0Var.c()).param("tid", x0Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
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
    public class d implements c.a.d.n.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ x f17242e;

        public d(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17242e = xVar;
        }

        @Override // c.a.d.n.e.w
        public void b(View view, c.a.d.n.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d2 d2Var = ((c2) nVar).w;
                d2Var.objType = 1;
                if (this.f17242e.E != null) {
                    this.f17242e.E.a(threadCardViewHolder.getView(), d2Var);
                }
                ThreadCardUtils.jumpToPB((c.a.s0.s.q.a) d2Var, view.getContext(), this.f17242e.C, false);
                threadCardViewHolder.getCardView().o(new a.C0186a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.B = true;
        this.C = 3;
        this.D = new c.a.t0.d1.v2.b();
        this.E = new a(this);
        this.F = new b(this);
        this.x = tbPageContext;
        this.f3303i = bdUniqueId2;
    }

    public final void D0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) {
            if (this.y == null) {
                this.y = new HashSet<>();
            }
            c.a.t0.d1.v2.c.k().d(d2Var, this.y);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: E0 */
    public ThreadCardViewHolder<d2> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.x.getPageActivity());
            c.a.l.d dVar = new c.a.l.d(this.x.getPageActivity());
            dVar.a(4280);
            dVar.s(this.f3303i);
            dVar.r(new c(this));
            bVar.o(dVar);
            q0 q0Var = new q0(this.x.getPageActivity());
            bVar.n(q0Var);
            if (this.C == 502) {
                q0Var.s(false);
            } else {
                q0Var.s(true);
            }
            q0Var.t(3);
            c.a.l.n nVar = new c.a.l.n(this.x.getPageActivity());
            nVar.w(this.B);
            nVar.v("frs");
            bVar.h(nVar);
            n0 n0Var = new n0(this.x.getPageActivity());
            c.a.s0.s.q.f fVar = new c.a.s0.s.q.f();
            if (100 == a0().tabType) {
                fVar.f13685b = 25;
                n0Var.v(19);
            } else {
                fVar.f13685b = 2;
                n0Var.v(2);
            }
            fVar.f13691h = 2;
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !c.a.d.f.p.m.isEmpty(this.n.getForum().getId())) {
                fVar.f13693j = this.n.getForum().getId();
            }
            n0Var.u(fVar);
            n0Var.z(3);
            n0Var.w(2);
            n0Var.a(16);
            bVar.m(n0Var);
            bVar.l().g(c.a.d.f.p.n.f(this.f3299e, d1.tbds28));
            l0 i2 = bVar.i();
            i2.r(2);
            ThreadCardViewHolder<d2> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
            threadCardViewHolder.setPageId(this.f3303i);
            V(new d(this));
            threadCardViewHolder.showMultiDelDecorItem();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.d1.k, c.a.d.n.e.a
    /* renamed from: F0 */
    public View S(int i2, View view, ViewGroup viewGroup, c2 c2Var, ThreadCardViewHolder<d2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view, viewGroup, c2Var, threadCardViewHolder})) == null) {
            if (c2Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            if (threadCardViewHolder.getCardView() instanceof c.a.t0.t.e) {
                threadCardViewHolder.getCardView().d(this.z);
            }
            super.S(i2, view, viewGroup, c2Var, threadCardViewHolder);
            c.a.t0.d1.j.i(threadCardViewHolder.getCardView().f(), this.n);
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
                c2Var.w.A4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
            }
            boolean z = (c2Var.w.J() == null || c2Var.w.J().getUserId() == null || !c2Var.w.J().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (c2Var.w.A2() && c2Var.w.T() != null && !z) {
                threadCardViewHolder.showNEGFeedBackView(true).t(this.F);
            }
            threadCardViewHolder.showThemeAndStarDecorItem();
            if (threadCardViewHolder.getCardView().f() != null) {
                threadCardViewHolder.getCardView().f().a(32);
            }
            threadCardViewHolder.onBindDataToView(c2Var.w);
            threadCardViewHolder.getCardView().onChangeSkinType(this.x, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.E);
            if (this.D != null) {
                FrsViewData frsViewData2 = this.n;
                c2Var.w.U1 = (c2Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            c.a.t0.d1.v2.c.k().c(this.D, c2Var.w);
            D0(c2Var.w);
            c2Var.w.S4();
            c.a.t0.d1.v2.a.m(c2Var.w, this.f3303i, this.D, a0());
            FrsViewData frsViewData3 = this.n;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                c.a.t0.d1.v2.a.l(c2Var.w, this.n.getForum().getId());
            }
            d2 d2Var = c2Var.w;
            if (d2Var != null) {
                d2Var.S4();
            }
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
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
            this.z = str;
        }
    }

    @Override // c.a.t0.d1.v2.d
    public c.a.t0.d1.v2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.D : (c.a.t0.d1.v2.b) invokeV.objValue;
    }

    @Override // c.a.t0.g0.b0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.C = i2;
        }
    }

    @Override // c.a.t0.d1.k
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.A = str;
        }
    }

    @Override // c.a.t0.d1.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.B = z;
        }
    }
}
