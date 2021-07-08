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
    public String f3031a;

    /* renamed from: b  reason: collision with root package name */
    public String f3032b;

    /* renamed from: c  reason: collision with root package name */
    public String f3033c;

    /* renamed from: d  reason: collision with root package name */
    public String f3034d;

    /* renamed from: e  reason: collision with root package name */
    public String f3035e;

    /* renamed from: f  reason: collision with root package name */
    public String f3036f;

    /* renamed from: g  reason: collision with root package name */
    public String f3037g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3038h;

    /* renamed from: i  reason: collision with root package name */
    public String f3039i;
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
        this.f3031a = "";
        this.f3032b = "";
        this.f3033c = "";
        this.f3034d = "";
        this.f3035e = "";
        this.f3036f = "";
        this.f3037g = "";
        this.f3038h = false;
        this.f3039i = "";
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
        this.f3031a = "";
        this.f3032b = "";
        this.f3033c = "";
        this.f3034d = "";
        this.f3035e = "";
        this.f3036f = "";
        this.f3037g = "";
        this.f3038h = false;
        this.f3039i = "";
        this.j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f3034d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f3034d)) {
            this.f3034d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f3033c = intent.getStringExtra("access_token");
        this.f3037g = intent.getStringExtra("secret_key");
        this.f3031a = intent.getStringExtra("method");
        this.f3032b = intent.getStringExtra("method_type");
        this.f3035e = intent.getStringExtra("appid");
        this.f3038h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.f3039i = intent.getStringExtra("push_proxy");
        this.j = intent.getBooleanExtra("should_notify_user", true);
        this.k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "method=" + this.f3031a + ", accessToken=" + this.f3033c + ", packageName=" + this.f3034d + ", appId=" + this.f3035e + ", userId=" + this.f3036f;
        }
        return (String) invokeV.objValue;
    }
}
