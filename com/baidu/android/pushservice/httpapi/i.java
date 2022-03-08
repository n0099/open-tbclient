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
    public String f30856b;

    /* renamed from: c  reason: collision with root package name */
    public String f30857c;

    /* renamed from: d  reason: collision with root package name */
    public String f30858d;

    /* renamed from: e  reason: collision with root package name */
    public String f30859e;

    /* renamed from: f  reason: collision with root package name */
    public String f30860f;

    /* renamed from: g  reason: collision with root package name */
    public String f30861g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f30862h;

    /* renamed from: i  reason: collision with root package name */
    public String f30863i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f30864j;
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
        this.f30856b = "";
        this.f30857c = "";
        this.f30858d = "";
        this.f30859e = "";
        this.f30860f = "";
        this.f30861g = "";
        this.f30862h = false;
        this.f30863i = "";
        this.f30864j = true;
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
        this.f30856b = "";
        this.f30857c = "";
        this.f30858d = "";
        this.f30859e = "";
        this.f30860f = "";
        this.f30861g = "";
        this.f30862h = false;
        this.f30863i = "";
        this.f30864j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f30858d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f30858d)) {
            this.f30858d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f30857c = intent.getStringExtra("access_token");
        this.f30861g = intent.getStringExtra("secret_key");
        this.a = intent.getStringExtra("method");
        this.f30856b = intent.getStringExtra("method_type");
        this.f30859e = intent.getStringExtra("appid");
        this.f30862h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.f30863i = intent.getStringExtra("push_proxy");
        this.f30864j = intent.getBooleanExtra("should_notify_user", true);
        this.k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "method=" + this.a + ", accessToken=" + this.f30857c + ", packageName=" + this.f30858d + ", appId=" + this.f30859e + ", userId=" + this.f30860f;
        }
        return (String) invokeV.objValue;
    }
}
