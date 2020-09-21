package com.baidu.searchbox.ugc.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.publisher.base.R;
import com.baidu.searchbox.ugc.utils.SystemBarTintManager;
/* loaded from: classes24.dex */
public class PreviewBaseActivity extends BaseActivity {
    protected SystemBarTintManager tintManager;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.appframework.BaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 19) {
            setTranslucentStatus(true);
        }
        this.tintManager = new SystemBarTintManager(this);
        this.tintManager.setStatusBarTintEnabled(true);
        this.tintManager.setStatusBarTintResource(R.color.publisher_transparent);
        setEnableImmersion(false);
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean z) {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags |= 67108864;
        } else {
            attributes.flags &= -67108865;
        }
        window.setAttributes(attributes);
    }
}
