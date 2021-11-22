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
/* loaded from: classes6.dex */
public class H5PayActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.alipay.sdk.widget.c f34814a;

    /* renamed from: b  reason: collision with root package name */
    public String f34815b;

    /* renamed from: c  reason: collision with root package name */
    public String f34816c;

    /* renamed from: d  reason: collision with root package name */
    public String f34817d;

    /* renamed from: e  reason: collision with root package name */
    public String f34818e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34819f;

    /* renamed from: g  reason: collision with root package name */
    public String f34820g;

    /* renamed from: h  reason: collision with root package name */
    public WeakReference<com.alipay.sdk.sys.a> f34821h;

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
            Object obj = PayTask.f34846h;
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
                d.a((com.alipay.sdk.sys.a) l.a(this.f34821h), i2, i3, intent);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            com.alipay.sdk.widget.c cVar = this.f34814a;
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
                com.alipay.sdk.sys.a a2 = a.C1564a.a(getIntent());
                if (a2 == null) {
                    finish();
                    LogUtil.logActivity(this, "onCreate");
                    return;
                }
                this.f34821h = new WeakReference<>(a2);
                if (!com.alipay.sdk.data.a.u().s()) {
                    setRequestedOrientation(1);
                } else {
                    setRequestedOrientation(3);
                }
                try {
                    Bundle extras = getIntent().getExtras();
                    String string = extras.getString("url", null);
                    this.f34815b = string;
                    if (!l.d(string)) {
                        finish();
                        LogUtil.logActivity(this, "onCreate");
                        return;
                    }
                    this.f34817d = extras.getString("cookie", null);
                    this.f34816c = extras.getString("method", null);
                    this.f34818e = extras.getString("title", null);
                    this.f34820g = extras.getString("version", "v1");
                    this.f34819f = extras.getBoolean("backisexit", false);
                    try {
                        com.alipay.sdk.widget.d dVar = new com.alipay.sdk.widget.d(this, a2, this.f34820g);
                        setContentView(dVar);
                        dVar.a(this.f34818e, this.f34816c, this.f34819f);
                        dVar.a(this.f34815b, this.f34817d);
                        dVar.a(this.f34815b);
                        this.f34814a = dVar;
                        LogUtil.logActivity(this, "onCreate");
                    } catch (Throwable th) {
                        com.alipay.sdk.app.statistic.a.a(a2, "biz", "GetInstalledAppEx", th);
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
            com.alipay.sdk.widget.c cVar = this.f34814a;
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
                    com.alipay.sdk.app.statistic.a.a((com.alipay.sdk.sys.a) l.a(this.f34821h), "biz", com.alipay.sdk.app.statistic.b.F, th);
                } catch (Throwable unused) {
                }
            }
        }
    }
}
