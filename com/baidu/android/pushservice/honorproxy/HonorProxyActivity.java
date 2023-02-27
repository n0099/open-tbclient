package com.baidu.android.pushservice.honorproxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.pushservice.n.c;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class HonorProxyActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1371973183, "Lcom/baidu/android/pushservice/honorproxy/HonorProxyActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1371973183, "Lcom/baidu/android/pushservice/honorproxy/HonorProxyActivity;");
        }
    }

    public HonorProxyActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                Intent intent = getIntent();
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("msgid");
                    String stringExtra2 = intent.getStringExtra("hnsigninfo");
                    String stringExtra3 = intent.getStringExtra("custom_content");
                    String stringExtra4 = intent.getStringExtra("pkg_content");
                    if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                        Intent intent2 = new Intent("com.baidu.android.pushservice.action.HONOR_CLICK");
                        intent2.putExtra("hn_notification_sign", stringExtra2);
                        intent2.putExtra("hn_notification_msg_id", stringExtra);
                        intent2.putExtra("hn_notification_pkg_content", stringExtra4);
                        intent2.putExtra("extra_extra_custom_content", stringExtra3);
                        Utility.a(intent2, getApplicationContext());
                        c.a().a(this, false, 1, stringExtra3);
                    }
                }
            } catch (Exception unused) {
            }
            finish();
        }
    }
}
