package c.a.u0.e1.z1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.l0;
import c.a.l.w0.a;
import c.a.t0.s.r.d2;
import c.a.t0.s.r.e2;
import c.a.u0.e1.f1;
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
/* loaded from: classes8.dex */
public class s extends c.a.u0.e1.k<d2, ThreadCardViewHolder<e2>> implements c.a.u0.g0.z, c.a.u0.e1.y2.d, c.a.u0.t.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public c.a.u0.g0.b0<e2> B;
    public String x;
    public String y;
    public boolean z;

    /* loaded from: classes8.dex */
    public class a extends c.a.u0.g0.b0<e2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ s f17424b;

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
            this.f17424b = sVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.u0.g0.b0
        /* renamed from: d */
        public void a(View view, e2 e2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, e2Var) == null) || view == null || e2Var == null) {
                return;
            }
            if (this.f17424b.u != null) {
                this.f17424b.u.b(view, e2Var, this.f17424b.getType());
            }
            if ("c13010".equals(this.f17424b.y)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", e2Var.U()).param("tid", e2Var.w1()));
            }
            if (view.getId() != f1.user_name && view.getId() != f1.user_avatar) {
                if (view.getId() == f1.thread_info_commont_container) {
                    c.a.u0.e1.y2.a.e(e2Var, 5, this.f17424b.f2451i, c.a.u0.e1.y2.d.p0, this.f17424b.a0());
                    c.a.u0.e1.b3.q.g(e2Var, this.f17424b.n, 1);
                } else if (view.getId() == f1.share_num_container) {
                    c.a.u0.e1.y2.a.e(e2Var, 14, this.f17424b.f2451i, c.a.u0.e1.y2.d.p0, this.f17424b.a0());
                } else if (view instanceof TbImageView) {
                    if (this.f17424b.B.a instanceof Boolean) {
                        if (((Boolean) this.f17424b.B.a).booleanValue()) {
                            c.a.u0.e1.y2.a.e(e2Var, 1, this.f17424b.f2451i, c.a.u0.e1.y2.d.p0, this.f17424b.a0());
                        } else {
                            c.a.u0.e1.y2.a.e(e2Var, 3, this.f17424b.f2451i, c.a.u0.e1.y2.d.p0, this.f17424b.a0());
                        }
                    }
                    c.a.u0.e1.b3.q.g(e2Var, this.f17424b.n, 2);
                } else if (view instanceof ThreadGodReplyLayout) {
                    c.a.u0.e1.y2.a.e(e2Var, 15, this.f17424b.f2451i, c.a.u0.e1.y2.d.p0, this.f17424b.a0());
                    c.a.u0.e1.b3.q.g(e2Var, this.f17424b.n, 1);
                } else {
                    c.a.u0.e1.y2.a.e(e2Var, 1, this.f17424b.f2451i, c.a.u0.e1.y2.d.p0, this.f17424b.a0());
                    c.a.u0.e1.b3.q.g(e2Var, this.f17424b.n, 1);
                }
            } else {
                c.a.u0.e1.y2.a.e(e2Var, 2, this.f17424b.f2451i, c.a.u0.e1.y2.d.p0, this.f17424b.a0());
            }
            if (view.getId() != f1.user_name && view.getId() != f1.user_avatar) {
                if (view.getId() == f1.card_divider_tv) {
                    c.a.u0.e1.b3.q.a(c.a.u0.e1.y2.d.p0, e2Var.getRecomReason());
                    return;
                } else if (view instanceof TbImageView) {
                    if (this.f17424b.B.a instanceof Boolean) {
                        if (((Boolean) this.f17424b.B.a).booleanValue()) {
                            c.a.u0.e1.y2.c.k().h(c.a.u0.e1.y2.d.p0, e2Var, 1);
                            return;
                        } else {
                            c.a.u0.e1.y2.c.k().h(c.a.u0.e1.y2.d.p0, e2Var, 3);
                            return;
                        }
                    }
                    return;
                } else if (view.getId() == f1.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                    return;
                } else if (view.getId() == f1.thread_card_voice) {
                    c.a.u0.e1.y2.c.k().h(c.a.u0.e1.y2.d.p0, e2Var, 5);
                    return;
                } else if (view instanceof ThreadGodReplyLayout) {
                    int i2 = 6;
                    if (e2Var.z1() != null && e2Var.z1().N() != null && e2Var.z1().N().y() != null && e2Var.z1().N().y().size() > 0) {
                        i2 = e2Var.z1().P ? 9 : 8;
                    }
                    c.a.u0.e1.y2.c.k().h(c.a.u0.e1.y2.d.p0, e2Var, i2);
                    return;
                } else {
                    c.a.u0.e1.y2.c.k().h(c.a.u0.e1.y2.d.p0, e2Var, 1);
                    return;
                }
            }
            c.a.u0.e1.y2.c.k().h(c.a.u0.e1.y2.d.p0, e2Var, 2);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements c.a.d.o.e.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f17425e;

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
            this.f17425e = sVar;
        }

        @Override // c.a.d.o.e.v
        public void b(View view, c.a.d.o.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof d2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                e2 e2Var = ((d2) nVar).w;
                e2Var.objType = 1;
                if (this.f17425e.B != null) {
                    this.f17425e.B.a(threadCardViewHolder.getView(), e2Var);
                }
                ThreadCardUtils.jumpToPB((c.a.t0.s.r.a) e2Var, view.getContext(), 3, false);
                threadCardViewHolder.getCardView().o(new a.C0210a(1));
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
        this.f2451i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: B0 */
    public ThreadCardViewHolder<e2> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity(), false);
            c.a.l.v vVar = new c.a.l.v(this.o.getPageActivity());
            vVar.r("frs");
            vVar.s(this.z);
            if (this.A == 502) {
                vVar.t(false);
            } else {
                vVar.t(true);
            }
            bVar.n(vVar);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
            k.r(3);
            ThreadCardViewHolder<e2> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.f2451i);
            threadCardViewHolder.showMultiDelDecorItem(false);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.u0.e1.k, c.a.d.o.e.a
    /* renamed from: C0 */
    public View S(int i2, View view, ViewGroup viewGroup, d2 d2Var, ThreadCardViewHolder<e2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view, viewGroup, d2Var, threadCardViewHolder})) == null) {
            super.S(i2, view, viewGroup, d2Var, threadCardViewHolder);
            if (d2Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            threadCardViewHolder.getCardView().d(this.x);
            threadCardViewHolder.getCardView().q(i2);
            c.a.u0.e1.j.i(threadCardViewHolder.getCardView().f(), this.n);
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
                d2Var.w.B4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
            }
            threadCardViewHolder.onBindDataToView(d2Var.w);
            threadCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.B);
            d2Var.w.T4();
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.u0.g0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // c.a.u0.t.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.x = str;
        }
    }

    @Override // c.a.u0.e1.y2.d
    public c.a.u0.e1.y2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? c.a.u0.e1.y2.d.p0 : (c.a.u0.e1.y2.b) invokeV.objValue;
    }

    @Override // c.a.u0.g0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.A = i2;
        }
    }

    @Override // c.a.u0.e1.k
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.y = str;
        }
    }

    @Override // c.a.u0.e1.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.z = z;
        }
    }
}
