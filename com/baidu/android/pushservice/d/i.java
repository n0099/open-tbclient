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
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f3057a;

    /* renamed from: b  reason: collision with root package name */
    public String f3058b;

    /* renamed from: c  reason: collision with root package name */
    public String f3059c;

    /* renamed from: d  reason: collision with root package name */
    public String f3060d;

    /* renamed from: e  reason: collision with root package name */
    public String f3061e;

    /* renamed from: f  reason: collision with root package name */
    public String f3062f;

    /* renamed from: g  reason: collision with root package name */
    public String f3063g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3064h;

    /* renamed from: i  reason: collision with root package name */
    public String f3065i;
    public boolean j;
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
        this.f3057a = "";
        this.f3058b = "";
        this.f3059c = "";
        this.f3060d = "";
        this.f3061e = "";
        this.f3062f = "";
        this.f3063g = "";
        this.f3064h = false;
        this.f3065i = "";
        this.j = true;
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
        this.f3057a = "";
        this.f3058b = "";
        this.f3059c = "";
        this.f3060d = "";
        this.f3061e = "";
        this.f3062f = "";
        this.f3063g = "";
        this.f3064h = false;
        this.f3065i = "";
        this.j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f3060d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f3060d)) {
            this.f3060d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f3059c = intent.getStringExtra("access_token");
        this.f3063g = intent.getStringExtra("secret_key");
        this.f3057a = intent.getStringExtra("method");
        this.f3058b = intent.getStringExtra("method_type");
        this.f3061e = intent.getStringExtra("appid");
        this.f3064h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.f3065i = intent.getStringExtra("push_proxy");
        this.j = intent.getBooleanExtra("should_notify_user", true);
        this.k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "method=" + this.f3057a + ", accessToken=" + this.f3059c + ", packageName=" + this.f3060d + ", appId=" + this.f3061e + ", userId=" + this.f3062f;
        }
        return (String) invokeV.objValue;
    }
}
