package b.c.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes6.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f31024a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f31025b;

    /* renamed from: c  reason: collision with root package name */
    public final int f31026c;

    /* renamed from: d  reason: collision with root package name */
    public final int f31027d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f31028e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f31029f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f31030g;

    /* renamed from: h  reason: collision with root package name */
    public final int f31031h;

    /* renamed from: i  reason: collision with root package name */
    public final int f31032i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    @Nullable
    public String m;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f31033a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f31034b;

        /* renamed from: c  reason: collision with root package name */
        public int f31035c;

        /* renamed from: d  reason: collision with root package name */
        public int f31036d;

        /* renamed from: e  reason: collision with root package name */
        public int f31037e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f31038f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f31039g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f31040h;

        public a() {
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
            this.f31035c = -1;
            this.f31036d = -1;
            this.f31037e = -1;
        }

        public d a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new d(this) : (d) invokeV.objValue;
        }

        public a b(int i2, TimeUnit timeUnit) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, timeUnit)) == null) {
                if (i2 >= 0) {
                    long seconds = timeUnit.toSeconds(i2);
                    this.f31036d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                    return this;
                }
                throw new IllegalArgumentException("maxStale < 0: " + i2);
            }
            return (a) invokeIL.objValue;
        }

        public a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.f31033a = true;
                return this;
            }
            return (a) invokeV.objValue;
        }

        public a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                this.f31038f = true;
                return this;
            }
            return (a) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(712794601, "Lb/c/b/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(712794601, "Lb/c/b/d;");
                return;
            }
        }
        a aVar = new a();
        aVar.c();
        aVar.a();
        a aVar2 = new a();
        aVar2.d();
        aVar2.b(Integer.MAX_VALUE, TimeUnit.SECONDS);
        aVar2.a();
    }

    public d(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z6), Boolean.valueOf(z7), Boolean.valueOf(z8), str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f31024a = z;
        this.f31025b = z2;
        this.f31026c = i2;
        this.f31027d = i3;
        this.f31028e = z3;
        this.f31029f = z4;
        this.f31030g = z5;
        this.f31031h = i4;
        this.f31032i = i5;
        this.j = z6;
        this.k = z7;
        this.l = z8;
        this.m = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static d k(r rVar) {
        InterceptResult invokeL;
        int i2;
        int i3;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, rVar)) == null) {
            r rVar2 = rVar;
            int g2 = rVar.g();
            int i4 = 0;
            boolean z = true;
            String str2 = null;
            boolean z2 = false;
            boolean z3 = false;
            int i5 = -1;
            int i6 = -1;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            int i7 = -1;
            int i8 = -1;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            while (i4 < g2) {
                String e2 = rVar2.e(i4);
                String h2 = rVar2.h(i4);
                if (e2.equalsIgnoreCase("Cache-Control")) {
                    if (str2 == null) {
                        str2 = h2;
                        for (i2 = 0; i2 < h2.length(); i2 = i3) {
                            int f2 = b.c.b.e0.i.e.f(h2, i2, "=,;");
                            String trim = h2.substring(i2, f2).trim();
                            if (f2 == h2.length() || h2.charAt(f2) == ',' || h2.charAt(f2) == ';') {
                                i3 = f2 + 1;
                                str = null;
                            } else {
                                int g3 = b.c.b.e0.i.e.g(h2, f2 + 1);
                                if (g3 < h2.length() && h2.charAt(g3) == '\"') {
                                    int i9 = g3 + 1;
                                    int f3 = b.c.b.e0.i.e.f(h2, i9, "\"");
                                    str = h2.substring(i9, f3);
                                    i3 = f3 + 1;
                                } else {
                                    i3 = b.c.b.e0.i.e.f(h2, g3, ",;");
                                    str = h2.substring(g3, i3).trim();
                                }
                            }
                            if ("no-cache".equalsIgnoreCase(trim)) {
                                z2 = true;
                            } else if ("no-store".equalsIgnoreCase(trim)) {
                                z3 = true;
                            } else if (ClientCookie.MAX_AGE_ATTR.equalsIgnoreCase(trim)) {
                                i5 = b.c.b.e0.i.e.d(str, -1);
                            } else if ("s-maxage".equalsIgnoreCase(trim)) {
                                i6 = b.c.b.e0.i.e.d(str, -1);
                            } else if (PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equalsIgnoreCase(trim)) {
                                z4 = true;
                            } else if ("public".equalsIgnoreCase(trim)) {
                                z5 = true;
                            } else if ("must-revalidate".equalsIgnoreCase(trim)) {
                                z6 = true;
                            } else if ("max-stale".equalsIgnoreCase(trim)) {
                                i7 = b.c.b.e0.i.e.d(str, Integer.MAX_VALUE);
                            } else if ("min-fresh".equalsIgnoreCase(trim)) {
                                i8 = b.c.b.e0.i.e.d(str, -1);
                            } else if ("only-if-cached".equalsIgnoreCase(trim)) {
                                z7 = true;
                            } else if ("no-transform".equalsIgnoreCase(trim)) {
                                z8 = true;
                            } else if ("immutable".equalsIgnoreCase(trim)) {
                                z9 = true;
                            }
                        }
                        i4++;
                        rVar2 = rVar;
                    }
                } else if (!e2.equalsIgnoreCase("Pragma")) {
                    i4++;
                    rVar2 = rVar;
                }
                z = false;
                while (i2 < h2.length()) {
                }
                i4++;
                rVar2 = rVar;
            }
            return new d(z2, z3, i5, i6, z4, z5, z6, i7, i8, z7, z8, z9, !z ? null : str2);
        }
        return (d) invokeL.objValue;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.f31024a) {
                sb.append("no-cache, ");
            }
            if (this.f31025b) {
                sb.append("no-store, ");
            }
            if (this.f31026c != -1) {
                sb.append("max-age=");
                sb.append(this.f31026c);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            if (this.f31027d != -1) {
                sb.append("s-maxage=");
                sb.append(this.f31027d);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            if (this.f31028e) {
                sb.append("private, ");
            }
            if (this.f31029f) {
                sb.append("public, ");
            }
            if (this.f31030g) {
                sb.append("must-revalidate, ");
            }
            if (this.f31031h != -1) {
                sb.append("max-stale=");
                sb.append(this.f31031h);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            if (this.f31032i != -1) {
                sb.append("min-fresh=");
                sb.append(this.f31032i);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            if (this.j) {
                sb.append("only-if-cached, ");
            }
            if (this.k) {
                sb.append("no-transform, ");
            }
            if (this.l) {
                sb.append("immutable, ");
            }
            if (sb.length() == 0) {
                return "";
            }
            sb.delete(sb.length() - 2, sb.length());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31028e : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31029f : invokeV.booleanValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31026c : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f31031h : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f31032i : invokeV.intValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31030g : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f31024a : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f31025b : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            String str = this.m;
            if (str != null) {
                return str;
            }
            String a2 = a();
            this.m = a2;
            return a2;
        }
        return (String) invokeV.objValue;
    }

    public d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31024a = aVar.f31033a;
        this.f31025b = aVar.f31034b;
        this.f31026c = aVar.f31035c;
        this.f31027d = -1;
        this.f31028e = false;
        this.f31029f = false;
        this.f31030g = false;
        this.f31031h = aVar.f31036d;
        this.f31032i = aVar.f31037e;
        this.j = aVar.f31038f;
        this.k = aVar.f31039g;
        this.l = aVar.f31040h;
    }
}
