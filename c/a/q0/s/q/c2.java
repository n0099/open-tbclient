package c.a.q0.s.q;

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
/* loaded from: classes5.dex */
public class c2 extends a implements c.a.d.m.e.n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12884e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12885f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12886g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12887h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12888i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f12889j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f12890k;
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
    public d2 w;
    public int x;
    public int y;

    public c2() {
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
        this.f12884e = false;
        this.f12885f = false;
        this.f12886g = false;
        this.f12887h = false;
        this.f12888i = false;
        this.f12889j = false;
        this.f12890k = false;
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

    @Override // c.a.q0.s.q.a
    public x0 getNegFeedBackData() {
        InterceptResult invokeV;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d2 d2Var = this.w;
            if (d2Var == null || (sparseArray = d2Var.m1) == null || sparseArray.size() <= 0) {
                return null;
            }
            x0 x0Var = new x0();
            x0Var.o(getThreadData().v1());
            x0Var.k(getThreadData().U());
            x0Var.n(getThreadData().G0());
            x0Var.j(this.w.m1);
            d2 d2Var2 = this.w;
            x0Var.f13089g = d2Var2.n1;
            x0Var.p = d2Var2.b1;
            x0Var.f13093k = d2Var2.a1;
            x0Var.m = d2Var2.c1;
            x0Var.l = d2Var2.Z0;
            x0Var.q = d2Var2.U1;
            x0Var.o = d2Var2.R0();
            return x0Var;
        }
        return (x0) invokeV.objValue;
    }

    @Override // c.a.q0.s.q.a
    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.w.d1 : (String) invokeV.objValue;
    }

    @Override // c.a.q0.s.q.a
    public d2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.w : (d2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d2 d2Var = this.w;
            if (d2Var == null) {
                return null;
            }
            if (d2Var.j0()) {
                if (this.w.t1() != null) {
                    return d2.D3;
                }
                return d2.f3;
            }
            int s0 = this.w.s0();
            d2 d2Var2 = this.w;
            int i3 = d2Var2.d0;
            if (i3 == 63) {
                return d2.P3;
            }
            if (i3 == 64) {
                return d2.Q3;
            }
            if (i3 == 65) {
                return d2.v3;
            }
            if (d2Var2.o1() != null && this.w.d0 == 60) {
                return d2.G3;
            }
            if (this.w.o1() != null && ((i2 = this.w.d0) == 49 || i2 == 69)) {
                return d2.E3;
            }
            if (this.w.o1() != null && this.w.d0 == 67) {
                return d2.H3;
            }
            d2 d2Var3 = this.w;
            if (d2Var3.d0 == 51) {
                return d2.F3;
            }
            if (s0 != 2 && s0 != 1) {
                if (d2Var3.t1() != null && this.w.e2() && !this.w.i2()) {
                    return d2.U3;
                }
                d2 d2Var4 = this.w;
                if (d2Var4.B1 && (originalThreadInfo = d2Var4.A1) != null) {
                    if (originalThreadInfo.w) {
                        if (originalThreadInfo.r != null) {
                            return d2.L3;
                        }
                        if (originalThreadInfo.f()) {
                            return d2.K3;
                        }
                        return d2.J3;
                    }
                    return d2.I3;
                } else if (this.w.g2()) {
                    return d2.S3.get() ? d2.Y3 : d2.f3;
                } else if (this.w.L1() && this.w.w() == 1) {
                    return d2.S3.get() ? d2.Z3 : d2.f3;
                } else if (this.w.h2()) {
                    return d2.B3;
                } else {
                    if (this.w.E2()) {
                        return this.w.f0() != null ? d2.O3 : d2.N3;
                    }
                    c.a.r0.t3.j0.o oVar = this.w.N2;
                    if (oVar != null && oVar.f()) {
                        return this.w.N2.g() ? AdvertAppInfo.H4 : AdvertAppInfo.I4;
                    } else if (this.v) {
                        return d2.k3;
                    } else {
                        if (this.f12884e) {
                            return d2.l3;
                        }
                        if (this.f12885f) {
                            return d2.m3;
                        }
                        if (this.f12886g) {
                            return d2.n3;
                        }
                        if (this.f12887h) {
                            return d2.o3;
                        }
                        if (this.f12888i) {
                            return d2.p3;
                        }
                        if (this.f12889j) {
                            return d2.q3;
                        }
                        if (this.f12890k) {
                            return d2.s3;
                        }
                        if (this.l) {
                            return d2.t3;
                        }
                        if (this.m) {
                            return d2.D3;
                        }
                        if (this.n) {
                            return d2.V3;
                        }
                        if (this.w.c2()) {
                            if (this.o) {
                                return d2.M3;
                            }
                            return d2.C3;
                        } else if (this.p) {
                            return d2.R3;
                        } else {
                            if (this.q) {
                                return d2.w3;
                            }
                            if (this.r) {
                                return d2.x3;
                            }
                            if (this.s) {
                                return d2.y3;
                            }
                            if (this.t) {
                                return d2.z3;
                            }
                            if (this.u) {
                                return d2.A3;
                            }
                            return d2.f3;
                        }
                    }
                }
            }
            return d2.e3;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
