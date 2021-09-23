package c.a.r0.w0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.entelechy.adapter.FrsCardVideoViewHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class o extends c.a.r0.w0.k<c2, FrsCardVideoViewHolder<c.a.r0.w0.n1.g.b>> implements c.a.r0.a0.z, c.a.r0.w0.k2.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static int B = 5;
    public static int C = 10;
    public static int D = 15;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.a0.b0<d2> A;
    public TbPageContext<?> x;
    public String y;
    public c.a.r0.w0.k2.b z;

    /* loaded from: classes4.dex */
    public class a extends c.a.r0.a0.b0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ o f27234b;

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
            this.f27234b = oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a0.b0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) || view == null || d2Var == null) {
                return;
            }
            if (view.getId() == R.id.frame_video) {
                this.f27234b.J0(d2Var, "c11718");
            } else if (view.getId() == R.id.layout_root) {
                this.f27234b.J0(d2Var, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
            } else if (view.getId() == R.id.image_user || view.getId() == R.id.pendant_image_user) {
                this.f27234b.J0(d2Var, "c10241");
            } else if (view.getId() == R.id.card_divider_tv) {
                c.a.r0.w0.n2.l.a(this.f27234b.z, d2Var.getRecomReason());
            }
            if (view.getId() != R.id.card_home_page_normal_thread_user_name && !(view instanceof HeadImageView) && !(view instanceof HeadPendantView)) {
                if (view.getId() == R.id.frame_video) {
                    c.a.r0.w0.k2.a.e(d2Var, 4, this.f27234b.f2962i, this.f27234b.z, this.f27234b.i0());
                    if (this.f27234b.n == null || this.f27234b.n.getForum() == null) {
                        return;
                    }
                    c.a.r0.w0.k2.a.c(d2Var, this.f27234b.n.getForum().getId());
                    return;
                } else if (view.getId() == R.id.thread_info_commont_container) {
                    c.a.r0.w0.k2.a.e(d2Var, 5, this.f27234b.f2962i, this.f27234b.z, this.f27234b.i0());
                    if (this.f27234b.n == null || this.f27234b.n.getForum() == null) {
                        return;
                    }
                    c.a.r0.w0.k2.a.c(d2Var, this.f27234b.n.getForum().getId());
                    return;
                } else {
                    c.a.r0.w0.k2.a.e(d2Var, 1, this.f27234b.f2962i, this.f27234b.z, this.f27234b.i0());
                    if (this.f27234b.n == null || this.f27234b.n.getForum() == null) {
                        return;
                    }
                    c.a.r0.w0.k2.a.c(d2Var, this.f27234b.n.getForum().getId());
                    return;
                }
            }
            c.a.r0.w0.k2.a.e(d2Var, 2, this.f27234b.f2962i, this.f27234b.z, this.f27234b.i0());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-152647208, "Lc/a/r0/w0/n1/d/o;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-152647208, "Lc/a/r0/w0/n1/d/o;");
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
        this.z = new c.a.r0.w0.k2.b();
        this.A = new a(this);
        this.x = tbPageContext;
    }

    public final void J0(d2 d2Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, d2Var, str) == null) || d2Var == null) {
            return;
        }
        int h0 = d2Var.h0();
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_locate", K0(h0));
        statisticItem.param("tid", d2Var.s1());
        statisticItem.param("obj_type", 2);
        TiebaStatic.log(statisticItem);
    }

    public final String K0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? i2 == B ? "3" : i2 == C ? "10" : i2 == D ? "11" : "" : (String) invokeI.objValue;
    }

    public final c.a.r0.p2.o L0(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var)) == null) {
            if (d2Var != null) {
                c.a.r0.p2.o oVar = new c.a.r0.p2.o();
                oVar.f23822a = K0(d2Var.h0());
                oVar.f23825d = this.z.f26961c;
                oVar.f23824c = d2Var.s1();
                oVar.l = d2Var.Z0;
                if (d2Var.q1() != null) {
                    oVar.m = d2Var.q1().video_md5;
                }
                d2Var.M4();
                return oVar;
            }
            return null;
        }
        return (c.a.r0.p2.o) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: M0 */
    public FrsCardVideoViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            c.a.r0.w0.n1.g.b bVar = new c.a.r0.w0.n1.g.b(this.x, this.f2962i);
            bVar.a0(this.f2962i);
            bVar.a(this.y);
            return new FrsCardVideoViewHolder(bVar);
        }
        return (FrsCardVideoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.w0.k, c.a.e.l.e.a
    /* renamed from: N0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c2 c2Var, FrsCardVideoViewHolder frsCardVideoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, c2Var, frsCardVideoViewHolder})) == null) {
            if (frsCardVideoViewHolder == null || frsCardVideoViewHolder.getCardView() == null) {
                return null;
            }
            frsCardVideoViewHolder.getCardView().g0(L0(c2Var.w));
            frsCardVideoViewHolder.getCardView().k(c2Var.w);
            frsCardVideoViewHolder.getCardView().m(this.A);
            c.a.r0.w0.k2.a.m(c2Var.w, this.f2962i, this.z, i0());
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null) {
                c.a.r0.w0.k2.a.l(c2Var.w, this.n.getForum().getId());
            }
            return frsCardVideoViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.r0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.y = str;
        }
    }

    @Override // c.a.r0.w0.k2.d
    public c.a.r0.w0.k2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.z : (c.a.r0.w0.k2.b) invokeV.objValue;
    }

    @Override // c.a.r0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
        }
    }
}
