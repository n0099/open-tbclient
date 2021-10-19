package c.a.r0.q2.p;

import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.q0.s.q.d2;
import c.a.r0.a2.j;
import c.a.r0.q2.h;
import c.a.r0.q2.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f24010a;

    /* renamed from: b  reason: collision with root package name */
    public long f24011b;

    /* renamed from: c  reason: collision with root package name */
    public long f24012c;

    /* renamed from: d  reason: collision with root package name */
    public d2 f24013d;

    /* renamed from: e  reason: collision with root package name */
    public o f24014e;

    /* renamed from: f  reason: collision with root package name */
    public String f24015f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f24016g;

    /* renamed from: h  reason: collision with root package name */
    public j f24017h;

    public b() {
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
        this.f24010a = 0L;
        this.f24011b = 0L;
        this.f24015f = "1";
        this.f24017h = new j();
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long j2 = this.f24012c;
            float f2 = ((float) this.f24010a) / ((float) j2);
            return j2 <= 60000 ? ((double) f2) >= 0.9d : j2 <= 180000 ? ((double) f2) >= 0.8d : j2 <= 600000 ? ((double) f2) >= 0.7d : ((double) f2) >= 0.6d;
        }
        return invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f24011b <= 0) {
            return;
        }
        this.f24010a += System.currentTimeMillis() - this.f24011b;
        this.f24011b = 0L;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f24011b > 0) {
                this.f24010a += System.currentTimeMillis() - this.f24011b;
                this.f24011b = 0L;
            }
            this.f24016g = false;
        }
    }

    public void d(TbCyberVideoView tbCyberVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbCyberVideoView) == null) {
            this.f24017h.d(tbCyberVideoView);
        }
    }

    public void e(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            this.f24012c = j2;
            this.f24017h.c();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f24017h.e();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f24011b != 0) {
                this.f24010a += System.currentTimeMillis() - this.f24011b;
            }
            this.f24011b = System.currentTimeMillis();
            this.f24016g = true;
            this.f24017h.b();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f24011b > 0) {
                this.f24010a += System.currentTimeMillis() - this.f24011b;
                this.f24011b = 0L;
            }
            i();
            this.f24010a = 0L;
            this.f24011b = 0L;
            this.f24016g = false;
            this.f24017h.a();
        }
    }

    public final void i() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            long j2 = this.f24010a;
            if (j2 < 0 || j2 >= 86400000) {
                return;
            }
            if (j2 > 0) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                statisticItem.param(TiebaStatic.Params.OBJ_DURATION, this.f24010a);
                statisticItem.param("obj_type", this.f24015f);
                statisticItem.param("playduration", this.f24012c);
                statisticItem.param("player_type", 1);
                statisticItem.param("is_finish", a() ? 1 : 0);
                if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem.param("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                o oVar = this.f24014e;
                if (oVar != null) {
                    oVar.a(statisticItem);
                }
                if (!statisticItem.hasParam(TiebaStatic.Params.OBJ_PARAM5) && (d2Var = this.f24013d) != null) {
                    if (d2Var.L() != null) {
                        if (this.f24013d.L().oriUgcType == 2) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                        } else if (this.f24013d.L().oriUgcType == 4) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                        }
                    } else {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                    }
                }
                d2 d2Var2 = this.f24013d;
                if (d2Var2 != null) {
                    statisticItem.param(TiebaStatic.Params.IS_ZP, d2Var2.I2() ? 1 : 0);
                }
                TiebaStatic.log(statisticItem);
                h.d(this.f24010a, this.f24015f, this.f24014e, "", this.f24012c);
            } else if (this.f24016g) {
                h.d(j2, this.f24015f, this.f24014e, "", this.f24012c);
            }
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f24015f = str;
        }
    }

    public void k(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, d2Var) == null) {
            this.f24013d = d2Var;
        }
    }

    public void l(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, oVar) == null) {
            this.f24014e = oVar;
        }
    }
}
