package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.d.n;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.CommandMessage;
/* loaded from: classes4.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static i f37183b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f37184a;

    public i(Context context) {
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
        this.f37184a = context;
        com.baidu.android.pushservice.a.b.a(context);
        k.a(context);
        com.baidu.android.pushservice.h.d.a();
    }

    public static synchronized i a(Context context) {
        InterceptResult invokeL;
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (i.class) {
                if (f37183b == null) {
                    f37183b = new i(context);
                }
                iVar = f37183b;
            }
            return iVar;
        }
        return (i) invokeL.objValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            com.baidu.android.pushservice.i.a.c.a(this.f37184a.getApplicationContext());
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            PushSettings.a(this.f37184a, 0);
        }
    }

    private void b(Intent intent) {
        boolean a2;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, intent) == null) {
            com.baidu.android.pushservice.d.i iVar = new com.baidu.android.pushservice.d.i(intent);
            int intExtra = intent.getIntExtra("bind_status", 0);
            int intExtra2 = intent.getIntExtra("push_sdk_version", 0);
            com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< METHOD_BIND ", this.f37184a);
            m.a("RegistrationService#handleBind#METHOD_BIND request arrive at " + System.currentTimeMillis(), this.f37184a);
            String d2 = com.baidu.android.pushservice.a.b.a(this.f37184a).d(iVar.f37051d);
            if (!TextUtils.isEmpty(iVar.f37054g) && com.baidu.android.pushservice.a.b.a(this.f37184a).b(iVar.f37051d, iVar.f37054g) && !TextUtils.isEmpty(d2)) {
                Intent intent2 = new Intent();
                intent2.putExtra("method", iVar.f37048a);
                intent2.putExtra("error_msg", 0);
                intent2.putExtra("content", d2.getBytes());
                intent2.putExtra("bind_status", intExtra);
                m.b(this.f37184a, intent2, "com.baidu.android.pushservice.action.RECEIVE", iVar.f37051d);
                m.a("RegistrationService#handleBind#returned by cacheContent = " + d2, this.f37184a);
                return;
            }
            m.a("RegistrationService#handleBind#METHOD_BIND request start at " + System.currentTimeMillis(), this.f37184a);
            if (intent.hasExtra("bind_notify_status")) {
                a2 = a(new com.baidu.android.pushservice.d.e(iVar, this.f37184a, intExtra, intExtra2, intent.getStringExtra("bind_notify_status")));
                sb = new StringBuilder();
            } else {
                a2 = a(new com.baidu.android.pushservice.d.e(iVar, this.f37184a, intExtra, intExtra2));
                sb = new StringBuilder();
            }
            sb.append("submitApiProcessor for bind=");
            sb.append(iVar.toString());
            m.a(sb.toString(), this.f37184a);
            if (a2) {
                return;
            }
            new Thread(new com.baidu.android.pushservice.d.e(iVar, this.f37184a, intExtra, intExtra2)).start();
            m.a("submitApiProcessor failed bind " + iVar.toString(), this.f37184a);
        }
    }

    private void c(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, intent) == null) {
            com.baidu.android.pushservice.d.i iVar = new com.baidu.android.pushservice.d.i(intent);
            com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< METHOD_UNBIND ", this.f37184a);
            if (!TextUtils.isEmpty(iVar.f37051d) && !TextUtils.isEmpty(iVar.f37054g)) {
                com.baidu.android.pushservice.a.e a2 = com.baidu.android.pushservice.a.b.a(this.f37184a).a(iVar.f37051d);
                if (a2 != null && !TextUtils.isEmpty(a2.a())) {
                    iVar.f37052e = a2.a();
                }
                com.baidu.android.pushservice.a.b.a(this.f37184a).e(iVar.f37051d);
            }
            a(new n(iVar, this.f37184a));
        }
    }

    private void d(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, intent) == null) {
            com.baidu.android.pushservice.d.i iVar = new com.baidu.android.pushservice.d.i(intent);
            String stringExtra = intent.getStringExtra(CommandMessage.TYPE_TAGS);
            com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< ACTION_SET_TAGS ", this.f37184a);
            a(new com.baidu.android.pushservice.d.m(iVar, this.f37184a, stringExtra));
        }
    }

    private void e(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, intent) == null) {
            com.baidu.android.pushservice.d.i iVar = new com.baidu.android.pushservice.d.i(intent);
            String stringExtra = intent.getStringExtra(CommandMessage.TYPE_TAGS);
            com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< ACTION_GBIND ", this.f37184a);
            a(new com.baidu.android.pushservice.d.h(iVar, this.f37184a, stringExtra));
        }
    }

    private void f(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, intent) == null) {
            com.baidu.android.pushservice.d.i iVar = new com.baidu.android.pushservice.d.i(intent);
            com.baidu.android.pushservice.g.a.a("RegistrationService", "<<< METHOD_LISTTAGS ", this.f37184a);
            a(new com.baidu.android.pushservice.d.k(iVar, this.f37184a));
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
            m.a("handleIntent#action = " + action, this.f37184a);
            if ("com.baidu.pushservice.action.publicmsg.CLICK_V2".equals(action) || "com.baidu.pushservice.action.publicmsg.DELETE_V2".equals(action)) {
                PublicMsg publicMsg = (PublicMsg) intent.getParcelableExtra("public_msg");
                String host = intent.getData().getHost();
                if (publicMsg != null) {
                    publicMsg.handle(this.f37184a, action, host);
                }
                return true;
            } else if ("com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) || "com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
                PublicMsg publicMsg2 = (PublicMsg) intent.getParcelableExtra("public_msg");
                if (m.b(this.f37184a, publicMsg2)) {
                    publicMsg2.handlePrivateNotification(this.f37184a, action, intent.getStringExtra("msg_id"), intent.getStringExtra("app_id"), intent.getByteArrayExtra("baidu_message_secur_info"), intent.getByteArrayExtra("baidu_message_body"));
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

    public boolean a(com.baidu.android.pushservice.d.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            try {
                com.baidu.android.pushservice.h.d.a().a(aVar);
                return true;
            } catch (Exception e2) {
                com.baidu.android.pushservice.g.a.a("RegistrationService", e2, this.f37184a);
                new b.c(this.f37184a.getApplicationContext()).a(Log.getStackTraceString(e2)).a();
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
