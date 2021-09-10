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
/* loaded from: classes3.dex */
public class c2 extends a implements c.a.e.l.e.n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14122e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14123f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14124g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14125h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14126i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f14127j;
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
        this.f14122e = false;
        this.f14123f = false;
        this.f14124g = false;
        this.f14125h = false;
        this.f14126i = false;
        this.f14127j = false;
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

    @Override // c.a.q0.s.q.a
    public x0 getNegFeedBackData() {
        InterceptResult invokeV;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d2 d2Var = this.w;
            if (d2Var == null || (sparseArray = d2Var.j1) == null || sparseArray.size() <= 0) {
                return null;
            }
            x0 x0Var = new x0();
            x0Var.p(getThreadData().s1());
            x0Var.l(getThreadData().T());
            x0Var.o(getThreadData().F0());
            x0Var.k(this.w.j1);
            d2 d2Var2 = this.w;
            x0Var.f14351g = d2Var2.k1;
            x0Var.p = d2Var2.Y0;
            x0Var.k = d2Var2.X0;
            x0Var.m = d2Var2.Z0;
            x0Var.l = d2Var2.W0;
            x0Var.q = d2Var2.S1;
            x0Var.o = d2Var2.Q0();
            return x0Var;
        }
        return (x0) invokeV.objValue;
    }

    @Override // c.a.q0.s.q.a
    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.w.a1 : (String) invokeV.objValue;
    }

    @Override // c.a.q0.s.q.a
    public d2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.w : (d2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.e.l.e.n
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
            if (d2Var.i0()) {
                if (this.w.q1() != null) {
                    return d2.w3;
                }
                return d2.Z2;
            }
            int r0 = this.w.r0();
            d2 d2Var2 = this.w;
            int i3 = d2Var2.c0;
            if (i3 == 63) {
                return d2.I3;
            }
            if (i3 == 64) {
                return d2.J3;
            }
            if (i3 == 65) {
                return d2.o3;
            }
            if (d2Var2.l1() != null && this.w.c0 == 60) {
                return d2.z3;
            }
            if (this.w.l1() != null && ((i2 = this.w.c0) == 49 || i2 == 69)) {
                return d2.x3;
            }
            if (this.w.l1() != null && this.w.c0 == 67) {
                return d2.A3;
            }
            d2 d2Var3 = this.w;
            if (d2Var3.c0 == 51) {
                return d2.y3;
            }
            if (r0 != 2 && r0 != 1) {
                if (d2Var3.q1() != null && this.w.b2() && !this.w.f2()) {
                    return d2.O3;
                }
                d2 d2Var4 = this.w;
                if (d2Var4.y1 && (originalThreadInfo = d2Var4.x1) != null) {
                    if (originalThreadInfo.w) {
                        if (originalThreadInfo.r != null) {
                            return d2.E3;
                        }
                        if (originalThreadInfo.f()) {
                            return d2.D3;
                        }
                        return d2.C3;
                    }
                    return d2.B3;
                } else if (this.w.d2()) {
                    return d2.L3.get() ? d2.S3 : d2.Z2;
                } else if (this.w.I1() && this.w.w() == 1) {
                    return d2.L3.get() ? d2.T3 : d2.Z2;
                } else if (this.w.e2()) {
                    return d2.u3;
                } else {
                    if (this.w.B2()) {
                        return this.w.e0() != null ? d2.H3 : d2.G3;
                    }
                    c.a.r0.j3.i0.o oVar = this.w.J2;
                    if (oVar != null && oVar.f()) {
                        return this.w.J2.g() ? AdvertAppInfo.A4 : AdvertAppInfo.B4;
                    } else if (this.v) {
                        return d2.e3;
                    } else {
                        if (this.f14122e) {
                            return d2.f3;
                        }
                        if (this.f14123f) {
                            return d2.g3;
                        }
                        if (this.f14124g) {
                            return d2.h3;
                        }
                        if (this.f14125h) {
                            return d2.i3;
                        }
                        if (this.f14126i) {
                            return d2.j3;
                        }
                        if (this.f14127j) {
                            return d2.k3;
                        }
                        if (this.k) {
                            return d2.l3;
                        }
                        if (this.l) {
                            return d2.m3;
                        }
                        if (this.m) {
                            return d2.w3;
                        }
                        if (this.n) {
                            return d2.P3;
                        }
                        if (this.w.Z1()) {
                            if (this.o) {
                                return d2.F3;
                            }
                            return d2.v3;
                        } else if (this.p) {
                            return d2.K3;
                        } else {
                            if (this.q) {
                                return d2.p3;
                            }
                            if (this.r) {
                                return d2.q3;
                            }
                            if (this.s) {
                                return d2.r3;
                            }
                            if (this.t) {
                                return d2.s3;
                            }
                            if (this.u) {
                                return d2.t3;
                            }
                            return d2.Z2;
                        }
                    }
                }
            }
            return d2.Y2;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
