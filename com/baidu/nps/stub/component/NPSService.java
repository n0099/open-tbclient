package com.baidu.nps.stub.component;

import android.app.Service;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.baidu.nps.main.manager.NPSManager;
/* loaded from: classes2.dex */
public abstract class NPSService extends Service {
    public Resources mNPSResources;

    private String getBundlePackageName() {
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        if (TextUtils.isEmpty(getBundlePackageName())) {
            return super.getClassLoader();
        }
        return NPSManager.getInstance().getBundle(getBundlePackageName()).getClassloader();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (TextUtils.isEmpty(getBundlePackageName())) {
            return super.getResources();
        }
        Resources resources = NPSManager.getInstance().getBundle(getBundlePackageName()).getResources(super.getResources());
        this.mNPSResources = resources;
        return resources;
    }
}
