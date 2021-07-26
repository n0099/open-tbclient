package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.views.RoundWebview;
import com.baidu.sapi2.views.swipeback.SwipeBackLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c0.a.c;
import d.a.c0.a.e;
import d.a.c0.a.f;
/* loaded from: classes2.dex */
public class YouthStyleLoginActivity extends LoginActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwipeBackLayout H;
    public ImageView I;

    public YouthStyleLoginActivity() {
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

    @Override // com.baidu.sapi2.activity.LoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            setContentView(f.layout_sapi_sdk_youth_style_login_activity);
            this.mNeedSetContentView = false;
            super.onCreate(bundle);
            this.H = (SwipeBackLayout) findViewById(e.sbl_root_view);
            this.I = (ImageView) findViewById(e.iv_pick_up_arrow);
            this.H.setDirectionMode(4);
            ((LoginActivity) this).sapiWebView.setOverScrollMode(2);
            SapiWebView sapiWebView = ((LoginActivity) this).sapiWebView;
            if (sapiWebView instanceof RoundWebview) {
                ((RoundWebview) sapiWebView).a(getResources().getDimension(c.sapi_sdk_youth_style_webview_radius), getResources().getDimension(c.sapi_sdk_youth_style_webview_radius), 0.0f, 0.0f);
            }
            this.I.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.sapi2.activity.YouthStyleLoginActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ YouthStyleLoginActivity f9919a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f9919a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f9919a.onClose();
                    }
                }
            });
        }
    }
}
