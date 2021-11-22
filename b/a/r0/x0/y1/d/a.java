package b.a.r0.x0.y1.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import b.a.l.l0;
import b.a.l.n0;
import b.a.l.w0.a;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.x0;
import b.a.r0.x0.f1;
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
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends b.a.r0.x0.k<d2, ThreadCardViewHolder<d2>> implements b.a.r0.b0.b0, b.a.r0.x0.v2.d, b.a.r0.p.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NEGFeedBackView.b A;
    public int x;
    public String y;
    public b.a.r0.b0.d0<d2> z;

    /* renamed from: b.a.r0.x0.y1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1378a extends b.a.r0.b0.d0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f28198b;

        public C1378a(a aVar) {
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
            this.f28198b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.d0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) {
                b.a.r0.b0.v.b().d(true);
                b.a.r0.p.d.c().h("page_recommend", "show_");
                if (view == null || d2Var == null || StringUtils.isNull(d2Var.t1())) {
                    return;
                }
                if (view.getId() == f1.thread_card_root) {
                    b.a.r0.x0.v2.c.j().g(b.a.r0.x0.v2.d.h0, d2Var, 13);
                }
                if (view.getId() != f1.user_name && view.getId() != f1.user_avatar) {
                    if (view instanceof ThreadGodReplyLayout) {
                        b.a.r0.x0.v2.a.e(d2Var, 15, this.f28198b.f2425i, b.a.r0.x0.v2.d.h0, this.f28198b.h0());
                        if (this.f28198b.n == null || this.f28198b.n.getForum() == null) {
                            return;
                        }
                        b.a.r0.x0.v2.a.c(d2Var, this.f28198b.n.getForum().getId());
                        return;
                    } else if (view.getId() == f1.thread_info_commont_container) {
                        b.a.r0.x0.v2.a.e(d2Var, 5, this.f28198b.f2425i, b.a.r0.x0.v2.d.h0, this.f28198b.h0());
                        if (this.f28198b.n == null || this.f28198b.n.getForum() == null) {
                            return;
                        }
                        b.a.r0.x0.v2.a.c(d2Var, this.f28198b.n.getForum().getId());
                        return;
                    } else if (view.getId() == f1.share_num_container) {
                        b.a.r0.x0.v2.a.e(d2Var, 14, this.f28198b.f2425i, b.a.r0.x0.v2.d.h0, this.f28198b.h0());
                        return;
                    } else if (view.getId() == f1.img_agree) {
                        b.a.r0.x0.v2.a.e(d2Var, 12, this.f28198b.f2425i, b.a.r0.x0.v2.d.h0, this.f28198b.h0());
                        return;
                    } else if (view.getId() == f1.img_disagree) {
                        b.a.r0.x0.v2.a.e(d2Var, 13, this.f28198b.f2425i, b.a.r0.x0.v2.d.h0, this.f28198b.h0());
                        return;
                    } else {
                        b.a.r0.x0.v2.a.e(d2Var, 1, this.f28198b.f2425i, b.a.r0.x0.v2.d.h0, this.f28198b.h0());
                        if (this.f28198b.n == null || this.f28198b.n.getForum() == null) {
                            return;
                        }
                        b.a.r0.x0.v2.a.c(d2Var, this.f28198b.n.getForum().getId());
                        return;
                    }
                }
                b.a.r0.x0.v2.a.e(d2Var, 2, this.f28198b.f2425i, b.a.r0.x0.v2.d.h0, this.f28198b.h0());
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class c implements b.a.e.m.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28199e;

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
            this.f28199e = aVar;
        }

        @Override // b.a.e.m.e.w
        public void b(View view, b.a.e.m.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                this.f28199e.K0(view, nVar);
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
        this.z = new C1378a(this);
        this.A = new b(this);
        this.o = tbPageContext;
    }

    public final void K0(View view, b.a.e.m.e.n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view, nVar) == null) && (nVar instanceof d2) && (view.getTag() instanceof ThreadCardViewHolder)) {
            d2 d2Var = (d2) nVar;
            d2Var.objType = 1;
            ThreadCardUtils.jumpToPB((b.a.q0.s.q.a) d2Var, view.getContext(), 3, false);
            ((ThreadCardViewHolder) view.getTag()).getCardView().n(new a.C0092a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: L0 */
    public ThreadCardViewHolder<d2> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity());
            b.a.l.d dVar = new b.a.l.d(this.o.getPageActivity());
            dVar.s(this.f2425i);
            dVar.u(this.o);
            bVar.o(dVar);
            bVar.n(new b.a.l.b(this.o.getPageActivity()));
            n0 n0Var = new n0(this.o.getPageActivity());
            b.a.q0.s.q.f fVar = new b.a.q0.s.q.f();
            if (100 == h0().tabType) {
                fVar.f14080b = 25;
                n0Var.v(19);
                n0Var.z(14);
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
            bVar.m(n0Var);
            l0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.q);
            k.q(3);
            ThreadCardViewHolder<d2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.f2425i);
            c0(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.x0.k, b.a.e.m.e.a
    /* renamed from: M0 */
    public View Z(int i2, View view, ViewGroup viewGroup, d2 d2Var, ThreadCardViewHolder<d2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view, viewGroup, d2Var, threadCardViewHolder})) == null) {
            super.Z(i2, view, viewGroup, d2Var, threadCardViewHolder);
            if (d2Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            b.a.r0.x0.v2.c.j().c(b.a.r0.x0.v2.d.h0, d2Var);
            threadCardViewHolder.getCardView().setPage(this.y);
            threadCardViewHolder.getCardView().p(i2);
            if (this.x == 1) {
                threadCardViewHolder.showNEGFeedBackView(true).t(this.A);
            }
            threadCardViewHolder.showUnfollowedDecorItemIfNeed(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.onBindDataToView(d2Var);
            threadCardViewHolder.getCardView().o(this.z);
            threadCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // b.a.r0.b0.b0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // b.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.y = str;
        }
    }

    @Override // b.a.r0.x0.v2.d
    public b.a.r0.x0.v2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? b.a.r0.x0.v2.d.h0 : (b.a.r0.x0.v2.b) invokeV.objValue;
    }

    @Override // b.a.r0.b0.b0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.x = i2;
        }
    }

    @Override // b.a.r0.x0.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }
}
