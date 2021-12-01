package com.baidu.android.pushservice.d;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f32411b;

    /* renamed from: c  reason: collision with root package name */
    public String f32412c;

    /* renamed from: d  reason: collision with root package name */
    public String f32413d;

    /* renamed from: e  reason: collision with root package name */
    public String f32414e;

    /* renamed from: f  reason: collision with root package name */
    public String f32415f;

    /* renamed from: g  reason: collision with root package name */
    public String f32416g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32417h;

    /* renamed from: i  reason: collision with root package name */
    public String f32418i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f32419j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f32420k;

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
        this.f32411b = "";
        this.f32412c = "";
        this.f32413d = "";
        this.f32414e = "";
        this.f32415f = "";
        this.f32416g = "";
        this.f32417h = false;
        this.f32418i = "";
        this.f32419j = true;
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
        this.f32411b = "";
        this.f32412c = "";
        this.f32413d = "";
        this.f32414e = "";
        this.f32415f = "";
        this.f32416g = "";
        this.f32417h = false;
        this.f32418i = "";
        this.f32419j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f32413d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f32413d)) {
            this.f32413d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f32412c = intent.getStringExtra("access_token");
        this.f32416g = intent.getStringExtra("secret_key");
        this.a = intent.getStringExtra("method");
        this.f32411b = intent.getStringExtra("method_type");
        this.f32414e = intent.getStringExtra("appid");
        this.f32417h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.f32418i = intent.getStringExtra("push_proxy");
        this.f32419j = intent.getBooleanExtra("should_notify_user", true);
        this.f32420k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "method=" + this.a + ", accessToken=" + this.f32412c + ", packageName=" + this.f32413d + ", appId=" + this.f32414e + ", userId=" + this.f32415f;
        }
        return (String) invokeV.objValue;
    }
}
