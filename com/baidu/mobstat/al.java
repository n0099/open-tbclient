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
import com.baidu.mobstat.ai;
import com.baidu.mobstat.aj;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
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
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class al {
    public static /* synthetic */ Interceptable $ic;
    public static final al B;
    public transient /* synthetic */ FieldHolder $fh;
    public be A;
    public Handler C;
    public aj.a D;
    public boolean E;
    public JSONArray F;
    public Object G;
    public Context a;
    public aj b;
    public ai c;
    public Activity d;
    public am e;
    public Handler f;
    public HandlerThread g;
    public Handler h;
    public HandlerThread i;
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

    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ al a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(al alVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, message) != null) {
                return;
            }
            switch (message.what) {
                case 21:
                    this.a.l();
                    return;
                case 22:
                    this.a.m();
                    return;
                case 23:
                    this.a.n();
                    return;
                case 24:
                    Bundle data = message.getData();
                    if (data != null) {
                        this.a.b(data.getString("autoconfig.key"));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ al a;

        public b(al alVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alVar;
        }

        @Override // com.baidu.mobstat.ai.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                Message obtainMessage = this.a.f.obtainMessage(24);
                Bundle bundle = new Bundle();
                bundle.putString("autoconfig.key", str);
                obtainMessage.setData(bundle);
                this.a.f.sendMessage(obtainMessage);
            }
        }

        @Override // com.baidu.mobstat.ai.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.j();
        }

        @Override // com.baidu.mobstat.ai.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
                return;
            }
            this.a.k();
        }

        @Override // com.baidu.mobstat.ai.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) {
                return;
            }
            this.a.b(z);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ al a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(al alVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i != 1) {
                    if (i != 2) {
                        return;
                    }
                    this.a.s();
                    return;
                }
                this.a.o();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581657191, "Lcom/baidu/mobstat/al;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581657191, "Lcom/baidu/mobstat/al;");
                return;
            }
        }
        B = new al();
    }

    public static al a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return B;
        }
        return (al) invokeV.objValue;
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            if (bc.c().b()) {
                bc.c().a("uninstallConnectionTracker");
            }
            aj ajVar = this.b;
            if (ajVar != null) {
                ajVar.b();
                this.b = null;
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
            this.r = bn.a(this.a, af.c);
            c(this.r);
            au.b(this.r);
            aq.a(this.r);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65565, this) == null) && !this.k) {
            this.f.sendMessage(this.f.obtainMessage(21));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65568, this) != null) || this.k) {
            return;
        }
        boolean a2 = bf.a(this.a, this.v, 0, true);
        this.k = true;
        if (a2) {
            this.p = bn.a(this.a, af.a);
        }
    }

    private boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, this)) == null) {
            ai aiVar = this.c;
            if (aiVar != null && aiVar.b()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, this)) == null) {
            if (TextUtils.isEmpty(this.v)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, this)) == null) {
            Activity activity = this.d;
            if (activity != null) {
                return activity.getClass().getName();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    private void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65578, this) == null) && !this.o) {
            if (TextUtils.isEmpty(this.r)) {
                h();
            }
            this.o = true;
        }
    }

    public void b() {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || (activity = this.d) == null) {
            return;
        }
        ah.b(activity);
    }

    public void c() {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || (activity = this.d) == null) {
            return;
        }
        ah.a(activity);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && p()) {
            this.c.a();
        }
    }

    public al() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.y = new JSONObject();
        this.z = new JSONObject();
        this.A = be.a();
        this.C = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.mobstat.al.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ al a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    switch (message.what) {
                        case 32:
                            this.a.b();
                            return;
                        case 33:
                            this.a.c();
                            return;
                        case 34:
                            this.a.h();
                            return;
                        default:
                            return;
                    }
                }
            }
        };
        this.D = new aj.a(this) { // from class: com.baidu.mobstat.al.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ al a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
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

            @Override // com.baidu.mobstat.aj.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (bc.c().b()) {
                        bc.c().a("onGesture");
                    }
                    this.a.i();
                }
            }
        };
        this.E = true;
        this.F = new JSONArray();
        this.G = new Object();
        this.e = new am();
        HandlerThread handlerThread = new HandlerThread("crawlerThread");
        this.i = handlerThread;
        handlerThread.start();
        this.h = new c(this, this.i.getLooper());
        HandlerThread handlerThread2 = new HandlerThread("downloadThread");
        this.g = handlerThread2;
        handlerThread2.start();
        this.f = new a(this, this.g.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            bb.c().a("autotrace: start to connect");
            a(1);
            if (p()) {
                bb.c().a("autotrace: connect established, no need to duplicate connect");
                return;
            }
            String a2 = a(this.a);
            if (bc.c().b()) {
                String str = HttpRetryStatistic.RETRY_URL;
                if (!TextUtils.isEmpty(a2)) {
                    str = HttpRetryStatistic.RETRY_URL + a2;
                }
                bc.c().a(str);
            }
            try {
                this.c = new ai(URI.create(a2), new b());
            } catch (Exception unused) {
            }
        }
    }

    private void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65577, this) != null) || this.l) {
            return;
        }
        if (!this.n) {
            this.q = bn.a(this.a, af.b);
            this.n = true;
        }
        if (this.s == 0) {
            this.s = bp.a().n(this.a);
            this.t = bp.a().o(this.a);
        }
        long j = this.t;
        if ((this.n && TextUtils.isEmpty(this.q)) || System.currentTimeMillis() - this.s > j) {
            this.f.sendMessage(this.f.obtainMessage(22));
        }
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
            arrayList.add(new Pair("deviceName", bw.k(context)));
            arrayList.add(new Pair(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android"));
            arrayList.add(new Pair("model", CooperService.instance().getPhoneModel()));
            CooperService.instance().getCUID(context, false);
            arrayList.add(new Pair("cuid", ""));
            arrayList.add(new Pair("auto", "1"));
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

    private JSONObject a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject == null) {
                return jSONObject2;
            }
            try {
                jSONObject2.put("type", StatConstants.VALUE_TYPE_UPLOAD);
                jSONObject2.put("data", jSONObject);
            } catch (Exception unused) {
            }
            return jSONObject2;
        }
        return (JSONObject) invokeL.objValue;
    }

    private void e(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, activity) == null) {
            if (bc.c().b()) {
                bc.c().a("installConnectionTracker");
            }
            aj ajVar = new aj(this.D);
            this.b = ajVar;
            ajVar.a(activity);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005c A[Catch: Exception -> 0x0068, TRY_LEAVE, TryCatch #0 {Exception -> 0x0068, blocks: (B:10:0x0013, B:11:0x002c, B:13:0x0032, B:15:0x0046, B:16:0x0049, B:25:0x005c, B:21:0x0053), top: B:35:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONObject a(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, jSONObject, str)) == null) {
            if (jSONObject == null || TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject2 = (JSONObject) jSONObject.get("meta");
                int i = jSONObject2.getInt("matchAll");
                JSONArray jSONArray = (JSONArray) jSONObject.get("data");
                JSONArray jSONArray2 = new JSONArray();
                boolean z = false;
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject3 = (JSONObject) jSONArray.get(i2);
                    if (str.equals((String) jSONObject3.get("page"))) {
                        jSONArray2.put(jSONObject3);
                    }
                }
                if (i == 0) {
                    if (i == 0 && jSONArray2.length() != 0) {
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
        } else {
            return (JSONObject) invokeLL.objValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65549, this, z) == null) {
            this.j = false;
            am.b();
            this.h.removeMessages(2);
            this.C.sendMessage(this.C.obtainMessage(33));
        }
    }

    public void c(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, activity) != null) || !q()) {
            return;
        }
        this.d = null;
        b(activity, false);
        f();
        a(activity, false);
    }

    private void b(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65545, this, activity, z) != null) || (activity instanceof IIgnoreAutoTrace) || CooperService.instance().isCloseTrace()) {
            return;
        }
        if (z) {
            BDStatCore.instance().onResume(activity, true);
        } else {
            BDStatCore.instance().onPause(activity, true, null);
        }
    }

    private void b(WebView webView, String str, bk bkVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65546, this, webView, str, bkVar) != null) || bkVar == null) {
            return;
        }
        bkVar.a(webView, str);
    }

    private void c(WebView webView, String str, bk bkVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65550, this, webView, str, bkVar) != null) || bkVar == null) {
            return;
        }
        bkVar.a(this.d, webView, str, a(this.y, r()), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65548, this, str) != null) || this.a == null || TextUtils.isEmpty(str)) {
            return;
        }
        bp.a().c(this.a, System.currentTimeMillis());
        bn.a(this.a, af.c, str, false);
        this.C.sendMessage(this.C.obtainMessage(34));
    }

    private void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65552, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = (JSONObject) jSONObject.get("meta");
            JSONArray jSONArray = (JSONArray) jSONObject.get("data");
            JSONArray jSONArray2 = new JSONArray();
            JSONArray jSONArray3 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject3 = (JSONObject) jSONArray.get(i);
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

    private void d(Activity activity) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65553, this, activity) != null) || activity == null || (intent = activity.getIntent()) == null) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra(MtjConfig.BAIDU_MTJ_PUSH_CALL, false);
        String stringExtra = intent.getStringExtra(MtjConfig.BAIDU_MTJ_PUSH_MSG);
        if (this.E) {
            LaunchInfo launchInfo = new LaunchInfo();
            if (booleanExtra) {
                launchInfo.setPushInfo(bi.e(activity), stringExtra);
            }
            String g = bi.g(activity);
            if (!TextUtils.isEmpty(g)) {
                launchInfo.setRefererPkgName(g);
            }
            BDStatCore.instance().autoTrackLaunchInfo(this.a, launchInfo, true);
        } else {
            LaunchInfo launchInfo2 = new LaunchInfo();
            if (booleanExtra) {
                launchInfo2.setPushInfo(bi.e(activity), stringExtra);
            }
            String g2 = bi.g(activity);
            if (!TextUtils.isEmpty(g2)) {
                launchInfo2.setRefererPkgName(g2);
            }
            BDStatCore.instance().autoTrackLaunchInfo(this.a, launchInfo2, false);
        }
        this.E = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65563, this) != null) || p()) {
            return;
        }
        bb.c().a("autotrace: gesture success");
        a(0);
        if (!bw.q(this.a)) {
            bb.c().a("autotrace: network invalid, failed to connect to circle server");
            return;
        }
        this.h.sendMessage(this.h.obtainMessage(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            this.j = true;
            if (p() && this.j) {
                this.C.sendMessage(this.C.obtainMessage(32));
                this.h.sendMessage(this.h.obtainMessage(2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65569, this) != null) || this.l || !bw.q(this.a)) {
            return;
        }
        boolean a2 = bf.a(this.a, this.v, 1, true);
        this.l = true;
        if (a2) {
            this.q = bn.a(this.a, af.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65570, this) != null) || this.m || !bw.q(this.a)) {
            return;
        }
        boolean a2 = bf.a(this.a, this.v, 2, true);
        this.m = true;
        if (a2) {
            this.C.sendMessage(this.C.obtainMessage(34));
        }
    }

    private void t() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65576, this) != null) || this.m) {
            return;
        }
        if (this.u == 0) {
            this.u = bp.a().p(this.a);
        }
        if (System.currentTimeMillis() - this.u > 86400000) {
            this.f.sendMessage(this.f.obtainMessage(23));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65575, this) == null) && p() && this.j) {
            JSONObject a2 = a(this.e.a(this.d));
            if (a2 != null) {
                if (bc.c().b()) {
                    bc c2 = bc.c();
                    c2.a("doSendSnapshot:" + a2.toString());
                }
                try {
                    this.c.a(a2);
                } catch (Exception unused) {
                }
            }
            this.h.sendMessageDelayed(this.h.obtainMessage(2), 2000L);
        }
    }

    public JSONArray e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            synchronized (this.G) {
                if (this.a == null) {
                    return new JSONArray();
                }
                String a2 = bn.a(this.a, af.d);
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
                bn.a(this.a, af.d, jSONArray2.toString(), false);
                return jSONArray;
            }
        }
        return (JSONArray) invokeV.objValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            a(i, "");
        }
    }

    public void a(int i, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            synchronized (this.G) {
                if (this.a == null) {
                    return;
                }
                if (str == null) {
                    str = "";
                }
                long currentTimeMillis = System.currentTimeMillis();
                boolean q = bw.q(this.a);
                StringBuilder sb = new StringBuilder();
                if (q) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                sb.append(i2);
                sb.append("|");
                sb.append(str);
                String sb2 = sb.toString();
                this.F.put(i + "_" + currentTimeMillis + "_" + sb2);
                bn.a(this.a, af.d, this.F.toString(), false);
            }
        }
    }

    public void a(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048579, this, activity, z) != null) || (activity instanceof IIgnoreAutoEvent)) {
            return;
        }
        if (z) {
            this.A.a(activity, true, this.z, this.w);
        } else {
            this.A.a(activity, true);
        }
    }

    public void a(WebView webView, String str, bk bkVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, webView, str, bkVar) == null) {
            if (TextUtils.isEmpty(this.p)) {
                this.p = bn.a(this.a, af.a);
            }
            b(webView, this.p, bkVar);
            if (TextUtils.isEmpty(this.q)) {
                this.q = bn.a(this.a, af.b);
            }
            c(webView, this.q, bkVar);
        }
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

    public boolean a(Activity activity, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, activity, intent)) == null) {
            Uri data = intent.getData();
            if (data == null) {
                return false;
            }
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
                String s = bp.a().s(activity);
                if (TextUtils.isEmpty(queryParameter2) || queryParameter2.equals(s)) {
                    return false;
                }
                bp.a().k(activity, queryParameter2);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public void b(Activity activity) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, activity) != null) || !q()) {
            return;
        }
        this.a = activity.getApplicationContext();
        if (activity != null && (intent = activity.getIntent()) != null && a(activity, intent)) {
            a().i();
        }
        if (this.d != null) {
            c();
        }
        this.d = activity;
        if (bu.a().e()) {
            d(activity);
        }
        v();
        t();
        u();
        b(activity, true);
        e(activity);
        g();
        a(activity, true);
    }
}
