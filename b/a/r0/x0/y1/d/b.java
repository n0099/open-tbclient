package b.a.r0.x0.y1.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import b.a.l.a;
import b.a.l.d;
import b.a.l.g0;
import b.a.l.l0;
import b.a.l.n0;
import b.a.l.o0;
import b.a.l.w0.a;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.x0;
import b.a.r0.x0.d1;
import b.a.r0.x0.f1;
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
/* loaded from: classes6.dex */
public class b extends b.a.r0.x0.k<c2, ThreadCardViewHolder<d2>> implements b.a.r0.b0.b0, b.a.r0.x0.v2.d, b.a.r0.p.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public boolean B;
    public int C;
    public b.a.r0.x0.v2.b D;
    public b.a.r0.b0.d0<d2> E;
    public NEGFeedBackView.b F;
    public TbPageContext<?> x;
    public HashSet<String> y;
    public String z;

    /* loaded from: classes6.dex */
    public class a extends b.a.r0.b0.d0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f28201b;

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
            this.f28201b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.d0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) || view == null || d2Var == null) {
                return;
            }
            if ("c13010".equals(this.f28201b.A)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 3).param("fid", d2Var.T()).param("tid", d2Var.t1()));
            }
            if (view.getId() != f1.user_name && view.getId() != f1.user_avatar) {
                if (view instanceof ThreadGodReplyLayout) {
                    b.a.r0.x0.v2.a.e(d2Var, 15, this.f28201b.f2425i, this.f28201b.D, this.f28201b.h0());
                    if (this.f28201b.n != null && this.f28201b.n.getForum() != null) {
                        b.a.r0.x0.v2.a.c(d2Var, this.f28201b.n.getForum().getId());
                    }
                } else if (view.getId() == f1.thread_info_commont_container) {
                    b.a.r0.x0.v2.a.e(d2Var, 5, this.f28201b.f2425i, this.f28201b.D, this.f28201b.h0());
                    if (this.f28201b.n != null && this.f28201b.n.getForum() != null) {
                        b.a.r0.x0.v2.a.c(d2Var, this.f28201b.n.getForum().getId());
                    }
                } else if (view.getId() == f1.share_num_container) {
                    b.a.r0.x0.v2.a.e(d2Var, 14, this.f28201b.f2425i, this.f28201b.D, this.f28201b.h0());
                } else if (view.getId() == f1.img_agree) {
                    b.a.r0.x0.v2.a.e(d2Var, 12, this.f28201b.f2425i, this.f28201b.D, this.f28201b.h0());
                } else if (view.getId() == f1.img_disagree) {
                    b.a.r0.x0.v2.a.e(d2Var, 13, this.f28201b.f2425i, this.f28201b.D, this.f28201b.h0());
                } else {
                    b.a.r0.x0.v2.a.e(d2Var, 1, this.f28201b.f2425i, this.f28201b.D, this.f28201b.h0());
                    if (this.f28201b.n != null && this.f28201b.n.getForum() != null) {
                        b.a.r0.x0.v2.a.c(d2Var, this.f28201b.n.getForum().getId());
                    }
                }
            } else {
                b.a.r0.x0.v2.a.e(d2Var, 2, this.f28201b.f2425i, this.f28201b.D, this.f28201b.h0());
            }
            if (view.getId() == f1.user_name || view.getId() == f1.user_avatar) {
                b.a.r0.x0.v2.c.j().g(this.f28201b.D, d2Var, 2);
            } else if (view.getId() != f1.card_home_page_normal_thread_user_icon) {
                b.a.r0.x0.v2.c.j().g(this.f28201b.D, d2Var, 1);
            } else {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
            if (view.getId() != f1.user_name && view.getId() != f1.user_avatar) {
                if (view instanceof OriginalThreadCardView) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                    statisticItem.param("obj_type", "3");
                    statisticItem.param("tid", d2Var.t1());
                    TiebaStatic.log(statisticItem);
                    return;
                }
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
            statisticItem2.param("obj_type", "1");
            statisticItem2.param("tid", d2Var.t1());
            TiebaStatic.log(statisticItem2);
        }
    }

    /* renamed from: b.a.r0.x0.y1.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1379b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1379b(b bVar) {
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

    /* loaded from: classes6.dex */
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

        @Override // b.a.l.d.b
        public void a(b.a.q0.s.q.a aVar, View view) {
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

    /* loaded from: classes6.dex */
    public class d implements a.InterfaceC0090a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f28202a;

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
            this.f28202a = bVar;
        }

        @Override // b.a.l.a.InterfaceC0090a
        public void a(b.a.q0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().y1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.getThreadData().y1, this.f28202a.f2421e, 3);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements a.InterfaceC0090a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f28203a;

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
            this.f28203a = bVar;
        }

        @Override // b.a.l.a.InterfaceC0090a
        public void a(b.a.q0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().y1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.getThreadData().y1, this.f28203a.f2421e, 3);
        }
    }

    /* loaded from: classes6.dex */
    public class f implements b.a.e.m.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f28204e;

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
            this.f28204e = bVar;
        }

        @Override // b.a.e.m.e.w
        public void b(View view, b.a.e.m.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof c2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d2 d2Var = ((c2) nVar).w;
                d2Var.objType = 1;
                if (this.f28204e.E != null) {
                    this.f28204e.E.a(threadCardViewHolder.getView(), d2Var);
                }
                ThreadCardUtils.jumpToPB((b.a.q0.s.q.a) d2Var, view.getContext(), this.f28204e.C, false);
                threadCardViewHolder.getCardView().n(new a.C0092a(1));
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
        this.D = new b.a.r0.x0.v2.b();
        this.E = new a(this);
        this.F = new C1379b(this);
        this.x = tbPageContext;
        this.f2425i = bdUniqueId2;
    }

    public final void P0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) {
            if (this.y == null) {
                this.y = new HashSet<>();
            }
            b.a.r0.x0.v2.c.j().d(d2Var, this.y);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: Q0 */
    public ThreadCardViewHolder<d2> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.x.getPageActivity());
            b.a.l.d dVar = new b.a.l.d(this.x.getPageActivity());
            dVar.a(4280);
            dVar.s(this.f2425i);
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
            bVar.l().g(b.a.e.f.p.l.g(this.f2421e, d1.tbds38));
            bVar.n(g0Var);
            g0 g0Var2 = new g0(this.x);
            g0Var2.m(Boolean.TRUE);
            g0Var2.u("frs");
            if (this.C == 502) {
                g0Var2.w(false);
            } else {
                g0Var2.w(true);
            }
            g0Var2.x(b.a.q0.b.g.b.b(), UtilHelper.getDimenPixelSize(d1.M_H_X004), b.a.q0.b.g.b.b(), UtilHelper.getDimenPixelSize(d1.M_H_X004));
            g0Var2.v(new d(this));
            bVar.h(g0Var2);
            o0 o0Var = new o0(this.x.getPageActivity());
            o0Var.m(Boolean.TRUE);
            o0Var.t(new e(this));
            bVar.h(o0Var);
            b.a.l.n nVar = new b.a.l.n(this.x.getPageActivity());
            nVar.w(this.B);
            nVar.v("frs");
            bVar.h(nVar);
            n0 n0Var = new n0(this.x.getPageActivity());
            b.a.q0.s.q.f fVar = new b.a.q0.s.q.f();
            if (100 == h0().tabType) {
                fVar.f14080b = 25;
                n0Var.v(19);
                n0Var.v(14);
            } else {
                fVar.f14080b = 2;
                n0Var.v(2);
                n0Var.z(1);
            }
            fVar.f14086h = 2;
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !b.a.e.f.p.k.isEmpty(this.n.getForum().getId())) {
                fVar.j = this.n.getForum().getId();
            }
            n0Var.u(fVar);
            n0Var.w(3);
            n0Var.a(16);
            bVar.m(n0Var);
            l0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.q);
            k.q(3);
            ThreadCardViewHolder<d2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.f2425i);
            c0(new f(this));
            threadCardViewHolder.showMultiDelDecorItem();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.x0.k, b.a.e.m.e.a
    /* renamed from: R0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c2 c2Var, ThreadCardViewHolder<d2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view, viewGroup, c2Var, threadCardViewHolder})) == null) {
            if (c2Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            if (threadCardViewHolder.getCardView() instanceof b.a.r0.p.e) {
                threadCardViewHolder.getCardView().setPage(this.z);
            }
            threadCardViewHolder.getCardView().p(i2);
            super.Z(i2, view, viewGroup, c2Var, threadCardViewHolder);
            b.a.r0.x0.j.i(threadCardViewHolder.getCardView().e(), this.n);
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
                c2Var.w.y4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
            }
            boolean z = (c2Var.w.J() == null || c2Var.w.J().getUserId() == null || !c2Var.w.J().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (c2Var.w.z2() && c2Var.w.S() != null && !z) {
                threadCardViewHolder.showNEGFeedBackView(true).t(this.F);
            }
            threadCardViewHolder.showThemeAndStarDecorItem();
            if (threadCardViewHolder.getCardView().e() != null) {
                threadCardViewHolder.getCardView().e().a(32);
            }
            threadCardViewHolder.onBindDataToView(c2Var.w);
            threadCardViewHolder.getCardView().onChangeSkinType(this.x, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().o(this.E);
            if (this.D != null) {
                FrsViewData frsViewData2 = this.n;
                c2Var.w.T1 = (c2Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            b.a.r0.x0.v2.c.j().c(this.D, c2Var.w);
            P0(c2Var.w);
            c2Var.w.Q4();
            b.a.r0.x0.v2.a.m(c2Var.w, this.f2425i, this.D, h0());
            FrsViewData frsViewData3 = this.n;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                b.a.r0.x0.v2.a.l(c2Var.w, this.n.getForum().getId());
            }
            d2 d2Var = c2Var.w;
            if (d2Var != null) {
                d2Var.Q4();
            }
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void S0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
        }
    }

    @Override // b.a.r0.b0.b0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // b.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.z = str;
        }
    }

    @Override // b.a.r0.x0.v2.d
    public b.a.r0.x0.v2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.D : (b.a.r0.x0.v2.b) invokeV.objValue;
    }

    @Override // b.a.r0.b0.b0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.C = i2;
        }
    }

    @Override // b.a.r0.x0.k, b.a.r0.b0.a0
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.A = str;
        }
    }

    @Override // b.a.r0.x0.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.B = z;
        }
    }
}
