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
/* loaded from: classes9.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f32781b;

    /* renamed from: c  reason: collision with root package name */
    public String f32782c;

    /* renamed from: d  reason: collision with root package name */
    public String f32783d;

    /* renamed from: e  reason: collision with root package name */
    public String f32784e;

    /* renamed from: f  reason: collision with root package name */
    public String f32785f;

    /* renamed from: g  reason: collision with root package name */
    public String f32786g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32787h;

    /* renamed from: i  reason: collision with root package name */
    public String f32788i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f32789j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f32790k;

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
        this.f32781b = "";
        this.f32782c = "";
        this.f32783d = "";
        this.f32784e = "";
        this.f32785f = "";
        this.f32786g = "";
        this.f32787h = false;
        this.f32788i = "";
        this.f32789j = true;
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
        this.f32781b = "";
        this.f32782c = "";
        this.f32783d = "";
        this.f32784e = "";
        this.f32785f = "";
        this.f32786g = "";
        this.f32787h = false;
        this.f32788i = "";
        this.f32789j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f32783d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f32783d)) {
            this.f32783d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f32782c = intent.getStringExtra("access_token");
        this.f32786g = intent.getStringExtra("secret_key");
        this.a = intent.getStringExtra("method");
        this.f32781b = intent.getStringExtra("method_type");
        this.f32784e = intent.getStringExtra("appid");
        this.f32787h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.f32788i = intent.getStringExtra("push_proxy");
        this.f32789j = intent.getBooleanExtra("should_notify_user", true);
        this.f32790k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "method=" + this.a + ", accessToken=" + this.f32782c + ", packageName=" + this.f32783d + ", appId=" + this.f32784e + ", userId=" + this.f32785f;
        }
        return (String) invokeV.objValue;
    }
}
