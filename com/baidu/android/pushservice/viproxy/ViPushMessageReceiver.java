package com.baidu.android.pushservice.viproxy;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.frequency.b;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.OpenClientPushMessageReceiver;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ViPushMessageReceiver extends OpenClientPushMessageReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ViPushMessageReceiver() {
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

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onNotificationMessageClicked(Context context, UPSNotificationMessage uPSNotificationMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, uPSNotificationMessage) == null) || uPSNotificationMessage == null) {
            return;
        }
        int skipType = uPSNotificationMessage.getSkipType();
        String skipContent = uPSNotificationMessage.getSkipContent();
        if (skipType != 3 || skipContent.isEmpty()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(skipContent);
            String optString = jSONObject.optString("msgid");
            String optString2 = jSONObject.optString("visigninfo");
            String optString3 = jSONObject.optString("pkg_content");
            String optString4 = jSONObject.optString("custom_content");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return;
            }
            Intent intent = new Intent("com.baidu.android.pushservice.action.VIVO_CLICK");
            intent.putExtra("vi_notification_title", uPSNotificationMessage.getTitle());
            intent.putExtra("vi_notification_content", uPSNotificationMessage.getContent());
            intent.putExtra("vi_notification_sign", optString2);
            intent.putExtra("vi_notification_msg_id", optString);
            intent.putExtra("vi_notification_pkg_content", optString3);
            intent.putExtra("extra_extra_custom_content", optString4);
            m.a(intent, context.getApplicationContext());
            b.a().a(context, false, 1, optString4);
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
        }
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onReceiveRegId(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) {
        }
    }
}
