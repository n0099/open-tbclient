package com.baidu.adp.plugin.pluginBase;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
/* loaded from: classes.dex */
public class PluginBaseFragmentActivity extends PluginBaseActivity {
    private com.baidu.adp.plugin.a.b mProxyActivity = null;

    public FragmentManager getSupportFragmentManager() {
        if (this.mProxyActivity == null) {
            return null;
        }
        return this.mProxyActivity.proxyGetSupportFragmentManager();
    }

    public void setActivityProxy(com.baidu.adp.plugin.a.b bVar) {
        super.setActivityProxy((com.baidu.adp.plugin.a.a) bVar);
        this.mProxyActivity = bVar;
    }

    public void onAttachFragment(Fragment fragment) {
        if (this.mProxyActivity != null) {
            this.mProxyActivity.proxyOnAttachFragment(fragment);
        }
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        if (this.mProxyActivity != null) {
            this.mProxyActivity.proxyStartActivityFromFragment(fragment, intent, i);
        }
    }
}
