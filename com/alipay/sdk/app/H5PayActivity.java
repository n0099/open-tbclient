package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class H5PayActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.alipay.sdk.widget.c a;

    /* renamed from: b  reason: collision with root package name */
    public String f30772b;

    /* renamed from: c  reason: collision with root package name */
    public String f30773c;

    /* renamed from: d  reason: collision with root package name */
    public String f30774d;

    /* renamed from: e  reason: collision with root package name */
    public String f30775e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30776f;

    /* renamed from: g  reason: collision with root package name */
    public String f30777g;

    /* renamed from: h  reason: collision with root package name */
    public WeakReference<com.alipay.sdk.sys.a> f30778h;

    public H5PayActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            try {
                super.requestWindowFeature(1);
                getWindow().addFlags(8192);
            } catch (Throwable th) {
                com.alipay.sdk.util.c.a(th);
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Object obj = PayTask.f30797h;
            synchronized (obj) {
                try {
                    obj.notify();
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            super.finish();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 1010) {
                d.a((com.alipay.sdk.sys.a) l.a(this.f30778h), i2, i3, intent);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            com.alipay.sdk.widget.c cVar = this.a;
            if (cVar == null) {
                finish();
            } else if (cVar.a()) {
                cVar.b();
            } else {
                if (!cVar.b()) {
                    super.onBackPressed();
                }
                b.a(b.a());
                finish();
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            b();
            super.onCreate(bundle);
            try {
                com.alipay.sdk.sys.a a = a.C1703a.a(getIntent());
                if (a == null) {
                    finish();
                    LogUtil.logActivity(this, "onCreate");
                    return;
                }
                this.f30778h = new WeakReference<>(a);
                if (!com.alipay.sdk.data.a.u().s()) {
                    setRequestedOrientation(1);
                } else {
                    setRequestedOrientation(3);
                }
                try {
                    Bundle extras = getIntent().getExtras();
                    String string = extras.getString("url", null);
                    this.f30772b = string;
                    if (!l.d(string)) {
                        finish();
                        LogUtil.logActivity(this, "onCreate");
                        return;
                    }
                    this.f30774d = extras.getString("cookie", null);
                    this.f30773c = extras.getString("method", null);
                    this.f30775e = extras.getString("title", null);
                    this.f30777g = extras.getString("version", "v1");
                    this.f30776f = extras.getBoolean("backisexit", false);
                    try {
                        com.alipay.sdk.widget.d dVar = new com.alipay.sdk.widget.d(this, a, this.f30777g);
                        setContentView(dVar);
                        dVar.a(this.f30775e, this.f30773c, this.f30776f);
                        dVar.a(this.f30772b, this.f30774d);
                        dVar.a(this.f30772b);
                        this.a = dVar;
                        LogUtil.logActivity(this, "onCreate");
                    } catch (Throwable th) {
                        com.alipay.sdk.app.statistic.a.a(a, "biz", "GetInstalledAppEx", th);
                        finish();
                        LogUtil.logActivity(this, "onCreate");
                    }
                } catch (Exception unused) {
                    finish();
                    LogUtil.logActivity(this, "onCreate");
                }
            } catch (Exception unused2) {
                finish();
                LogUtil.logActivity(this, "onCreate");
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            com.alipay.sdk.widget.c cVar = this.a;
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            try {
                super.setRequestedOrientation(i2);
            } catch (Throwable th) {
                try {
                    com.alipay.sdk.app.statistic.a.a((com.alipay.sdk.sys.a) l.a(this.f30778h), "biz", com.alipay.sdk.app.statistic.b.F, th);
                } catch (Throwable unused) {
                }
            }
        }
    }
}
