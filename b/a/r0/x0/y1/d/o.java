package b.a.r0.x0.y1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.r0.x0.f1;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.frs.entelechy.adapter.FrsCardVideoViewHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class o extends b.a.r0.x0.k<c2, FrsCardVideoViewHolder<b.a.r0.x0.y1.g.b>> implements b.a.r0.b0.b0, b.a.r0.x0.v2.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static int B = 5;
    public static int C = 10;
    public static int D = 15;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.r0.b0.d0<d2> A;
    public TbPageContext<?> x;
    public String y;
    public b.a.r0.x0.v2.b z;

    /* loaded from: classes6.dex */
    public class a extends b.a.r0.b0.d0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ o f28255b;

        public a(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28255b = oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.d0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) || view == null || d2Var == null) {
                return;
            }
            if (view.getId() == f1.frame_video) {
                this.f28255b.I0(d2Var, "c11718");
            } else if (view.getId() == f1.layout_root) {
                this.f28255b.I0(d2Var, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
            } else if (view.getId() == f1.image_user || view.getId() == f1.pendant_image_user) {
                this.f28255b.I0(d2Var, "c10241");
            } else if (view.getId() == f1.card_divider_tv) {
                b.a.r0.x0.y2.l.a(this.f28255b.z, d2Var.getRecomReason());
            }
            if (view.getId() != f1.card_home_page_normal_thread_user_name && !(view instanceof HeadImageView) && !(view instanceof HeadPendantView)) {
                if (view.getId() == f1.frame_video) {
                    b.a.r0.x0.v2.a.e(d2Var, 4, this.f28255b.f2425i, this.f28255b.z, this.f28255b.h0());
                    if (this.f28255b.n == null || this.f28255b.n.getForum() == null) {
                        return;
                    }
                    b.a.r0.x0.v2.a.c(d2Var, this.f28255b.n.getForum().getId());
                    return;
                } else if (view.getId() == f1.thread_info_commont_container) {
                    b.a.r0.x0.v2.a.e(d2Var, 5, this.f28255b.f2425i, this.f28255b.z, this.f28255b.h0());
                    if (this.f28255b.n == null || this.f28255b.n.getForum() == null) {
                        return;
                    }
                    b.a.r0.x0.v2.a.c(d2Var, this.f28255b.n.getForum().getId());
                    return;
                } else {
                    b.a.r0.x0.v2.a.e(d2Var, 1, this.f28255b.f2425i, this.f28255b.z, this.f28255b.h0());
                    if (this.f28255b.n == null || this.f28255b.n.getForum() == null) {
                        return;
                    }
                    b.a.r0.x0.v2.a.c(d2Var, this.f28255b.n.getForum().getId());
                    return;
                }
            }
            b.a.r0.x0.v2.a.e(d2Var, 2, this.f28255b.f2425i, this.f28255b.z, this.f28255b.h0());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-529864511, "Lb/a/r0/x0/y1/d/o;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-529864511, "Lb/a/r0/x0/y1/d/o;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.z = new b.a.r0.x0.v2.b();
        this.A = new a(this);
        this.x = tbPageContext;
    }

    public final void I0(d2 d2Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, d2Var, str) == null) || d2Var == null) {
            return;
        }
        int h0 = d2Var.h0();
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_locate", J0(h0));
        statisticItem.param("tid", d2Var.t1());
        statisticItem.param("obj_type", 2);
        TiebaStatic.log(statisticItem);
    }

    public final String J0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? i2 == B ? "3" : i2 == C ? "10" : i2 == D ? "11" : "" : (String) invokeI.objValue;
    }

    public final b.a.r0.q2.p K0(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var)) == null) {
            if (d2Var != null) {
                b.a.r0.q2.p pVar = new b.a.r0.q2.p();
                pVar.f24403a = J0(d2Var.h0());
                pVar.f24406d = this.z.f27993c;
                pVar.f24405c = d2Var.t1();
                pVar.l = d2Var.Z0;
                if (d2Var.r1() != null) {
                    pVar.m = d2Var.r1().video_md5;
                }
                d2Var.Q4();
                return pVar;
            }
            return null;
        }
        return (b.a.r0.q2.p) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: L0 */
    public FrsCardVideoViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            b.a.r0.x0.y1.g.b bVar = new b.a.r0.x0.y1.g.b(this.x, this.f2425i);
            bVar.Z(this.f2425i);
            bVar.a(this.y);
            return new FrsCardVideoViewHolder(bVar);
        }
        return (FrsCardVideoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.x0.k, b.a.e.m.e.a
    /* renamed from: M0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c2 c2Var, FrsCardVideoViewHolder frsCardVideoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, c2Var, frsCardVideoViewHolder})) == null) {
            if (frsCardVideoViewHolder == null || frsCardVideoViewHolder.getCardView() == null) {
                return null;
            }
            frsCardVideoViewHolder.getCardView().f0(K0(c2Var.w));
            frsCardVideoViewHolder.getCardView().j(c2Var.w);
            frsCardVideoViewHolder.getCardView().l(this.A);
            b.a.r0.x0.v2.a.m(c2Var.w, this.f2425i, this.z, h0());
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null) {
                b.a.r0.x0.v2.a.l(c2Var.w, this.n.getForum().getId());
            }
            return frsCardVideoViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // b.a.r0.b0.b0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.y = str;
        }
    }

    @Override // b.a.r0.x0.v2.d
    public b.a.r0.x0.v2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.z : (b.a.r0.x0.v2.b) invokeV.objValue;
    }

    @Override // b.a.r0.b0.b0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
        }
    }
}
