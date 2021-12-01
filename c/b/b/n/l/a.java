package c.b.b.n.l;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class a implements Comparable<a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final c.b.b.q.a<String> f27578g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final long f27579e;

    /* renamed from: f  reason: collision with root package name */
    public final int f27580f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(339257936, "Lc/b/b/n/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(339257936, "Lc/b/b/n/l/a;");
                return;
            }
        }
        f27578g = new c.b.b.q.a<>();
    }

    public a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27579e = j2;
        this.f27580f = Long.numberOfTrailingZeros(j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
        r7 = c.b.b.n.l.a.f27578g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
        if (r0 >= r7.f27768f) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
        return r7.get(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j2)) == null) {
            int i2 = -1;
            while (j2 != 0 && (i2 = i2 + 1) < 63 && ((j2 >> i2) & 1) == 0) {
            }
            return null;
        }
        return (String) invokeJ.objValue;
    }

    public static final long c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, str)) != null) {
            return invokeL.longValue;
        }
        int i2 = 0;
        while (true) {
            c.b.b.q.a<String> aVar = f27578g;
            if (i2 >= aVar.f27768f) {
                return 0L;
            }
            if (aVar.get(i2).compareTo(str) == 0) {
                return 1 << i2;
            }
            i2++;
        }
    }

    public static final long d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            long c2 = c(str);
            if (c2 > 0) {
                return c2;
            }
            f27578g.a(str);
            return 1 << (f27578g.f27768f - 1);
        }
        return invokeL.longValue;
    }

    public boolean a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? aVar.hashCode() == hashCode() : invokeL.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.f27579e != aVar.f27579e) {
                    return false;
                }
                return a(aVar);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27580f * 7489 : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b(this.f27579e) : (String) invokeV.objValue;
    }
}
