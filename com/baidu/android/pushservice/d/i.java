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
    public String f36942a;

    /* renamed from: b  reason: collision with root package name */
    public String f36943b;

    /* renamed from: c  reason: collision with root package name */
    public String f36944c;

    /* renamed from: d  reason: collision with root package name */
    public String f36945d;

    /* renamed from: e  reason: collision with root package name */
    public String f36946e;

    /* renamed from: f  reason: collision with root package name */
    public String f36947f;

    /* renamed from: g  reason: collision with root package name */
    public String f36948g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36949h;

    /* renamed from: i  reason: collision with root package name */
    public String f36950i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f36951j;
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
        this.f36942a = "";
        this.f36943b = "";
        this.f36944c = "";
        this.f36945d = "";
        this.f36946e = "";
        this.f36947f = "";
        this.f36948g = "";
        this.f36949h = false;
        this.f36950i = "";
        this.f36951j = true;
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
        this.f36942a = "";
        this.f36943b = "";
        this.f36944c = "";
        this.f36945d = "";
        this.f36946e = "";
        this.f36947f = "";
        this.f36948g = "";
        this.f36949h = false;
        this.f36950i = "";
        this.f36951j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f36945d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f36945d)) {
            this.f36945d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f36944c = intent.getStringExtra("access_token");
        this.f36948g = intent.getStringExtra("secret_key");
        this.f36942a = intent.getStringExtra("method");
        this.f36943b = intent.getStringExtra("method_type");
        this.f36946e = intent.getStringExtra("appid");
        this.f36949h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.f36950i = intent.getStringExtra("push_proxy");
        this.f36951j = intent.getBooleanExtra("should_notify_user", true);
        this.k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "method=" + this.f36942a + ", accessToken=" + this.f36944c + ", packageName=" + this.f36945d + ", appId=" + this.f36946e + ", userId=" + this.f36947f;
        }
        return (String) invokeV.objValue;
    }
}
