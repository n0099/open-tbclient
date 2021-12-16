package c.a.s0.z2.q;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.r0.s.r.d2;
import c.a.s0.h2.j;
import c.a.s0.z2.h;
import c.a.s0.z2.p;
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
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f26417b;

    /* renamed from: c  reason: collision with root package name */
    public long f26418c;

    /* renamed from: d  reason: collision with root package name */
    public d2 f26419d;

    /* renamed from: e  reason: collision with root package name */
    public p f26420e;

    /* renamed from: f  reason: collision with root package name */
    public String f26421f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26422g;

    /* renamed from: h  reason: collision with root package name */
    public j f26423h;

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
        this.a = 0L;
        this.f26417b = 0L;
        this.f26421f = "1";
        this.f26423h = new j();
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long j2 = this.f26418c;
            float f2 = ((float) this.a) / ((float) j2);
            return j2 <= 60000 ? ((double) f2) >= 0.9d : j2 <= 180000 ? ((double) f2) >= 0.8d : j2 <= 600000 ? ((double) f2) >= 0.7d : ((double) f2) >= 0.6d;
        }
        return invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f26417b <= 0) {
            return;
        }
        this.a += System.currentTimeMillis() - this.f26417b;
        this.f26417b = 0L;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f26417b > 0) {
                this.a += System.currentTimeMillis() - this.f26417b;
                this.f26417b = 0L;
            }
            this.f26422g = false;
        }
    }

    public void d(TbCyberVideoView tbCyberVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbCyberVideoView) == null) {
            this.f26423h.d(tbCyberVideoView);
        }
    }

    public void e(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            this.f26418c = j2;
            this.f26423h.c();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f26423h.e();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f26417b != 0) {
                this.a += System.currentTimeMillis() - this.f26417b;
            }
            this.f26417b = System.currentTimeMillis();
            this.f26422g = true;
            this.f26423h.b();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f26417b > 0) {
                this.a += System.currentTimeMillis() - this.f26417b;
                this.f26417b = 0L;
            }
            i();
            this.a = 0L;
            this.f26417b = 0L;
            this.f26422g = false;
            this.f26423h.a();
        }
    }

    public final void i() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            long j2 = this.a;
            if (j2 < 0 || j2 >= 86400000) {
                return;
            }
            if (j2 > 0) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                statisticItem.param(TiebaStatic.Params.OBJ_DURATION, this.a);
                statisticItem.param("obj_type", this.f26421f);
                statisticItem.param("playduration", this.f26418c);
                statisticItem.param("player_type", 1);
                statisticItem.param("is_finish", a() ? 1 : 0);
                if (!l.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem.param("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                p pVar = this.f26420e;
                if (pVar != null) {
                    pVar.a(statisticItem);
                }
                if (!statisticItem.hasParam(TiebaStatic.Params.OBJ_PARAM5) && (d2Var = this.f26419d) != null) {
                    if (d2Var.L() != null) {
                        if (this.f26419d.L().oriUgcType == 2) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                        } else if (this.f26419d.L().oriUgcType == 4) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                        }
                    } else {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                    }
                }
                d2 d2Var2 = this.f26419d;
                if (d2Var2 != null) {
                    statisticItem.param(TiebaStatic.Params.IS_ZP, d2Var2.M2() ? 1 : 0);
                }
                TiebaStatic.log(statisticItem);
                h.d(this.a, this.f26421f, this.f26420e, "", this.f26418c);
            } else if (this.f26422g) {
                h.d(j2, this.f26421f, this.f26420e, "", this.f26418c);
            }
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f26421f = str;
        }
    }

    public void k(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, d2Var) == null) {
            this.f26419d = d2Var;
        }
    }

    public void l(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, pVar) == null) {
            this.f26420e = pVar;
        }
    }
}
