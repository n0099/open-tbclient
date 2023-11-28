package com.baidu.android.pushservice.viproxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.android.pushservice.z.c;
import com.baidu.android.pushservice.z.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ViNotifyActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ ViNotifyActivity g;

        public a(ViNotifyActivity viNotifyActivity, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viNotifyActivity, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = viNotifyActivity;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = this.c;
                if (!TextUtils.isEmpty(str)) {
                    str = Utility.a(Base64.decode(this.c.getBytes(), 2), "UTF-8");
                }
                String str2 = this.d;
                if (!TextUtils.isEmpty(str2)) {
                    str2 = Utility.a(Base64.decode(this.d.getBytes(), 2), "UTF-8");
                }
                this.g.a(this.e, str2, this.f, str);
            }
        }
    }

    public ViNotifyActivity() {
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

    public final void a(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, str4) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        Intent intent = new Intent("com.baidu.android.pushservice.action.VIVO_CLICK");
        intent.putExtra("vi_notification_sign", str3);
        intent.putExtra("vi_notification_msg_id", str);
        intent.putExtra("vi_notification_pkg_content", str2);
        intent.putExtra("extra_extra_custom_content", str4);
        Utility.a(intent, getApplicationContext());
        com.baidu.android.pushservice.n.c.a().a(getApplicationContext(), false, 1, str4);
    }

    public final void a(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4, str5) == null) {
            if (TextUtils.equals("1", str)) {
                e.a().a(new a(this, str5, str3, str2, str4));
            } else {
                a(str2, str3, str4, str5);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                Intent intent = getIntent();
                String stringExtra = intent.getStringExtra("msgid");
                String stringExtra2 = intent.getStringExtra("visigninfo");
                a(intent.getStringExtra("c"), stringExtra, intent.getStringExtra("pkg_content"), stringExtra2, intent.getStringExtra("custom_content"));
            } catch (Exception unused) {
            }
            finish();
        }
    }
}
