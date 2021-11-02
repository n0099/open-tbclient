package com.baidu.android.pushservice.d;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
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
    public String f35260a;

    /* renamed from: b  reason: collision with root package name */
    public String f35261b;

    /* renamed from: c  reason: collision with root package name */
    public String f35262c;

    /* renamed from: d  reason: collision with root package name */
    public String f35263d;

    /* renamed from: e  reason: collision with root package name */
    public String f35264e;

    /* renamed from: f  reason: collision with root package name */
    public String f35265f;

    /* renamed from: g  reason: collision with root package name */
    public String f35266g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f35267h;

    /* renamed from: i  reason: collision with root package name */
    public String f35268i;
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
        this.f35260a = "";
        this.f35261b = "";
        this.f35262c = "";
        this.f35263d = "";
        this.f35264e = "";
        this.f35265f = "";
        this.f35266g = "";
        this.f35267h = false;
        this.f35268i = "";
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
        this.f35260a = "";
        this.f35261b = "";
        this.f35262c = "";
        this.f35263d = "";
        this.f35264e = "";
        this.f35265f = "";
        this.f35266g = "";
        this.f35267h = false;
        this.f35268i = "";
        this.j = true;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("app");
        if (pendingIntent != null) {
            this.f35263d = pendingIntent.getTargetPackage();
        }
        if (TextUtils.isEmpty(this.f35263d)) {
            this.f35263d = intent.getStringExtra("pkg_name");
        }
        this.f35262c = intent.getStringExtra("access_token");
        this.f35266g = intent.getStringExtra("secret_key");
        this.f35260a = intent.getStringExtra("method");
        this.f35261b = intent.getStringExtra("method_type");
        this.f35264e = intent.getStringExtra("appid");
        this.f35267h = intent.getBooleanExtra("bd_push_extra_is_baidu_app", false);
        this.f35268i = intent.getStringExtra("push_proxy");
        this.j = intent.getBooleanExtra("should_notify_user", true);
        this.k = intent.getBooleanExtra("ignore_token", false);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "method=" + this.f35260a + ", accessToken=" + this.f35262c + ", packageName=" + this.f35263d + ", appId=" + this.f35264e + ", userId=" + this.f35265f;
        }
        return (String) invokeV.objValue;
    }
}
