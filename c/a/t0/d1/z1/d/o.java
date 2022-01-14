package c.a.t0.d1.z1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.e2;
import c.a.t0.d1.f1;
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
/* loaded from: classes7.dex */
public class o extends c.a.t0.d1.k<d2, FrsCardVideoViewHolder<c.a.t0.d1.z1.g.b>> implements c.a.t0.g0.b0, c.a.t0.d1.w2.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static int B = 5;
    public static int C = 10;
    public static int D = 15;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.t0.g0.d0<e2> A;
    public TbPageContext<?> x;
    public String y;
    public c.a.t0.d1.w2.b z;

    /* loaded from: classes7.dex */
    public class a extends c.a.t0.g0.d0<e2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ o f16952b;

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
            this.f16952b = oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.g0.d0
        /* renamed from: d */
        public void a(View view, e2 e2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, e2Var) == null) || view == null || e2Var == null) {
                return;
            }
            if (view.getId() == f1.frame_video) {
                this.f16952b.B0(e2Var, "c11718");
            } else if (view.getId() == f1.layout_root) {
                this.f16952b.B0(e2Var, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
            } else if (view.getId() == f1.image_user || view.getId() == f1.pendant_image_user) {
                this.f16952b.B0(e2Var, "c10241");
            } else if (view.getId() == f1.card_divider_tv) {
                c.a.t0.d1.z2.n.a(this.f16952b.z, e2Var.getRecomReason());
            }
            if (view.getId() != f1.card_home_page_normal_thread_user_name && !(view instanceof HeadImageView) && !(view instanceof HeadPendantView)) {
                if (view.getId() == f1.frame_video) {
                    c.a.t0.d1.w2.a.e(e2Var, 4, this.f16952b.f3262i, this.f16952b.z, this.f16952b.a0());
                    if (this.f16952b.n == null || this.f16952b.n.getForum() == null) {
                        return;
                    }
                    c.a.t0.d1.w2.a.c(e2Var, this.f16952b.n.getForum().getId());
                    return;
                } else if (view.getId() == f1.thread_info_commont_container) {
                    c.a.t0.d1.w2.a.e(e2Var, 5, this.f16952b.f3262i, this.f16952b.z, this.f16952b.a0());
                    if (this.f16952b.n == null || this.f16952b.n.getForum() == null) {
                        return;
                    }
                    c.a.t0.d1.w2.a.c(e2Var, this.f16952b.n.getForum().getId());
                    return;
                } else {
                    c.a.t0.d1.w2.a.e(e2Var, 1, this.f16952b.f3262i, this.f16952b.z, this.f16952b.a0());
                    if (this.f16952b.n == null || this.f16952b.n.getForum() == null) {
                        return;
                    }
                    c.a.t0.d1.w2.a.c(e2Var, this.f16952b.n.getForum().getId());
                    return;
                }
            }
            c.a.t0.d1.w2.a.e(e2Var, 2, this.f16952b.f3262i, this.f16952b.z, this.f16952b.a0());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1048008806, "Lc/a/t0/d1/z1/d/o;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1048008806, "Lc/a/t0/d1/z1/d/o;");
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
        this.z = new c.a.t0.d1.w2.b();
        this.A = new a(this);
        this.x = tbPageContext;
    }

    public final void B0(e2 e2Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, e2Var, str) == null) || e2Var == null) {
            return;
        }
        int i0 = e2Var.i0();
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_locate", C0(i0));
        statisticItem.param("tid", e2Var.v1());
        statisticItem.param("obj_type", 2);
        TiebaStatic.log(statisticItem);
    }

    public final String C0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? i2 == B ? "3" : i2 == C ? "10" : i2 == D ? "11" : "" : (String) invokeI.objValue;
    }

    public final c.a.t0.z2.t D0(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2Var)) == null) {
            if (e2Var != null) {
                c.a.t0.z2.t tVar = new c.a.t0.z2.t();
                tVar.a = C0(e2Var.i0());
                tVar.f26075d = this.z.f16716c;
                tVar.f26074c = e2Var.v1();
                tVar.l = e2Var.b1;
                if (e2Var.t1() != null) {
                    tVar.m = e2Var.t1().video_md5;
                }
                e2Var.S4();
                return tVar;
            }
            return null;
        }
        return (c.a.t0.z2.t) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: E0 */
    public FrsCardVideoViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            c.a.t0.d1.z1.g.b bVar = new c.a.t0.d1.z1.g.b(this.x, this.f3262i);
            bVar.T(this.f3262i);
            bVar.a(this.y);
            return new FrsCardVideoViewHolder(bVar);
        }
        return (FrsCardVideoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.d1.k, c.a.d.n.e.a
    /* renamed from: F0 */
    public View S(int i2, View view, ViewGroup viewGroup, d2 d2Var, FrsCardVideoViewHolder frsCardVideoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, d2Var, frsCardVideoViewHolder})) == null) {
            if (frsCardVideoViewHolder == null || frsCardVideoViewHolder.getCardView() == null) {
                return null;
            }
            frsCardVideoViewHolder.getCardView().Z(D0(d2Var.w));
            frsCardVideoViewHolder.getCardView().k(d2Var.w);
            frsCardVideoViewHolder.getCardView().m(this.A);
            c.a.t0.d1.w2.a.n(d2Var.w, this.f3262i, this.z, a0());
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null) {
                c.a.t0.d1.w2.a.l(d2Var.w, a0());
                c.a.t0.d1.w2.a.m(d2Var.w, this.n.getForum().getId());
            }
            return frsCardVideoViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.t0.g0.b0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.y = str;
        }
    }

    @Override // c.a.t0.d1.w2.d
    public c.a.t0.d1.w2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.z : (c.a.t0.d1.w2.b) invokeV.objValue;
    }

    @Override // c.a.t0.g0.b0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
        }
    }
}
