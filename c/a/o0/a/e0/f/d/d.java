package c.a.o0.a.e0.f.d;

import android.text.TextUtils;
import c.a.o0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f5190a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f5191b;

    /* renamed from: c  reason: collision with root package name */
    public static c.a.o0.a.j2.a f5192c;

    /* renamed from: d  reason: collision with root package name */
    public static Timer f5193d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5194e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5194e = dVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = d.f5190a;
                this.f5194e.c();
                this.f5194e.h();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.a.o0.a.e0.f.d.d
        public void f(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            if (d.f5190a) {
                String str2 = "local-debug statistic event name is : " + str;
            }
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 50335962) {
                if (hashCode != 1109597094) {
                    if (hashCode == 1158237819 && str.equals("downloadsuccess")) {
                        c2 = 1;
                    }
                } else if (str.equals("downloadfail")) {
                    c2 = 2;
                }
            } else if (str.equals("downloadstart")) {
                c2 = 0;
            }
            if (c2 == 0) {
                i();
                c.a.o0.a.j2.b.d(d.f5192c, str, d());
            } else if (c2 == 1) {
                if (d.f5192c != null) {
                    c.a.o0.a.j2.b.d(d.f5192c, "downloadsuccess", d());
                }
                c();
                h();
            } else if (c2 != 2) {
                if (d.f5192c != null) {
                    c.a.o0.a.j2.b.d(d.f5192c, str, d());
                }
            } else {
                if (d.f5192c != null) {
                    c.a.o0.a.j2.b.d(d.f5192c, "downloadfail", d());
                }
                c();
                h();
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static class c extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.a.o0.a.e0.f.d.d
        public void f(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str) || f.k().m()) {
                return;
            }
            if (d.f5190a) {
                String str2 = "local-debug statistic event name is : " + str;
            }
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 900970612) {
                if (hashCode == 1415552890 && str.equals("unzipstart")) {
                    c2 = 0;
                }
            } else if (str.equals("pageready")) {
                c2 = 1;
            }
            if (c2 == 0) {
                i();
                c.a.o0.a.j2.b.d(d.f5192c, str, d());
            } else if (c2 != 1) {
                if (d.f5192c != null) {
                    c.a.o0.a.j2.b.d(d.f5192c, str, d());
                }
            } else if (d.f5192c != null) {
                c.a.o0.a.j2.b.d(d.f5192c, str, d());
                c();
                h();
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1886833319, "Lc/a/o0/a/e0/f/d/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1886833319, "Lc/a/o0/a/e0/f/d/d;");
                return;
            }
        }
        f5190a = k.f7049a;
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f5191b == null) {
                synchronized (c.a.o0.a.g1.f.class) {
                    if (f5191b == null) {
                        if (c.a.h0.b.a.a.g()) {
                            f5191b = new b(null);
                        } else {
                            f5191b = new c(null);
                        }
                    }
                }
            }
            return f5191b;
        }
        return (d) invokeV.objValue;
    }

    public static void g(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, jSONArray) == null) || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        JSONObject optJSONObject = jSONArray.optJSONObject(0);
        String optString = optJSONObject != null ? optJSONObject.optString("actionId") : "";
        if (TextUtils.isEmpty(optString) || f5191b == null) {
            return;
        }
        f5191b.f(optString);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || f5192c == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            c.a.o0.a.a2.e Q = c.a.o0.a.a2.e.Q();
            jSONObject2.putOpt("appid", Q == null ? "" : Q.getAppId());
            jSONObject2.putOpt("from", "local-debug");
            jSONObject.putOpt("from", "swan");
            jSONObject.putOpt("ext", jSONObject2);
        } catch (JSONException unused) {
            boolean z = f5190a;
        }
        c.a.o0.a.j2.b.f(f5192c, jSONObject.toString());
        c.a.o0.a.j2.b.c(f5192c);
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
            } catch (JSONException unused) {
                boolean z = f5190a;
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public abstract void f(String str);

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Timer timer = f5193d;
            if (timer != null) {
                timer.cancel();
                f5193d = null;
            }
            f5191b = null;
            f5192c = null;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && f5192c == null) {
            f5192c = c.a.o0.a.j2.k.c("1153");
            a aVar = new a(this);
            Timer timer = new Timer();
            f5193d = timer;
            try {
                timer.schedule(aVar, 40000L);
            } catch (Exception e2) {
                if (f5190a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
