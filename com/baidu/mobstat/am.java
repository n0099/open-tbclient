package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.aj;
import com.baidu.mobstat.ak;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.CommandMessage;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import kotlinx.coroutines.DebugKt;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class am {
    public static /* synthetic */ Interceptable $ic;
    public static final am B;
    public transient /* synthetic */ FieldHolder $fh;
    public bf A;
    public Handler C;
    public ak.a D;
    public boolean E;
    public JSONArray F;
    public Object G;

    /* renamed from: a  reason: collision with root package name */
    public Context f40976a;

    /* renamed from: b  reason: collision with root package name */
    public ak f40977b;

    /* renamed from: c  reason: collision with root package name */
    public aj f40978c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f40979d;

    /* renamed from: e  reason: collision with root package name */
    public an f40980e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f40981f;

    /* renamed from: g  reason: collision with root package name */
    public HandlerThread f40982g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f40983h;

    /* renamed from: i  reason: collision with root package name */
    public HandlerThread f40984i;
    public volatile boolean j;
    public volatile boolean k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile boolean n;
    public volatile boolean o;
    public volatile String p;
    public volatile String q;
    public volatile String r;
    public long s;
    public long t;
    public long u;
    public String v;
    public boolean w;
    public String x;
    public JSONObject y;
    public JSONObject z;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ am f40987a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(am amVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {amVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40987a = amVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 21:
                        this.f40987a.l();
                        return;
                    case 22:
                        this.f40987a.m();
                        return;
                    case 23:
                        this.f40987a.n();
                        return;
                    case 24:
                        Bundle data = message.getData();
                        if (data != null) {
                            this.f40987a.b(data.getString("autoconfig.key"));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements aj.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ am f40988a;

        public b(am amVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {amVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40988a = amVar;
        }

        @Override // com.baidu.mobstat.aj.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f40988a.j();
            }
        }

        @Override // com.baidu.mobstat.aj.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f40988a.k();
            }
        }

        @Override // com.baidu.mobstat.aj.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.f40988a.b(z);
            }
        }

        @Override // com.baidu.mobstat.aj.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                Message obtainMessage = this.f40988a.f40981f.obtainMessage(24);
                Bundle bundle = new Bundle();
                bundle.putString("autoconfig.key", str);
                obtainMessage.setData(bundle);
                this.f40988a.f40981f.sendMessage(obtainMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ am f40989a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(am amVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {amVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40989a = amVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 1) {
                    this.f40989a.o();
                } else if (i2 != 2) {
                } else {
                    this.f40989a.s();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581657222, "Lcom/baidu/mobstat/am;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581657222, "Lcom/baidu/mobstat/am;");
                return;
            }
        }
        B = new am();
    }

    public am() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.y = new JSONObject();
        this.z = new JSONObject();
        this.A = bf.a();
        this.C = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.mobstat.am.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ am f40985a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f40985a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    switch (message.what) {
                        case 32:
                            this.f40985a.b();
                            return;
                        case 33:
                            this.f40985a.c();
                            return;
                        case 34:
                            this.f40985a.h();
                            return;
                        default:
                            return;
                    }
                }
            }
        };
        this.D = new ak.a(this) { // from class: com.baidu.mobstat.am.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ am f40986a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f40986a = this;
            }

            @Override // com.baidu.mobstat.ak.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (bd.c().b()) {
                        bd.c().a("onGesture");
                    }
                    this.f40986a.i();
                }
            }
        };
        this.E = true;
        this.F = new JSONArray();
        this.G = new Object();
        this.f40980e = new an();
        HandlerThread handlerThread = new HandlerThread("crawlerThread");
        this.f40984i = handlerThread;
        handlerThread.start();
        this.f40983h = new c(this, this.f40984i.getLooper());
        HandlerThread handlerThread2 = new HandlerThread("downloadThread");
        this.f40982g = handlerThread2;
        handlerThread2.start();
        this.f40981f = new a(this, this.f40982g.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            this.j = true;
            if (p() && this.j) {
                this.C.sendMessage(this.C.obtainMessage(32));
                this.f40983h.sendMessage(this.f40983h.obtainMessage(2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65568, this) == null) || this.k) {
            return;
        }
        boolean a2 = bg.a(this.f40976a, this.v, 0, true);
        this.k = true;
        if (a2) {
            this.p = bo.a(this.f40976a, "mtj_vizParser.js");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65569, this) == null) || this.l) {
            return;
        }
        boolean a2 = bg.a(this.f40976a, this.v, 1, true);
        this.l = true;
        if (a2) {
            this.q = bo.a(this.f40976a, "mtj_autoTracker.js");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65570, this) == null) || this.m) {
            return;
        }
        boolean a2 = bg.a(this.f40976a, this.v, 2, true);
        this.m = true;
        if (a2) {
            this.C.sendMessage(this.C.obtainMessage(34));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            bc.c().a("autotrace: start to connect");
            a(1);
            if (p()) {
                bc.c().a("autotrace: connect established, no need to duplicate connect");
                return;
            }
            String a2 = a(this.f40976a);
            if (bd.c().b()) {
                String str = HttpRetryStatistic.RETRY_URL;
                if (!TextUtils.isEmpty(a2)) {
                    str = HttpRetryStatistic.RETRY_URL + a2;
                }
                bd.c().a(str);
            }
            try {
                this.f40978c = new aj(URI.create(a2), new b());
            } catch (Exception unused) {
            }
        }
    }

    private boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, this)) == null) {
            aj ajVar = this.f40978c;
            return ajVar != null && ajVar.b();
        }
        return invokeV.booleanValue;
    }

    private boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65573, this)) == null) ? !TextUtils.isEmpty(this.v) : invokeV.booleanValue;
    }

    private String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, this)) == null) {
            Activity activity = this.f40979d;
            if (activity != null) {
                return activity.getClass().getName();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65575, this) == null) && p() && this.j) {
            JSONObject a2 = a(this.f40980e.a(this.f40979d));
            if (a2 != null) {
                if (bd.c().b()) {
                    bd c2 = bd.c();
                    c2.a("doSendSnapshot:" + a2.toString());
                }
                try {
                    this.f40978c.a(a2);
                } catch (Exception unused) {
                }
            }
            this.f40983h.sendMessageDelayed(this.f40983h.obtainMessage(2), 2000L);
        }
    }

    private void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65576, this) == null) && bw.s(this.f40976a) && !this.m) {
            if (this.u == 0) {
                this.u = bq.a().p(this.f40976a);
            }
            if (System.currentTimeMillis() - this.u > 86400000) {
                this.f40981f.sendMessage(this.f40981f.obtainMessage(23));
            }
        }
    }

    private void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65577, this) == null) && bw.s(this.f40976a) && !this.l) {
            if (!this.n) {
                this.q = bo.a(this.f40976a, "mtj_autoTracker.js");
                this.n = true;
            }
            if (this.s == 0) {
                this.s = bq.a().n(this.f40976a);
                this.t = bq.a().o(this.f40976a);
            }
            if (!(this.n && TextUtils.isEmpty(this.q)) && System.currentTimeMillis() - this.s <= this.t) {
                return;
            }
            this.f40981f.sendMessage(this.f40981f.obtainMessage(22));
        }
    }

    private void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65578, this) == null) || this.o) {
            return;
        }
        if (TextUtils.isEmpty(this.r)) {
            h();
        }
        this.o = true;
    }

    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
        }
    }

    private void d(Activity activity) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65553, this, activity) == null) || activity == null || (intent = activity.getIntent()) == null) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("Baidu_mtj_push_call", false);
        String stringExtra = intent.getStringExtra("Baidu_mtj_push_msg");
        if (this.E) {
            LaunchInfo launchInfo = new LaunchInfo();
            if (booleanExtra) {
                launchInfo.setPushInfo(bj.e(activity), stringExtra);
            }
            String g2 = bj.g(activity);
            if (!TextUtils.isEmpty(g2)) {
                launchInfo.setRefererPkgName(g2);
            }
            BDStatCore.instance().autoTrackLaunchInfo(this.f40976a, launchInfo, true);
        } else {
            LaunchInfo launchInfo2 = new LaunchInfo();
            if (booleanExtra) {
                launchInfo2.setPushInfo(bj.e(activity), stringExtra);
            }
            String g3 = bj.g(activity);
            if (!TextUtils.isEmpty(g3)) {
                launchInfo2.setRefererPkgName(g3);
            }
            BDStatCore.instance().autoTrackLaunchInfo(this.f40976a, launchInfo2, false);
        }
        this.E = false;
    }

    private void e(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, activity) == null) {
            if (bd.c().b()) {
                bd.c().a("installConnectionTracker");
            }
            ak akVar = new ak(this.D);
            this.f40977b = akVar;
            akVar.a(activity);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            if (bd.c().b()) {
                bd.c().a("uninstallConnectionTracker");
            }
            ak akVar = this.f40977b;
            if (akVar != null) {
                akVar.b();
                this.f40977b = null;
            }
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            if (p() && this.j) {
                b();
            } else {
                c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            this.r = bo.a(this.f40976a, "mtj_auto.config");
            c(this.r);
            av.b(this.r);
            ar.a(this.r);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65563, this) == null) || p()) {
            return;
        }
        bc.c().a("autotrace: gesture success");
        a(0);
        if (!bw.s(this.f40976a)) {
            bc.c().a("autotrace: network invalid, failed to connect to circle server");
            return;
        }
        this.f40983h.sendMessage(this.f40983h.obtainMessage(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65565, this) == null) || this.k) {
            return;
        }
        this.f40981f.sendMessage(this.f40981f.obtainMessage(21));
    }

    public void b(Activity activity) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, activity) == null) && q()) {
            this.f40976a = activity.getApplicationContext();
            if (activity != null && (intent = activity.getIntent()) != null && a(activity, intent)) {
                a().i();
            }
            if (this.f40979d != null) {
                c();
            }
            this.f40979d = activity;
            d(activity);
            v();
            t();
            u();
            b(activity, true);
            e(activity);
            g();
            a(activity, true);
        }
    }

    public void c(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, activity) == null) && q()) {
            this.f40979d = null;
            b(activity, false);
            f();
            a(activity, false);
        }
    }

    public static am a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? B : (am) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.v = str;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.w = z;
        }
    }

    public JSONArray e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            synchronized (this.G) {
                if (this.f40976a == null) {
                    return new JSONArray();
                }
                String a2 = bo.a(this.f40976a, "trace_circle.data");
                JSONArray jSONArray = null;
                try {
                    if (!TextUtils.isEmpty(a2)) {
                        jSONArray = new JSONArray(a2);
                    }
                } catch (Exception unused) {
                }
                if (jSONArray == null) {
                    jSONArray = new JSONArray();
                }
                JSONArray jSONArray2 = new JSONArray();
                this.F = jSONArray2;
                bo.a(this.f40976a, "trace_circle.data", jSONArray2.toString(), false);
                return jSONArray;
            }
        }
        return (JSONArray) invokeV.objValue;
    }

    public boolean a(Activity activity, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, activity, intent)) == null) {
            Uri data = intent.getData();
            if (data != null) {
                String scheme = data.getScheme();
                if (TextUtils.isEmpty(scheme)) {
                    return false;
                }
                try {
                    String queryParameter = data.getQueryParameter("token");
                    String queryParameter2 = data.getQueryParameter("time");
                    if (!scheme.startsWith("mtj") || scheme.length() <= 3) {
                        return false;
                    }
                    String substring = scheme.substring(3);
                    if (TextUtils.isEmpty(substring) || !substring.equals(this.v.toLowerCase()) || TextUtils.isEmpty(queryParameter)) {
                        return false;
                    }
                    this.x = queryParameter;
                    String r = bq.a().r(activity);
                    if (TextUtils.isEmpty(queryParameter2) || queryParameter2.equals(r)) {
                        return false;
                    }
                    bq.a().j(activity, queryParameter2);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void c() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (activity = this.f40979d) == null) {
            return;
        }
        ai.a(activity);
    }

    private void c(WebView webView, String str, bl blVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65550, this, webView, str, blVar) == null) || blVar == null) {
            return;
        }
        blVar.a(this.f40979d, webView, str, a(this.y, r()), true);
    }

    private void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = (JSONObject) jSONObject.get("meta");
            JSONArray jSONArray = (JSONArray) jSONObject.get("data");
            JSONArray jSONArray2 = new JSONArray();
            JSONArray jSONArray3 = new JSONArray();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject3 = (JSONObject) jSONArray.get(i2);
                String str2 = (String) jSONObject3.opt("url");
                if (TextUtils.isEmpty((String) jSONObject3.opt("webLayout")) && TextUtils.isEmpty(str2)) {
                    jSONArray3.put(jSONObject3);
                } else {
                    jSONArray2.put(jSONObject3);
                }
            }
            this.y.put("meta", jSONObject2);
            this.y.put("data", jSONArray2);
            this.z.put("meta", jSONObject2);
            this.z.put("data", jSONArray3);
        } catch (Exception unused) {
        }
    }

    public void b() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (activity = this.f40979d) == null) {
            return;
        }
        ai.b(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65549, this, z) == null) {
            this.j = false;
            an.b();
            this.f40983h.removeMessages(2);
            this.C.sendMessage(this.C.obtainMessage(33));
        }
    }

    public void a(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, activity, z) == null) || (activity instanceof IIgnoreAutoEvent)) {
            return;
        }
        if (z) {
            this.A.a(activity, true, this.z, this.w);
        } else {
            this.A.a(activity, true);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && p()) {
            this.f40978c.a();
        }
    }

    public void a(WebView webView, String str, bl blVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, webView, str, blVar) == null) {
            if (TextUtils.isEmpty(this.p)) {
                this.p = bo.a(this.f40976a, "mtj_vizParser.js");
            }
            b(webView, this.p, blVar);
            if (TextUtils.isEmpty(this.q)) {
                this.q = bo.a(this.f40976a, "mtj_autoTracker.js");
            }
            c(webView, this.q, blVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, this, str) == null) || this.f40976a == null || TextUtils.isEmpty(str)) {
            return;
        }
        bq.a().c(this.f40976a, System.currentTimeMillis());
        bo.a(this.f40976a, "mtj_auto.config", str, false);
        this.C.sendMessage(this.C.obtainMessage(34));
    }

    private String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context)) == null) {
            ArrayList<Pair> arrayList = new ArrayList();
            arrayList.add(new Pair("appKey", "" + this.v));
            arrayList.add(new Pair("appVersion", bw.g(context)));
            arrayList.add(new Pair("appName", bw.h(context)));
            arrayList.add(new Pair("packageName", context.getPackageName()));
            arrayList.add(new Pair(CommandMessage.SDK_VERSION, StatService.getSdkVersion()));
            arrayList.add(new Pair("deviceName", bw.m(context)));
            arrayList.add(new Pair(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android"));
            arrayList.add(new Pair("model", android.os.Build.MODEL));
            arrayList.add(new Pair("cuid", CooperService.instance().getCUID(context, false)));
            arrayList.add(new Pair(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "1"));
            if (!TextUtils.isEmpty(this.x)) {
                arrayList.add(new Pair("token", this.x));
            }
            StringBuilder sb = new StringBuilder();
            for (Pair pair : arrayList) {
                try {
                    String encode = URLEncoder.encode(((String) pair.first).toString(), "UTF-8");
                    String encode2 = URLEncoder.encode(((String) pair.second).toString(), "UTF-8");
                    if (TextUtils.isEmpty(sb.toString())) {
                        sb.append(encode + "=" + encode2);
                    } else {
                        sb.append("&" + encode + "=" + encode2);
                    }
                } catch (Exception unused) {
                }
            }
            String str = "wss://mtjsocket.baidu.com/app?" + sb.toString();
            this.x = null;
            return str;
        }
        return (String) invokeL.objValue;
    }

    private void b(WebView webView, String str, bl blVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65546, this, webView, str, blVar) == null) || blVar == null) {
            return;
        }
        blVar.a(webView, str);
    }

    private void b(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65545, this, activity, z) == null) || (activity instanceof IIgnoreAutoTrace)) {
            return;
        }
        if (z) {
            BDStatCore.instance().onResume(activity, true);
        } else {
            BDStatCore.instance().onPause(activity, true, null);
        }
    }

    private JSONObject a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject == null) {
                return jSONObject2;
            }
            try {
                jSONObject2.put("type", "upload");
                jSONObject2.put("data", jSONObject);
            } catch (Exception unused) {
            }
            return jSONObject2;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005c A[Catch: Exception -> 0x0068, TRY_LEAVE, TryCatch #0 {Exception -> 0x0068, blocks: (B:10:0x0013, B:11:0x002c, B:13:0x0032, B:15:0x0046, B:16:0x0049, B:25:0x005c, B:21:0x0053), top: B:35:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONObject a(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, jSONObject, str)) != null) {
            return (JSONObject) invokeLL.objValue;
        }
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = (JSONObject) jSONObject.get("meta");
            int i2 = jSONObject2.getInt("matchAll");
            JSONArray jSONArray = (JSONArray) jSONObject.get("data");
            JSONArray jSONArray2 = new JSONArray();
            boolean z = false;
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject3 = (JSONObject) jSONArray.get(i3);
                if (str.equals((String) jSONObject3.get("page"))) {
                    jSONArray2.put(jSONObject3);
                }
            }
            if (i2 == 0) {
                if (i2 == 0 && jSONArray2.length() != 0) {
                }
                if (z) {
                    return null;
                }
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put("meta", jSONObject2);
                    jSONObject4.put("data", jSONArray2);
                } catch (Exception unused) {
                }
                return jSONObject4;
            }
            z = true;
            if (z) {
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            a(i2, "");
        }
    }

    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            synchronized (this.G) {
                if (this.f40976a == null) {
                    return;
                }
                if (str == null) {
                    str = "";
                }
                long currentTimeMillis = System.currentTimeMillis();
                boolean s = bw.s(this.f40976a);
                StringBuilder sb = new StringBuilder();
                sb.append(s ? 1 : 0);
                sb.append("|");
                sb.append(str);
                String sb2 = sb.toString();
                this.F.put(i2 + "_" + currentTimeMillis + "_" + sb2);
                bo.a(this.f40976a, "trace_circle.data", this.F.toString(), false);
            }
        }
    }
}
