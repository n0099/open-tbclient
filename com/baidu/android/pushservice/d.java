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
import com.baidu.sapi2.share.ShareCallPacking;
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
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
/* loaded from: classes.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static Boolean b = null;
    public static volatile d m = null;
    public static int v = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable A;
    public long B;
    public final int[] C;
    public int D;
    public int E;
    public int F;
    public String G;
    public boolean a;
    public volatile boolean c;
    public boolean d;
    public b e;
    public a f;
    public boolean g;
    public long h;
    public int i;
    public final Handler j;
    public final Context k;
    public com.baidu.android.pushservice.message.d l;
    public boolean n;
    public boolean o;
    public String p;
    public String q;
    public int r;
    public Thread s;
    public List<String> t;
    public boolean u;
    public Socket w;
    public InputStream x;
    public OutputStream y;
    public com.baidu.android.pushservice.g.d z;

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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.a.d) {
                    com.baidu.android.pushservice.message.e eVar = null;
                    try {
                        eVar = this.a.l.b();
                    } catch (Exception e) {
                        new b.c(this.a.k).a(Log.getStackTraceString(e)).a();
                    }
                    this.a.j.removeCallbacks(this.a.A);
                    if (this.a.n) {
                        this.a.n = false;
                        this.a.a(true);
                    }
                    if (this.a.o) {
                        this.a.o = false;
                    }
                    if (eVar == null || !((eVar.b() != null && eVar.b().length != 0) || eVar.a() == com.baidu.android.pushservice.message.h.g.b() || eVar.a() == com.baidu.android.pushservice.message.h.f.b())) {
                        this.a.f((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT);
                        this.a.g();
                        com.baidu.android.pushservice.f.a.a("PushConnection", "PushConnection Receive err " + this.a.k.getPackageName() + System.currentTimeMillis(), this.a.k.getApplicationContext());
                    } else {
                        try {
                            this.a.l.b(eVar);
                            this.a.i = 0;
                        } catch (Exception e2) {
                            new b.c(this.a.k).a(Log.getStackTraceString(e2)).a();
                            this.a.g();
                        }
                    }
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.a.d) {
                    com.baidu.android.pushservice.message.e eVar = null;
                    synchronized (this.a.l.a()) {
                        try {
                            if (this.a.l.a().size() == 0) {
                                this.a.l.a().wait();
                            }
                            if (this.a.l.a().size() > 0) {
                                eVar = this.a.l.a().removeFirst();
                            }
                        } catch (Exception e) {
                            new b.c(this.a.k).a(Log.getStackTraceString(e)).a();
                        }
                    }
                    if (this.a.d) {
                        return;
                    }
                    if (eVar != null && eVar.b() != null) {
                        if (eVar.c()) {
                            this.a.n = eVar.d();
                            if (com.baidu.android.pushservice.message.h.a(eVar.a()) == com.baidu.android.pushservice.message.h.b) {
                                this.a.o = true;
                            }
                            this.a.j.removeCallbacks(this.a.A);
                            this.a.j.postDelayed(this.a.A, 60000L);
                        }
                        try {
                            this.a.y.write(eVar.b());
                            this.a.y.flush();
                        } catch (Exception e2) {
                            this.a.g();
                            this.a.f((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT);
                            new b.c(this.a.k).a(Log.getStackTraceString(e2)).a();
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
        b = Boolean.FALSE;
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
        this.a = false;
        this.c = false;
        this.d = false;
        this.g = false;
        this.t = Collections.synchronizedList(new ArrayList());
        this.u = false;
        this.z = new com.baidu.android.pushservice.g.d(this, 0) { // from class: com.baidu.android.pushservice.d.4
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
        this.A = new Runnable(this) { // from class: com.baidu.android.pushservice.d.5
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
                    com.baidu.android.pushservice.f.a.c("PushConnection", " -- Send Timeout --", this.a.k.getApplicationContext());
                    if (this.a.n) {
                        this.a.n = false;
                    }
                    this.a.a(false);
                    this.a.f(10004);
                    this.a.g();
                    com.baidu.android.pushservice.f.a.a("PushConnection", "PushConnection Send Timeout " + this.a.k.getPackageName() + System.currentTimeMillis(), this.a.k.getApplicationContext());
                }
            }
        };
        this.B = 0L;
        this.C = new int[]{180, 300, 360, HttpStatus.SC_METHOD_FAILURE, RecordConstants.DEFAULT_PREVIEW_WIDTH, 720, 900};
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.k = context;
        this.j = new Handler(context.getMainLooper());
        int f = f();
        if (f >= 0 && f < this.C.length) {
            this.D = f;
        }
        b(context);
        f.a(this.k).b(this.C[this.D] * 1000);
        this.G = com.baidu.android.pushservice.i.g.d(this.k);
        this.p = g.d();
        this.r = g.a(this.k);
        this.u = com.baidu.android.pushservice.b.d.e(this.k);
    }

    public static d a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (m == null) {
                synchronized (d.class) {
                    if (m == null) {
                        m = new d(context);
                    }
                }
            }
            return m;
        }
        return (d) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        c a2;
        c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65549, this, i, i2) == null) {
            f(i);
            if (this.t.size() > 0) {
                b = Boolean.FALSE;
                e(i2);
                return;
            }
            j();
            this.t.clear();
            int i3 = v;
            if (i3 != 0) {
                int i4 = 1;
                if (i3 == 1) {
                    a2 = c.a(this.k);
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
                                this.b.q = null;
                                Boolean unused = d.b = Boolean.FALSE;
                                if (list == null || list.size() <= 0) {
                                    this.b.a(10005, this.a);
                                    return;
                                }
                                this.b.t.addAll(list);
                                this.b.e(this.a);
                            }
                        }
                    };
                } else {
                    if (this.u) {
                        i4 = 2;
                        if (i3 == 2) {
                            a2 = c.a(this.k);
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
                                        this.b.q = null;
                                        Boolean unused = d.b = Boolean.FALSE;
                                        if (list == null || list.size() <= 0) {
                                            this.b.a(10006, this.a);
                                            return;
                                        }
                                        this.b.t.addAll(list);
                                        this.b.e(this.a);
                                    }
                                }
                            };
                        }
                    }
                    v = 0;
                }
                a2.a(i4, aVar);
                return;
            }
            this.t.add(g.d());
            b = Boolean.FALSE;
            e(i2);
        }
    }

    private synchronized void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65556, this, i) == null) {
            synchronized (this) {
                if (!this.a && !b.booleanValue() && !this.c) {
                    this.c = true;
                    this.t.clear();
                    if (v != 0) {
                        if (v == 1) {
                            c.a(this.k).a(1, new c.a(this, i) { // from class: com.baidu.android.pushservice.d.1
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
                                        this.b.c = false;
                                        if (list == null || list.size() <= 0) {
                                            this.b.a(10005, this.a);
                                            return;
                                        }
                                        if (this.b.t.isEmpty()) {
                                            this.b.t.addAll(list);
                                        }
                                        this.b.c(this.a);
                                    }
                                }
                            });
                        } else if (this.u && v == 2) {
                            c.a(this.k).a(2, new c.a(this, i) { // from class: com.baidu.android.pushservice.d.2
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
                                        this.b.c = false;
                                        if (list == null || list.size() <= 0) {
                                            this.b.a(10006, this.a);
                                            return;
                                        }
                                        if (this.b.t.isEmpty()) {
                                            this.b.t.addAll(list);
                                        }
                                        this.b.c(this.a);
                                    }
                                }
                            });
                        } else {
                            v = 0;
                            if (this.t.isEmpty()) {
                                this.t.add(g.d());
                            }
                            this.c = false;
                        }
                    }
                    if (this.t.isEmpty()) {
                        this.t.add(g.d());
                    }
                    this.c = false;
                    c(i);
                }
            }
        }
    }

    private void b(Context context) {
        b.c cVar;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65557, this, context) == null) && PushSettings.f(context)) {
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
                            this.C[i] = jSONArray.getInt(i);
                            this.D = 0;
                            this.E = 0;
                            this.F = 0;
                        }
                    }
                    String property2 = properties.getProperty("originseed");
                    if (property2 != null && property2.length() > 0) {
                        this.D = Integer.parseInt(property2);
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        e = e2;
                        com.baidu.android.pushservice.f.a.b("PushConnection", "error " + e.getMessage(), this.k.getApplicationContext());
                        cVar = new b.c(this.k);
                        cVar.a(Log.getStackTraceString(e)).a();
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream2 = fileInputStream;
                    com.baidu.android.pushservice.f.a.b("PushConnection", "getTestConfig exception " + e.getMessage(), this.k.getApplicationContext());
                    new b.c(this.k).a(Log.getStackTraceString(e)).a();
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e4) {
                            e = e4;
                            com.baidu.android.pushservice.f.a.b("PushConnection", "error " + e.getMessage(), this.k.getApplicationContext());
                            cVar = new b.c(this.k);
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
                            com.baidu.android.pushservice.f.a.b("PushConnection", "error " + e5.getMessage(), this.k.getApplicationContext());
                            new b.c(this.k).a(Log.getStackTraceString(e5)).a();
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
        if (interceptable == null || interceptable.invokeI(65562, this, i) == null) {
            synchronized (this) {
                if (!this.a && !b.booleanValue()) {
                    if (!j.a(this.k).e()) {
                        e.h(this.k);
                        return;
                    }
                    if (this.t.size() > 0) {
                        this.p = this.t.remove(0);
                    }
                    b = Boolean.TRUE;
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
                                    this.b.w = new Socket(this.b.p, this.b.r);
                                    this.b.x = this.b.w.getInputStream();
                                    this.b.y = this.b.w.getOutputStream();
                                    try {
                                        this.b.l = new com.baidu.android.pushservice.message.f(this.b.k.getApplicationContext(), this.b.x, this.b.y);
                                        this.b.a = true;
                                        this.b.h = System.currentTimeMillis();
                                        if (this.b.f != null) {
                                            this.b.f.interrupt();
                                        }
                                        if (this.b.e != null) {
                                            this.b.e.interrupt();
                                        }
                                        this.b.d = false;
                                        this.b.f = new a(this.b);
                                        this.b.f.start();
                                        this.b.e = new b(this.b);
                                        this.b.e.start();
                                        Boolean unused = d.b = Boolean.FALSE;
                                        this.b.l.a(this.a);
                                        Boolean unused2 = d.b = Boolean.FALSE;
                                        this.b.p = g.d();
                                        this.b.t.clear();
                                    } catch (Exception e) {
                                        new b.c(this.b.k).a(Log.getStackTraceString(e)).a();
                                    }
                                } catch (Exception e2) {
                                    this.b.a((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT, this.a);
                                    new b.c(this.b.k).a(Log.getStackTraceString(e2)).a();
                                }
                            }
                        }
                    };
                    if (this.s != null) {
                        this.s.interrupt();
                    }
                    Thread thread = new Thread(runnable);
                    this.s = thread;
                    thread.setName("PushService-PushService-connect");
                    this.s.start();
                    return;
                }
                com.baidu.android.pushservice.f.a.c("PushConnection", "Connect return. mConnected:" + this.a + " mConnectting:" + b, this.k.getApplicationContext());
            }
        }
    }

    private Runnable d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65564, this, i)) == null) {
            this.z.a(i);
            return this.z;
        }
        return (Runnable) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65569, this, i) == null) {
            com.baidu.android.pushservice.f.a.c("PushConnection", "disconnectedByPeer, mStoped == " + this.g, this.k.getApplicationContext());
            h();
            if (this.g) {
                return;
            }
            this.i++;
            if (com.baidu.android.pushservice.b.d.g()) {
                this.j.removeCallbacks(d(i));
                this.j.postDelayed(d(i), 30000);
                com.baidu.android.pushservice.f.a.c("PushConnection", "PeakTime retry-- retry times: " + this.i + " time delay: 30000", this.k.getApplicationContext());
            } else if (this.i <= 5) {
                this.j.removeCallbacks(d(i));
                int i2 = this.i;
                int i3 = (i2 - 1) * 30 * 1000;
                if (i2 == 1) {
                    i3 = 3000;
                }
                this.j.postDelayed(d(i), i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65572, this, i) == null) {
            if (this.h == 0 && i != 0) {
                new b.C0038b(this.k).a(System.currentTimeMillis()).a(i + "").b(this.p + "/" + this.q + ":" + this.r + ":" + v).d(401100L).a();
            } else if (this.h != 0) {
                if (this.o) {
                    new b.C0038b(this.k).b(System.currentTimeMillis()).a(i + "").d(401102L).a();
                    this.o = false;
                    return;
                }
                new b.C0038b(this.k).a(true).a(this.h).b(System.currentTimeMillis()).a(i + "").c(this.i).d(401101L).a();
                this.h = 0L;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            e(0);
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            com.baidu.android.pushservice.f.a.c("PushConnection", "destroy", this.k.getApplicationContext());
            Handler handler = this.j;
            if (handler != null) {
                handler.removeCallbacks(this.A);
            }
            this.d = true;
            this.a = false;
            com.baidu.android.pushservice.message.d dVar = this.l;
            if (dVar != null) {
                try {
                    synchronized (dVar.a()) {
                        this.l.a().notifyAll();
                    }
                } catch (Exception e) {
                    new b.c(this.k).a(Log.getStackTraceString(e)).a();
                }
            }
            i();
            com.baidu.android.pushservice.message.d dVar2 = this.l;
            if (dVar2 != null) {
                dVar2.c();
            }
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            try {
                if (this.w != null) {
                    this.w.close();
                    this.w = null;
                }
                if (this.x != null) {
                    this.x.close();
                    this.x = null;
                }
                if (this.y != null) {
                    this.y.close();
                    this.y = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, this) == null) {
            v = (v + 1) % 3;
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.i = 0;
            this.g = false;
            b(i);
        }
    }

    public void a(int i, String str, byte[] bArr) {
        com.baidu.android.pushservice.message.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, bArr) == null) || (dVar = this.l) == null) {
            return;
        }
        dVar.a(i, str, bArr);
    }

    public void a(boolean z) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            String d = com.baidu.android.pushservice.i.g.d(this.k);
            if (TextUtils.equals(this.G, d)) {
                int d2 = d();
                if (z) {
                    if (com.baidu.android.pushservice.i.g.a(this.k)) {
                        e();
                        int i = this.E + 1;
                        this.E = i;
                        if (i >= 3) {
                            this.E = 0;
                            int i2 = this.D;
                            if (i2 < this.C.length - 1) {
                                this.E = 0;
                                this.D = i2 + 1;
                            }
                        }
                        if (this.F >= 30) {
                            this.F = 0;
                        }
                        sb = new StringBuilder();
                        sb.append("RTC stat change from ");
                        sb.append(d2);
                        sb.append(" to ");
                        sb.append(d());
                    }
                    this.D++;
                    sb = new StringBuilder();
                    sb.append("RTC stat change from ");
                    sb.append(d2);
                    sb.append(" to ");
                    sb.append(d());
                } else {
                    this.E = 0;
                    this.F = 0;
                    if (com.baidu.android.pushservice.i.g.a(this.k)) {
                        int i3 = this.D;
                        if (i3 > 0) {
                            this.D = i3 - 1;
                            e();
                        }
                        sb = new StringBuilder();
                        sb.append("RTC stat change from ");
                        sb.append(d2);
                        sb.append(" to ");
                        sb.append(d());
                    }
                    this.D++;
                    sb = new StringBuilder();
                    sb.append("RTC stat change from ");
                    sb.append(d2);
                    sb.append(" to ");
                    sb.append(d());
                }
            } else {
                this.D = f();
                this.E = 0;
                sb = new StringBuilder();
                sb.append("RTC stat change ");
                sb.append(d());
                sb.append(" because of network changing");
            }
            sb.toString();
            this.G = d;
            f.a(this.k).b(d() * 1000);
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            com.baidu.android.pushservice.f.a.c("PushConnection", "---stop---", this.k.getApplicationContext());
            this.d = true;
            this.g = true;
            this.j.removeCallbacks(this.z);
            h();
            m = null;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.l == null) {
            return;
        }
        if (System.currentTimeMillis() - this.B >= 60000) {
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
                        this.a.l.d();
                        this.a.B = System.currentTimeMillis();
                        com.baidu.android.pushservice.f.a.c("PushConnection", "sendHeartbeatMessage", this.a.k.getApplicationContext());
                    }
                }
            });
        } else {
            com.baidu.android.pushservice.f.a.c("PushConnection", "sendHeartbeatMessage ingnored， because too frequent.", this.k.getApplicationContext());
        }
    }

    public int d() {
        InterceptResult invokeV;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i = this.D;
            if (i >= 0) {
                int[] iArr = this.C;
                if (i >= iArr.length) {
                    length = iArr.length - 1;
                }
                return this.C[this.D];
            }
            length = 0;
            this.D = length;
            return this.C[this.D];
        }
        return invokeV.intValue;
    }

    public void e() {
        Context context;
        int i;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (com.baidu.android.pushservice.i.g.b(this.k)) {
                context = this.k;
                i = this.D;
                str = "com.baidu.pushservice.CUR_PERIOD_WIFI";
            } else {
                context = this.k;
                i = this.D;
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
            if (com.baidu.android.pushservice.i.g.a(this.k)) {
                if (com.baidu.android.pushservice.i.g.b(this.k)) {
                    context = this.k;
                    str = "com.baidu.pushservice.CUR_PERIOD_WIFI";
                } else {
                    context = this.k;
                    str = "com.baidu.pushservice.CUR_PERIOD_MOBILE";
                }
                return com.baidu.android.pushservice.i.i.b(context, str, 0);
            }
            return 0;
        }
        return invokeV.intValue;
    }
}
