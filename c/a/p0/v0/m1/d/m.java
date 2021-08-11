package c.a.p0.v0.m1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.l0;
import c.a.l.v0.a;
import c.a.o0.s.q.b2;
import c.a.o0.s.q.c2;
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
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class m extends c.a.p0.v0.k<b2, ThreadCardViewHolder<c2>> implements c.a.p0.a0.z, c.a.p0.v0.j2.d, c.a.p0.o.f, c.a.p0.a0.a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public c.a.p0.a0.b0<c2> B;
    public String x;
    public String y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a extends c.a.p0.a0.b0<c2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ m f26112b;

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
            this.f26112b = mVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a0.b0
        /* renamed from: d */
        public void a(View view, c2 c2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, c2Var) == null) || view == null || c2Var == null) {
                return;
            }
            if (this.f26112b.u != null) {
                this.f26112b.u.b(view, c2Var, this.f26112b.K());
            }
            if ("c13010".equals(this.f26112b.x)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", c2Var.T()).param("tid", c2Var.q1()));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    c.a.p0.v0.j2.a.e(c2Var, 5, this.f26112b.f2908i, c.a.p0.v0.j2.d.h0, this.f26112b.i0());
                    c.a.p0.v0.n2.l.g(c2Var, this.f26112b.n, 1);
                } else if (view.getId() == R.id.share_num_container) {
                    c.a.p0.v0.j2.a.e(c2Var, 14, this.f26112b.f2908i, c.a.p0.v0.j2.d.h0, this.f26112b.i0());
                } else if (view.getId() == R.id.img_agree) {
                    c.a.p0.v0.j2.a.e(c2Var, 12, this.f26112b.f2908i, c.a.p0.v0.j2.d.h0, this.f26112b.i0());
                } else if (view.getId() == R.id.img_disagree) {
                    c.a.p0.v0.j2.a.e(c2Var, 13, this.f26112b.f2908i, c.a.p0.v0.j2.d.h0, this.f26112b.i0());
                } else if (view instanceof TbImageView) {
                    if (this.f26112b.B.f14951a instanceof Boolean) {
                        if (((Boolean) this.f26112b.B.f14951a).booleanValue()) {
                            c.a.p0.v0.j2.a.e(c2Var, 1, this.f26112b.f2908i, c.a.p0.v0.j2.d.h0, this.f26112b.i0());
                        } else {
                            c.a.p0.v0.j2.a.e(c2Var, 3, this.f26112b.f2908i, c.a.p0.v0.j2.d.h0, this.f26112b.i0());
                        }
                    }
                    c.a.p0.v0.n2.l.g(c2Var, this.f26112b.n, 2);
                } else if (view instanceof ThreadGodReplyLayout) {
                    c.a.p0.v0.j2.a.e(c2Var, 15, this.f26112b.f2908i, c.a.p0.v0.j2.d.h0, this.f26112b.i0());
                    c.a.p0.v0.n2.l.g(c2Var, this.f26112b.n, 1);
                } else {
                    c.a.p0.v0.j2.a.e(c2Var, 1, this.f26112b.f2908i, c.a.p0.v0.j2.d.h0, this.f26112b.i0());
                    c.a.p0.v0.n2.l.g(c2Var, this.f26112b.n, 1);
                }
            } else {
                c.a.p0.v0.j2.a.e(c2Var, 2, this.f26112b.f2908i, c.a.p0.v0.j2.d.h0, this.f26112b.i0());
            }
            if (view.getId() == R.id.thread_card_root && c2Var.A2()) {
                this.f26112b.P0(c2Var);
            } else if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.card_divider_tv) {
                    c.a.p0.v0.n2.l.a(c.a.p0.v0.j2.d.h0, c2Var.getRecomReason());
                } else if (view instanceof TbImageView) {
                    if (this.f26112b.B.f14951a instanceof Boolean) {
                        if (((Boolean) this.f26112b.B.f14951a).booleanValue()) {
                            c.a.p0.v0.j2.c.j().g(c.a.p0.v0.j2.d.h0, c2Var, 1);
                        } else {
                            c.a.p0.v0.j2.c.j().g(c.a.p0.v0.j2.d.h0, c2Var, 3);
                        }
                    }
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view.getId() == R.id.thread_card_voice) {
                    c.a.p0.v0.j2.c.j().g(c.a.p0.v0.j2.d.h0, c2Var, 5);
                } else if (view instanceof ThreadGodReplyLayout) {
                    int i2 = 6;
                    if (c2Var.t1() != null && c2Var.t1().K() != null && c2Var.t1().K().y() != null && c2Var.t1().K().y().size() > 0) {
                        i2 = c2Var.t1().N ? 9 : 8;
                    }
                    c.a.p0.v0.j2.c.j().g(c.a.p0.v0.j2.d.h0, c2Var, i2);
                } else {
                    c.a.p0.v0.j2.c.j().g(c.a.p0.v0.j2.d.h0, c2Var, 1);
                }
            } else {
                c.a.p0.v0.j2.c.j().g(c.a.p0.v0.j2.d.h0, c2Var, 2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.a.e.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.l.n f26113e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ m f26114f;

        public b(m mVar, c.a.l.n nVar) {
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
            this.f26114f = mVar;
            this.f26113e = nVar;
        }

        @Override // c.a.e.k.e.w
        public void b(View view, c.a.e.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof b2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                if ((c.a.p0.v0.b.f().i() || c.a.p0.v0.a.h().j()) && !this.f26113e.t()) {
                    c2 c2Var = ((b2) nVar).w;
                    if (c2Var == null) {
                        return;
                    }
                    if (!c2Var.f2() && c.a.p0.v0.b.f().i()) {
                        if (c.a.p0.v0.b.f().a(c2Var)) {
                            c2Var.W3(true);
                        }
                    } else if (!c2Var.g2() && c.a.p0.v0.a.h().j()) {
                        if (c.a.p0.v0.a.h().a(c2Var)) {
                            c2Var.X3(true);
                        }
                    } else {
                        c.a.p0.v0.b.f().l(c2Var);
                        c2Var.W3(false);
                        c.a.p0.v0.a.h().l(c2Var);
                        c2Var.X3(false);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, c2Var));
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                c2 c2Var2 = ((b2) nVar).w;
                c2Var2.objType = 1;
                if (this.f26114f.B != null) {
                    this.f26114f.B.a(threadCardViewHolder.getView(), c2Var2);
                }
                ThreadCardUtils.jumpToPB((c.a.o0.s.q.a) c2Var2, view.getContext(), this.f26114f.A, false);
                threadCardViewHolder.getCardView().o(new a.C0088a(1));
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
        this.f2908i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.k.e.a
    /* renamed from: N0 */
    public ThreadCardViewHolder<c2> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity(), false);
            c.a.l.n nVar = new c.a.l.n(this.o.getPageActivity());
            bVar.h(nVar);
            nVar.w(this.z);
            nVar.v("frs");
            l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.q);
            k.r(3);
            ThreadCardViewHolder<c2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.f2908i);
            d0(new b(this, nVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.v0.k, c.a.e.k.e.a
    /* renamed from: O0 */
    public View a0(int i2, View view, ViewGroup viewGroup, b2 b2Var, ThreadCardViewHolder<c2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view, viewGroup, b2Var, threadCardViewHolder})) == null) {
            super.a0(i2, view, viewGroup, b2Var, threadCardViewHolder);
            if (b2Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            threadCardViewHolder.getCardView().setPage(this.y);
            threadCardViewHolder.getCardView().q(i2);
            c.a.p0.v0.j.i(threadCardViewHolder.getCardView().e(), this.n);
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
                b2Var.w.m4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
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

    @Override // c.a.p0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // c.a.p0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.y = str;
        }
    }

    @Override // c.a.p0.v0.j2.d
    public c.a.p0.v0.j2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? c.a.p0.v0.j2.d.h0 : (c.a.p0.v0.j2.b) invokeV.objValue;
    }

    @Override // c.a.p0.a0.a0
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // c.a.p0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.A = i2;
        }
    }

    @Override // c.a.p0.v0.k, c.a.p0.a0.y
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.x = str;
        }
    }

    @Override // c.a.p0.v0.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.z = z;
        }
    }
}
