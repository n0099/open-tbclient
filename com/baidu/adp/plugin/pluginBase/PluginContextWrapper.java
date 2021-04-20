package com.baidu.adp.plugin.pluginBase;

import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.proxy.ContentResolverProxy;
import d.b.c.a.h;
import d.b.c.h.j.g.d;
/* loaded from: classes.dex */
public class PluginContextWrapper extends ContextWrapper {
    public String mPackageName;
    public Resources.Theme mTheme;

    public PluginContextWrapper(Context context) {
        super(context);
        this.mPackageName = null;
        this.mTheme = null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        PluginSetting h2 = d.k().h(this.mPackageName);
        if (h2 != null && h2.isThird) {
            Plugin plugin2 = PluginCenter.getInstance().getPlugin(this.mPackageName);
            if (plugin2 != null && plugin2.isLoaded()) {
                return plugin2.getApplication();
            }
            throw new RuntimeException("third plugin is not loaded");
        } else if (PluginCenter.getInstance().isLoaded(this.mPackageName)) {
            return PluginCenter.getInstance().getPlugin(this.mPackageName).getApplication();
        } else {
            throw new RuntimeException("plugin is not loaded");
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        if (PluginCenter.getInstance().isLoaded(this.mPackageName)) {
            return PluginCenter.getInstance().getPlugin(this.mPackageName).getDexClassLoader();
        }
        throw new RuntimeException("plugin is not loaded");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ContentResolver getContentResolver() {
        return ContentResolverProxy.getContentResolver();
    }

    public String getPluginPackageName() {
        return this.mPackageName;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        PluginSetting h2 = d.k().h(this.mPackageName);
        if (h2 != null && h2.isThird) {
            Plugin plugin2 = PluginCenter.getInstance().getPlugin(this.mPackageName);
            if (plugin2 != null && plugin2.isLoaded()) {
                return plugin2.getPluginResources();
            }
            throw new RuntimeException("third plugin is not loaded");
        }
        Resources b2 = h.a().b();
        return b2 != null ? b2 : super.getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        if (this.mTheme == null) {
            Resources.Theme newTheme = getResources().newTheme();
            this.mTheme = newTheme;
            newTheme.setTo(BdBaseApplication.getInst().getTheme());
        }
        return this.mTheme;
    }

    public void setPluginPackageName(String str) {
        this.mPackageName = str;
        if (PluginCenter.getInstance().isLoaded(this.mPackageName)) {
            attachBaseContext(PluginCenter.getInstance().getPlugin(this.mPackageName).getApplication().getBaseContext());
            return;
        }
        throw new RuntimeException("plugin is not loaded");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        getTheme().applyStyle(i, true);
    }
}
