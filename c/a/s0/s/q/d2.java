package c.a.s0.s.q;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class d2 extends a implements c.a.d.n.e.n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13343e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13344f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13345g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13346h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13347i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f13348j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public e2 w;
    public int x;
    public int y;

    public d2() {
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
        this.f13343e = false;
        this.f13344f = false;
        this.f13345g = false;
        this.f13346h = false;
        this.f13347i = false;
        this.f13348j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.x = 0;
        this.y = 0;
    }

    @Override // c.a.s0.s.q.a
    public x0 getNegFeedBackData() {
        InterceptResult invokeV;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e2 e2Var = this.w;
            if (e2Var == null || (sparseArray = e2Var.l1) == null || sparseArray.size() <= 0) {
                return null;
            }
            x0 x0Var = new x0();
            x0Var.o(getThreadData().v1());
            x0Var.k(getThreadData().U());
            x0Var.n(getThreadData().G0());
            x0Var.j(this.w.l1);
            e2 e2Var2 = this.w;
            x0Var.f13531g = e2Var2.m1;
            x0Var.p = e2Var2.b1;
            x0Var.k = e2Var2.a1;
            x0Var.m = e2Var2.c1;
            x0Var.l = e2Var2.Z0;
            x0Var.q = e2Var2.T1;
            x0Var.o = e2Var2.R0();
            return x0Var;
        }
        return (x0) invokeV.objValue;
    }

    @Override // c.a.s0.s.q.a
    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.w.d1 : (String) invokeV.objValue;
    }

    @Override // c.a.s0.s.q.a
    public e2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.w : (e2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.n.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            e2 e2Var = this.w;
            if (e2Var == null) {
                return null;
            }
            if (e2Var.j0()) {
                if (this.w.t1() != null) {
                    return e2.G3;
                }
                return e2.i3;
            }
            int s0 = this.w.s0();
            e2 e2Var2 = this.w;
            int i3 = e2Var2.d0;
            if (i3 == 63) {
                return e2.S3;
            }
            if (i3 == 64) {
                return e2.T3;
            }
            if (i3 == 65) {
                return e2.y3;
            }
            if (e2Var2.o1() != null && this.w.d0 == 60) {
                return e2.J3;
            }
            if (this.w.o1() != null && ((i2 = this.w.d0) == 49 || i2 == 69)) {
                return e2.H3;
            }
            if (this.w.o1() != null && this.w.d0 == 67) {
                return e2.K3;
            }
            e2 e2Var3 = this.w;
            if (e2Var3.d0 == 51) {
                return e2.I3;
            }
            if (s0 != 2 && s0 != 1) {
                if (e2Var3.t1() != null && this.w.e2() && !this.w.i2()) {
                    return e2.X3;
                }
                e2 e2Var4 = this.w;
                if (e2Var4.A1 && (originalThreadInfo = e2Var4.z1) != null) {
                    if (originalThreadInfo.x) {
                        if (originalThreadInfo.r != null) {
                            return e2.O3;
                        }
                        if (originalThreadInfo.g()) {
                            return e2.N3;
                        }
                        return e2.M3;
                    }
                    return e2.L3;
                } else if (this.w.g2()) {
                    return e2.V3.get() ? e2.b4 : e2.i3;
                } else if (this.w.L1() && this.w.w() == 1) {
                    return e2.V3.get() ? e2.c4 : e2.i3;
                } else if (this.w.h2()) {
                    return e2.E3;
                } else {
                    if (this.w.E2()) {
                        return this.w.f0() != null ? e2.R3 : e2.Q3;
                    }
                    c.a.t0.w3.j0.o oVar = this.w.M2;
                    if (oVar != null && oVar.f()) {
                        return this.w.M2.g() ? AdvertAppInfo.K4 : AdvertAppInfo.L4;
                    } else if (this.v) {
                        return e2.n3;
                    } else {
                        if (this.f13343e) {
                            return e2.o3;
                        }
                        if (this.f13344f) {
                            return e2.p3;
                        }
                        if (this.f13345g) {
                            return e2.q3;
                        }
                        if (this.f13346h) {
                            return e2.r3;
                        }
                        if (this.f13347i) {
                            return e2.s3;
                        }
                        if (this.f13348j) {
                            return e2.t3;
                        }
                        if (this.k) {
                            return e2.v3;
                        }
                        if (this.l) {
                            return e2.w3;
                        }
                        if (this.m) {
                            return e2.G3;
                        }
                        if (this.n) {
                            return e2.Y3;
                        }
                        if (this.w.c2()) {
                            if (this.o) {
                                return e2.P3;
                            }
                            return e2.F3;
                        } else if (this.p) {
                            return e2.U3;
                        } else {
                            if (this.q) {
                                return e2.z3;
                            }
                            if (this.r) {
                                return e2.A3;
                            }
                            if (this.s) {
                                return e2.B3;
                            }
                            if (this.t) {
                                return e2.C3;
                            }
                            if (this.u) {
                                return e2.D3;
                            }
                            return e2.i3;
                        }
                    }
                }
            }
            return e2.h3;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
