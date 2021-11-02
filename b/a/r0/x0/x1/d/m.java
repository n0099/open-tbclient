package b.a.r0.x0.x1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.l.l0;
import b.a.l.v0.a;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.r0.x0.e1;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class m extends b.a.r0.x0.k<c2, ThreadCardViewHolder<d2>> implements b.a.r0.b0.a0, b.a.r0.x0.u2.d, b.a.r0.p.f, b.a.r0.b0.b0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public b.a.r0.b0.c0<d2> B;
    public String x;
    public String y;
    public boolean z;

    /* loaded from: classes5.dex */
    public class a extends b.a.r0.b0.c0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ m f26654b;

        public a(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26654b = mVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) || view == null || d2Var == null) {
                return;
            }
            if (this.f26654b.u != null) {
                this.f26654b.u.b(view, d2Var, this.f26654b.getType());
            }
            if ("c13010".equals(this.f26654b.x)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", d2Var.T()).param("tid", d2Var.s1()));
            }
            if (view.getId() != e1.user_name && view.getId() != e1.user_avatar) {
                if (view.getId() == e1.thread_info_commont_container) {
                    b.a.r0.x0.u2.a.e(d2Var, 5, this.f26654b.f2423i, b.a.r0.x0.u2.d.h0, this.f26654b.h0());
                    b.a.r0.x0.x2.l.g(d2Var, this.f26654b.n, 1);
                } else if (view.getId() == e1.share_num_container) {
                    b.a.r0.x0.u2.a.e(d2Var, 14, this.f26654b.f2423i, b.a.r0.x0.u2.d.h0, this.f26654b.h0());
                } else if (view.getId() == e1.img_agree) {
                    b.a.r0.x0.u2.a.e(d2Var, 12, this.f26654b.f2423i, b.a.r0.x0.u2.d.h0, this.f26654b.h0());
                } else if (view.getId() == e1.img_disagree) {
                    b.a.r0.x0.u2.a.e(d2Var, 13, this.f26654b.f2423i, b.a.r0.x0.u2.d.h0, this.f26654b.h0());
                } else if (view instanceof TbImageView) {
                    if (this.f26654b.B.f14741a instanceof Boolean) {
                        if (((Boolean) this.f26654b.B.f14741a).booleanValue()) {
                            b.a.r0.x0.u2.a.e(d2Var, 1, this.f26654b.f2423i, b.a.r0.x0.u2.d.h0, this.f26654b.h0());
                        } else {
                            b.a.r0.x0.u2.a.e(d2Var, 3, this.f26654b.f2423i, b.a.r0.x0.u2.d.h0, this.f26654b.h0());
                        }
                    }
                    b.a.r0.x0.x2.l.g(d2Var, this.f26654b.n, 2);
                } else if (view instanceof ThreadGodReplyLayout) {
                    b.a.r0.x0.u2.a.e(d2Var, 15, this.f26654b.f2423i, b.a.r0.x0.u2.d.h0, this.f26654b.h0());
                    b.a.r0.x0.x2.l.g(d2Var, this.f26654b.n, 1);
                } else {
                    b.a.r0.x0.u2.a.e(d2Var, 1, this.f26654b.f2423i, b.a.r0.x0.u2.d.h0, this.f26654b.h0());
                    b.a.r0.x0.x2.l.g(d2Var, this.f26654b.n, 1);
                }
            } else {
                b.a.r0.x0.u2.a.e(d2Var, 2, this.f26654b.f2423i, b.a.r0.x0.u2.d.h0, this.f26654b.h0());
            }
            if (view.getId() == e1.thread_card_root && d2Var.E2()) {
                this.f26654b.O0(d2Var);
            } else if (view.getId() != e1.user_name && view.getId() != e1.user_avatar) {
                if (view.getId() == e1.card_divider_tv) {
                    b.a.r0.x0.x2.l.a(b.a.r0.x0.u2.d.h0, d2Var.getRecomReason());
                } else if (view instanceof TbImageView) {
                    if (this.f26654b.B.f14741a instanceof Boolean) {
                        if (((Boolean) this.f26654b.B.f14741a).booleanValue()) {
                            b.a.r0.x0.u2.c.j().g(b.a.r0.x0.u2.d.h0, d2Var, 1);
                        } else {
                            b.a.r0.x0.u2.c.j().g(b.a.r0.x0.u2.d.h0, d2Var, 3);
                        }
                    }
                } else if (view.getId() == e1.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view.getId() == e1.thread_card_voice) {
                    b.a.r0.x0.u2.c.j().g(b.a.r0.x0.u2.d.h0, d2Var, 5);
                } else if (view instanceof ThreadGodReplyLayout) {
                    int i2 = 6;
                    if (d2Var.v1() != null && d2Var.v1().M() != null && d2Var.v1().M().y() != null && d2Var.v1().M().y().size() > 0) {
                        i2 = d2Var.v1().P ? 9 : 8;
                    }
                    b.a.r0.x0.u2.c.j().g(b.a.r0.x0.u2.d.h0, d2Var, i2);
                } else {
                    b.a.r0.x0.u2.c.j().g(b.a.r0.x0.u2.d.h0, d2Var, 1);
                }
            } else {
                b.a.r0.x0.u2.c.j().g(b.a.r0.x0.u2.d.h0, d2Var, 2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements b.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.l.n f26655e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ m f26656f;

        public b(m mVar, b.a.l.n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26656f = mVar;
            this.f26655e = nVar;
        }

        @Override // b.a.e.l.e.w
        public void b(View view, b.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof c2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                if ((b.a.r0.x0.b.f().i() || b.a.r0.x0.a.h().j()) && !this.f26655e.t()) {
                    d2 d2Var = ((c2) nVar).w;
                    if (d2Var == null) {
                        return;
                    }
                    if (!d2Var.j2() && b.a.r0.x0.b.f().i()) {
                        if (b.a.r0.x0.b.f().a(d2Var)) {
                            d2Var.g4(true);
                        }
                    } else if (!d2Var.k2() && b.a.r0.x0.a.h().j()) {
                        if (b.a.r0.x0.a.h().a(d2Var)) {
                            d2Var.h4(true);
                        }
                    } else {
                        b.a.r0.x0.b.f().l(d2Var);
                        d2Var.g4(false);
                        b.a.r0.x0.a.h().l(d2Var);
                        d2Var.h4(false);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, d2Var));
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d2 d2Var2 = ((c2) nVar).w;
                d2Var2.objType = 1;
                if (this.f26656f.B != null) {
                    this.f26656f.B.a(threadCardViewHolder.getView(), d2Var2);
                }
                ThreadCardUtils.jumpToPB((b.a.q0.s.q.a) d2Var2, view.getContext(), this.f26656f.A, false);
                threadCardViewHolder.getCardView().n(new a.C0090a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.B = new a(this);
        this.o = tbPageContext;
        this.f2423i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: M0 */
    public ThreadCardViewHolder<d2> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity(), false);
            b.a.l.n nVar = new b.a.l.n(this.o.getPageActivity());
            bVar.h(nVar);
            nVar.w(this.z);
            nVar.v("frs");
            l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.q);
            k.q(3);
            ThreadCardViewHolder<d2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.f2423i);
            c0(new b(this, nVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.x0.k, b.a.e.l.e.a
    /* renamed from: N0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c2 c2Var, ThreadCardViewHolder<d2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view, viewGroup, c2Var, threadCardViewHolder})) == null) {
            super.Z(i2, view, viewGroup, c2Var, threadCardViewHolder);
            if (c2Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            threadCardViewHolder.getCardView().setPage(this.y);
            threadCardViewHolder.getCardView().p(i2);
            b.a.r0.x0.j.i(threadCardViewHolder.getCardView().e(), this.n);
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
                c2Var.w.w4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
            }
            threadCardViewHolder.onBindDataToView(c2Var.w);
            threadCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().o(this.B);
            c2Var.w.O4();
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void O0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", d2Var.f0()).param("obj_locate", i0() ? 2 : 1).param("obj_id", d2Var.l1() == null ? -1L : d2Var.l1().live_id).param("obj_type", 1));
        }
    }

    @Override // b.a.r0.b0.a0
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

    @Override // b.a.r0.x0.u2.d
    public b.a.r0.x0.u2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? b.a.r0.x0.u2.d.h0 : (b.a.r0.x0.u2.b) invokeV.objValue;
    }

    @Override // b.a.r0.b0.b0
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // b.a.r0.b0.a0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.A = i2;
        }
    }

    @Override // b.a.r0.x0.k, b.a.r0.b0.z
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.x = str;
        }
    }

    @Override // b.a.r0.x0.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.z = z;
        }
    }
}
