package c.m.a;

import android.content.Context;
import com.baidu.mobstat.Config;
import com.baidu.sofire.d.D;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONStringer;
/* loaded from: classes3.dex */
public class x2 {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;

    /* renamed from: b */
    public static final String[] f23608b;

    /* renamed from: c */
    public static final String[] f23609c;

    /* renamed from: d */
    public static final String[] f23610d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-901460615, "Lc/m/a/x2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-901460615, "Lc/m/a/x2;");
                return;
            }
        }
        a = new String[]{"as", D.COLUMN_PLUGIN_ACTIVITY_INFO_LIST, "ao", "scb", "wdin", "asr", "wbas", "wbao"};
        f23608b = new String[]{"ins", Config.DEVICE_BRAND, "wdtr", "witr"};
        f23609c = new String[]{"be", "bce", "bpe", "ps", "scbe", "wdst", "wde", "wie", "dplop", "wbe", "hte"};
        f23610d = new String[]{"Ld", "wdin", "wiin", "wdre", "wiop", "wii", "rle"};
    }

    public x2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static t2 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new t2(new x2(), context) : (t2) invokeL.objValue;
    }

    public static /* synthetic */ String b(String str) {
        try {
            return r0.g(str);
        } catch (Exception unused) {
            return str;
        }
    }

    /* JADX DEBUG: Method not inlined, still used in: [c.m.a.t2.a(int, long):c.m.a.t2] */
    public static /* synthetic */ JSONStringer c() {
        return new JSONStringer().object();
    }

    public static /* synthetic */ JSONStringer d(String str, b3 b3Var) {
        JSONStringer g2 = g();
        g2.key("e").value(str).key("timeis").value(f());
        if (b3Var != null) {
            g2.key("pid").value(b3Var.a);
            if (b3Var.f23414b != null) {
                JSONStringer key = g2.key("traceid");
                String traceid = b3Var.f23414b.getTraceid();
                try {
                    traceid = r0.g(traceid);
                } catch (Exception unused) {
                }
                JSONStringer key2 = key.value(traceid).key("cid");
                String id = b3Var.f23414b.getId();
                try {
                    id = r0.g(id);
                } catch (Exception unused2) {
                }
                key2.value(id).key("type").value(b3Var.f23414b.getType());
            }
        }
        return g2;
    }

    public static /* synthetic */ String e() {
        String valueOf = String.valueOf(System.currentTimeMillis());
        try {
            return r0.g(valueOf);
        } catch (Exception unused) {
            return valueOf;
        }
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            try {
                return r0.g(valueOf);
            } catch (Exception unused) {
                return valueOf;
            }
        }
        return (String) invokeV.objValue;
    }

    public static JSONStringer g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? new JSONStringer().object() : (JSONStringer) invokeV.objValue;
    }
}
