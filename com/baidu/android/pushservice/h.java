package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.httpapi.k;
import com.baidu.android.pushservice.httpapi.n;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static h f32991b;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    public h(Context context) {
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
        com.baidu.android.pushservice.a.b.a(context);
        j.a(context);
        com.baidu.android.pushservice.g.e.a();
    }

    public static synchronized h a(Context context) {
        InterceptResult invokeL;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (h.class) {
                if (f32991b == null) {
                    f32991b = new h(context);
                }
                hVar = f32991b;
            }
            return hVar;
        }
        return (h) invokeL.objValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            com.baidu.android.pushservice.h.a.c.a(this.a.getApplicationContext());
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            PushSettings.a(this.a, 0);
        }
    }

    private void b(Intent intent) {
        com.baidu.android.pushservice.httpapi.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, intent) == null) {
            com.baidu.android.pushservice.httpapi.i iVar = new com.baidu.android.pushservice.httpapi.i(intent);
            int intExtra = intent.getIntExtra("bind_status", 0);
            int intExtra2 = intent.getIntExtra("push_sdk_version", 0);
            com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< METHOD_BIND ", this.a);
            String d2 = com.baidu.android.pushservice.a.b.a(this.a).d(iVar.f33278d);
            if (!TextUtils.isEmpty(iVar.f33281g) && com.baidu.android.pushservice.a.b.a(this.a).b(iVar.f33278d, iVar.f33281g) && !TextUtils.isEmpty(d2)) {
                Intent intent2 = new Intent();
                intent2.putExtra("method", iVar.a);
                intent2.putExtra(GameCodeGetResponseMsg.PARAM_ERROR_MSG, 0);
                intent2.putExtra("content", d2.getBytes());
                intent2.putExtra("bind_status", intExtra);
                m.b(this.a, intent2, "com.baidu.android.pushservice.action.RECEIVE", iVar.f33278d);
                return;
            }
            if (intent.hasExtra("bind_notify_status")) {
                eVar = new com.baidu.android.pushservice.httpapi.e(iVar, this.a, intExtra, intExtra2, intent.getStringExtra("bind_notify_status"));
            } else {
                eVar = new com.baidu.android.pushservice.httpapi.e(iVar, this.a, intExtra, intExtra2);
            }
            if (a(eVar)) {
                return;
            }
            new Thread(new com.baidu.android.pushservice.httpapi.e(iVar, this.a, intExtra, intExtra2)).start();
        }
    }

    private void c(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, intent) == null) {
            com.baidu.android.pushservice.httpapi.i iVar = new com.baidu.android.pushservice.httpapi.i(intent);
            com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< METHOD_UNBIND ", this.a);
            if (!TextUtils.isEmpty(iVar.f33278d) && !TextUtils.isEmpty(iVar.f33281g)) {
                com.baidu.android.pushservice.a.e a = com.baidu.android.pushservice.a.b.a(this.a).a(iVar.f33278d);
                if (a != null && !TextUtils.isEmpty(a.a())) {
                    iVar.f33279e = a.a();
                }
                com.baidu.android.pushservice.a.b.a(this.a).e(iVar.f33278d);
            }
            a(new n(iVar, this.a));
        }
    }

    private void d(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, intent) == null) {
            com.baidu.android.pushservice.httpapi.i iVar = new com.baidu.android.pushservice.httpapi.i(intent);
            String stringExtra = intent.getStringExtra("tags");
            com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< ACTION_SET_TAGS ", this.a);
            a(new com.baidu.android.pushservice.httpapi.m(iVar, this.a, stringExtra));
        }
    }

    private void e(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, intent) == null) {
            com.baidu.android.pushservice.httpapi.i iVar = new com.baidu.android.pushservice.httpapi.i(intent);
            String stringExtra = intent.getStringExtra("tags");
            com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< ACTION_GBIND ", this.a);
            a(new com.baidu.android.pushservice.httpapi.h(iVar, this.a, stringExtra));
        }
    }

    private void f(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, intent) == null) {
            com.baidu.android.pushservice.httpapi.i iVar = new com.baidu.android.pushservice.httpapi.i(intent);
            com.baidu.android.pushservice.f.a.a("RegistrationService", "<<< METHOD_LISTTAGS ", this.a);
            a(new k(iVar, this.a));
        }
    }

    public boolean a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            if (intent == null || TextUtils.isEmpty(intent.getAction())) {
                return false;
            }
            String action = intent.getAction();
            if ("com.baidu.pushservice.action.publicmsg.CLICK_V2".equals(action) || "com.baidu.pushservice.action.publicmsg.DELETE_V2".equals(action)) {
                PublicMsg publicMsg = (PublicMsg) intent.getParcelableExtra("public_msg");
                String host = intent.getData().getHost();
                if (publicMsg != null) {
                    publicMsg.handle(this.a, action, host);
                }
                return true;
            } else if ("com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) || "com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
                PublicMsg publicMsg2 = (PublicMsg) intent.getParcelableExtra("public_msg");
                if (m.b(this.a, publicMsg2)) {
                    publicMsg2.handlePrivateNotification(this.a, action, intent.getStringExtra("msg_id"), intent.getStringExtra("app_id"), intent.getByteArrayExtra("baidu_message_secur_info"), intent.getByteArrayExtra("baidu_message_body"));
                    return true;
                }
                return true;
            } else if ("com.baidu.android.pushservice.action.METHOD".equals(action)) {
                String stringExtra = intent.getStringExtra("method");
                if ("method_bind".equals(stringExtra)) {
                    b(intent);
                } else if ("method_unbind".equals(stringExtra)) {
                    c(intent);
                } else if ("method_set_tags".equals(stringExtra) || "method_set_sdk_tags".equals(stringExtra)) {
                    d(intent);
                } else if ("method_del_tags".equals(stringExtra) || "method_del_sdk_tags".equals(stringExtra)) {
                    e(intent);
                } else if ("method_listtags".equals(stringExtra) || "method_list_sdk_tags".equals(stringExtra)) {
                    f(intent);
                } else if ("com.baidu.android.pushservice.action.SEND_APPSTAT".equals(stringExtra)) {
                    a();
                } else if (!"com.baidu.android.pushservice.action.ENBALE_APPSTAT".equals(stringExtra)) {
                    return false;
                } else {
                    b();
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean a(com.baidu.android.pushservice.httpapi.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            try {
                com.baidu.android.pushservice.g.e.a().a(aVar);
                return true;
            } catch (Exception e2) {
                com.baidu.android.pushservice.f.a.a("RegistrationService", e2, this.a);
                new b.c(this.a.getApplicationContext()).a(Log.getStackTraceString(e2)).a();
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
