package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.views.RoundWebview;
import com.baidu.sapi2.views.swipeback.SwipeBackLayout;
import d.a.a0.a.c;
import d.a.a0.a.e;
import d.a.a0.a.f;
/* loaded from: classes2.dex */
public class YouthStyleLoginActivity extends LoginActivity {
    public SwipeBackLayout H;
    public ImageView I;

    @Override // com.baidu.sapi2.activity.LoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
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
        this.I.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.sapi2.activity.YouthStyleLoginActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                YouthStyleLoginActivity.this.onClose();
            }
        });
    }
}
