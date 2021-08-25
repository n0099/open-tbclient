package c.a.o0.a.h0.l.g.o;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.k;
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
    public static final boolean f6126c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f6127d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Set<C0225a> f6128a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<C0225a> f6129b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(86626678, "Lc/a/o0/a/h0/l/g/o/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(86626678, "Lc/a/o0/a/h0/l/g/o/a;");
                return;
            }
        }
        f6126c = k.f7049a;
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
        this.f6128a = c.a.o0.a.v2.z0.a.a(new C0225a[0]);
        this.f6129b = c.a.o0.a.v2.z0.a.a(new C0225a[0]);
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f6127d == null) {
                synchronized (a.class) {
                    if (f6127d == null) {
                        f6127d = new a();
                    }
                }
            }
            return f6127d;
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
            boolean z2 = f6126c;
            synchronized (this.f6128a) {
                this.f6128a.clear();
                this.f6129b.clear();
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
            HashSet a2 = c.a.o0.a.v2.z0.a.a(new String[0]);
            synchronized (this.f6128a) {
                for (C0225a c0225a : this.f6128a) {
                    a2.add(c0225a.f6130a);
                }
                for (C0225a c0225a2 : this.f6129b) {
                    a2.add(c0225a2.f6130a);
                }
            }
            return a2;
        }
        return (Set) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f6129b.size() > 0 : invokeV.booleanValue;
    }

    public boolean f(C0225a c0225a) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, c0225a)) == null) {
            synchronized (this.f6128a) {
                contains = this.f6128a.contains(c0225a);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public boolean g(C0225a c0225a) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, c0225a)) == null) {
            synchronized (this.f6128a) {
                contains = this.f6129b.contains(c0225a);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public void h(String str) {
        Iterator<C0225a> it;
        Iterator<C0225a> it2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && f6126c) {
            synchronized (this.f6128a) {
                while (this.f6128a.iterator().hasNext()) {
                    String str2 = "loaded:" + it.next();
                }
                while (this.f6129b.iterator().hasNext()) {
                    String str3 = "loading:" + it2.next();
                }
            }
        }
    }

    public void i(C0225a c0225a, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048583, this, c0225a, z) == null) && c0225a != null && c0225a.a()) {
            if (f6126c) {
                StringBuilder sb = new StringBuilder();
                sb.append("record one app status - ");
                sb.append(z ? "loaded" : "loading");
                sb.toString();
                String str = "record one app - " + c0225a;
            }
            synchronized (this.f6128a) {
                (z ? this.f6128a : this.f6129b).add(c0225a);
            }
        }
    }

    public void j(JSONObject jSONObject) {
        int length;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) || jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        if (f6126c) {
            String str = "get multi preload status - " + jSONObject;
        }
        synchronized (this.f6128a) {
            b(false);
            JSONArray optJSONArray = jSONObject.optJSONArray("loaded");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    i(new C0225a(optJSONArray.optJSONObject(i2)), true);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("loading");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                i(new C0225a(optJSONObject), false);
            }
        }
        k();
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.o0.a.v1.b.b v = c.a.o0.a.v1.b.c.E("swan_multi_preload_on_server").z("swan_multi_preload_app_ids", (String[]) d().toArray(new String[0])).v("swan_multi_preload_app_process_index", SwanAppProcessInfo.current().index);
            v.K(true);
            v.L();
            boolean z = f6126c;
        }
    }

    /* renamed from: c.a.o0.a.h0.l.g.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0225a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f6130a;

        /* renamed from: b  reason: collision with root package name */
        public final String f6131b;

        public C0225a(String str, long j2) {
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
            this.f6130a = str;
            this.f6131b = String.valueOf(j2);
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.f6130a) || TextUtils.isEmpty(this.f6131b)) ? false : true : invokeV.booleanValue;
        }

        public boolean equals(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof C0225a) {
                    C0225a c0225a = (C0225a) obj;
                    return TextUtils.equals(this.f6130a, c0225a.f6130a) && TextUtils.equals(this.f6131b, c0225a.f6131b);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                String str = this.f6130a;
                int hashCode = str == null ? 0 : str.hashCode();
                String str2 = this.f6131b;
                return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "Item{appKey='" + this.f6130a + ExtendedMessageFormat.QUOTE + ", version='" + this.f6131b + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }

        public C0225a(JSONObject jSONObject) {
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
                this.f6131b = null;
                this.f6130a = null;
                return;
            }
            this.f6130a = jSONObject.optString("appKey");
            this.f6131b = jSONObject.optString("version");
        }
    }
}
