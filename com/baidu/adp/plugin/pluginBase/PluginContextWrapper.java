package com.baidu.adp.plugin.pluginBase;

import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.g;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.c;
import com.baidu.adp.plugin.proxy.ContentResolverProxy;
/* loaded from: classes.dex */
public class PluginContextWrapper extends ContextWrapper {
    private String mPackageName;
    private Resources.Theme mTheme;

    public PluginContextWrapper(Context context) {
        super(context);
        this.mPackageName = null;
        this.mTheme = null;
    }

    public void setPluginPackageName(String str) {
        this.mPackageName = str;
        if (!PluginCenter.getInstance().isLoaded(this.mPackageName)) {
            throw new RuntimeException("plugin is not loaded");
        }
        attachBaseContext(PluginCenter.getInstance().getPlugin(this.mPackageName).getApplication().getBaseContext());
    }

    public String getPluginPackageName() {
        return this.mPackageName;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        if (!PluginCenter.getInstance().isLoaded(this.mPackageName)) {
            throw new RuntimeException("plugin is not loaded");
        }
        return PluginCenter.getInstance().getPlugin(this.mPackageName).getDexClassLoader();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        PluginSetting findPluginSetting = c.jX().findPluginSetting(this.mPackageName);
        if (findPluginSetting != null && findPluginSetting.isThird) {
            Plugin plugin2 = PluginCenter.getInstance().getPlugin(this.mPackageName);
            if (plugin2 == null || !plugin2.isLoaded()) {
                throw new RuntimeException("third plugin is not loaded");
            }
            return plugin2.getApplication();
        } else if (!PluginCenter.getInstance().isLoaded(this.mPackageName)) {
            throw new RuntimeException("plugin is not loaded");
        } else {
            return PluginCenter.getInstance().getPlugin(this.mPackageName).getApplication();
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        PluginSetting findPluginSetting = c.jX().findPluginSetting(this.mPackageName);
        if (findPluginSetting != null && findPluginSetting.isThird) {
            Plugin plugin2 = PluginCenter.getInstance().getPlugin(this.mPackageName);
            if (plugin2 == null || !plugin2.isLoaded()) {
                throw new RuntimeException("third plugin is not loaded");
            }
            return plugin2.getPluginResources();
        }
        Resources resources = g.cg().getResources();
        return resources == null ? super.getResources() : resources;
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

    @Override // android.content.ContextWrapper, android.content.Context
    public ContentResolver getContentResolver() {
        return ContentResolverProxy.getContentResolver();
    }
}
