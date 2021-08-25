package c.a.q0.v0.m1.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.v0.a;
import c.a.p0.s.q.b2;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.x0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class j extends c.a.q0.v0.k<b2, ThreadCardViewHolder<c2>> implements c.a.q0.a0.z, c.a.q0.v0.j2.d, c.a.q0.o.f, c.a.q0.a0.a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public c.a.q0.a0.b0<c2> B;
    public NEGFeedBackView.b C;
    public boolean x;
    public String y;
    public String z;

    /* loaded from: classes4.dex */
    public class a extends c.a.q0.a0.b0<c2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f26532b;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26532b = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, c2 c2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, c2Var) == null) || view == null || c2Var == null) {
                return;
            }
            if (this.f26532b.u != null) {
                this.f26532b.u.b(view, c2Var, this.f26532b.K());
            }
            if ("c13010".equals(this.f26532b.y)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", c2Var.T()).param("tid", c2Var.q1()));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    c.a.q0.v0.j2.a.e(c2Var, 5, this.f26532b.f2970i, c.a.q0.v0.j2.d.h0, this.f26532b.i0());
                    c.a.q0.v0.m2.l.g(c2Var, this.f26532b.n, 1);
                } else if (view.getId() == R.id.share_num_container) {
                    c.a.q0.v0.j2.a.e(c2Var, 14, this.f26532b.f2970i, c.a.q0.v0.j2.d.h0, this.f26532b.i0());
                } else if (view.getId() == R.id.img_agree) {
                    c.a.q0.v0.j2.a.e(c2Var, 12, this.f26532b.f2970i, c.a.q0.v0.j2.d.h0, this.f26532b.i0());
                } else if (view.getId() == R.id.img_disagree) {
                    c.a.q0.v0.j2.a.e(c2Var, 13, this.f26532b.f2970i, c.a.q0.v0.j2.d.h0, this.f26532b.i0());
                } else if (view instanceof TbImageView) {
                    if (this.f26532b.B.f15237a instanceof Boolean) {
                        if (((Boolean) this.f26532b.B.f15237a).booleanValue()) {
                            c.a.q0.v0.j2.a.e(c2Var, 1, this.f26532b.f2970i, c.a.q0.v0.j2.d.h0, this.f26532b.i0());
                        } else {
                            c.a.q0.v0.j2.a.e(c2Var, 3, this.f26532b.f2970i, c.a.q0.v0.j2.d.h0, this.f26532b.i0());
                        }
                    }
                    c.a.q0.v0.m2.l.g(c2Var, this.f26532b.n, 2);
                } else if (view instanceof ThreadGodReplyLayout) {
                    c.a.q0.v0.j2.a.e(c2Var, 15, this.f26532b.f2970i, c.a.q0.v0.j2.d.h0, this.f26532b.i0());
                    c.a.q0.v0.m2.l.g(c2Var, this.f26532b.n, 1);
                } else {
                    c.a.q0.v0.j2.a.e(c2Var, 1, this.f26532b.f2970i, c.a.q0.v0.j2.d.h0, this.f26532b.i0());
                    c.a.q0.v0.m2.l.g(c2Var, this.f26532b.n, 1);
                }
            } else {
                c.a.q0.v0.j2.a.e(c2Var, 2, this.f26532b.f2970i, c.a.q0.v0.j2.d.h0, this.f26532b.i0());
            }
            if (view.getId() == R.id.thread_card_root && c2Var.A2()) {
                this.f26532b.P0(c2Var);
            } else if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.card_divider_tv) {
                    c.a.q0.v0.m2.l.a(c.a.q0.v0.j2.d.h0, c2Var.getRecomReason());
                } else if (view instanceof TbImageView) {
                    if (this.f26532b.B.f15237a instanceof Boolean) {
                        if (((Boolean) this.f26532b.B.f15237a).booleanValue()) {
                            c.a.q0.v0.j2.c.j().g(c.a.q0.v0.j2.d.h0, c2Var, 1);
                        } else {
                            c.a.q0.v0.j2.c.j().g(c.a.q0.v0.j2.d.h0, c2Var, 3);
                        }
                    }
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view.getId() == R.id.thread_card_voice) {
                    c.a.q0.v0.j2.c.j().g(c.a.q0.v0.j2.d.h0, c2Var, 5);
                } else if (view instanceof ThreadGodReplyLayout) {
                    int i2 = 6;
                    if (c2Var.t1() != null && c2Var.t1().K() != null && c2Var.t1().K().y() != null && c2Var.t1().K().y().size() > 0) {
                        i2 = c2Var.t1().N ? 9 : 8;
                    }
                    c.a.q0.v0.j2.c.j().g(c.a.q0.v0.j2.d.h0, c2Var, i2);
                } else {
                    c.a.q0.v0.j2.c.j().g(c.a.q0.v0.j2.d.h0, c2Var, 1);
                }
            } else {
                c.a.q0.v0.j2.c.j().g(c.a.q0.v0.j2.d.h0, c2Var, 2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f26533e;

        public b(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26533e = jVar;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, c.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof b2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                c2 c2Var = ((b2) nVar).w;
                c2Var.objType = 1;
                if (this.f26533e.B != null) {
                    this.f26533e.B.a(threadCardViewHolder.getView(), c2Var);
                }
                ThreadCardUtils.jumpToPB((c.a.p0.s.q.a) c2Var, view.getContext(), this.f26533e.A, false, c.a.l.e.a((c.a.e.l.e.s) viewGroup, view, i2));
                threadCardViewHolder.getCardView().o(new a.C0096a(1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f26534a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f26535b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f26536c;

        public c(j jVar, ViewGroup viewGroup, View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, viewGroup, view, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26534a = viewGroup;
            this.f26535b = view;
            this.f26536c = i2;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(c.a.l.e.a((c.a.e.l.e.s) this.f26534a, this.f26535b, this.f26536c));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.x = false;
        this.A = 3;
        this.B = new a(this);
        this.C = new d(this);
        this.o = tbPageContext;
        this.f2970i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: N0 */
    public ThreadCardViewHolder<c2> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity(), false);
            n0 n0Var = new n0(this.o.getPageActivity());
            c.a.p0.s.q.f fVar = new c.a.p0.s.q.f();
            fVar.f14219b = this.x ? 10 : 2;
            fVar.f14225h = 2;
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !c.a.e.e.p.k.isEmpty(this.n.getForum().getId())) {
                fVar.f14227j = this.n.getForum().getId();
            }
            n0Var.u(fVar);
            n0Var.v(2);
            n0Var.A(FrsFragment.STAR_FRS);
            n0Var.z(1);
            n0Var.w(3);
            n0Var.a(48);
            bVar.m(n0Var);
            l0 k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.q);
            k.r(3);
            ThreadCardViewHolder<c2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.f2970i);
            threadCardViewHolder.showMultiDelDecorItem(true);
            threadCardViewHolder.setDelDecorWeightSum(4, bVar.l());
            d0(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.v0.k, c.a.e.l.e.a
    /* renamed from: O0 */
    public View a0(int i2, View view, ViewGroup viewGroup, b2 b2Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view, viewGroup, b2Var, threadCardViewHolder})) == null) {
            super.a0(i2, view, viewGroup, b2Var, threadCardViewHolder);
            if (b2Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            threadCardViewHolder.getCardView().setPage(this.z);
            threadCardViewHolder.getCardView().q(i2);
            c.a.q0.v0.j.i(threadCardViewHolder.getCardView().e(), this.n);
            if (b2Var.w.getType() == c2.M3) {
                threadCardViewHolder.getCardView().e().a(128);
            } else {
                threadCardViewHolder.getCardView().e().b(128);
            }
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
                b2Var.w.m4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
            }
            threadCardViewHolder.showNEGFeedBackViewIfNeed(false, Align.ALIGN_RIGHT_BOTTOM, this.C);
            if (threadCardViewHolder.getCardView().e() instanceof n0) {
                ((n0) threadCardViewHolder.getCardView().e()).y(new c(this, viewGroup, view, i2));
            }
            threadCardViewHolder.onBindDataToView(b2Var.w);
            threadCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.B);
            b2Var.w.C4();
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void P0(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c2Var) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", c2Var.f0()).param("obj_locate", j0() ? 2 : 1).param("obj_id", c2Var.j1() == null ? -1L : c2Var.j1().live_id).param("obj_type", 1));
        }
    }

    @Override // c.a.q0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // c.a.q0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.z = str;
        }
    }

    @Override // c.a.q0.v0.j2.d
    public c.a.q0.v0.j2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? c.a.q0.v0.j2.d.h0 : (c.a.q0.v0.j2.b) invokeV.objValue;
    }

    @Override // c.a.q0.a0.a0
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.x = z;
        }
    }

    @Override // c.a.q0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.A = i2;
        }
    }

    @Override // c.a.q0.v0.k, c.a.q0.a0.y
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.y = str;
        }
    }
}
