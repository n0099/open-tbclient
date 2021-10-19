package c.a.r0.x0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.l.l0;
import c.a.l.v0.a;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
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
public class v extends c.a.r0.x0.k<c2, ThreadCardViewHolder<d2>> implements c.a.r0.b0.a0, c.a.r0.x0.k2.d, c.a.r0.p.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public c.a.r0.b0.c0<d2> B;
    public String x;
    public String y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a extends c.a.r0.b0.c0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ v f27431b;

        public a(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27431b = vVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) || view == null || d2Var == null) {
                return;
            }
            if (this.f27431b.u != null) {
                this.f27431b.u.b(view, d2Var, this.f27431b.K());
            }
            if ("c13010".equals(this.f27431b.x)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", d2Var.T()).param("tid", d2Var.s1()));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    c.a.r0.x0.k2.a.e(d2Var, 5, this.f27431b.f2962i, c.a.r0.x0.k2.d.h0, this.f27431b.i0());
                    c.a.r0.x0.n2.l.g(d2Var, this.f27431b.n, 1);
                } else if (view.getId() == R.id.share_num_container) {
                    c.a.r0.x0.k2.a.e(d2Var, 14, this.f27431b.f2962i, c.a.r0.x0.k2.d.h0, this.f27431b.i0());
                } else if (view instanceof TbImageView) {
                    if (this.f27431b.B.f15713a instanceof Boolean) {
                        if (((Boolean) this.f27431b.B.f15713a).booleanValue()) {
                            c.a.r0.x0.k2.a.e(d2Var, 1, this.f27431b.f2962i, c.a.r0.x0.k2.d.h0, this.f27431b.i0());
                        } else {
                            c.a.r0.x0.k2.a.e(d2Var, 3, this.f27431b.f2962i, c.a.r0.x0.k2.d.h0, this.f27431b.i0());
                        }
                    }
                    c.a.r0.x0.n2.l.g(d2Var, this.f27431b.n, 2);
                } else if (view instanceof ThreadGodReplyLayout) {
                    c.a.r0.x0.k2.a.e(d2Var, 15, this.f27431b.f2962i, c.a.r0.x0.k2.d.h0, this.f27431b.i0());
                    c.a.r0.x0.n2.l.g(d2Var, this.f27431b.n, 1);
                } else {
                    c.a.r0.x0.k2.a.e(d2Var, 1, this.f27431b.f2962i, c.a.r0.x0.k2.d.h0, this.f27431b.i0());
                    c.a.r0.x0.n2.l.g(d2Var, this.f27431b.n, 1);
                }
            } else {
                c.a.r0.x0.k2.a.e(d2Var, 2, this.f27431b.f2962i, c.a.r0.x0.k2.d.h0, this.f27431b.i0());
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.card_divider_tv) {
                    c.a.r0.x0.n2.l.a(c.a.r0.x0.k2.d.h0, d2Var.getRecomReason());
                    return;
                } else if (view instanceof TbImageView) {
                    if (this.f27431b.B.f15713a instanceof Boolean) {
                        if (((Boolean) this.f27431b.B.f15713a).booleanValue()) {
                            c.a.r0.x0.k2.c.j().g(c.a.r0.x0.k2.d.h0, d2Var, 1);
                            return;
                        } else {
                            c.a.r0.x0.k2.c.j().g(c.a.r0.x0.k2.d.h0, d2Var, 3);
                            return;
                        }
                    }
                    return;
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                    return;
                } else if (view.getId() == R.id.thread_card_voice) {
                    c.a.r0.x0.k2.c.j().g(c.a.r0.x0.k2.d.h0, d2Var, 5);
                    return;
                } else if (view instanceof ThreadGodReplyLayout) {
                    int i2 = 6;
                    if (d2Var.v1() != null && d2Var.v1().K() != null && d2Var.v1().K().y() != null && d2Var.v1().K().y().size() > 0) {
                        i2 = d2Var.v1().N ? 9 : 8;
                    }
                    c.a.r0.x0.k2.c.j().g(c.a.r0.x0.k2.d.h0, d2Var, i2);
                    return;
                } else {
                    c.a.r0.x0.k2.c.j().g(c.a.r0.x0.k2.d.h0, d2Var, 1);
                    return;
                }
            }
            c.a.r0.x0.k2.c.j().g(c.a.r0.x0.k2.d.h0, d2Var, 2);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f27432e;

        public b(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27432e = vVar;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, c.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d2 d2Var = ((c2) nVar).w;
                d2Var.objType = 1;
                if (this.f27432e.B != null) {
                    this.f27432e.B.a(threadCardViewHolder.getView(), d2Var);
                }
                ThreadCardUtils.jumpToPB((c.a.q0.s.q.a) d2Var, view.getContext(), 3, false);
                threadCardViewHolder.getCardView().o(new a.C0095a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.f2962i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: J0 */
    public ThreadCardViewHolder<d2> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity(), false);
            c.a.l.y yVar = new c.a.l.y(this.o.getPageActivity());
            yVar.p("frs");
            yVar.q(this.z);
            if (this.A == 502) {
                yVar.r(false);
            } else {
                yVar.r(true);
            }
            bVar.n(yVar);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
            k.r(3);
            ThreadCardViewHolder<d2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.f2962i);
            threadCardViewHolder.showMultiDelDecorItem(false);
            d0(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.x0.k, c.a.e.l.e.a
    /* renamed from: K0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c2 c2Var, ThreadCardViewHolder<d2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view, viewGroup, c2Var, threadCardViewHolder})) == null) {
            super.a0(i2, view, viewGroup, c2Var, threadCardViewHolder);
            if (c2Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            threadCardViewHolder.getCardView().setPage(this.y);
            threadCardViewHolder.getCardView().q(i2);
            c.a.r0.x0.j.i(threadCardViewHolder.getCardView().e(), this.n);
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
                c2Var.w.v4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
            }
            threadCardViewHolder.onBindDataToView(c2Var.w);
            threadCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.B);
            c2Var.w.M4();
            c.a.l.y yVar = (c.a.l.y) threadCardViewHolder.getCardView().f();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) yVar.f3886j.singalImg.getLayoutParams();
            layoutParams.width = c2Var.x;
            layoutParams.height = c2Var.y;
            if (yVar.f3886j.singalImg.getVisibility() != 8) {
                yVar.f3886j.singalImg.setLayoutParams(layoutParams);
            }
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.r0.b0.a0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    @Override // c.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.y = str;
        }
    }

    @Override // c.a.r0.x0.k2.d
    public c.a.r0.x0.k2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? c.a.r0.x0.k2.d.h0 : (c.a.r0.x0.k2.b) invokeV.objValue;
    }

    @Override // c.a.r0.b0.a0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.A = i2;
        }
    }

    @Override // c.a.r0.x0.k, c.a.r0.b0.z
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.x = str;
        }
    }

    @Override // c.a.r0.x0.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.z = z;
        }
    }
}
