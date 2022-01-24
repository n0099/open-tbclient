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
    public String f32247b;

    /* renamed from: c  reason: collision with root package name */
    public String f32248c;

    /* renamed from: d  reason: collision with root package name */
    public String f32249d;

    /* renamed from: e  reason: collision with root package name */
    public String f32250e;

    /* renamed from: f  reason: collision with root package name */
    public String f32251f;

    /* renamed from: g  reason: collision with root package name */
    public String f32252g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32253h;

    /* renamed from: i  reason: collision with root package name */
    public String f32254i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f32255j;
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
        this.f32247b = "";
        this.f32248c = "";
        this.f32249d = "";
        this.f32250e = "";
        this.f32251f = "";
        this.f32252g = "";
        this.f32253h = false;
        this.f32254i = "";
        this.f32255j = true;
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
        this.f32247b = "";
        this.f32248c = "";
        this.f32249d = "";
        this.f32250e = "";
        this.f32251f = "";
        this.f32252g = "";
        this.f32253h = false;
        this.f32254i = "";
        this.f32255j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f32249d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f32249d)) {
            this.f32249d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f32248c = intent.getStringExtra("access_token");
        this.f32252g = intent.getStringExtra("secret_key");
        this.a = intent.getStringExtra("method");
        this.f32247b = intent.getStringExtra("method_type");
        this.f32250e = intent.getStringExtra("appid");
        this.f32253h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.f32254i = intent.getStringExtra("push_proxy");
        this.f32255j = intent.getBooleanExtra("should_notify_user", true);
        this.k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "method=" + this.a + ", accessToken=" + this.f32248c + ", packageName=" + this.f32249d + ", appId=" + this.f32250e + ", userId=" + this.f32251f;
        }
        return (String) invokeV.objValue;
    }
}
