package c.a.p0.a0.d0;

import androidx.core.view.InputDeviceCompat;
import c.a.o0.s.q.c2;
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
/* loaded from: classes3.dex */
public class l extends b implements IVideoData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId X;
    public static String Y;
    public static String Z;
    public static String a0;
    public static String b0;
    public static String c0;
    public static String i0;
    public static String j0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean U;
    public boolean V;
    public int W;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1076938725, "Lc/a/p0/a0/d0/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1076938725, "Lc/a/p0/a0/d0/l;");
                return;
            }
        }
        X = BdUniqueId.gen();
        Y = "";
        Z = "";
        a0 = "";
        b0 = "";
        j0 = "";
    }

    public l(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.U = false;
        this.V = true;
        this.W = 0;
        this.f14959e = c2Var;
    }

    public static boolean T(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, c2Var)) == null) ? (c2Var == null || c2Var.o1() == null) ? false : true : invokeL.booleanValue;
    }

    @Override // c.a.p0.a0.d0.b
    public StatisticItem B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = 1;
            StatisticItem y = y(a0, true);
            if (y != null && getThreadData() != null) {
                c2 threadData = getThreadData();
                y.param("obj_name", (threadData.t1() == null || (threadData.t1().K() == null && threadData.t1().V() == null)) ? 0 : 1);
                if (threadData.J() != null) {
                    y.param(TiebaStatic.Params.AB_TYPE, threadData.J().hadConcerned() ? 1 : 0);
                }
                if (threadData.L() != null) {
                    y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                    y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                }
                y.param(TiebaStatic.Params.OBJ_PARAM5, U(threadData));
                if (threadData.H1()) {
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

    @Override // c.a.p0.a0.d0.b
    public StatisticItem D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StatisticItem y = y(b0, true);
            if (getThreadData() != null) {
                c2 threadData = getThreadData();
                if (threadData.L() != null) {
                    y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                    y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                }
                y.param(TiebaStatic.Params.OBJ_PARAM5, U(threadData));
                y.param("nid", threadData.D0());
            }
            return y;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // c.a.p0.a0.d0.b
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public StatisticItem P(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, c2Var)) == null) ? Q(c2Var, -1) : (StatisticItem) invokeL.objValue;
    }

    public StatisticItem Q(c2 c2Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, c2Var, i2)) == null) {
            StatisticItem y = y(b0, true);
            if (y != null) {
                if (i2 != -1) {
                    y.param(TiebaStatic.Params.CLICK_LOCATE, i2);
                }
                if (getThreadData() != null) {
                    c2 threadData = getThreadData();
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
            StatisticItem y = y(j0, true);
            if (y != null && getThreadData() != null) {
                c2 threadData = getThreadData();
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

    public StatisticItem S(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, c2Var)) == null) {
            StatisticItem y = y(Y, true);
            if (y != null && getThreadData() != null) {
                c2 threadData = getThreadData();
                if (threadData.L() != null) {
                    y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                    y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                    if (threadData.H1()) {
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

    public int U(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, c2Var)) == null) {
            if (c2Var == null) {
                return 1;
            }
            if (c2Var.L1() || c2Var.K1()) {
                return 2;
            }
            return (c2Var.J1() || c2Var.M1()) ? 3 : 1;
        }
        return invokeL.intValue;
    }

    @Override // c.a.o0.s.q.a
    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c2 c2Var = this.f14959e;
            if (c2Var == null) {
                return null;
            }
            return c2Var.Y0;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.p0.a0.d0.b, c.a.o0.s.q.a
    public c2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c2 c2Var = this.f14959e;
            if (c2Var == null) {
                return null;
            }
            if (c2Var.T0() != 5) {
                this.f14959e.e4(1);
            }
            return this.f14959e;
        }
        return (c2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.e.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            c2 c2Var = this.f14959e;
            if (c2Var == null) {
                return k.s0;
            }
            if (this.F) {
                if (this.s) {
                    return c2.X2;
                }
                return c2Var.getType();
            } else if (this.r) {
                return k.C0;
            } else {
                if (this.x) {
                    return X;
                }
                if (this.E) {
                    return k.I0;
                }
                if (this.C) {
                    return k.K0;
                }
                if (this.B) {
                    return k.J0;
                }
                if (this.s) {
                    return k.D0;
                }
                if (this.y) {
                    return k.L0;
                }
                if (this.z) {
                    return k.M0;
                }
                if (this.A) {
                    return k.N0;
                }
                if (this.D) {
                    return k.O0;
                }
                return X;
            }
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoData
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            c2 c2Var = this.f14959e;
            if (c2Var == null || c2Var.o1() == null || this.f14959e.o1().video_url == null) {
                return null;
            }
            return this.f14959e.o1().video_url;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.p0.a0.d0.b
    public StatisticItem i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            c2 c2Var = this.f14959e;
            if (c2Var != null) {
                statisticItem.param("fid", c2Var.T());
                statisticItem.param("tid", this.f14959e.q1());
                if (this.f14959e.M1()) {
                    statisticItem.param("obj_type", 8);
                } else if (this.f14959e.L1()) {
                    statisticItem.param("obj_type", 9);
                } else if (this.f14959e.A2()) {
                    statisticItem.param("obj_type", 2);
                }
                statisticItem.param("obj_param1", F() ? 2 : 1);
                if (this.f14959e.J() != null) {
                    statisticItem.param("obj_id", this.f14959e.J().getUserId());
                }
            }
            return statisticItem;
        }
        return (StatisticItem) invokeL.objValue;
    }

    @Override // c.a.p0.a0.d0.b
    public StatisticItem o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            StatisticItem y = y(Z, true);
            if (y != null && getThreadData() != null) {
                c2 threadData = getThreadData();
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
