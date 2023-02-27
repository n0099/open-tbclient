package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.views.RoundWebview;
import com.baidu.sapi2.views.swipeback.SwipeBackLayout;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class YouthStyleLoginActivity extends LoginActivity {
    public SwipeBackLayout I;
    public ImageView J;

    @Override // com.baidu.sapi2.activity.LoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setContentView(R.layout.layout_sapi_sdk_youth_style_login_activity);
        this.mNeedSetContentView = false;
        super.onCreate(bundle);
        this.I = (SwipeBackLayout) findViewById(R.id.sbl_root_view);
        this.J = (ImageView) findViewById(R.id.iv_pick_up_arrow);
        this.I.setDirectionMode(4);
        ((LoginActivity) this).sapiWebView.setOverScrollMode(2);
        SapiWebView sapiWebView = ((LoginActivity) this).sapiWebView;
        if (sapiWebView instanceof RoundWebview) {
            ((RoundWebview) sapiWebView).a(getResources().getDimension(R.dimen.sapi_sdk_youth_style_webview_radius), getResources().getDimension(R.dimen.sapi_sdk_youth_style_webview_radius), 0.0f, 0.0f);
        }
        this.J.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.sapi2.activity.YouthStyleLoginActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                YouthStyleLoginActivity.this.onClose();
            }
        });
    }
}
