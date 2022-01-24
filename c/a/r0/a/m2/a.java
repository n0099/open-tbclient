package c.a.r0.a.m2;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.k;
import c.a.r0.a.m2.d.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f7835e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f7836f;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.a.m2.d.b a;

    /* renamed from: b  reason: collision with root package name */
    public c f7837b;

    /* renamed from: c  reason: collision with root package name */
    public b f7838c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.a.m2.c.a f7839d;

    /* renamed from: c.a.r0.a.m2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0465a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b implements c.a.r0.a.m2.d.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public JSONArray f7840b;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7840b = null;
            }
        }

        public JSONObject c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("extra", this.f7840b);
                } catch (JSONException e2) {
                    if (c.a.r0.a.m2.d.a.a) {
                        Log.getStackTraceString(e2);
                    }
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar, C0465a c0465a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(430657163, "Lc/a/r0/a/m2/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(430657163, "Lc/a/r0/a/m2/a;");
                return;
            }
        }
        f7835e = k.a;
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
        this.a = new c.a.r0.a.m2.d.b();
        this.f7837b = new c();
        this.f7838c = new b(this, null);
        this.f7839d = new c.a.r0.a.m2.c.a();
    }

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f7836f == null) {
                synchronized (a.class) {
                    if (f7836f == null) {
                        f7836f = new a();
                    }
                }
            }
            return f7836f;
        }
        return (a) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.c();
            this.f7837b.b();
            this.f7838c.b();
        }
    }

    public File b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(e());
            jSONArray.put(g());
            jSONArray.put(c());
            return this.f7839d.d(jSONArray);
        }
        return (File) invokeV.objValue;
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject c2 = this.f7838c.c();
            if (f7835e) {
                String str = "extraTraces: " + c2;
            }
            return c2;
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject d2 = this.a.d();
            if (f7835e) {
                String str = "LaunchTraces: " + d2;
            }
            return d2;
        }
        return (JSONObject) invokeV.objValue;
    }

    public c.a.r0.a.m2.c.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f7839d : (c.a.r0.a.m2.c.a) invokeV.objValue;
    }

    public JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONObject c2 = this.f7837b.c();
            if (f7835e) {
                String str = "WhiteTraces: " + c2;
            }
            return c2;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) {
            this.f7837b.a(jSONObject);
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            j(str, null);
        }
    }

    public void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            this.a.a(str, str2);
        }
    }

    public void k(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jSONObject) == null) {
            this.a.b(jSONObject);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f7838c.f7840b == null || this.f7838c.f7840b.length() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(e());
        jSONArray.put(g());
        jSONArray.put(c());
        this.f7839d.d(jSONArray);
    }
}
