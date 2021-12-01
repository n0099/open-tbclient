package c.a.p0.a.h0.l.g.o;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import c.a.p0.a.y1.b.d;
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
    public static final boolean f5722c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f5723d;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<C0289a> a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<C0289a> f5724b;

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
        f5722c = k.a;
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
        this.a = c.a.p0.a.z2.a1.a.a(new C0289a[0]);
        this.f5724b = c.a.p0.a.z2.a1.a.a(new C0289a[0]);
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f5723d == null) {
                synchronized (a.class) {
                    if (f5723d == null) {
                        f5723d = new a();
                    }
                }
            }
            return f5723d;
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
            boolean z2 = f5722c;
            synchronized (this.a) {
                this.a.clear();
                this.f5724b.clear();
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
            HashSet a = c.a.p0.a.z2.a1.a.a(new String[0]);
            synchronized (this.a) {
                for (C0289a c0289a : this.a) {
                    a.add(c0289a.a);
                }
                for (C0289a c0289a2 : this.f5724b) {
                    a.add(c0289a2.a);
                }
            }
            return a;
        }
        return (Set) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f5724b.size() > 0 : invokeV.booleanValue;
    }

    public boolean f(C0289a c0289a) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, c0289a)) == null) {
            synchronized (this.a) {
                contains = this.a.contains(c0289a);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public boolean g(C0289a c0289a) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, c0289a)) == null) {
            synchronized (this.a) {
                contains = this.f5724b.contains(c0289a);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public void h(String str) {
        Iterator<C0289a> it;
        Iterator<C0289a> it2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && f5722c) {
            synchronized (this.a) {
                while (this.a.iterator().hasNext()) {
                    String str2 = "loaded:" + it.next();
                }
                while (this.f5724b.iterator().hasNext()) {
                    String str3 = "loading:" + it2.next();
                }
            }
        }
    }

    public void i(C0289a c0289a, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048583, this, c0289a, z) == null) && c0289a != null && c0289a.a()) {
            if (f5722c) {
                StringBuilder sb = new StringBuilder();
                sb.append("record one app status - ");
                sb.append(z ? "loaded" : "loading");
                sb.toString();
                String str = "record one app - " + c0289a;
            }
            synchronized (this.a) {
                (z ? this.a : this.f5724b).add(c0289a);
            }
        }
    }

    public void j(JSONObject jSONObject) {
        int length;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) || jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        if (f5722c) {
            String str = "get multi preload status - " + jSONObject;
        }
        synchronized (this.a) {
            b(false);
            JSONArray optJSONArray = jSONObject.optJSONArray("loaded");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    i(new C0289a(optJSONArray.optJSONObject(i2)), true);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("loading");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                i(new C0289a(optJSONObject), false);
            }
        }
        k();
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.p0.a.y1.b.c w = d.P("swan_multi_preload_on_server").A("swan_multi_preload_app_ids", (String[]) d().toArray(new String[0])).w("swan_multi_preload_app_process_index", SwanAppProcessInfo.current().index);
            w.K(true);
            w.call();
            boolean z = f5722c;
        }
    }

    /* renamed from: c.a.p0.a.h0.l.g.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0289a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final String f5725b;

        public C0289a(String str, long j2) {
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
            this.a = str;
            this.f5725b = String.valueOf(j2);
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.f5725b)) ? false : true : invokeV.booleanValue;
        }

        public boolean equals(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof C0289a) {
                    C0289a c0289a = (C0289a) obj;
                    return TextUtils.equals(this.a, c0289a.a) && TextUtils.equals(this.f5725b, c0289a.f5725b);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                String str = this.a;
                int hashCode = str == null ? 0 : str.hashCode();
                String str2 = this.f5725b;
                return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "Item{appKey='" + this.a + ExtendedMessageFormat.QUOTE + ", version='" + this.f5725b + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }

        public C0289a(JSONObject jSONObject) {
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
                this.f5725b = null;
                this.a = null;
                return;
            }
            this.a = jSONObject.optString("appKey");
            this.f5725b = jSONObject.optString("version");
        }
    }
}
