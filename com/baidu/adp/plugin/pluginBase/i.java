package com.baidu.adp.plugin.pluginBase;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.j;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
/* loaded from: classes.dex */
public class i extends ContextWrapper {
    private String mPackageName;
    private Resources.Theme mTheme;

    public i(Context context) {
        super(context);
        this.mPackageName = null;
        this.mTheme = null;
    }

    public void setPluginPackageName(String str) {
        Application application;
        this.mPackageName = str;
        if (!PluginCenter.getInstance().isLoaded(this.mPackageName)) {
            throw new RuntimeException("plugin is not loaded");
        }
        com.baidu.adp.plugin.a plugin2 = PluginCenter.getInstance().getPlugin(this.mPackageName);
        if (plugin2 != null && (application = plugin2.getApplication()) != null) {
            attachBaseContext(application.getBaseContext());
        } else {
            com.baidu.adp.plugin.b.a.lI().bl("PLUGIN_PCW_SPPN_NULL");
        }
    }

    public String getPluginPackageName() {
        return this.mPackageName;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        if (!PluginCenter.getInstance().isLoaded(this.mPackageName)) {
            throw new RuntimeException("plugin is not loaded");
        }
        return PluginCenter.getInstance().getPlugin(this.mPackageName).ks();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        if (!PluginCenter.getInstance().isLoaded(this.mPackageName)) {
            throw new RuntimeException("plugin is not loaded");
        }
        return PluginCenter.getInstance().getPlugin(this.mPackageName).getApplication();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().findPluginSetting(this.mPackageName);
        if (findPluginSetting != null && findPluginSetting.isThird) {
            if (!PluginCenter.getInstance().isLoaded(this.mPackageName)) {
                throw new RuntimeException("plugin is not loaded");
            }
            com.baidu.adp.plugin.a plugin2 = PluginCenter.getInstance().getPlugin(this.mPackageName);
            if (plugin2 != null) {
                return plugin2.kt();
            }
        } else {
            Resources resources = j.dK().getResources();
            if (resources != null) {
                return resources;
            }
        }
        return super.getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        if (this.mTheme == null) {
            this.mTheme = getResources().newTheme();
            this.mTheme.setTo(BdBaseApplication.getInst().getTheme());
        }
        return this.mTheme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        getTheme().applyStyle(i, true);
    }
}
