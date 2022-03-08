package c.a.b0.k0.j;

import c.a.b0.a0.c.e;
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
    public final c.a.b0.k0.l.a a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1698b;

    /* renamed from: c  reason: collision with root package name */
    public int f1699c;

    /* renamed from: d  reason: collision with root package name */
    public final JSONObject f1700d;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1698b = true;
        this.f1699c = -1;
        this.f1700d = new JSONObject();
        c.a.b0.k0.l.a aVar = new c.a.b0.k0.l.a();
        this.a = aVar;
        aVar.a = System.currentTimeMillis();
    }

    public String a(String str, long j2, long j3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)})) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Constants.KEYS.AD_INFO, str);
                jSONObject.put("isbrowser", String.valueOf(j2));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("aderrorcode", String.valueOf(j3));
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

    public void b(String str, String str2, String str3, String str4, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) || this.a == null) {
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
        c.a.b0.k0.l.a aVar = this.a;
        f2.a("f3", str4);
        f2.a("f4", String.valueOf(j2));
        f2.a("f6", String.valueOf(this.f1699c));
        f2.a("f7", "ad");
        f2.a("f14", "");
        f2.a("f15", String.valueOf(this.a.a));
        f2.a("f16", String.format(Locale.CHINA, "%.3f", Float.valueOf((((float) ((currentTimeMillis - aVar.f1714d) + aVar.f1715e)) * 1.0f) / 1000.0f)));
        f2.a("f17", str3);
        f2.a("f18", String.valueOf(this.a.f1712b));
        f2.a("f19", String.valueOf(this.a.f1713c));
        f2.a("f20", String.valueOf(this.a.f1714d));
        f2.a("f21", String.valueOf(this.a.f1716f));
        f2.b("f23", this.f1700d);
        c.a.b0.a0.a.b(f2);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.b0.k0.l.a aVar = this.a;
            aVar.a = 0L;
            aVar.f1715e = 0L;
            aVar.f1716f = 0L;
            aVar.f1714d = 0L;
            aVar.f1713c = 0L;
            aVar.f1712b = 0L;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.f1714d = System.currentTimeMillis();
            c.a.b0.k0.l.a aVar = this.a;
            long j2 = aVar.f1714d - aVar.f1713c;
            if (j2 < 0) {
                j2 = 0;
            }
            this.a.f1715e += j2;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.f1713c = System.currentTimeMillis();
            if (this.f1698b) {
                c.a.b0.k0.l.a aVar = this.a;
                long j2 = aVar.f1713c - aVar.a;
                if (j2 < 0) {
                    j2 = 0;
                }
                this.a.f1715e = j2;
                this.f1698b = false;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.f1712b = System.currentTimeMillis();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.f1716f = System.currentTimeMillis();
        }
    }
}
