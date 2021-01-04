package com.baidu.adp.plugin.pluginBase;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.adp.plugin.a.a;
import com.baidu.adp.plugin.a.b;
/* loaded from: classes.dex */
public class PluginBaseFragmentActivity extends PluginBaseActivity {
    private b mProxyActivity = null;

    public FragmentManager getSupportFragmentManager() {
        if (this.mProxyActivity == null) {
            return null;
        }
        return this.mProxyActivity.proxyGetSupportFragmentManager();
    }

    public void setActivityProxy(b bVar) {
        super.setActivityProxy((a) bVar);
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
