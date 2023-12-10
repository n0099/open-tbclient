package com.baidu.android.pushservice.o;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.a0.i;
import com.baidu.android.pushservice.a0.j;
import com.baidu.android.pushservice.e;
import com.baidu.android.pushservice.l.d;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.android.pushservice.z.c;
import com.baidu.tieba.jbc;
import com.baidu.tieba.m9c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.push.HmsMessaging;
import com.tencent.connect.common.Constants;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentLinkedQueue<Long> e;
    public static final ConcurrentLinkedQueue<Long> f;
    public static final ConcurrentLinkedQueue<Long> g;
    public static final ConcurrentLinkedQueue<Long> h;
    public static volatile a i;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public Context c;
    public Timer d;

    /* renamed from: com.baidu.android.pushservice.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0033a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a c;

        public C0033a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = aVar;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.c.d();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.f();
                } catch (Exception unused) {
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-676721284, "Lcom/baidu/android/pushservice/o/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-676721284, "Lcom/baidu/android/pushservice/o/a;");
                return;
            }
        }
        e = new ConcurrentLinkedQueue<>();
        f = new ConcurrentLinkedQueue<>();
        g = new ConcurrentLinkedQueue<>();
        h = new ConcurrentLinkedQueue<>();
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.b = "";
        this.d = null;
        this.c = context;
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (i == null) {
                synchronized (a.class) {
                    if (i == null) {
                        i = new a(context);
                    }
                }
            }
            return i;
        }
        return (a) invokeL.objValue;
    }

    public final String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            ConcurrentLinkedQueue<Long> concurrentLinkedQueue = g;
            long j = 0;
            long longValue = (concurrentLinkedQueue == null || concurrentLinkedQueue.size() <= 0) ? 0L : g.poll().longValue();
            ConcurrentLinkedQueue<Long> concurrentLinkedQueue2 = h;
            if (concurrentLinkedQueue2 != null && concurrentLinkedQueue2.size() > 0) {
                j = h.poll().longValue();
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject2.put(Constants.PARAM_PLATFORM, 0);
                jSONObject2.put("token", str);
                jSONObject2.put("cost", j);
                jSONObject3.put(Constants.PARAM_PLATFORM, 9);
                jSONObject3.put("token", str2);
                jSONObject3.put("cost", longValue);
                jSONArray.put(jSONObject2);
                jSONArray.put(jSONObject3);
                jSONObject.put("info", jSONArray);
            } catch (JSONException unused) {
            }
            j.a(this.c, 5, str);
            j.a(this.c, 10, str2);
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }

    public synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            synchronized (this) {
                this.a = str;
                try {
                    a(false);
                    if (a()) {
                        if (this.d != null) {
                            this.d.cancel();
                        }
                        f();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public final void a(boolean z) {
        ConcurrentLinkedQueue<Long> concurrentLinkedQueue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (z) {
                if (e.size() > 0) {
                    valueOf = e.poll();
                }
                concurrentLinkedQueue = h;
            } else {
                if (f.size() > 0) {
                    valueOf = f.poll();
                }
                concurrentLinkedQueue = g;
            }
            concurrentLinkedQueue.add(Long.valueOf(System.currentTimeMillis() - valueOf.longValue()));
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (d.g(this.c) == 1) {
                return (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.a)) ? false : true;
            }
            return !TextUtils.isEmpty(d.g(this.c) == 2 ? this.a : this.b);
        }
        return invokeV.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            f.add(Long.valueOf(System.currentTimeMillis()));
            try {
                m9c.a().b(this.c, true);
            } catch (Throwable unused) {
            }
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public synchronized void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            synchronized (this) {
                this.b = str;
                try {
                    a(true);
                    if (a()) {
                        if (this.d != null) {
                            this.d.cancel();
                        }
                        f();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            e.add(Long.valueOf(System.currentTimeMillis()));
            try {
                String token = HmsInstanceId.getInstance(this.c).getToken(jbc.c(this.c).a("client/app_id"), HmsMessaging.DEFAULT_TOKEN_SCOPE);
                this.b = token;
                if (!TextUtils.isEmpty(token)) {
                    a(true);
                }
            } catch (Throwable unused) {
                PushSettings.h = 1;
                i.b(this.c, "com.baidu.android.pushservice.PushSettings.hw_hms_down_mode", 1);
                Utility.W(this.c);
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.d == null) {
                this.d = new Timer();
            }
            b bVar = new b(this);
            g();
            if (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.a)) {
                if (d.g(this.c) == 1) {
                    e.b(this.c, a(this.b, this.a));
                } else if (d.g(this.c) == 2) {
                    e.a(this.c, this.a);
                } else {
                    e.a(this.c, this.b, 5);
                }
            }
            if (!TextUtils.isEmpty(this.a) && TextUtils.isEmpty(this.b)) {
                if (d.g(this.c) == 2) {
                    e.a(this.c, this.a);
                } else {
                    this.d.schedule(bVar, 3000L);
                }
            }
            if (!TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.a)) {
                if (d.g(this.c) == 2 || d.g(this.c) == 1) {
                    this.d.schedule(bVar, 3000L);
                } else {
                    e.a(this.c, this.b, 5);
                }
            }
            if (TextUtils.isEmpty(this.a) && TextUtils.isEmpty(this.b)) {
                this.d.schedule(bVar, 3000L);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            com.baidu.android.pushservice.z.e.a().a(new C0033a(this));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            boolean z = System.currentTimeMillis() - j.d(this.c) <= 86400000;
            if (TextUtils.isEmpty(this.b) && z) {
                this.b = j.b(this.c);
                a(true);
            }
            if (TextUtils.isEmpty(this.a) && z) {
                this.a = j.a(this.c);
                a(false);
            }
            if (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.a)) {
                if (d.g(this.c) == 1) {
                    e.b(this.c, a(this.b, this.a));
                } else if (d.g(this.c) == 2) {
                    e.a(this.c, this.a);
                } else {
                    e.a(this.c, this.b, 5);
                }
            }
            if (!TextUtils.isEmpty(this.a) && TextUtils.isEmpty(this.b)) {
                if (d.g(this.c) == 1) {
                    e.b(this.c, a("", this.a));
                } else {
                    e.a(this.c, this.a);
                }
            }
            if (!TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.a)) {
                e.a(this.c, this.b, 5);
            }
            if (TextUtils.isEmpty(this.a) && TextUtils.isEmpty(this.b)) {
                e.a(this.c, 0);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (d.g(this.c) == 1) {
                if (TextUtils.isEmpty(this.b)) {
                    c();
                }
                if (!TextUtils.isEmpty(this.a)) {
                    return;
                }
            } else if (d.g(this.c) != 2) {
                if (TextUtils.isEmpty(this.b)) {
                    c();
                    return;
                }
                return;
            } else if (!TextUtils.isEmpty(this.a)) {
                return;
            }
            b();
        }
    }
}
