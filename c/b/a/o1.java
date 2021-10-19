package c.b.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o1 extends h1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final long[] f31413f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public long f31414d;

    /* renamed from: e  reason: collision with root package name */
    public long f31415e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2074075194, "Lc/b/a/o1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2074075194, "Lc/b/a/o1;");
                return;
            }
        }
        f31413f = new long[]{60000};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o1(j1 j1Var) {
        super(j1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((j1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.b.a.h1
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.b.a.h1
    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long Z = this.f31373a.i().Z();
            if (Z > 60000 || Z <= 0) {
                Z = 60000;
            }
            f31413f[0] = Z;
            return this.f31414d + Z;
        }
        return invokeV.longValue;
    }

    @Override // c.b.a.h1
    public long[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f31413f : (long[]) invokeV.objValue;
    }

    @Override // c.b.a.h1
    public boolean d() {
        InterceptResult invokeV;
        u c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (System.currentTimeMillis() > this.f31415e + this.f31373a.i().Z()) {
                JSONObject j2 = this.f31373a.j().j();
                p1 m = this.f31373a.m();
                if (m != null && j2 != null && (c2 = m.c()) != null) {
                    this.f31373a.h().n(j2, c2, m.h());
                    this.f31415e = System.currentTimeMillis();
                }
            }
            ArrayList<v> e2 = this.f31373a.h().e();
            ArrayList<v> arrayList = new ArrayList<>(e2.size());
            ArrayList<v> arrayList2 = new ArrayList<>(e2.size());
            j1 j1Var = this.f31373a;
            String[] b2 = o.b(j1Var, j1Var.f(), this.f31373a.j().c());
            Iterator<v> it = e2.iterator();
            while (it.hasNext()) {
                v next = it.next();
                int a2 = n.a(b2, next.m, this.f31373a.i());
                if (a2 == 200) {
                    arrayList.add(next);
                } else {
                    next.o = a2;
                    arrayList2.add(next);
                }
            }
            if (arrayList.size() > 0 || arrayList2.size() > 0) {
                this.f31373a.h().k(arrayList, arrayList2);
            }
            h0.e(e() + arrayList.size() + " " + e2.size(), null);
            if (arrayList.size() == e2.size()) {
                this.f31414d = System.currentTimeMillis();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.b.a.h1
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "s" : (String) invokeV.objValue;
    }
}
