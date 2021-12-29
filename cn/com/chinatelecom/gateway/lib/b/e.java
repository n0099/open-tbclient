package cn.com.chinatelecom.gateway.lib.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
import java.util.TimerTask;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "e";

    /* renamed from: b  reason: collision with root package name */
    public static int f31588b;

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, b> f31589c;

    /* renamed from: d  reason: collision with root package name */
    public static List<String> f31590d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1293545119, "Lcn/com/chinatelecom/gateway/lib/b/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1293545119, "Lcn/com/chinatelecom/gateway/lib/b/e;");
                return;
            }
        }
        f31589c = new HashMap();
        f31590d = new ArrayList();
    }

    public e() {
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

    public static synchronized b a(String str) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            synchronized (e.class) {
                try {
                    bVar = f31589c.containsKey(str) ? f31589c.get(str) : null;
                    if (bVar == null) {
                        bVar = new b(str);
                        f31589c.put(str, bVar);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    return new b(str);
                }
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str) == null) {
            try {
                synchronized (e.class) {
                    if (f31589c.containsKey(str)) {
                        f31590d.add(f31589c.get(str).toString());
                        f31589c.remove(str);
                    }
                    if (f31588b != 1 && !f31590d.isEmpty()) {
                        f31588b = 1;
                        new Timer().schedule(new TimerTask(context) { // from class: cn.com.chinatelecom.gateway.lib.b.e.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Context a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {context};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = context;
                            }

                            @Override // java.util.TimerTask, java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    e.b(this.a);
                                }
                            }
                        }, 8000L);
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
            int i2 = -1;
            try {
                if (!TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject(str2);
                    i2 = jSONObject.getInt("result");
                    str4 = jSONObject.optString("msg");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            b a2 = a(str).a(i2);
            if (i2 == 0) {
                a2.f(str4);
            } else {
                a2.f(str4).e(str3);
            }
        }
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, context) == null) || context == null) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (e.class) {
                arrayList.addAll(f31590d);
                f31588b = 0;
                f31590d.clear();
            }
            if (arrayList.isEmpty()) {
                return;
            }
            d.a(context, arrayList);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, str) == null) {
            d.a(context, str);
        }
    }
}
