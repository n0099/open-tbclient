package c.a.q0.v0.m1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.l0;
import c.a.l.v0.a;
import c.a.p0.s.q.b2;
import c.a.p0.s.q.c2;
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
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class s extends c.a.q0.v0.k<b2, ThreadCardViewHolder<c2>> implements c.a.q0.a0.z, c.a.q0.v0.j2.d, c.a.q0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public c.a.q0.a0.b0<c2> B;
    public String x;
    public String y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a extends c.a.q0.a0.b0<c2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ s f26559b;

        public a(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26559b = sVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, c2 c2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, c2Var) == null) || view == null || c2Var == null) {
                return;
            }
            if (this.f26559b.u != null) {
                this.f26559b.u.b(view, c2Var, this.f26559b.K());
            }
            if ("c13010".equals(this.f26559b.y)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", c2Var.T()).param("tid", c2Var.q1()));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    c.a.q0.v0.j2.a.e(c2Var, 5, this.f26559b.f2970i, c.a.q0.v0.j2.d.h0, this.f26559b.i0());
                    c.a.q0.v0.m2.l.g(c2Var, this.f26559b.n, 1);
                } else if (view.getId() == R.id.share_num_container) {
                    c.a.q0.v0.j2.a.e(c2Var, 14, this.f26559b.f2970i, c.a.q0.v0.j2.d.h0, this.f26559b.i0());
                } else if (view instanceof TbImageView) {
                    if (this.f26559b.B.f15237a instanceof Boolean) {
                        if (((Boolean) this.f26559b.B.f15237a).booleanValue()) {
                            c.a.q0.v0.j2.a.e(c2Var, 1, this.f26559b.f2970i, c.a.q0.v0.j2.d.h0, this.f26559b.i0());
                        } else {
                            c.a.q0.v0.j2.a.e(c2Var, 3, this.f26559b.f2970i, c.a.q0.v0.j2.d.h0, this.f26559b.i0());
                        }
                    }
                    c.a.q0.v0.m2.l.g(c2Var, this.f26559b.n, 2);
                } else if (view instanceof ThreadGodReplyLayout) {
                    c.a.q0.v0.j2.a.e(c2Var, 15, this.f26559b.f2970i, c.a.q0.v0.j2.d.h0, this.f26559b.i0());
                    c.a.q0.v0.m2.l.g(c2Var, this.f26559b.n, 1);
                } else {
                    c.a.q0.v0.j2.a.e(c2Var, 1, this.f26559b.f2970i, c.a.q0.v0.j2.d.h0, this.f26559b.i0());
                    c.a.q0.v0.m2.l.g(c2Var, this.f26559b.n, 1);
                }
            } else {
                c.a.q0.v0.j2.a.e(c2Var, 2, this.f26559b.f2970i, c.a.q0.v0.j2.d.h0, this.f26559b.i0());
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.card_divider_tv) {
                    c.a.q0.v0.m2.l.a(c.a.q0.v0.j2.d.h0, c2Var.getRecomReason());
                    return;
                } else if (view instanceof TbImageView) {
                    if (this.f26559b.B.f15237a instanceof Boolean) {
                        if (((Boolean) this.f26559b.B.f15237a).booleanValue()) {
                            c.a.q0.v0.j2.c.j().g(c.a.q0.v0.j2.d.h0, c2Var, 1);
                            return;
                        } else {
                            c.a.q0.v0.j2.c.j().g(c.a.q0.v0.j2.d.h0, c2Var, 3);
                            return;
                        }
                    }
                    return;
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                    return;
                } else if (view.getId() == R.id.thread_card_voice) {
                    c.a.q0.v0.j2.c.j().g(c.a.q0.v0.j2.d.h0, c2Var, 5);
                    return;
                } else if (view instanceof ThreadGodReplyLayout) {
                    int i2 = 6;
                    if (c2Var.t1() != null && c2Var.t1().K() != null && c2Var.t1().K().y() != null && c2Var.t1().K().y().size() > 0) {
                        i2 = c2Var.t1().N ? 9 : 8;
                    }
                    c.a.q0.v0.j2.c.j().g(c.a.q0.v0.j2.d.h0, c2Var, i2);
                    return;
                } else {
                    c.a.q0.v0.j2.c.j().g(c.a.q0.v0.j2.d.h0, c2Var, 1);
                    return;
                }
            }
            c.a.q0.v0.j2.c.j().g(c.a.q0.v0.j2.d.h0, c2Var, 2);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f26560e;

        public b(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26560e = sVar;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, c.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof b2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                c2 c2Var = ((b2) nVar).w;
                c2Var.objType = 1;
                if (this.f26560e.B != null) {
                    this.f26560e.B.a(threadCardViewHolder.getView(), c2Var);
                }
                ThreadCardUtils.jumpToPB((c.a.p0.s.q.a) c2Var, view.getContext(), 3, false);
                threadCardViewHolder.getCardView().o(new a.C0096a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.B = new a(this);
        this.o = tbPageContext;
        this.f2970i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: J0 */
    public ThreadCardViewHolder<c2> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity(), false);
            c.a.l.v vVar = new c.a.l.v(this.o.getPageActivity());
            vVar.u("frs");
            vVar.v(this.z);
            if (this.A == 502) {
                vVar.w(false);
            } else {
                vVar.w(true);
            }
            bVar.n(vVar);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
            k.r(3);
            ThreadCardViewHolder<c2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.f2970i);
            threadCardViewHolder.showMultiDelDecorItem(false);
            d0(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.v0.k, c.a.e.l.e.a
    /* renamed from: K0 */
    public View a0(int i2, View view, ViewGroup viewGroup, b2 b2Var, ThreadCardViewHolder<c2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view, viewGroup, b2Var, threadCardViewHolder})) == null) {
            super.a0(i2, view, viewGroup, b2Var, threadCardViewHolder);
            if (b2Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            threadCardViewHolder.getCardView().setPage(this.x);
            threadCardViewHolder.getCardView().q(i2);
            c.a.q0.v0.j.i(threadCardViewHolder.getCardView().e(), this.n);
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
            this.x = str;
        }
    }

    @Override // c.a.q0.v0.j2.d
    public c.a.q0.v0.j2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? c.a.q0.v0.j2.d.h0 : (c.a.q0.v0.j2.b) invokeV.objValue;
    }

    @Override // c.a.q0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.A = i2;
        }
    }

    @Override // c.a.q0.v0.k, c.a.q0.a0.y
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.y = str;
        }
    }

    @Override // c.a.q0.v0.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.z = z;
        }
    }
}
