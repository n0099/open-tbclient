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
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.b.d;
import com.baidu.android.pushservice.frequency.UploadDataListener;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.k;
import com.baidu.android.pushservice.i.l;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.dxmpay.wallet.utils.StatHelper;
import com.heytap.mcssdk.callback.PushCallback;
import com.heytap.mcssdk.mode.SubscribeResult;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static String f30520b;

    /* renamed from: c  reason: collision with root package name */
    public static String f30521c;

    /* renamed from: d  reason: collision with root package name */
    public static String f30522d;

    /* renamed from: e  reason: collision with root package name */
    public static String f30523e;

    /* renamed from: f  reason: collision with root package name */
    public static String f30524f;

    /* renamed from: g  reason: collision with root package name */
    public static String f30525g;

    /* renamed from: h  reason: collision with root package name */
    public static String f30526h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile int f30527i;

    /* renamed from: j  reason: collision with root package name */
    public static volatile long f30528j;
    public static Handler k;
    public static final ConcurrentLinkedQueue<Runnable> l;
    public static int m;
    public static long n;
    public static ConnectivityManager.NetworkCallback o;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(context.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
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
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || message.what != 65553 || e.k == null || e.l == null || e.l.isEmpty()) {
                return;
            }
            e.k.removeCallbacks((b) e.l.poll());
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
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
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
            if (r0 > 86400000) goto L8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
            if (r0 > 172800000) goto L8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0024, code lost:
            if (r0 > com.baidu.tbadk.core.util.StorageFile.MAX_BUBBULE_CACHE_TIME) goto L8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
            r3 = r2;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            String d2;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - com.baidu.android.pushservice.i.j.a(this.a);
            String str = "";
            if (com.baidu.android.pushservice.b.d.k(this.a)) {
                d2 = com.baidu.android.pushservice.i.j.c(this.a);
            } else if (!com.baidu.android.pushservice.b.d.l(this.a)) {
                if (com.baidu.android.pushservice.b.d.j(this.a)) {
                    d2 = com.baidu.android.pushservice.i.j.d(this.a);
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    e.a(this.a, str);
                    return;
                }
                if (!e.l.isEmpty()) {
                    e.l.poll();
                }
                e.k(this.a);
            } else {
                d2 = com.baidu.android.pushservice.i.j.b(this.a);
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
        l = new ConcurrentLinkedQueue<>();
        m = 0;
        n = 0L;
        f30527i = 0;
        f30528j = 0L;
    }

    public static Intent a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            Intent intent = new Intent("com.baidu.android.pushservice.action.receiver.ALARM");
            intent.putExtra(Constants.EXTRA_ALARM_ALERT, StatHelper.SENSOR_OK);
            intent.setFlags(32);
            intent.setClass(context, PushServiceReceiver.class);
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public static Intent a(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, context, i2)) == null) {
            Intent c2 = c(context);
            if (c2 == null) {
                return null;
            }
            c2.putExtra("method", "method_bind");
            c2.putExtra("bind_status", i2);
            c2.putExtra("push_sdk_version", (int) com.baidu.android.pushservice.a.a());
            c2.setFlags(c2.getFlags() | 32);
            if (Build.VERSION.SDK_INT >= 19) {
                int b2 = com.baidu.android.pushservice.i.h.b(context);
                c2.putExtra("bind_notify_status", b2 + "");
            }
            return c2;
        }
        return (Intent) invokeLI.objValue;
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2) == null) || System.currentTimeMillis() - f30528j < 30000) {
            return;
        }
        f30527i = i2;
        f30528j = System.currentTimeMillis();
    }

    public static void a(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65541, null, context, i2, str) == null) || m(context)) {
            return;
        }
        com.baidu.android.pushservice.a.a(context, true);
        m.a(context, true, false);
        com.baidu.android.pushservice.f.a.a("PushManagerHandler", "startWork from" + context.getPackageName() + " at time of " + System.currentTimeMillis(), context);
        if (p(context)) {
            m.a(context, true, true);
            String q = q(context);
            Intent intent = new Intent();
            intent.putExtra("method", "method_bind");
            intent.putExtra(GameCodeGetResponseMsg.PARAM_ERROR_MSG, 0);
            intent.putExtra("content", q.getBytes());
            intent.putExtra("bind_status", 0);
            com.baidu.android.pushservice.f.a.a("PushManagerHandler", "new startWork> sendResult to " + context.getPackageName() + " ,method:method_bind ,errorCode : 0 ,content : " + q, context.getApplicationContext());
            m.b(context, intent, "com.baidu.android.pushservice.action.RECEIVE", context.getPackageName());
            v(context);
        } else {
            a(context, i2, str, false);
        }
        if (Build.VERSION.SDK_INT >= 24 && m.m(context, context.getPackageName()) >= 24) {
            u(context);
        }
        w(context);
    }

    public static void a(Context context, int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            int f2 = com.baidu.android.pushservice.b.d.g() ? com.baidu.android.pushservice.b.d.f() : 0;
            if (k == null) {
                k = new a(context);
            }
            k.postDelayed(new Runnable(context, str, i2, z) { // from class: com.baidu.android.pushservice.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f30530b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f30531c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ boolean f30532d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, str, Integer.valueOf(i2), Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = context;
                    this.f30530b = str;
                    this.f30531c = i2;
                    this.f30532d = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.baidu.android.pushservice.b.d.a(this.a.getApplicationContext()).a(this.f30530b, new d.a(this) { // from class: com.baidu.android.pushservice.e.3.1
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

                            @Override // com.baidu.android.pushservice.b.d.a
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    AnonymousClass3 anonymousClass3 = this.a;
                                    if (anonymousClass3.f30531c == 0) {
                                        com.baidu.android.pushservice.i.i.a(anonymousClass3.a, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
                                        AnonymousClass3 anonymousClass32 = this.a;
                                        com.baidu.android.pushservice.i.i.a(anonymousClass32.a, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE", anonymousClass32.f30530b);
                                    }
                                    int unused = e.m = 0;
                                    i.a = false;
                                    AnonymousClass3 anonymousClass33 = this.a;
                                    e.b(anonymousClass33.a, anonymousClass33.f30532d, anonymousClass33.f30531c);
                                }
                            }
                        });
                    }
                }
            }, f2 * 1000);
        }
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, str) == null) {
            try {
                if (k != null && !l.isEmpty()) {
                    k.sendEmptyMessage(65553);
                }
                long currentTimeMillis = System.currentTimeMillis();
                Intent a2 = a(context, 0);
                if (a2 == null) {
                    return;
                }
                int b2 = com.baidu.android.pushservice.b.d.a(context).b();
                if (TextUtils.isEmpty(str)) {
                    k(context);
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                boolean z = true;
                if (b2 == 5) {
                    jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, 0);
                } else if (b2 == 6) {
                    jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, 1);
                } else if (b2 == 7) {
                    jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, 3);
                } else if (b2 == 8) {
                    jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, 4);
                } else if (b2 == 9) {
                    jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, 5);
                } else {
                    z = false;
                }
                if (z) {
                    jSONObject2.put("token", str);
                    jSONObject.put("info", jSONObject2);
                    com.baidu.android.pushservice.i.j.a(context, b2, str);
                }
                a2.putExtra("push_proxy", jSONObject.toString());
                if (i.a) {
                    i.a(context).a(jSONObject.toString());
                } else {
                    a(context, a2);
                }
                com.baidu.android.pushservice.i.j.a(context, "need_retry_proxy_bind", false);
                new b.d(context.getApplicationContext()).a("bindForProxy").c(0L).d(501002L).b(currentTimeMillis).a(n).c(Build.FINGERPRINT).a();
            } catch (Exception e2) {
                k(context);
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
        }
    }

    public static void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65544, null, context, z) == null) {
            Context applicationContext = context.getApplicationContext();
            if (TextUtils.isEmpty(f30525g)) {
                f30525g = com.baidu.android.pushservice.i.i.a(applicationContext, "BD_OPPO_PROXY_APPKEY_KEY");
            }
            if (TextUtils.isEmpty(f30526h)) {
                f30526h = com.baidu.android.pushservice.i.i.a(applicationContext, "BD_OPPO_PROXY_APPSECRET_KEY");
            }
            if (!TextUtils.isEmpty(f30525g) && !TextUtils.isEmpty(f30526h)) {
                s(applicationContext);
                m.a(applicationContext, f30525g, f30526h, new PushCallback(z, applicationContext) { // from class: com.baidu.android.pushservice.e.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ boolean a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Context f30529b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {Boolean.valueOf(z), applicationContext};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = z;
                        this.f30529b = applicationContext;
                    }

                    @Override // com.heytap.mcssdk.callback.PushCallback
                    public void onGetAliases(int i2, List<SubscribeResult> list) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, list) == null) {
                        }
                    }

                    @Override // com.heytap.mcssdk.callback.PushCallback
                    public void onGetNotificationStatus(int i2, int i3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                        }
                    }

                    @Override // com.heytap.mcssdk.callback.PushCallback
                    public void onGetPushStatus(int i2, int i3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                        }
                    }

                    @Override // com.heytap.mcssdk.callback.PushCallback
                    public void onGetTags(int i2, List<SubscribeResult> list) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048579, this, i2, list) == null) {
                        }
                    }

                    @Override // com.heytap.mcssdk.callback.PushCallback
                    public void onGetUserAccounts(int i2, List<SubscribeResult> list) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048580, this, i2, list) == null) {
                        }
                    }

                    @Override // com.heytap.mcssdk.callback.PushCallback
                    public void onRegister(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeIL(1048581, this, i2, str) == null) && this.a) {
                            if (i2 != 0 || TextUtils.isEmpty(str)) {
                                e.k(this.f30529b);
                            } else {
                                e.a(this.f30529b, str);
                            }
                        }
                    }

                    @Override // com.heytap.mcssdk.callback.PushCallback
                    public void onSetAliases(int i2, List<SubscribeResult> list) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048582, this, i2, list) == null) {
                        }
                    }

                    @Override // com.heytap.mcssdk.callback.PushCallback
                    public void onSetPushTime(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048583, this, i2, str) == null) {
                        }
                    }

                    @Override // com.heytap.mcssdk.callback.PushCallback
                    public void onSetTags(int i2, List<SubscribeResult> list) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, list) == null) {
                        }
                    }

                    @Override // com.heytap.mcssdk.callback.PushCallback
                    public void onSetUserAccounts(int i2, List<SubscribeResult> list) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048585, this, i2, list) == null) {
                        }
                    }

                    @Override // com.heytap.mcssdk.callback.PushCallback
                    public void onUnRegister(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048586, this, i2) == null) {
                        }
                    }

                    @Override // com.heytap.mcssdk.callback.PushCallback
                    public void onUnsetAliases(int i2, List<SubscribeResult> list) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048587, this, i2, list) == null) {
                        }
                    }

                    @Override // com.heytap.mcssdk.callback.PushCallback
                    public void onUnsetTags(int i2, List<SubscribeResult> list) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048588, this, i2, list) == null) {
                        }
                    }

                    @Override // com.heytap.mcssdk.callback.PushCallback
                    public void onUnsetUserAccounts(int i2, List<SubscribeResult> list) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048589, this, i2, list) == null) {
                        }
                    }
                });
            } else if (z) {
                l(applicationContext);
            }
        }
    }

    public static boolean a(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, intent)) == null) ? h.a(context).a(intent) : invokeLL.booleanValue;
    }

    public static boolean a(Context context, UploadDataListener uploadDataListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, uploadDataListener)) == null) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, context, str, str2)) == null) {
            try {
                if (!TextUtils.isEmpty(str) && str2 != null) {
                    String n2 = m.n(context, context.getPackageName());
                    if (n2 != null) {
                        String a2 = com.baidu.android.pushservice.i.f.a(m.a(n2.getBytes(), str2.getBytes()), false);
                        if (!TextUtils.isEmpty(a2)) {
                            if (k.a(a2.getBytes(), str, BaiduAppSSOJni.getPublicKey(3))) {
                            }
                        }
                    }
                    return true;
                }
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            } catch (UnsatisfiedLinkError e3) {
                new b.c(context).a(Log.getStackTraceString(e3)).a();
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static Intent b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            Intent intent = new Intent("com.baidu.android.pushservice.action.receiver.CANCEL_ALARM");
            intent.setFlags(32);
            intent.setClass(context, PushServiceReceiver.class);
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public static void b(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65551, null, context, i2) == null) {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, PushSystemNotifyReceiver.class.getName()), i2, 1);
        }
    }

    public static void b(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65552, null, context, i2, str) == null) {
            i.a = true;
            if (i2 == 0) {
                com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
                com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE", str);
            }
            b(context, true, i2);
        }
    }

    public static void b(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65553, null, context, intent) == null) || a(context, intent)) {
            return;
        }
        context.sendBroadcast(intent);
    }

    public static void b(Context context, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            boolean c2 = com.baidu.android.pushservice.b.d.c(context);
            n = System.currentTimeMillis();
            new b.d(context.getApplicationContext()).a("startBind").d(501005L).a(n).a();
            if (com.baidu.android.pushservice.b.d.l(context)) {
                if (!z && !c2) {
                    com.baidu.android.pushservice.a.a(context, false);
                }
                f(context);
            } else if (com.baidu.android.pushservice.b.d.k(context)) {
                if (!z && !c2) {
                    com.baidu.android.pushservice.a.a(context, false);
                }
                d(context);
            } else if (com.baidu.android.pushservice.b.d.m(context) && com.baidu.android.pushservice.b.d.p(context)) {
                if (!z && !c2) {
                    com.baidu.android.pushservice.a.a(context, false);
                }
                a(context, true);
            } else if (com.baidu.android.pushservice.b.d.j(context)) {
                if (!z && !c2) {
                    com.baidu.android.pushservice.a.a(context, false);
                }
                e(context);
            } else if (com.baidu.android.pushservice.b.d.o(context)) {
                m.b(context.getApplicationContext(), z);
            } else {
                com.baidu.android.pushservice.f.a.a("PushManagerHandler", "login type = " + i2, context.getApplicationContext());
                if (i2 != 0) {
                    com.baidu.android.pushservice.f.a.b("PushManagerHandler", "Wrong login type, please check!", context.getApplicationContext());
                    return;
                }
                com.baidu.android.pushservice.f.a.a("PushManagerHandler", "startWork at time of " + System.currentTimeMillis(), context);
                if (i.a) {
                    i.a(context).a("");
                } else {
                    c(context, 0);
                }
            }
        }
    }

    public static Intent c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
            if (m(context)) {
                return null;
            }
            int i2 = a;
            if (i2 == -1) {
                i2 = com.baidu.android.pushservice.i.i.b(context, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
            }
            String r = r(context);
            if (TextUtils.isEmpty(r)) {
                com.baidu.android.pushservice.f.a.b("PushManagerHandler", "Can not acquire loginValue, please check if there is a right loginValue", context);
                l(context);
                return null;
            }
            Intent a2 = l.a(context);
            if (i2 == 0) {
                a2.putExtra("secret_key", r);
                return a2;
            }
            return null;
        }
        return (Intent) invokeL.objValue;
    }

    public static String c(Context context, Intent intent) {
        InterceptResult invokeLL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, intent)) == null) {
            if (intent != null) {
                try {
                    Uri data = intent.getData();
                    String stringExtra = intent.getStringExtra("bdpush_hwprisigninfo");
                    if (!TextUtils.isEmpty(stringExtra) || data == null) {
                        return stringExtra;
                    }
                    String fragment = data.getFragment();
                    if (TextUtils.isEmpty(fragment) || (split = fragment.split(";")) == null || split.length <= 0) {
                        return stringExtra;
                    }
                    for (int i2 = 0; i2 < split.length; i2++) {
                        if (split[i2].startsWith("S.bdpush_hwprisigninfo")) {
                            return split[i2].substring(23);
                        }
                    }
                    return stringExtra;
                } catch (Exception e2) {
                    new b.c(context).a(Log.getStackTraceString(e2)).a();
                    return null;
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static void c(Context context, int i2) {
        Intent a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65557, null, context, i2) == null) || (a2 = a(context, i2)) == null) {
            return;
        }
        a(context, a2);
        com.baidu.android.pushservice.f.a.a("PushManagerHandler", "Bind by selfEventHandler", context);
    }

    public static void c(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65558, null, context, i2, str) == null) {
            String str2 = "errorCode:" + i2 + ",errorMsg:" + str;
            com.baidu.android.pushservice.f.a.b("PushManagerHandler", str2, context.getApplicationContext());
            com.baidu.android.pushservice.c.c.a(context, 0L);
            m.a(context, false);
            Intent intent = new Intent();
            intent.putExtra("method", "method_bind");
            intent.putExtra(GameCodeGetResponseMsg.PARAM_ERROR_MSG, i2);
            intent.putExtra("content", str2.getBytes());
            intent.putExtra("bind_status", 0);
            m.b(context, intent, "com.baidu.android.pushservice.action.RECEIVE", context.getPackageName());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
        r3 = r2.getFragment();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0046, code lost:
        if (android.text.TextUtils.isEmpty(r3) != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
        r3 = r3.split(";");
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
        if (r3 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
        if (r3.length <= 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
        if (r5 >= r3.length) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005f, code lost:
        if (r3[r5].contains("S.bdpush_hwmsgid") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
        r7 = r3[r5].split("=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0069, code lost:
        if (r7 == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
        if (1 >= r7.length) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006f, code lost:
        r4 = r7[1];
        r11.putExtra("bdpush_hwmsgid", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0075, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0078, code lost:
        r11 = r2.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0080, code lost:
        if (android.text.TextUtils.isEmpty(r11) != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0088, code lost:
        if (r11.contains("#Intent;") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008a, code lost:
        r0 = com.baidu.android.pushservice.i.m.o(r10, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008e, code lost:
        if (r0 <= 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:?, code lost:
        return r4 + r11.substring(0, r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, context, intent)) == null) {
            if (intent != null) {
                try {
                    Uri data = intent.getData();
                    String stringExtra = intent.getStringExtra("bdpush_hwprisigninfo");
                    String stringExtra2 = intent.getStringExtra("bdpush_hwmsgid");
                    if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                        if (data != null) {
                            return stringExtra2 + data.toString();
                        }
                        return null;
                    }
                    return null;
                } catch (Exception e2) {
                    new b.c(context).a(Log.getStackTraceString(e2)).a();
                    return null;
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, context) == null) {
            Context applicationContext = context.getApplicationContext();
            if (TextUtils.isEmpty(f30521c)) {
                f30521c = com.baidu.android.pushservice.i.i.a(applicationContext, "BD_PROXY_APPID_KEY");
            }
            if (TextUtils.isEmpty(f30522d)) {
                f30522d = com.baidu.android.pushservice.i.i.a(applicationContext, "BD_PROXY_APPKEY_KEY");
            }
            if (TextUtils.isEmpty(f30521c) || TextUtils.isEmpty(f30522d)) {
                l(applicationContext);
                return;
            }
            s(applicationContext);
            m.c(applicationContext, f30521c, f30522d);
        }
    }

    public static void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, context) == null) {
            Context applicationContext = context.getApplicationContext();
            if (TextUtils.isEmpty(f30523e)) {
                f30523e = com.baidu.android.pushservice.i.i.a(applicationContext, "BD_MEIZU_PROXY_APPID_KEY");
            }
            if (TextUtils.isEmpty(f30524f)) {
                f30524f = com.baidu.android.pushservice.i.i.a(applicationContext, "BD_MEIZU_PROXY_APPKEY_KEY");
            }
            if (TextUtils.isEmpty(f30523e) || TextUtils.isEmpty(f30524f)) {
                l(applicationContext);
                return;
            }
            s(applicationContext);
            m.d(applicationContext, f30523e, f30524f);
        }
    }

    public static void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, context) == null) {
            PushSettings.f30266g = 0;
            com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushSettings.hw_hms_down_mode", 0);
            com.baidu.android.pushservice.g.e.a().a(new com.baidu.android.pushservice.g.c(context) { // from class: com.baidu.android.pushservice.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = context;
                }

                @Override // com.baidu.android.pushservice.g.c
                public void a() {
                    String str;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        e.s(this.a);
                        try {
                            str = HmsInstanceId.getInstance(this.a).getToken(AGConnectServicesConfig.fromContext(this.a).getString("client/app_id"), "HCM");
                        } catch (Throwable unused) {
                            PushSettings.f30266g = 1;
                            com.baidu.android.pushservice.i.i.a(this.a, "com.baidu.android.pushservice.PushSettings.hw_hms_down_mode", 1);
                            m.j(this.a);
                            str = "";
                        }
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        e.a(this.a, str);
                    }
                }
            });
        }
    }

    public static void g(Context context) {
        Intent c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65563, null, context) == null) || (c2 = c(context)) == null) {
            return;
        }
        c2.putExtra("method", "method_unbind");
        b(context, c2);
        m.a(context, false);
    }

    public static void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, context) == null) {
            String r = r(context);
            if (TextUtils.isEmpty(r)) {
                return;
            }
            a(context, 0, r, false);
        }
    }

    public static void i(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65565, null, context) == null) || k == null || l.isEmpty()) {
            return;
        }
        k.sendEmptyMessage(65553);
        l(context);
    }

    public static void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, context) == null) {
            i(context);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0047 A[Catch: all -> 0x00ae, TryCatch #0 {all -> 0x00ae, blocks: (B:4:0x0004, B:6:0x000a, B:9:0x0021, B:24:0x0047, B:25:0x0053, B:12:0x0028, B:15:0x002f, B:18:0x0038, B:21:0x0041, B:27:0x005f, B:30:0x0066, B:33:0x006d), top: B:41:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void k(Context context) {
        Intent a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, null, context) == null) {
            try {
                boolean z = false;
                if (!i.a) {
                    if (t(context) || (a2 = a(context, 0)) == null) {
                        return;
                    }
                    a2.putExtra("ignore_token", true);
                    a(context, a2);
                    com.baidu.android.pushservice.i.j.a(context, "need_retry_proxy_bind", true);
                    new b.d(context.getApplicationContext()).a("bindForProxy").c(LightappBusinessClient.SVC_ID_H5_QRGEN).d(501002L).b(System.currentTimeMillis()).a(n).c(Build.FINGERPRINT).a();
                    return;
                }
                int b2 = com.baidu.android.pushservice.b.d.a(context).b();
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                if (b2 == 5) {
                    jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, 0);
                } else if (b2 == 6) {
                    jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, 1);
                } else if (b2 == 7) {
                    jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, 3);
                } else if (b2 != 8) {
                    if (b2 == 9) {
                        jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, 5);
                    }
                    if (z) {
                        jSONObject2.put("token", "");
                        jSONObject.put("info", jSONObject2);
                    }
                    i.a(context).a(jSONObject.toString());
                } else {
                    jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, 4);
                }
                z = true;
                if (z) {
                }
                i.a(context).a(jSONObject.toString());
            } catch (Throwable th) {
                new b.c(context).a(Log.getStackTraceString(th)).a();
            }
        }
    }

    public static void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, context) == null) {
            Intent intent = new Intent();
            String a2 = PushConstants.a(IMConstants.ERROR_GROUP_DISBAND);
            intent.setAction("com.baidu.android.pushservice.action.RECEIVE");
            intent.putExtra("method", "method_bind");
            intent.putExtra(GameCodeGetResponseMsg.PARAM_ERROR_MSG, IMConstants.ERROR_GROUP_DISBAND);
            intent.putExtra("content", a2.getBytes());
            intent.setFlags(32);
            m.b(context, intent, intent.getAction(), context.getPackageName());
            new b.d(context.getApplicationContext()).a("bindForProxy").c(30602L).d(501002L).b(System.currentTimeMillis()).a(n).a();
        }
    }

    public static boolean m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) ? context == null : invokeL.booleanValue;
    }

    @TargetApi(24)
    public static void n(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65570, null, context) == null) || o == null) {
            return;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                connectivityManager.unregisterNetworkCallback(o);
                o = null;
            }
        } catch (SecurityException unused) {
        }
    }

    public static boolean p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, context)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0);
            if (sharedPreferences.getBoolean("bind_status", false)) {
                if (System.currentTimeMillis() - sharedPreferences.getLong("currbindtime", 0L) > com.baidu.android.pushservice.b.d.f(context) * 3600 * 1000) {
                    sharedPreferences.edit().clear().commit();
                    return false;
                } else if (com.baidu.android.pushservice.i.j.b(context, "need_retry_proxy_bind", false)) {
                    return false;
                } else {
                    return ((long) m.c(context, context.getPackageName())) == sharedPreferences.getLong("version_code", 0L) && com.baidu.android.pushservice.c.c.b(context) == com.baidu.android.pushservice.a.a();
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, context)) == null) {
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

    public static String r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65574, null, context)) == null) ? !TextUtils.isEmpty(f30520b) ? f30520b : com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE") : (String) invokeL.objValue;
    }

    public static void s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65575, null, context) == null) {
            Context applicationContext = context.getApplicationContext();
            if (l.size() > 100) {
                return;
            }
            b bVar = new b(applicationContext);
            l.add(bVar);
            if (k == null) {
                k = new a(applicationContext);
            }
            k.postDelayed(bVar, 10000L);
        }
    }

    public static boolean t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, context)) == null) {
            if (m >= 2 || TextUtils.isEmpty(f30520b)) {
                return false;
            }
            m++;
            b(context, true, a);
            return true;
        }
        return invokeL.booleanValue;
    }

    @TargetApi(24)
    public static void u(Context context) {
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65577, null, context) == null) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return;
        }
        try {
            if (o == null) {
                ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback(context) { // from class: com.baidu.android.pushservice.e.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = context;
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onAvailable(Network network) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, network) == null) {
                            super.onAvailable(network);
                            l.a(this.a, 0);
                        }
                    }
                };
                o = networkCallback;
                connectivityManager.registerDefaultNetworkCallback(networkCallback);
            }
        } catch (Exception unused) {
            o = null;
        }
    }

    public static void v(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65578, null, context) == null) {
            List<String> i2 = com.baidu.android.pushservice.b.d.i(context);
            if (i2.isEmpty()) {
                return;
            }
            Handler handler = new Handler(context.getMainLooper());
            for (int i3 = 0; i3 < i2.size(); i3++) {
                String str = i2.get(i3);
                if (m.b(context, str)) {
                    handler.postDelayed(new Runnable(str, context) { // from class: com.baidu.android.pushservice.e.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ String a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ Context f30533b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {str, context};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = str;
                            this.f30533b = context;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    Intent intent = new Intent();
                                    intent.setPackage(this.a);
                                    intent.setClassName(this.a, "com.baidu.android.pushservice.PushService");
                                    intent.putExtra("source", this.f30533b.getPackageName());
                                    this.f30533b.startService(intent);
                                    new b.d(this.f30533b).d(501010L).a(System.currentTimeMillis()).c(this.a).a();
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }, (5 + i3) * 1000);
                }
            }
        }
    }

    public static void w(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65579, null, context) == null) {
            if ((m.f() || m.h() || m.g()) && PushSettings.i(context) && m.p(context) && TextUtils.isEmpty(com.baidu.android.pushservice.i.i.a(context, "notification_channel_id"))) {
                com.baidu.android.pushservice.i.h.a(context, "com.baidu.android.pushservice.push", "云推送");
            }
        }
    }
}
