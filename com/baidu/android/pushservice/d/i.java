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
    public String f37215a;

    /* renamed from: b  reason: collision with root package name */
    public String f37216b;

    /* renamed from: c  reason: collision with root package name */
    public String f37217c;

    /* renamed from: d  reason: collision with root package name */
    public String f37218d;

    /* renamed from: e  reason: collision with root package name */
    public String f37219e;

    /* renamed from: f  reason: collision with root package name */
    public String f37220f;

    /* renamed from: g  reason: collision with root package name */
    public String f37221g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f37222h;

    /* renamed from: i  reason: collision with root package name */
    public String f37223i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f37224j;
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
        this.f37215a = "";
        this.f37216b = "";
        this.f37217c = "";
        this.f37218d = "";
        this.f37219e = "";
        this.f37220f = "";
        this.f37221g = "";
        this.f37222h = false;
        this.f37223i = "";
        this.f37224j = true;
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
        this.f37215a = "";
        this.f37216b = "";
        this.f37217c = "";
        this.f37218d = "";
        this.f37219e = "";
        this.f37220f = "";
        this.f37221g = "";
        this.f37222h = false;
        this.f37223i = "";
        this.f37224j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f37218d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f37218d)) {
            this.f37218d = intent.getStringExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME);
        }
        this.f37217c = intent.getStringExtra("access_token");
        this.f37221g = intent.getStringExtra("secret_key");
        this.f37215a = intent.getStringExtra("method");
        this.f37216b = intent.getStringExtra("method_type");
        this.f37219e = intent.getStringExtra("appid");
        this.f37222h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.f37223i = intent.getStringExtra("push_proxy");
        this.f37224j = intent.getBooleanExtra("should_notify_user", true);
        this.k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "method=" + this.f37215a + ", accessToken=" + this.f37217c + ", packageName=" + this.f37218d + ", appId=" + this.f37219e + ", userId=" + this.f37220f;
        }
        return (String) invokeV.objValue;
    }
}
