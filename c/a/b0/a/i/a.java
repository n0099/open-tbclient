package c.a.b0.a.i;

import c.a.b0.a.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static e a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.b0.a.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0034a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public long f1594b;

        /* renamed from: c  reason: collision with root package name */
        public int f1595c;

        /* renamed from: d  reason: collision with root package name */
        public String f1596d;

        /* renamed from: e  reason: collision with root package name */
        public String f1597e;

        /* renamed from: f  reason: collision with root package name */
        public String f1598f;

        /* renamed from: g  reason: collision with root package name */
        public String f1599g;

        /* renamed from: h  reason: collision with root package name */
        public String f1600h;

        /* renamed from: i  reason: collision with root package name */
        public String f1601i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f1602j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f1603k;
        public boolean l;
        public int m;
        public int n;
        public JSONObject o;
        public JSONObject p;

        public C0034a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public static void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, str, jSONObject) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("sdk_version", Integer.valueOf(c.a.b0.a.b.h()));
                if (jSONObject2.length() > 0) {
                    jSONObject2.put("debug_info", jSONObject);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            e eVar = a;
            if (eVar != null) {
                eVar.report(str, jSONObject2);
            }
        }
    }
}
