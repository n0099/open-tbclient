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
    public String f3028a;

    /* renamed from: b  reason: collision with root package name */
    public String f3029b;

    /* renamed from: c  reason: collision with root package name */
    public String f3030c;

    /* renamed from: d  reason: collision with root package name */
    public String f3031d;

    /* renamed from: e  reason: collision with root package name */
    public String f3032e;

    /* renamed from: f  reason: collision with root package name */
    public String f3033f;

    /* renamed from: g  reason: collision with root package name */
    public String f3034g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3035h;

    /* renamed from: i  reason: collision with root package name */
    public String f3036i;
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
        this.f3028a = "";
        this.f3029b = "";
        this.f3030c = "";
        this.f3031d = "";
        this.f3032e = "";
        this.f3033f = "";
        this.f3034g = "";
        this.f3035h = false;
        this.f3036i = "";
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
        this.f3028a = "";
        this.f3029b = "";
        this.f3030c = "";
        this.f3031d = "";
        this.f3032e = "";
        this.f3033f = "";
        this.f3034g = "";
        this.f3035h = false;
        this.f3036i = "";
        this.j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f3031d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f3031d)) {
            this.f3031d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f3030c = intent.getStringExtra("access_token");
        this.f3034g = intent.getStringExtra("secret_key");
        this.f3028a = intent.getStringExtra("method");
        this.f3029b = intent.getStringExtra("method_type");
        this.f3032e = intent.getStringExtra("appid");
        this.f3035h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.f3036i = intent.getStringExtra("push_proxy");
        this.j = intent.getBooleanExtra("should_notify_user", true);
        this.k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "method=" + this.f3028a + ", accessToken=" + this.f3030c + ", packageName=" + this.f3031d + ", appId=" + this.f3032e + ", userId=" + this.f3033f;
        }
        return (String) invokeV.objValue;
    }
}
