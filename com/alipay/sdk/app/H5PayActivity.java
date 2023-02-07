package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class H5PayActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.alipay.sdk.widget.c a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public String g;
    public WeakReference<com.alipay.sdk.sys.a> h;

    public H5PayActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            Object obj = PayTask.h;
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
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i == 1010) {
                d.a((com.alipay.sdk.sys.a) l.a(this.h), i, i2, intent);
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
    public void setRequestedOrientation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            try {
                super.setRequestedOrientation(i);
            } catch (Throwable th) {
                try {
                    com.alipay.sdk.app.statistic.a.a((com.alipay.sdk.sys.a) l.a(this.h), "biz", com.alipay.sdk.app.statistic.b.F, th);
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            b();
            super.onCreate(bundle);
            try {
                com.alipay.sdk.sys.a a = a.C0012a.a(getIntent());
                if (a == null) {
                    finish();
                    return;
                }
                this.h = new WeakReference<>(a);
                if (!com.alipay.sdk.data.a.u().s()) {
                    setRequestedOrientation(1);
                } else {
                    setRequestedOrientation(3);
                }
                try {
                    Bundle extras = getIntent().getExtras();
                    String string = extras.getString("url", null);
                    this.b = string;
                    if (!l.d(string)) {
                        finish();
                        return;
                    }
                    this.d = extras.getString("cookie", null);
                    this.c = extras.getString("method", null);
                    this.e = extras.getString("title", null);
                    this.g = extras.getString("version", "v1");
                    this.f = extras.getBoolean("backisexit", false);
                    try {
                        com.alipay.sdk.widget.d dVar = new com.alipay.sdk.widget.d(this, a, this.g);
                        setContentView(dVar);
                        dVar.a(this.e, this.c, this.f);
                        dVar.a(this.b, this.d);
                        dVar.a(this.b);
                        this.a = dVar;
                    } catch (Throwable th) {
                        com.alipay.sdk.app.statistic.a.a(a, "biz", "GetInstalledAppEx", th);
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
}
