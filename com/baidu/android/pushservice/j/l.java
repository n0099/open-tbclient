package com.baidu.android.pushservice.j;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Intent a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            Intent intent = new Intent("com.baidu.android.pushservice.action.METHOD");
            intent.addFlags(32);
            try {
                intent.putExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME, context.getPackageName());
                intent.putExtra("method_version", "V2");
                intent.putExtra(!m.o(context) ? "priority2" : "priority3", 0);
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public static boolean a(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, intent)) == null) {
            if (intent == null || TextUtils.isEmpty(intent.getAction())) {
                intent = a(context);
            }
            return (!com.baidu.android.pushservice.b.d.q(context) || com.baidu.android.pushservice.b.d.c(context)) ? a(context, intent, context.getPackageName()) : com.baidu.android.pushservice.i.a(context).a(intent);
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(Context context, Intent intent, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, intent, str)) == null) {
            com.baidu.android.pushservice.g.a.a("ServiceUtils", "startPushService go on pkgName = " + str, context.getApplicationContext());
            try {
                if (!TextUtils.isEmpty(str)) {
                    intent.setPackage(str);
                    intent.setClassName(str, m.m() ? "com.baidu.pushservice.PushService" : "com.baidu.android.pushservice.PushService");
                    context.startService(intent);
                    com.baidu.android.pushservice.g.a.a("ServiceUtils", "startPushService by startService", context.getApplicationContext());
                    return true;
                }
            } catch (Exception e2) {
                com.baidu.android.pushservice.g.a.b("ServiceUtils", "START SERVICE E: " + e2, context.getApplicationContext());
                if (com.baidu.android.pushservice.a.a(context.getPackageName())) {
                    return false;
                }
            }
            if (!m.p(context) && m.e(context, str)) {
                try {
                    String b2 = m.b(context, str, intent.getAction());
                    if (!TextUtils.isEmpty(b2)) {
                        intent.setClassName(str, b2);
                        context.sendBroadcast(intent);
                        com.baidu.android.pushservice.g.a.a("ServiceUtils", "startPushService by sendBroadcast", context.getApplicationContext());
                        return true;
                    }
                } catch (Exception e3) {
                    com.baidu.android.pushservice.g.a.b("ServiceUtils", "START SERVICE E-2: " + e3, context.getApplicationContext());
                    new b.c(context).a(Log.getStackTraceString(e3)).a();
                }
                return false;
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            com.baidu.android.pushservice.b.d.a(context).d();
            if (!com.baidu.android.pushservice.b.d.q(context) || com.baidu.android.pushservice.b.d.c(context)) {
                if (!com.baidu.android.pushservice.job.a.a() && !m.g(context) && (Build.VERSION.SDK_INT > 22 || (!m.e() && !m.h()))) {
                    new Handler(context.getMainLooper()).postDelayed(new Runnable(context) { // from class: com.baidu.android.pushservice.j.l.1
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

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                com.baidu.android.pushservice.job.a.a(this.a);
                                com.baidu.android.pushservice.job.a.a(this.a, true);
                            }
                        }
                    }, com.baidu.android.pushservice.b.d.h() * 1000);
                }
                com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("checkAndStartPushService", (short) 98, context.getApplicationContext()) { // from class: com.baidu.android.pushservice.j.l.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context a;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8, r9);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {r8, Short.valueOf(r9), r10};
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
                        this.a = r10;
                    }

                    @Override // com.baidu.android.pushservice.h.c
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            l.a(this.a, new Intent());
                        }
                    }
                });
            }
        }
    }
}
