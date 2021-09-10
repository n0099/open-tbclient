package c.a.p0.a.h0.l.g.o;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f6154c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f6155d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Set<C0227a> f6156a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<C0227a> f6157b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-423907499, "Lc/a/p0/a/h0/l/g/o/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-423907499, "Lc/a/p0/a/h0/l/g/o/a;");
                return;
            }
        }
        f6154c = k.f7077a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6156a = c.a.p0.a.v2.z0.a.a(new C0227a[0]);
        this.f6157b = c.a.p0.a.v2.z0.a.a(new C0227a[0]);
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f6155d == null) {
                synchronized (a.class) {
                    if (f6155d == null) {
                        f6155d = new a();
                    }
                }
            }
            return f6155d;
        }
        return (a) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b(true);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            boolean z2 = f6154c;
            synchronized (this.f6156a) {
                this.f6156a.clear();
                this.f6157b.clear();
            }
            if (z) {
                k();
            }
        }
    }

    public Set<String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HashSet a2 = c.a.p0.a.v2.z0.a.a(new String[0]);
            synchronized (this.f6156a) {
                for (C0227a c0227a : this.f6156a) {
                    a2.add(c0227a.f6158a);
                }
                for (C0227a c0227a2 : this.f6157b) {
                    a2.add(c0227a2.f6158a);
                }
            }
            return a2;
        }
        return (Set) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f6157b.size() > 0 : invokeV.booleanValue;
    }

    public boolean f(C0227a c0227a) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, c0227a)) == null) {
            synchronized (this.f6156a) {
                contains = this.f6156a.contains(c0227a);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public boolean g(C0227a c0227a) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, c0227a)) == null) {
            synchronized (this.f6156a) {
                contains = this.f6157b.contains(c0227a);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public void h(String str) {
        Iterator<C0227a> it;
        Iterator<C0227a> it2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && f6154c) {
            synchronized (this.f6156a) {
                while (this.f6156a.iterator().hasNext()) {
                    String str2 = "loaded:" + it.next();
                }
                while (this.f6157b.iterator().hasNext()) {
                    String str3 = "loading:" + it2.next();
                }
            }
        }
    }

    public void i(C0227a c0227a, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048583, this, c0227a, z) == null) && c0227a != null && c0227a.a()) {
            if (f6154c) {
                StringBuilder sb = new StringBuilder();
                sb.append("record one app status - ");
                sb.append(z ? "loaded" : "loading");
                sb.toString();
                String str = "record one app - " + c0227a;
            }
            synchronized (this.f6156a) {
                (z ? this.f6156a : this.f6157b).add(c0227a);
            }
        }
    }

    public void j(JSONObject jSONObject) {
        int length;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) || jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        if (f6154c) {
            String str = "get multi preload status - " + jSONObject;
        }
        synchronized (this.f6156a) {
            b(false);
            JSONArray optJSONArray = jSONObject.optJSONArray("loaded");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    i(new C0227a(optJSONArray.optJSONObject(i2)), true);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("loading");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                i(new C0227a(optJSONObject), false);
            }
        }
        k();
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.p0.a.v1.b.b v = c.a.p0.a.v1.b.c.E("swan_multi_preload_on_server").z("swan_multi_preload_app_ids", (String[]) d().toArray(new String[0])).v("swan_multi_preload_app_process_index", SwanAppProcessInfo.current().index);
            v.K(true);
            v.L();
            boolean z = f6154c;
        }
    }

    /* renamed from: c.a.p0.a.h0.l.g.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0227a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f6158a;

        /* renamed from: b  reason: collision with root package name */
        public final String f6159b;

        public C0227a(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6158a = str;
            this.f6159b = String.valueOf(j2);
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.f6158a) || TextUtils.isEmpty(this.f6159b)) ? false : true : invokeV.booleanValue;
        }

        public boolean equals(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof C0227a) {
                    C0227a c0227a = (C0227a) obj;
                    return TextUtils.equals(this.f6158a, c0227a.f6158a) && TextUtils.equals(this.f6159b, c0227a.f6159b);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                String str = this.f6158a;
                int hashCode = str == null ? 0 : str.hashCode();
                String str2 = this.f6159b;
                return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "Item{appKey='" + this.f6158a + ExtendedMessageFormat.QUOTE + ", version='" + this.f6159b + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }

        public C0227a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (jSONObject == null) {
                this.f6159b = null;
                this.f6158a = null;
                return;
            }
            this.f6158a = jSONObject.optString("appKey");
            this.f6159b = jSONObject.optString("version");
        }
    }
}
