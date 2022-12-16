package com.alipay.sdk.app.statistic;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.packet.e;
import com.alipay.sdk.packet.impl.d;
import com.alipay.sdk.util.h;
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
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.alipay.sdk.app.statistic.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0007a {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String a = "RecordPref";
        public static final String b = "alipay_cashier_statistic_record";
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.alipay.sdk.app.statistic.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0008a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final LinkedHashMap<String, String> a;

            public C0008a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = new LinkedHashMap<>();
            }

            public C0008a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                        return;
                    }
                }
                this.a = new LinkedHashMap<>();
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i3);
                        this.a.put(jSONArray2.getString(0), jSONArray2.getString(1));
                    }
                } catch (Throwable th) {
                    com.alipay.sdk.util.c.a(th);
                }
            }

            public String a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    try {
                        JSONArray jSONArray = new JSONArray();
                        for (Map.Entry<String, String> entry : this.a.entrySet()) {
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
        }

        public C0007a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static synchronized int a(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
                synchronized (C0007a.class) {
                    com.alipay.sdk.util.c.b(a, "stat remove " + str);
                    if (context != null && !TextUtils.isEmpty(str)) {
                        C0008a a2 = a(context);
                        if (a2.a.isEmpty()) {
                            return 0;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (Map.Entry<String, String> entry : a2.a.entrySet()) {
                            if (str.equals(entry.getValue())) {
                                arrayList.add(entry.getKey());
                            }
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            a2.a.remove((String) it.next());
                        }
                        a(context, a2);
                        return arrayList.size();
                    }
                    return 0;
                }
            }
            return invokeLL.intValue;
        }

        public static synchronized C0008a a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
                synchronized (C0007a.class) {
                    try {
                        String a2 = h.a(null, context, b, null);
                        if (TextUtils.isEmpty(a2)) {
                            return new C0008a();
                        }
                        return new C0008a(a2);
                    } catch (Throwable th) {
                        com.alipay.sdk.util.c.a(th);
                        return new C0008a();
                    }
                }
            }
            return (C0008a) invokeL.objValue;
        }

        public static synchronized String a(Context context, String str, String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) {
                synchronized (C0007a.class) {
                    com.alipay.sdk.util.c.b(a, "stat append " + str2 + " , " + str);
                    if (context != null && !TextUtils.isEmpty(str)) {
                        if (TextUtils.isEmpty(str2)) {
                            str2 = UUID.randomUUID().toString();
                        }
                        C0008a a2 = a(context);
                        if (a2.a.size() > 20) {
                            a2.a.clear();
                        }
                        a2.a.put(str2, str);
                        a(context, a2);
                        return str2;
                    }
                    return null;
                }
            }
            return (String) invokeLLL.objValue;
        }

        public static synchronized void a(Context context, C0008a c0008a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, c0008a) == null) {
                synchronized (C0007a.class) {
                    if (c0008a == null) {
                        try {
                            c0008a = new C0008a();
                        } catch (Throwable th) {
                            com.alipay.sdk.util.c.a(th);
                        }
                    }
                    h.b(null, context, b, c0008a.a());
                }
            }
        }

        public static synchronized String b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
                synchronized (C0007a.class) {
                    com.alipay.sdk.util.c.b(a, "stat peek");
                    if (context == null) {
                        return null;
                    }
                    C0008a a2 = a(context);
                    if (a2.a.isEmpty()) {
                        return null;
                    }
                    return a2.a.entrySet().iterator().next().getValue();
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.alipay.sdk.app.statistic.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class RunnableC0009a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ Context b;

            public RunnableC0009a(String str, Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
                this.b = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!TextUtils.isEmpty(this.a) && !b.b(this.b, this.a)) {
                        return;
                    }
                    for (int i = 0; i < 4; i++) {
                        String b = C0007a.b(this.b);
                        if (TextUtils.isEmpty(b) || !b.b(this.b, b)) {
                            return;
                        }
                    }
                }
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
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

        public static synchronized void a(Context context, com.alipay.sdk.app.statistic.b bVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(65538, null, context, bVar, str, str2) == null) {
                synchronized (b.class) {
                    if (context != null && bVar != null && str != null) {
                        a(context, bVar.a(str), str2);
                    }
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
                        C0007a.a(context, str, str2);
                    }
                    new Thread(new RunnableC0009a(str, context)).start();
                }
            }
        }

        public static synchronized boolean b(Context context, String str) {
            InterceptResult invokeLL;
            e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
                synchronized (b.class) {
                    com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "stat sub " + str);
                    if (com.alipay.sdk.data.a.u().d()) {
                        eVar = new d();
                    } else {
                        eVar = new com.alipay.sdk.packet.impl.e();
                    }
                    if (eVar.a((com.alipay.sdk.sys.a) null, context, str) == null) {
                        return false;
                    }
                    C0007a.a(context, str);
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String a = "alipay_cashier_statistic_v";
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:17:0x0029
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
            */
        public static synchronized long a(android.content.Context r6) {
            /*
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.alipay.sdk.app.statistic.a.c.$ic
                if (r0 != 0) goto L2c
            L4:
                java.lang.Class<com.alipay.sdk.app.statistic.a$c> r0 = com.alipay.sdk.app.statistic.a.c.class
                monitor-enter(r0)
                r1 = 0
                java.lang.String r2 = "alipay_cashier_statistic_v"
                java.lang.String r2 = com.alipay.sdk.util.h.a(r1, r6, r2, r1)     // Catch: java.lang.Throwable -> L19
                boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L19
                if (r3 != 0) goto L19
                long r2 = java.lang.Long.parseLong(r2)     // Catch: java.lang.Throwable -> L19
                goto L1b
            L19:
                r2 = 0
            L1b:
                r4 = 1
                long r2 = r2 + r4
                java.lang.String r4 = "alipay_cashier_statistic_v"
                java.lang.String r5 = java.lang.Long.toString(r2)     // Catch: java.lang.Throwable -> L27
                com.alipay.sdk.util.h.b(r1, r6, r4, r5)     // Catch: java.lang.Throwable -> L27
            L27:
                monitor-exit(r0)
                return r2
            L29:
                r6 = move-exception
                monitor-exit(r0)
                throw r6
            L2c:
                r3 = r0
                r4 = 65537(0x10001, float:9.1837E-41)
                r5 = 0
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r3.invokeL(r4, r5, r6)
                if (r0 == 0) goto L4
                long r1 = r0.longValue
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.statistic.a.c.a(android.content.Context):long");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (a.class) {
                b.a(context);
            }
        }
    }

    public static synchronized void a(Context context, com.alipay.sdk.sys.a aVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, context, aVar, str, str2) == null) {
            synchronized (a.class) {
                if (context != null && aVar != null) {
                    try {
                        C0007a.a(context, aVar.i.a(str), str2);
                    } catch (Throwable th) {
                        com.alipay.sdk.util.c.a(th);
                    }
                }
            }
        }
    }

    public static synchronized void b(Context context, com.alipay.sdk.sys.a aVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65544, null, context, aVar, str, str2) == null) {
            synchronized (a.class) {
                if (context != null && aVar != null) {
                    b.a(context, aVar.i, str, str2);
                }
            }
        }
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65539, null, aVar, str, str2) != null) || aVar == null) {
            return;
        }
        aVar.i.a(str, str2);
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, str, str2, str3) != null) || aVar == null) {
            return;
        }
        aVar.i.a(str, str2, str3);
    }

    public static void b(com.alipay.sdk.sys.a aVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65545, null, aVar, str, str2, str3) != null) || aVar == null) {
            return;
        }
        aVar.i.b(str, str2, str3);
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, aVar, str, str2, th) != null) || aVar == null) {
            return;
        }
        aVar.i.a(str, str2, th);
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, String str2, Throwable th, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65542, null, aVar, str, str2, th, str3) != null) || aVar == null) {
            return;
        }
        aVar.i.a(str, str2, th, str3);
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65543, null, aVar, str, th) == null) && aVar != null && th != null && th.getClass() != null) {
            aVar.i.a(str, th.getClass().getSimpleName(), th);
        }
    }
}
