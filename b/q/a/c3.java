package b.q.a;

import android.content.Context;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONStringer;
/* loaded from: classes6.dex */
public class c3 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f33271a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f33272b;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f33273c;

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f33274d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(161021126, "Lb/q/a/c3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(161021126, "Lb/q/a/c3;");
                return;
            }
        }
        f33271a = new String[]{"as", "ac", "ao", "scb", "wdin", "asr", "wbas", "wbao"};
        f33272b = new String[]{"ins", "bd", "wdtr", "witr"};
        f33273c = new String[]{"be", "bce", "bpe", "ps", "scbe", "wdst", "wde", "wie", "dplop", "wbe", "hte"};
        f33274d = new String[]{"Ld", "wdin", "wiin", "wdre", "wiop", "wii", "rle"};
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
            g2.key("pid").value(g3Var.f33324a);
            if (g3Var.f33325b != null) {
                JSONStringer key = g2.key("traceid");
                String traceid = g3Var.f33325b.getTraceid();
                try {
                    traceid = r0.g(traceid);
                } catch (Exception unused) {
                }
                JSONStringer key2 = key.value(traceid).key(IAdRequestParam.CELL_ID);
                String id = g3Var.f33325b.getId();
                try {
                    id = r0.g(id);
                } catch (Exception unused2) {
                }
                key2.value(id).key("type").value(g3Var.f33325b.getType());
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
