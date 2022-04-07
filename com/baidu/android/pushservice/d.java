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
/* loaded from: classes.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static Boolean c = null;
    public static volatile d n = null;
    public static int w = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] A;
    public int B;
    public int C;
    public int D;
    public String E;
    public volatile int a;
    public boolean b;
    public volatile boolean d;
    public boolean e;
    public b f;
    public a g;
    public boolean h;
    public long i;
    public int j;
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

    /* loaded from: classes.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                while (!this.a.e) {
                    try {
                        bArr = PushSocket.a(this.a.l, this.a.a);
                    } catch (Exception e) {
                        com.baidu.android.pushservice.f.a.b("PushConnection", "Get message exception", this.a.l.getApplicationContext());
                        new b.c(this.a.l).a(Log.getStackTraceString(e)).a();
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
                                } catch (Exception e2) {
                                    com.baidu.android.pushservice.f.a.b("PushConnection", "Handle message exception " + m.a(e2), this.a.l.getApplicationContext());
                                    new b.c(this.a.l).a(Log.getStackTraceString(e2)).a();
                                    this.a.g();
                                }
                            }
                            this.a.j = 0;
                        } catch (Exception e3) {
                            com.baidu.android.pushservice.f.a.c("PushConnection", "Read message exception " + m.a(e3), this.a.l.getApplicationContext());
                            new b.c(this.a.l).a(Log.getStackTraceString(e3)).a();
                            this.a.f(lastSocketError);
                            this.a.g();
                            str = "PushConnection Read message exception " + this.a.l.getPackageName() + m.a(e3) + " lastSocketError " + lastSocketError + " socketfd " + this.a.a + System.currentTimeMillis();
                        }
                    }
                    com.baidu.android.pushservice.f.a.a("PushConnection", str, this.a.l.getApplicationContext());
                }
            }
        }
    }

    /* loaded from: classes.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.a.e) {
                    com.baidu.android.pushservice.message.e eVar = null;
                    synchronized (this.a.m.a()) {
                        try {
                            if (this.a.m.a().size() == 0) {
                                this.a.m.a().wait();
                            }
                            if (this.a.m.a().size() > 0) {
                                eVar = this.a.m.a().removeFirst();
                            }
                        } catch (Exception e) {
                            new b.c(this.a.l).a(Log.getStackTraceString(e)).a();
                        }
                    }
                    if (this.a.e) {
                        return;
                    }
                    if (eVar != null && eVar.b() != null) {
                        if (eVar.c()) {
                            this.a.o = eVar.d();
                            if (com.baidu.android.pushservice.message.h.a(eVar.a()) == com.baidu.android.pushservice.message.h.b) {
                                this.a.p = true;
                            }
                            this.a.k.removeCallbacks(this.a.y);
                            this.a.k.postDelayed(this.a.y, 60000L);
                        }
                        try {
                            i = PushSocket.a(this.a.a, eVar.b(), eVar.b().length);
                        } catch (Exception e2) {
                            new b.c(this.a.l).a(Log.getStackTraceString(e2)).a();
                            i = -1;
                        }
                        if (i == -1) {
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
        c = Boolean.FALSE;
    }

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.b = false;
        this.d = false;
        this.e = false;
        this.h = false;
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
        int f = f();
        if (f >= 0 && f < this.A.length) {
            this.B = f;
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
    public void a(int i, int i2) {
        c a2;
        c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65546, this, i, i2) == null) {
            if (this.a == -1 && i == 110) {
                this.s = 80;
            }
            f(i);
            if (this.u.size() > 0) {
                c = Boolean.FALSE;
                e(i2);
                return;
            }
            i();
            this.u.clear();
            int i3 = w;
            if (i3 != 0) {
                int i4 = 1;
                if (i3 == 1) {
                    a2 = c.a(this.l);
                    aVar = new c.a(this, i2) { // from class: com.baidu.android.pushservice.d.7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ int a;
                        public final /* synthetic */ d b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i2)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i5 = newInitContext.flag;
                                if ((i5 & 1) != 0) {
                                    int i6 = i5 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.b = this;
                            this.a = i2;
                        }

                        @Override // com.baidu.android.pushservice.c.a
                        public void a(int i5, List<String> list) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i5, list) == null) {
                                this.b.r = null;
                                Boolean unused = d.c = Boolean.FALSE;
                                if (list == null || list.size() <= 0) {
                                    this.b.a(10005, this.a);
                                    return;
                                }
                                this.b.u.addAll(list);
                                this.b.e(this.a);
                            }
                        }
                    };
                } else {
                    if (this.v) {
                        i4 = 2;
                        if (i3 == 2) {
                            a2 = c.a(this.l);
                            aVar = new c.a(this, i2) { // from class: com.baidu.android.pushservice.d.8
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ int a;
                                public final /* synthetic */ d b;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Integer.valueOf(i2)};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i5 = newInitContext.flag;
                                        if ((i5 & 1) != 0) {
                                            int i6 = i5 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.b = this;
                                    this.a = i2;
                                }

                                @Override // com.baidu.android.pushservice.c.a
                                public void a(int i5, List<String> list) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i5, list) == null) {
                                        this.b.r = null;
                                        Boolean unused = d.c = Boolean.FALSE;
                                        if (list == null || list.size() <= 0) {
                                            this.b.a(10006, this.a);
                                            return;
                                        }
                                        this.b.u.addAll(list);
                                        this.b.e(this.a);
                                    }
                                }
                            };
                        }
                    }
                    w = 0;
                }
                a2.a(i4, aVar);
                return;
            }
            this.u.add(g.d());
            c = Boolean.FALSE;
            e(i2);
        }
    }

    private synchronized void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65554, this, i) == null) {
            synchronized (this) {
                if (!this.b && !c.booleanValue() && !this.d) {
                    this.d = true;
                    this.u.clear();
                    if (w != 0) {
                        if (w == 1) {
                            c.a(this.l).a(1, new c.a(this, i) { // from class: com.baidu.android.pushservice.d.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ int a;
                                public final /* synthetic */ d b;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Integer.valueOf(i)};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.b = this;
                                    this.a = i;
                                }

                                @Override // com.baidu.android.pushservice.c.a
                                public void a(int i2, List<String> list) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, list) == null) {
                                        this.b.d = false;
                                        if (list == null || list.size() <= 0) {
                                            this.b.a(10005, this.a);
                                            return;
                                        }
                                        if (this.b.u.isEmpty()) {
                                            this.b.u.addAll(list);
                                        }
                                        this.b.c(this.a);
                                    }
                                }
                            });
                        } else if (this.v && w == 2) {
                            c.a(this.l).a(2, new c.a(this, i) { // from class: com.baidu.android.pushservice.d.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ int a;
                                public final /* synthetic */ d b;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Integer.valueOf(i)};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.b = this;
                                    this.a = i;
                                }

                                @Override // com.baidu.android.pushservice.c.a
                                public void a(int i2, List<String> list) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, list) == null) {
                                        this.b.d = false;
                                        if (list == null || list.size() <= 0) {
                                            this.b.a(10006, this.a);
                                            return;
                                        }
                                        if (this.b.u.isEmpty()) {
                                            this.b.u.addAll(list);
                                        }
                                        this.b.c(this.a);
                                    }
                                }
                            });
                        } else {
                            w = 0;
                            if (this.u.isEmpty()) {
                                this.u.add(g.d());
                            }
                            this.d = false;
                        }
                    }
                    if (this.u.isEmpty()) {
                        this.u.add(g.d());
                    }
                    this.d = false;
                    c(i);
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
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    properties.load(fileInputStream);
                    String property = properties.getProperty("rtcseed");
                    if (property != null && property.length() > 0) {
                        JSONArray jSONArray = new JSONArray(property);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            this.A[i] = jSONArray.getInt(i);
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
                    } catch (IOException e2) {
                        e = e2;
                        com.baidu.android.pushservice.f.a.b("PushConnection", "error " + e.getMessage(), this.l.getApplicationContext());
                        cVar = new b.c(this.l);
                        cVar.a(Log.getStackTraceString(e)).a();
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream2 = fileInputStream;
                    com.baidu.android.pushservice.f.a.b("PushConnection", "getTestConfig exception " + e.getMessage(), this.l.getApplicationContext());
                    new b.c(this.l).a(Log.getStackTraceString(e)).a();
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e4) {
                            e = e4;
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
                        } catch (IOException e5) {
                            com.baidu.android.pushservice.f.a.b("PushConnection", "error " + e5.getMessage(), this.l.getApplicationContext());
                            new b.c(this.l).a(Log.getStackTraceString(e5)).a();
                        }
                    }
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65558, this, i) == null) {
            synchronized (this) {
                if (!this.b && !c.booleanValue()) {
                    if (!j.a(this.l).e()) {
                        e.h(this.l);
                        return;
                    }
                    if (this.u.size() > 0) {
                        this.q = this.u.remove(0);
                    }
                    c = Boolean.TRUE;
                    this.a = -1;
                    Runnable runnable = new Runnable(this, i) { // from class: com.baidu.android.pushservice.d.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ int a;
                        public final /* synthetic */ d b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.b = this;
                            this.a = i;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    PushSocket.createSocket(this.b.q, this.b.s, new PushSocket.OnCreateSocketListener(this) { // from class: com.baidu.android.pushservice.d.3.1
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
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.a = this;
                                        }

                                        @Override // com.baidu.android.pushservice.jni.PushSocket.OnCreateSocketListener
                                        public void onConnect(int i2) {
                                            int i3;
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeI(1048576, this, i2) == null) {
                                                this.a.b.a = i2;
                                                this.a.b.r = PushSocket.getLastSocketIP();
                                                try {
                                                    i3 = PushSocket.getLastSocketError();
                                                } catch (Exception unused) {
                                                    i3 = 0;
                                                }
                                                if (this.a.b.a <= -1 || (i3 >= 101 && i3 != 115)) {
                                                    AnonymousClass3 anonymousClass3 = this.a;
                                                    anonymousClass3.b.a(i3, anonymousClass3.a);
                                                    return;
                                                }
                                                d dVar = this.a.b;
                                                dVar.m = new com.baidu.android.pushservice.message.f(dVar.l.getApplicationContext());
                                                this.a.b.b = true;
                                                this.a.b.i = System.currentTimeMillis();
                                                try {
                                                    if (this.a.b.g != null) {
                                                        this.a.b.g.interrupt();
                                                    }
                                                    if (this.a.b.f != null) {
                                                        this.a.b.f.interrupt();
                                                    }
                                                    this.a.b.e = false;
                                                    this.a.b.g = new a(this.a.b);
                                                    this.a.b.g.start();
                                                    this.a.b.f = new b(this.a.b);
                                                    this.a.b.f.start();
                                                } catch (Exception unused2) {
                                                }
                                                this.a.b.m.a(this.a.a);
                                                Boolean unused3 = d.c = Boolean.FALSE;
                                                this.a.b.q = g.d();
                                                this.a.b.u.clear();
                                            }
                                        }
                                    });
                                } catch (Exception e) {
                                    new b.c(this.b.l).a(Log.getStackTraceString(e)).a();
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
                com.baidu.android.pushservice.f.a.c("PushConnection", "Connect return. mConnected:" + this.b + " mConnectting:" + c, this.l.getApplicationContext());
            }
        }
    }

    private Runnable d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65563, this, i)) == null) {
            this.x.a(i);
            return this.x;
        }
        return (Runnable) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65566, this, i) == null) {
            com.baidu.android.pushservice.f.a.c("PushConnection", "disconnectedByPeer, mStoped == " + this.h, this.l.getApplicationContext());
            h();
            if (this.h) {
                return;
            }
            this.j++;
            if (com.baidu.android.pushservice.b.d.g()) {
                this.k.removeCallbacks(d(i));
                this.k.postDelayed(d(i), 30000);
                com.baidu.android.pushservice.f.a.c("PushConnection", "PeakTime retry-- retry times: " + this.j + " time delay: 30000", this.l.getApplicationContext());
            } else if (this.j <= 5) {
                this.k.removeCallbacks(d(i));
                int i2 = this.j;
                int i3 = (i2 - 1) * 30 * 1000;
                if (i2 == 1) {
                    i3 = 3000;
                }
                this.k.postDelayed(d(i), i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65570, this, i) == null) {
            if (this.i != 0 || i == 0) {
                if (this.i != 0) {
                    if (this.p) {
                        new b.C0037b(this.l).b(System.currentTimeMillis()).a(i + "").d(401102L).a();
                        this.p = false;
                        return;
                    }
                    new b.C0037b(this.l).a(true).a(this.i).b(System.currentTimeMillis()).a(i + "").c(this.j).d(401101L).a();
                    this.i = 0L;
                    return;
                }
                return;
            }
            new b.C0037b(this.l).a(System.currentTimeMillis()).a(i + "").b(this.q + "/" + this.r + ":" + this.s + ":" + w + ":" + com.baidu.android.pushservice.i.g.g(this.l)).d(401100L).a();
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
            this.e = true;
            this.b = false;
            com.baidu.android.pushservice.message.d dVar = this.m;
            if (dVar != null) {
                try {
                    synchronized (dVar.a()) {
                        this.m.a().notifyAll();
                    }
                } catch (Exception e) {
                    new b.c(this.l).a(Log.getStackTraceString(e)).a();
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

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.j = 0;
            this.h = false;
            b(i);
        }
    }

    public void a(int i, String str, byte[] bArr) {
        com.baidu.android.pushservice.message.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, bArr) == null) || (dVar = this.m) == null) {
            return;
        }
        dVar.a(i, str, bArr);
    }

    public void a(boolean z) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            String h = com.baidu.android.pushservice.i.g.h(this.l);
            if (TextUtils.equals(this.E, h)) {
                int d = d();
                if (z) {
                    if (com.baidu.android.pushservice.i.g.a(this.l)) {
                        e();
                        int i = this.C + 1;
                        this.C = i;
                        if (i >= 3) {
                            this.C = 0;
                            int i2 = this.B;
                            if (i2 < this.A.length - 1) {
                                this.C = 0;
                                this.B = i2 + 1;
                            }
                        }
                        if (this.D >= 30) {
                            this.D = 0;
                        }
                        sb = new StringBuilder();
                        sb.append("RTC stat change from ");
                        sb.append(d);
                        sb.append(" to ");
                        sb.append(d());
                    }
                    this.B++;
                    sb = new StringBuilder();
                    sb.append("RTC stat change from ");
                    sb.append(d);
                    sb.append(" to ");
                    sb.append(d());
                } else {
                    this.C = 0;
                    this.D = 0;
                    if (com.baidu.android.pushservice.i.g.a(this.l)) {
                        int i3 = this.B;
                        if (i3 > 0) {
                            this.B = i3 - 1;
                            e();
                        }
                        sb = new StringBuilder();
                        sb.append("RTC stat change from ");
                        sb.append(d);
                        sb.append(" to ");
                        sb.append(d());
                    }
                    this.B++;
                    sb = new StringBuilder();
                    sb.append("RTC stat change from ");
                    sb.append(d);
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
            this.E = h;
            f.a(this.l).b(d() * 1000);
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            com.baidu.android.pushservice.f.a.c("PushConnection", "---stop---", this.l.getApplicationContext());
            this.e = true;
            this.h = true;
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                        int i = ((int) (currentTimeMillis / 1000)) % 60;
                        if (((int) ((currentTimeMillis / 60000) % 5)) == 0 && i < 15) {
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
            int i = this.B;
            if (i >= 0) {
                int[] iArr = this.A;
                if (i >= iArr.length) {
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
        int i;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (com.baidu.android.pushservice.i.g.b(this.l)) {
                context = this.l;
                i = this.B;
                str = "com.baidu.pushservice.CUR_PERIOD_WIFI";
            } else {
                context = this.l;
                i = this.B;
                str = "com.baidu.pushservice.CUR_PERIOD_MOBILE";
            }
            com.baidu.android.pushservice.i.i.a(context, str, i);
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
