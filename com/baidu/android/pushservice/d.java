package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.c;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static Boolean E = null;
    public static volatile d F = null;
    public static int G = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public String D;
    public boolean a;
    public volatile boolean b;
    public boolean c;
    public j d;
    public i e;
    public boolean f;
    public long g;
    public int h;
    public final Handler i;
    public final Context j;
    public com.baidu.android.pushservice.w.d k;
    public boolean l;
    public boolean m;
    public String n;
    public String o;
    public int p;
    public Thread q;
    public List<String> r;
    public boolean s;
    public Socket t;
    public InputStream u;
    public OutputStream v;
    public com.baidu.android.pushservice.z.d w;
    public Runnable x;
    public long y;
    public final int[] z;

    /* loaded from: classes.dex */
    public class a implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ d b;

        public a(d dVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dVar;
            this.a = i;
        }

        @Override // com.baidu.android.pushservice.c.d
        public void a(int i, List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, list) == null) {
                this.b.b = false;
                if (list == null || list.size() <= 0) {
                    this.b.a(10005, this.a);
                    return;
                }
                if (this.b.r.isEmpty()) {
                    this.b.r.addAll(list);
                }
                this.b.b(this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ d b;

        public b(d dVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dVar;
            this.a = i;
        }

        @Override // com.baidu.android.pushservice.c.d
        public void a(int i, List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, list) == null) {
                this.b.b = false;
                if (list == null || list.size() <= 0) {
                    this.b.a(10006, this.a);
                    return;
                }
                if (this.b.r.isEmpty()) {
                    this.b.r.addAll(list);
                }
                this.b.b(this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ d b;

        public c(d dVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dVar;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.b.t = new Socket(this.b.n, this.b.p);
                    this.b.u = this.b.t.getInputStream();
                    this.b.v = this.b.t.getOutputStream();
                    try {
                        this.b.k = new com.baidu.android.pushservice.w.f(this.b.j.getApplicationContext(), this.b.u, this.b.v);
                        this.b.a = true;
                        this.b.g = System.currentTimeMillis();
                        if (this.b.e != null) {
                            this.b.e.interrupt();
                        }
                        if (this.b.d != null) {
                            this.b.d.interrupt();
                        }
                        this.b.c = false;
                        this.b.e = new i(this.b);
                        this.b.e.start();
                        this.b.d = new j(this.b);
                        this.b.d.start();
                        Boolean unused = d.E = Boolean.FALSE;
                        this.b.k.a(this.a);
                        Boolean unused2 = d.E = Boolean.FALSE;
                        this.b.n = com.baidu.android.pushservice.g.e();
                        this.b.r.clear();
                    } catch (Exception unused3) {
                    }
                } catch (Exception unused4) {
                    this.b.a((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT, this.a);
                }
            }
        }
    }

    /* renamed from: com.baidu.android.pushservice.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0026d extends com.baidu.android.pushservice.z.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0026d(d dVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b(a());
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public e(d dVar) {
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
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                com.baidu.android.pushservice.u.a.c("PushConnection", " -- Send Timeout --", this.a.j.getApplicationContext());
                if (this.a.l) {
                    this.a.l = false;
                }
                this.a.a(false);
                this.a.f(10004);
                this.a.c();
                com.baidu.android.pushservice.u.a.a("PushConnection", "PushConnection Send Timeout " + this.a.j.getPackageName() + System.currentTimeMillis(), this.a.j.getApplicationContext());
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends com.baidu.android.pushservice.z.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(d dVar, String str, short s) {
            super(str, s);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, Short.valueOf(s)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dVar;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = ((int) (currentTimeMillis / 1000)) % 60;
                if (((int) ((currentTimeMillis / 60000) % 5)) == 0 && i < 15) {
                    try {
                        Thread.sleep((long) (Math.random() * 60.0d * 1000.0d));
                    } catch (InterruptedException unused) {
                    }
                }
                this.c.k.d();
                this.c.y = System.currentTimeMillis();
                com.baidu.android.pushservice.u.a.c("PushConnection", "sendHeartbeatMessage", this.c.j.getApplicationContext());
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ d b;

        public g(d dVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dVar;
            this.a = i;
        }

        @Override // com.baidu.android.pushservice.c.d
        public void a(int i, List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, list) == null) {
                this.b.o = null;
                Boolean unused = d.E = Boolean.FALSE;
                if (list == null || list.size() <= 0) {
                    this.b.a(10005, this.a);
                    return;
                }
                this.b.r.addAll(list);
                this.b.d(this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ d b;

        public h(d dVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dVar;
            this.a = i;
        }

        @Override // com.baidu.android.pushservice.c.d
        public void a(int i, List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, list) == null) {
                this.b.o = null;
                Boolean unused = d.E = Boolean.FALSE;
                if (list == null || list.size() <= 0) {
                    this.b.a(10006, this.a);
                    return;
                }
                this.b.r.addAll(list);
                this.b.d(this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public i(d dVar) {
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
                while (!this.a.c) {
                    com.baidu.android.pushservice.w.e eVar = null;
                    try {
                        eVar = this.a.k.c();
                    } catch (Exception unused) {
                    }
                    this.a.i.removeCallbacks(this.a.x);
                    if (this.a.l) {
                        this.a.l = false;
                        this.a.a(true);
                    }
                    if (this.a.m) {
                        this.a.m = false;
                    }
                    if (eVar == null || !((eVar.a() != null && eVar.a().length != 0) || eVar.c() == com.baidu.android.pushservice.w.h.h.a() || eVar.c() == com.baidu.android.pushservice.w.h.g.a())) {
                        this.a.f((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT);
                        this.a.c();
                        com.baidu.android.pushservice.u.a.a("PushConnection", "PushConnection Receive err " + this.a.j.getPackageName() + System.currentTimeMillis(), this.a.j.getApplicationContext());
                    } else {
                        try {
                            this.a.k.a(eVar);
                            this.a.h = 0;
                        } catch (Exception unused2) {
                            this.a.c();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class j extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public j(d dVar) {
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
                while (!this.a.c) {
                    com.baidu.android.pushservice.w.e eVar = null;
                    synchronized (this.a.k.a()) {
                        try {
                            if (this.a.k.a().size() == 0) {
                                this.a.k.a().wait();
                            }
                            if (this.a.k.a().size() > 0) {
                                eVar = this.a.k.a().removeFirst();
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if (this.a.c) {
                        return;
                    }
                    if (eVar != null && eVar.a() != null) {
                        if (eVar.e()) {
                            this.a.l = eVar.d();
                            if (com.baidu.android.pushservice.w.h.a(eVar.c()) == com.baidu.android.pushservice.w.h.c) {
                                this.a.m = true;
                            }
                            this.a.i.removeCallbacks(this.a.x);
                            this.a.i.postDelayed(this.a.x, 60000L);
                        }
                        try {
                            this.a.v.write(eVar.a());
                            this.a.v.flush();
                        } catch (Exception unused2) {
                            this.a.c();
                            this.a.f((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT);
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
        E = Boolean.FALSE;
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
        this.a = false;
        this.b = false;
        this.c = false;
        this.f = false;
        this.r = Collections.synchronizedList(new ArrayList());
        this.s = false;
        this.w = new C0026d(this, 0);
        this.x = new e(this);
        this.y = 0L;
        this.z = new int[]{180, 300, 360, HttpStatus.SC_METHOD_FAILURE, 540, 720, 900};
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.j = context;
        this.i = new Handler(context.getMainLooper());
        int d = d();
        if (d >= 0 && d < this.z.length) {
            this.A = d;
        }
        b(context);
        com.baidu.android.pushservice.f.a(this.j).d(this.z[this.A] * 1000);
        this.D = com.baidu.android.pushservice.a0.g.c(this.j);
        this.n = com.baidu.android.pushservice.g.e();
        this.p = com.baidu.android.pushservice.g.c(this.j);
        this.s = com.baidu.android.pushservice.l.d.a(this.j);
    }

    public static d a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (F == null) {
                synchronized (d.class) {
                    if (F == null) {
                        F = new d(context);
                    }
                }
            }
            return F;
        }
        return (d) invokeL.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.t != null) {
                    this.t.close();
                    this.t = null;
                }
                if (this.u != null) {
                    this.u.close();
                    this.u = null;
                }
                if (this.v != null) {
                    this.v.close();
                    this.v = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.h = 0;
            this.f = false;
            c(i2);
        }
    }

    public final void a(int i2, int i3) {
        com.baidu.android.pushservice.c a2;
        c.d hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            f(i2);
            if (this.r.size() > 0) {
                E = Boolean.FALSE;
                d(i3);
                return;
            }
            g();
            this.r.clear();
            int i4 = G;
            if (i4 != 0) {
                int i5 = 1;
                if (i4 == 1) {
                    a2 = com.baidu.android.pushservice.c.a(this.j);
                    hVar = new g(this, i3);
                } else {
                    if (this.s) {
                        i5 = 2;
                        if (i4 == 2) {
                            a2 = com.baidu.android.pushservice.c.a(this.j);
                            hVar = new h(this, i3);
                        }
                    }
                    G = 0;
                }
                a2.a(i5, hVar);
                return;
            }
            this.r.add(com.baidu.android.pushservice.g.e());
            E = Boolean.FALSE;
            d(i3);
        }
    }

    public void a(int i2, String str, byte[] bArr) {
        com.baidu.android.pushservice.w.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048579, this, i2, str, bArr) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.a(i2, str, bArr);
    }

    public void a(boolean z) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            String c2 = com.baidu.android.pushservice.a0.g.c(this.j);
            if (TextUtils.equals(this.D, c2)) {
                int e2 = e();
                if (z) {
                    if (com.baidu.android.pushservice.a0.g.d(this.j)) {
                        h();
                        int i2 = this.B + 1;
                        this.B = i2;
                        if (i2 >= 3) {
                            this.B = 0;
                            int i3 = this.A;
                            if (i3 < this.z.length - 1) {
                                this.B = 0;
                                this.A = i3 + 1;
                            }
                        }
                        if (this.C >= 30) {
                            this.C = 0;
                        }
                        sb = new StringBuilder();
                        sb.append("RTC stat change from ");
                        sb.append(e2);
                        sb.append(" to ");
                        sb.append(e());
                    }
                    this.A++;
                    sb = new StringBuilder();
                    sb.append("RTC stat change from ");
                    sb.append(e2);
                    sb.append(" to ");
                    sb.append(e());
                } else {
                    this.B = 0;
                    this.C = 0;
                    if (com.baidu.android.pushservice.a0.g.d(this.j)) {
                        int i4 = this.A;
                        if (i4 > 0) {
                            this.A = i4 - 1;
                            h();
                        }
                        sb = new StringBuilder();
                        sb.append("RTC stat change from ");
                        sb.append(e2);
                        sb.append(" to ");
                        sb.append(e());
                    }
                    this.A++;
                    sb = new StringBuilder();
                    sb.append("RTC stat change from ");
                    sb.append(e2);
                    sb.append(" to ");
                    sb.append(e());
                }
            } else {
                this.A = d();
                this.B = 0;
                sb = new StringBuilder();
                sb.append("RTC stat change ");
                sb.append(e());
                sb.append(" because of network changing");
            }
            sb.toString();
            this.D = c2;
            com.baidu.android.pushservice.f.a(this.j).d(e() * 1000);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            com.baidu.android.pushservice.u.a.c("PushConnection", "destroy", this.j.getApplicationContext());
            Handler handler = this.i;
            if (handler != null) {
                handler.removeCallbacks(this.x);
            }
            this.c = true;
            this.a = false;
            com.baidu.android.pushservice.w.d dVar = this.k;
            if (dVar != null) {
                try {
                    synchronized (dVar.a()) {
                        this.k.a().notifyAll();
                    }
                } catch (Exception unused) {
                }
            }
            a();
            com.baidu.android.pushservice.w.d dVar2 = this.k;
            if (dVar2 != null) {
                dVar2.b();
            }
        }
    }

    public final synchronized void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            synchronized (this) {
                if (!this.a && !E.booleanValue()) {
                    if (!com.baidu.android.pushservice.j.a(this.j).e()) {
                        com.baidu.android.pushservice.e.w(this.j);
                        return;
                    }
                    if (this.r.size() > 0) {
                        this.n = this.r.remove(0);
                    }
                    E = Boolean.TRUE;
                    c cVar = new c(this, i2);
                    Thread thread = this.q;
                    if (thread != null) {
                        thread.interrupt();
                    }
                    Thread thread2 = new Thread(cVar);
                    this.q = thread2;
                    thread2.setName("PushService-PushService-connect");
                    this.q.start();
                    return;
                }
                com.baidu.android.pushservice.u.a.c("PushConnection", "Connect return. mConnected:" + this.a + " mConnectting:" + E, this.j.getApplicationContext());
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:63:0x0059 */
    /* JADX WARN: Type inference failed for: r3v10, types: [int] */
    /* JADX WARN: Type inference failed for: r3v11, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public final void b(Context context) {
        StringBuilder sb;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, context) == null) && PushSettings.e(context)) {
            File file = new File(Environment.getExternalStorageDirectory(), "baidu/pushservice/pushservice.cfg");
            if (file.exists()) {
                Properties properties = new Properties();
                FileInputStream fileInputStream2 = null;
                ?? r3 = 0;
                FileInputStream fileInputStream3 = null;
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    properties.load(fileInputStream);
                    String property = properties.getProperty("rtcseed");
                    if (property != null && (r3 = property.length()) > 0) {
                        r3 = new JSONArray(property);
                        for (int i2 = 0; i2 < r3.length(); i2++) {
                            this.z[i2] = r3.getInt(i2);
                            this.A = 0;
                            this.B = 0;
                            this.C = 0;
                        }
                    }
                    String property2 = properties.getProperty("originseed");
                    if (property2 != null && property2.length() > 0) {
                        this.A = Integer.parseInt(property2);
                    }
                    try {
                        fileInputStream.close();
                        fileInputStream2 = r3;
                    } catch (IOException e3) {
                        e = e3;
                        sb = new StringBuilder();
                        sb.append("error ");
                        sb.append(e.getMessage());
                        com.baidu.android.pushservice.u.a.b("PushConnection", sb.toString(), this.j.getApplicationContext());
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileInputStream3 = fileInputStream;
                    com.baidu.android.pushservice.u.a.b("PushConnection", "getTestConfig exception " + e.getMessage(), this.j.getApplicationContext());
                    fileInputStream2 = fileInputStream3;
                    if (fileInputStream3 != null) {
                        try {
                            fileInputStream3.close();
                            fileInputStream2 = fileInputStream3;
                        } catch (IOException e5) {
                            e = e5;
                            sb = new StringBuilder();
                            sb.append("error ");
                            sb.append(e.getMessage());
                            com.baidu.android.pushservice.u.a.b("PushConnection", sb.toString(), this.j.getApplicationContext());
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e6) {
                            com.baidu.android.pushservice.u.a.b("PushConnection", "error " + e6.getMessage(), this.j.getApplicationContext());
                        }
                    }
                    throw th;
                }
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d(0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:
        if (r4.r.isEmpty() != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void c(int i2) {
        com.baidu.android.pushservice.c a2;
        c.d bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            synchronized (this) {
                if (!this.a && !E.booleanValue() && !this.b) {
                    int i3 = 1;
                    this.b = true;
                    this.r.clear();
                    int i4 = G;
                    if (i4 == 0) {
                        if (this.r.isEmpty()) {
                            this.r.add(com.baidu.android.pushservice.g.e());
                        }
                        this.b = false;
                        b(i2);
                    } else {
                        if (i4 == 1) {
                            a2 = com.baidu.android.pushservice.c.a(this.j);
                            bVar = new a(this, i2);
                        } else {
                            if (this.s) {
                                i3 = 2;
                                if (i4 == 2) {
                                    a2 = com.baidu.android.pushservice.c.a(this.j);
                                    bVar = new b(this, i2);
                                }
                            }
                            G = 0;
                        }
                        a2.a(i3, bVar);
                    }
                }
            }
        }
    }

    public int d() {
        InterceptResult invokeV;
        Context context;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (com.baidu.android.pushservice.a0.g.d(this.j)) {
                if (com.baidu.android.pushservice.a0.g.e(this.j)) {
                    context = this.j;
                    str = "com.baidu.pushservice.CUR_PERIOD_WIFI";
                } else {
                    context = this.j;
                    str = "com.baidu.pushservice.CUR_PERIOD_MOBILE";
                }
                return com.baidu.android.pushservice.a0.i.a(context, str, 0);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            com.baidu.android.pushservice.u.a.c("PushConnection", "disconnectedByPeer, mStoped == " + this.f, this.j.getApplicationContext());
            b();
            if (this.f) {
                return;
            }
            int i3 = this.h + 1;
            this.h = i3;
            if (i3 <= 5) {
                this.i.removeCallbacks(e(i2));
                int i4 = this.h;
                int i5 = (i4 - 1) * 30 * 1000;
                if (i4 == 1) {
                    i5 = 3000;
                }
                this.i.postDelayed(e(i2), i5);
            }
        }
    }

    public int e() {
        InterceptResult invokeV;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i2 = this.A;
            if (i2 >= 0) {
                int[] iArr = this.z;
                if (i2 >= iArr.length) {
                    length = iArr.length - 1;
                }
                return this.z[this.A];
            }
            length = 0;
            this.A = length;
            return this.z[this.A];
        }
        return invokeV.intValue;
    }

    public final Runnable e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            this.w.a(i2);
            return this.w;
        }
        return (Runnable) invokeI.objValue;
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            if (this.g != 0 || i2 == 0) {
                if (this.g != 0) {
                    if (this.m) {
                        this.m = false;
                        return;
                    } else {
                        this.g = 0L;
                        return;
                    }
                }
                return;
            }
            String str = this.n + "/" + this.o + ":" + this.p + ":" + G;
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            G = (G + 1) % 3;
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || this.k == null) {
            return;
        }
        if (System.currentTimeMillis() - this.y >= 60000 || i2 != 0) {
            com.baidu.android.pushservice.z.e.a().a(new f(this, "heartbeat", (short) 98));
        } else {
            com.baidu.android.pushservice.u.a.c("PushConnection", "sendHeartbeatMessage ingnored， because too frequent.", this.j.getApplicationContext());
        }
    }

    public void h() {
        Context context;
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (com.baidu.android.pushservice.a0.g.e(this.j)) {
                context = this.j;
                i2 = this.A;
                str = "com.baidu.pushservice.CUR_PERIOD_WIFI";
            } else {
                context = this.j;
                i2 = this.A;
                str = "com.baidu.pushservice.CUR_PERIOD_MOBILE";
            }
            com.baidu.android.pushservice.a0.i.b(context, str, i2);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            com.baidu.android.pushservice.u.a.c("PushConnection", "---stop---", this.j.getApplicationContext());
            this.c = true;
            this.f = true;
            this.i.removeCallbacks(this.w);
            b();
            F = null;
        }
    }
}
