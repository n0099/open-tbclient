package c.a.b1.f;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.b1.g.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f2286d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f2287e;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.b1.g.a a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f2288b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f2289c;

    /* renamed from: c.a.b1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0093a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(61242527, "Lc/a/b1/f/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(61242527, "Lc/a/b1/f/a$b;");
                    return;
                }
            }
            a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1921721827, "Lc/a/b1/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1921721827, "Lc/a/b1/f/a;");
                return;
            }
        }
        f2286d = AppConfig.isDebug();
        f2287e = AppRuntime.getAppContext().getApplicationInfo().dataDir + File.separator + "yalog/";
    }

    public /* synthetic */ a(C0093a c0093a) {
        this();
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (a) invokeV.objValue;
    }

    public Map<String, c.a.b1.g.b> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.c() : (Map) invokeV.objValue;
    }

    public float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.d() : invokeV.floatValue;
    }

    public float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.e() : invokeV.floatValue;
    }

    public List<c> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.f() : (List) invokeV.objValue;
    }

    public float f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.g() : invokeV.floatValue;
    }

    public float g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.h() : invokeV.floatValue;
    }

    public float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a.i() : invokeV.floatValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.a == null) {
                this.a = new c.a.b1.g.a();
            }
            j();
            k();
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!new File(f2287e).exists()) {
                boolean z = f2286d;
                return;
            }
            File file = new File(f2287e, "yalog_cloud.txt");
            if (!file.exists()) {
                boolean z2 = f2286d;
                this.a.l();
                return;
            }
            String a = c.a.b1.j.a.a(file);
            if (f2286d) {
                String str = "read from local: " + a;
            }
            if (TextUtils.isEmpty(a)) {
                this.a.l();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(a);
                this.f2288b = jSONObject;
                this.a.p(jSONObject.optString(TbConfig.SW_APID));
                this.a.m(this.f2288b.optString("cl"));
                this.a.w((float) this.f2288b.optDouble("tosize"));
                this.a.s((float) this.f2288b.optDouble("sisize"));
                this.a.u((float) this.f2288b.optDouble("spsize"));
                this.a.v((float) this.f2288b.optDouble("sptime"));
                this.a.r((float) this.f2288b.optDouble("idsize"));
                if (this.f2288b.has("spdelist")) {
                    List<String> asList = Arrays.asList(this.f2288b.optString("spdelist"));
                    if (asList.size() > 0) {
                        this.a.o(asList);
                    }
                }
                if (this.f2288b.has("splist")) {
                    JSONObject optJSONObject = this.f2288b.optJSONObject("splist");
                    ArrayList arrayList = new ArrayList();
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                            if (optJSONObject2 != null) {
                                arrayList.add(new c(next, !TextUtils.equals("0", optJSONObject2.optString(TbConfig.SW_APID)), (float) optJSONObject2.optDouble("size"), (float) optJSONObject2.optDouble("time")));
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        this.a.t(arrayList);
                    }
                }
            } catch (JSONException e2) {
                if (f2286d) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void k() {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (!new File(f2287e).exists()) {
                boolean z = f2286d;
                return;
            }
            File file = new File(f2287e, "yalog_id_cloud.txt");
            if (!file.exists()) {
                boolean z2 = f2286d;
                return;
            }
            String a = c.a.b1.j.a.a(file);
            if (f2286d) {
                String str = "read from local: " + a;
            }
            if (TextUtils.isEmpty(a)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(a);
                this.f2289c = jSONObject;
                if (jSONObject.has("iddemap") && (optJSONObject = this.f2289c.optJSONObject("iddemap")) != null && optJSONObject.length() > 0) {
                    HashMap hashMap = new HashMap();
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, optJSONObject.optString(next));
                    }
                    if (hashMap.size() > 0) {
                        this.a.n(hashMap);
                    }
                }
                if (this.f2289c.has("idlist")) {
                    JSONObject optJSONObject2 = this.f2289c.optJSONObject("idlist");
                    HashMap hashMap2 = new HashMap();
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        Iterator<String> keys2 = optJSONObject2.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            JSONObject optJSONObject3 = optJSONObject2.optJSONObject(next2);
                            if (optJSONObject3 != null) {
                                hashMap2.put(next2, new c.a.b1.g.b(next2, optJSONObject3.optLong("v"), !TextUtils.equals("0", optJSONObject3.optString(TbConfig.SW_APID)), (float) optJSONObject3.optDouble("size")));
                            }
                        }
                    }
                    if (hashMap2.size() > 0) {
                        this.a.q(hashMap2);
                    }
                }
            } catch (JSONException e2) {
                if (f2286d) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a.j() : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a.k() : invokeV.booleanValue;
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
        i();
    }
}
