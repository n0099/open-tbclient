package c.a.s0.g0.f0;

import androidx.core.view.InputDeviceCompat;
import c.a.r0.s.r.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.videoPreload.IVideoData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class l extends b implements IVideoData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId Z;
    public static String a0;
    public static String b0;
    public static String c0;
    public static String d0;
    public static String e0;
    public static String f0;
    public static String g0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean W;
    public boolean X;
    public int Y;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-304051046, "Lc/a/s0/g0/f0/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-304051046, "Lc/a/s0/g0/f0/l;");
                return;
            }
        }
        Z = BdUniqueId.gen();
        a0 = "";
        b0 = "";
        c0 = "";
        d0 = "";
        g0 = "";
    }

    public l(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.W = false;
        this.X = true;
        this.Y = 0;
        this.f17727e = d2Var;
    }

    public static boolean T(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, d2Var)) == null) ? (d2Var == null || d2Var.t1() == null) ? false : true : invokeL.booleanValue;
    }

    @Override // c.a.s0.g0.f0.b
    public StatisticItem B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = 1;
            StatisticItem y = y(c0, true);
            if (y != null && getThreadData() != null) {
                d2 threadData = getThreadData();
                y.param("obj_name", (threadData.y1() == null || (threadData.y1().M() == null && threadData.y1().Y() == null)) ? 0 : 1);
                if (threadData.J() != null) {
                    y.param(TiebaStatic.Params.AB_TYPE, threadData.J().hadConcerned() ? 1 : 0);
                }
                if (threadData.L() != null) {
                    y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                    y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                }
                y.param(TiebaStatic.Params.OBJ_PARAM5, U(threadData));
                if (threadData.N1()) {
                    y.param(TiebaStatic.Params.OBJ_TO, 2);
                } else {
                    y.param(TiebaStatic.Params.OBJ_TO, 1);
                }
                if (threadData.J() != null && threadData.J().getAlaInfo() != null) {
                    int calculateLiveType = YYLiveUtil.calculateLiveType(threadData.J().getAlaInfo());
                    if (threadData.J().getAlaInfo().live_status != 1 && threadData.J().getAlaInfo().friendRoomStatus != 2) {
                        i2 = 2;
                    }
                    if (threadData.J().getAlaInfo().mYyExtData != null) {
                        TiebaStaticHelper.addYYParam(y, threadData.J().getAlaInfo().mYyExtData);
                    }
                    y.param(TiebaStatic.Params.OBJ_PARAM7, i2);
                    y.param(TiebaStatic.Params.OBJ_PARAM8, calculateLiveType);
                }
            }
            return y;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // c.a.s0.g0.f0.b
    public StatisticItem D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StatisticItem y = y(d0, true);
            if (getThreadData() != null) {
                d2 threadData = getThreadData();
                if (threadData.L() != null) {
                    y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                    y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                }
                y.param(TiebaStatic.Params.OBJ_PARAM5, U(threadData));
                y.param("nid", threadData.G0());
            }
            return y;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // c.a.s0.g0.f0.b
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public StatisticItem P(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, d2Var)) == null) ? Q(d2Var, -1) : (StatisticItem) invokeL.objValue;
    }

    public StatisticItem Q(d2 d2Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, d2Var, i2)) == null) {
            StatisticItem y = y(d0, true);
            if (y != null) {
                if (i2 != -1) {
                    y.param(TiebaStatic.Params.CLICK_LOCATE, i2);
                }
                if (getThreadData() != null) {
                    d2 threadData = getThreadData();
                    if (threadData.L() != null) {
                        y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                        y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                    }
                    y.param(TiebaStatic.Params.OBJ_PARAM5, U(threadData));
                }
            }
            return y;
        }
        return (StatisticItem) invokeLI.objValue;
    }

    public StatisticItem R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StatisticItem y = y(g0, true);
            if (y != null && getThreadData() != null) {
                d2 threadData = getThreadData();
                if (threadData.L() != null) {
                    y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                    y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                }
                y.param(TiebaStatic.Params.OBJ_PARAM5, U(threadData));
            }
            return y;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public StatisticItem S(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, d2Var)) == null) {
            StatisticItem y = y(a0, true);
            if (y != null && getThreadData() != null) {
                d2 threadData = getThreadData();
                if (threadData.L() != null) {
                    y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                    y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                    if (threadData.N1()) {
                        y.param(TiebaStatic.Params.OBJ_PARAM2, 2);
                    } else {
                        y.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                    }
                }
                if (threadData.J() != null && threadData.J().getAlaInfo() != null) {
                    int calculateLiveType = YYLiveUtil.calculateLiveType(threadData.J().getAlaInfo());
                    if (threadData.J().getAlaInfo().mYyExtData != null) {
                        TiebaStaticHelper.addYYParam(y, threadData.J().getAlaInfo().mYyExtData);
                    }
                    y.param(TiebaStatic.Params.OBJ_PARAM7, calculateLiveType);
                }
                y.param(TiebaStatic.Params.OBJ_PARAM5, U(threadData));
            }
            return y;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public int U(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, d2Var)) == null) {
            if (d2Var == null) {
                return 1;
            }
            if (d2Var.R1() || d2Var.Q1()) {
                return 2;
            }
            return (d2Var.P1() || d2Var.S1()) ? 3 : 1;
        }
        return invokeL.intValue;
    }

    @Override // c.a.r0.s.r.a
    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            d2 d2Var = this.f17727e;
            if (d2Var == null) {
                return null;
            }
            return d2Var.d1;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.s0.g0.f0.b, c.a.r0.s.r.a
    public d2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            d2 d2Var = this.f17727e;
            if (d2Var == null) {
                return null;
            }
            if (d2Var.W0() != 5) {
                this.f17727e.s4(1);
            }
            return this.f17727e;
        }
        return (d2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            d2 d2Var = this.f17727e;
            if (d2Var == null) {
                return k.v0;
            }
            if (this.G) {
                if (this.s) {
                    return d2.h3;
                }
                return d2Var.getType();
            } else if (this.r) {
                return k.F0;
            } else {
                if (this.x) {
                    return Z;
                }
                if (this.F) {
                    return k.M0;
                }
                if (this.D) {
                    return k.O0;
                }
                if (this.C) {
                    return k.N0;
                }
                if (this.s) {
                    return k.G0;
                }
                if (this.z) {
                    return k.P0;
                }
                if (this.A) {
                    return k.Q0;
                }
                if (this.B) {
                    return k.R0;
                }
                if (this.E) {
                    return k.S0;
                }
                return Z;
            }
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoData
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            d2 d2Var = this.f17727e;
            if (d2Var == null || d2Var.t1() == null || this.f17727e.t1().video_url == null) {
                return null;
            }
            return this.f17727e.t1().video_url;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.s0.g0.f0.b
    public StatisticItem i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            d2 d2Var = this.f17727e;
            if (d2Var != null) {
                statisticItem.param("fid", d2Var.U());
                statisticItem.param("tid", this.f17727e.v1());
                if (this.f17727e.S1()) {
                    statisticItem.param("obj_type", 8);
                } else if (this.f17727e.R1()) {
                    statisticItem.param("obj_type", 9);
                } else if (this.f17727e.H2()) {
                    statisticItem.param("obj_type", 2);
                }
                statisticItem.param("obj_param1", F() ? 2 : 1);
                if (this.f17727e.J() != null) {
                    statisticItem.param("obj_id", this.f17727e.J().getUserId());
                }
            }
            return statisticItem;
        }
        return (StatisticItem) invokeL.objValue;
    }

    @Override // c.a.s0.g0.f0.b
    public StatisticItem o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            StatisticItem y = y(b0, true);
            if (y != null && getThreadData() != null) {
                d2 threadData = getThreadData();
                if (threadData.L() != null) {
                    y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                    y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                }
                y.param(TiebaStatic.Params.OBJ_PARAM5, U(threadData));
            }
            return y;
        }
        return (StatisticItem) invokeV.objValue;
    }
}
