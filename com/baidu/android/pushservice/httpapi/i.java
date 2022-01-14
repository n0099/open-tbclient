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
    public String f32219b;

    /* renamed from: c  reason: collision with root package name */
    public String f32220c;

    /* renamed from: d  reason: collision with root package name */
    public String f32221d;

    /* renamed from: e  reason: collision with root package name */
    public String f32222e;

    /* renamed from: f  reason: collision with root package name */
    public String f32223f;

    /* renamed from: g  reason: collision with root package name */
    public String f32224g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32225h;

    /* renamed from: i  reason: collision with root package name */
    public String f32226i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f32227j;
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
        this.f32219b = "";
        this.f32220c = "";
        this.f32221d = "";
        this.f32222e = "";
        this.f32223f = "";
        this.f32224g = "";
        this.f32225h = false;
        this.f32226i = "";
        this.f32227j = true;
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
        this.f32219b = "";
        this.f32220c = "";
        this.f32221d = "";
        this.f32222e = "";
        this.f32223f = "";
        this.f32224g = "";
        this.f32225h = false;
        this.f32226i = "";
        this.f32227j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f32221d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f32221d)) {
            this.f32221d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f32220c = intent.getStringExtra("access_token");
        this.f32224g = intent.getStringExtra("secret_key");
        this.a = intent.getStringExtra("method");
        this.f32219b = intent.getStringExtra("method_type");
        this.f32222e = intent.getStringExtra("appid");
        this.f32225h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.f32226i = intent.getStringExtra("push_proxy");
        this.f32227j = intent.getBooleanExtra("should_notify_user", true);
        this.k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "method=" + this.a + ", accessToken=" + this.f32220c + ", packageName=" + this.f32221d + ", appId=" + this.f32222e + ", userId=" + this.f32223f;
        }
        return (String) invokeV.objValue;
    }
}
