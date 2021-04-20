package com.baidu.adp.plugin.proxy.activity;

import android.content.Intent;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdFragmentActivity;
import d.b.c.h.f.b;
/* loaded from: classes.dex */
public class ThirdFragmentActivityProxy extends FragmentActivityProxy {
    @Override // com.baidu.adp.plugin.proxy.activity.FragmentActivityProxy
    public void loadEntityActivity() {
        if (this.mEntity != null || super.isFinishing()) {
            return;
        }
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra(Plugin.INTENT_EXTRA_PACKAGE_NAME);
        if (!PluginCenter.getInstance().isLoaded(stringExtra)) {
            finish();
            BdLog.e("plugin not loaded. pluginname is " + stringExtra);
            return;
        }
        try {
            String stringExtra2 = intent.getStringExtra(Plugin.INTENT_EXTRA_ACTIVITY);
            if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
                Plugin plugin2 = PluginCenter.getInstance().getPlugin(stringExtra);
                PluginBaseThirdFragmentActivity pluginBaseThirdFragmentActivity = (PluginBaseThirdFragmentActivity) plugin2.getDexClassLoader().loadClass(stringExtra2).asSubclass(PluginBaseThirdFragmentActivity.class).newInstance();
                this.mEntity = pluginBaseThirdFragmentActivity;
                pluginBaseThirdFragmentActivity.setActivityProxy((b) this);
                this.mEntity.setPluginPackageName(stringExtra);
                setTheme(plugin2.getActivityThemeResource());
            } else {
                PluginBaseThirdFragmentActivity pluginBaseThirdFragmentActivity2 = (PluginBaseThirdFragmentActivity) PluginCenter.getInstance().getPlugin(stringExtra).getDexClassLoader().loadClass(stringExtra2).asSubclass(PluginBaseThirdFragmentActivity.class).newInstance();
                this.mEntity = pluginBaseThirdFragmentActivity2;
                pluginBaseThirdFragmentActivity2.setActivityProxy((b) this);
                this.mEntity.setPluginPackageName(stringExtra);
            }
        } catch (ClassNotFoundException e2) {
            BdLog.e(e2);
        } catch (IllegalAccessException e3) {
            BdLog.e(e3);
        } catch (InstantiationException e4) {
            BdLog.e(e4);
        } catch (Exception e5) {
            BdLog.e(e5);
        }
    }
}
