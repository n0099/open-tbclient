package cn.com.chinatelecom.gateway.lib.b;

import android.content.Context;
import android.text.TextUtils;
import cn.com.chinatelecom.gateway.lib.a.f;
import cn.com.chinatelecom.gateway.lib.c.i;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "d";

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f30827b;
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
        f30827b = new byte[]{15, 31, 94, 10, 90, 15, 91, 24, 10, 30, 88, 7, 89, 10, 95, 30};
    }

    public d() {
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

    public static void a(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65541, null, context, i2) == null) {
            try {
                cn.com.chinatelecom.gateway.lib.c.b.a(context, "key_c_l_l_v", i2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, context, str) == null) {
            int hashCode = str.hashCode();
            int i2 = 0;
            if (hashCode == 64897) {
                if (str.equals("ALL")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else if (hashCode != 78159) {
                if (hashCode == 66247144 && str.equals("ERROR")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (str.equals("OFF")) {
                    c2 = 2;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 == 1) {
                    i2 = -1;
                } else if (c2 == 2) {
                    i2 = -2;
                }
            }
            a(context, i2);
        }
    }

    public static void a(Context context, List<String> list) {
        int b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, context, list) == null) || (b2 = b(context)) == -2) {
            return;
        }
        b(context, list, b2);
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                return cn.com.chinatelecom.gateway.lib.c.b.b(context, "key_c_l_l_v", 0);
            } catch (Throwable th) {
                th.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) ? a.a(context, "https://collect.ux.21cn.com/collect/custom/accountMsg", str) : (String) invokeLL.objValue;
    }

    public static String b(Context context, Queue<String> queue) {
        InterceptResult invokeLL;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, queue)) == null) {
            JSONArray jSONArray = new JSONArray();
            String jSONArray2 = jSONArray.toString();
            if (!queue.isEmpty()) {
                for (String str : queue) {
                    try {
                        jSONArray.put(new JSONObject(str));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            if (jSONArray.length() <= 0) {
                return "";
            }
            String jSONArray3 = jSONArray.toString();
            if (!TextUtils.isEmpty(jSONArray3)) {
                try {
                    a2 = cn.com.chinatelecom.gateway.lib.a.b.a(cn.com.chinatelecom.gateway.lib.a.a.b(jSONArray3, f.a(f30827b)));
                } catch (Exception e3) {
                    e = e3;
                }
                try {
                    jSONArray2 = URLEncoder.encode(a2, "UTF-8");
                } catch (Exception e4) {
                    e = e4;
                    jSONArray2 = a2;
                    e.printStackTrace();
                    return b(context, jSONArray2);
                }
            }
            return b(context, jSONArray2);
        }
        return (String) invokeLL.objValue;
    }

    public static void b(Context context, List<String> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65548, null, context, list, i2) == null) {
            i.a(new Runnable(context, list, i2) { // from class: cn.com.chinatelecom.gateway.lib.b.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ List f30828b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f30829c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, list, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = context;
                    this.f30828b = list;
                    this.f30829c = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            Queue c2 = d.c(this.a, this.f30828b, this.f30829c);
                            if (c2.isEmpty()) {
                                return;
                            }
                            String b2 = d.b(this.a, c2);
                            JSONObject jSONObject = null;
                            int i3 = -1;
                            try {
                                if (!TextUtils.isEmpty(b2)) {
                                    JSONObject jSONObject2 = new JSONObject(b2);
                                    try {
                                        i3 = jSONObject2.getInt("code");
                                        jSONObject = jSONObject2;
                                    } catch (Exception e2) {
                                        e = e2;
                                        jSONObject = jSONObject2;
                                        e.printStackTrace();
                                        if (jSONObject != null) {
                                        }
                                        d.b(this.a, c2, this.f30829c);
                                        return;
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                            }
                            if (jSONObject != null || i3 != 0) {
                                d.b(this.a, c2, this.f30829c);
                                return;
                            }
                            d.c(this.a);
                            c2.clear();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public static void b(Context context, Queue<String> queue, int i2) {
        String str;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65549, null, context, queue, i2) == null) {
            JSONArray jSONArray = new JSONArray();
            if (queue != null && !queue.isEmpty()) {
                int i3 = 0;
                for (String str2 : queue) {
                    try {
                        jSONObject = new JSONObject(str2);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (i2 != -1 || jSONObject.getInt("rt") != 0) {
                        jSONArray.put(jSONObject);
                        i3++;
                        if (i3 > 10) {
                            break;
                        }
                    }
                }
            }
            if (jSONArray.length() > 0) {
                try {
                    str = cn.com.chinatelecom.gateway.lib.a.a.a(jSONArray.toString(), f.a(f30827b));
                } catch (Exception e3) {
                    e3.printStackTrace();
                    str = null;
                }
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c.a(context, str);
        }
    }

    public static synchronized Queue<String> c(Context context, List<String> list, int i2) {
        InterceptResult invokeLLI;
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65550, null, context, list, i2)) == null) {
            synchronized (d.class) {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                String a2 = c.a(context);
                if (!TextUtils.isEmpty(a2)) {
                    try {
                        JSONArray jSONArray = new JSONArray(cn.com.chinatelecom.gateway.lib.a.a.c(a2, f.a(f30827b)));
                        int length = jSONArray.length();
                        for (int i3 = 0; i3 < length && i3 <= 10; i3++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i3);
                            if (jSONObject != null) {
                                concurrentLinkedQueue.add(jSONObject.toString());
                            }
                        }
                        c.a(context, "");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (i2 == -1) {
                    for (String str : list) {
                        try {
                            if (new JSONObject(str).getInt("rt") != 0) {
                                concurrentLinkedQueue.add(str);
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                } else if (i2 == 0) {
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

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, context) == null) {
            c.a(context, "");
        }
    }
}
