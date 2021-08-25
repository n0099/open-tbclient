package com.alipay.sdk.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.k;
import com.alipay.sdk.widget.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class H5PayActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.alipay.sdk.widget.c f35731a;

    /* renamed from: b  reason: collision with root package name */
    public String f35732b;

    /* renamed from: c  reason: collision with root package name */
    public String f35733c;

    /* renamed from: d  reason: collision with root package name */
    public String f35734d;

    /* renamed from: e  reason: collision with root package name */
    public String f35735e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35736f;

    /* renamed from: g  reason: collision with root package name */
    public String f35737g;

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
            } catch (Throwable th) {
                com.alipay.sdk.util.c.a(th);
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Object obj = PayTask.f35762a;
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
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            com.alipay.sdk.widget.c cVar = this.f35731a;
            if (cVar == null) {
                finish();
            } else if (cVar.c()) {
                cVar.b();
            } else {
                if (!cVar.b()) {
                    super.onBackPressed();
                }
                b.a(b.c());
                finish();
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            b();
            super.onCreate(bundle);
            try {
                com.alipay.sdk.sys.a a2 = a.C1565a.a(getIntent());
                if (a2 == null) {
                    finish();
                    return;
                }
                if (!com.alipay.sdk.data.a.p().b()) {
                    setRequestedOrientation(1);
                } else {
                    setRequestedOrientation(3);
                }
                try {
                    Bundle extras = getIntent().getExtras();
                    String string = extras.getString("url", null);
                    this.f35732b = string;
                    if (!k.d(string)) {
                        finish();
                        return;
                    }
                    this.f35734d = extras.getString("cookie", null);
                    this.f35733c = extras.getString("method", null);
                    this.f35735e = extras.getString("title", null);
                    this.f35737g = extras.getString("version", "v1");
                    this.f35736f = extras.getBoolean("backisexit", false);
                    try {
                        d dVar = new d(this, a2, this.f35737g);
                        setContentView(dVar);
                        dVar.a(this.f35735e, this.f35733c, this.f35736f);
                        dVar.a(this.f35732b, this.f35734d);
                        dVar.a(this.f35732b);
                        this.f35731a = dVar;
                    } catch (Throwable th) {
                        com.alipay.sdk.app.statistic.a.a(a2, "biz", "GetInstalledAppEx", th);
                        finish();
                    }
                } catch (Exception unused) {
                    finish();
                }
            } catch (Exception unused2) {
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            com.alipay.sdk.widget.c cVar = this.f35731a;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            try {
                super.setRequestedOrientation(i2);
            } catch (Throwable th) {
                try {
                    com.alipay.sdk.app.statistic.a.a(a.C1565a.a(getIntent()), "biz", com.alipay.sdk.app.statistic.b.v, th);
                } catch (Throwable unused) {
                }
            }
        }
    }
}
