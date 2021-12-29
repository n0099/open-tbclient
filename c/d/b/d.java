package c.d.b;

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
/* loaded from: classes9.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f28518b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28519c;

    /* renamed from: d  reason: collision with root package name */
    public final int f28520d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f28521e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f28522f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f28523g;

    /* renamed from: h  reason: collision with root package name */
    public final int f28524h;

    /* renamed from: i  reason: collision with root package name */
    public final int f28525i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f28526j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f28527k;
    public final boolean l;
    @Nullable
    public String m;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f28528b;

        /* renamed from: c  reason: collision with root package name */
        public int f28529c;

        /* renamed from: d  reason: collision with root package name */
        public int f28530d;

        /* renamed from: e  reason: collision with root package name */
        public int f28531e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f28532f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f28533g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f28534h;

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
            this.f28529c = -1;
            this.f28530d = -1;
            this.f28531e = -1;
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
                    this.f28530d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
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
                this.a = true;
                return this;
            }
            return (a) invokeV.objValue;
        }

        public a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                this.f28532f = true;
                return this;
            }
            return (a) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1810733209, "Lc/d/b/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1810733209, "Lc/d/b/d;");
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
        this.a = z;
        this.f28518b = z2;
        this.f28519c = i2;
        this.f28520d = i3;
        this.f28521e = z3;
        this.f28522f = z4;
        this.f28523g = z5;
        this.f28524h = i4;
        this.f28525i = i5;
        this.f28526j = z6;
        this.f28527k = z7;
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
                            int f2 = c.d.b.e0.i.e.f(h2, i2, "=,;");
                            String trim = h2.substring(i2, f2).trim();
                            if (f2 == h2.length() || h2.charAt(f2) == ',' || h2.charAt(f2) == ';') {
                                i3 = f2 + 1;
                                str = null;
                            } else {
                                int g3 = c.d.b.e0.i.e.g(h2, f2 + 1);
                                if (g3 < h2.length() && h2.charAt(g3) == '\"') {
                                    int i9 = g3 + 1;
                                    int f3 = c.d.b.e0.i.e.f(h2, i9, "\"");
                                    str = h2.substring(i9, f3);
                                    i3 = f3 + 1;
                                } else {
                                    i3 = c.d.b.e0.i.e.f(h2, g3, ",;");
                                    str = h2.substring(g3, i3).trim();
                                }
                            }
                            if ("no-cache".equalsIgnoreCase(trim)) {
                                z2 = true;
                            } else if ("no-store".equalsIgnoreCase(trim)) {
                                z3 = true;
                            } else if (ClientCookie.MAX_AGE_ATTR.equalsIgnoreCase(trim)) {
                                i5 = c.d.b.e0.i.e.d(str, -1);
                            } else if ("s-maxage".equalsIgnoreCase(trim)) {
                                i6 = c.d.b.e0.i.e.d(str, -1);
                            } else if (PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equalsIgnoreCase(trim)) {
                                z4 = true;
                            } else if ("public".equalsIgnoreCase(trim)) {
                                z5 = true;
                            } else if ("must-revalidate".equalsIgnoreCase(trim)) {
                                z6 = true;
                            } else if ("max-stale".equalsIgnoreCase(trim)) {
                                i7 = c.d.b.e0.i.e.d(str, Integer.MAX_VALUE);
                            } else if ("min-fresh".equalsIgnoreCase(trim)) {
                                i8 = c.d.b.e0.i.e.d(str, -1);
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
            if (this.a) {
                sb.append("no-cache, ");
            }
            if (this.f28518b) {
                sb.append("no-store, ");
            }
            if (this.f28519c != -1) {
                sb.append("max-age=");
                sb.append(this.f28519c);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            if (this.f28520d != -1) {
                sb.append("s-maxage=");
                sb.append(this.f28520d);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            if (this.f28521e) {
                sb.append("private, ");
            }
            if (this.f28522f) {
                sb.append("public, ");
            }
            if (this.f28523g) {
                sb.append("must-revalidate, ");
            }
            if (this.f28524h != -1) {
                sb.append("max-stale=");
                sb.append(this.f28524h);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            if (this.f28525i != -1) {
                sb.append("min-fresh=");
                sb.append(this.f28525i);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            if (this.f28526j) {
                sb.append("only-if-cached, ");
            }
            if (this.f28527k) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28521e : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28522f : invokeV.booleanValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28519c : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28524h : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28525i : invokeV.intValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f28523g : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f28518b : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f28526j : invokeV.booleanValue;
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
        this.a = aVar.a;
        this.f28518b = aVar.f28528b;
        this.f28519c = aVar.f28529c;
        this.f28520d = -1;
        this.f28521e = false;
        this.f28522f = false;
        this.f28523g = false;
        this.f28524h = aVar.f28530d;
        this.f28525i = aVar.f28531e;
        this.f28526j = aVar.f28532f;
        this.f28527k = aVar.f28533g;
        this.l = aVar.f28534h;
    }
}
