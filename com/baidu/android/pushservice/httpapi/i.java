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
/* loaded from: classes10.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f32453b;

    /* renamed from: c  reason: collision with root package name */
    public String f32454c;

    /* renamed from: d  reason: collision with root package name */
    public String f32455d;

    /* renamed from: e  reason: collision with root package name */
    public String f32456e;

    /* renamed from: f  reason: collision with root package name */
    public String f32457f;

    /* renamed from: g  reason: collision with root package name */
    public String f32458g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32459h;

    /* renamed from: i  reason: collision with root package name */
    public String f32460i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f32461j;
    public boolean k;

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
        this.f32453b = "";
        this.f32454c = "";
        this.f32455d = "";
        this.f32456e = "";
        this.f32457f = "";
        this.f32458g = "";
        this.f32459h = false;
        this.f32460i = "";
        this.f32461j = true;
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
        this.f32453b = "";
        this.f32454c = "";
        this.f32455d = "";
        this.f32456e = "";
        this.f32457f = "";
        this.f32458g = "";
        this.f32459h = false;
        this.f32460i = "";
        this.f32461j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f32455d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f32455d)) {
            this.f32455d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f32454c = intent.getStringExtra("access_token");
        this.f32458g = intent.getStringExtra("secret_key");
        this.a = intent.getStringExtra("method");
        this.f32453b = intent.getStringExtra("method_type");
        this.f32456e = intent.getStringExtra("appid");
        this.f32459h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.f32460i = intent.getStringExtra("push_proxy");
        this.f32461j = intent.getBooleanExtra("should_notify_user", true);
        this.k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "method=" + this.a + ", accessToken=" + this.f32454c + ", packageName=" + this.f32455d + ", appId=" + this.f32456e + ", userId=" + this.f32457f;
        }
        return (String) invokeV.objValue;
    }
}
