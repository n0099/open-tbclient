package c.a.t0.g0.f0;

import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SmartApp;
/* loaded from: classes7.dex */
public class k extends b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BdUniqueId A0;
    public static final BdUniqueId B0;
    public static final BdUniqueId C0;
    public static final BdUniqueId D0;
    public static final BdUniqueId E0;
    public static final BdUniqueId F0;
    public static final BdUniqueId G0;
    public static final BdUniqueId H0;
    public static final BdUniqueId I0;
    public static final BdUniqueId J0;
    public static final BdUniqueId K0;
    public static final BdUniqueId L0;
    public static final BdUniqueId M0;
    public static final BdUniqueId N0;
    public static final BdUniqueId O0;
    public static final BdUniqueId P0;
    public static final BdUniqueId Q0;
    public static final BdUniqueId R0;
    public static final BdUniqueId S0;
    public static final BdUniqueId T0;
    public static String Y = "";
    public static String Z = "";
    public static String a0 = "";
    public static String b0 = "";
    public static String c0 = "";
    public static String d0 = "";
    public static String e0 = "";
    public static String f0 = "";
    public static String g0 = "";
    public static String h0 = "";
    public static String i0 = "";
    public static String k0 = "";
    public static String q0 = "";
    public static String r0 = "";
    public static String s0 = "";
    public static String t0 = "";
    public static String u0 = "";
    public static final BdUniqueId v0;
    public static final BdUniqueId w0;
    public static final BdUniqueId x0;
    public static final BdUniqueId y0;
    public static final BdUniqueId z0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean W;
    public boolean X;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2101002436, "Lc/a/t0/g0/f0/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2101002436, "Lc/a/t0/g0/f0/k;");
                return;
            }
        }
        v0 = BdUniqueId.gen();
        w0 = BdUniqueId.gen();
        x0 = BdUniqueId.gen();
        y0 = BdUniqueId.gen();
        z0 = BdUniqueId.gen();
        A0 = BdUniqueId.gen();
        B0 = BdUniqueId.gen();
        C0 = BdUniqueId.gen();
        D0 = BdUniqueId.gen();
        E0 = BdUniqueId.gen();
        F0 = BdUniqueId.gen();
        G0 = BdUniqueId.gen();
        H0 = BdUniqueId.gen();
        I0 = BdUniqueId.gen();
        J0 = BdUniqueId.gen();
        K0 = BdUniqueId.gen();
        L0 = BdUniqueId.gen();
        M0 = BdUniqueId.gen();
        N0 = BdUniqueId.gen();
        O0 = BdUniqueId.gen();
        P0 = BdUniqueId.gen();
        Q0 = BdUniqueId.gen();
        R0 = BdUniqueId.gen();
        S0 = BdUniqueId.gen();
        T0 = BdUniqueId.gen();
    }

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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
    }

    public static boolean Y(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, d2Var)) == null) {
            if (d2Var == null) {
                return false;
            }
            return d2Var.getType() == d2.i3 || d2Var.getType() == d2.F3 || d2Var.getType() == d2.E3 || d2Var.getType() == d2.L3 || d2Var.getType() == d2.Q3;
        }
        return invokeL.booleanValue;
    }

    public static boolean Z(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, d2Var)) == null) {
            if (d2Var == null) {
                return false;
            }
            return d2Var.getType() == d2.S3 || d2Var.getType() == d2.T3;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.t0.g0.f0.b
    public StatisticItem A() {
        InterceptResult invokeV;
        StatisticItem w;
        SmartApp g1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (X()) {
                w = w(e0);
            } else if (W()) {
                StatisticItem w2 = w(q0);
                if (w2 != null && getThreadData() != null && (g1 = getThreadData().g1()) != null) {
                    TiebaStatic.deleteParamByKey(w2, "obj_type");
                    w2.param("obj_type", g1.id);
                    w2.param("obj_name", g1.name);
                }
                return w2;
            } else {
                w = w(Z);
                if (w != null) {
                    w.param(TiebaStatic.Params.AB_ACTION, "click");
                    if (getThreadData() != null) {
                        d2 threadData = getThreadData();
                        if (threadData.L() != null) {
                            w.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                        }
                        w.param(TiebaStatic.Params.OBJ_PARAM5, a0(threadData));
                    }
                }
            }
            if (w != null && getThreadData() != null) {
                w.param(TiebaStatic.Params.IS_FULL, getThreadData().y2() ? 1 : 0);
            }
            return w;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // c.a.t0.g0.f0.b
    public StatisticItem B() {
        InterceptResult invokeV;
        SmartApp g1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = 0;
            int i3 = 1;
            if (X()) {
                StatisticItem w = w(d0);
                if (w != null) {
                    w.setPosition(this.position);
                    if (getThreadData() != null) {
                        d2 threadData = getThreadData();
                        if (threadData.y1() != null && (threadData.y1().N() != null || threadData.y1().Z() != null)) {
                            i2 = 1;
                        }
                        w.param("obj_name", i2);
                        if (threadData.J() != null) {
                            w.param(TiebaStatic.Params.AB_TYPE, threadData.J().hadConcerned() ? 1 : 0);
                        }
                        w.param(TiebaStatic.Params.IS_FULL, threadData.y2() ? 1 : 0);
                    }
                }
                return w;
            } else if (W()) {
                StatisticItem w2 = w(k0);
                if (w2 != null) {
                    w2.setPosition(this.position);
                    if (getThreadData() != null && (g1 = getThreadData().g1()) != null) {
                        TiebaStatic.deleteParamByKey(w2, "obj_type");
                        w2.param("obj_type", g1.id);
                        w2.param("obj_name", g1.name);
                    }
                }
                return w2;
            } else if (G()) {
                return null;
            } else {
                StatisticItem w3 = w(Y);
                if (w3 != null) {
                    w3.setPosition(this.position);
                    w3.param(TiebaStatic.Params.AB_ACTION, "show");
                    if (getThreadData() != null) {
                        d2 threadData2 = getThreadData();
                        int i4 = (threadData2.y1() == null || (threadData2.y1().N() == null && threadData2.y1().Z() == null)) ? 0 : 1;
                        w3.param("obj_name", i4);
                        if (i4 != 0 && threadData2.y1().N() != null && threadData2.y1().N().y() != null && threadData2.y1().N().y().size() > 0) {
                            w3.param(TiebaStatic.Params.OBJ_TO, threadData2.y1().P ? 2 : 1);
                        }
                        if (threadData2.J() != null) {
                            w3.param(TiebaStatic.Params.AB_TYPE, threadData2.J().hadConcerned() ? 1 : 0);
                        }
                        w3.param(TiebaStatic.Params.IS_FULL, threadData2.y2() ? 1 : 0);
                        if (threadData2.L() != null) {
                            w3.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.L().oriUgcNid);
                        }
                        w3.param(TiebaStatic.Params.OBJ_PARAM5, a0(threadData2));
                        if (threadData2.N1()) {
                            w3.param(TiebaStatic.Params.OBJ_PARAM6, 2);
                        } else {
                            w3.param(TiebaStatic.Params.OBJ_PARAM6, 1);
                        }
                        if (threadData2.d2()) {
                            w3.param(TiebaStatic.Params.GUA_TYPE, 1);
                        } else if (threadData2.t0() != null) {
                            w3.param(TiebaStatic.Params.GUA_TYPE, 2);
                        } else {
                            w3.param(TiebaStatic.Params.GUA_TYPE, 0);
                        }
                        if (threadData2.J() != null && threadData2.J().getAlaInfo() != null) {
                            int calculateLiveType = YYLiveUtil.calculateLiveType(threadData2.J().getAlaInfo());
                            if (threadData2.J().getAlaInfo().live_status != 1 && threadData2.J().getAlaInfo().friendRoomStatus != 2) {
                                i3 = 2;
                            }
                            if (threadData2.J().getAlaInfo().mYyExtData != null) {
                                TiebaStaticHelper.addYYParam(w3, threadData2.J().getAlaInfo().mYyExtData);
                            }
                            w3.param(TiebaStatic.Params.OBJ_PARAM7, i3);
                            w3.param(TiebaStatic.Params.OBJ_PARAM8, calculateLiveType);
                        }
                    }
                }
                return w3;
            }
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // c.a.t0.g0.f0.b
    public StatisticItem D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StatisticItem y = y(r0, true);
            if (getThreadData() != null) {
                d2 threadData = getThreadData();
                if (threadData.L() != null) {
                    y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                    y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                }
                y.param(TiebaStatic.Params.OBJ_PARAM5, a0(threadData));
            }
            return y;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // c.a.t0.g0.f0.b
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d2 d2Var = this.f18222e;
            return d2Var != null && d2Var.H2();
        }
        return invokeV.booleanValue;
    }

    public int P(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, d2Var)) == null) {
            if (d2Var == null) {
                return 0;
            }
            if (d2Var.P1()) {
                return 1;
            }
            if (d2Var.H2()) {
                return 2;
            }
            if (d2Var.Q1()) {
                return 3;
            }
            return d2Var.R1() ? 4 : 0;
        }
        return invokeL.intValue;
    }

    public StatisticItem Q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            StatisticItem w = w(str);
            if (w != null) {
                w.param("ab_tag", g()).param(TiebaStatic.Params.AB_ACTION, "show");
                if (getThreadData() != null) {
                    d2 threadData = getThreadData();
                    int i2 = (threadData.y1() == null || (threadData.y1().N() == null && threadData.y1().Z() == null)) ? 0 : 1;
                    w.param("obj_name", i2);
                    if (i2 != 0 && threadData.y1().N() != null && threadData.y1().N().y() != null && threadData.y1().N().y().size() > 0) {
                        w.param(TiebaStatic.Params.OBJ_TO, threadData.y1().P ? 2 : 1);
                    }
                }
            }
            return w;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public StatisticItem R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (X()) {
                return w(h0);
            }
            StatisticItem w = w(c0);
            if (w != null) {
                w.param(TiebaStatic.Params.AB_ACTION, "click");
                if (getThreadData() != null) {
                    d2 threadData = getThreadData();
                    if (threadData.L() != null) {
                        w.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                    }
                    w.param(TiebaStatic.Params.OBJ_PARAM5, a0(threadData));
                }
            }
            return w;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public StatisticItem S(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? w(str) : (StatisticItem) invokeL.objValue;
    }

    public StatisticItem T(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            StatisticItem w = w(str);
            d2 d2Var = this.f18222e;
            if (d2Var != null && d2Var.J() != null) {
                w.param(TiebaStatic.Params.AB_TYPE, this.f18222e.J().hadConcerned() ? 1 : 0);
            }
            return w;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public StatisticItem U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (l.T(this.f18222e)) {
                StatisticItem y = y(s0, true);
                if (y != null && getThreadData() != null) {
                    d2 threadData = getThreadData();
                    if (threadData.L() != null) {
                        y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                        y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                    }
                    y.param(TiebaStatic.Params.OBJ_PARAM5, a0(threadData));
                    if (threadData.N1()) {
                        y.addParam(TiebaStatic.Params.OBJ_PARAM2, 2);
                    } else {
                        y.addParam(TiebaStatic.Params.OBJ_PARAM2, 1);
                    }
                    if (threadData.J() != null && threadData.J().getAlaInfo() != null) {
                        int calculateLiveType = YYLiveUtil.calculateLiveType(threadData.J().getAlaInfo());
                        if (threadData.J().getAlaInfo().mYyExtData != null) {
                            TiebaStaticHelper.addYYParam(y, threadData.J().getAlaInfo().mYyExtData);
                        }
                        y.param(TiebaStatic.Params.OBJ_PARAM7, calculateLiveType);
                    }
                }
                return y;
            } else if (X()) {
                return w(g0);
            } else {
                StatisticItem w = w(b0);
                if (w != null) {
                    w.param("ab_tag", g()).param(TiebaStatic.Params.AB_ACTION, "click");
                    if (getThreadData() != null) {
                        d2 threadData2 = getThreadData();
                        if (threadData2.L() != null) {
                            w.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.L().oriUgcNid);
                        }
                        w.param(TiebaStatic.Params.OBJ_PARAM5, a0(threadData2));
                        w.param("nid", threadData2.G0());
                        if (threadData2.N1()) {
                            w.param(TiebaStatic.Params.OBJ_PARAM2, 2);
                        } else {
                            w.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                        }
                        if (threadData2.J() != null && threadData2.J().getAlaInfo() != null) {
                            int calculateLiveType2 = YYLiveUtil.calculateLiveType(threadData2.J().getAlaInfo());
                            if (threadData2.J().getAlaInfo().mYyExtData != null) {
                                TiebaStaticHelper.addYYParam(w, threadData2.J().getAlaInfo().mYyExtData);
                            }
                            w.param(TiebaStatic.Params.OBJ_PARAM6, calculateLiveType2);
                        }
                    }
                }
                return w;
            }
        }
        return (StatisticItem) invokeV.objValue;
    }

    public StatisticItem V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? w(i0) : (StatisticItem) invokeV.objValue;
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            d2 d2Var = this.f18222e;
            return d2Var == null || d2Var.z2();
        }
        return invokeV.booleanValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            d2 d2Var = this.f18222e;
            return (d2Var == null || ListUtils.getCount(d2Var.F1()) == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public int a0(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, d2Var)) == null) {
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

    @Override // c.a.t0.g0.f0.b, c.a.s0.s.q.a
    public d2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            d2 d2Var = this.f18222e;
            if (d2Var == null) {
                return null;
            }
            if (d2Var.W0() == 5) {
                return this.f18222e;
            }
            this.f18222e.s4(1);
            return this.f18222e;
        }
        return (d2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.n.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        int indexOf;
        int indexOf2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            d2 d2Var = this.f18222e;
            if (d2Var == null) {
                return v0;
            }
            if (this.G && b.V.length > 1) {
                BdUniqueId type = d2Var.getType();
                if (type == d2.i3 || type == d2.E3 || type == d2.Q3 || type == d2.F3) {
                    if (this.s) {
                        indexOf = b.T.indexOf(b.J);
                    } else {
                        indexOf = b.T.indexOf(b.I);
                    }
                    if (this.t) {
                        indexOf2 = b.U.indexOf(b.K);
                    } else if (this.v) {
                        indexOf2 = b.U.indexOf(b.M);
                    } else if (this.u) {
                        indexOf2 = b.U.indexOf(b.L);
                    } else {
                        indexOf2 = b.U.indexOf(b.N);
                    }
                    if (indexOf >= 0) {
                        BdUniqueId[][] bdUniqueIdArr = b.V;
                        return (indexOf >= bdUniqueIdArr.length || indexOf2 < 0 || indexOf2 >= bdUniqueIdArr[0].length) ? type : bdUniqueIdArr[indexOf][indexOf2];
                    }
                    return type;
                }
                return type;
            }
            d2 d2Var2 = this.f18222e;
            int i2 = d2Var2.d0;
            if (i2 == 63) {
                return C0;
            }
            if (i2 == 64) {
                return D0;
            }
            if (d2Var2.B1 && (originalThreadInfo = d2Var2.A1) != null) {
                if (originalThreadInfo.x) {
                    if (originalThreadInfo.r != null) {
                        return B0;
                    }
                    if (originalThreadInfo.g()) {
                        return A0;
                    }
                    return z0;
                }
                return y0;
            } else if (this.r) {
                return G0;
            } else {
                if (this.y) {
                    return M0;
                }
                if (this.w) {
                    return I0;
                }
                if (this.u) {
                    return J0;
                }
                if (this.v) {
                    return K0;
                }
                if (this.t) {
                    return L0;
                }
                if (this.F) {
                    return N0;
                }
                if (this.D) {
                    return P0;
                }
                if (this.C) {
                    return O0;
                }
                if (this.s) {
                    return H0;
                }
                if (this.z) {
                    return Q0;
                }
                if (this.A) {
                    return R0;
                }
                if (this.B) {
                    return S0;
                }
                if (this.E) {
                    return T0;
                }
                return F0;
            }
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // c.a.t0.g0.f0.b
    public StatisticItem i(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            d2 d2Var = this.f18222e;
            if (d2Var != null) {
                if (d2Var.L() == null) {
                    statisticItem.param("fid", this.f18222e.U());
                    statisticItem.param("tid", this.f18222e.v1());
                    statisticItem.param("fname", this.f18222e.a0());
                } else {
                    statisticItem.param("tid", this.f18222e.L().oriUgcNid);
                }
                if (this.f18222e.H2()) {
                    i2 = 2;
                } else if (this.f18222e.h2()) {
                    i2 = 4;
                } else {
                    d2 d2Var2 = this.f18222e;
                    if (d2Var2.B1) {
                        i2 = 5;
                    } else if (d2Var2.P1()) {
                        i2 = 6;
                    } else if (this.f18222e.Q1()) {
                        i2 = 7;
                    } else if (this.f18222e.S1()) {
                        i2 = 8;
                    } else {
                        i2 = this.f18222e.R1() ? 9 : 1;
                    }
                }
                statisticItem.param("obj_type", i2);
                statisticItem.param("obj_id", this.f18222e.J().getUserId());
                statisticItem.param("obj_param1", F() ? 2 : 1);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeL.objValue;
    }

    @Override // c.a.t0.g0.f0.b
    public StatisticItem o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (X()) {
                return w(f0);
            }
            if (l.T(this.f18222e)) {
                StatisticItem y = y(t0, true);
                if (y != null && getThreadData() != null) {
                    d2 threadData = getThreadData();
                    if (threadData.L() != null) {
                        y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                        y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                    }
                    y.param(TiebaStatic.Params.OBJ_PARAM5, a0(threadData));
                }
                return y;
            }
            StatisticItem x = x(a0, 0);
            if (x != null) {
                x.param("ab_tag", g()).param(TiebaStatic.Params.AB_ACTION, "click");
                if (getThreadData() != null) {
                    d2 threadData2 = getThreadData();
                    if (threadData2.L() != null) {
                        x.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.L().oriUgcNid);
                    }
                    x.param(TiebaStatic.Params.OBJ_PARAM5, a0(threadData2));
                    x.param("nid", threadData2.G0());
                }
            }
            return x;
        }
        return (StatisticItem) invokeV.objValue;
    }
}
