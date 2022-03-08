package c.a.q0.r.r;

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
/* loaded from: classes2.dex */
public class d2 extends a implements c.a.d.o.e.n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13229e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13230f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13231g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13232h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13233i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f13234j;
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
        this.f13229e = false;
        this.f13230f = false;
        this.f13231g = false;
        this.f13232h = false;
        this.f13233i = false;
        this.f13234j = false;
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

    @Override // c.a.q0.r.r.a
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
            x0Var.o(getThreadData().w1());
            x0Var.k(getThreadData().U());
            x0Var.n(getThreadData().H0());
            x0Var.j(this.w.l1);
            e2 e2Var2 = this.w;
            x0Var.f13412g = e2Var2.m1;
            x0Var.p = e2Var2.b1;
            x0Var.k = e2Var2.a1;
            x0Var.m = e2Var2.c1;
            x0Var.l = e2Var2.Z0;
            x0Var.q = e2Var2.T1;
            x0Var.o = e2Var2.S0();
            return x0Var;
        }
        return (x0) invokeV.objValue;
    }

    @Override // c.a.q0.r.r.a
    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.w.d1 : (String) invokeV.objValue;
    }

    @Override // c.a.q0.r.r.a
    public e2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.w : (e2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.o.e.n
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
            if (e2Var.k0()) {
                if (this.w.u1() != null) {
                    return e2.H3;
                }
                return e2.j3;
            }
            int t0 = this.w.t0();
            e2 e2Var2 = this.w;
            int i3 = e2Var2.d0;
            if (i3 == 63) {
                return e2.T3;
            }
            if (i3 == 64) {
                return e2.U3;
            }
            if (i3 == 65) {
                return e2.z3;
            }
            if (e2Var2.p1() != null && this.w.d0 == 60) {
                return e2.K3;
            }
            if (this.w.p1() != null && ((i2 = this.w.d0) == 49 || i2 == 69)) {
                return e2.I3;
            }
            if (this.w.p1() != null && this.w.d0 == 67) {
                return e2.L3;
            }
            e2 e2Var3 = this.w;
            if (e2Var3.d0 == 51) {
                return e2.J3;
            }
            if (t0 != 2 && t0 != 1) {
                if (e2Var3.u1() != null && this.w.f2() && !this.w.j2()) {
                    return e2.Y3;
                }
                e2 e2Var4 = this.w;
                if (e2Var4.A1 && (originalThreadInfo = e2Var4.z1) != null) {
                    if (originalThreadInfo.x) {
                        if (originalThreadInfo.r != null) {
                            return e2.P3;
                        }
                        if (originalThreadInfo.g()) {
                            return e2.O3;
                        }
                        return e2.N3;
                    }
                    return e2.M3;
                } else if (this.w.h2()) {
                    return e2.W3.get() ? e2.c4 : e2.j3;
                } else if (this.w.M1() && this.w.w() == 1) {
                    return e2.W3.get() ? e2.d4 : e2.j3;
                } else if (this.w.i2()) {
                    return e2.F3;
                } else {
                    if (this.w.F2()) {
                        return this.w.g0() != null ? e2.S3 : e2.R3;
                    }
                    c.a.r0.y3.k0.n nVar = this.w.M2;
                    if (nVar != null && nVar.f()) {
                        return this.w.M2.g() ? AdvertAppInfo.L4 : AdvertAppInfo.M4;
                    } else if (this.v) {
                        return e2.o3;
                    } else {
                        if (this.f13229e) {
                            return e2.p3;
                        }
                        if (this.f13230f) {
                            return e2.q3;
                        }
                        if (this.f13231g) {
                            return e2.r3;
                        }
                        if (this.f13232h) {
                            return e2.s3;
                        }
                        if (this.f13233i) {
                            return e2.t3;
                        }
                        if (this.f13234j) {
                            return e2.u3;
                        }
                        if (this.k) {
                            return e2.w3;
                        }
                        if (this.l) {
                            return e2.x3;
                        }
                        if (this.m) {
                            return e2.H3;
                        }
                        if (this.n) {
                            return e2.Z3;
                        }
                        if (this.w.d2()) {
                            if (this.o) {
                                return e2.Q3;
                            }
                            return e2.G3;
                        } else if (this.p) {
                            return e2.V3;
                        } else {
                            if (this.q) {
                                return e2.A3;
                            }
                            if (this.r) {
                                return e2.B3;
                            }
                            if (this.s) {
                                return e2.C3;
                            }
                            if (this.t) {
                                return e2.D3;
                            }
                            if (this.u) {
                                return e2.E3;
                            }
                            return e2.j3;
                        }
                    }
                }
            }
            return e2.i3;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
