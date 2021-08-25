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
    public String f37048a;

    /* renamed from: b  reason: collision with root package name */
    public String f37049b;

    /* renamed from: c  reason: collision with root package name */
    public String f37050c;

    /* renamed from: d  reason: collision with root package name */
    public String f37051d;

    /* renamed from: e  reason: collision with root package name */
    public String f37052e;

    /* renamed from: f  reason: collision with root package name */
    public String f37053f;

    /* renamed from: g  reason: collision with root package name */
    public String f37054g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f37055h;

    /* renamed from: i  reason: collision with root package name */
    public String f37056i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f37057j;
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
        this.f37048a = "";
        this.f37049b = "";
        this.f37050c = "";
        this.f37051d = "";
        this.f37052e = "";
        this.f37053f = "";
        this.f37054g = "";
        this.f37055h = false;
        this.f37056i = "";
        this.f37057j = true;
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
        this.f37048a = "";
        this.f37049b = "";
        this.f37050c = "";
        this.f37051d = "";
        this.f37052e = "";
        this.f37053f = "";
        this.f37054g = "";
        this.f37055h = false;
        this.f37056i = "";
        this.f37057j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f37051d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f37051d)) {
            this.f37051d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f37050c = intent.getStringExtra("access_token");
        this.f37054g = intent.getStringExtra("secret_key");
        this.f37048a = intent.getStringExtra("method");
        this.f37049b = intent.getStringExtra("method_type");
        this.f37052e = intent.getStringExtra("appid");
        this.f37055h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.f37056i = intent.getStringExtra("push_proxy");
        this.f37057j = intent.getBooleanExtra("should_notify_user", true);
        this.k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "method=" + this.f37048a + ", accessToken=" + this.f37050c + ", packageName=" + this.f37051d + ", appId=" + this.f37052e + ", userId=" + this.f37053f;
        }
        return (String) invokeV.objValue;
    }
}
