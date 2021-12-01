package c.a.b0.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f1742d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final c.a.b0.i.a f1743b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1744c;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.b0.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0054b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1595650564, "Lc/a/b0/i/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1595650564, "Lc/a/b0/i/b$b;");
                    return;
                }
            }
            a = new b(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1950261574, "Lc/a/b0/i/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1950261574, "Lc/a/b0/i/b;");
                return;
            }
        }
        f1742d = new Object();
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C0054b.a : (b) invokeV.objValue;
    }

    @Override // c.a.b0.i.l
    public int a(String str, int i2) {
        InterceptResult invokeLI;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return i2;
            }
            g(NodeJS.GLOBAL);
            if (c.a.b0.u.c.a(this.f1743b.a(), str) && (str2 = (String) c.a.b0.u.c.b(this.f1743b.a(), str)) != null) {
                try {
                    return Integer.parseInt(str2);
                } catch (NumberFormatException unused) {
                }
            }
            return i2;
        }
        return invokeLI.intValue;
    }

    @Override // c.a.b0.i.l
    public int b(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, i2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                g(str);
                Map map = (Map) c.a.b0.u.c.b(this.f1743b.b(), str);
                if (map != null && c.a.b0.u.c.a(map, str2) && (str3 = (String) c.a.b0.u.c.b(map, str2)) != null) {
                    try {
                        return Integer.parseInt(str3);
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            return i2;
        }
        return invokeLLI.intValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f1743b.f1741d = true;
        }
    }

    public void e(@Nullable String str) throws ADConfigError {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (str != null && !TextUtils.isEmpty(str)) {
                JSONObject b2 = c.a.b0.u.b.b(str);
                if (b2.has("error_code")) {
                    if (TextUtils.equals(b2.optString("error_code"), "0")) {
                        if (b2.has("error_message")) {
                            if (TextUtils.equals(b2.optString("error_message"), "success")) {
                                String optString = b2.optString("data");
                                if (!TextUtils.isEmpty(optString)) {
                                    JSONObject b3 = c.a.b0.u.b.b(optString);
                                    String optString2 = b3.optString("sign");
                                    if (!TextUtils.isEmpty(optString2)) {
                                        if (TextUtils.equals(optString2, c.a.b0.v.e.a().b("nad_app_quick_config").getString("_ad_adc_conf_sign", ""))) {
                                            return;
                                        }
                                        c.a.b0.v.e.a().b("nad_app_quick_config").g("_ad_adc_conf_sign", optString2);
                                        synchronized (f1742d) {
                                            this.f1743b.update(b3);
                                        }
                                        return;
                                    }
                                    throw ADConfigError.error("2", ADConfigError.REASON_NULL_SIGN);
                                }
                                throw ADConfigError.error("7", ADConfigError.REASON_NULL_DATA);
                            }
                            throw ADConfigError.error("5", ADConfigError.REASON_WRONG_MSG);
                        }
                        throw ADConfigError.error("6", ADConfigError.REASON_NULL_MSG);
                    }
                    throw ADConfigError.error("3", ADConfigError.REASON_WRONG_CODE);
                }
                throw ADConfigError.error("4", ADConfigError.REASON_NULL_CODE);
            }
            throw ADConfigError.error("1", ADConfigError.REASON_NULL_RESPONSE_BODY);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f1743b.f1741d = false;
        }
    }

    public final void g(String str) {
        Map<String, ?> all;
        Map<String, ?> all2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            c.a.b0.v.e a2 = c.a.b0.v.e.a();
            c.a.b0.v.b b2 = a2.b("nad.launch.config." + str);
            if (NodeJS.GLOBAL.equals(str)) {
                if (this.f1744c || (all2 = b2.getAll()) == null) {
                    return;
                }
                c.a.b0.u.c.f(this.f1743b.a(), all2);
                this.f1744c = true;
            } else if (((Map) c.a.b0.u.c.b(this.f1743b.b(), str)) == null && (all = b2.getAll()) != null) {
                c.a.b0.u.c.e(this.f1743b.b(), str, all);
            }
        }
    }

    public b() {
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
        this.f1743b = new c.a.b0.i.a();
        this.f1744c = false;
    }
}
