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
/* loaded from: classes9.dex */
public class c3 {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f30298b;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f30299c;

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f30300d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1646433337, "Lc/q/a/c3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1646433337, "Lc/q/a/c3;");
                return;
            }
        }
        a = new String[]{"as", "ac", "ao", "scb", "wdin", "asr", "wbas", "wbao"};
        f30298b = new String[]{"ins", "bd", "wdtr", "witr"};
        f30299c = new String[]{"be", "bce", "bpe", "ps", "scbe", "wdst", "wde", "wie", "dplop", "wbe", "hte"};
        f30300d = new String[]{"Ld", "wdin", "wiin", "wdre", "wiop", "wii", "rle"};
    }

    public c3() {
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

    public static y2 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new y2(new c3(), context) : (y2) invokeL.objValue;
    }

    public static /* synthetic */ String b(String str) {
        try {
            return r0.g(str);
        } catch (Exception unused) {
            return str;
        }
    }

    public static /* synthetic */ JSONStringer d(String str, g3 g3Var) {
        JSONStringer g2 = g();
        g2.key("e").value(str).key("timeis").value(f());
        if (g3Var != null) {
            g2.key("pid").value(g3Var.a);
            if (g3Var.f30327b != null) {
                JSONStringer key = g2.key("traceid");
                String traceid = g3Var.f30327b.getTraceid();
                try {
                    traceid = r0.g(traceid);
                } catch (Exception unused) {
                }
                JSONStringer key2 = key.value(traceid).key("cid");
                String id = g3Var.f30327b.getId();
                try {
                    id = r0.g(id);
                } catch (Exception unused2) {
                }
                key2.value(id).key("type").value(g3Var.f30327b.getType());
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
