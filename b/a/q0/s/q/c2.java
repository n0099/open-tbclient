package b.a.q0.s.q;

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
/* loaded from: classes4.dex */
public class c2 extends a implements b.a.e.m.e.n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14034e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14035f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14036g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14037h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14038i;
    public boolean j;
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
        this.f14034e = false;
        this.f14035f = false;
        this.f14036g = false;
        this.f14037h = false;
        this.f14038i = false;
        this.j = false;
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

    @Override // b.a.q0.s.q.a
    public x0 getNegFeedBackData() {
        InterceptResult invokeV;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d2 d2Var = this.w;
            if (d2Var == null || (sparseArray = d2Var.k1) == null || sparseArray.size() <= 0) {
                return null;
            }
            x0 x0Var = new x0();
            x0Var.o(getThreadData().t1());
            x0Var.k(getThreadData().T());
            x0Var.n(getThreadData().F0());
            x0Var.j(this.w.k1);
            d2 d2Var2 = this.w;
            x0Var.f14266g = d2Var2.l1;
            x0Var.p = d2Var2.Z0;
            x0Var.k = d2Var2.Y0;
            x0Var.m = d2Var2.a1;
            x0Var.l = d2Var2.X0;
            x0Var.q = d2Var2.T1;
            x0Var.o = d2Var2.Q0();
            return x0Var;
        }
        return (x0) invokeV.objValue;
    }

    @Override // b.a.q0.s.q.a
    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.w.b1 : (String) invokeV.objValue;
    }

    @Override // b.a.q0.s.q.a
    public d2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.w : (d2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, b.a.e.m.e.n
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
                if (this.w.r1() != null) {
                    return d2.z3;
                }
                return d2.b3;
            }
            int r0 = this.w.r0();
            d2 d2Var2 = this.w;
            int i3 = d2Var2.i0;
            if (i3 == 63) {
                return d2.L3;
            }
            if (i3 == 64) {
                return d2.M3;
            }
            if (i3 == 65) {
                return d2.r3;
            }
            if (d2Var2.m1() != null && this.w.i0 == 60) {
                return d2.C3;
            }
            if (this.w.m1() != null && ((i2 = this.w.i0) == 49 || i2 == 69)) {
                return d2.A3;
            }
            if (this.w.m1() != null && this.w.i0 == 67) {
                return d2.D3;
            }
            d2 d2Var3 = this.w;
            if (d2Var3.i0 == 51) {
                return d2.B3;
            }
            if (r0 != 2 && r0 != 1) {
                if (d2Var3.r1() != null && this.w.d2() && !this.w.h2()) {
                    return d2.Q3;
                }
                d2 d2Var4 = this.w;
                if (d2Var4.z1 && (originalThreadInfo = d2Var4.y1) != null) {
                    if (originalThreadInfo.w) {
                        if (originalThreadInfo.r != null) {
                            return d2.H3;
                        }
                        if (originalThreadInfo.f()) {
                            return d2.G3;
                        }
                        return d2.F3;
                    }
                    return d2.E3;
                } else if (this.w.f2()) {
                    return d2.O3.get() ? d2.U3 : d2.b3;
                } else if (this.w.K1() && this.w.w() == 1) {
                    return d2.O3.get() ? d2.V3 : d2.b3;
                } else if (this.w.g2()) {
                    return d2.x3;
                } else {
                    if (this.w.D2()) {
                        return this.w.e0() != null ? d2.K3 : d2.J3;
                    }
                    b.a.r0.m3.j0.o oVar = this.w.K2;
                    if (oVar != null && oVar.f()) {
                        return this.w.K2.g() ? AdvertAppInfo.C4 : AdvertAppInfo.D4;
                    } else if (this.v) {
                        return d2.g3;
                    } else {
                        if (this.f14034e) {
                            return d2.h3;
                        }
                        if (this.f14035f) {
                            return d2.i3;
                        }
                        if (this.f14036g) {
                            return d2.j3;
                        }
                        if (this.f14037h) {
                            return d2.k3;
                        }
                        if (this.f14038i) {
                            return d2.l3;
                        }
                        if (this.j) {
                            return d2.m3;
                        }
                        if (this.k) {
                            return d2.o3;
                        }
                        if (this.l) {
                            return d2.p3;
                        }
                        if (this.m) {
                            return d2.z3;
                        }
                        if (this.n) {
                            return d2.R3;
                        }
                        if (this.w.b2()) {
                            if (this.o) {
                                return d2.I3;
                            }
                            return d2.y3;
                        } else if (this.p) {
                            return d2.N3;
                        } else {
                            if (this.q) {
                                return d2.s3;
                            }
                            if (this.r) {
                                return d2.t3;
                            }
                            if (this.s) {
                                return d2.u3;
                            }
                            if (this.t) {
                                return d2.v3;
                            }
                            if (this.u) {
                                return d2.w3;
                            }
                            return d2.b3;
                        }
                    }
                }
            }
            return d2.a3;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
