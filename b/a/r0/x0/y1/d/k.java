package b.a.r0.x0.y1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.l.l0;
import b.a.l.w0.a;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
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
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k extends b.a.r0.x0.k<c2, ThreadCardViewHolder<d2>> implements b.a.r0.b0.b0, b.a.r0.x0.v2.d, b.a.r0.p.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public b.a.r0.b0.d0<d2> B;
    public String x;
    public String y;
    public boolean z;

    /* loaded from: classes6.dex */
    public class a extends b.a.r0.b0.d0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f28246b;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28246b = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.d0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) || view == null || d2Var == null) {
                return;
            }
            if (this.f28246b.u != null) {
                this.f28246b.u.b(view, d2Var, this.f28246b.getType());
            }
            if ("c13010".equals(this.f28246b.x)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", d2Var.T()).param("tid", d2Var.t1()));
            }
            if (view.getId() != f1.user_name && view.getId() != f1.user_avatar) {
                if (view.getId() == f1.thread_info_commont_container) {
                    b.a.r0.x0.v2.a.e(d2Var, 5, this.f28246b.f2425i, b.a.r0.x0.v2.d.h0, this.f28246b.h0());
                    b.a.r0.x0.y2.l.g(d2Var, this.f28246b.n, 1);
                } else if (view.getId() == f1.share_num_container) {
                    b.a.r0.x0.v2.a.e(d2Var, 14, this.f28246b.f2425i, b.a.r0.x0.v2.d.h0, this.f28246b.h0());
                } else if (view instanceof TbImageView) {
                    if (this.f28246b.B.f16228a instanceof Boolean) {
                        if (((Boolean) this.f28246b.B.f16228a).booleanValue()) {
                            b.a.r0.x0.v2.a.e(d2Var, 1, this.f28246b.f2425i, b.a.r0.x0.v2.d.h0, this.f28246b.h0());
                        } else {
                            b.a.r0.x0.v2.a.e(d2Var, 3, this.f28246b.f2425i, b.a.r0.x0.v2.d.h0, this.f28246b.h0());
                        }
                    }
                    b.a.r0.x0.y2.l.g(d2Var, this.f28246b.n, 2);
                } else if (view instanceof ThreadGodReplyLayout) {
                    b.a.r0.x0.v2.a.e(d2Var, 15, this.f28246b.f2425i, b.a.r0.x0.v2.d.h0, this.f28246b.h0());
                    b.a.r0.x0.y2.l.g(d2Var, this.f28246b.n, 1);
                } else {
                    b.a.r0.x0.v2.a.e(d2Var, 1, this.f28246b.f2425i, b.a.r0.x0.v2.d.h0, this.f28246b.h0());
                    b.a.r0.x0.y2.l.g(d2Var, this.f28246b.n, 1);
                }
            } else {
                b.a.r0.x0.v2.a.e(d2Var, 2, this.f28246b.f2425i, b.a.r0.x0.v2.d.h0, this.f28246b.h0());
            }
            if (view.getId() == f1.thread_card_root && d2Var.G2()) {
                this.f28246b.M0(d2Var);
            } else if (view.getId() != f1.user_name && view.getId() != f1.user_avatar) {
                if (view.getId() == f1.card_divider_tv) {
                    b.a.r0.x0.y2.l.a(b.a.r0.x0.v2.d.h0, d2Var.getRecomReason());
                } else if (view instanceof TbImageView) {
                    if (this.f28246b.B.f16228a instanceof Boolean) {
                        if (((Boolean) this.f28246b.B.f16228a).booleanValue()) {
                            b.a.r0.x0.v2.c.j().g(b.a.r0.x0.v2.d.h0, d2Var, 1);
                        } else {
                            b.a.r0.x0.v2.c.j().g(b.a.r0.x0.v2.d.h0, d2Var, 3);
                        }
                    }
                } else if (view.getId() == f1.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view.getId() == f1.thread_card_voice) {
                    b.a.r0.x0.v2.c.j().g(b.a.r0.x0.v2.d.h0, d2Var, 5);
                } else if (view instanceof ThreadGodReplyLayout) {
                    int i2 = 6;
                    if (d2Var.w1() != null && d2Var.w1().M() != null && d2Var.w1().M().y() != null && d2Var.w1().M().y().size() > 0) {
                        i2 = d2Var.w1().P ? 9 : 8;
                    }
                    b.a.r0.x0.v2.c.j().g(b.a.r0.x0.v2.d.h0, d2Var, i2);
                } else {
                    b.a.r0.x0.v2.c.j().g(b.a.r0.x0.v2.d.h0, d2Var, 1);
                }
            } else {
                b.a.r0.x0.v2.c.j().g(b.a.r0.x0.v2.d.h0, d2Var, 2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements b.a.e.m.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f28247e;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28247e = kVar;
        }

        @Override // b.a.e.m.e.w
        public void b(View view, b.a.e.m.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof c2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d2 d2Var = ((c2) nVar).w;
                d2Var.objType = 1;
                if (this.f28247e.B != null) {
                    this.f28247e.B.a(threadCardViewHolder.getView(), d2Var);
                }
                ThreadCardUtils.jumpToPB((b.a.q0.s.q.a) d2Var, view.getContext(), this.f28247e.A, false);
                threadCardViewHolder.getCardView().n(new a.C0092a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.f2425i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: K0 */
    public ThreadCardViewHolder<d2> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity(), false);
            b.a.l.z zVar = new b.a.l.z(this.o.getPageActivity());
            zVar.q("frs");
            zVar.r(this.z);
            if (this.A == 502) {
                zVar.s(false);
            } else {
                zVar.s(true);
            }
            bVar.n(zVar);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
            k.q(3);
            ThreadCardViewHolder<d2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.f2425i);
            threadCardViewHolder.showMultiDelDecorItem(false);
            c0(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.x0.k, b.a.e.m.e.a
    /* renamed from: L0 */
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
                c2Var.w.y4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
            }
            threadCardViewHolder.onBindDataToView(c2Var.w);
            threadCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().o(this.B);
            c2Var.w.Q4();
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void M0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", d2Var.f0()).param("obj_locate", i0() ? 2 : 1).param("obj_id", d2Var.m1() == null ? -1L : d2Var.m1().live_id).param("obj_type", 1));
        }
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
            this.A = i2;
        }
    }

    @Override // b.a.r0.x0.k, b.a.r0.b0.a0
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.x = str;
        }
    }

    @Override // b.a.r0.x0.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.z = z;
        }
    }
}
