package com.baidu.android.pushservice;

import android.annotation.TargetApi;
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
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.l;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.heytap.mcssdk.callback.PushCallback;
import com.heytap.mcssdk.mode.SubscribeResult;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f3084a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static String f3085b;

    /* renamed from: c  reason: collision with root package name */
    public static String f3086c;

    /* renamed from: d  reason: collision with root package name */
    public static String f3087d;

    /* renamed from: e  reason: collision with root package name */
    public static String f3088e;

    /* renamed from: f  reason: collision with root package name */
    public static String f3089f;

    /* renamed from: g  reason: collision with root package name */
    public static String f3090g;

    /* renamed from: h  reason: collision with root package name */
    public static String f3091h;

    /* renamed from: i  reason: collision with root package name */
    public static Handler f3092i;
    public static final ConcurrentLinkedQueue<Runnable> j;
    public static int k;
    public static long l;
    public static ConnectivityManager.NetworkCallback m;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || message.what != 65553 || f.f3092i == null || f.j == null || f.j.isEmpty()) {
                return;
            }
            f.f3092i.removeCallbacks((b) f.j.poll());
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f3103a;

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
            this.f3103a = context;
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
            long currentTimeMillis = System.currentTimeMillis() - com.baidu.android.pushservice.j.j.a(this.f3103a);
            String str = "";
            if (com.baidu.android.pushservice.b.d.k(this.f3103a)) {
                d2 = com.baidu.android.pushservice.j.j.c(this.f3103a);
            } else if (!com.baidu.android.pushservice.b.d.l(this.f3103a)) {
                if (com.baidu.android.pushservice.b.d.j(this.f3103a)) {
                    d2 = com.baidu.android.pushservice.j.j.d(this.f3103a);
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    f.a(this.f3103a, str);
                    return;
                }
                if (!f.j.isEmpty()) {
                    f.j.poll();
                }
                f.k(this.f3103a);
            } else {
                d2 = com.baidu.android.pushservice.j.j.b(this.f3103a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-840926985, "Lcom/baidu/android/pushservice/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-840926985, "Lcom/baidu/android/pushservice/f;");
                return;
            }
        }
        j = new ConcurrentLinkedQueue<>();
        k = 0;
        l = 0L;
    }

    public static Intent a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            Intent intent = new Intent("com.baidu.android.pushservice.action.receiver.ALARM");
            intent.putExtra(Constants.EXTRA_ALARM_ALERT, "OK");
            intent.setFlags(32);
            intent.setClass(context, PushServiceReceiver.class);
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public static Intent a(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, context, i2)) == null) {
            Intent c2 = c(context);
            if (c2 == null) {
                return null;
            }
            c2.putExtra("method", "method_bind");
            c2.putExtra("bind_status", i2);
            c2.putExtra("push_sdk_version", (int) com.baidu.android.pushservice.a.a());
            c2.setFlags(c2.getFlags() | 32);
            if (Build.VERSION.SDK_INT >= 19) {
                int b2 = com.baidu.android.pushservice.j.h.b(context);
                c2.putExtra("bind_notify_status", b2 + "");
            }
            return c2;
        }
        return (Intent) invokeLI.objValue;
    }

    public static void a(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(AdIconUtil.AD_TEXT_ID, null, context, i2, str) == null) || m(context)) {
            return;
        }
        com.baidu.android.pushservice.a.a(context, true);
        m.a(context, true, false);
        m.a("startWork from" + context.getPackageName() + " at time of " + System.currentTimeMillis(), context);
        if (o(context)) {
            m.a(context, true, true);
            String p = p(context);
            Intent intent = new Intent();
            intent.putExtra("method", "method_bind");
            intent.putExtra("error_msg", 0);
            intent.putExtra("content", p.getBytes());
            intent.putExtra("bind_status", 0);
            com.baidu.android.pushservice.g.a.a("PushManagerHandler", "new startWork> sendResult to " + context.getPackageName() + " ,method:method_bind ,errorCode : 0 ,content : " + p, context.getApplicationContext());
            m.b(context, intent, "com.baidu.android.pushservice.action.RECEIVE", context.getPackageName());
            u(context);
        } else {
            a(context, i2, str, false);
        }
        if (Build.VERSION.SDK_INT >= 24 && m.m(context, context.getPackageName()) >= 24) {
            t(context);
        }
        v(context);
    }

    public static void a(Context context, int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            int f2 = com.baidu.android.pushservice.b.d.g() ? com.baidu.android.pushservice.b.d.f() : 0;
            if (f3092i == null) {
                f3092i = new a(context);
            }
            f3092i.postDelayed(new Runnable(context, str, i2, z) { // from class: com.baidu.android.pushservice.f.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f3095a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f3096b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f3097c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ boolean f3098d;

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
                    this.f3095a = context;
                    this.f3096b = str;
                    this.f3097c = i2;
                    this.f3098d = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.baidu.android.pushservice.b.d.a(this.f3095a.getApplicationContext()).a(this.f3096b, new d.a(this) { // from class: com.baidu.android.pushservice.f.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f3099a;

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
                                this.f3099a = this;
                            }

                            @Override // com.baidu.android.pushservice.b.d.a
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    AnonymousClass2 anonymousClass2 = this.f3099a;
                                    if (anonymousClass2.f3097c == 0) {
                                        com.baidu.android.pushservice.j.i.a(anonymousClass2.f3095a, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
                                        AnonymousClass2 anonymousClass22 = this.f3099a;
                                        com.baidu.android.pushservice.j.i.a(anonymousClass22.f3095a, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE", anonymousClass22.f3096b);
                                    }
                                    int unused = f.k = 0;
                                    j.f3466a = false;
                                    AnonymousClass2 anonymousClass23 = this.f3099a;
                                    f.b(anonymousClass23.f3095a, anonymousClass23.f3098d, anonymousClass23.f3097c);
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
                if (f3092i != null && !j.isEmpty()) {
                    f3092i.sendEmptyMessage(65553);
                } else if (!com.baidu.android.pushservice.b.d.m(context) && !com.baidu.android.pushservice.b.d.n(context)) {
                    return;
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
                    com.baidu.android.pushservice.j.j.a(context, b2, str);
                }
                a2.putExtra("push_proxy", jSONObject.toString());
                if (j.f3466a) {
                    j.a(context).a(jSONObject.toString());
                } else {
                    a(context, a2);
                }
                com.baidu.android.pushservice.j.j.a(context, "need_retry_proxy_bind", false);
                new b.d(context.getApplicationContext()).a("bindForProxy").c(0L).d(501002L).b(currentTimeMillis).a(l).c(Build.FINGERPRINT).a();
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
            if (TextUtils.isEmpty(f3090g)) {
                f3090g = com.baidu.android.pushservice.j.i.a(applicationContext, "BD_OPPO_PROXY_APPKEY_KEY");
            }
            if (TextUtils.isEmpty(f3091h)) {
                f3091h = com.baidu.android.pushservice.j.i.a(applicationContext, "BD_OPPO_PROXY_APPSECRET_KEY");
            }
            if (!TextUtils.isEmpty(f3090g) && !TextUtils.isEmpty(f3091h)) {
                m.a(applicationContext, f3090g, f3091h, new PushCallback(z, applicationContext) { // from class: com.baidu.android.pushservice.f.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ boolean f3093a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Context f3094b;

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
                        this.f3093a = z;
                        this.f3094b = applicationContext;
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
                        if ((interceptable2 == null || interceptable2.invokeIL(1048581, this, i2, str) == null) && this.f3093a) {
                            if (i2 != 0 || TextUtils.isEmpty(str)) {
                                f.k(this.f3094b);
                            } else {
                                f.a(this.f3094b, str);
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, intent)) == null) ? i.a(context).a(intent) : invokeLL.booleanValue;
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
                    String n = m.n(context, context.getPackageName());
                    if (n != null) {
                        String a2 = com.baidu.android.pushservice.j.f.a(m.a(n.getBytes(), str2.getBytes()), false);
                        if (!TextUtils.isEmpty(a2)) {
                            if (com.baidu.android.pushservice.j.k.a(a2.getBytes(), str, BaiduAppSSOJni.getPublicKey(3))) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            Intent intent = new Intent("com.baidu.android.pushservice.action.receiver.CANCEL_ALARM");
            intent.setFlags(32);
            intent.setClass(context, PushServiceReceiver.class);
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public static void b(Context context, int i2) {
        Intent a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65550, null, context, i2) == null) || (a2 = a(context, i2)) == null) {
            return;
        }
        com.baidu.android.pushservice.g.a.a("PushManagerHandler", "a bind intent send", context.getApplicationContext());
        a(context, a2);
        m.a("Bind by selfEventHandler", context);
    }

    public static void b(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65551, null, context, i2, str) == null) {
            j.f3466a = true;
            if (i2 == 0) {
                com.baidu.android.pushservice.j.i.a(context, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
                com.baidu.android.pushservice.j.i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE", str);
            }
            b(context, true, i2);
        }
    }

    public static void b(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, null, context, intent) == null) || a(context, intent)) {
            return;
        }
        context.sendBroadcast(intent);
    }

    public static void b(Context context, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            boolean c2 = com.baidu.android.pushservice.b.d.c(context);
            l = System.currentTimeMillis();
            new b.d(context.getApplicationContext()).a("startBind").d(501005L).a(l).a();
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
                com.baidu.android.pushservice.g.a.a("PushManagerHandler", "login type = " + i2, context.getApplicationContext());
                if (i2 != 0) {
                    com.baidu.android.pushservice.g.a.b("PushManagerHandler", "Wrong login type, please check!", context.getApplicationContext());
                    return;
                }
                m.a("startWork at time of " + System.currentTimeMillis(), context);
                if (j.f3466a) {
                    j.a(context).a("");
                } else {
                    b(context, 0);
                }
            }
        }
    }

    public static Intent c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            if (m(context)) {
                return null;
            }
            int i2 = f3084a;
            if (i2 == -1) {
                i2 = com.baidu.android.pushservice.j.i.b(context, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
            }
            String q = q(context);
            if (TextUtils.isEmpty(q)) {
                com.baidu.android.pushservice.g.a.b("PushManagerHandler", "Can not acquire loginValue, please check if there is a right loginValue", context);
                l(context);
                return null;
            }
            Intent a2 = l.a(context);
            if (i2 == 0) {
                a2.putExtra("secret_key", q);
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, context, intent)) == null) {
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

    public static void c(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65556, null, context, i2, str) == null) {
            String str2 = "errorCode:" + i2 + ",errorMsg:" + str;
            com.baidu.android.pushservice.g.a.b("PushManagerHandler", str2, context.getApplicationContext());
            com.baidu.android.pushservice.c.c.a(context, 0L);
            m.a(context, false);
            Intent intent = new Intent();
            intent.putExtra("method", "method_bind");
            intent.putExtra("error_msg", i2);
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
        r0 = com.baidu.android.pushservice.j.m.o(r10, r11);
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, context, intent)) == null) {
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
        if (interceptable == null || interceptable.invokeL(65558, null, context) == null) {
            Context applicationContext = context.getApplicationContext();
            if (TextUtils.isEmpty(f3086c)) {
                f3086c = com.baidu.android.pushservice.j.i.a(applicationContext, "BD_PROXY_APPID_KEY");
            }
            if (TextUtils.isEmpty(f3087d)) {
                f3087d = com.baidu.android.pushservice.j.i.a(applicationContext, "BD_PROXY_APPKEY_KEY");
            }
            if (TextUtils.isEmpty(f3086c) || TextUtils.isEmpty(f3087d)) {
                l(applicationContext);
                return;
            }
            m.c(applicationContext, f3086c, f3087d);
            r(applicationContext);
        }
    }

    public static void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, context) == null) {
            Context applicationContext = context.getApplicationContext();
            if (TextUtils.isEmpty(f3088e)) {
                f3088e = com.baidu.android.pushservice.j.i.a(applicationContext, "BD_MEIZU_PROXY_APPID_KEY");
            }
            if (TextUtils.isEmpty(f3089f)) {
                f3089f = com.baidu.android.pushservice.j.i.a(applicationContext, "BD_MEIZU_PROXY_APPKEY_KEY");
            }
            if (TextUtils.isEmpty(f3088e) || TextUtils.isEmpty(f3089f)) {
                l(applicationContext);
                return;
            }
            m.d(applicationContext, f3088e, f3089f);
            r(applicationContext);
        }
    }

    public static void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, context) == null) {
            m.j(context);
            r(context);
        }
    }

    public static void g(Context context) {
        Intent c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65561, null, context) == null) || (c2 = c(context)) == null) {
            return;
        }
        c2.putExtra("method", "method_unbind");
        b(context, c2);
        m.a(context, false);
    }

    public static void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, context) == null) {
            String q = q(context);
            if (TextUtils.isEmpty(q)) {
                return;
            }
            a(context, 0, q, false);
        }
    }

    public static void i(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65563, null, context) == null) || f3092i == null || j.isEmpty()) {
            return;
        }
        f3092i.sendEmptyMessage(65553);
        l(context);
    }

    public static void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, context) == null) {
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
        if (interceptable == null || interceptable.invokeL(65565, null, context) == null) {
            try {
                boolean z = false;
                if (!j.f3466a) {
                    if (s(context) || (a2 = a(context, 0)) == null) {
                        return;
                    }
                    a2.putExtra("ignore_token", true);
                    a(context, a2);
                    com.baidu.android.pushservice.j.j.a(context, "need_retry_proxy_bind", true);
                    new b.d(context.getApplicationContext()).a("bindForProxy").c(LightappBusinessClient.SVC_ID_H5_QRGEN).d(501002L).b(System.currentTimeMillis()).a(l).c(Build.FINGERPRINT).a();
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
                    j.a(context).a(jSONObject.toString());
                } else {
                    jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, 4);
                }
                z = true;
                if (z) {
                }
                j.a(context).a(jSONObject.toString());
            } catch (Throwable th) {
                new b.c(context).a(Log.getStackTraceString(th)).a();
            }
        }
    }

    public static void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, context) == null) {
            Intent intent = new Intent();
            String a2 = PushConstants.a(IMConstants.ERROR_GROUP_DISBAND);
            intent.setAction("com.baidu.android.pushservice.action.RECEIVE");
            intent.putExtra("method", "method_bind");
            intent.putExtra("error_msg", IMConstants.ERROR_GROUP_DISBAND);
            intent.putExtra("content", a2.getBytes());
            intent.setFlags(32);
            m.b(context, intent, intent.getAction(), context.getPackageName());
            new b.d(context.getApplicationContext()).a("bindForProxy").c(30602L).d(501002L).b(System.currentTimeMillis()).a(l).a();
        }
    }

    public static boolean m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) ? context == null : invokeL.booleanValue;
    }

    @TargetApi(24)
    public static void n(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65568, null, context) == null) || m == null) {
            return;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                connectivityManager.unregisterNetworkCallback(m);
                m = null;
            }
        } catch (SecurityException unused) {
        }
    }

    public static boolean o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0);
            if (sharedPreferences.getBoolean("bind_status", false)) {
                if (System.currentTimeMillis() - sharedPreferences.getLong("currbindtime", 0L) > com.baidu.android.pushservice.b.d.f(context) * 3600 * 1000) {
                    sharedPreferences.edit().clear().commit();
                    return false;
                } else if (com.baidu.android.pushservice.j.j.b(context, "need_retry_proxy_bind", false)) {
                    return false;
                } else {
                    return ((long) m.c(context, context.getPackageName())) == sharedPreferences.getLong("version_code", 0L) && com.baidu.android.pushservice.c.c.b(context) == com.baidu.android.pushservice.a.a();
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
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

    public static String q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) ? !TextUtils.isEmpty(f3085b) ? f3085b : com.baidu.android.pushservice.j.i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE") : (String) invokeL.objValue;
    }

    public static void r(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, null, context) == null) {
            Context applicationContext = context.getApplicationContext();
            if (j.size() > 100) {
                return;
            }
            b bVar = new b(applicationContext);
            j.add(bVar);
            if (f3092i == null) {
                f3092i = new a(applicationContext);
            }
            f3092i.postDelayed(bVar, 6000L);
        }
    }

    public static boolean s(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, context)) == null) {
            if (k >= 2 || TextUtils.isEmpty(f3085b)) {
                return false;
            }
            k++;
            b(context, true, f3084a);
            return true;
        }
        return invokeL.booleanValue;
    }

    @TargetApi(24)
    public static void t(Context context) {
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65574, null, context) == null) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return;
        }
        try {
            if (m == null) {
                ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback(context) { // from class: com.baidu.android.pushservice.f.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Context f3100a;

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
                        this.f3100a = context;
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onAvailable(Network network) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, network) == null) {
                            super.onAvailable(network);
                            l.b(this.f3100a);
                        }
                    }
                };
                m = networkCallback;
                connectivityManager.registerDefaultNetworkCallback(networkCallback);
            }
        } catch (SecurityException unused) {
        }
    }

    public static void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65575, null, context) == null) {
            List<String> i2 = com.baidu.android.pushservice.b.d.i(context);
            if (i2.isEmpty()) {
                return;
            }
            Handler handler = new Handler(context.getMainLooper());
            for (int i3 = 0; i3 < i2.size(); i3++) {
                String str = i2.get(i3);
                if (m.b(context, str)) {
                    handler.postDelayed(new Runnable(str, context) { // from class: com.baidu.android.pushservice.f.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ String f3101a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ Context f3102b;

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
                            this.f3101a = str;
                            this.f3102b = context;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    Intent intent = new Intent();
                                    intent.setPackage(this.f3101a);
                                    intent.setClassName(this.f3101a, "com.baidu.android.pushservice.PushService");
                                    intent.putExtra("source", this.f3102b.getPackageName());
                                    this.f3102b.startService(intent);
                                    new b.d(this.f3102b).d(501010L).a(System.currentTimeMillis()).c(this.f3101a).a();
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }, (5 + i3) * 1000);
                }
            }
        }
    }

    public static void v(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65576, null, context) == null) {
            if ((m.e() || m.g() || m.f()) && PushSettings.i(context) && m.p(context) && TextUtils.isEmpty(com.baidu.android.pushservice.j.i.a(context, "notification_channel_id"))) {
                com.baidu.android.pushservice.j.h.a(context, "com.baidu.android.pushservice.push", "云推送");
            }
        }
    }
}
