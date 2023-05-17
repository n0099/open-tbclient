package com.baidu.sapi2.social;

import android.os.Bundle;
import android.widget.RelativeLayout;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class SocialLoginBase extends BaseActivity implements NoProguard {
    public static WXInvokeCallback t;
    public RelativeLayout rootView;

    public static WXInvokeCallback getWXinvokeCallback() {
        return t;
    }

    public static void setWXLoginCallback(WXInvokeCallback wXInvokeCallback) {
        t = wXInvokeCallback;
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
        } catch (Throwable unused) {
        }
        this.rootView = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091ea2);
    }
}
