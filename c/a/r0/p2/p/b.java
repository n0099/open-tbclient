package c.a.r0.p2.p;

import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.q0.s.q.d2;
import c.a.r0.p2.h;
import c.a.r0.p2.o;
import c.a.r0.z1.j;
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
    public long f23835a;

    /* renamed from: b  reason: collision with root package name */
    public long f23836b;

    /* renamed from: c  reason: collision with root package name */
    public long f23837c;

    /* renamed from: d  reason: collision with root package name */
    public d2 f23838d;

    /* renamed from: e  reason: collision with root package name */
    public o f23839e;

    /* renamed from: f  reason: collision with root package name */
    public String f23840f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23841g;

    /* renamed from: h  reason: collision with root package name */
    public j f23842h;

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
        this.f23835a = 0L;
        this.f23836b = 0L;
        this.f23840f = "1";
        this.f23842h = new j();
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long j2 = this.f23837c;
            float f2 = ((float) this.f23835a) / ((float) j2);
            return j2 <= 60000 ? ((double) f2) >= 0.9d : j2 <= 180000 ? ((double) f2) >= 0.8d : j2 <= 600000 ? ((double) f2) >= 0.7d : ((double) f2) >= 0.6d;
        }
        return invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f23836b <= 0) {
            return;
        }
        this.f23835a += System.currentTimeMillis() - this.f23836b;
        this.f23836b = 0L;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f23836b > 0) {
                this.f23835a += System.currentTimeMillis() - this.f23836b;
                this.f23836b = 0L;
            }
            this.f23841g = false;
        }
    }

    public void d(TbCyberVideoView tbCyberVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbCyberVideoView) == null) {
            this.f23842h.d(tbCyberVideoView);
        }
    }

    public void e(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            this.f23837c = j2;
            this.f23842h.c();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f23842h.e();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f23836b != 0) {
                this.f23835a += System.currentTimeMillis() - this.f23836b;
            }
            this.f23836b = System.currentTimeMillis();
            this.f23841g = true;
            this.f23842h.b();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f23836b > 0) {
                this.f23835a += System.currentTimeMillis() - this.f23836b;
                this.f23836b = 0L;
            }
            i();
            this.f23835a = 0L;
            this.f23836b = 0L;
            this.f23841g = false;
            this.f23842h.a();
        }
    }

    public final void i() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            long j2 = this.f23835a;
            if (j2 < 0 || j2 >= 86400000) {
                return;
            }
            if (j2 > 0) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                statisticItem.param(TiebaStatic.Params.OBJ_DURATION, this.f23835a);
                statisticItem.param("obj_type", this.f23840f);
                statisticItem.param("playduration", this.f23837c);
                statisticItem.param("player_type", 1);
                statisticItem.param("is_finish", a() ? 1 : 0);
                if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem.param("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                o oVar = this.f23839e;
                if (oVar != null) {
                    oVar.a(statisticItem);
                }
                if (!statisticItem.hasParam(TiebaStatic.Params.OBJ_PARAM5) && (d2Var = this.f23838d) != null) {
                    if (d2Var.L() != null) {
                        if (this.f23838d.L().oriUgcType == 2) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                        } else if (this.f23838d.L().oriUgcType == 4) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                        }
                    } else {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                    }
                }
                d2 d2Var2 = this.f23838d;
                if (d2Var2 != null) {
                    statisticItem.param(TiebaStatic.Params.IS_ZP, d2Var2.I2() ? 1 : 0);
                }
                TiebaStatic.log(statisticItem);
                h.d(this.f23835a, this.f23840f, this.f23839e, "", this.f23837c);
            } else if (this.f23841g) {
                h.d(j2, this.f23840f, this.f23839e, "", this.f23837c);
            }
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f23840f = str;
        }
    }

    public void k(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, d2Var) == null) {
            this.f23838d = d2Var;
        }
    }

    public void l(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, oVar) == null) {
            this.f23839e = oVar;
        }
    }
}
