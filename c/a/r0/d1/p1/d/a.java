package c.a.r0.d1.p1.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.w0.a;
import c.a.q0.r.r.e2;
import c.a.q0.r.r.x0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends c.a.r0.d1.k<e2, ThreadCardViewHolder<e2>> implements c.a.r0.f0.z, c.a.r0.d1.o2.d, c.a.r0.t.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NEGFeedBackView.b A;
    public int x;
    public String y;
    public c.a.r0.f0.b0<e2> z;

    /* renamed from: c.a.r0.d1.p1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1019a extends c.a.r0.f0.b0<e2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f15942b;

        public C1019a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15942b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.f0.b0
        /* renamed from: d */
        public void a(View view, e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, e2Var) == null) {
                c.a.r0.f0.u.b().d(true);
                c.a.r0.t.d.c().h("page_recommend", "show_");
                if (view == null || e2Var == null || StringUtils.isNull(e2Var.w1())) {
                    return;
                }
                if (view.getId() == R.id.thread_card_root) {
                    c.a.r0.d1.o2.c.k().h(c.a.r0.d1.o2.d.p0, e2Var, 13);
                }
                if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                    if (view instanceof ThreadGodReplyLayout) {
                        c.a.r0.d1.o2.a.e(e2Var, 15, this.f15942b.f3080i, c.a.r0.d1.o2.d.p0, this.f15942b.a0());
                        if (this.f15942b.n == null || this.f15942b.n.getForum() == null) {
                            return;
                        }
                        c.a.r0.d1.o2.a.c(e2Var, this.f15942b.n.getForum().getId());
                        return;
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        c.a.r0.d1.o2.a.e(e2Var, 5, this.f15942b.f3080i, c.a.r0.d1.o2.d.p0, this.f15942b.a0());
                        if (this.f15942b.n == null || this.f15942b.n.getForum() == null) {
                            return;
                        }
                        c.a.r0.d1.o2.a.c(e2Var, this.f15942b.n.getForum().getId());
                        return;
                    } else if (view.getId() == R.id.share_num_container) {
                        c.a.r0.d1.o2.a.e(e2Var, 14, this.f15942b.f3080i, c.a.r0.d1.o2.d.p0, this.f15942b.a0());
                        return;
                    } else if (view.getId() == R.id.img_agree) {
                        c.a.r0.d1.o2.a.e(e2Var, 12, this.f15942b.f3080i, c.a.r0.d1.o2.d.p0, this.f15942b.a0());
                        return;
                    } else if (view.getId() == R.id.img_disagree) {
                        c.a.r0.d1.o2.a.e(e2Var, 13, this.f15942b.f3080i, c.a.r0.d1.o2.d.p0, this.f15942b.a0());
                        return;
                    } else {
                        c.a.r0.d1.o2.a.e(e2Var, 1, this.f15942b.f3080i, c.a.r0.d1.o2.d.p0, this.f15942b.a0());
                        if (this.f15942b.n == null || this.f15942b.n.getForum() == null) {
                            return;
                        }
                        c.a.r0.d1.o2.a.c(e2Var, this.f15942b.n.getForum().getId());
                        return;
                    }
                }
                c.a.r0.d1.o2.a.e(e2Var, 2, this.f15942b.f3080i, c.a.r0.d1.o2.d.p0, this.f15942b.a0());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
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

    /* loaded from: classes2.dex */
    public class c implements c.a.d.o.e.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15943e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15943e = aVar;
        }

        @Override // c.a.d.o.e.v
        public void b(View view, c.a.d.o.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                this.f15943e.D0(view, nVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.x = 3;
        this.z = new C1019a(this);
        this.A = new b(this);
        this.o = tbPageContext;
    }

    public final void D0(View view, c.a.d.o.e.n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view, nVar) == null) && (nVar instanceof e2) && (view.getTag() instanceof ThreadCardViewHolder)) {
            e2 e2Var = (e2) nVar;
            e2Var.objType = 1;
            ThreadCardUtils.jumpToPB((c.a.q0.r.r.a) e2Var, view.getContext(), 3, false);
            ((ThreadCardViewHolder) view.getTag()).getCardView().o(new a.C0203a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: E0 */
    public ThreadCardViewHolder<e2> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity());
            c.a.l.d dVar = new c.a.l.d(this.o.getPageActivity());
            dVar.s(this.f3080i);
            dVar.u(this.o);
            bVar.o(dVar);
            bVar.n(new c.a.l.b(this.o.getPageActivity()));
            n0 n0Var = new n0(this.o.getPageActivity());
            c.a.q0.r.r.f fVar = new c.a.q0.r.r.f();
            if (100 == a0().tabType) {
                fVar.f13257b = 25;
                n0Var.v(19);
                n0Var.z(14);
            } else {
                fVar.f13257b = 2;
                n0Var.v(2);
                n0Var.z(1);
            }
            fVar.f13263h = 2;
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !c.a.d.f.p.m.isEmpty(this.n.getForum().getId())) {
                fVar.f13265j = this.n.getForum().getId();
            }
            n0Var.u(fVar);
            n0Var.w(3);
            bVar.m(n0Var);
            l0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.q);
            k.r(3);
            ThreadCardViewHolder<e2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.f3080i);
            V(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.d1.k, c.a.d.o.e.a
    /* renamed from: F0 */
    public View S(int i2, View view, ViewGroup viewGroup, e2 e2Var, ThreadCardViewHolder<e2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view, viewGroup, e2Var, threadCardViewHolder})) == null) {
            super.S(i2, view, viewGroup, e2Var, threadCardViewHolder);
            if (e2Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            c.a.r0.d1.o2.c.k().c(c.a.r0.d1.o2.d.p0, e2Var);
            threadCardViewHolder.getCardView().d(this.y);
            threadCardViewHolder.getCardView().q(i2);
            if (this.x == 1) {
                threadCardViewHolder.showNEGFeedBackView(true).t(this.A);
            }
            threadCardViewHolder.showUnfollowedDecorItemIfNeed(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.onBindDataToView(e2Var);
            threadCardViewHolder.getCardView().p(this.z);
            threadCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.r0.f0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // c.a.r0.t.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.y = str;
        }
    }

    @Override // c.a.r0.d1.o2.d
    public c.a.r0.d1.o2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? c.a.r0.d1.o2.d.p0 : (c.a.r0.d1.o2.b) invokeV.objValue;
    }

    @Override // c.a.r0.f0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.x = i2;
        }
    }

    @Override // c.a.r0.d1.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }
}
