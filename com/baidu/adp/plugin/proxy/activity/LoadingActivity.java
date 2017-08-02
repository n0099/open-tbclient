package com.baidu.adp.plugin.proxy.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.install.b;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.util.c;
/* loaded from: classes.dex */
public class LoadingActivity extends BdBaseActivity<LoadingActivity> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(Plugin.INTENT_EXTRA_PACKAGE_NAME);
        if (PluginCenter.getInstance().isLoaded(stringExtra)) {
            finish();
            return;
        }
        initLoadingView(stringExtra);
        PluginPackageManager.ju().a(stringExtra, new b() { // from class: com.baidu.adp.plugin.proxy.activity.LoadingActivity.1
            @Override // com.baidu.adp.plugin.install.b
            public void z(String str, String str2) {
                LoadingActivity.this.showToast(PluginCenter.getInstance().getCommonErrorShowText());
            }

            @Override // com.baidu.adp.plugin.install.b
            public void aX(String str) {
                final Plugin plugin2 = PluginCenter.getInstance().getPlugin(str);
                if (plugin2 != null) {
                    plugin2.asyncInit(str, new c() { // from class: com.baidu.adp.plugin.proxy.activity.LoadingActivity.1.1
                        @Override // com.baidu.adp.plugin.util.c
                        public void a(Plugin.b bVar, String str2) {
                            Intent intent = new Intent(LoadingActivity.this.getIntent());
                            intent.setComponent(new ComponentName(str2, LoadingActivity.this.getIntent().getStringExtra(Plugin.INTENT_EXTRA_REDIRECT_ACTIVITY)));
                            plugin2.launchIntent(LoadingActivity.this.getPageContext().getContext(), intent);
                            LoadingActivity.this.finish();
                        }
                    });
                }
            }
        });
    }

    private void initLoadingView(String str) {
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

    @Override // com.baidu.adp.base.f
    public e<LoadingActivity> getPageContext() {
        return null;
    }
}
