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
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f24700b;

    /* renamed from: c  reason: collision with root package name */
    public String f24701c;

    /* renamed from: d  reason: collision with root package name */
    public String f24702d;

    /* renamed from: e  reason: collision with root package name */
    public String f24703e;

    /* renamed from: f  reason: collision with root package name */
    public String f24704f;

    /* renamed from: g  reason: collision with root package name */
    public String f24705g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24706h;
    public String i;
    public boolean j;
    public boolean k;

    public i() {
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
        this.a = "";
        this.f24700b = "";
        this.f24701c = "";
        this.f24702d = "";
        this.f24703e = "";
        this.f24704f = "";
        this.f24705g = "";
        this.f24706h = false;
        this.i = "";
        this.j = true;
    }

    public i(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {intent};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.f24700b = "";
        this.f24701c = "";
        this.f24702d = "";
        this.f24703e = "";
        this.f24704f = "";
        this.f24705g = "";
        this.f24706h = false;
        this.i = "";
        this.j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f24702d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f24702d)) {
            this.f24702d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f24701c = intent.getStringExtra("access_token");
        this.f24705g = intent.getStringExtra("secret_key");
        this.a = intent.getStringExtra("method");
        this.f24700b = intent.getStringExtra("method_type");
        this.f24703e = intent.getStringExtra("appid");
        this.f24706h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.i = intent.getStringExtra("push_proxy");
        this.j = intent.getBooleanExtra("should_notify_user", true);
        this.k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "method=" + this.a + ", accessToken=" + this.f24701c + ", packageName=" + this.f24702d + ", appId=" + this.f24703e + ", userId=" + this.f24704f;
        }
        return (String) invokeV.objValue;
    }
}
