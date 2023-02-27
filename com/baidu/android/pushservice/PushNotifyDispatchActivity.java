package com.baidu.android.pushservice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class PushNotifyDispatchActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PushNotifyDispatchActivity() {
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

    public final void a(Intent intent, Context context) {
        String packageName;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, intent, context) == null) || intent == null) {
            return;
        }
        String str = "com.baidu.android.pushservice.PushService";
        if (TextUtils.equals(intent.getAction(), "com.baidu.android.pushservice.action.privatenotification.CLICK")) {
            packageName = context.getPackageName();
            if (Utility.U(context)) {
                str = "com.baidu.pushservice.PushService";
            }
        } else if (TextUtils.equals(intent.getAction(), "com.baidu.android.pushservice.action.pass_through_notify_CLICK")) {
            intent.setClassName(context.getPackageName(), Utility.b(context, context.getPackageName(), "com.baidu.android.pushservice.action.RECEIVE"));
            context.sendBroadcast(intent);
            return;
        } else if (!TextUtils.equals(intent.getAction(), "com.baidu.pushservice.action.publicmsg.CLICK_V2")) {
            return;
        } else {
            packageName = context.getPackageName();
        }
        intent.setClassName(packageName, str);
        context.startService(intent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            a(getIntent(), getApplicationContext());
            finish();
        }
    }
}
