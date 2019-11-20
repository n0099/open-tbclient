package com.baidu.adp.base;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class g {
    private static g kB = null;
    private Resources mCurrentResources = null;
    private ArrayList<String> kC = null;
    private HashSet<String> kD = null;

    public static g eo() {
        if (kB == null) {
            synchronized (g.class) {
                if (kB == null) {
                    kB = new g();
                }
            }
        }
        return kB;
    }

    public synchronized void setHostResources(Resources resources) {
        this.mCurrentResources = resources;
    }

    public synchronized void h(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.mCurrentResources == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.kD == null) {
                this.kD = new HashSet<>();
            }
            if (this.kD.contains(str)) {
                com.baidu.adp.plugin.b.a.iv().f("plugin_load", "repeat_inject_res", str, str2);
            }
            this.kD.add(str);
        }
        if (this.kC == null) {
            this.kC = new ArrayList<>();
        }
        if (!this.kC.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.d.callMethod(this.mCurrentResources.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.kC.size() > 0) {
                    Iterator<String> it = this.kC.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.d.callMethod(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.d.callMethod(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.d.callMethod(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.mCurrentResources = new Resources(assetManager, this.mCurrentResources.getDisplayMetrics(), this.mCurrentResources.getConfiguration());
            }
            this.kC.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.mCurrentResources;
    }
}
