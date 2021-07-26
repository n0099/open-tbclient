package com.alipay.sdk.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import com.alipay.sdk.util.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.disk.DefaultDiskStorage;
/* loaded from: classes.dex */
public class H5PayActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.alipay.sdk.widget.g f1787a;

    /* renamed from: b  reason: collision with root package name */
    public String f1788b;

    /* renamed from: c  reason: collision with root package name */
    public String f1789c;

    /* renamed from: d  reason: collision with root package name */
    public String f1790d;

    /* renamed from: e  reason: collision with root package name */
    public String f1791e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1792f;

    /* renamed from: g  reason: collision with root package name */
    public String f1793g;

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
            Object obj = PayTask.f1805a;
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
            com.alipay.sdk.widget.g gVar = this.f1787a;
            if (gVar instanceof com.alipay.sdk.widget.h) {
                gVar.b();
                return;
            }
            if (!gVar.b()) {
                super.onBackPressed();
            }
            j.a(j.c());
            finish();
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
                Bundle extras = getIntent().getExtras();
                String string = extras.getString("url", null);
                this.f1788b = string;
                if (!n.f(string)) {
                    finish();
                    return;
                }
                this.f1790d = extras.getString("cookie", null);
                this.f1789c = extras.getString("method", null);
                this.f1791e = extras.getString("title", null);
                this.f1793g = extras.getString("version", "v1");
                this.f1792f = extras.getBoolean("backisexit", false);
                try {
                    if (DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX.equals(this.f1793g)) {
                        com.alipay.sdk.widget.j jVar = new com.alipay.sdk.widget.j(this);
                        setContentView(jVar);
                        jVar.a(this.f1791e, this.f1789c, this.f1792f);
                        jVar.a(this.f1788b);
                        this.f1787a = jVar;
                        return;
                    }
                    com.alipay.sdk.widget.h hVar = new com.alipay.sdk.widget.h(this);
                    this.f1787a = hVar;
                    setContentView(hVar);
                    this.f1787a.a(this.f1788b, this.f1790d);
                    this.f1787a.a(this.f1788b);
                } catch (Throwable th) {
                    com.alipay.sdk.app.statistic.a.a("biz", "GetInstalledAppEx", th);
                    finish();
                }
            } catch (Exception unused) {
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            this.f1787a.a();
        }
    }
}
