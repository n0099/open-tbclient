package com.baidu.adp.plugin.proxy.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.base.j;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
/* loaded from: classes.dex */
public class LoadingActivity extends BdBaseActivity<LoadingActivity> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("intent_extra_package_name");
        if (PluginCenter.getInstance().isLoaded(stringExtra)) {
            finish();
            return;
        }
        bA(stringExtra);
        PluginPackageManager.ls().a(stringExtra, new a(this));
    }

    private void bA(String str) {
        try {
            LinearLayout linearLayout = new LinearLayout(getPageContext().getPageActivity());
            linearLayout.setGravity(17);
            ProgressBar progressBar = new ProgressBar(getPageContext().getPageActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            linearLayout.addView(progressBar, layoutParams);
            setContentView(linearLayout);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.k
    public j<LoadingActivity> getPageContext() {
        return null;
    }
}
