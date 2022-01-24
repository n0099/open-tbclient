package c.a.t0.a3.u;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.s0.s.q.e2;
import c.a.t0.a3.g;
import c.a.t0.a3.t;
import c.a.t0.i2.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f15298b;

    /* renamed from: c  reason: collision with root package name */
    public long f15299c;

    /* renamed from: d  reason: collision with root package name */
    public e2 f15300d;

    /* renamed from: e  reason: collision with root package name */
    public t f15301e;

    /* renamed from: f  reason: collision with root package name */
    public String f15302f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15303g;

    /* renamed from: h  reason: collision with root package name */
    public j f15304h;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.f15298b = 0L;
        this.f15302f = "1";
        this.f15304h = new j();
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long j2 = this.f15299c;
            float f2 = ((float) this.a) / ((float) j2);
            return j2 <= 60000 ? ((double) f2) >= 0.9d : j2 <= 180000 ? ((double) f2) >= 0.8d : j2 <= 600000 ? ((double) f2) >= 0.7d : ((double) f2) >= 0.6d;
        }
        return invokeV.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15302f : (String) invokeV.objValue;
    }

    public t c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15301e : (t) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f15298b <= 0) {
            return;
        }
        this.a += System.currentTimeMillis() - this.f15298b;
        this.f15298b = 0L;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f15298b > 0) {
                this.a += System.currentTimeMillis() - this.f15298b;
                this.f15298b = 0L;
            }
            this.f15303g = false;
        }
    }

    public void f(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.f15304h.d(gVar);
        }
    }

    public void g(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            this.f15299c = j2;
            this.f15304h.c();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f15304h.e();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f15298b != 0) {
                this.a += System.currentTimeMillis() - this.f15298b;
            }
            this.f15298b = System.currentTimeMillis();
            this.f15303g = true;
            this.f15304h.b();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f15298b > 0) {
                this.a += System.currentTimeMillis() - this.f15298b;
                this.f15298b = 0L;
            }
            k();
            this.a = 0L;
            this.f15298b = 0L;
            this.f15303g = false;
            this.f15304h.a();
        }
    }

    public final void k() {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            long j2 = this.a;
            if (j2 < 0 || j2 >= 86400000) {
                return;
            }
            if (j2 > 0) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                statisticItem.param(TiebaStatic.Params.OBJ_DURATION, this.a);
                statisticItem.param("obj_type", this.f15302f);
                statisticItem.param("playduration", this.f15299c);
                statisticItem.param("player_type", 1);
                statisticItem.param("is_finish", a() ? 1 : 0);
                if (!m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem.param("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                t tVar = this.f15301e;
                if (tVar != null) {
                    tVar.a(statisticItem);
                }
                if (!statisticItem.hasParam(TiebaStatic.Params.OBJ_PARAM5) && (e2Var = this.f15300d) != null) {
                    if (e2Var.L() != null) {
                        if (this.f15300d.L().oriUgcType == 2) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                        } else if (this.f15300d.L().oriUgcType == 4) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                        }
                    } else {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                    }
                }
                e2 e2Var2 = this.f15300d;
                if (e2Var2 != null) {
                    statisticItem.param(TiebaStatic.Params.IS_ZP, e2Var2.N2() ? 1 : 0);
                }
                TiebaStatic.log(statisticItem);
                c.a.t0.a3.j.d(this.a, this.f15302f, this.f15301e, "", this.f15299c);
            } else if (this.f15303g) {
                c.a.t0.a3.j.d(j2, this.f15302f, this.f15301e, "", this.f15299c);
            }
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f15302f = str;
        }
    }

    public void m(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, e2Var) == null) {
            this.f15300d = e2Var;
        }
    }

    public void n(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, tVar) == null) {
            this.f15301e = tVar;
        }
    }
}
