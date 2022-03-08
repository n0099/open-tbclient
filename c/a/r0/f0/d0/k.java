package c.a.r0.f0.d0;

import androidx.core.view.InputDeviceCompat;
import c.a.q0.r.r.e2;
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
/* loaded from: classes2.dex */
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
    public static String V = "";
    public static String W = "";
    public static String X = "";
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
    public static final BdUniqueId s0;
    public static final BdUniqueId t0;
    public static final BdUniqueId u0;
    public static final BdUniqueId v0;
    public static final BdUniqueId w0;
    public static final BdUniqueId x0;
    public static final BdUniqueId y0;
    public static final BdUniqueId z0;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-251757095, "Lc/a/r0/f0/d0/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-251757095, "Lc/a/r0/f0/d0/k;");
                return;
            }
        }
        s0 = BdUniqueId.gen();
        t0 = BdUniqueId.gen();
        u0 = BdUniqueId.gen();
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
            }
        }
    }

    public static boolean X(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, e2Var)) == null) {
            if (e2Var == null) {
                return false;
            }
            return e2Var.getType() == e2.j3 || e2Var.getType() == e2.G3 || e2Var.getType() == e2.F3 || e2Var.getType() == e2.M3 || e2Var.getType() == e2.R3;
        }
        return invokeL.booleanValue;
    }

    public static boolean Y(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, e2Var)) == null) {
            if (e2Var == null) {
                return false;
            }
            return e2Var.getType() == e2.T3 || e2Var.getType() == e2.U3;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.f0.d0.b
    public StatisticItem A() {
        InterceptResult invokeV;
        StatisticItem w;
        SmartApp h1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (W()) {
                w = w(b0);
            } else if (V()) {
                StatisticItem w2 = w(h0);
                if (w2 != null && getThreadData() != null && (h1 = getThreadData().h1()) != null) {
                    TiebaStatic.deleteParamByKey(w2, "obj_type");
                    w2.param("obj_type", h1.id);
                    w2.param("obj_name", h1.name);
                }
                return w2;
            } else {
                w = w(W);
                if (w != null) {
                    w.param(TiebaStatic.Params.AB_ACTION, "click");
                    if (getThreadData() != null) {
                        e2 threadData = getThreadData();
                        if (threadData.L() != null) {
                            w.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                        }
                        w.param(TiebaStatic.Params.OBJ_PARAM5, Z(threadData));
                    }
                }
            }
            if (w != null && getThreadData() != null) {
                w.param(TiebaStatic.Params.IS_FULL, getThreadData().z2() ? 1 : 0);
            }
            return w;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // c.a.r0.f0.d0.b
    public StatisticItem B() {
        InterceptResult invokeV;
        SmartApp h1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = 0;
            int i3 = 1;
            if (W()) {
                StatisticItem w = w(a0);
                if (w != null) {
                    w.setPosition(this.position);
                    if (getThreadData() != null) {
                        e2 threadData = getThreadData();
                        if (threadData.z1() != null && (threadData.z1().N() != null || threadData.z1().Z() != null)) {
                            i2 = 1;
                        }
                        w.param("obj_name", i2);
                        if (threadData.J() != null) {
                            w.param(TiebaStatic.Params.AB_TYPE, threadData.J().hadConcerned() ? 1 : 0);
                        }
                        w.param(TiebaStatic.Params.IS_FULL, threadData.z2() ? 1 : 0);
                    }
                }
                return w;
            } else if (V()) {
                StatisticItem w2 = w(g0);
                if (w2 != null) {
                    w2.setPosition(this.position);
                    if (getThreadData() != null && (h1 = getThreadData().h1()) != null) {
                        TiebaStatic.deleteParamByKey(w2, "obj_type");
                        w2.param("obj_type", h1.id);
                        w2.param("obj_name", h1.name);
                    }
                }
                return w2;
            } else if (F()) {
                return null;
            } else {
                StatisticItem w3 = w(V);
                if (w3 != null) {
                    w3.setPosition(this.position);
                    w3.param(TiebaStatic.Params.AB_ACTION, "show");
                    if (getThreadData() != null) {
                        e2 threadData2 = getThreadData();
                        int i4 = (threadData2.z1() == null || (threadData2.z1().N() == null && threadData2.z1().Z() == null)) ? 0 : 1;
                        w3.param("obj_name", i4);
                        if (i4 != 0 && threadData2.z1().N() != null && threadData2.z1().N().y() != null && threadData2.z1().N().y().size() > 0) {
                            w3.param(TiebaStatic.Params.OBJ_TO, threadData2.z1().P ? 2 : 1);
                        }
                        if (threadData2.J() != null) {
                            w3.param(TiebaStatic.Params.AB_TYPE, threadData2.J().hadConcerned() ? 1 : 0);
                        }
                        w3.param(TiebaStatic.Params.IS_FULL, threadData2.z2() ? 1 : 0);
                        if (threadData2.L() != null) {
                            w3.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.L().oriUgcNid);
                        }
                        w3.param(TiebaStatic.Params.OBJ_PARAM5, Z(threadData2));
                        if (threadData2.O1()) {
                            w3.param(TiebaStatic.Params.OBJ_PARAM6, 2);
                        } else {
                            w3.param(TiebaStatic.Params.OBJ_PARAM6, 1);
                        }
                        if (threadData2.e2()) {
                            w3.param(TiebaStatic.Params.GUA_TYPE, 1);
                        } else if (threadData2.u0() != null) {
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

    @Override // c.a.r0.f0.d0.b
    public StatisticItem C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StatisticItem y = y(i0, true);
            if (getThreadData() != null) {
                e2 threadData = getThreadData();
                if (threadData.L() != null) {
                    y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                    y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                }
                y.param(TiebaStatic.Params.OBJ_PARAM5, Z(threadData));
            }
            return y;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // c.a.r0.f0.d0.b
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            e2 e2Var = this.f17272e;
            return e2Var != null && e2Var.I2();
        }
        return invokeV.booleanValue;
    }

    public int O(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, e2Var)) == null) {
            if (e2Var == null) {
                return 0;
            }
            if (e2Var.Q1()) {
                return 1;
            }
            if (e2Var.I2()) {
                return 2;
            }
            if (e2Var.R1()) {
                return 3;
            }
            return e2Var.S1() ? 4 : 0;
        }
        return invokeL.intValue;
    }

    public StatisticItem P(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            StatisticItem w = w(str);
            if (w != null) {
                w.param("ab_tag", g()).param(TiebaStatic.Params.AB_ACTION, "show");
                if (getThreadData() != null) {
                    e2 threadData = getThreadData();
                    int i2 = (threadData.z1() == null || (threadData.z1().N() == null && threadData.z1().Z() == null)) ? 0 : 1;
                    w.param("obj_name", i2);
                    if (i2 != 0 && threadData.z1().N() != null && threadData.z1().N().y() != null && threadData.z1().N().y().size() > 0) {
                        w.param(TiebaStatic.Params.OBJ_TO, threadData.z1().P ? 2 : 1);
                    }
                }
            }
            return w;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public StatisticItem Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (W()) {
                return w(e0);
            }
            StatisticItem w = w(Z);
            if (w != null) {
                w.param(TiebaStatic.Params.AB_ACTION, "click");
                if (getThreadData() != null) {
                    e2 threadData = getThreadData();
                    if (threadData.L() != null) {
                        w.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                    }
                    w.param(TiebaStatic.Params.OBJ_PARAM5, Z(threadData));
                }
            }
            return w;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public StatisticItem R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? w(str) : (StatisticItem) invokeL.objValue;
    }

    public StatisticItem S(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            StatisticItem w = w(str);
            e2 e2Var = this.f17272e;
            if (e2Var != null && e2Var.J() != null) {
                w.param(TiebaStatic.Params.AB_TYPE, this.f17272e.J().hadConcerned() ? 1 : 0);
            }
            return w;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public StatisticItem T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (l.S(this.f17272e)) {
                StatisticItem y = y(k0, true);
                if (y != null && getThreadData() != null) {
                    e2 threadData = getThreadData();
                    if (threadData.L() != null) {
                        y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                        y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                    }
                    y.param(TiebaStatic.Params.OBJ_PARAM5, Z(threadData));
                    if (threadData.O1()) {
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
            } else if (W()) {
                return w(d0);
            } else {
                StatisticItem w = w(Y);
                if (w != null) {
                    w.param("ab_tag", g()).param(TiebaStatic.Params.AB_ACTION, "click");
                    if (getThreadData() != null) {
                        e2 threadData2 = getThreadData();
                        if (threadData2.L() != null) {
                            w.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.L().oriUgcNid);
                        }
                        w.param(TiebaStatic.Params.OBJ_PARAM5, Z(threadData2));
                        w.param("nid", threadData2.H0());
                        if (threadData2.O1()) {
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

    public StatisticItem U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? w(f0) : (StatisticItem) invokeV.objValue;
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            e2 e2Var = this.f17272e;
            return e2Var == null || e2Var.A2();
        }
        return invokeV.booleanValue;
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            e2 e2Var = this.f17272e;
            return (e2Var == null || ListUtils.getCount(e2Var.G1()) == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public int Z(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, e2Var)) == null) {
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

    @Override // c.a.r0.f0.d0.b, c.a.q0.r.r.a
    public e2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            e2 e2Var = this.f17272e;
            if (e2Var == null) {
                return null;
            }
            if (e2Var.X0() == 5) {
                return this.f17272e;
            }
            this.f17272e.t4(1);
            return this.f17272e;
        }
        return (e2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        int indexOf;
        int indexOf2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            e2 e2Var = this.f17272e;
            if (e2Var == null) {
                return s0;
            }
            if (this.F && b.U.length > 1) {
                BdUniqueId type = e2Var.getType();
                if (type == e2.j3 || type == e2.F3 || type == e2.R3 || type == e2.G3) {
                    if (this.r) {
                        indexOf = b.S.indexOf(b.I);
                    } else {
                        indexOf = b.S.indexOf(b.H);
                    }
                    if (this.s) {
                        indexOf2 = b.T.indexOf(b.J);
                    } else if (this.u) {
                        indexOf2 = b.T.indexOf(b.L);
                    } else if (this.t) {
                        indexOf2 = b.T.indexOf(b.K);
                    } else {
                        indexOf2 = b.T.indexOf(b.M);
                    }
                    if (indexOf >= 0) {
                        BdUniqueId[][] bdUniqueIdArr = b.U;
                        return (indexOf >= bdUniqueIdArr.length || indexOf2 < 0 || indexOf2 >= bdUniqueIdArr[0].length) ? type : bdUniqueIdArr[indexOf][indexOf2];
                    }
                    return type;
                }
                return type;
            }
            e2 e2Var2 = this.f17272e;
            int i2 = e2Var2.d0;
            if (i2 == 63) {
                return z0;
            }
            if (i2 == 64) {
                return A0;
            }
            if (e2Var2.A1 && (originalThreadInfo = e2Var2.z1) != null) {
                if (originalThreadInfo.x) {
                    if (originalThreadInfo.r != null) {
                        return y0;
                    }
                    if (originalThreadInfo.g()) {
                        return x0;
                    }
                    return w0;
                }
                return v0;
            } else if (this.q) {
                return D0;
            } else {
                if (this.x) {
                    return J0;
                }
                if (this.v) {
                    return F0;
                }
                if (this.t) {
                    return G0;
                }
                if (this.u) {
                    return H0;
                }
                if (this.s) {
                    return I0;
                }
                if (this.E) {
                    return K0;
                }
                if (this.C) {
                    return M0;
                }
                if (this.B) {
                    return L0;
                }
                if (this.r) {
                    return E0;
                }
                if (this.y) {
                    return N0;
                }
                if (this.z) {
                    return O0;
                }
                if (this.A) {
                    return P0;
                }
                if (this.D) {
                    return Q0;
                }
                return C0;
            }
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // c.a.r0.f0.d0.b
    public StatisticItem i(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            e2 e2Var = this.f17272e;
            if (e2Var != null) {
                if (e2Var.L() == null) {
                    statisticItem.param("fid", this.f17272e.U());
                    statisticItem.param("tid", this.f17272e.w1());
                    statisticItem.param("fname", this.f17272e.b0());
                } else {
                    statisticItem.param("tid", this.f17272e.L().oriUgcNid);
                }
                if (this.f17272e.I2()) {
                    i2 = 2;
                } else if (this.f17272e.i2()) {
                    i2 = 4;
                } else {
                    e2 e2Var2 = this.f17272e;
                    if (e2Var2.A1) {
                        i2 = 5;
                    } else if (e2Var2.Q1()) {
                        i2 = 6;
                    } else if (this.f17272e.R1()) {
                        i2 = 7;
                    } else if (this.f17272e.T1()) {
                        i2 = 8;
                    } else {
                        i2 = this.f17272e.S1() ? 9 : 1;
                    }
                }
                statisticItem.param("obj_type", i2);
                statisticItem.param("obj_id", this.f17272e.J().getUserId());
                statisticItem.param("obj_param1", E() ? 2 : 1);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeL.objValue;
    }

    @Override // c.a.r0.f0.d0.b
    public StatisticItem o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (W()) {
                return w(c0);
            }
            if (l.S(this.f17272e)) {
                StatisticItem y = y(q0, true);
                if (y != null && getThreadData() != null) {
                    e2 threadData = getThreadData();
                    if (threadData.L() != null) {
                        y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                        y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                    }
                    y.param(TiebaStatic.Params.OBJ_PARAM5, Z(threadData));
                }
                return y;
            }
            StatisticItem x = x(X, 0);
            if (x != null) {
                x.param("ab_tag", g()).param(TiebaStatic.Params.AB_ACTION, "click");
                if (getThreadData() != null) {
                    e2 threadData2 = getThreadData();
                    if (threadData2.L() != null) {
                        x.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.L().oriUgcNid);
                    }
                    x.param(TiebaStatic.Params.OBJ_PARAM5, Z(threadData2));
                    x.param("nid", threadData2.H0());
                }
            }
            return x;
        }
        return (StatisticItem) invokeV.objValue;
    }
}
