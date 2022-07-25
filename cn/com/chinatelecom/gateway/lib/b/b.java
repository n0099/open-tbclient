package cn.com.chinatelecom.gateway.lib.b;

import android.content.Context;
import android.text.TextUtils;
import cn.com.chinatelecom.gateway.lib.c.f;
import cn.com.chinatelecom.gateway.lib.c.q;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1293545212, "Lcn/com/chinatelecom/gateway/lib/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1293545212, "Lcn/com/chinatelecom/gateway/lib/b/b;");
                return;
            }
        }
        a = new byte[]{15, 31, 94, 10, 90, 15, 91, 24, 10, 30, 88, 7, 89, 10, 95, 30};
    }

    public b() {
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

    public static void a(Context context, String str) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, str) == null) {
            int hashCode = str.hashCode();
            int i = 0;
            if (hashCode == 64897) {
                if (str.equals("ALL")) {
                    c = 0;
                }
                c = 65535;
            } else if (hashCode != 78159) {
                if (hashCode == 66247144 && str.equals("ERROR")) {
                    c = 1;
                }
                c = 65535;
            } else {
                if (str.equals("OFF")) {
                    c = 2;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c == 1) {
                    i = -1;
                } else if (c == 2) {
                    i = -2;
                }
            }
            try {
                f.a(context, "key_c_l_l_v", i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(Context context, List list) {
        int b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, context, list) == null) || (b = b(context)) == -2) {
            return;
        }
        q.a();
        q.a(new c(context, list, b));
    }

    public static /* synthetic */ void a(Context context, Queue queue, int i) {
        String str;
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        if (queue != null && !queue.isEmpty()) {
            Iterator it = queue.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                try {
                    jSONObject = new JSONObject((String) it.next());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (i != -1 || jSONObject.getInt("rt") != 0) {
                    jSONArray.put(jSONObject);
                    i2++;
                    if (i2 > 10) {
                        break;
                    }
                }
            }
        }
        if (jSONArray.length() > 0) {
            try {
                str = cn.com.chinatelecom.gateway.lib.a.a.a(jSONArray.toString(), cn.com.chinatelecom.gateway.lib.a.f.a(a));
            } catch (Exception e2) {
                e2.printStackTrace();
                str = null;
            }
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a.a(context, str);
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                return f.b(context, "key_c_l_l_v", 0);
            } catch (Throwable th) {
                th.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static String b(Context context, Queue queue) {
        InterceptResult invokeLL;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, queue)) == null) {
            JSONArray jSONArray = new JSONArray();
            String jSONArray2 = jSONArray.toString();
            if (!queue.isEmpty()) {
                Iterator it = queue.iterator();
                while (it.hasNext()) {
                    try {
                        jSONArray.put(new JSONObject((String) it.next()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (jSONArray.length() <= 0) {
                return "";
            }
            String jSONArray3 = jSONArray.toString();
            if (!TextUtils.isEmpty(jSONArray3)) {
                try {
                    a2 = cn.com.chinatelecom.gateway.lib.a.b.a(cn.com.chinatelecom.gateway.lib.a.a.b(jSONArray3, cn.com.chinatelecom.gateway.lib.a.f.a(a)));
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    jSONArray2 = URLEncoder.encode(a2, "UTF-8");
                } catch (Exception e3) {
                    e = e3;
                    jSONArray2 = a2;
                    e.printStackTrace();
                    return a.a("https://api-e189.21cn.com/gw/client/accountMsg.do", jSONArray2);
                }
            }
            return a.a("https://api-e189.21cn.com/gw/client/accountMsg.do", jSONArray2);
        }
        return (String) invokeLL.objValue;
    }

    public static synchronized Queue b(Context context, List list, int i) {
        InterceptResult invokeLLI;
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65546, null, context, list, i)) == null) {
            synchronized (b.class) {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                String a2 = a.a(context);
                if (!TextUtils.isEmpty(a2)) {
                    try {
                        JSONArray jSONArray = new JSONArray(cn.com.chinatelecom.gateway.lib.a.a.c(a2, cn.com.chinatelecom.gateway.lib.a.f.a(a)));
                        int length = jSONArray.length();
                        for (int i2 = 0; i2 < length && i2 <= 10; i2++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            if (jSONObject != null) {
                                concurrentLinkedQueue.add(jSONObject.toString());
                            }
                        }
                        a.a(context, "");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (i == -1) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        try {
                            if (new JSONObject(str).getInt("rt") != 0) {
                                concurrentLinkedQueue.add(str);
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (i == 0) {
                    concurrentLinkedQueue.addAll(list);
                }
                while (concurrentLinkedQueue.size() > 10) {
                    concurrentLinkedQueue.poll();
                }
            }
            return concurrentLinkedQueue;
        }
        return (Queue) invokeLLI.objValue;
    }
}
