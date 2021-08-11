package c.a.p0.o2.p;

import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.o0.s.q.c2;
import c.a.p0.o2.h;
import c.a.p0.o2.o;
import c.a.p0.y1.j;
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
import com.bytedance.sdk.openadsdk.TTAdConstant;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f22897a;

    /* renamed from: b  reason: collision with root package name */
    public long f22898b;

    /* renamed from: c  reason: collision with root package name */
    public long f22899c;

    /* renamed from: d  reason: collision with root package name */
    public c2 f22900d;

    /* renamed from: e  reason: collision with root package name */
    public o f22901e;

    /* renamed from: f  reason: collision with root package name */
    public String f22902f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22903g;

    /* renamed from: h  reason: collision with root package name */
    public j f22904h;

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
        this.f22897a = 0L;
        this.f22898b = 0L;
        this.f22902f = "1";
        this.f22904h = new j();
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long j2 = this.f22899c;
            float f2 = ((float) this.f22897a) / ((float) j2);
            return j2 <= 60000 ? ((double) f2) >= 0.9d : j2 <= 180000 ? ((double) f2) >= 0.8d : j2 <= TTAdConstant.AD_MAX_EVENT_TIME ? ((double) f2) >= 0.7d : ((double) f2) >= 0.6d;
        }
        return invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f22898b <= 0) {
            return;
        }
        this.f22897a += System.currentTimeMillis() - this.f22898b;
        this.f22898b = 0L;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f22898b > 0) {
                this.f22897a += System.currentTimeMillis() - this.f22898b;
                this.f22898b = 0L;
            }
            this.f22903g = false;
        }
    }

    public void d(TbCyberVideoView tbCyberVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbCyberVideoView) == null) {
            this.f22904h.d(tbCyberVideoView);
        }
    }

    public void e(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            this.f22899c = j2;
            this.f22904h.c();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f22904h.e();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f22898b != 0) {
                this.f22897a += System.currentTimeMillis() - this.f22898b;
            }
            this.f22898b = System.currentTimeMillis();
            this.f22903g = true;
            this.f22904h.b();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f22898b > 0) {
                this.f22897a += System.currentTimeMillis() - this.f22898b;
                this.f22898b = 0L;
            }
            i();
            this.f22897a = 0L;
            this.f22898b = 0L;
            this.f22903g = false;
            this.f22904h.a();
        }
    }

    public final void i() {
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            long j2 = this.f22897a;
            if (j2 < 0 || j2 >= 86400000) {
                return;
            }
            if (j2 > 0) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                statisticItem.param(TiebaStatic.Params.OBJ_DURATION, this.f22897a);
                statisticItem.param("obj_type", this.f22902f);
                statisticItem.param("playduration", this.f22899c);
                statisticItem.param("player_type", 1);
                statisticItem.param("is_finish", a() ? 1 : 0);
                if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem.param("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                o oVar = this.f22901e;
                if (oVar != null) {
                    oVar.a(statisticItem);
                }
                if (!statisticItem.hasParam(TiebaStatic.Params.OBJ_PARAM5) && (c2Var = this.f22900d) != null) {
                    if (c2Var.L() != null) {
                        if (this.f22900d.L().oriUgcType == 2) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                        } else if (this.f22900d.L().oriUgcType == 4) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                        }
                    } else {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                    }
                }
                c2 c2Var2 = this.f22900d;
                if (c2Var2 != null) {
                    statisticItem.param(TiebaStatic.Params.IS_ZP, c2Var2.E2() ? 1 : 0);
                }
                TiebaStatic.log(statisticItem);
                h.d(this.f22897a, this.f22902f, this.f22901e, "", this.f22899c);
            } else if (this.f22903g) {
                h.d(j2, this.f22902f, this.f22901e, "", this.f22899c);
            }
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f22902f = str;
        }
    }

    public void k(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, c2Var) == null) {
            this.f22900d = c2Var;
        }
    }

    public void l(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, oVar) == null) {
            this.f22901e = oVar;
        }
    }
}
