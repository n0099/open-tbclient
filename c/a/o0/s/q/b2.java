package c.a.o0.s.q;

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
public class b2 extends a implements c.a.e.k.e.n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13845e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13846f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13847g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13848h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13849i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f13850j;
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
    public c2 w;
    public int x;
    public int y;

    public b2() {
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
        this.f13845e = false;
        this.f13846f = false;
        this.f13847g = false;
        this.f13848h = false;
        this.f13849i = false;
        this.f13850j = false;
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

    @Override // c.a.o0.s.q.a
    public x0 getNegFeedBackData() {
        InterceptResult invokeV;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c2 c2Var = this.w;
            if (c2Var == null || (sparseArray = c2Var.h1) == null || sparseArray.size() <= 0) {
                return null;
            }
            x0 x0Var = new x0();
            x0Var.p(getThreadData().q1());
            x0Var.l(getThreadData().T());
            x0Var.o(getThreadData().D0());
            x0Var.k(this.w.h1);
            c2 c2Var2 = this.w;
            x0Var.f14081g = c2Var2.i1;
            x0Var.p = c2Var2.W0;
            x0Var.k = c2Var2.V0;
            x0Var.m = c2Var2.X0;
            x0Var.l = c2Var2.U0;
            x0Var.q = c2Var2.Q1;
            x0Var.o = c2Var2.O0();
            return x0Var;
        }
        return (x0) invokeV.objValue;
    }

    @Override // c.a.o0.s.q.a
    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.w.Y0 : (String) invokeV.objValue;
    }

    @Override // c.a.o0.s.q.a
    public c2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.w : (c2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.e.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c2 c2Var = this.w;
            if (c2Var == null) {
                return null;
            }
            if (c2Var.i0()) {
                if (this.w.o1() != null) {
                    return c2.t3;
                }
                return c2.W2;
            }
            int p0 = this.w.p0();
            c2 c2Var2 = this.w;
            int i3 = c2Var2.a0;
            if (i3 == 63) {
                return c2.F3;
            }
            if (i3 == 64) {
                return c2.G3;
            }
            if (i3 == 65) {
                return c2.l3;
            }
            if (c2Var2.j1() != null && this.w.a0 == 60) {
                return c2.w3;
            }
            if (this.w.j1() != null && ((i2 = this.w.a0) == 49 || i2 == 69)) {
                return c2.u3;
            }
            if (this.w.j1() != null && this.w.a0 == 67) {
                return c2.x3;
            }
            c2 c2Var3 = this.w;
            if (c2Var3.a0 == 51) {
                return c2.v3;
            }
            if (p0 != 2 && p0 != 1) {
                if (c2Var3.o1() != null && this.w.Y1() && !this.w.c2()) {
                    return c2.L3;
                }
                c2 c2Var4 = this.w;
                if (c2Var4.w1 && (originalThreadInfo = c2Var4.v1) != null) {
                    if (originalThreadInfo.w) {
                        if (originalThreadInfo.r != null) {
                            return c2.B3;
                        }
                        if (originalThreadInfo.f()) {
                            return c2.A3;
                        }
                        return c2.z3;
                    }
                    return c2.y3;
                } else if (this.w.a2()) {
                    return c2.I3.get() ? c2.P3 : c2.W2;
                } else if (this.w.G1() && this.w.w() == 1) {
                    return c2.I3.get() ? c2.Q3 : c2.W2;
                } else if (this.w.b2()) {
                    return c2.r3;
                } else {
                    if (this.w.x2()) {
                        return this.w.e0() != null ? c2.E3 : c2.D3;
                    }
                    c.a.p0.i3.h0.o oVar = this.w.H2;
                    if (oVar != null && oVar.f()) {
                        return this.w.H2.g() ? AdvertAppInfo.x4 : AdvertAppInfo.y4;
                    } else if (this.v) {
                        return c2.b3;
                    } else {
                        if (this.f13845e) {
                            return c2.c3;
                        }
                        if (this.f13846f) {
                            return c2.d3;
                        }
                        if (this.f13847g) {
                            return c2.e3;
                        }
                        if (this.f13848h) {
                            return c2.f3;
                        }
                        if (this.f13849i) {
                            return c2.g3;
                        }
                        if (this.f13850j) {
                            return c2.h3;
                        }
                        if (this.k) {
                            return c2.i3;
                        }
                        if (this.l) {
                            return c2.j3;
                        }
                        if (this.m) {
                            return c2.t3;
                        }
                        if (this.n) {
                            return c2.M3;
                        }
                        if (this.w.W1()) {
                            if (this.o) {
                                return c2.C3;
                            }
                            return c2.s3;
                        } else if (this.p) {
                            return c2.H3;
                        } else {
                            if (this.q) {
                                return c2.m3;
                            }
                            if (this.r) {
                                return c2.n3;
                            }
                            if (this.s) {
                                return c2.o3;
                            }
                            if (this.t) {
                                return c2.p3;
                            }
                            if (this.u) {
                                return c2.q3;
                            }
                            return c2.W2;
                        }
                    }
                }
            }
            return c2.V2;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
