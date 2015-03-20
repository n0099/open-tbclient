package com.baidu.adp.plugin.pluginBase;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
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
        return PluginCenter.getInstance().getPlugin(this.mPackageName).kh();
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
        if (!PluginCenter.getInstance().isLoaded(this.mPackageName)) {
            throw new RuntimeException("plugin is not loaded");
        }
        return PluginCenter.getInstance().getPlugin(this.mPackageName).ki();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }
}
