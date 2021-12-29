package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.message.a.k;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class PushPatchMessageReceiver extends com.xiaomi.mipush.sdk.PushMessageReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_ARRIVED = 2;
    public static final int MSG_CLICKED = 3;
    public static final int MSG_PASS = 1;
    public static final String PUSH_MSG = "xm_push_msg";
    public static final String PUSH_MSG_TYPE = "xm_push_msg_type";
    public static final String REGID = "xm_regid";
    public static final String REGISTER_ERRORCODE = "xm_register_errorcode";
    public static final String TAG = "PushPatchMessageReceiver";
    public transient /* synthetic */ FieldHolder $fh;

    public PushPatchMessageReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void handleXiaomiMsg(Context context, MiPushMessage miPushMessage, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65537, this, context, miPushMessage, i2) == null) {
            try {
                Intent intent = new Intent("com.xiaomi.mipush.PUSH_MSG");
                intent.putExtra(PUSH_MSG, miPushMessage);
                intent.putExtra(PUSH_MSG_TYPE, i2);
                m.a(intent, context.getApplicationContext());
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
        }
    }

    public static boolean msgFromXMConsole(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            try {
                new JSONObject(str);
                return false;
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, miPushMessage) == null) {
            super.onNotificationMessageArrived(context, miPushMessage);
            handleXiaomiMsg(context, miPushMessage, 2);
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, miPushMessage) == null) {
            super.onNotificationMessageClicked(context, miPushMessage);
            handleXiaomiMsg(context, miPushMessage, 3);
            String content = miPushMessage.getContent();
            com.baidu.android.pushservice.message.i iVar = new com.baidu.android.pushservice.message.i();
            if (msgFromXMConsole(context, content)) {
                iVar.f33375k = k.f33341b.b();
            } else {
                content = iVar.b(context, content);
            }
            com.baidu.android.pushservice.frequency.b.a().a(context, false, 1, content);
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, miPushMessage) == null) {
            super.onReceivePassThroughMessage(context, miPushMessage);
            handleXiaomiMsg(context, miPushMessage, 1);
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, miPushCommandMessage) == null) {
            super.onReceiveRegisterResult(context, miPushCommandMessage);
            if (miPushCommandMessage != null) {
                try {
                    String command = miPushCommandMessage.getCommand();
                    List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                    String str = (commandArguments == null || commandArguments.size() <= 0) ? null : commandArguments.get(0);
                    if (MiPushClient.COMMAND_REGISTER.equals(command)) {
                        Intent intent = new Intent("com.xiaomi.mipush.REGISTER");
                        intent.putExtra(REGID, str);
                        intent.putExtra(REGISTER_ERRORCODE, miPushCommandMessage.getResultCode());
                        m.a(intent, context.getApplicationContext());
                    }
                } catch (Exception e2) {
                    new b.c(context).a(Log.getStackTraceString(e2)).a();
                }
            }
        }
    }
}
