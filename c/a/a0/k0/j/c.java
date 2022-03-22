package c.a.a0.k0.j;

import c.a.a0.a0.c.e;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.a0.k0.l.a a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1316b;

    /* renamed from: c  reason: collision with root package name */
    public int f1317c;

    /* renamed from: d  reason: collision with root package name */
    public final JSONObject f1318d;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1316b = true;
        this.f1317c = -1;
        this.f1318d = new JSONObject();
        c.a.a0.k0.l.a aVar = new c.a.a0.k0.l.a();
        this.a = aVar;
        aVar.a = System.currentTimeMillis();
    }

    public String a(String str, long j, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Constants.KEYS.AD_INFO, str);
                jSONObject.put("isbrowser", String.valueOf(j));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("aderrorcode", String.valueOf(j2));
                jSONObject2.put("multipleaccess", String.valueOf(z));
                jSONObject2.put(PrefetchEvent.MODULE, "0");
                jSONObject.put("adext", jSONObject2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public void b(String str, String str2, String str3, String str4, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) || this.a == null) {
            return;
        }
        if (str3 == null) {
            str3 = "";
        }
        e f2 = new e().f("1006");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ext", str2);
            f2.a("f1", jSONObject.toString());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("timing", str);
            f2.a("f2", jSONObject2.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        long currentTimeMillis = System.currentTimeMillis();
        c.a.a0.k0.l.a aVar = this.a;
        f2.a("f3", str4);
        f2.a("f4", String.valueOf(j));
        f2.a("f6", String.valueOf(this.f1317c));
        f2.a("f7", "ad");
        f2.a("f14", "");
        f2.a("f15", String.valueOf(this.a.a));
        f2.a("f16", String.format(Locale.CHINA, "%.3f", Float.valueOf((((float) ((currentTimeMillis - aVar.f1330d) + aVar.f1331e)) * 1.0f) / 1000.0f)));
        f2.a("f17", str3);
        f2.a("f18", String.valueOf(this.a.f1328b));
        f2.a("f19", String.valueOf(this.a.f1329c));
        f2.a("f20", String.valueOf(this.a.f1330d));
        f2.a("f21", String.valueOf(this.a.f1332f));
        f2.b("f23", this.f1318d);
        c.a.a0.a0.a.b(f2);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.a0.k0.l.a aVar = this.a;
            aVar.a = 0L;
            aVar.f1331e = 0L;
            aVar.f1332f = 0L;
            aVar.f1330d = 0L;
            aVar.f1329c = 0L;
            aVar.f1328b = 0L;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.f1330d = System.currentTimeMillis();
            c.a.a0.k0.l.a aVar = this.a;
            long j = aVar.f1330d - aVar.f1329c;
            if (j < 0) {
                j = 0;
            }
            this.a.f1331e += j;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.f1329c = System.currentTimeMillis();
            if (this.f1316b) {
                c.a.a0.k0.l.a aVar = this.a;
                long j = aVar.f1329c - aVar.a;
                if (j < 0) {
                    j = 0;
                }
                this.a.f1331e = j;
                this.f1316b = false;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.f1328b = System.currentTimeMillis();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.f1332f = System.currentTimeMillis();
        }
    }
}
