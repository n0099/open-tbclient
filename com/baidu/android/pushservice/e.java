package com.baidu.android.pushservice;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.pushservice.a0.l;
import com.baidu.android.pushservice.a0.m;
import com.baidu.android.pushservice.frequency.UploadDataListener;
import com.baidu.android.pushservice.httpapi.TokenBindListener;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.l.d;
import com.baidu.android.pushservice.pull.ClientEventInfo;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.fva;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.push.HmsMessaging;
import com.kuaishou.weapon.p0.u;
import com.tencent.connect.common.Constants;
import com.vivo.push.PushClient;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = -1;
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    public static final ConcurrentLinkedQueue<Runnable> i;
    public static int j;
    public static ConnectivityManager.NetworkCallback k;
    public static Handler l;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends com.baidu.android.pushservice.z.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context c;

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = context;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.h(this.c);
                try {
                    str = HmsInstanceId.getInstance(this.c).getToken(fva.c(this.c).a("client/app_id"), HmsMessaging.DEFAULT_TOKEN_SCOPE);
                } catch (Throwable unused) {
                    PushSettings.h = 1;
                    com.baidu.android.pushservice.a0.i.b(this.c, "com.baidu.android.pushservice.PushSettings.hw_hms_down_mode", 1);
                    Utility.W(this.c);
                    str = "";
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                e.a(this.c, str, 5);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements d.InterfaceC0025d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;

        public b(int i, Context context, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), context, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = context;
            this.c = str;
            this.d = z;
        }

        @Override // com.baidu.android.pushservice.l.d.InterfaceC0025d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a == 0) {
                    com.baidu.android.pushservice.a0.i.b(this.b, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
                    com.baidu.android.pushservice.a0.i.b(this.b, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE", this.c);
                }
                int unused = e.j = 0;
                com.baidu.android.pushservice.i.g = false;
                e.b(this.b, this.d, this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends com.baidu.android.pushservice.z.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ TokenBindListener e;

        public c(Context context, String str, TokenBindListener tokenBindListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, tokenBindListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = context;
            this.d = str;
            this.e = tokenBindListener;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            TokenBindListener tokenBindListener;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.u(this.c);
                if (!Utility.b(this.c) && !TextUtils.isEmpty(this.d) && (tokenBindListener = this.e) != null) {
                    tokenBindListener.onResult(0, "sdk_bind");
                }
                e.c(this.c, 0, this.d);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d extends ConnectivityManager.NetworkCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public d(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, network) == null) {
                super.onAvailable(network);
                e.A(this.a);
            }
        }
    }

    /* renamed from: com.baidu.android.pushservice.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0024e extends com.baidu.android.pushservice.z.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context c;

        public C0024e(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = context;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && e.f(this.c)) {
                m.a(this.c);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Context b;

        public f(String str, Context context) {
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
                try {
                    Intent intent = new Intent();
                    intent.setPackage(this.a);
                    intent.setClassName(this.a, "com.baidu.android.pushservice.PushService");
                    intent.putExtra("source", this.b.getPackageName());
                    this.b.startService(intent);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class g implements d.InterfaceC0025d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ClientEventInfo d;

        public g(Context context, int i, String str, ClientEventInfo clientEventInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Integer.valueOf(i), str, clientEventInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = i;
            this.c = str;
            this.d = clientEventInfo;
        }

        @Override // com.baidu.android.pushservice.l.d.InterfaceC0025d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (Utility.I(this.a) && this.b == 0) {
                    com.baidu.android.pushservice.a0.i.b(this.a, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
                    com.baidu.android.pushservice.a0.i.b(this.a, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE", this.c);
                }
                if (Utility.T(this.a) || Utility.J(this.a) || Utility.I(this.a)) {
                    com.baidu.android.pushservice.i.g = false;
                    int unused = e.j = 0;
                    e.b(this.a, true, this.b);
                }
                m.b(this.a.getApplicationContext(), null, this.d);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class h extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Context context) {
            super(context.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
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
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || message.what != 65553 || e.l == null || e.i == null || e.i.isEmpty()) {
                return;
            }
            e.l.removeCallbacks((i) e.i.poll());
        }
    }

    /* loaded from: classes.dex */
    public static class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        public i(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
            if (r0 > 172800000) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0059, code lost:
            if (r0 > 86400000) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
            r2 = "";
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0022, code lost:
            if (r0 > com.baidu.tbadk.core.util.StorageFile.MAX_BUBBULE_CACHE_TIME) goto L17;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis() - com.baidu.android.pushservice.a0.j.d(this.a);
                String str = com.baidu.android.pushservice.l.d.B(this.a) ? com.baidu.android.pushservice.a0.j.e(this.a) : (com.baidu.android.pushservice.l.d.m(this.a) || com.baidu.android.pushservice.l.d.t(this.a)) ? com.baidu.android.pushservice.a0.j.b(this.a) : com.baidu.android.pushservice.l.d.n(this.a) ? com.baidu.android.pushservice.a0.j.c(this.a) : null;
                if (!TextUtils.isEmpty(str)) {
                    e.a(this.a, str);
                    return;
                }
                if (!e.i.isEmpty()) {
                    e.i.poll();
                }
                e.z(this.a);
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
        i = new ConcurrentLinkedQueue<>();
        j = 0;
    }

    public static void A(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, context) == null) || context == null) {
            return;
        }
        com.baidu.android.pushservice.z.e.a().a(new C0024e(context));
    }

    @TargetApi(24)
    public static void B(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, context) == null) || k == null) {
            return;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                connectivityManager.unregisterNetworkCallback(k);
                k = null;
            }
        } catch (SecurityException unused) {
        }
    }

    public static void C(Context context) {
        Intent i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, context) == null) || (i2 = i(context)) == null) {
            return;
        }
        i2.putExtra("method", "method_unbind");
        a(context, i2);
        Utility.c(context, false);
    }

    public static boolean D(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? System.currentTimeMillis() - com.baidu.android.pushservice.a0.i.b(context, "key_widget_push_source_set_time") < 259200000 : invokeL.booleanValue;
    }

    public static Intent a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, context, z)) == null) {
            Intent intent = new Intent("com.baidu.android.pushservice.action.receiver.CHANGE_ALARM");
            intent.setFlags(32);
            intent.putExtra("com.baidu.android.pushservice.action.receiver.ALARM_IS_BACK", z);
            intent.setClass(context, PushServiceReceiver.class);
            return intent;
        }
        return (Intent) invokeLZ.objValue;
    }

    public static void a(Context context, int i2) {
        Intent b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65545, null, context, i2) == null) || (b2 = b(context, i2)) == null) {
            return;
        }
        d(context, b2);
        com.baidu.android.pushservice.u.a.a("PushManagerHandler", "Bind by selfEventHandler", context);
    }

    public static void a(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65546, null, context, i2, str) == null) {
            String str2 = "errorCode:" + i2 + ",errorMsg:" + str;
            com.baidu.android.pushservice.u.a.b("PushManagerHandler", str2, context.getApplicationContext());
            Utility.c(context, false);
            Intent intent = new Intent();
            intent.putExtra("method", "method_bind");
            intent.putExtra(GameCodeGetResponseMsg.PARAM_ERROR_MSG, i2);
            intent.putExtra("content", str2.getBytes());
            intent.putExtra("bind_status", 0);
            Utility.c(context, intent, "com.baidu.android.pushservice.action.RECEIVE", context.getPackageName());
        }
    }

    public static void a(Context context, int i2, String str, ClientEventInfo clientEventInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65547, null, context, i2, str, clientEventInfo) == null) {
            com.baidu.android.pushservice.l.d.i(context.getApplicationContext()).a(str, new g(context, i2, str, clientEventInfo));
        }
    }

    public static void a(Context context, int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{context, Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            com.baidu.android.pushservice.l.d.i(context.getApplicationContext()).a(str, new b(i2, context, str, z));
        }
    }

    public static void a(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, context, intent) == null) || d(context, intent)) {
            return;
        }
        context.sendBroadcast(intent);
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, str) == null) {
            a(context, str, -1);
        }
    }

    public static void a(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65551, null, context, str, i2) == null) {
            try {
                if (l != null && !i.isEmpty()) {
                    l.sendEmptyMessage(65553);
                }
                System.currentTimeMillis();
                Intent b2 = b(context, 0);
                if (b2 == null) {
                    return;
                }
                if (i2 == -1) {
                    i2 = com.baidu.android.pushservice.l.d.i(context).b();
                }
                if (TextUtils.isEmpty(str)) {
                    z(context);
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                boolean z = true;
                if (i2 == 5) {
                    jSONObject2.put(Constants.PARAM_PLATFORM, 0);
                } else if (i2 == 6) {
                    jSONObject2.put(Constants.PARAM_PLATFORM, 1);
                } else if (i2 == 7) {
                    jSONObject2.put(Constants.PARAM_PLATFORM, 3);
                } else if (i2 == 8) {
                    jSONObject2.put(Constants.PARAM_PLATFORM, 4);
                } else if (i2 == 9) {
                    jSONObject2.put(Constants.PARAM_PLATFORM, 5);
                } else if (i2 == 10) {
                    jSONObject2.put(Constants.PARAM_PLATFORM, 9);
                } else {
                    z = false;
                }
                if (z) {
                    jSONObject2.put("token", str);
                    JSONObject l2 = l(context);
                    if (l2.length() > 0) {
                        jSONObject2.put("ext", l2);
                    }
                    jSONObject.put("info", jSONObject2);
                    com.baidu.android.pushservice.a0.j.a(context, i2, str);
                }
                b2.putExtra("push_proxy", jSONObject.toString());
                if (com.baidu.android.pushservice.i.g) {
                    com.baidu.android.pushservice.i.a(context).a(jSONObject.toString());
                } else {
                    d(context, b2);
                }
                com.baidu.android.pushservice.a0.j.b(context, "need_retry_proxy_bind", false);
            } catch (Exception unused) {
                z(context);
            }
        }
    }

    public static void a(Context context, String str, int i2, String str2, ClientEventInfo clientEventInfo, TokenBindListener tokenBindListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{context, str, Integer.valueOf(i2), str2, clientEventInfo, tokenBindListener}) == null) || context == null) {
            return;
        }
        com.baidu.android.pushservice.i.a(context).a(i2, str2, clientEventInfo, tokenBindListener);
        com.baidu.android.pushservice.z.e.a().a(new c(context, str, tokenBindListener));
    }

    public static boolean a(Context context, UploadDataListener uploadDataListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, context, uploadDataListener)) == null) {
            if (uploadDataListener == null) {
                return false;
            }
            if (context == null) {
                uploadDataListener.onResult(IMConstants.ERROR_GROUP_DISBAND);
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65555, null, context, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && str2 != null) {
                String d2 = Utility.d(context, context.getPackageName());
                if (d2 != null) {
                    String a2 = com.baidu.android.pushservice.a0.f.a(Utility.a(d2.getBytes(), str2.getBytes()), false);
                    if (!TextUtils.isEmpty(a2)) {
                        if (l.a(a2.getBytes(), str, BaiduAppSSOJni.getPublicKey(3))) {
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static Intent b(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65556, null, context, i2)) == null) {
            Intent i3 = i(context);
            if (i3 == null) {
                return null;
            }
            i3.putExtra("method", "method_bind");
            i3.putExtra("bind_status", i2);
            i3.putExtra("push_sdk_version", (int) com.baidu.android.pushservice.a.a());
            i3.setFlags(i3.getFlags() | 32);
            if (Build.VERSION.SDK_INT >= 19) {
                int b2 = com.baidu.android.pushservice.a0.h.b(context);
                i3.putExtra("bind_notify_status", b2 + "");
            }
            return i3;
        }
        return (Intent) invokeLI.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
        r2 = r1.getFragment();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (android.text.TextUtils.isEmpty(r2) != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
        r2 = r2.split(com.yy.hiidostatis.defs.obj.ParamableElem.DIVIDE_PARAM);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
        if (r2 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
        if (r2.length <= 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
        if (r4 >= r2.length) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0059, code lost:
        if (r2[r4].contains("S.bdpush_hwmsgid") == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005b, code lost:
        r6 = r2[r4].split("=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:
        if (r6 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0067, code lost:
        if (1 >= r6.length) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0069, code lost:
        r3 = r6[1];
        r10.putExtra("bdpush_hwmsgid", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0072, code lost:
        r10 = r1.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007a, code lost:
        if (android.text.TextUtils.isEmpty(r10) != false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0082, code lost:
        if (r10.contains("#Intent;") == false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0084, code lost:
        r9 = com.baidu.android.pushservice.util.Utility.f(r9, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0088, code lost:
        if (r9 <= 0) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008a, code lost:
        r0 = new java.lang.StringBuilder();
        r0.append(r3);
        r0.append(r10.substring(0, r9));
        r9 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, context, intent)) == null) {
            if (intent != null) {
                try {
                    Uri data = intent.getData();
                    String stringExtra = intent.getStringExtra("bdpush_hwprisigninfo");
                    String stringExtra2 = intent.getStringExtra("bdpush_hwmsgid");
                    if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                        if (data != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(stringExtra2);
                            sb.append(data.toString());
                            return sb.toString();
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static void b(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65559, null, context, i2, str) == null) || s(context)) {
            return;
        }
        com.baidu.android.pushservice.a.a(context, true);
        Utility.a(context, true, false);
        com.baidu.android.pushservice.u.a.a("PushManagerHandler", "startWork from" + context.getPackageName() + " at time of " + System.currentTimeMillis(), context);
        if (f(context)) {
            Utility.a(context, true, true);
            String e2 = e(context);
            Intent intent = new Intent();
            intent.putExtra("method", "method_bind");
            intent.putExtra(GameCodeGetResponseMsg.PARAM_ERROR_MSG, 0);
            intent.putExtra("content", e2.getBytes());
            intent.putExtra("bind_status", 0);
            com.baidu.android.pushservice.u.a.a("PushManagerHandler", "new startWork> sendResult to " + context.getPackageName() + " ,method:method_bind ,errorCode : 0 ,content : " + e2, context.getApplicationContext());
            Utility.c(context, intent, "com.baidu.android.pushservice.action.RECEIVE", context.getPackageName());
            t(context);
        } else {
            a(context, i2, str, false);
        }
        if (Build.VERSION.SDK_INT >= 24 && Utility.j(context, context.getPackageName()) >= 24) {
            v(context);
        }
        g(context);
    }

    public static void b(Context context, String str) {
        Intent b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65560, null, context, str) == null) || (b2 = b(context, 0)) == null) {
            return;
        }
        if (com.baidu.android.pushservice.i.g) {
            com.baidu.android.pushservice.i.a(context).a(str);
            return;
        }
        b2.putExtra("push_proxy", str);
        d(context, b2);
    }

    public static void b(Context context, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            boolean q = com.baidu.android.pushservice.l.d.q(context);
            System.currentTimeMillis();
            if (com.baidu.android.pushservice.l.d.m(context)) {
                if (!z && !q) {
                    com.baidu.android.pushservice.a.a(context, false);
                }
            } else if (!com.baidu.android.pushservice.l.d.t(context)) {
                if (com.baidu.android.pushservice.l.d.B(context)) {
                    if (!z && !q) {
                        com.baidu.android.pushservice.a.a(context, false);
                    }
                    q(context);
                    return;
                } else if (com.baidu.android.pushservice.l.d.p(context) && com.baidu.android.pushservice.l.d.w(context)) {
                    if (!z && !q) {
                        com.baidu.android.pushservice.a.a(context, false);
                    }
                    p(context);
                    return;
                } else if (com.baidu.android.pushservice.l.d.n(context)) {
                    if (!z && !q) {
                        com.baidu.android.pushservice.a.a(context, false);
                    }
                    o(context);
                    return;
                } else if (com.baidu.android.pushservice.l.d.y(context)) {
                    Utility.b(context.getApplicationContext(), z);
                    return;
                } else {
                    com.baidu.android.pushservice.u.a.a("PushManagerHandler", "login type = " + i2, context.getApplicationContext());
                    if (i2 != 0) {
                        com.baidu.android.pushservice.u.a.b("PushManagerHandler", "Wrong login type, please check!", context.getApplicationContext());
                        return;
                    }
                    com.baidu.android.pushservice.u.a.a("PushManagerHandler", "startWork at time of " + System.currentTimeMillis(), context);
                    if (com.baidu.android.pushservice.i.g) {
                        com.baidu.android.pushservice.i.a(context).a("");
                        return;
                    } else {
                        a(context, 0);
                        return;
                    }
                }
            } else if (com.baidu.android.pushservice.l.d.l(context)) {
                com.baidu.android.pushservice.o.a.a(context).e();
                return;
            }
            n(context);
        }
    }

    public static String c(Context context, Intent intent) {
        InterceptResult invokeLL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, context, intent)) == null) {
            if (intent != null) {
                try {
                    Uri data = intent.getData();
                    String stringExtra = intent.getStringExtra("bdpush_hwprisigninfo");
                    if (!TextUtils.isEmpty(stringExtra) || data == null) {
                        return stringExtra;
                    }
                    String fragment = data.getFragment();
                    if (TextUtils.isEmpty(fragment) || (split = fragment.split(ParamableElem.DIVIDE_PARAM)) == null || split.length <= 0) {
                        return stringExtra;
                    }
                    for (int i2 = 0; i2 < split.length; i2++) {
                        if (split[i2].startsWith("S.bdpush_hwprisigninfo")) {
                            return split[i2].substring(23);
                        }
                    }
                    return stringExtra;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, context) == null) {
            d(context);
        }
    }

    public static void c(Context context, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65564, null, context, i2) == null) && i2 == 3) {
            com.baidu.android.pushservice.a0.i.b(context, "key_widget_push_source_set_time", System.currentTimeMillis());
        }
    }

    public static void c(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65565, null, context, i2, str) == null) {
            com.baidu.android.pushservice.i.g = true;
            if (i2 == 0) {
                com.baidu.android.pushservice.a0.i.b(context, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
                com.baidu.android.pushservice.a0.i.b(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE", str);
            }
            b(context, true, i2);
        }
    }

    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65566, null, context) == null) || l == null || i.isEmpty()) {
            return;
        }
        l.sendEmptyMessage(65553);
        y(context);
    }

    public static void d(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65567, null, context, i2) == null) {
            try {
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, PushSystemNotifyReceiver.class.getName()), i2, 1);
            } catch (Throwable unused) {
            }
            if (i2 == 2) {
                com.baidu.android.pushservice.v.c.a().d(context, i2);
            }
        }
    }

    public static boolean d(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65568, null, context, intent)) == null) ? com.baidu.android.pushservice.h.a(context).c(intent) : invokeLL.booleanValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0);
                String string = sharedPreferences.getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, "");
                String string2 = sharedPreferences.getString("appid", "");
                String string3 = sharedPreferences.getString("channel_id", "");
                String string4 = sharedPreferences.getString("new_channel_id", "");
                String string5 = sharedPreferences.getString("user_id", "");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", string2);
                jSONObject.put("channel_id", string3);
                if (!TextUtils.isEmpty(string4)) {
                    jSONObject.put("new_channel_id", string4);
                }
                jSONObject.put("user_id", string5);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, string);
                jSONObject2.put("response_params", jSONObject);
                return jSONObject2.toString();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0);
            if (sharedPreferences.getBoolean("bind_status", false)) {
                if (System.currentTimeMillis() - sharedPreferences.getLong("currbindtime", 0L) > com.baidu.android.pushservice.l.d.f(context) * 3600 * 1000) {
                    sharedPreferences.edit().clear().commit();
                    return false;
                } else if (com.baidu.android.pushservice.a0.j.a(context, "need_retry_proxy_bind", false)) {
                    return false;
                } else {
                    return ((long) Utility.k(context, context.getPackageName())) == sharedPreferences.getLong("version_code", 0L) && com.baidu.android.pushservice.a0.i.a(context, "com.baidu.android.pushservice.SDK_INT_VERSION", (int) com.baidu.android.pushservice.a.a()) == com.baidu.android.pushservice.a.a();
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, context) == null) {
            if ((Utility.N(context) || Utility.P(context) || Utility.M(context)) && PushSettings.k(context) && Utility.E(context) && TextUtils.isEmpty(com.baidu.android.pushservice.a0.i.c(context, "notification_channel_id"))) {
                com.baidu.android.pushservice.a0.h.a(context, "com.baidu.android.pushservice.push", "云推送");
            }
        }
    }

    public static void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, null, context) == null) {
            Context applicationContext = context.getApplicationContext();
            if (i.size() > 100) {
                return;
            }
            i iVar = new i(applicationContext);
            i.add(iVar);
            if (l == null) {
                l = new h(applicationContext);
            }
            l.postDelayed(iVar, 10000L);
        }
    }

    public static Intent i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, context)) == null) {
            if (s(context)) {
                return null;
            }
            int i2 = a;
            if (i2 == -1) {
                i2 = com.baidu.android.pushservice.a0.i.a(context, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
            }
            String k2 = k(context);
            if (TextUtils.isEmpty(k2)) {
                com.baidu.android.pushservice.u.a.b("PushManagerHandler", "Can not acquire loginValue, please check if there is a right loginValue", context);
                y(context);
                return null;
            }
            Intent b2 = m.b(context);
            if (i2 == 0) {
                b2.putExtra("secret_key", k2);
                return b2;
            }
            return null;
        }
        return (Intent) invokeL.objValue;
    }

    public static Intent j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, context)) == null) {
            Intent intent = new Intent("com.baidu.android.pushservice.action.receiver.ALARM");
            intent.putExtra(com.baidu.android.imsdk.internal.Constants.EXTRA_ALARM_ALERT, "OK");
            intent.setFlags(32);
            intent.setClass(context, PushServiceReceiver.class);
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public static String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65575, null, context)) == null) ? !TextUtils.isEmpty(b) ? b : com.baidu.android.pushservice.a0.i.c(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE") : (String) invokeL.objValue;
    }

    public static JSONObject l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, context)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (com.baidu.android.pushservice.l.d.y(context)) {
                    jSONObject.put("control_strategies", PushClient.getInstance(context).isSupportNewControlStrategies() == 0 ? 1 : 0);
                }
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static Intent m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, context)) == null) {
            Intent intent = new Intent("com.baidu.android.pushservice.action.receiver.CANCEL_ALARM");
            intent.setFlags(32);
            intent.setClass(context, PushServiceReceiver.class);
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public static void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65578, null, context) == null) {
            PushSettings.h = 0;
            com.baidu.android.pushservice.a0.i.b(context, "com.baidu.android.pushservice.PushSettings.hw_hms_down_mode", 0);
            com.baidu.android.pushservice.z.e.a().a(new a(context));
        }
    }

    public static void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65579, null, context) == null) {
            Context applicationContext = context.getApplicationContext();
            if (TextUtils.isEmpty(e)) {
                e = com.baidu.android.pushservice.a0.i.c(applicationContext, "BD_MEIZU_PROXY_APPID_KEY");
            }
            if (TextUtils.isEmpty(f)) {
                f = com.baidu.android.pushservice.a0.i.c(applicationContext, "BD_MEIZU_PROXY_APPKEY_KEY");
            }
            if (TextUtils.isEmpty(e) || TextUtils.isEmpty(f)) {
                y(applicationContext);
                return;
            }
            h(applicationContext);
            Utility.c(applicationContext, e, f);
        }
    }

    public static void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65580, null, context) == null) {
            Context applicationContext = context.getApplicationContext();
            if (TextUtils.isEmpty(g)) {
                g = com.baidu.android.pushservice.a0.i.c(applicationContext, "BD_OPPO_PROXY_APPKEY_KEY");
            }
            if (TextUtils.isEmpty(h)) {
                h = com.baidu.android.pushservice.a0.i.c(applicationContext, "BD_OPPO_PROXY_APPSECRET_KEY");
            }
            if (TextUtils.isEmpty(g) || TextUtils.isEmpty(h)) {
                y(applicationContext);
                return;
            }
            h(applicationContext);
            Utility.d(applicationContext, g, h);
        }
    }

    public static void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65581, null, context) == null) {
            Context applicationContext = context.getApplicationContext();
            if (TextUtils.isEmpty(c)) {
                c = com.baidu.android.pushservice.a0.i.c(applicationContext, "BD_PROXY_APPID_KEY");
            }
            if (TextUtils.isEmpty(d)) {
                d = com.baidu.android.pushservice.a0.i.c(applicationContext, "BD_PROXY_APPKEY_KEY");
            }
            if (TextUtils.isEmpty(c) || TextUtils.isEmpty(d)) {
                y(applicationContext);
                return;
            }
            h(applicationContext);
            Utility.e(applicationContext, c, d);
        }
    }

    public static boolean r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65582, null, context)) == null) ? context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).contains("bind_status") : invokeL.booleanValue;
    }

    public static boolean s(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65583, null, context)) == null) ? context == null : invokeL.booleanValue;
    }

    public static void t(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65584, null, context) == null) {
            List<String> j2 = com.baidu.android.pushservice.l.d.j(context);
            if (j2.isEmpty()) {
                return;
            }
            Handler handler = new Handler(context.getMainLooper());
            for (int i2 = 0; i2 < j2.size(); i2++) {
                String str = j2.get(i2);
                if (Utility.m(context, str)) {
                    handler.postDelayed(new f(str, context), (5 + i2) * 1000);
                }
            }
        }
    }

    public static void u(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65585, null, context) == null) || context == null) {
            return;
        }
        context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0);
        context.getSharedPreferences(u.x, 0);
        context.getSharedPreferences("push_client_self_info", 0);
        context.getSharedPreferences("pst_bdservice_v1", 0);
        com.baidu.android.pushservice.l.d.i(context);
    }

    @TargetApi(24)
    public static void v(Context context) {
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65586, null, context) == null) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return;
        }
        try {
            if (k == null) {
                d dVar = new d(context);
                k = dVar;
                connectivityManager.registerDefaultNetworkCallback(dVar);
            }
        } catch (Exception unused) {
            k = null;
        }
    }

    public static void w(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65587, null, context) == null) {
            String k2 = k(context);
            if (TextUtils.isEmpty(k2)) {
                return;
            }
            a(context, 0, k2, false);
        }
    }

    public static boolean x(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, context)) == null) {
            if (j >= 2 || TextUtils.isEmpty(b)) {
                return false;
            }
            j++;
            b(context, true, a);
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void y(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65589, null, context) == null) {
            Intent intent = new Intent();
            String a2 = PushConstants.a(IMConstants.ERROR_GROUP_DISBAND);
            intent.setAction("com.baidu.android.pushservice.action.RECEIVE");
            intent.putExtra("method", "method_bind");
            intent.putExtra(GameCodeGetResponseMsg.PARAM_ERROR_MSG, IMConstants.ERROR_GROUP_DISBAND);
            intent.putExtra("content", a2.getBytes());
            intent.setFlags(32);
            Utility.c(context, intent, intent.getAction(), context.getPackageName());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0047 A[Catch: all -> 0x007a, TryCatch #0 {all -> 0x007a, blocks: (B:4:0x0004, B:6:0x000a, B:9:0x0021, B:24:0x0047, B:25:0x0053, B:12:0x0028, B:15:0x002f, B:18:0x0038, B:21:0x0041, B:27:0x005f, B:30:0x0066, B:33:0x006d), top: B:39:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void z(Context context) {
        Intent b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65590, null, context) == null) {
            try {
                boolean z = false;
                if (!com.baidu.android.pushservice.i.g) {
                    if (x(context) || (b2 = b(context, 0)) == null) {
                        return;
                    }
                    b2.putExtra("ignore_token", true);
                    d(context, b2);
                    com.baidu.android.pushservice.a0.j.b(context, "need_retry_proxy_bind", true);
                    return;
                }
                int b3 = com.baidu.android.pushservice.l.d.i(context).b();
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                if (b3 == 5) {
                    jSONObject2.put(Constants.PARAM_PLATFORM, 0);
                } else if (b3 == 6) {
                    jSONObject2.put(Constants.PARAM_PLATFORM, 1);
                } else if (b3 == 7) {
                    jSONObject2.put(Constants.PARAM_PLATFORM, 3);
                } else if (b3 != 8) {
                    if (b3 == 9) {
                        jSONObject2.put(Constants.PARAM_PLATFORM, 5);
                    }
                    if (z) {
                        jSONObject2.put("token", "");
                        jSONObject.put("info", jSONObject2);
                    }
                    com.baidu.android.pushservice.i.a(context).a(jSONObject.toString());
                } else {
                    jSONObject2.put(Constants.PARAM_PLATFORM, 4);
                }
                z = true;
                if (z) {
                }
                com.baidu.android.pushservice.i.a(context).a(jSONObject.toString());
            } catch (Throwable unused) {
            }
        }
    }
}
