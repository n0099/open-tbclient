package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import b.a.p0.a.v2.q0;
import b.a.p0.b.f;
import b.a.p0.b.g;
import b.a.p0.b.h;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.bdprivate.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class LoginServiceAgreementActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_URL = "url";
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppActionBar mActionBar;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LoginServiceAgreementActivity f44399e;

        public a(LoginServiceAgreementActivity loginServiceAgreementActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loginServiceAgreementActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44399e = loginServiceAgreementActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f44399e.finish();
            }
        }
    }

    public LoginServiceAgreementActivity() {
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

    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            int Z = q0.Z(this);
            super.onCreate(bundle);
            q0.g(this, Z);
            Intent intent = getIntent();
            if (intent == null) {
                finish();
                return;
            }
            Bundle extras = intent.getExtras();
            setContentView(g.activity_login_service_agreement);
            NgWebView ngWebView = (NgWebView) findViewById(f.aiapps_webView_container);
            if (extras != null) {
                ngWebView.loadUrl(extras.getString("url"));
            }
            SwanAppActionBar swanAppActionBar = (SwanAppActionBar) findViewById(f.ai_apps_title_bar);
            this.mActionBar = swanAppActionBar;
            swanAppActionBar.setLeftBackViewVisibility(true);
            this.mActionBar.setLeftBackViewClickListener(new a(this));
            this.mActionBar.setTitle(h.swanapp_service_agreement);
            this.mActionBar.setRightZoneVisibility(false);
        }
    }
}
