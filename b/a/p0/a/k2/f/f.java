package b.a.p0.a.k2.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public class f implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f6437a;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f6438a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-164442189, "Lb/a/p0/a/k2/f/f$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-164442189, "Lb/a/p0/a/k2/f/f$a;");
                    return;
                }
            }
            int[] iArr = new int[PathType.values().length];
            f6438a = iArr;
            try {
                iArr[PathType.RELATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6438a[PathType.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6438a[PathType.BD_FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // b.a.p0.a.k2.f.d
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            return P == null ? str : b.a.p0.a.k2.b.H(str, P);
        }
        return (String) invokeL.objValue;
    }

    @Override // b.a.p0.a.k2.f.d
    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? b.a.p0.a.k2.b.G(str) : invokeL.booleanValue;
    }

    @Override // b.a.p0.a.k2.f.d
    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            return P == null ? "" : b.a.p0.a.k2.b.n(P.f3961f, str, null);
        }
        return (String) invokeL.objValue;
    }

    @Override // b.a.p0.a.k2.f.d
    @NonNull
    public synchronized e d() {
        InterceptResult invokeV;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                if (this.f6437a == null) {
                    this.f6437a = new g();
                }
                eVar = this.f6437a;
            }
            return eVar;
        }
        return (e) invokeV.objValue;
    }

    @Override // b.a.p0.a.k2.f.d
    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            if (P == null) {
                return null;
            }
            return b.a.p0.a.k2.b.L(str, P, P.Y());
        }
        return (String) invokeL.objValue;
    }

    @Override // b.a.p0.a.k2.f.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            return P == null ? "" : b.a.p0.a.k2.b.z(P.f3961f);
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.k2.f.d
    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            return P == null ? str : b.a.p0.a.k2.b.I(str, P.f3961f);
        }
        return (String) invokeL.objValue;
    }

    @Override // b.a.p0.a.k2.f.d
    public String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            String s = b.a.p0.t.d.s(str);
            if (TextUtils.isEmpty(s)) {
                return g(str);
            }
            return g(str) + "." + s;
        }
        return (String) invokeL.objValue;
    }

    @Override // b.a.p0.a.k2.f.d
    public String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            if (P == null) {
                return null;
            }
            return b.a.p0.a.k2.b.M(str, P.f3961f);
        }
        return (String) invokeL.objValue;
    }

    @Override // b.a.p0.a.k2.f.d
    public boolean j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            PathType s = b.a.p0.a.k2.b.s(str);
            if (z) {
                s = o(str, s);
            }
            return s != PathType.ERROR;
        }
        return invokeLZ.booleanValue;
    }

    @Override // b.a.p0.a.k2.f.d
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            return P == null ? "" : b.a.p0.a.k2.b.x(P.f3961f);
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.k2.f.d
    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? b.a.p0.a.k2.b.F(str) : invokeL.booleanValue;
    }

    @Override // b.a.p0.a.k2.f.d
    public String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? b.a.p0.a.k2.b.K(str) : (String) invokeL.objValue;
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int indexOf = str.indexOf(com.baidu.android.imsdk.retrieve.Constants.PATH_PARENT);
            if (indexOf != 0) {
                return indexOf > 0;
            }
            String substring = str.substring(3);
            return !TextUtils.isEmpty(substring) && substring.contains(com.baidu.android.imsdk.retrieve.Constants.PATH_PARENT);
        }
        return invokeL.booleanValue;
    }

    public final PathType o(String str, PathType pathType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, pathType)) == null) {
            int i2 = a.f6438a[pathType.ordinal()];
            if (i2 == 1) {
                return n(str) ? PathType.ERROR : pathType;
            } else if (i2 != 2) {
                return i2 != 3 ? PathType.ERROR : pathType;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("bdfile://code");
                sb.append(File.separator);
                return (str.startsWith(sb.toString()) || "bdfile://code".equals(str)) ? PathType.RELATIVE : pathType;
            }
        }
        return (PathType) invokeLL.objValue;
    }
}
