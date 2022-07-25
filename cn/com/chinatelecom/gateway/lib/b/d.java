package cn.com.chinatelecom.gateway.lib.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static Map b;
    public static List c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1293545150, "Lcn/com/chinatelecom/gateway/lib/b/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1293545150, "Lcn/com/chinatelecom/gateway/lib/b/d;");
                return;
            }
        }
        b = new HashMap();
        c = new ArrayList();
    }

    public d() {
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

    public static synchronized a a(String str) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            synchronized (d.class) {
                try {
                    aVar = b.containsKey(str) ? (a) b.get(str) : null;
                    if (aVar == null) {
                        aVar = new a(str);
                        b.put(str, aVar);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    return new a(str);
                }
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public static /* synthetic */ void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (d.class) {
                arrayList.addAll(c);
                a = 0;
                c.clear();
            }
            if (arrayList.isEmpty()) {
                return;
            }
            b.a(context, arrayList);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str) == null) {
            try {
                synchronized (d.class) {
                    if (b.containsKey(str)) {
                        c.add(((a) b.get(str)).toString());
                        b.remove(str);
                    }
                    if (a != 1 && !c.isEmpty()) {
                        a = 1;
                        new Timer().schedule(new e(context), 8000L);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, str, str2, str3) == null) {
            String str4 = "";
            int i = -1;
            try {
                if (!TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject(str2);
                    i = jSONObject.getInt(TiebaStatic.LogFields.RESULT);
                    str4 = jSONObject.optString("msg");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            a a2 = a(str).a(i);
            if (i == 0) {
                a2.f(str4);
            } else {
                a2.f(str4).e(str3);
            }
        }
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, context, str) == null) {
            b.a(context, str);
        }
    }
}
