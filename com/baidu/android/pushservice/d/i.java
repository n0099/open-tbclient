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
/* loaded from: classes6.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f36089a;

    /* renamed from: b  reason: collision with root package name */
    public String f36090b;

    /* renamed from: c  reason: collision with root package name */
    public String f36091c;

    /* renamed from: d  reason: collision with root package name */
    public String f36092d;

    /* renamed from: e  reason: collision with root package name */
    public String f36093e;

    /* renamed from: f  reason: collision with root package name */
    public String f36094f;

    /* renamed from: g  reason: collision with root package name */
    public String f36095g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36096h;

    /* renamed from: i  reason: collision with root package name */
    public String f36097i;
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
        this.f36089a = "";
        this.f36090b = "";
        this.f36091c = "";
        this.f36092d = "";
        this.f36093e = "";
        this.f36094f = "";
        this.f36095g = "";
        this.f36096h = false;
        this.f36097i = "";
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
        this.f36089a = "";
        this.f36090b = "";
        this.f36091c = "";
        this.f36092d = "";
        this.f36093e = "";
        this.f36094f = "";
        this.f36095g = "";
        this.f36096h = false;
        this.f36097i = "";
        this.j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f36092d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f36092d)) {
            this.f36092d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f36091c = intent.getStringExtra("access_token");
        this.f36095g = intent.getStringExtra("secret_key");
        this.f36089a = intent.getStringExtra("method");
        this.f36090b = intent.getStringExtra("method_type");
        this.f36093e = intent.getStringExtra("appid");
        this.f36096h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.f36097i = intent.getStringExtra("push_proxy");
        this.j = intent.getBooleanExtra("should_notify_user", true);
        this.k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "method=" + this.f36089a + ", accessToken=" + this.f36091c + ", packageName=" + this.f36092d + ", appId=" + this.f36093e + ", userId=" + this.f36094f;
        }
        return (String) invokeV.objValue;
    }
}
