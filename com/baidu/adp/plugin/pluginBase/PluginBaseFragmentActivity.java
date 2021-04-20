package com.baidu.adp.plugin.pluginBase;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import d.b.c.h.f.a;
import d.b.c.h.f.b;
/* loaded from: classes.dex */
public class PluginBaseFragmentActivity extends PluginBaseActivity {
    public b mProxyActivity = null;

    public FragmentManager getSupportFragmentManager() {
        b bVar = this.mProxyActivity;
        if (bVar == null) {
            return null;
        }
        return bVar.proxyGetSupportFragmentManager();
    }

    public void onAttachFragment(Fragment fragment) {
        b bVar = this.mProxyActivity;
        if (bVar == null) {
            return;
        }
        bVar.proxyOnAttachFragment(fragment);
    }

    public void setActivityProxy(b bVar) {
        super.setActivityProxy((a) bVar);
        this.mProxyActivity = bVar;
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        b bVar = this.mProxyActivity;
        if (bVar == null) {
            return;
        }
        bVar.proxyStartActivityFromFragment(fragment, intent, i);
    }
}
