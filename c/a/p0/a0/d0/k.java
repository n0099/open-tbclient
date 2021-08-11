package c.a.p0.a0.d0;

import androidx.core.view.InputDeviceCompat;
import c.a.o0.s.q.c2;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
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
/* loaded from: classes3.dex */
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
    public static String W = "";
    public static String X = "";
    public static String Y = "";
    public static String Z = "";
    public static String a0 = "";
    public static String b0 = "";
    public static String c0 = "";
    public static String i0 = "";
    public static String j0 = "";
    public static String k0 = "";
    public static String l0 = "";
    public static String m0 = "";
    public static String n0 = "";
    public static String o0 = "";
    public static String p0 = "";
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
    public boolean U;
    public boolean V;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1076938756, "Lc/a/p0/a0/d0/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1076938756, "Lc/a/p0/a0/d0/k;");
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
        this.U = false;
        this.V = true;
    }

    public static boolean Y(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, c2Var)) == null) {
            if (c2Var == null) {
                return false;
            }
            return c2Var.getType() == c2.W2 || c2Var.getType() == c2.s3 || c2Var.getType() == c2.r3 || c2Var.getType() == c2.y3 || c2Var.getType() == c2.D3;
        }
        return invokeL.booleanValue;
    }

    public static boolean Z(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, c2Var)) == null) {
            if (c2Var == null) {
                return false;
            }
            return c2Var.getType() == c2.F3 || c2Var.getType() == c2.G3;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p0.a0.d0.b
    public StatisticItem A() {
        InterceptResult invokeV;
        StatisticItem w;
        SmartApp c1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (X()) {
                w = w(c0);
            } else if (W()) {
                StatisticItem w2 = w(n0);
                if (w2 != null && getThreadData() != null && (c1 = getThreadData().c1()) != null) {
                    TiebaStatic.deleteParamByKey(w2, "obj_type");
                    w2.param("obj_type", c1.id);
                    w2.param("obj_name", c1.name);
                }
                return w2;
            } else {
                w = w(X);
                if (w != null) {
                    w.param(TiebaStatic.Params.AB_ACTION, PrefetchEvent.STATE_CLICK);
                    if (getThreadData() != null) {
                        c2 threadData = getThreadData();
                        if (threadData.L() != null) {
                            w.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                        }
                        w.param(TiebaStatic.Params.OBJ_PARAM5, a0(threadData));
                    }
                }
            }
            if (w != null && getThreadData() != null) {
                w.param(TiebaStatic.Params.IS_FULL, getThreadData().r2() ? 1 : 0);
            }
            return w;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // c.a.p0.a0.d0.b
    public StatisticItem B() {
        InterceptResult invokeV;
        SmartApp c1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = 0;
            int i3 = 1;
            if (X()) {
                StatisticItem w = w(b0);
                if (w != null) {
                    w.setPosition(this.position);
                    if (getThreadData() != null) {
                        c2 threadData = getThreadData();
                        if (threadData.t1() != null && (threadData.t1().K() != null || threadData.t1().V() != null)) {
                            i2 = 1;
                        }
                        w.param("obj_name", i2);
                        if (threadData.J() != null) {
                            w.param(TiebaStatic.Params.AB_TYPE, threadData.J().hadConcerned() ? 1 : 0);
                        }
                        w.param(TiebaStatic.Params.IS_FULL, threadData.r2() ? 1 : 0);
                    }
                }
                return w;
            } else if (W()) {
                StatisticItem w2 = w(m0);
                if (w2 != null) {
                    w2.setPosition(this.position);
                    if (getThreadData() != null && (c1 = getThreadData().c1()) != null) {
                        TiebaStatic.deleteParamByKey(w2, "obj_type");
                        w2.param("obj_type", c1.id);
                        w2.param("obj_name", c1.name);
                    }
                }
                return w2;
            } else if (G()) {
                return null;
            } else {
                StatisticItem w3 = w(W);
                if (w3 != null) {
                    w3.setPosition(this.position);
                    w3.param(TiebaStatic.Params.AB_ACTION, "show");
                    if (getThreadData() != null) {
                        c2 threadData2 = getThreadData();
                        int i4 = (threadData2.t1() == null || (threadData2.t1().K() == null && threadData2.t1().V() == null)) ? 0 : 1;
                        w3.param("obj_name", i4);
                        if (i4 != 0 && threadData2.t1().K() != null && threadData2.t1().K().y() != null && threadData2.t1().K().y().size() > 0) {
                            w3.param(TiebaStatic.Params.OBJ_TO, threadData2.t1().N ? 2 : 1);
                        }
                        if (threadData2.J() != null) {
                            w3.param(TiebaStatic.Params.AB_TYPE, threadData2.J().hadConcerned() ? 1 : 0);
                        }
                        w3.param(TiebaStatic.Params.IS_FULL, threadData2.r2() ? 1 : 0);
                        if (threadData2.L() != null) {
                            w3.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.L().oriUgcNid);
                        }
                        w3.param(TiebaStatic.Params.OBJ_PARAM5, a0(threadData2));
                        if (threadData2.H1()) {
                            w3.param(TiebaStatic.Params.OBJ_PARAM6, 2);
                        } else {
                            w3.param(TiebaStatic.Params.OBJ_PARAM6, 1);
                        }
                        if (threadData2.X1()) {
                            w3.param(TiebaStatic.Params.GUA_TYPE, 1);
                        } else if (threadData2.q0() != null) {
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

    @Override // c.a.p0.a0.d0.b
    public StatisticItem D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StatisticItem y = y(o0, true);
            if (getThreadData() != null) {
                c2 threadData = getThreadData();
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

    @Override // c.a.p0.a0.d0.b
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c2 c2Var = this.f14959e;
            return c2Var != null && c2Var.A2();
        }
        return invokeV.booleanValue;
    }

    public int P(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, c2Var)) == null) {
            if (c2Var == null) {
                return 0;
            }
            if (c2Var.J1()) {
                return 1;
            }
            if (c2Var.A2()) {
                return 2;
            }
            if (c2Var.K1()) {
                return 3;
            }
            return c2Var.L1() ? 4 : 0;
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
                    c2 threadData = getThreadData();
                    int i2 = (threadData.t1() == null || (threadData.t1().K() == null && threadData.t1().V() == null)) ? 0 : 1;
                    w.param("obj_name", i2);
                    if (i2 != 0 && threadData.t1().K() != null && threadData.t1().K().y() != null && threadData.t1().K().y().size() > 0) {
                        w.param(TiebaStatic.Params.OBJ_TO, threadData.t1().N ? 2 : 1);
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
                return w(k0);
            }
            StatisticItem w = w(a0);
            if (w != null) {
                w.param(TiebaStatic.Params.AB_ACTION, PrefetchEvent.STATE_CLICK);
                if (getThreadData() != null) {
                    c2 threadData = getThreadData();
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
            c2 c2Var = this.f14959e;
            if (c2Var != null && c2Var.J() != null) {
                w.param(TiebaStatic.Params.AB_TYPE, this.f14959e.J().hadConcerned() ? 1 : 0);
            }
            return w;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public StatisticItem U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (l.T(this.f14959e)) {
                StatisticItem y = y(p0, true);
                if (y != null && getThreadData() != null) {
                    c2 threadData = getThreadData();
                    if (threadData.L() != null) {
                        y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                        y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                    }
                    y.param(TiebaStatic.Params.OBJ_PARAM5, a0(threadData));
                    if (threadData.H1()) {
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
                return w(j0);
            } else {
                StatisticItem w = w(Z);
                if (w != null) {
                    w.param("ab_tag", g()).param(TiebaStatic.Params.AB_ACTION, PrefetchEvent.STATE_CLICK);
                    if (getThreadData() != null) {
                        c2 threadData2 = getThreadData();
                        if (threadData2.L() != null) {
                            w.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.L().oriUgcNid);
                        }
                        w.param(TiebaStatic.Params.OBJ_PARAM5, a0(threadData2));
                        w.param("nid", threadData2.D0());
                        if (threadData2.H1()) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? w(l0) : (StatisticItem) invokeV.objValue;
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            c2 c2Var = this.f14959e;
            return c2Var == null || c2Var.s2();
        }
        return invokeV.booleanValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c2 c2Var = this.f14959e;
            return (c2Var == null || ListUtils.getCount(c2Var.B1()) == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public int a0(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, c2Var)) == null) {
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

    @Override // c.a.p0.a0.d0.b, c.a.o0.s.q.a
    public c2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            c2 c2Var = this.f14959e;
            if (c2Var == null) {
                return null;
            }
            if (c2Var.T0() == 5) {
                return this.f14959e;
            }
            this.f14959e.e4(1);
            return this.f14959e;
        }
        return (c2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.e.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        int indexOf;
        int indexOf2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            c2 c2Var = this.f14959e;
            if (c2Var == null) {
                return s0;
            }
            if (this.F && b.T.length > 1) {
                BdUniqueId type = c2Var.getType();
                if (type == c2.W2 || type == c2.r3 || type == c2.D3 || type == c2.s3) {
                    if (this.s) {
                        indexOf = b.R.indexOf(b.I);
                    } else {
                        indexOf = b.R.indexOf(b.H);
                    }
                    if (this.t) {
                        indexOf2 = b.S.indexOf(b.J);
                    } else if (this.v) {
                        indexOf2 = b.S.indexOf(b.L);
                    } else if (this.u) {
                        indexOf2 = b.S.indexOf(b.K);
                    } else {
                        indexOf2 = b.S.indexOf(b.M);
                    }
                    if (indexOf >= 0) {
                        BdUniqueId[][] bdUniqueIdArr = b.T;
                        return (indexOf >= bdUniqueIdArr.length || indexOf2 < 0 || indexOf2 >= bdUniqueIdArr[0].length) ? type : bdUniqueIdArr[indexOf][indexOf2];
                    }
                    return type;
                }
                return type;
            }
            c2 c2Var2 = this.f14959e;
            int i2 = c2Var2.a0;
            if (i2 == 63) {
                return z0;
            }
            if (i2 == 64) {
                return A0;
            }
            if (c2Var2.w1 && (originalThreadInfo = c2Var2.v1) != null) {
                if (originalThreadInfo.w) {
                    if (originalThreadInfo.r != null) {
                        return y0;
                    }
                    if (originalThreadInfo.f()) {
                        return x0;
                    }
                    return w0;
                }
                return v0;
            } else if (this.r) {
                return C0;
            } else {
                if (this.w) {
                    return E0;
                }
                if (this.u) {
                    return F0;
                }
                if (this.v) {
                    return G0;
                }
                if (this.t) {
                    return H0;
                }
                if (this.E) {
                    return I0;
                }
                if (this.C) {
                    return K0;
                }
                if (this.B) {
                    return J0;
                }
                if (this.s) {
                    return D0;
                }
                if (this.y) {
                    return L0;
                }
                if (this.z) {
                    return M0;
                }
                if (this.A) {
                    return N0;
                }
                if (this.D) {
                    return O0;
                }
                return s0;
            }
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // c.a.p0.a0.d0.b
    public StatisticItem i(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            c2 c2Var = this.f14959e;
            if (c2Var != null) {
                if (c2Var.L() == null) {
                    statisticItem.param("fid", this.f14959e.T());
                    statisticItem.param("tid", this.f14959e.q1());
                    statisticItem.param("fname", this.f14959e.Z());
                } else {
                    statisticItem.param("tid", this.f14959e.L().oriUgcNid);
                }
                if (this.f14959e.A2()) {
                    i2 = 2;
                } else if (this.f14959e.b2()) {
                    i2 = 4;
                } else {
                    c2 c2Var2 = this.f14959e;
                    if (c2Var2.w1) {
                        i2 = 5;
                    } else if (c2Var2.J1()) {
                        i2 = 6;
                    } else if (this.f14959e.K1()) {
                        i2 = 7;
                    } else if (this.f14959e.M1()) {
                        i2 = 8;
                    } else {
                        i2 = this.f14959e.L1() ? 9 : 1;
                    }
                }
                statisticItem.param("obj_type", i2);
                statisticItem.param("obj_id", this.f14959e.J().getUserId());
                statisticItem.param("obj_param1", F() ? 2 : 1);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeL.objValue;
    }

    @Override // c.a.p0.a0.d0.b
    public StatisticItem o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (X()) {
                return w(i0);
            }
            if (l.T(this.f14959e)) {
                StatisticItem y = y(q0, true);
                if (y != null && getThreadData() != null) {
                    c2 threadData = getThreadData();
                    if (threadData.L() != null) {
                        y.param(TiebaStatic.Params.OBJ_PARAM4, threadData.L().oriUgcNid);
                        y.param(TiebaStatic.Params.OBJ_PARAM6, threadData.L().oriUgcVid);
                    }
                    y.param(TiebaStatic.Params.OBJ_PARAM5, a0(threadData));
                }
                return y;
            }
            StatisticItem x = x(Y, 0);
            if (x != null) {
                x.param("ab_tag", g()).param(TiebaStatic.Params.AB_ACTION, PrefetchEvent.STATE_CLICK);
                if (getThreadData() != null) {
                    c2 threadData2 = getThreadData();
                    if (threadData2.L() != null) {
                        x.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.L().oriUgcNid);
                    }
                    x.param(TiebaStatic.Params.OBJ_PARAM5, a0(threadData2));
                    x.param("nid", threadData2.D0());
                }
            }
            return x;
        }
        return (StatisticItem) invokeV.objValue;
    }
}
