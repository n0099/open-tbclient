package com.baidu.android.pushservice.cross;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class CrossMsgActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CrossMsgActivity() {
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

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Uri data;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            Intent intent = getIntent();
            if (intent != null && (data = intent.getData()) != null) {
                String queryParameter = data.getQueryParameter("from");
                String queryParameter2 = data.getQueryParameter("to");
                if (queryParameter != null && queryParameter.startsWith("com.baidu") && TextUtils.equals(queryParameter2, getPackageName())) {
                    String stringExtra = intent.getStringExtra("msgid");
                    String stringExtra2 = intent.getStringExtra("notification_title");
                    String stringExtra3 = intent.getStringExtra("notification_content");
                    int intExtra = intent.getIntExtra("open_type", 0);
                    String stringExtra4 = intent.getStringExtra("message_pkg_content");
                    String stringExtra5 = intent.getStringExtra("extra_extra_custom_content");
                    String stringExtra6 = intent.getStringExtra("com.baidu.pushservice.app_id");
                    byte[] byteArrayExtra = intent.getByteArrayExtra("baidu_message_secur_info");
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra("baidu_message_body");
                    if (!TextUtils.isEmpty(stringExtra) && byteArrayExtra != null) {
                        Intent intent2 = new Intent("com.baidu.android.pushservice.action.CROSS_CLICK");
                        intent2.putExtra("msgid", stringExtra);
                        intent2.putExtra("notification_title", stringExtra2);
                        intent2.putExtra("notification_content", stringExtra3);
                        intent2.putExtra("open_type", intExtra);
                        intent2.putExtra("message_pkg_content", stringExtra4);
                        intent2.putExtra("extra_extra_custom_content", stringExtra5);
                        intent2.putExtra("com.baidu.pushservice.app_id", stringExtra6);
                        intent2.putExtra("baidu_message_secur_info", byteArrayExtra);
                        intent2.putExtra("baidu_message_body", byteArrayExtra2);
                        m.a(intent2, getApplicationContext());
                    }
                }
            }
            finish();
        }
    }
}
