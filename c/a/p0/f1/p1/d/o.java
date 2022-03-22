package c.a.p0.f1.p1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.r.a2;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class o extends c.a.p0.f1.k<a2, FrsCardVideoViewHolder<c.a.p0.f1.p1.g.b>> implements c.a.p0.h0.z, c.a.p0.f1.o2.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static int x = 5;
    public static int y = 10;
    public static int z = 15;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> t;
    public String u;
    public c.a.p0.f1.o2.b v;
    public c.a.p0.h0.b0<ThreadData> w;

    /* loaded from: classes2.dex */
    public class a extends c.a.p0.h0.b0<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ o f14344b;

        public a(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14344b = oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.h0.b0
        /* renamed from: d */
        public void a(View view, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, threadData) == null) || view == null || threadData == null) {
                return;
            }
            if (view.getId() == R.id.obfuscated_res_0x7f090aaf) {
                this.f14344b.A0(threadData, "c11718");
            } else if (view.getId() == R.id.obfuscated_res_0x7f0911f5) {
                this.f14344b.A0(threadData, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
            } else if (view.getId() == R.id.obfuscated_res_0x7f090e85 || view.getId() == R.id.obfuscated_res_0x7f09175d) {
                this.f14344b.A0(threadData, "c10241");
            } else if (view.getId() == R.id.obfuscated_res_0x7f0904f7) {
                c.a.p0.f1.r2.q.a(this.f14344b.v, threadData.getRecomReason());
            }
            if (view.getId() != R.id.obfuscated_res_0x7f090543 && !(view instanceof HeadImageView) && !(view instanceof HeadPendantView)) {
                if (view.getId() == R.id.obfuscated_res_0x7f090aaf) {
                    c.a.p0.f1.o2.a.e(threadData, 4, this.f14344b.f2571e, this.f14344b.v, this.f14344b.a0());
                    if (this.f14344b.j == null || this.f14344b.j.getForum() == null) {
                        return;
                    }
                    c.a.p0.f1.o2.a.c(threadData, this.f14344b.j.getForum().getId());
                    return;
                } else if (view.getId() == R.id.obfuscated_res_0x7f091fac) {
                    c.a.p0.f1.o2.a.e(threadData, 5, this.f14344b.f2571e, this.f14344b.v, this.f14344b.a0());
                    if (this.f14344b.j == null || this.f14344b.j.getForum() == null) {
                        return;
                    }
                    c.a.p0.f1.o2.a.c(threadData, this.f14344b.j.getForum().getId());
                    return;
                } else {
                    c.a.p0.f1.o2.a.e(threadData, 1, this.f14344b.f2571e, this.f14344b.v, this.f14344b.a0());
                    if (this.f14344b.j == null || this.f14344b.j.getForum() == null) {
                        return;
                    }
                    c.a.p0.f1.o2.a.c(threadData, this.f14344b.j.getForum().getId());
                    return;
                }
            }
            c.a.p0.f1.o2.a.e(threadData, 2, this.f14344b.f2571e, this.f14344b.v, this.f14344b.a0());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-552526006, "Lc/a/p0/f1/p1/d/o;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-552526006, "Lc/a/p0/f1/p1/d/o;");
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.v = new c.a.p0.f1.o2.b();
        this.w = new a(this);
        this.t = tbPageContext;
    }

    public final void A0(ThreadData threadData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, threadData, str) == null) || threadData == null) {
            return;
        }
        int insertFloor = threadData.getInsertFloor();
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_locate", B0(insertFloor));
        statisticItem.param("tid", threadData.getTid());
        statisticItem.param("obj_type", 2);
        TiebaStatic.log(statisticItem);
    }

    public final String B0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? i == x ? "3" : i == y ? "10" : i == z ? "11" : "" : (String) invokeI.objValue;
    }

    public final c.a.p0.c3.u C0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) {
            if (threadData != null) {
                c.a.p0.c3.u uVar = new c.a.p0.c3.u();
                uVar.a = B0(threadData.getInsertFloor());
                uVar.f13505d = this.v.f14300c;
                uVar.f13504c = threadData.getTid();
                uVar.l = threadData.mRecomAbTag;
                if (threadData.getThreadVideoInfo() != null) {
                    uVar.m = threadData.getThreadVideoInfo().video_md5;
                }
                threadData.updateShowStatus();
                return uVar;
            }
            return null;
        }
        return (c.a.p0.c3.u) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: D0 */
    public FrsCardVideoViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            c.a.p0.f1.p1.g.b bVar = new c.a.p0.f1.p1.g.b(this.t, this.f2571e);
            bVar.U(this.f2571e);
            bVar.a(this.u);
            return new FrsCardVideoViewHolder(bVar);
        }
        return (FrsCardVideoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.f1.k, c.a.d.o.e.a
    /* renamed from: E0 */
    public View S(int i, View view, ViewGroup viewGroup, a2 a2Var, FrsCardVideoViewHolder frsCardVideoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view, viewGroup, a2Var, frsCardVideoViewHolder})) == null) {
            if (frsCardVideoViewHolder == null || frsCardVideoViewHolder.c() == null) {
                return null;
            }
            frsCardVideoViewHolder.c().a0(C0(a2Var.s));
            frsCardVideoViewHolder.c().l(a2Var.s);
            frsCardVideoViewHolder.c().n(this.w);
            c.a.p0.f1.o2.a.n(a2Var.s, this.f2571e, this.v, a0());
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null) {
                c.a.p0.f1.o2.a.l(a2Var.s, a0());
                c.a.p0.f1.o2.a.m(a2Var.s, this.j.getForum().getId());
            }
            return frsCardVideoViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.p0.h0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.u = str;
        }
    }

    @Override // c.a.p0.f1.o2.d
    public c.a.p0.f1.o2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.v : (c.a.p0.f1.o2.b) invokeV.objValue;
    }

    @Override // c.a.p0.h0.z
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }
}
