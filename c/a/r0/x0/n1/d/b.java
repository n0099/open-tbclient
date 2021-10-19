package c.a.r0.x0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import c.a.l.a;
import c.a.l.d;
import c.a.l.g0;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.o0;
import c.a.l.v0.a;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.x0;
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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class b extends c.a.r0.x0.k<c2, ThreadCardViewHolder<d2>> implements c.a.r0.b0.a0, c.a.r0.x0.k2.d, c.a.r0.p.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public boolean B;
    public int C;
    public c.a.r0.x0.k2.b D;
    public c.a.r0.b0.c0<d2> E;
    public NEGFeedBackView.b F;
    public TbPageContext<?> x;
    public HashSet<String> y;
    public String z;

    /* loaded from: classes4.dex */
    public class a extends c.a.r0.b0.c0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f27355b;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27355b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) || view == null || d2Var == null) {
                return;
            }
            if ("c13010".equals(this.f27355b.A)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 3).param("fid", d2Var.T()).param("tid", d2Var.s1()));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view instanceof ThreadGodReplyLayout) {
                    c.a.r0.x0.k2.a.e(d2Var, 15, this.f27355b.f2962i, this.f27355b.D, this.f27355b.i0());
                    if (this.f27355b.n != null && this.f27355b.n.getForum() != null) {
                        c.a.r0.x0.k2.a.c(d2Var, this.f27355b.n.getForum().getId());
                    }
                } else if (view.getId() == R.id.thread_info_commont_container) {
                    c.a.r0.x0.k2.a.e(d2Var, 5, this.f27355b.f2962i, this.f27355b.D, this.f27355b.i0());
                    if (this.f27355b.n != null && this.f27355b.n.getForum() != null) {
                        c.a.r0.x0.k2.a.c(d2Var, this.f27355b.n.getForum().getId());
                    }
                } else if (view.getId() == R.id.share_num_container) {
                    c.a.r0.x0.k2.a.e(d2Var, 14, this.f27355b.f2962i, this.f27355b.D, this.f27355b.i0());
                } else if (view.getId() == R.id.img_agree) {
                    c.a.r0.x0.k2.a.e(d2Var, 12, this.f27355b.f2962i, this.f27355b.D, this.f27355b.i0());
                } else if (view.getId() == R.id.img_disagree) {
                    c.a.r0.x0.k2.a.e(d2Var, 13, this.f27355b.f2962i, this.f27355b.D, this.f27355b.i0());
                } else {
                    c.a.r0.x0.k2.a.e(d2Var, 1, this.f27355b.f2962i, this.f27355b.D, this.f27355b.i0());
                    if (this.f27355b.n != null && this.f27355b.n.getForum() != null) {
                        c.a.r0.x0.k2.a.c(d2Var, this.f27355b.n.getForum().getId());
                    }
                }
            } else {
                c.a.r0.x0.k2.a.e(d2Var, 2, this.f27355b.f2962i, this.f27355b.D, this.f27355b.i0());
            }
            if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                c.a.r0.x0.k2.c.j().g(this.f27355b.D, d2Var, 2);
            } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                c.a.r0.x0.k2.c.j().g(this.f27355b.D, d2Var, 1);
            } else {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view instanceof OriginalThreadCardView) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                    statisticItem.param("obj_type", "3");
                    statisticItem.param("tid", d2Var.s1());
                    TiebaStatic.log(statisticItem);
                    return;
                }
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
            statisticItem2.param("obj_type", "1");
            statisticItem2.param("tid", d2Var.s1());
            TiebaStatic.log(statisticItem2);
        }
    }

    /* renamed from: c.a.r0.x0.n1.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1282b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1282b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
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
            TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", x0Var.c()).param("tid", x0Var.f()).param("nid", x0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", x0Var.l).param("weight", x0Var.k).param("ab_tag", x0Var.p).param("extra", x0Var.m).param("card_type", x0Var.o).param(TiebaStatic.Params.OBJ_FLOOR, x0Var.q));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(x0 x0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x0Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", x0Var.c()).param("tid", x0Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
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
        public void a(c.a.q0.s.q.a aVar, View view) {
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
    public class d implements a.InterfaceC0093a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27356a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27356a = bVar;
        }

        @Override // c.a.l.a.InterfaceC0093a
        public void a(c.a.q0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().y1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.getThreadData().y1, this.f27356a.f2958e, 3);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.InterfaceC0093a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27357a;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27357a = bVar;
        }

        @Override // c.a.l.a.InterfaceC0093a
        public void a(c.a.q0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().y1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.getThreadData().y1, this.f27357a.f2958e, 3);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements c.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f27358e;

        public f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27358e = bVar;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, c.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d2 d2Var = ((c2) nVar).w;
                d2Var.objType = 1;
                if (this.f27358e.E != null) {
                    this.f27358e.E.a(threadCardViewHolder.getView(), d2Var);
                }
                ThreadCardUtils.jumpToPB((c.a.q0.s.q.a) d2Var, view.getContext(), this.f27358e.C, false);
                threadCardViewHolder.getCardView().o(new a.C0095a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.D = new c.a.r0.x0.k2.b();
        this.E = new a(this);
        this.F = new C1282b(this);
        this.x = tbPageContext;
        this.f2962i = bdUniqueId2;
    }

    public final void Q0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) {
            if (this.y == null) {
                this.y = new HashSet<>();
            }
            c.a.r0.x0.k2.c.j().d(d2Var, this.y);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: R0 */
    public ThreadCardViewHolder<d2> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.x.getPageActivity());
            c.a.l.d dVar = new c.a.l.d(this.x.getPageActivity());
            dVar.a(4280);
            dVar.s(this.f2962i);
            dVar.r(new c(this));
            bVar.o(dVar);
            g0 g0Var = new g0(this.x);
            g0Var.m(Boolean.FALSE);
            g0Var.u("frs");
            if (this.C == 502) {
                g0Var.w(false);
            } else {
                g0Var.w(true);
            }
            bVar.l().g(c.a.e.e.p.l.g(this.f2958e, R.dimen.tbds38));
            bVar.n(g0Var);
            g0 g0Var2 = new g0(this.x);
            g0Var2.m(Boolean.TRUE);
            g0Var2.u("frs");
            if (this.C == 502) {
                g0Var2.w(false);
            } else {
                g0Var2.w(true);
            }
            g0Var2.x(c.a.q0.b.g.b.b(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), c.a.q0.b.g.b.b(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
            g0Var2.v(new d(this));
            bVar.h(g0Var2);
            o0 o0Var = new o0(this.x.getPageActivity());
            o0Var.m(Boolean.TRUE);
            o0Var.t(new e(this));
            bVar.h(o0Var);
            c.a.l.n nVar = new c.a.l.n(this.x.getPageActivity());
            nVar.w(this.B);
            nVar.v("frs");
            bVar.h(nVar);
            n0 n0Var = new n0(this.x.getPageActivity());
            c.a.q0.s.q.f fVar = new c.a.q0.s.q.f();
            if (100 == i0().tabType) {
                fVar.f14190b = 25;
                n0Var.v(19);
                n0Var.v(14);
            } else {
                fVar.f14190b = 2;
                n0Var.v(2);
                n0Var.z(1);
            }
            fVar.f14196h = 2;
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !c.a.e.e.p.k.isEmpty(this.n.getForum().getId())) {
                fVar.f14198j = this.n.getForum().getId();
            }
            n0Var.u(fVar);
            n0Var.w(3);
            n0Var.a(16);
            bVar.m(n0Var);
            l0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.q);
            k.r(3);
            ThreadCardViewHolder<d2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.f2962i);
            d0(new f(this));
            threadCardViewHolder.showMultiDelDecorItem();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.x0.k, c.a.e.l.e.a
    /* renamed from: S0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c2 c2Var, ThreadCardViewHolder<d2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view, viewGroup, c2Var, threadCardViewHolder})) == null) {
            if (c2Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            if (threadCardViewHolder.getCardView() instanceof c.a.r0.p.e) {
                threadCardViewHolder.getCardView().setPage(this.z);
            }
            threadCardViewHolder.getCardView().q(i2);
            super.a0(i2, view, viewGroup, c2Var, threadCardViewHolder);
            c.a.r0.x0.j.i(threadCardViewHolder.getCardView().e(), this.n);
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
                c2Var.w.v4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
            }
            boolean z = (c2Var.w.J() == null || c2Var.w.J().getUserId() == null || !c2Var.w.J().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (c2Var.w.x2() && c2Var.w.S() != null && !z) {
                threadCardViewHolder.showNEGFeedBackView(true).t(this.F);
            }
            threadCardViewHolder.showThemeAndStarDecorItem();
            if (threadCardViewHolder.getCardView().e() != null) {
                threadCardViewHolder.getCardView().e().a(32);
            }
            threadCardViewHolder.onBindDataToView(c2Var.w);
            threadCardViewHolder.getCardView().onChangeSkinType(this.x, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.E);
            if (this.D != null) {
                FrsViewData frsViewData2 = this.n;
                c2Var.w.T1 = (c2Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            c.a.r0.x0.k2.c.j().c(this.D, c2Var.w);
            Q0(c2Var.w);
            c2Var.w.M4();
            c.a.r0.x0.k2.a.m(c2Var.w, this.f2962i, this.D, i0());
            FrsViewData frsViewData3 = this.n;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                c.a.r0.x0.k2.a.l(c2Var.w, this.n.getForum().getId());
            }
            d2 d2Var = c2Var.w;
            if (d2Var != null) {
                d2Var.M4();
            }
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void T0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
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
            this.z = str;
        }
    }

    @Override // c.a.r0.x0.k2.d
    public c.a.r0.x0.k2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.D : (c.a.r0.x0.k2.b) invokeV.objValue;
    }

    @Override // c.a.r0.b0.a0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.C = i2;
        }
    }

    @Override // c.a.r0.x0.k, c.a.r0.b0.z
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.A = str;
        }
    }

    @Override // c.a.r0.x0.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.B = z;
        }
    }
}
