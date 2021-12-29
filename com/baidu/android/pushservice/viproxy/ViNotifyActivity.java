package com.baidu.android.pushservice.viproxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.pushservice.frequency.b;
import com.baidu.android.pushservice.g.c;
import com.baidu.android.pushservice.g.e;
import com.baidu.android.pushservice.i.m;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class ViNotifyActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ViNotifyActivity() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65538, this, str, str2, str3, str4) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        Intent intent = new Intent("com.baidu.android.pushservice.action.VIVO_CLICK");
        intent.putExtra("vi_notification_sign", str3);
        intent.putExtra("vi_notification_msg_id", str);
        intent.putExtra("vi_notification_pkg_content", str2);
        intent.putExtra("extra_extra_custom_content", str4);
        m.a(intent, getApplicationContext());
        b.a().a(getApplicationContext(), false, 1, str4);
    }

    private void a(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, this, str, str2, str3, str4, str5) == null) {
            if (TextUtils.equals("1", str)) {
                e.a().a(new c(this, str5, str3, str2, str4) { // from class: com.baidu.android.pushservice.viproxy.ViNotifyActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f33391b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ String f33392c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ String f33393d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ ViNotifyActivity f33394e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str5, str3, str2, str4};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f33394e = this;
                        this.a = str5;
                        this.f33391b = str3;
                        this.f33392c = str2;
                        this.f33393d = str4;
                    }

                    @Override // com.baidu.android.pushservice.g.c
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            String str6 = this.a;
                            if (!TextUtils.isEmpty(str6)) {
                                str6 = m.a(Base64.decode(this.a.getBytes(), 2), "UTF-8");
                            }
                            String str7 = this.f33391b;
                            if (!TextUtils.isEmpty(str7)) {
                                str7 = m.a(Base64.decode(this.f33391b.getBytes(), 2), "UTF-8");
                            }
                            this.f33394e.a(this.f33392c, str7, this.f33393d, str6);
                        }
                    }
                });
            } else {
                a(str2, str3, str4, str5);
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
                String stringExtra = intent.getStringExtra("msgid");
                String stringExtra2 = intent.getStringExtra("visigninfo");
                a(intent.getStringExtra("c"), stringExtra, intent.getStringExtra("pkg_content"), stringExtra2, intent.getStringExtra("custom_content"));
            } catch (Exception unused) {
            }
            finish();
            LogUtil.logActivity(this, "onCreate");
        }
    }
}
