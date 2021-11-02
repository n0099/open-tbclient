package b.a.r0.x0.x1.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import b.a.l.d;
import b.a.l.l0;
import b.a.l.n0;
import b.a.l.v0.a;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.x0;
import b.a.r0.x0.e1;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class p extends b.a.r0.x0.k<c2, ThreadCardViewHolder<d2>> implements b.a.r0.b0.a0, b.a.r0.x0.u2.d, b.a.r0.p.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public b.a.r0.x0.u2.b B;
    public b.a.r0.b0.c0<d2> C;
    public NEGFeedBackView.b D;
    public TbPageContext<?> x;
    public String y;
    public boolean z;

    /* loaded from: classes5.dex */
    public class a extends b.a.r0.b0.c0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ p f26661b;

        public a(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26661b = pVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) || view == null || d2Var == null) {
                return;
            }
            if (view.getId() != e1.user_name && view.getId() != e1.user_avatar) {
                if (view.getId() == e1.thread_info_commont_container) {
                    b.a.r0.x0.u2.a.e(d2Var, 5, this.f26661b.f2423i, this.f26661b.B, this.f26661b.h0());
                    b.a.r0.x0.x2.l.g(d2Var, this.f26661b.n, 1);
                } else if (view.getId() == e1.share_num_container) {
                    b.a.r0.x0.u2.a.e(d2Var, 14, this.f26661b.f2423i, this.f26661b.B, this.f26661b.h0());
                } else if (view.getId() == e1.img_agree) {
                    b.a.r0.x0.u2.a.e(d2Var, 12, this.f26661b.f2423i, this.f26661b.B, this.f26661b.h0());
                } else if (view.getId() == e1.img_disagree) {
                    b.a.r0.x0.u2.a.e(d2Var, 13, this.f26661b.f2423i, this.f26661b.B, this.f26661b.h0());
                } else if (view instanceof TbImageView) {
                    if (this.f26661b.C.f14741a instanceof Boolean) {
                        if (((Boolean) this.f26661b.C.f14741a).booleanValue()) {
                            b.a.r0.x0.u2.a.e(d2Var, 1, this.f26661b.f2423i, this.f26661b.B, this.f26661b.h0());
                        } else {
                            b.a.r0.x0.u2.a.e(d2Var, 3, this.f26661b.f2423i, this.f26661b.B, this.f26661b.h0());
                        }
                    }
                    b.a.r0.x0.x2.l.g(d2Var, this.f26661b.n, 2);
                } else if (view instanceof ThreadGodReplyLayout) {
                    b.a.r0.x0.u2.a.e(d2Var, 15, this.f26661b.f2423i, this.f26661b.B, this.f26661b.h0());
                    b.a.r0.x0.x2.l.g(d2Var, this.f26661b.n, 1);
                } else {
                    b.a.r0.x0.u2.a.e(d2Var, 1, this.f26661b.f2423i, this.f26661b.B, this.f26661b.h0());
                    b.a.r0.x0.x2.l.g(d2Var, this.f26661b.n, 1);
                }
            } else {
                b.a.r0.x0.u2.a.e(d2Var, 2, this.f26661b.f2423i, this.f26661b.B, this.f26661b.h0());
            }
            if (view.getId() == e1.user_name || view.getId() == e1.user_avatar) {
                b.a.r0.x0.u2.c.j().g(this.f26661b.B, d2Var, 2);
            } else if (view.getId() != e1.card_home_page_normal_thread_user_icon) {
                b.a.r0.x0.u2.c.j().g(this.f26661b.B, d2Var, 7);
            } else {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
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

    /* loaded from: classes5.dex */
    public class c implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
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
            if (view.getId() == e1.user_name) {
                aVar.objType = 3;
            } else if (view.getId() == e1.user_avatar) {
                aVar.objType = 4;
            } else {
                aVar.objType = 1;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements b.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ p f26662e;

        public d(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26662e = pVar;
        }

        @Override // b.a.e.l.e.w
        public void b(View view, b.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof c2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d2 d2Var = ((c2) nVar).w;
                d2Var.objType = 1;
                if (this.f26662e.C != null) {
                    this.f26662e.C.a(threadCardViewHolder.getView(), d2Var);
                }
                ThreadCardUtils.jumpToPB((b.a.q0.s.q.a) d2Var, view.getContext(), this.f26662e.A, false);
                threadCardViewHolder.getCardView().n(new a.C0090a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.z = true;
        this.A = 3;
        this.B = new b.a.r0.x0.u2.b();
        this.C = new a(this);
        this.D = new b(this);
        this.x = tbPageContext;
        this.f2423i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: J0 */
    public ThreadCardViewHolder<d2> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.x.getPageActivity());
            b.a.l.d dVar = new b.a.l.d(this.x.getPageActivity());
            dVar.s(this.f2423i);
            dVar.a(4272);
            dVar.r(new c(this));
            bVar.o(dVar);
            bVar.n(new b.a.l.t(this.x.getPageActivity()));
            b.a.l.n nVar = new b.a.l.n(this.x.getPageActivity());
            nVar.w(this.z);
            nVar.v("frs");
            bVar.h(nVar);
            n0 n0Var = new n0(this.x.getPageActivity());
            b.a.q0.s.q.f fVar = new b.a.q0.s.q.f();
            if (100 == h0().tabType) {
                fVar.f13300b = 25;
                n0Var.v(19);
            } else {
                fVar.f13300b = 2;
                n0Var.v(2);
            }
            fVar.f13306h = 2;
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !b.a.e.e.p.k.isEmpty(this.n.getForum().getId())) {
                fVar.j = this.n.getForum().getId();
            }
            n0Var.u(fVar);
            n0Var.z(this.A);
            n0Var.w(this.A);
            n0Var.a(48);
            bVar.m(n0Var);
            l0 j = bVar.j(BaseCardInfo.SupportType.FULL, viewGroup);
            j.q(this.A);
            ThreadCardViewHolder<d2> threadCardViewHolder = new ThreadCardViewHolder<>(j);
            threadCardViewHolder.setPageId(this.f2423i);
            c0(new d(this));
            threadCardViewHolder.showMultiDelDecorItem();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.x0.k, b.a.e.l.e.a
    /* renamed from: K0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c2 c2Var, ThreadCardViewHolder<d2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view, viewGroup, c2Var, threadCardViewHolder})) == null) {
            if (c2Var == null || threadCardViewHolder == null || threadCardViewHolder.getCardView() == null) {
                return null;
            }
            super.Z(i2, view, viewGroup, c2Var, threadCardViewHolder);
            if (threadCardViewHolder.getCardView() instanceof b.a.r0.p.e) {
                threadCardViewHolder.getCardView().setPage(this.y);
            }
            b.a.r0.x0.j.i(threadCardViewHolder.getCardView().e(), this.n);
            boolean z = (c2Var.w.J() == null || c2Var.w.J().getUserId() == null || !c2Var.w.J().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (c2Var.w.x2() && c2Var.w.S() != null && !z) {
                b.a.l.b0 showNEGFeedBackView = threadCardViewHolder.showNEGFeedBackView(true);
                showNEGFeedBackView.t(this.D);
                showNEGFeedBackView.onBindDataToView(c2Var.w.getNegFeedBackData());
            }
            threadCardViewHolder.showThemeAndStarDecorItem();
            threadCardViewHolder.onBindDataToView(c2Var.w);
            threadCardViewHolder.setOnSubCardClickListener(this.C);
            threadCardViewHolder.getCardView().onChangeSkinType(this.x, TbadkCoreApplication.getInst().getSkinType());
            if (this.B != null) {
                FrsViewData frsViewData = this.n;
                c2Var.w.T1 = (c2Var.position + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            b.a.r0.x0.u2.c.j().c(this.B, c2Var.w);
            b.a.r0.x0.u2.a.m(c2Var.w, this.f2423i, this.B, h0());
            FrsViewData frsViewData2 = this.n;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                b.a.r0.x0.u2.a.l(c2Var.w, this.n.getForum().getId());
            }
            if (c2Var != null) {
                c2Var.w.O4();
            }
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // b.a.r0.b0.a0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // b.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.y = str;
        }
    }

    @Override // b.a.r0.x0.u2.d
    public b.a.r0.x0.u2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.B : (b.a.r0.x0.u2.b) invokeV.objValue;
    }

    @Override // b.a.r0.b0.a0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.A = i2;
        }
    }

    @Override // b.a.r0.x0.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.z = z;
        }
    }
}
