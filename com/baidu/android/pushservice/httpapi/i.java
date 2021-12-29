package com.baidu.android.pushservice.httpapi;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f33276b;

    /* renamed from: c  reason: collision with root package name */
    public String f33277c;

    /* renamed from: d  reason: collision with root package name */
    public String f33278d;

    /* renamed from: e  reason: collision with root package name */
    public String f33279e;

    /* renamed from: f  reason: collision with root package name */
    public String f33280f;

    /* renamed from: g  reason: collision with root package name */
    public String f33281g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f33282h;

    /* renamed from: i  reason: collision with root package name */
    public String f33283i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f33284j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f33285k;

    public i() {
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
        this.a = "";
        this.f33276b = "";
        this.f33277c = "";
        this.f33278d = "";
        this.f33279e = "";
        this.f33280f = "";
        this.f33281g = "";
        this.f33282h = false;
        this.f33283i = "";
        this.f33284j = true;
    }

    public i(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {intent};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.f33276b = "";
        this.f33277c = "";
        this.f33278d = "";
        this.f33279e = "";
        this.f33280f = "";
        this.f33281g = "";
        this.f33282h = false;
        this.f33283i = "";
        this.f33284j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f33278d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f33278d)) {
            this.f33278d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f33277c = intent.getStringExtra("access_token");
        this.f33281g = intent.getStringExtra("secret_key");
        this.a = intent.getStringExtra("method");
        this.f33276b = intent.getStringExtra("method_type");
        this.f33279e = intent.getStringExtra("appid");
        this.f33282h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.f33283i = intent.getStringExtra("push_proxy");
        this.f33284j = intent.getBooleanExtra("should_notify_user", true);
        this.f33285k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "method=" + this.a + ", accessToken=" + this.f33277c + ", packageName=" + this.f33278d + ", appId=" + this.f33279e + ", userId=" + this.f33280f;
        }
        return (String) invokeV.objValue;
    }
}
