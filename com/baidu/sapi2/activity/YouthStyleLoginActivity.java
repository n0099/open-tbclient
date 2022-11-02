package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.views.RoundWebview;
import com.baidu.sapi2.views.swipeback.SwipeBackLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class YouthStyleLoginActivity extends LoginActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwipeBackLayout I;
    public ImageView J;

    public YouthStyleLoginActivity() {
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

    @Override // com.baidu.sapi2.activity.LoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d0516);
            this.mNeedSetContentView = false;
            super.onCreate(bundle);
            this.I = (SwipeBackLayout) findViewById(R.id.obfuscated_res_0x7f091dfd);
            this.J = (ImageView) findViewById(R.id.obfuscated_res_0x7f091050);
            this.I.setDirectionMode(4);
            ((LoginActivity) this).sapiWebView.setOverScrollMode(2);
            SapiWebView sapiWebView = ((LoginActivity) this).sapiWebView;
            if (sapiWebView instanceof RoundWebview) {
                ((RoundWebview) sapiWebView).a(getResources().getDimension(R.dimen.obfuscated_res_0x7f07062d), getResources().getDimension(R.dimen.obfuscated_res_0x7f07062d), 0.0f, 0.0f);
            }
            this.J.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.sapi2.activity.YouthStyleLoginActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ YouthStyleLoginActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.a.onClose();
                    }
                }
            });
        }
    }
}
