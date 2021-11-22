package b.a.r0.b0.f0;

import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.d2;
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
/* loaded from: classes4.dex */
public class l extends b implements IVideoData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId Z;
    public static String a0;
    public static String b0;
    public static String c0;
    public static String i0;
    public static String j0;
    public static String k0;
    public static String l0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean W;
    public boolean X;
    public int Y;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-138768579, "Lb/a/r0/b0/f0/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-138768579, "Lb/a/r0/b0/f0/l;");
                return;
            }
        }
        Z = BdUniqueId.gen();
        a0 = "";
        b0 = "";
        c0 = "";
        i0 = "";
        l0 = "";
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
        this.f16235e = d2Var;
    }

    public static boolean T(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, d2Var)) == null) ? (d2Var == null || d2Var.r1() == null) ? false : true : invokeL.booleanValue;
    }

    @Override // b.a.r0.b0.f0.b
    public StatisticItem B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = 1;
            StatisticItem y = y(c0, true);
            if (y != null && getThreadData() != null) {
                d2 threadData = getThreadData();
                y.param("obj_name", (threadData.w1() == null || (threadData.w1().M() == null && threadData.w1().Y() == null)) ? 0 : 1);
                if (threadData.J() != null) {
                    y.param(TiebaStatic.Params.AB_TYPE, threadData.J().hadConcerned() ? 1 : 0);
                }
                if (threadData.L() != null) {
                    y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                    y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                }
                y.param(TiebaStatic.Params.OBJ_PARAM5, U(threadData));
                if (threadData.M1()) {
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

    @Override // b.a.r0.b0.f0.b
    public StatisticItem D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StatisticItem y = y(i0, true);
            if (getThreadData() != null) {
                d2 threadData = getThreadData();
                if (threadData.L() != null) {
                    y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                    y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                }
                y.param(TiebaStatic.Params.OBJ_PARAM5, U(threadData));
                y.param("nid", threadData.F0());
            }
            return y;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // b.a.r0.b0.f0.b
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
            StatisticItem y = y(i0, true);
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
            StatisticItem y = y(l0, true);
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
                    if (threadData.M1()) {
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
            if (d2Var.Q1() || d2Var.P1()) {
                return 2;
            }
            return (d2Var.O1() || d2Var.R1()) ? 3 : 1;
        }
        return invokeL.intValue;
    }

    @Override // b.a.q0.s.q.a
    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            d2 d2Var = this.f16235e;
            if (d2Var == null) {
                return null;
            }
            return d2Var.b1;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.r0.b0.f0.b, b.a.q0.s.q.a
    public d2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            d2 d2Var = this.f16235e;
            if (d2Var == null) {
                return null;
            }
            if (d2Var.V0() != 5) {
                this.f16235e.q4(1);
            }
            return this.f16235e;
        }
        return (d2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, b.a.e.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            d2 d2Var = this.f16235e;
            if (d2Var == null) {
                return k.u0;
            }
            if (this.G) {
                if (this.s) {
                    return d2.c3;
                }
                return d2Var.getType();
            } else if (this.r) {
                return k.E0;
            } else {
                if (this.x) {
                    return Z;
                }
                if (this.F) {
                    return k.L0;
                }
                if (this.D) {
                    return k.N0;
                }
                if (this.C) {
                    return k.M0;
                }
                if (this.s) {
                    return k.F0;
                }
                if (this.z) {
                    return k.O0;
                }
                if (this.A) {
                    return k.P0;
                }
                if (this.B) {
                    return k.Q0;
                }
                if (this.E) {
                    return k.R0;
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
            d2 d2Var = this.f16235e;
            if (d2Var == null || d2Var.r1() == null || this.f16235e.r1().video_url == null) {
                return null;
            }
            return this.f16235e.r1().video_url;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.r0.b0.f0.b
    public StatisticItem i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            d2 d2Var = this.f16235e;
            if (d2Var != null) {
                statisticItem.param("fid", d2Var.T());
                statisticItem.param("tid", this.f16235e.t1());
                if (this.f16235e.R1()) {
                    statisticItem.param("obj_type", 8);
                } else if (this.f16235e.Q1()) {
                    statisticItem.param("obj_type", 9);
                } else if (this.f16235e.G2()) {
                    statisticItem.param("obj_type", 2);
                }
                statisticItem.param("obj_param1", F() ? 2 : 1);
                if (this.f16235e.J() != null) {
                    statisticItem.param("obj_id", this.f16235e.J().getUserId());
                }
            }
            return statisticItem;
        }
        return (StatisticItem) invokeL.objValue;
    }

    @Override // b.a.r0.b0.f0.b
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
