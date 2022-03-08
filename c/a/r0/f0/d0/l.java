package c.a.r0.f0.d0;

import androidx.core.view.InputDeviceCompat;
import c.a.q0.r.r.e2;
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
/* loaded from: classes2.dex */
public class l extends b implements IVideoData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId Y;
    public static String Z;
    public static String a0;
    public static String b0;
    public static String c0;
    public static String d0;
    public static String e0;
    public static String f0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean V;
    public boolean W;
    public int X;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-251757064, "Lc/a/r0/f0/d0/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-251757064, "Lc/a/r0/f0/d0/l;");
                return;
            }
        }
        Y = BdUniqueId.gen();
        Z = "";
        a0 = "";
        b0 = "";
        c0 = "";
        f0 = "";
    }

    public l(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.V = false;
        this.W = true;
        this.X = 0;
        this.f17272e = e2Var;
    }

    public static boolean S(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, e2Var)) == null) ? (e2Var == null || e2Var.u1() == null) ? false : true : invokeL.booleanValue;
    }

    @Override // c.a.r0.f0.d0.b
    public StatisticItem B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = 1;
            StatisticItem y = y(b0, true);
            if (y != null && getThreadData() != null) {
                e2 threadData = getThreadData();
                y.param("obj_name", (threadData.z1() == null || (threadData.z1().N() == null && threadData.z1().Z() == null)) ? 0 : 1);
                if (threadData.J() != null) {
                    y.param(TiebaStatic.Params.AB_TYPE, threadData.J().hadConcerned() ? 1 : 0);
                }
                if (threadData.L() != null) {
                    y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                    y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                }
                y.param(TiebaStatic.Params.OBJ_PARAM5, T(threadData));
                if (threadData.O1()) {
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

    @Override // c.a.r0.f0.d0.b
    public StatisticItem C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StatisticItem y = y(c0, true);
            if (getThreadData() != null) {
                e2 threadData = getThreadData();
                if (threadData.L() != null) {
                    y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                    y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                }
                y.param(TiebaStatic.Params.OBJ_PARAM5, T(threadData));
                y.param("nid", threadData.H0());
            }
            return y;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // c.a.r0.f0.d0.b
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public StatisticItem O(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, e2Var)) == null) ? P(e2Var, -1) : (StatisticItem) invokeL.objValue;
    }

    public StatisticItem P(e2 e2Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, e2Var, i2)) == null) {
            StatisticItem y = y(c0, true);
            if (y != null) {
                if (i2 != -1) {
                    y.param(TiebaStatic.Params.CLICK_LOCATE, i2);
                }
                if (getThreadData() != null) {
                    e2 threadData = getThreadData();
                    if (threadData.L() != null) {
                        y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                        y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                    }
                    y.param(TiebaStatic.Params.OBJ_PARAM5, T(threadData));
                }
            }
            return y;
        }
        return (StatisticItem) invokeLI.objValue;
    }

    public StatisticItem Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StatisticItem y = y(f0, true);
            if (y != null && getThreadData() != null) {
                e2 threadData = getThreadData();
                if (threadData.L() != null) {
                    y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                    y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                }
                y.param(TiebaStatic.Params.OBJ_PARAM5, T(threadData));
            }
            return y;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public StatisticItem R(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, e2Var)) == null) {
            StatisticItem y = y(Z, true);
            if (y != null && getThreadData() != null) {
                e2 threadData = getThreadData();
                if (threadData.L() != null) {
                    y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                    y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                    if (threadData.O1()) {
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
                y.param(TiebaStatic.Params.OBJ_PARAM5, T(threadData));
            }
            return y;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public int T(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, e2Var)) == null) {
            if (e2Var == null) {
                return 1;
            }
            if (e2Var.S1() || e2Var.R1()) {
                return 2;
            }
            return (e2Var.Q1() || e2Var.T1()) ? 3 : 1;
        }
        return invokeL.intValue;
    }

    @Override // c.a.q0.r.r.a
    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            e2 e2Var = this.f17272e;
            if (e2Var == null) {
                return null;
            }
            return e2Var.d1;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.f0.d0.b, c.a.q0.r.r.a
    public e2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            e2 e2Var = this.f17272e;
            if (e2Var == null) {
                return null;
            }
            if (e2Var.X0() != 5) {
                this.f17272e.t4(1);
            }
            return this.f17272e;
        }
        return (e2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            e2 e2Var = this.f17272e;
            if (e2Var == null) {
                return k.s0;
            }
            if (this.F) {
                if (this.r) {
                    return e2.k3;
                }
                return e2Var.getType();
            } else if (this.q) {
                return k.D0;
            } else {
                if (this.w) {
                    return Y;
                }
                if (this.E) {
                    return k.K0;
                }
                if (this.C) {
                    return k.M0;
                }
                if (this.B) {
                    return k.L0;
                }
                if (this.r) {
                    return k.E0;
                }
                if (this.y) {
                    return k.N0;
                }
                if (this.z) {
                    return k.O0;
                }
                if (this.A) {
                    return k.P0;
                }
                if (this.D) {
                    return k.Q0;
                }
                return Y;
            }
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoData
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            e2 e2Var = this.f17272e;
            if (e2Var == null || e2Var.u1() == null || this.f17272e.u1().video_url == null) {
                return null;
            }
            return this.f17272e.u1().video_url;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.f0.d0.b
    public StatisticItem i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            e2 e2Var = this.f17272e;
            if (e2Var != null) {
                statisticItem.param("fid", e2Var.U());
                statisticItem.param("tid", this.f17272e.w1());
                if (this.f17272e.T1()) {
                    statisticItem.param("obj_type", 8);
                } else if (this.f17272e.S1()) {
                    statisticItem.param("obj_type", 9);
                } else if (this.f17272e.I2()) {
                    statisticItem.param("obj_type", 2);
                }
                statisticItem.param("obj_param1", E() ? 2 : 1);
                if (this.f17272e.J() != null) {
                    statisticItem.param("obj_id", this.f17272e.J().getUserId());
                }
            }
            return statisticItem;
        }
        return (StatisticItem) invokeL.objValue;
    }

    @Override // c.a.r0.f0.d0.b
    public StatisticItem o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            StatisticItem y = y(a0, true);
            if (y != null && getThreadData() != null) {
                e2 threadData = getThreadData();
                if (threadData.L() != null) {
                    y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                    y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                }
                y.param(TiebaStatic.Params.OBJ_PARAM5, T(threadData));
            }
            return y;
        }
        return (StatisticItem) invokeV.objValue;
    }
}
