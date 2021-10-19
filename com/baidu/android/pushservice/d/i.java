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
    public String f37219a;

    /* renamed from: b  reason: collision with root package name */
    public String f37220b;

    /* renamed from: c  reason: collision with root package name */
    public String f37221c;

    /* renamed from: d  reason: collision with root package name */
    public String f37222d;

    /* renamed from: e  reason: collision with root package name */
    public String f37223e;

    /* renamed from: f  reason: collision with root package name */
    public String f37224f;

    /* renamed from: g  reason: collision with root package name */
    public String f37225g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f37226h;

    /* renamed from: i  reason: collision with root package name */
    public String f37227i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f37228j;
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
        this.f37219a = "";
        this.f37220b = "";
        this.f37221c = "";
        this.f37222d = "";
        this.f37223e = "";
        this.f37224f = "";
        this.f37225g = "";
        this.f37226h = false;
        this.f37227i = "";
        this.f37228j = true;
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
        this.f37219a = "";
        this.f37220b = "";
        this.f37221c = "";
        this.f37222d = "";
        this.f37223e = "";
        this.f37224f = "";
        this.f37225g = "";
        this.f37226h = false;
        this.f37227i = "";
        this.f37228j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f37222d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f37222d)) {
            this.f37222d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f37221c = intent.getStringExtra("access_token");
        this.f37225g = intent.getStringExtra("secret_key");
        this.f37219a = intent.getStringExtra("method");
        this.f37220b = intent.getStringExtra("method_type");
        this.f37223e = intent.getStringExtra("appid");
        this.f37226h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.f37227i = intent.getStringExtra("push_proxy");
        this.f37228j = intent.getBooleanExtra("should_notify_user", true);
        this.k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "method=" + this.f37219a + ", accessToken=" + this.f37221c + ", packageName=" + this.f37222d + ", appId=" + this.f37223e + ", userId=" + this.f37224f;
        }
        return (String) invokeV.objValue;
    }
}
