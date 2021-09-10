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
/* loaded from: classes4.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f37167a;

    /* renamed from: b  reason: collision with root package name */
    public String f37168b;

    /* renamed from: c  reason: collision with root package name */
    public String f37169c;

    /* renamed from: d  reason: collision with root package name */
    public String f37170d;

    /* renamed from: e  reason: collision with root package name */
    public String f37171e;

    /* renamed from: f  reason: collision with root package name */
    public String f37172f;

    /* renamed from: g  reason: collision with root package name */
    public String f37173g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f37174h;

    /* renamed from: i  reason: collision with root package name */
    public String f37175i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f37176j;
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
        this.f37167a = "";
        this.f37168b = "";
        this.f37169c = "";
        this.f37170d = "";
        this.f37171e = "";
        this.f37172f = "";
        this.f37173g = "";
        this.f37174h = false;
        this.f37175i = "";
        this.f37176j = true;
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
        this.f37167a = "";
        this.f37168b = "";
        this.f37169c = "";
        this.f37170d = "";
        this.f37171e = "";
        this.f37172f = "";
        this.f37173g = "";
        this.f37174h = false;
        this.f37175i = "";
        this.f37176j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f37170d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f37170d)) {
            this.f37170d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f37169c = intent.getStringExtra("access_token");
        this.f37173g = intent.getStringExtra("secret_key");
        this.f37167a = intent.getStringExtra("method");
        this.f37168b = intent.getStringExtra("method_type");
        this.f37171e = intent.getStringExtra("appid");
        this.f37174h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.f37175i = intent.getStringExtra("push_proxy");
        this.f37176j = intent.getBooleanExtra("should_notify_user", true);
        this.k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "method=" + this.f37167a + ", accessToken=" + this.f37169c + ", packageName=" + this.f37170d + ", appId=" + this.f37171e + ", userId=" + this.f37172f;
        }
        return (String) invokeV.objValue;
    }
}
