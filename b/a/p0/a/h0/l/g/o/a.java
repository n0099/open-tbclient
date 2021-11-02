package b.a.p0.a.h0.l.g.o;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
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
    public static final boolean f5501c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f5502d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Set<C0222a> f5503a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<C0222a> f5504b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-15083274, "Lb/a/p0/a/h0/l/g/o/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-15083274, "Lb/a/p0/a/h0/l/g/o/a;");
                return;
            }
        }
        f5501c = k.f6397a;
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
        this.f5503a = b.a.p0.a.v2.z0.a.a(new C0222a[0]);
        this.f5504b = b.a.p0.a.v2.z0.a.a(new C0222a[0]);
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f5502d == null) {
                synchronized (a.class) {
                    if (f5502d == null) {
                        f5502d = new a();
                    }
                }
            }
            return f5502d;
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
            boolean z2 = f5501c;
            synchronized (this.f5503a) {
                this.f5503a.clear();
                this.f5504b.clear();
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
            HashSet a2 = b.a.p0.a.v2.z0.a.a(new String[0]);
            synchronized (this.f5503a) {
                for (C0222a c0222a : this.f5503a) {
                    a2.add(c0222a.f5505a);
                }
                for (C0222a c0222a2 : this.f5504b) {
                    a2.add(c0222a2.f5505a);
                }
            }
            return a2;
        }
        return (Set) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f5504b.size() > 0 : invokeV.booleanValue;
    }

    public boolean f(C0222a c0222a) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, c0222a)) == null) {
            synchronized (this.f5503a) {
                contains = this.f5503a.contains(c0222a);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public boolean g(C0222a c0222a) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, c0222a)) == null) {
            synchronized (this.f5503a) {
                contains = this.f5504b.contains(c0222a);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public void h(String str) {
        Iterator<C0222a> it;
        Iterator<C0222a> it2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && f5501c) {
            synchronized (this.f5503a) {
                while (this.f5503a.iterator().hasNext()) {
                    String str2 = "loaded:" + it.next();
                }
                while (this.f5504b.iterator().hasNext()) {
                    String str3 = "loading:" + it2.next();
                }
            }
        }
    }

    public void i(C0222a c0222a, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048583, this, c0222a, z) == null) && c0222a != null && c0222a.a()) {
            if (f5501c) {
                StringBuilder sb = new StringBuilder();
                sb.append("record one app status - ");
                sb.append(z ? "loaded" : "loading");
                sb.toString();
                String str = "record one app - " + c0222a;
            }
            synchronized (this.f5503a) {
                (z ? this.f5503a : this.f5504b).add(c0222a);
            }
        }
    }

    public void j(JSONObject jSONObject) {
        int length;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) || jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        if (f5501c) {
            String str = "get multi preload status - " + jSONObject;
        }
        synchronized (this.f5503a) {
            b(false);
            JSONArray optJSONArray = jSONObject.optJSONArray("loaded");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    i(new C0222a(optJSONArray.optJSONObject(i2)), true);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("loading");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                i(new C0222a(optJSONObject), false);
            }
        }
        k();
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            b.a.p0.a.v1.b.b v = b.a.p0.a.v1.b.c.E("swan_multi_preload_on_server").z("swan_multi_preload_app_ids", (String[]) d().toArray(new String[0])).v("swan_multi_preload_app_process_index", SwanAppProcessInfo.current().index);
            v.J(true);
            v.call();
            boolean z = f5501c;
        }
    }

    /* renamed from: b.a.p0.a.h0.l.g.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0222a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f5505a;

        /* renamed from: b  reason: collision with root package name */
        public final String f5506b;

        public C0222a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5505a = str;
            this.f5506b = String.valueOf(j);
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.f5505a) || TextUtils.isEmpty(this.f5506b)) ? false : true : invokeV.booleanValue;
        }

        public boolean equals(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof C0222a) {
                    C0222a c0222a = (C0222a) obj;
                    return TextUtils.equals(this.f5505a, c0222a.f5505a) && TextUtils.equals(this.f5506b, c0222a.f5506b);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                String str = this.f5505a;
                int hashCode = str == null ? 0 : str.hashCode();
                String str2 = this.f5506b;
                return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "Item{appKey='" + this.f5505a + ExtendedMessageFormat.QUOTE + ", version='" + this.f5506b + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }

        public C0222a(JSONObject jSONObject) {
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
                this.f5506b = null;
                this.f5505a = null;
                return;
            }
            this.f5505a = jSONObject.optString("appKey");
            this.f5506b = jSONObject.optString("version");
        }
    }
}
