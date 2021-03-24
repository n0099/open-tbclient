package com.baidu.sapi2.social;

import android.os.Bundle;
import android.widget.RelativeLayout;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.activity.BaseActivity;
import d.b.a0.a.e;
import d.b.a0.a.f;
/* loaded from: classes2.dex */
public class SocialLoginBase extends BaseActivity implements NoProguard {
    public static WXInvokeCallback p;
    public RelativeLayout rootView;

    public static WXInvokeCallback getWXinvokeCallback() {
        return p;
    }

    public static void setWXLoginCallback(WXInvokeCallback wXInvokeCallback) {
        p = wXInvokeCallback;
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(f.layout_sapi_sdk_webview_with_title_bar);
        } catch (Throwable unused) {
        }
        this.rootView = (RelativeLayout) findViewById(e.root_view);
    }
}
