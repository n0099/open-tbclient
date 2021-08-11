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
/* loaded from: classes4.dex */
public class H5OpenAuthActivity extends H5PayActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f35624a;

    public H5OpenAuthActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35624a = false;
    }

    @Override // com.alipay.sdk.app.H5PayActivity
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.alipay.sdk.app.H5PayActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f35624a) {
                try {
                    com.alipay.sdk.sys.a a2 = a.C1561a.a(getIntent());
                    if (a2 != null) {
                        com.alipay.sdk.app.statistic.a.b(this, a2, "", a2.q);
                    }
                } catch (Throwable unused) {
                }
            }
            super.onDestroy();
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) {
            try {
                com.alipay.sdk.sys.a a2 = a.C1561a.a(intent);
                if (a2 == null) {
                    finish();
                    return;
                }
                try {
                    super.startActivity(intent);
                    Uri data = intent != null ? intent.getData() : null;
                    if (data == null || !data.toString().startsWith("alipays://platformapi/startapp")) {
                        return;
                    }
                    finish();
                } catch (Throwable th) {
                    com.alipay.sdk.app.statistic.a.a(a2, "biz", com.alipay.sdk.app.statistic.b.ak, th, (intent == null || intent.getData() == null) ? StringUtil.NULL_STRING : intent.getData().toString());
                    this.f35624a = true;
                    throw th;
                }
            } catch (Throwable unused) {
                finish();
            }
        }
    }
}
