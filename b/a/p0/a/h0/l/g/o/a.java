package b.a.p0.a.h0.l.g.o;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.y1.b.d;
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
    public static final boolean f5781c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f5782d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Set<C0233a> f5783a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<C0233a> f5784b;

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
        f5781c = k.f6863a;
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
        this.f5783a = b.a.p0.a.z2.a1.a.a(new C0233a[0]);
        this.f5784b = b.a.p0.a.z2.a1.a.a(new C0233a[0]);
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f5782d == null) {
                synchronized (a.class) {
                    if (f5782d == null) {
                        f5782d = new a();
                    }
                }
            }
            return f5782d;
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
            boolean z2 = f5781c;
            synchronized (this.f5783a) {
                this.f5783a.clear();
                this.f5784b.clear();
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
            HashSet a2 = b.a.p0.a.z2.a1.a.a(new String[0]);
            synchronized (this.f5783a) {
                for (C0233a c0233a : this.f5783a) {
                    a2.add(c0233a.f5785a);
                }
                for (C0233a c0233a2 : this.f5784b) {
                    a2.add(c0233a2.f5785a);
                }
            }
            return a2;
        }
        return (Set) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f5784b.size() > 0 : invokeV.booleanValue;
    }

    public boolean f(C0233a c0233a) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, c0233a)) == null) {
            synchronized (this.f5783a) {
                contains = this.f5783a.contains(c0233a);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public boolean g(C0233a c0233a) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, c0233a)) == null) {
            synchronized (this.f5783a) {
                contains = this.f5784b.contains(c0233a);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public void h(String str) {
        Iterator<C0233a> it;
        Iterator<C0233a> it2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && f5781c) {
            synchronized (this.f5783a) {
                while (this.f5783a.iterator().hasNext()) {
                    String str2 = "loaded:" + it.next();
                }
                while (this.f5784b.iterator().hasNext()) {
                    String str3 = "loading:" + it2.next();
                }
            }
        }
    }

    public void i(C0233a c0233a, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048583, this, c0233a, z) == null) && c0233a != null && c0233a.a()) {
            if (f5781c) {
                StringBuilder sb = new StringBuilder();
                sb.append("record one app status - ");
                sb.append(z ? "loaded" : "loading");
                sb.toString();
                String str = "record one app - " + c0233a;
            }
            synchronized (this.f5783a) {
                (z ? this.f5783a : this.f5784b).add(c0233a);
            }
        }
    }

    public void j(JSONObject jSONObject) {
        int length;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) || jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        if (f5781c) {
            String str = "get multi preload status - " + jSONObject;
        }
        synchronized (this.f5783a) {
            b(false);
            JSONArray optJSONArray = jSONObject.optJSONArray("loaded");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    i(new C0233a(optJSONArray.optJSONObject(i2)), true);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("loading");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                i(new C0233a(optJSONObject), false);
            }
        }
        k();
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            b.a.p0.a.y1.b.c w = d.P("swan_multi_preload_on_server").A("swan_multi_preload_app_ids", (String[]) d().toArray(new String[0])).w("swan_multi_preload_app_process_index", SwanAppProcessInfo.current().index);
            w.K(true);
            w.call();
            boolean z = f5781c;
        }
    }

    /* renamed from: b.a.p0.a.h0.l.g.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0233a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f5785a;

        /* renamed from: b  reason: collision with root package name */
        public final String f5786b;

        public C0233a(String str, long j) {
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
            this.f5785a = str;
            this.f5786b = String.valueOf(j);
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.f5785a) || TextUtils.isEmpty(this.f5786b)) ? false : true : invokeV.booleanValue;
        }

        public boolean equals(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof C0233a) {
                    C0233a c0233a = (C0233a) obj;
                    return TextUtils.equals(this.f5785a, c0233a.f5785a) && TextUtils.equals(this.f5786b, c0233a.f5786b);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                String str = this.f5785a;
                int hashCode = str == null ? 0 : str.hashCode();
                String str2 = this.f5786b;
                return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "Item{appKey='" + this.f5785a + ExtendedMessageFormat.QUOTE + ", version='" + this.f5786b + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }

        public C0233a(JSONObject jSONObject) {
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
                this.f5786b = null;
                this.f5785a = null;
                return;
            }
            this.f5785a = jSONObject.optString("appKey");
            this.f5786b = jSONObject.optString("version");
        }
    }
}
