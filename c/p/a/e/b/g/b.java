package c.p.a.e.b.g;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int B;

    /* renamed from: a  reason: collision with root package name */
    public final Context f35116a;

    /* renamed from: b  reason: collision with root package name */
    public k f35117b;

    /* renamed from: c  reason: collision with root package name */
    public l f35118c;

    /* renamed from: d  reason: collision with root package name */
    public j f35119d;

    /* renamed from: e  reason: collision with root package name */
    public c.p.a.e.b.f.j f35120e;

    /* renamed from: f  reason: collision with root package name */
    public c.p.a.e.b.o.a f35121f;

    /* renamed from: g  reason: collision with root package name */
    public c.p.a.e.b.o.j f35122g;

    /* renamed from: h  reason: collision with root package name */
    public c.p.a.e.b.o.h f35123h;

    /* renamed from: i  reason: collision with root package name */
    public m f35124i;

    /* renamed from: j  reason: collision with root package name */
    public i f35125j;
    public q k;
    public c.p.a.e.b.e.b l;
    public List<c.p.a.e.b.f.r> m;
    public c.p.a.e.b.f.f n;
    public ExecutorService o;
    public ExecutorService p;
    public ExecutorService q;
    public ExecutorService r;
    public ExecutorService s;
    public ExecutorService t;
    public ExecutorService u;
    public ExecutorService v;
    public u w;
    public int x;
    public int y;
    public boolean z;

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new ArrayList();
        this.A = true;
        this.B = 1056964607;
        this.f35116a = context;
    }

    public c.p.a.e.b.f.j A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f35120e : (c.p.a.e.b.f.j) invokeV.objValue;
    }

    public ExecutorService B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.v : (ExecutorService) invokeV.objValue;
    }

    public u C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.w : (u) invokeV.objValue;
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.y : invokeV.intValue;
    }

    public b E(c.p.a.e.b.o.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            this.f35121f = aVar;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.A : invokeV.booleanValue;
    }

    public b H(c.p.a.e.b.f.j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jVar)) == null) {
            this.f35120e = jVar;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b a(c.p.a.e.b.f.r rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rVar)) == null) {
            synchronized (this.m) {
                if (rVar != null) {
                    if (!this.m.contains(rVar)) {
                        this.m.add(rVar);
                        return this;
                    }
                }
                return this;
            }
        }
        return (b) invokeL.objValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new a(this) : (a) invokeV.objValue;
    }

    public b c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            this.B = i2;
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b d(c.p.a.e.b.f.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, fVar)) == null) {
            this.n = fVar;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public ExecutorService e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.o : (ExecutorService) invokeV.objValue;
    }

    public i f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f35125j : (i) invokeV.objValue;
    }

    public j g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f35119d : (j) invokeV.objValue;
    }

    public ExecutorService h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.u : (ExecutorService) invokeV.objValue;
    }

    public Context i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f35116a : (Context) invokeV.objValue;
    }

    public ExecutorService j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.t : (ExecutorService) invokeV.objValue;
    }

    public k k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f35117b : (k) invokeV.objValue;
    }

    public List<c.p.a.e.b.f.r> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.m : (List) invokeV.objValue;
    }

    public c.p.a.e.b.o.h m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f35123h : (c.p.a.e.b.o.h) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.B : invokeV.intValue;
    }

    public m o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f35124i : (m) invokeV.objValue;
    }

    public c.p.a.e.b.e.b p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.l : (c.p.a.e.b.e.b) invokeV.objValue;
    }

    public c.p.a.e.b.f.f q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.n : (c.p.a.e.b.f.f) invokeV.objValue;
    }

    public c.p.a.e.b.o.j r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f35122g : (c.p.a.e.b.o.j) invokeV.objValue;
    }

    public c.p.a.e.b.o.a s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f35121f : (c.p.a.e.b.o.a) invokeV.objValue;
    }

    public ExecutorService t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.p : (ExecutorService) invokeV.objValue;
    }

    public l u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f35118c : (l) invokeV.objValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.x : invokeV.intValue;
    }

    public ExecutorService w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.s : (ExecutorService) invokeV.objValue;
    }

    public ExecutorService x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.q : (ExecutorService) invokeV.objValue;
    }

    public ExecutorService y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.r : (ExecutorService) invokeV.objValue;
    }

    public q z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.k : (q) invokeV.objValue;
    }
}
