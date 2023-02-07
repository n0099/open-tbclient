package com.alipay.sdk.app;

import android.content.Intent;
import android.net.Uri;
import com.alipay.sdk.sys.a;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class H5OpenAuthActivity extends H5PayActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean i;

    @Override // com.alipay.sdk.app.H5PayActivity
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public H5OpenAuthActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
    }

    @Override // com.alipay.sdk.app.H5PayActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.i) {
                try {
                    com.alipay.sdk.sys.a a = a.C0012a.a(getIntent());
                    if (a != null) {
                        com.alipay.sdk.app.statistic.a.b(this, a, "", a.d);
                    }
                } catch (Throwable unused) {
                }
            }
            super.onDestroy();
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        String str;
        Uri uri;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) {
            try {
                com.alipay.sdk.sys.a a = a.C0012a.a(intent);
                try {
                    super.startActivity(intent);
                    if (intent != null) {
                        uri = intent.getData();
                    } else {
                        uri = null;
                    }
                    if (uri != null && uri.toString().startsWith("alipays://platformapi/startapp")) {
                        finish();
                    }
                } catch (Throwable th) {
                    if (intent != null && intent.getData() != null) {
                        str = intent.getData().toString();
                    } else {
                        str = StringUtil.NULL_STRING;
                    }
                    if (a != null) {
                        com.alipay.sdk.app.statistic.a.a(a, "biz", com.alipay.sdk.app.statistic.b.u0, th, str);
                    }
                    this.i = true;
                    throw th;
                }
            } catch (Throwable unused) {
                finish();
            }
        }
    }
}
