package c.a.c0.v.c0;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class p implements c.a.c0.v.p0.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final q f2362i;
    public transient /* synthetic */ FieldHolder $fh;
    public final SparseArray<Object> a;

    /* renamed from: b  reason: collision with root package name */
    public String f2363b;

    /* renamed from: c  reason: collision with root package name */
    public Object f2364c;

    /* renamed from: d  reason: collision with root package name */
    public int f2365d;

    /* renamed from: e  reason: collision with root package name */
    public int f2366e;

    /* renamed from: f  reason: collision with root package name */
    public int f2367f;

    /* renamed from: g  reason: collision with root package name */
    public StringBuilder f2368g;

    /* renamed from: h  reason: collision with root package name */
    public int f2369h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(531806232, "Lc/a/c0/v/c0/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(531806232, "Lc/a/c0/v/c0/p;");
                return;
            }
        }
        f2362i = new q();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p() {
        this("");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static p a(@NonNull p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, pVar)) == null) {
            p a = f2362i.a();
            a.v(pVar.f2365d);
            a.p(pVar.f2363b);
            a.t(pVar.f2364c);
            a.u(pVar.f2366e);
            a.s(pVar.f2367f);
            a.q(pVar.a);
            a.r(pVar.f2369h);
            return a;
        }
        return (p) invokeL.objValue;
    }

    public static p m(@NonNull String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2)) == null) {
            p a = f2362i.a();
            a.v(i2);
            a.p(str);
            return a;
        }
        return (p) invokeLI.objValue;
    }

    public boolean b(@NonNull c.a.c0.v.f0.j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) ? k() == jVar || !(l() == -1 || l() == jVar.getType()) : invokeL.booleanValue;
    }

    @NonNull
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2363b : (String) invokeV.objValue;
    }

    public boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? e(i2, false) : invokeI.booleanValue;
    }

    public boolean e(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            Object obj = this.a.get(i2);
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }
        return invokeCommon.booleanValue;
    }

    public Object f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.a.get(i2) : invokeI.objValue;
    }

    public int g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? h(i2, 0) : invokeI.intValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f2365d : invokeV.intValue;
    }

    public int h(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i2, i3)) == null) {
            Object obj = this.a.get(i2);
            return obj instanceof Integer ? ((Integer) obj).intValue() : i3;
        }
        return invokeII.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f2369h : invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f2367f : invokeV.intValue;
    }

    @Nullable
    public Object k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f2364c : invokeV.objValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f2366e : invokeV.intValue;
    }

    public void n(int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, obj) == null) {
            this.a.put(i2, obj);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            f2362i.d(this);
        }
    }

    @Override // c.a.c0.v.p0.c
    public void onInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.a.clear();
        }
    }

    @Override // c.a.c0.v.p0.c
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f2363b = "";
            this.f2364c = null;
            this.f2366e = -1;
            this.f2365d = -1;
            this.f2367f = 0;
            this.f2369h = 0;
            this.a.clear();
        }
    }

    public void p(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.f2363b = str;
        }
    }

    public void q(@NonNull SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, sparseArray) == null) {
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                this.a.put(sparseArray.keyAt(i2), sparseArray.valueAt(i2));
            }
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f2369h = i2;
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.f2367f = i2;
        }
    }

    public void t(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, obj) == null) {
            this.f2364c = obj;
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            StringBuilder sb = this.f2368g;
            if (sb == null) {
                this.f2368g = new StringBuilder();
            } else if (sb.length() > 0) {
                StringBuilder sb2 = this.f2368g;
                sb2.delete(0, sb2.length());
            }
            StringBuilder sb3 = this.f2368g;
            sb3.append("Action :");
            sb3.append(this.f2363b);
            sb3.append(", type :");
            sb3.append(this.f2365d);
            sb3.append(", from :");
            sb3.append(this.f2364c);
            sb3.append(", priority :");
            sb3.append(this.f2367f);
            sb3.append(", targetType :");
            sb3.append(this.f2366e);
            sb3.append(", bundle :");
            sb3.append(this.a.toString());
            sb3.append(", hash :");
            sb3.append(hashCode());
            return this.f2368g.toString();
        }
        return (String) invokeV.objValue;
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f2366e = i2;
        }
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.f2365d = i2;
        }
    }

    @Override // c.a.c0.v.p0.c
    public boolean verify(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new SparseArray<>(3);
        this.f2365d = -1;
        this.f2366e = -1;
        this.f2367f = 0;
        this.f2369h = 0;
        this.f2363b = str;
    }
}
