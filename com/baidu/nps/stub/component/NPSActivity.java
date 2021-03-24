package com.baidu.nps.stub.component;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.nps.main.manager.NPSManager;
/* loaded from: classes2.dex */
public abstract class NPSActivity extends Activity {
    public static final String WINDOW_HIERARCHY_TAG = "android:viewHierarchyState";
    public Resources mNPSResources;

    private String getBundlePackageName() {
        return null;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        if (!TextUtils.isEmpty(getBundlePackageName())) {
            return NPSManager.getInstance().getBundle(getBundlePackageName()).getClassloader();
        }
        return super.getClassLoader();
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        Intent intent = super.getIntent();
        if (intent != null) {
            intent.setExtrasClassLoader(getClassLoader());
        }
        return intent;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (TextUtils.isEmpty(getBundlePackageName())) {
            return super.getResources();
        }
        Resources resources = NPSManager.getInstance().getBundle(getBundlePackageName()).getResources(super.getResources());
        this.mNPSResources = resources;
        return resources;
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(WINDOW_HIERARCHY_TAG);
        if (bundle2 != null) {
            bundle2.setClassLoader(getClassLoader());
        }
        super.onRestoreInstanceState(bundle);
    }
}
