package c.a.r0.a3.u;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.q0.r.r.e2;
import c.a.r0.a3.g;
import c.a.r0.a3.t;
import c.a.r0.j2.j;
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
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f14950b;

    /* renamed from: c  reason: collision with root package name */
    public long f14951c;

    /* renamed from: d  reason: collision with root package name */
    public e2 f14952d;

    /* renamed from: e  reason: collision with root package name */
    public t f14953e;

    /* renamed from: f  reason: collision with root package name */
    public String f14954f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14955g;

    /* renamed from: h  reason: collision with root package name */
    public j f14956h;

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
        this.f14950b = 0L;
        this.f14954f = "1";
        this.f14956h = new j();
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long j2 = this.f14951c;
            float f2 = ((float) this.a) / ((float) j2);
            return j2 <= 60000 ? ((double) f2) >= 0.9d : j2 <= 180000 ? ((double) f2) >= 0.8d : j2 <= 600000 ? ((double) f2) >= 0.7d : ((double) f2) >= 0.6d;
        }
        return invokeV.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14954f : (String) invokeV.objValue;
    }

    public t c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14953e : (t) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f14950b <= 0) {
            return;
        }
        this.a += System.currentTimeMillis() - this.f14950b;
        this.f14950b = 0L;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f14950b > 0) {
                this.a += System.currentTimeMillis() - this.f14950b;
                this.f14950b = 0L;
            }
            this.f14955g = false;
        }
    }

    public void f(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.f14956h.d(gVar);
        }
    }

    public void g(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            this.f14951c = j2;
            this.f14956h.c();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f14956h.e();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f14950b != 0) {
                this.a += System.currentTimeMillis() - this.f14950b;
            }
            this.f14950b = System.currentTimeMillis();
            this.f14955g = true;
            this.f14956h.b();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f14950b > 0) {
                this.a += System.currentTimeMillis() - this.f14950b;
                this.f14950b = 0L;
            }
            k();
            this.a = 0L;
            this.f14950b = 0L;
            this.f14955g = false;
            this.f14956h.a();
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
                statisticItem.param("obj_type", this.f14954f);
                statisticItem.param("playduration", this.f14951c);
                statisticItem.param("player_type", 1);
                statisticItem.param("is_finish", a() ? 1 : 0);
                if (!m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem.param("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                t tVar = this.f14953e;
                if (tVar != null) {
                    tVar.a(statisticItem);
                }
                if (!statisticItem.hasParam(TiebaStatic.Params.OBJ_PARAM5) && (e2Var = this.f14952d) != null) {
                    if (e2Var.L() != null) {
                        if (this.f14952d.L().oriUgcType == 2) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                        } else if (this.f14952d.L().oriUgcType == 4) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                        }
                    } else {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                    }
                }
                e2 e2Var2 = this.f14952d;
                if (e2Var2 != null) {
                    statisticItem.param(TiebaStatic.Params.IS_ZP, e2Var2.N2() ? 1 : 0);
                }
                TiebaStatic.log(statisticItem);
                c.a.r0.a3.j.d(this.a, this.f14954f, this.f14953e, "", this.f14951c);
            } else if (this.f14955g) {
                c.a.r0.a3.j.d(j2, this.f14954f, this.f14953e, "", this.f14951c);
            }
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f14954f = str;
        }
    }

    public void m(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, e2Var) == null) {
            this.f14952d = e2Var;
        }
    }

    public void n(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, tVar) == null) {
            this.f14953e = tVar;
        }
    }
}
