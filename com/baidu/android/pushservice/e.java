package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.c;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes4.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static Boolean f37073c = null;
    public static volatile e n = null;
    public static int w = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] A;
    public int B;
    public int C;
    public int D;
    public String E;

    /* renamed from: a  reason: collision with root package name */
    public volatile int f37074a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37075b;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f37076d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37077e;

    /* renamed from: f  reason: collision with root package name */
    public b f37078f;

    /* renamed from: g  reason: collision with root package name */
    public a f37079g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f37080h;

    /* renamed from: i  reason: collision with root package name */
    public long f37081i;

    /* renamed from: j  reason: collision with root package name */
    public int f37082j;
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
    public Runnable x;
    public Runnable y;
    public long z;

    /* loaded from: classes4.dex */
    public class a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f37094a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37094a = eVar;
            setName("PushService-PushConnection-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            byte[] bArr;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.f37094a.f37077e) {
                    try {
                        bArr = PushSocket.a(this.f37094a.l, this.f37094a.f37074a);
                    } catch (Exception e2) {
                        com.baidu.android.pushservice.g.a.b("PushConnection", "Get message exception", this.f37094a.l.getApplicationContext());
                        new b.c(this.f37094a.l).a(Log.getStackTraceString(e2)).a();
                        bArr = null;
                    }
                    this.f37094a.k.removeCallbacks(this.f37094a.y);
                    if (this.f37094a.o) {
                        this.f37094a.o = false;
                        this.f37094a.a(true);
                    }
                    if (this.f37094a.p) {
                        this.f37094a.p = false;
                    }
                    int lastSocketError = PushSocket.getLastSocketError();
                    if (bArr == null || bArr.length == 0) {
                        this.f37094a.a(lastSocketError);
                        this.f37094a.j();
                        str = "PushConnection Receive err " + this.f37094a.l.getPackageName() + " lastSocketError " + lastSocketError + " socketfd " + this.f37094a.f37074a + System.currentTimeMillis();
                    } else {
                        try {
                            com.baidu.android.pushservice.message.e a2 = this.f37094a.m.a(bArr);
                            if (a2 != null) {
                                try {
                                    this.f37094a.m.b(a2);
                                } catch (Exception e3) {
                                    com.baidu.android.pushservice.g.a.b("PushConnection", "Handle message exception " + m.a(e3), this.f37094a.l.getApplicationContext());
                                    m.a("PushConnection Handle message exception " + this.f37094a.l.getPackageName() + m.a(e3) + " lastSocketError " + lastSocketError + " socketfd " + this.f37094a.f37074a + System.currentTimeMillis(), this.f37094a.l.getApplicationContext());
                                    new b.c(this.f37094a.l).a(Log.getStackTraceString(e3)).a();
                                    this.f37094a.j();
                                }
                            }
                            this.f37094a.f37082j = 0;
                        } catch (Exception e4) {
                            com.baidu.android.pushservice.g.a.c("PushConnection", "Read message exception " + m.a(e4), this.f37094a.l.getApplicationContext());
                            new b.c(this.f37094a.l).a(Log.getStackTraceString(e4)).a();
                            this.f37094a.a(lastSocketError);
                            this.f37094a.j();
                            str = "PushConnection Read message exception " + this.f37094a.l.getPackageName() + m.a(e4) + " lastSocketError " + lastSocketError + " socketfd " + this.f37094a.f37074a + System.currentTimeMillis();
                        }
                    }
                    m.a(str, this.f37094a.l.getApplicationContext());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f37098a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37098a = eVar;
            setName("PushService-PushConnection-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            com.baidu.android.pushservice.message.e removeFirst;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.f37098a.f37077e) {
                    synchronized (this.f37098a.m.a()) {
                        if (this.f37098a.m.a().size() == 0) {
                            try {
                                this.f37098a.m.a().wait();
                            } catch (InterruptedException e2) {
                                new b.c(this.f37098a.l).a(Log.getStackTraceString(e2)).a();
                            }
                        }
                        removeFirst = this.f37098a.m.a().size() > 0 ? this.f37098a.m.a().removeFirst() : null;
                    }
                    if (this.f37098a.f37077e) {
                        return;
                    }
                    if (removeFirst != null && removeFirst.b() != null) {
                        if (removeFirst.c()) {
                            this.f37098a.o = removeFirst.d();
                            if (com.baidu.android.pushservice.message.h.a(removeFirst.a()) == com.baidu.android.pushservice.message.h.f37595b) {
                                this.f37098a.p = true;
                            }
                            this.f37098a.k.removeCallbacks(this.f37098a.y);
                            this.f37098a.k.postDelayed(this.f37098a.y, 60000L);
                        }
                        try {
                            i2 = PushSocket.a(this.f37098a.f37074a, removeFirst.b(), removeFirst.b().length);
                        } catch (Exception e3) {
                            new b.c(this.f37098a.l).a(Log.getStackTraceString(e3)).a();
                            i2 = -1;
                        }
                        if (i2 == -1) {
                            int lastSocketError = PushSocket.getLastSocketError();
                            this.f37098a.a(lastSocketError);
                            this.f37098a.j();
                            m.a("PushConnection sendMsg err " + this.f37098a.l.getPackageName() + " lastSocketError " + lastSocketError + " socketfd " + this.f37098a.f37074a + System.currentTimeMillis(), this.f37098a.l.getApplicationContext());
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-840927016, "Lcom/baidu/android/pushservice/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-840927016, "Lcom/baidu/android/pushservice/e;");
                return;
            }
        }
        f37073c = Boolean.FALSE;
    }

    public e(Context context) {
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
        this.f37074a = -1;
        this.f37075b = false;
        this.f37076d = false;
        this.f37077e = false;
        this.f37080h = false;
        this.u = Collections.synchronizedList(new ArrayList());
        this.v = false;
        this.x = new Runnable(this) { // from class: com.baidu.android.pushservice.e.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f37087a;

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
                this.f37087a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f37087a.i();
                }
            }
        };
        this.y = new Runnable(this) { // from class: com.baidu.android.pushservice.e.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f37088a;

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
                this.f37088a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.baidu.android.pushservice.g.a.c("PushConnection", " -- Send Timeout --", this.f37088a.l.getApplicationContext());
                    if (this.f37088a.o) {
                        this.f37088a.o = false;
                    }
                    this.f37088a.a(false);
                    this.f37088a.a(10004);
                    this.f37088a.j();
                    m.a("PushConnection Send Timeout " + this.f37088a.l.getPackageName() + " lastSocketError " + PushSocket.getLastSocketError() + " socketfd " + this.f37088a.f37074a + System.currentTimeMillis(), this.f37088a.l.getApplicationContext());
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
        int g2 = g();
        if (g2 >= 0 && g2 < this.A.length) {
            this.B = g2;
        }
        b(context);
        g.a(this.l).a(this.A[this.B] * 1000);
        this.E = com.baidu.android.pushservice.j.g.i(this.l);
        this.q = h.d();
        this.s = h.a(this.l);
        this.v = false;
    }

    public static e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (n == null) {
                synchronized (e.class) {
                    if (n == null) {
                        n = new e(context);
                    }
                }
            }
            return n;
        }
        return (e) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65546, this, i2) == null) {
            if (this.f37081i != 0 || i2 == 0) {
                if (this.f37081i != 0) {
                    if (this.p) {
                        new b.C1603b(this.l).b(System.currentTimeMillis()).a(i2 + "").d(401102L).a();
                        this.p = false;
                        return;
                    }
                    new b.C1603b(this.l).a(true).a(this.f37081i).b(System.currentTimeMillis()).a(i2 + "").c(this.f37082j).d(401101L).a();
                    this.f37081i = 0L;
                    return;
                }
                return;
            }
            new b.C1603b(this.l).a(System.currentTimeMillis()).a(i2 + "").b(this.q + "/" + this.r + ":" + this.s + ":" + w + ":" + com.baidu.android.pushservice.j.g.h(this.l)).d(401100L).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        c a2;
        c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65552, this, i2) == null) {
            if (this.f37074a == -1 && i2 == 110) {
                this.s = 80;
            }
            a(i2);
            if (this.u.size() > 0) {
                f37073c = Boolean.FALSE;
                j();
                return;
            }
            l();
            this.u.clear();
            int i3 = w;
            if (i3 != 0) {
                int i4 = 1;
                if (i3 == 1) {
                    a2 = c.a(this.l);
                    aVar = new c.a(this) { // from class: com.baidu.android.pushservice.e.7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ e f37090a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i5 = newInitContext.flag;
                                if ((i5 & 1) != 0) {
                                    int i6 = i5 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f37090a = this;
                        }

                        @Override // com.baidu.android.pushservice.c.a
                        public void a(int i5, List<String> list) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i5, list) == null) {
                                this.f37090a.r = null;
                                Boolean unused = e.f37073c = Boolean.FALSE;
                                if (list == null || list.size() <= 0) {
                                    this.f37090a.b(10005);
                                    return;
                                }
                                this.f37090a.u.addAll(list);
                                this.f37090a.j();
                            }
                        }
                    };
                } else {
                    if (this.v) {
                        i4 = 2;
                        if (i3 == 2) {
                            a2 = c.a(this.l);
                            aVar = new c.a(this) { // from class: com.baidu.android.pushservice.e.8
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ e f37091a;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i5 = newInitContext.flag;
                                        if ((i5 & 1) != 0) {
                                            int i6 = i5 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f37091a = this;
                                }

                                @Override // com.baidu.android.pushservice.c.a
                                public void a(int i5, List<String> list) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i5, list) == null) {
                                        this.f37091a.r = null;
                                        Boolean unused = e.f37073c = Boolean.FALSE;
                                        if (list == null || list.size() <= 0) {
                                            this.f37091a.b(10006);
                                            return;
                                        }
                                        this.f37091a.u.addAll(list);
                                        this.f37091a.j();
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
            this.u.add(h.d());
            f37073c = Boolean.FALSE;
            j();
        }
    }

    private void b(Context context) {
        b.c cVar;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65553, this, context) == null) && PushSettings.f(context)) {
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
                        com.baidu.android.pushservice.g.a.b("PushConnection", "error " + e.getMessage(), this.l.getApplicationContext());
                        cVar = new b.c(this.l);
                        cVar.a(Log.getStackTraceString(e)).a();
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileInputStream2 = fileInputStream;
                    com.baidu.android.pushservice.g.a.b("PushConnection", "getTestConfig exception " + e.getMessage(), this.l.getApplicationContext());
                    new b.c(this.l).a(Log.getStackTraceString(e)).a();
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e5) {
                            e = e5;
                            com.baidu.android.pushservice.g.a.b("PushConnection", "error " + e.getMessage(), this.l.getApplicationContext());
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
                            com.baidu.android.pushservice.g.a.b("PushConnection", "error " + e6.getMessage(), this.l.getApplicationContext());
                            new b.c(this.l).a(Log.getStackTraceString(e6)).a();
                        }
                    }
                    throw th;
                }
            }
        }
    }

    private synchronized void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            synchronized (this) {
                if (!this.f37075b && !f37073c.booleanValue() && !this.f37076d) {
                    this.f37076d = true;
                    this.u.clear();
                    if (w != 0) {
                        if (w == 1) {
                            c.a(this.l).a(1, new c.a(this) { // from class: com.baidu.android.pushservice.e.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ e f37083a;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f37083a = this;
                                }

                                @Override // com.baidu.android.pushservice.c.a
                                public void a(int i2, List<String> list) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, list) == null) {
                                        this.f37083a.f37076d = false;
                                        if (list == null || list.size() <= 0) {
                                            this.f37083a.b(10005);
                                            return;
                                        }
                                        if (this.f37083a.u.isEmpty()) {
                                            this.f37083a.u.addAll(list);
                                        }
                                        this.f37083a.i();
                                    }
                                }
                            });
                        } else if (this.v && w == 2) {
                            c.a(this.l).a(2, new c.a(this) { // from class: com.baidu.android.pushservice.e.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ e f37084a;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f37084a = this;
                                }

                                @Override // com.baidu.android.pushservice.c.a
                                public void a(int i2, List<String> list) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, list) == null) {
                                        this.f37084a.f37076d = false;
                                        if (list == null || list.size() <= 0) {
                                            this.f37084a.b(10006);
                                            return;
                                        }
                                        if (this.f37084a.u.isEmpty()) {
                                            this.f37084a.u.addAll(list);
                                        }
                                        this.f37084a.i();
                                    }
                                }
                            });
                        } else {
                            w = 0;
                            if (this.u.isEmpty()) {
                                this.u.add(h.d());
                            }
                            this.f37076d = false;
                        }
                    }
                    if (this.u.isEmpty()) {
                        this.u.add(h.d());
                    }
                    this.f37076d = false;
                    i();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            synchronized (this) {
                if (!this.f37075b && !f37073c.booleanValue()) {
                    if (!k.a(this.l).e()) {
                        f.h(this.l);
                        return;
                    }
                    m.a("PushConnection connectImpl from " + this.l.getPackageName() + " at Time " + System.currentTimeMillis(), this.l);
                    if (this.u.size() > 0) {
                        this.q = this.u.remove(0);
                    }
                    f37073c = Boolean.TRUE;
                    this.f37074a = -1;
                    Runnable runnable = new Runnable(this) { // from class: com.baidu.android.pushservice.e.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ e f37085a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f37085a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    PushSocket.createSocket(this.f37085a.q, this.f37085a.s, new PushSocket.OnCreateSocketListener(this) { // from class: com.baidu.android.pushservice.e.3.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass3 f37086a;

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
                                            this.f37086a = this;
                                        }

                                        @Override // com.baidu.android.pushservice.jni.PushSocket.OnCreateSocketListener
                                        public void onConnect(int i2) {
                                            int i3;
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeI(1048576, this, i2) == null) {
                                                this.f37086a.f37085a.f37074a = i2;
                                                this.f37086a.f37085a.r = PushSocket.getLastSocketIP();
                                                try {
                                                    i3 = PushSocket.getLastSocketError();
                                                } catch (Exception unused) {
                                                    i3 = 0;
                                                }
                                                if (this.f37086a.f37085a.f37074a <= -1 || (i3 >= 101 && i3 != 115)) {
                                                    this.f37086a.f37085a.b(i3);
                                                    return;
                                                }
                                                e eVar = this.f37086a.f37085a;
                                                eVar.m = new com.baidu.android.pushservice.message.f(eVar.l.getApplicationContext());
                                                this.f37086a.f37085a.f37075b = true;
                                                this.f37086a.f37085a.f37081i = System.currentTimeMillis();
                                                if (this.f37086a.f37085a.f37079g != null) {
                                                    this.f37086a.f37085a.f37079g.interrupt();
                                                }
                                                if (this.f37086a.f37085a.f37078f != null) {
                                                    this.f37086a.f37085a.f37078f.interrupt();
                                                }
                                                this.f37086a.f37085a.f37077e = false;
                                                this.f37086a.f37085a.f37079g = new a(this.f37086a.f37085a);
                                                this.f37086a.f37085a.f37079g.start();
                                                this.f37086a.f37085a.f37078f = new b(this.f37086a.f37085a);
                                                this.f37086a.f37085a.f37078f.start();
                                                this.f37086a.f37085a.m.b();
                                                Boolean unused2 = e.f37073c = Boolean.FALSE;
                                                this.f37086a.f37085a.q = h.d();
                                                this.f37086a.f37085a.u.clear();
                                            }
                                        }
                                    });
                                } catch (Exception e2) {
                                    new b.c(this.f37085a.l).a(Log.getStackTraceString(e2)).a();
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
                com.baidu.android.pushservice.g.a.c("PushConnection", "Connect return. mConnected:" + this.f37075b + " mConnectting:" + f37073c, this.l.getApplicationContext());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            com.baidu.android.pushservice.g.a.c("PushConnection", "disconnectedByPeer, mStoped == " + this.f37080h, this.l.getApplicationContext());
            m.a("PushConnection destroy from " + this.l.getPackageName() + " at Time " + System.currentTimeMillis(), this.l);
            k();
            if (this.f37080h) {
                return;
            }
            this.f37082j++;
            if (com.baidu.android.pushservice.b.d.g()) {
                this.k.removeCallbacks(this.x);
                this.k.postDelayed(this.x, 30000);
                com.baidu.android.pushservice.g.a.c("PushConnection", "PeakTime retry-- retry times: " + this.f37082j + " time delay: 30000", this.l.getApplicationContext());
            } else if (this.f37082j <= 5) {
                this.k.removeCallbacks(this.x);
                int i2 = this.f37082j;
                int i3 = (i2 - 1) * 30 * 1000;
                if (i2 == 1) {
                    i3 = 3000;
                }
                this.k.postDelayed(this.x, i3);
            }
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            com.baidu.android.pushservice.g.a.c("PushConnection", "destroy", this.l.getApplicationContext());
            Handler handler = this.k;
            if (handler != null) {
                handler.removeCallbacks(this.y);
            }
            this.f37077e = true;
            this.f37075b = false;
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
            PushSocket.a(this.f37074a);
            this.f37074a = -1;
            com.baidu.android.pushservice.message.d dVar2 = this.m;
            if (dVar2 != null) {
                dVar2.c();
            }
        }
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            w = (w + 1) % 3;
        }
    }

    public void a(int i2, String str, byte[] bArr) {
        com.baidu.android.pushservice.message.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048576, this, i2, str, bArr) == null) || (dVar = this.m) == null) {
            return;
        }
        dVar.a(i2, str, bArr);
    }

    public void a(boolean z) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            String i2 = com.baidu.android.pushservice.j.g.i(this.l);
            if (TextUtils.equals(this.E, i2)) {
                int e2 = e();
                if (z) {
                    if (com.baidu.android.pushservice.j.g.a(this.l)) {
                        f();
                        int i3 = this.C + 1;
                        this.C = i3;
                        if (i3 >= 3) {
                            this.C = 0;
                            int i4 = this.B;
                            if (i4 < this.A.length - 1) {
                                this.C = 0;
                                this.B = i4 + 1;
                            }
                        }
                        if (this.D >= 30) {
                            this.D = 0;
                        }
                        sb = new StringBuilder();
                        sb.append("RTC stat change from ");
                        sb.append(e2);
                        sb.append(" to ");
                        sb.append(e());
                    }
                    this.B++;
                    sb = new StringBuilder();
                    sb.append("RTC stat change from ");
                    sb.append(e2);
                    sb.append(" to ");
                    sb.append(e());
                } else {
                    this.C = 0;
                    this.D = 0;
                    if (com.baidu.android.pushservice.j.g.a(this.l)) {
                        int i5 = this.B;
                        if (i5 > 0) {
                            this.B = i5 - 1;
                            f();
                        }
                        sb = new StringBuilder();
                        sb.append("RTC stat change from ");
                        sb.append(e2);
                        sb.append(" to ");
                        sb.append(e());
                    }
                    this.B++;
                    sb = new StringBuilder();
                    sb.append("RTC stat change from ");
                    sb.append(e2);
                    sb.append(" to ");
                    sb.append(e());
                }
            } else {
                this.B = g();
                this.C = 0;
                sb = new StringBuilder();
                sb.append("RTC stat change ");
                sb.append(e());
                sb.append(" because of network changing");
            }
            m.a(sb.toString(), this.l);
            this.E = i2;
            g.a(this.l).a(e() * 1000);
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37075b : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f37082j = 0;
            this.f37080h = false;
            h();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            com.baidu.android.pushservice.g.a.c("PushConnection", "---stop---", this.l.getApplicationContext());
            m.a("PushConnection stop from " + this.l.getPackageName() + " at Time " + System.currentTimeMillis(), this.l);
            this.f37077e = true;
            this.f37080h = true;
            this.k.removeCallbacks(this.x);
            k();
            n = null;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.m == null) {
            return;
        }
        if (System.currentTimeMillis() - this.z >= 60000) {
            com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c(this, "heartbeat", (short) 98) { // from class: com.baidu.android.pushservice.e.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f37089a;

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
                    this.f37089a = this;
                }

                @Override // com.baidu.android.pushservice.h.c
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
                        this.f37089a.m.d();
                        this.f37089a.z = System.currentTimeMillis();
                        com.baidu.android.pushservice.g.a.c("PushConnection", "sendHeartbeatMessage", this.f37089a.l.getApplicationContext());
                    }
                }
            });
        } else {
            com.baidu.android.pushservice.g.a.c("PushConnection", "sendHeartbeatMessage ingnored， because too frequent.", this.l.getApplicationContext());
        }
    }

    public int e() {
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

    public void f() {
        Context context;
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (com.baidu.android.pushservice.j.g.b(this.l)) {
                context = this.l;
                i2 = this.B;
                str = "com.baidu.pushservice.CUR_PERIOD_WIFI";
            } else {
                context = this.l;
                i2 = this.B;
                str = "com.baidu.pushservice.CUR_PERIOD_MOBILE";
            }
            com.baidu.android.pushservice.j.i.a(context, str, i2);
        }
    }

    public int g() {
        InterceptResult invokeV;
        Context context;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (com.baidu.android.pushservice.j.g.a(this.l)) {
                if (com.baidu.android.pushservice.j.g.b(this.l)) {
                    context = this.l;
                    str = "com.baidu.pushservice.CUR_PERIOD_WIFI";
                } else {
                    context = this.l;
                    str = "com.baidu.pushservice.CUR_PERIOD_MOBILE";
                }
                return com.baidu.android.pushservice.j.i.b(context, str, 0);
            }
            return 0;
        }
        return invokeV.intValue;
    }
}
