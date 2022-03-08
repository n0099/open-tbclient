package c.q.a;

import android.content.Context;
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
    public static final String[] f29171b;

    /* renamed from: c */
    public static final String[] f29172c;

    /* renamed from: d */
    public static final String[] f29173d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1646413187, "Lc/q/a/x2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1646413187, "Lc/q/a/x2;");
                return;
            }
        }
        a = new String[]{"as", "ac", "ao", "scb", "wdin", "asr", "wbas", "wbao"};
        f29171b = new String[]{"ins", "bd", "wdtr", "witr"};
        f29172c = new String[]{"be", "bce", "bpe", "ps", "scbe", "wdst", "wde", "wie", "dplop", "wbe", "hte"};
        f29173d = new String[]{"Ld", "wdin", "wiin", "wdre", "wiop", "wii", "rle"};
    }

    public x2() {
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

    /* JADX DEBUG: Method not inlined, still used in: [c.q.a.t2.a(int, long):c.q.a.t2] */
    public static /* synthetic */ JSONStringer c() {
        return new JSONStringer().object();
    }

    public static /* synthetic */ JSONStringer d(String str, b3 b3Var) {
        JSONStringer g2 = g();
        g2.key("e").value(str).key("timeis").value(f());
        if (b3Var != null) {
            g2.key("pid").value(b3Var.a);
            if (b3Var.f28927b != null) {
                JSONStringer key = g2.key("traceid");
                String traceid = b3Var.f28927b.getTraceid();
                try {
                    traceid = r0.g(traceid);
                } catch (Exception unused) {
                }
                JSONStringer key2 = key.value(traceid).key("cid");
                String id = b3Var.f28927b.getId();
                try {
                    id = r0.g(id);
                } catch (Exception unused2) {
                }
                key2.value(id).key("type").value(b3Var.f28927b.getType());
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
