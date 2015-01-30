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
        if (!PluginCenter.gW().aR(this.mPackageName)) {
            throw new RuntimeException("plugin is not loaded");
        }
        attachBaseContext(PluginCenter.gW().aS(this.mPackageName).gO().getBaseContext());
    }

    public String getPluginPackageName() {
        return this.mPackageName;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        if (!PluginCenter.gW().aR(this.mPackageName)) {
            throw new RuntimeException("plugin is not loaded");
        }
        return PluginCenter.gW().aS(this.mPackageName).gL();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        if (!PluginCenter.gW().aR(this.mPackageName)) {
            throw new RuntimeException("plugin is not loaded");
        }
        return PluginCenter.gW().aS(this.mPackageName).gO();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (!PluginCenter.gW().aR(this.mPackageName)) {
            throw new RuntimeException("plugin is not loaded");
        }
        return PluginCenter.gW().aS(this.mPackageName).gM();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }
}
