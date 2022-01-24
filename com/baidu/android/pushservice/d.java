package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.c;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.RecordConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static Boolean f31894c = null;
    public static volatile d n = null;
    public static int w = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] A;
    public int B;
    public int C;
    public int D;
    public String E;
    public volatile int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f31895b;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f31896d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f31897e;

    /* renamed from: f  reason: collision with root package name */
    public b f31898f;

    /* renamed from: g  reason: collision with root package name */
    public a f31899g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f31900h;

    /* renamed from: i  reason: collision with root package name */
    public long f31901i;

    /* renamed from: j  reason: collision with root package name */
    public int f31902j;
    public final Handler k;
    public final Context l;
    public com.baidu.android.pushservice.message.d m;
    public boolean o;
    public boolean p;
    public String q;
    public String r;
    public int s;
    public Thread t;
    public List<String> u;
    public boolean v;
    public com.baidu.android.pushservice.g.d x;
    public Runnable y;
    public long z;

    /* loaded from: classes10.dex */
    public class a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            setName("PushService-PushConnection-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            byte[] bArr;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.a.f31897e) {
                    try {
                        bArr = PushSocket.a(this.a.l, this.a.a);
                    } catch (Exception e2) {
                        com.baidu.android.pushservice.f.a.b("PushConnection", "Get message exception", this.a.l.getApplicationContext());
                        new b.c(this.a.l).a(Log.getStackTraceString(e2)).a();
                        bArr = null;
                    }
                    this.a.k.removeCallbacks(this.a.y);
                    if (this.a.o) {
                        this.a.o = false;
                        this.a.a(true);
                    }
                    if (this.a.p) {
                        this.a.p = false;
                    }
                    int lastSocketError = PushSocket.getLastSocketError();
                    if (bArr == null || bArr.length == 0) {
                        this.a.f(lastSocketError);
                        this.a.g();
                        str = "PushConnection Receive err " + this.a.l.getPackageName() + " lastSocketError " + lastSocketError + " socketfd " + this.a.a + System.currentTimeMillis();
                    } else {
                        try {
                            com.baidu.android.pushservice.message.e a = this.a.m.a(bArr);
                            if (a != null) {
                                try {
                                    this.a.m.b(a);
                                } catch (Exception e3) {
                                    com.baidu.android.pushservice.f.a.b("PushConnection", "Handle message exception " + m.a(e3), this.a.l.getApplicationContext());
                                    new b.c(this.a.l).a(Log.getStackTraceString(e3)).a();
                                    this.a.g();
                                }
                            }
                            this.a.f31902j = 0;
                        } catch (Exception e4) {
                            com.baidu.android.pushservice.f.a.c("PushConnection", "Read message exception " + m.a(e4), this.a.l.getApplicationContext());
                            new b.c(this.a.l).a(Log.getStackTraceString(e4)).a();
                            this.a.f(lastSocketError);
                            this.a.g();
                            str = "PushConnection Read message exception " + this.a.l.getPackageName() + m.a(e4) + " lastSocketError " + lastSocketError + " socketfd " + this.a.a + System.currentTimeMillis();
                        }
                    }
                    com.baidu.android.pushservice.f.a.a("PushConnection", str, this.a.l.getApplicationContext());
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            setName("PushService-PushConnection-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.a.f31897e) {
                    com.baidu.android.pushservice.message.e eVar = null;
                    synchronized (this.a.m.a()) {
                        try {
                            if (this.a.m.a().size() == 0) {
                                this.a.m.a().wait();
                            }
                            if (this.a.m.a().size() > 0) {
                                eVar = this.a.m.a().removeFirst();
                            }
                        } catch (Exception e2) {
                            new b.c(this.a.l).a(Log.getStackTraceString(e2)).a();
                        }
                    }
                    if (this.a.f31897e) {
                        return;
                    }
                    if (eVar != null && eVar.b() != null) {
                        if (eVar.c()) {
                            this.a.o = eVar.d();
                            if (com.baidu.android.pushservice.message.h.a(eVar.a()) == com.baidu.android.pushservice.message.h.f32327b) {
                                this.a.p = true;
                            }
                            this.a.k.removeCallbacks(this.a.y);
                            this.a.k.postDelayed(this.a.y, 60000L);
                        }
                        try {
                            i2 = PushSocket.a(this.a.a, eVar.b(), eVar.b().length);
                        } catch (Exception e3) {
                            new b.c(this.a.l).a(Log.getStackTraceString(e3)).a();
                            i2 = -1;
                        }
                        if (i2 == -1) {
                            this.a.f(PushSocket.getLastSocketError());
                            this.a.g();
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-840927047, "Lcom/baidu/android/pushservice/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-840927047, "Lcom/baidu/android/pushservice/d;");
                return;
            }
        }
        f31894c = Boolean.FALSE;
    }

    public d(Context context) {
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
        this.a = -1;
        this.f31895b = false;
        this.f31896d = false;
        this.f31897e = false;
        this.f31900h = false;
        this.u = Collections.synchronizedList(new ArrayList());
        this.v = false;
        this.x = new com.baidu.android.pushservice.g.d(this, 0) { // from class: com.baidu.android.pushservice.d.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.android.pushservice.g.d, java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.c(a());
                }
            }
        };
        this.y = new Runnable(this) { // from class: com.baidu.android.pushservice.d.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.baidu.android.pushservice.f.a.c("PushConnection", " -- Send Timeout --", this.a.l.getApplicationContext());
                    if (this.a.o) {
                        this.a.o = false;
                    }
                    this.a.a(false);
                    this.a.f(10004);
                    this.a.g();
                    com.baidu.android.pushservice.f.a.a("PushConnection", "PushConnection Send Timeout " + this.a.l.getPackageName() + " lastSocketError " + PushSocket.getLastSocketError() + " socketfd " + this.a.a + System.currentTimeMillis(), this.a.l.getApplicationContext());
                }
            }
        };
        this.z = 0L;
        this.A = new int[]{180, 300, 360, HttpStatus.SC_METHOD_FAILURE, RecordConstants.DEFAULT_PREVIEW_WIDTH, 720, 900};
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.l = context;
        this.k = new Handler(context.getMainLooper());
        int f2 = f();
        if (f2 >= 0 && f2 < this.A.length) {
            this.B = f2;
        }
        b(context);
        f.a(this.l).b(this.A[this.B] * 1000);
        this.E = com.baidu.android.pushservice.i.g.h(this.l);
        this.q = g.d();
        this.s = g.a(this.l);
        this.v = false;
    }

    public static d a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (n == null) {
                synchronized (d.class) {
                    if (n == null) {
                        n = new d(context);
                    }
                }
            }
            return n;
        }
        return (d) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3) {
        c a2;
        c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65546, this, i2, i3) == null) {
            if (this.a == -1 && i2 == 110) {
                this.s = 80;
            }
            f(i2);
            if (this.u.size() > 0) {
                f31894c = Boolean.FALSE;
                e(i3);
                return;
            }
            i();
            this.u.clear();
            int i4 = w;
            if (i4 != 0) {
                int i5 = 1;
                if (i4 == 1) {
                    a2 = c.a(this.l);
                    aVar = new c.a(this, i3) { // from class: com.baidu.android.pushservice.d.7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ int a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ d f31906b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i3)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i6 = newInitContext.flag;
                                if ((i6 & 1) != 0) {
                                    int i7 = i6 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f31906b = this;
                            this.a = i3;
                        }

                        @Override // com.baidu.android.pushservice.c.a
                        public void a(int i6, List<String> list) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i6, list) == null) {
                                this.f31906b.r = null;
                                Boolean unused = d.f31894c = Boolean.FALSE;
                                if (list == null || list.size() <= 0) {
                                    this.f31906b.a(10005, this.a);
                                    return;
                                }
                                this.f31906b.u.addAll(list);
                                this.f31906b.e(this.a);
                            }
                        }
                    };
                } else {
                    if (this.v) {
                        i5 = 2;
                        if (i4 == 2) {
                            a2 = c.a(this.l);
                            aVar = new c.a(this, i3) { // from class: com.baidu.android.pushservice.d.8
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ int a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ d f31907b;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Integer.valueOf(i3)};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i6 = newInitContext.flag;
                                        if ((i6 & 1) != 0) {
                                            int i7 = i6 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f31907b = this;
                                    this.a = i3;
                                }

                                @Override // com.baidu.android.pushservice.c.a
                                public void a(int i6, List<String> list) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i6, list) == null) {
                                        this.f31907b.r = null;
                                        Boolean unused = d.f31894c = Boolean.FALSE;
                                        if (list == null || list.size() <= 0) {
                                            this.f31907b.a(10006, this.a);
                                            return;
                                        }
                                        this.f31907b.u.addAll(list);
                                        this.f31907b.e(this.a);
                                    }
                                }
                            };
                        }
                    }
                    w = 0;
                }
                a2.a(i5, aVar);
                return;
            }
            this.u.add(g.d());
            f31894c = Boolean.FALSE;
            e(i3);
        }
    }

    private synchronized void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65554, this, i2) == null) {
            synchronized (this) {
                if (!this.f31895b && !f31894c.booleanValue() && !this.f31896d) {
                    this.f31896d = true;
                    this.u.clear();
                    if (w != 0) {
                        if (w == 1) {
                            c.a(this.l).a(1, new c.a(this, i2) { // from class: com.baidu.android.pushservice.d.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ int a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ d f31903b;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Integer.valueOf(i2)};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f31903b = this;
                                    this.a = i2;
                                }

                                @Override // com.baidu.android.pushservice.c.a
                                public void a(int i3, List<String> list) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, list) == null) {
                                        this.f31903b.f31896d = false;
                                        if (list == null || list.size() <= 0) {
                                            this.f31903b.a(10005, this.a);
                                            return;
                                        }
                                        if (this.f31903b.u.isEmpty()) {
                                            this.f31903b.u.addAll(list);
                                        }
                                        this.f31903b.c(this.a);
                                    }
                                }
                            });
                        } else if (this.v && w == 2) {
                            c.a(this.l).a(2, new c.a(this, i2) { // from class: com.baidu.android.pushservice.d.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ int a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ d f31904b;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Integer.valueOf(i2)};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f31904b = this;
                                    this.a = i2;
                                }

                                @Override // com.baidu.android.pushservice.c.a
                                public void a(int i3, List<String> list) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, list) == null) {
                                        this.f31904b.f31896d = false;
                                        if (list == null || list.size() <= 0) {
                                            this.f31904b.a(10006, this.a);
                                            return;
                                        }
                                        if (this.f31904b.u.isEmpty()) {
                                            this.f31904b.u.addAll(list);
                                        }
                                        this.f31904b.c(this.a);
                                    }
                                }
                            });
                        } else {
                            w = 0;
                            if (this.u.isEmpty()) {
                                this.u.add(g.d());
                            }
                            this.f31896d = false;
                        }
                    }
                    if (this.u.isEmpty()) {
                        this.u.add(g.d());
                    }
                    this.f31896d = false;
                    c(i2);
                }
            }
        }
    }

    private void b(Context context) {
        b.c cVar;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65555, this, context) == null) && PushSettings.f(context)) {
            File file = new File(Environment.getExternalStorageDirectory(), "baidu/pushservice/pushservice.cfg");
            if (file.exists()) {
                Properties properties = new Properties();
                FileInputStream fileInputStream2 = null;
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    properties.load(fileInputStream);
                    String property = properties.getProperty("rtcseed");
                    if (property != null && property.length() > 0) {
                        JSONArray jSONArray = new JSONArray(property);
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            this.A[i2] = jSONArray.getInt(i2);
                            this.B = 0;
                            this.C = 0;
                            this.D = 0;
                        }
                    }
                    String property2 = properties.getProperty("originseed");
                    if (property2 != null && property2.length() > 0) {
                        this.B = Integer.parseInt(property2);
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e = e3;
                        com.baidu.android.pushservice.f.a.b("PushConnection", "error " + e.getMessage(), this.l.getApplicationContext());
                        cVar = new b.c(this.l);
                        cVar.a(Log.getStackTraceString(e)).a();
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileInputStream2 = fileInputStream;
                    com.baidu.android.pushservice.f.a.b("PushConnection", "getTestConfig exception " + e.getMessage(), this.l.getApplicationContext());
                    new b.c(this.l).a(Log.getStackTraceString(e)).a();
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e5) {
                            e = e5;
                            com.baidu.android.pushservice.f.a.b("PushConnection", "error " + e.getMessage(), this.l.getApplicationContext());
                            cVar = new b.c(this.l);
                            cVar.a(Log.getStackTraceString(e)).a();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e6) {
                            com.baidu.android.pushservice.f.a.b("PushConnection", "error " + e6.getMessage(), this.l.getApplicationContext());
                            new b.c(this.l).a(Log.getStackTraceString(e6)).a();
                        }
                    }
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65558, this, i2) == null) {
            synchronized (this) {
                if (!this.f31895b && !f31894c.booleanValue()) {
                    if (!j.a(this.l).e()) {
                        e.h(this.l);
                        return;
                    }
                    if (this.u.size() > 0) {
                        this.q = this.u.remove(0);
                    }
                    f31894c = Boolean.TRUE;
                    this.a = -1;
                    Runnable runnable = new Runnable(this, i2) { // from class: com.baidu.android.pushservice.d.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ int a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ d f31905b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i2)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f31905b = this;
                            this.a = i2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    PushSocket.createSocket(this.f31905b.q, this.f31905b.s, new PushSocket.OnCreateSocketListener(this) { // from class: com.baidu.android.pushservice.d.3.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass3 a;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i3 = newInitContext.flag;
                                                if ((i3 & 1) != 0) {
                                                    int i4 = i3 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.a = this;
                                        }

                                        @Override // com.baidu.android.pushservice.jni.PushSocket.OnCreateSocketListener
                                        public void onConnect(int i3) {
                                            int i4;
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeI(1048576, this, i3) == null) {
                                                this.a.f31905b.a = i3;
                                                this.a.f31905b.r = PushSocket.getLastSocketIP();
                                                try {
                                                    i4 = PushSocket.getLastSocketError();
                                                } catch (Exception unused) {
                                                    i4 = 0;
                                                }
                                                if (this.a.f31905b.a <= -1 || (i4 >= 101 && i4 != 115)) {
                                                    AnonymousClass3 anonymousClass3 = this.a;
                                                    anonymousClass3.f31905b.a(i4, anonymousClass3.a);
                                                    return;
                                                }
                                                d dVar = this.a.f31905b;
                                                dVar.m = new com.baidu.android.pushservice.message.f(dVar.l.getApplicationContext());
                                                this.a.f31905b.f31895b = true;
                                                this.a.f31905b.f31901i = System.currentTimeMillis();
                                                try {
                                                    if (this.a.f31905b.f31899g != null) {
                                                        this.a.f31905b.f31899g.interrupt();
                                                    }
                                                    if (this.a.f31905b.f31898f != null) {
                                                        this.a.f31905b.f31898f.interrupt();
                                                    }
                                                    this.a.f31905b.f31897e = false;
                                                    this.a.f31905b.f31899g = new a(this.a.f31905b);
                                                    this.a.f31905b.f31899g.start();
                                                    this.a.f31905b.f31898f = new b(this.a.f31905b);
                                                    this.a.f31905b.f31898f.start();
                                                } catch (Exception unused2) {
                                                }
                                                this.a.f31905b.m.a(this.a.a);
                                                Boolean unused3 = d.f31894c = Boolean.FALSE;
                                                this.a.f31905b.q = g.d();
                                                this.a.f31905b.u.clear();
                                            }
                                        }
                                    });
                                } catch (Exception e2) {
                                    new b.c(this.f31905b.l).a(Log.getStackTraceString(e2)).a();
                                }
                            }
                        }
                    };
                    if (this.t != null) {
                        this.t.interrupt();
                    }
                    Thread thread = new Thread(runnable);
                    this.t = thread;
                    thread.setName("PushService-PushService-connect");
                    this.t.start();
                    return;
                }
                com.baidu.android.pushservice.f.a.c("PushConnection", "Connect return. mConnected:" + this.f31895b + " mConnectting:" + f31894c, this.l.getApplicationContext());
            }
        }
    }

    private Runnable d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65563, this, i2)) == null) {
            this.x.a(i2);
            return this.x;
        }
        return (Runnable) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65566, this, i2) == null) {
            com.baidu.android.pushservice.f.a.c("PushConnection", "disconnectedByPeer, mStoped == " + this.f31900h, this.l.getApplicationContext());
            h();
            if (this.f31900h) {
                return;
            }
            this.f31902j++;
            if (com.baidu.android.pushservice.b.d.g()) {
                this.k.removeCallbacks(d(i2));
                this.k.postDelayed(d(i2), 30000);
                com.baidu.android.pushservice.f.a.c("PushConnection", "PeakTime retry-- retry times: " + this.f31902j + " time delay: 30000", this.l.getApplicationContext());
            } else if (this.f31902j <= 5) {
                this.k.removeCallbacks(d(i2));
                int i3 = this.f31902j;
                int i4 = (i3 - 1) * 30 * 1000;
                if (i3 == 1) {
                    i4 = 3000;
                }
                this.k.postDelayed(d(i2), i4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65570, this, i2) == null) {
            if (this.f31901i != 0 || i2 == 0) {
                if (this.f31901i != 0) {
                    if (this.p) {
                        new b.C1743b(this.l).b(System.currentTimeMillis()).a(i2 + "").d(401102L).a();
                        this.p = false;
                        return;
                    }
                    new b.C1743b(this.l).a(true).a(this.f31901i).b(System.currentTimeMillis()).a(i2 + "").c(this.f31902j).d(401101L).a();
                    this.f31901i = 0L;
                    return;
                }
                return;
            }
            new b.C1743b(this.l).a(System.currentTimeMillis()).a(i2 + "").b(this.q + "/" + this.r + ":" + this.s + ":" + w + ":" + com.baidu.android.pushservice.i.g.g(this.l)).d(401100L).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            e(0);
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            com.baidu.android.pushservice.f.a.c("PushConnection", "destroy", this.l.getApplicationContext());
            Handler handler = this.k;
            if (handler != null) {
                handler.removeCallbacks(this.y);
            }
            this.f31897e = true;
            this.f31895b = false;
            com.baidu.android.pushservice.message.d dVar = this.m;
            if (dVar != null) {
                try {
                    synchronized (dVar.a()) {
                        this.m.a().notifyAll();
                    }
                } catch (Exception e2) {
                    new b.c(this.l).a(Log.getStackTraceString(e2)).a();
                }
            }
            PushSocket.a(this.a);
            this.a = -1;
            com.baidu.android.pushservice.message.d dVar2 = this.m;
            if (dVar2 != null) {
                dVar2.b();
            }
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
            w = (w + 1) % 3;
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f31902j = 0;
            this.f31900h = false;
            b(i2);
        }
    }

    public void a(int i2, String str, byte[] bArr) {
        com.baidu.android.pushservice.message.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, bArr) == null) || (dVar = this.m) == null) {
            return;
        }
        dVar.a(i2, str, bArr);
    }

    public void a(boolean z) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            String h2 = com.baidu.android.pushservice.i.g.h(this.l);
            if (TextUtils.equals(this.E, h2)) {
                int d2 = d();
                if (z) {
                    if (com.baidu.android.pushservice.i.g.a(this.l)) {
                        e();
                        int i2 = this.C + 1;
                        this.C = i2;
                        if (i2 >= 3) {
                            this.C = 0;
                            int i3 = this.B;
                            if (i3 < this.A.length - 1) {
                                this.C = 0;
                                this.B = i3 + 1;
                            }
                        }
                        if (this.D >= 30) {
                            this.D = 0;
                        }
                        sb = new StringBuilder();
                        sb.append("RTC stat change from ");
                        sb.append(d2);
                        sb.append(" to ");
                        sb.append(d());
                    }
                    this.B++;
                    sb = new StringBuilder();
                    sb.append("RTC stat change from ");
                    sb.append(d2);
                    sb.append(" to ");
                    sb.append(d());
                } else {
                    this.C = 0;
                    this.D = 0;
                    if (com.baidu.android.pushservice.i.g.a(this.l)) {
                        int i4 = this.B;
                        if (i4 > 0) {
                            this.B = i4 - 1;
                            e();
                        }
                        sb = new StringBuilder();
                        sb.append("RTC stat change from ");
                        sb.append(d2);
                        sb.append(" to ");
                        sb.append(d());
                    }
                    this.B++;
                    sb = new StringBuilder();
                    sb.append("RTC stat change from ");
                    sb.append(d2);
                    sb.append(" to ");
                    sb.append(d());
                }
            } else {
                this.B = f();
                this.C = 0;
                sb = new StringBuilder();
                sb.append("RTC stat change ");
                sb.append(d());
                sb.append(" because of network changing");
            }
            sb.toString();
            this.E = h2;
            f.a(this.l).b(d() * 1000);
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31895b : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            com.baidu.android.pushservice.f.a.c("PushConnection", "---stop---", this.l.getApplicationContext());
            this.f31897e = true;
            this.f31900h = true;
            this.k.removeCallbacks(this.x);
            h();
            n = null;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.m == null) {
            return;
        }
        if (System.currentTimeMillis() - this.z >= 60000) {
            com.baidu.android.pushservice.g.e.a().a(new com.baidu.android.pushservice.g.c(this, "heartbeat", (short) 98) { // from class: com.baidu.android.pushservice.d.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, Short.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.android.pushservice.g.c
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        int i2 = ((int) (currentTimeMillis / 1000)) % 60;
                        if (((int) ((currentTimeMillis / 60000) % 5)) == 0 && i2 < 15) {
                            try {
                                Thread.sleep((long) (Math.random() * 60.0d * 1000.0d));
                            } catch (InterruptedException unused) {
                            }
                        }
                        this.a.m.c();
                        this.a.z = System.currentTimeMillis();
                        com.baidu.android.pushservice.f.a.c("PushConnection", "sendHeartbeatMessage", this.a.l.getApplicationContext());
                    }
                }
            });
        } else {
            com.baidu.android.pushservice.f.a.c("PushConnection", "sendHeartbeatMessage ingnored， because too frequent.", this.l.getApplicationContext());
        }
    }

    public int d() {
        InterceptResult invokeV;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i2 = this.B;
            if (i2 >= 0) {
                int[] iArr = this.A;
                if (i2 >= iArr.length) {
                    length = iArr.length - 1;
                }
                return this.A[this.B];
            }
            length = 0;
            this.B = length;
            return this.A[this.B];
        }
        return invokeV.intValue;
    }

    public void e() {
        Context context;
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (com.baidu.android.pushservice.i.g.b(this.l)) {
                context = this.l;
                i2 = this.B;
                str = "com.baidu.pushservice.CUR_PERIOD_WIFI";
            } else {
                context = this.l;
                i2 = this.B;
                str = "com.baidu.pushservice.CUR_PERIOD_MOBILE";
            }
            com.baidu.android.pushservice.i.i.a(context, str, i2);
        }
    }

    public int f() {
        InterceptResult invokeV;
        Context context;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (com.baidu.android.pushservice.i.g.a(this.l)) {
                if (com.baidu.android.pushservice.i.g.b(this.l)) {
                    context = this.l;
                    str = "com.baidu.pushservice.CUR_PERIOD_WIFI";
                } else {
                    context = this.l;
                    str = "com.baidu.pushservice.CUR_PERIOD_MOBILE";
                }
                return com.baidu.android.pushservice.i.i.b(context, str, 0);
            }
            return 0;
        }
        return invokeV.intValue;
    }
}
