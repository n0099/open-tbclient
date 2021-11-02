package b.a.r0.q2.q;

import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.k;
import b.a.q0.s.q.d2;
import b.a.r0.a2.j;
import b.a.r0.q2.h;
import b.a.r0.q2.p;
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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f22894a;

    /* renamed from: b  reason: collision with root package name */
    public long f22895b;

    /* renamed from: c  reason: collision with root package name */
    public long f22896c;

    /* renamed from: d  reason: collision with root package name */
    public d2 f22897d;

    /* renamed from: e  reason: collision with root package name */
    public p f22898e;

    /* renamed from: f  reason: collision with root package name */
    public String f22899f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22900g;

    /* renamed from: h  reason: collision with root package name */
    public j f22901h;

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
        this.f22894a = 0L;
        this.f22895b = 0L;
        this.f22899f = "1";
        this.f22901h = new j();
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long j = this.f22896c;
            float f2 = ((float) this.f22894a) / ((float) j);
            return j <= 60000 ? ((double) f2) >= 0.9d : j <= 180000 ? ((double) f2) >= 0.8d : j <= 600000 ? ((double) f2) >= 0.7d : ((double) f2) >= 0.6d;
        }
        return invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f22895b <= 0) {
            return;
        }
        this.f22894a += System.currentTimeMillis() - this.f22895b;
        this.f22895b = 0L;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f22895b > 0) {
                this.f22894a += System.currentTimeMillis() - this.f22895b;
                this.f22895b = 0L;
            }
            this.f22900g = false;
        }
    }

    public void d(TbCyberVideoView tbCyberVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbCyberVideoView) == null) {
            this.f22901h.d(tbCyberVideoView);
        }
    }

    public void e(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.f22896c = j;
            this.f22901h.c();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f22901h.e();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f22895b != 0) {
                this.f22894a += System.currentTimeMillis() - this.f22895b;
            }
            this.f22895b = System.currentTimeMillis();
            this.f22900g = true;
            this.f22901h.b();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f22895b > 0) {
                this.f22894a += System.currentTimeMillis() - this.f22895b;
                this.f22895b = 0L;
            }
            i();
            this.f22894a = 0L;
            this.f22895b = 0L;
            this.f22900g = false;
            this.f22901h.a();
        }
    }

    public final void i() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            long j = this.f22894a;
            if (j < 0 || j >= 86400000) {
                return;
            }
            if (j > 0) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                statisticItem.param(TiebaStatic.Params.OBJ_DURATION, this.f22894a);
                statisticItem.param("obj_type", this.f22899f);
                statisticItem.param("playduration", this.f22896c);
                statisticItem.param("player_type", 1);
                statisticItem.param("is_finish", a() ? 1 : 0);
                if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem.param("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                p pVar = this.f22898e;
                if (pVar != null) {
                    pVar.a(statisticItem);
                }
                if (!statisticItem.hasParam(TiebaStatic.Params.OBJ_PARAM5) && (d2Var = this.f22897d) != null) {
                    if (d2Var.L() != null) {
                        if (this.f22897d.L().oriUgcType == 2) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                        } else if (this.f22897d.L().oriUgcType == 4) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                        }
                    } else {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                    }
                }
                d2 d2Var2 = this.f22897d;
                if (d2Var2 != null) {
                    statisticItem.param(TiebaStatic.Params.IS_ZP, d2Var2.I2() ? 1 : 0);
                }
                TiebaStatic.log(statisticItem);
                h.d(this.f22894a, this.f22899f, this.f22898e, "", this.f22896c);
            } else if (this.f22900g) {
                h.d(j, this.f22899f, this.f22898e, "", this.f22896c);
            }
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f22899f = str;
        }
    }

    public void k(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, d2Var) == null) {
            this.f22897d = d2Var;
        }
    }

    public void l(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, pVar) == null) {
            this.f22898e = pVar;
        }
    }
}
