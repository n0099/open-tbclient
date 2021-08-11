package com.alipay.sdk.app.statistic;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.packet.impl.d;
import com.alipay.sdk.packet.impl.e;
import com.alipay.sdk.util.g;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.alipay.sdk.app.statistic.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1557a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static final String f35692a = "RecordPref";

        /* renamed from: b  reason: collision with root package name */
        public static final String f35693b = "alipay_cashier_statistic_record";
        public transient /* synthetic */ FieldHolder $fh;

        public C1557a() {
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

        public static synchronized String a(Context context, String str, String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) {
                synchronized (C1557a.class) {
                    com.alipay.sdk.util.c.a(f35692a, "stat append " + str2 + " , " + str);
                    if (context != null && !TextUtils.isEmpty(str)) {
                        if (TextUtils.isEmpty(str2)) {
                            str2 = UUID.randomUUID().toString();
                        }
                        C1558a b2 = b(context);
                        if (b2.f35694a.size() > 20) {
                            b2.f35694a.clear();
                        }
                        b2.f35694a.put(str2, str);
                        a(context, b2);
                        return str2;
                    }
                    return null;
                }
            }
            return (String) invokeLLL.objValue;
        }

        public static synchronized C1558a b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
                synchronized (C1557a.class) {
                    try {
                        String b2 = g.b(null, context, f35693b, null);
                        if (TextUtils.isEmpty(b2)) {
                            return new C1558a();
                        }
                        return new C1558a(b2);
                    } catch (Throwable th) {
                        com.alipay.sdk.util.c.a(th);
                        return new C1558a();
                    }
                }
            }
            return (C1558a) invokeL.objValue;
        }

        /* renamed from: com.alipay.sdk.app.statistic.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C1558a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final LinkedHashMap<String, String> f35694a;

            public C1558a() {
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
                this.f35694a = new LinkedHashMap<>();
            }

            public String a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    try {
                        JSONArray jSONArray = new JSONArray();
                        for (Map.Entry<String, String> entry : this.f35694a.entrySet()) {
                            JSONArray jSONArray2 = new JSONArray();
                            jSONArray2.put(entry.getKey()).put(entry.getValue());
                            jSONArray.put(jSONArray2);
                        }
                        return jSONArray.toString();
                    } catch (Throwable th) {
                        com.alipay.sdk.util.c.a(th);
                        return new JSONArray().toString();
                    }
                }
                return (String) invokeV.objValue;
            }

            public C1558a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                        return;
                    }
                }
                this.f35694a = new LinkedHashMap<>();
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i4);
                        this.f35694a.put(jSONArray2.getString(0), jSONArray2.getString(1));
                    }
                } catch (Throwable th) {
                    com.alipay.sdk.util.c.a(th);
                }
            }
        }

        public static synchronized String a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
                synchronized (C1557a.class) {
                    com.alipay.sdk.util.c.a(f35692a, "stat peek");
                    if (context == null) {
                        return null;
                    }
                    C1558a b2 = b(context);
                    if (b2.f35694a.isEmpty()) {
                        return null;
                    }
                    return b2.f35694a.entrySet().iterator().next().getValue();
                }
            }
            return (String) invokeL.objValue;
        }

        public static synchronized int a(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
                synchronized (C1557a.class) {
                    com.alipay.sdk.util.c.a(f35692a, "stat remove " + str);
                    if (context != null && !TextUtils.isEmpty(str)) {
                        C1558a b2 = b(context);
                        if (b2.f35694a.isEmpty()) {
                            return 0;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (Map.Entry<String, String> entry : b2.f35694a.entrySet()) {
                            if (str.equals(entry.getValue())) {
                                arrayList.add(entry.getKey());
                            }
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            b2.f35694a.remove((String) it.next());
                        }
                        a(context, b2);
                        return arrayList.size();
                    }
                    return 0;
                }
            }
            return invokeLL.intValue;
        }

        public static synchronized void a(Context context, C1558a c1558a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, c1558a) == null) {
                synchronized (C1557a.class) {
                    if (c1558a == null) {
                        try {
                            c1558a = new C1558a();
                        } catch (Throwable th) {
                            com.alipay.sdk.util.c.a(th);
                        }
                    }
                    g.a(null, context, f35693b, c1558a.a());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        public static synchronized boolean b(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str)) == null) {
                synchronized (b.class) {
                    com.alipay.sdk.util.c.a(com.alipay.sdk.cons.a.x, "stat sub " + str);
                    if ((com.alipay.sdk.data.a.p().g() ? new d() : new e()).a((com.alipay.sdk.sys.a) null, context, str) != null) {
                        C1557a.a(context, str);
                        return true;
                    }
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }

        public static synchronized void a(Context context, com.alipay.sdk.app.statistic.b bVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(65538, null, context, bVar, str, str2) == null) {
                synchronized (b.class) {
                    if (context == null || bVar == null || str == null) {
                        return;
                    }
                    a(context, bVar.a(str), str2);
                }
            }
        }

        public static synchronized void a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
                synchronized (b.class) {
                    a(context, null, null);
                }
            }
        }

        public static synchronized void a(Context context, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65539, null, context, str, str2) == null) {
                synchronized (b.class) {
                    if (context == null) {
                        return;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        C1557a.a(context, str, str2);
                    }
                    new Thread(new Runnable(str, context) { // from class: com.alipay.sdk.app.statistic.a.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ String f35695a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ Context f35696b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {str, context};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f35695a = str;
                            this.f35696b = context;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                if (TextUtils.isEmpty(this.f35695a) || b.b(this.f35696b, this.f35695a)) {
                                    for (int i2 = 0; i2 < 4; i2++) {
                                        String a2 = C1557a.a(this.f35696b);
                                        if (TextUtils.isEmpty(a2) || !b.b(this.f35696b, a2)) {
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }).start();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static final String f35697a = "alipay_cashier_statistic_v";
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        public static synchronized long a(Context context) {
            InterceptResult invokeL;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (c.class) {
                    long j3 = 0;
                    try {
                        String b2 = g.b(null, context, f35697a, null);
                        if (!TextUtils.isEmpty(b2)) {
                            j3 = Long.parseLong(b2);
                        }
                    } catch (Throwable unused) {
                    }
                    j2 = j3 + 1;
                    try {
                        g.a(null, context, f35697a, Long.toString(j2));
                    } catch (Throwable unused2) {
                    }
                }
                return j2;
            }
            return invokeL.longValue;
        }
    }

    public a() {
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

    public static synchronized void a(Context context, com.alipay.sdk.sys.a aVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, context, aVar, str, str2) == null) {
            synchronized (a.class) {
                if (context == null || aVar == null) {
                    return;
                }
                try {
                    C1557a.a(context, aVar.u.a(str), str2);
                } catch (Throwable th) {
                    com.alipay.sdk.util.c.a(th);
                }
            }
        }
    }

    public static synchronized void b(Context context, com.alipay.sdk.sys.a aVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65544, null, context, aVar, str, str2) == null) {
            synchronized (a.class) {
                if (context == null || aVar == null) {
                    return;
                }
                b.a(context, aVar.u, str, str2);
            }
        }
    }

    public static void b(com.alipay.sdk.sys.a aVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65545, null, aVar, str, str2, str3) == null) || aVar == null) {
            return;
        }
        aVar.u.b(str, str2, str3);
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (a.class) {
                b.a(context);
            }
        }
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65543, null, aVar, str, th) == null) || aVar == null || th == null || th.getClass() == null) {
            return;
        }
        aVar.u.a(str, th.getClass().getSimpleName(), th);
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, String str2, Throwable th, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(AdIconUtil.BAIDU_LOGO_ID, null, aVar, str, str2, th, str3) == null) || aVar == null) {
            return;
        }
        aVar.u.a(str, str2, th, str3);
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, aVar, str, str2, th) == null) || aVar == null) {
            return;
        }
        aVar.u.a(str, str2, th);
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, str, str2, str3) == null) || aVar == null) {
            return;
        }
        aVar.u.a(str, str2, str3);
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, aVar, str, str2) == null) || aVar == null) {
            return;
        }
        aVar.u.a(str, str2);
    }
}
