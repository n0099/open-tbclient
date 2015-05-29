package com.baidu.adp.plugin.pluginBase;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.l;
import com.baidu.adp.plugin.PluginCenter;
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
        return PluginCenter.getInstance().getPlugin(this.mPackageName).kz();
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
        if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
            Resources resources = l.dJ().getResources();
            if (resources == null) {
                return super.getResources();
            }
            return resources;
        } else if (!PluginCenter.getInstance().isLoaded(this.mPackageName)) {
            throw new RuntimeException("plugin is not loaded");
        } else {
            return PluginCenter.getInstance().getPlugin(this.mPackageName).kA();
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
            if (this.mTheme == null) {
                this.mTheme = getResources().newTheme();
                this.mTheme.setTo(BdBaseApplication.getInst().getTheme());
            }
            return this.mTheme;
        }
        return super.getTheme();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
            getTheme().applyStyle(i, true);
        } else {
            super.setTheme(i);
        }
    }
}
