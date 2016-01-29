package com.baidu.adp.plugin.proxy.activity;

import android.content.Intent;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdFragmentActivity;
/* loaded from: classes.dex */
public class ThirdFragmentActivityProxy extends FragmentActivityProxy {
    @Override // com.baidu.adp.plugin.proxy.activity.FragmentActivityProxy
    public void loadEntityActivity() {
        if (this.mEntity == null && !super.isFinishing()) {
            Intent intent = getIntent();
            if (intent == null) {
                finish();
                return;
            }
            String stringExtra = intent.getStringExtra("intent_extra_package_name");
            if (!PluginCenter.getInstance().isLoaded(stringExtra)) {
                finish();
                BdLog.e("plugin not loaded. pluginname is " + stringExtra);
                return;
            }
            try {
                String stringExtra2 = intent.getStringExtra("intent_extra_activity");
                if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
                    com.baidu.adp.plugin.a plugin2 = PluginCenter.getInstance().getPlugin(stringExtra);
                    this.mEntity = (PluginBaseThirdFragmentActivity) plugin2.kD().loadClass(stringExtra2).asSubclass(PluginBaseThirdFragmentActivity.class).newInstance();
                    this.mEntity.setActivityProxy((com.baidu.adp.plugin.a.b) this);
                    this.mEntity.setPluginPackageName(stringExtra);
                    setTheme(plugin2.kG());
                } else {
                    this.mEntity = (PluginBaseThirdFragmentActivity) PluginCenter.getInstance().getPlugin(stringExtra).kD().loadClass(stringExtra2).asSubclass(PluginBaseThirdFragmentActivity.class).newInstance();
                    this.mEntity.setActivityProxy((com.baidu.adp.plugin.a.b) this);
                    this.mEntity.setPluginPackageName(stringExtra);
                }
            } catch (ClassNotFoundException e) {
                BdLog.e(e);
            } catch (IllegalAccessException e2) {
                BdLog.e(e2);
            } catch (InstantiationException e3) {
                BdLog.e(e3);
            } catch (Exception e4) {
                BdLog.e(e4);
            }
        }
    }
}
