package c.a.q0.v0.m1.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import c.a.l.d;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.v0.a;
import c.a.p0.s.q.b2;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.x0;
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
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class p extends c.a.q0.v0.k<b2, ThreadCardViewHolder<c2>> implements c.a.q0.a0.z, c.a.q0.v0.j2.d, c.a.q0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public c.a.q0.v0.j2.b B;
    public c.a.q0.a0.b0<c2> C;
    public NEGFeedBackView.b D;
    public TbPageContext<?> x;
    public String y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a extends c.a.q0.a0.b0<c2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ p f26547b;

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
            this.f26547b = pVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, c2 c2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, c2Var) == null) || view == null || c2Var == null) {
                return;
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    c.a.q0.v0.j2.a.e(c2Var, 5, this.f26547b.f2970i, this.f26547b.B, this.f26547b.i0());
                    c.a.q0.v0.m2.l.g(c2Var, this.f26547b.n, 1);
                } else if (view.getId() == R.id.share_num_container) {
                    c.a.q0.v0.j2.a.e(c2Var, 14, this.f26547b.f2970i, this.f26547b.B, this.f26547b.i0());
                } else if (view.getId() == R.id.img_agree) {
                    c.a.q0.v0.j2.a.e(c2Var, 12, this.f26547b.f2970i, this.f26547b.B, this.f26547b.i0());
                } else if (view.getId() == R.id.img_disagree) {
                    c.a.q0.v0.j2.a.e(c2Var, 13, this.f26547b.f2970i, this.f26547b.B, this.f26547b.i0());
                } else if (view instanceof TbImageView) {
                    if (this.f26547b.C.f15237a instanceof Boolean) {
                        if (((Boolean) this.f26547b.C.f15237a).booleanValue()) {
                            c.a.q0.v0.j2.a.e(c2Var, 1, this.f26547b.f2970i, this.f26547b.B, this.f26547b.i0());
                        } else {
                            c.a.q0.v0.j2.a.e(c2Var, 3, this.f26547b.f2970i, this.f26547b.B, this.f26547b.i0());
                        }
                    }
                    c.a.q0.v0.m2.l.g(c2Var, this.f26547b.n, 2);
                } else if (view instanceof ThreadGodReplyLayout) {
                    c.a.q0.v0.j2.a.e(c2Var, 15, this.f26547b.f2970i, this.f26547b.B, this.f26547b.i0());
                    c.a.q0.v0.m2.l.g(c2Var, this.f26547b.n, 1);
                } else {
                    c.a.q0.v0.j2.a.e(c2Var, 1, this.f26547b.f2970i, this.f26547b.B, this.f26547b.i0());
                    c.a.q0.v0.m2.l.g(c2Var, this.f26547b.n, 1);
                }
            } else {
                c.a.q0.v0.j2.a.e(c2Var, 2, this.f26547b.f2970i, this.f26547b.B, this.f26547b.i0());
            }
            if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                c.a.q0.v0.j2.c.j().g(this.f26547b.B, c2Var, 2);
            } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                c.a.q0.v0.j2.c.j().g(this.f26547b.B, c2Var, 7);
            } else {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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

        @Override // c.a.l.d.b
        public void a(c.a.p0.s.q.a aVar, View view) {
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
    public class d implements c.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ p f26548e;

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
            this.f26548e = pVar;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, c.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof b2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                c2 c2Var = ((b2) nVar).w;
                c2Var.objType = 1;
                if (this.f26548e.C != null) {
                    this.f26548e.C.a(threadCardViewHolder.getView(), c2Var);
                }
                ThreadCardUtils.jumpToPB((c.a.p0.s.q.a) c2Var, view.getContext(), this.f26548e.A, false);
                threadCardViewHolder.getCardView().o(new a.C0096a(1));
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
        this.B = new c.a.q0.v0.j2.b();
        this.C = new a(this);
        this.D = new b(this);
        this.x = tbPageContext;
        this.f2970i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: K0 */
    public ThreadCardViewHolder<c2> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.x.getPageActivity());
            c.a.l.d dVar = new c.a.l.d(this.x.getPageActivity());
            dVar.s(this.f2970i);
            dVar.a(4272);
            dVar.r(new c(this));
            bVar.o(dVar);
            bVar.n(new c.a.l.t(this.x.getPageActivity()));
            c.a.l.n nVar = new c.a.l.n(this.x.getPageActivity());
            nVar.w(this.z);
            nVar.v("frs");
            bVar.h(nVar);
            n0 n0Var = new n0(this.x.getPageActivity());
            c.a.p0.s.q.f fVar = new c.a.p0.s.q.f();
            fVar.f14219b = 2;
            fVar.f14225h = 2;
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !c.a.e.e.p.k.isEmpty(this.n.getForum().getId())) {
                fVar.f14227j = this.n.getForum().getId();
            }
            n0Var.u(fVar);
            n0Var.v(2);
            n0Var.z(this.A);
            n0Var.w(this.A);
            n0Var.a(48);
            bVar.m(n0Var);
            l0 j2 = bVar.j(BaseCardInfo.SupportType.FULL, viewGroup);
            j2.r(this.A);
            ThreadCardViewHolder<c2> threadCardViewHolder = new ThreadCardViewHolder<>(j2);
            threadCardViewHolder.setPageId(this.f2970i);
            d0(new d(this));
            threadCardViewHolder.showMultiDelDecorItem();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.v0.k, c.a.e.l.e.a
    /* renamed from: L0 */
    public View a0(int i2, View view, ViewGroup viewGroup, b2 b2Var, ThreadCardViewHolder<c2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view, viewGroup, b2Var, threadCardViewHolder})) == null) {
            if (b2Var == null || threadCardViewHolder == null || threadCardViewHolder.getCardView() == null) {
                return null;
            }
            super.a0(i2, view, viewGroup, b2Var, threadCardViewHolder);
            if (threadCardViewHolder.getCardView() instanceof c.a.q0.o.e) {
                threadCardViewHolder.getCardView().setPage(this.y);
            }
            c.a.q0.v0.j.i(threadCardViewHolder.getCardView().e(), this.n);
            boolean z = (b2Var.w.J() == null || b2Var.w.J().getUserId() == null || !b2Var.w.J().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (b2Var.w.t2() && b2Var.w.S() != null && !z) {
                c.a.l.b0 showNEGFeedBackView = threadCardViewHolder.showNEGFeedBackView(true);
                showNEGFeedBackView.t(this.D);
                showNEGFeedBackView.onBindDataToView(b2Var.w.getNegFeedBackData());
            }
            threadCardViewHolder.showThemeAndStarDecorItem();
            threadCardViewHolder.onBindDataToView(b2Var.w);
            threadCardViewHolder.setOnSubCardClickListener(this.C);
            threadCardViewHolder.getCardView().onChangeSkinType(this.x, TbadkCoreApplication.getInst().getSkinType());
            if (this.B != null) {
                FrsViewData frsViewData = this.n;
                b2Var.w.Q1 = (b2Var.position + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            c.a.q0.v0.j2.c.j().c(this.B, b2Var.w);
            c.a.q0.v0.j2.a.m(b2Var.w, this.f2970i, this.B, i0());
            FrsViewData frsViewData2 = this.n;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                c.a.q0.v0.j2.a.l(b2Var.w, this.n.getForum().getId());
            }
            if (b2Var != null) {
                b2Var.w.C4();
            }
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.q0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    @Override // c.a.q0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.y = str;
        }
    }

    @Override // c.a.q0.v0.j2.d
    public c.a.q0.v0.j2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.B : (c.a.q0.v0.j2.b) invokeV.objValue;
    }

    @Override // c.a.q0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.A = i2;
        }
    }

    @Override // c.a.q0.v0.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.z = z;
        }
    }
}
