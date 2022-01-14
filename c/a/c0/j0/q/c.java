package c.a.c0.j0.q;

import c.a.c0.a0.c.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.c0.j0.s.a a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2023b;

    /* renamed from: c  reason: collision with root package name */
    public int f2024c;

    /* renamed from: d  reason: collision with root package name */
    public final JSONObject f2025d;

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
        this.f2023b = true;
        this.f2024c = -1;
        this.f2025d = new JSONObject();
        c.a.c0.j0.s.a aVar = new c.a.c0.j0.s.a();
        this.a = aVar;
        aVar.a = System.currentTimeMillis();
    }

    public void a(String str, String str2, String str3, String str4, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) || this.a == null) {
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
        c.a.c0.j0.s.a aVar = this.a;
        f2.a("f3", str4);
        f2.a("f4", String.valueOf(j2));
        f2.a("f6", String.valueOf(this.f2024c));
        f2.a("f7", "ad");
        f2.a("f14", "");
        f2.a("f15", String.valueOf(this.a.a));
        f2.a("f16", String.format(Locale.CHINA, "%.3f", Float.valueOf((((float) ((currentTimeMillis - aVar.f2039d) + aVar.f2040e)) * 1.0f) / 1000.0f)));
        f2.a("f17", str3);
        f2.a("f18", String.valueOf(this.a.f2037b));
        f2.a("f19", String.valueOf(this.a.f2038c));
        f2.a("f20", String.valueOf(this.a.f2039d));
        f2.a("f21", String.valueOf(this.a.f2041f));
        f2.b("f23", this.f2025d);
        c.a.c0.a0.a.b(f2);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.c0.j0.s.a aVar = this.a;
            aVar.a = 0L;
            aVar.f2040e = 0L;
            aVar.f2041f = 0L;
            aVar.f2039d = 0L;
            aVar.f2038c = 0L;
            aVar.f2037b = 0L;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.f2039d = System.currentTimeMillis();
            c.a.c0.j0.s.a aVar = this.a;
            long j2 = aVar.f2039d - aVar.f2038c;
            if (j2 < 0) {
                j2 = 0;
            }
            this.a.f2040e += j2;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.f2038c = System.currentTimeMillis();
            if (this.f2023b) {
                c.a.c0.j0.s.a aVar = this.a;
                long j2 = aVar.f2038c - aVar.a;
                if (j2 < 0) {
                    j2 = 0;
                }
                this.a.f2040e = j2;
                this.f2023b = false;
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.f2037b = System.currentTimeMillis();
        }
    }
}
