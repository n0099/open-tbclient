package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class HmsPushPatchMessageService extends HmsMessageService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public HmsPushPatchMessageService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void a(Context context, RemoteMessage remoteMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, context, remoteMessage) == null) {
            try {
                String data = remoteMessage.getData();
                TextUtils.isEmpty(data);
                Map dataOfMap = remoteMessage.getDataOfMap();
                if (TextUtils.isEmpty(data) && dataOfMap != null && !dataOfMap.isEmpty()) {
                    data = new JSONObject(dataOfMap).toString();
                }
                if (TextUtils.isEmpty(data)) {
                    return;
                }
                Intent intent = new Intent("com.huawei.android.push.intent.RECEIVE");
                intent.putExtra("IS_HMS_PASS_MSG_KEY", true);
                intent.putExtra("HMS_PASS_MSG_VALUE_KEY", data);
                m.a(intent, context.getApplicationContext());
            } catch (Exception e) {
                new b.c(context).a(Log.getStackTraceString(e)).a();
            }
        }
    }

    public void onDeletedMessages() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onDeletedMessages();
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDestroy();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.android.pushservice.HmsPushPatchMessageService */
    /* JADX WARN: Multi-variable type inference failed */
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, remoteMessage) == null) {
            super.onMessageReceived(remoteMessage);
            if (!PushSettings.l(getApplicationContext()) || Build.VERSION.SDK_INT >= 29) {
                a(this, remoteMessage);
            }
        }
    }

    public void onMessageSent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            super.onMessageSent(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.android.pushservice.HmsPushPatchMessageService */
    /* JADX WARN: Multi-variable type inference failed */
    public void onNewToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            super.onNewToken(str);
            if (!PushSettings.l(this) || Build.VERSION.SDK_INT >= 29) {
                try {
                    if (!com.baidu.android.pushservice.b.d.l(this) || TextUtils.isEmpty(str)) {
                        return;
                    }
                    e.a((Context) this, str);
                } catch (Exception e) {
                    new b.c(this).a(Log.getStackTraceString(e)).a();
                }
            }
        }
    }

    public void onSendError(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, exc) == null) {
            super.onSendError(str, exc);
        }
    }

    public void onTokenError(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, exc) == null) {
            super.onTokenError(exc);
        }
    }
}
