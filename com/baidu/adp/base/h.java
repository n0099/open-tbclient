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
public class h {
    private static h Ih = null;
    private Resources mCurrentResources = null;
    private ArrayList<String> Ii = null;
    private HashSet<String> Ij = null;

    public static h kE() {
        if (Ih == null) {
            synchronized (h.class) {
                if (Ih == null) {
                    Ih = new h();
                }
            }
        }
        return Ih;
    }

    public synchronized void setHostResources(Resources resources) {
        this.mCurrentResources = resources;
    }

    public synchronized void r(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.mCurrentResources == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.Ij == null) {
                this.Ij = new HashSet<>();
            }
            if (this.Ij.contains(str)) {
                com.baidu.adp.plugin.b.a.pg().f("plugin_load", "repeat_inject_res", str, str2);
            }
            this.Ij.add(str);
        }
        if (this.Ii == null) {
            this.Ii = new ArrayList<>();
        }
        if (!this.Ii.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.d.callMethod(this.mCurrentResources.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.Ii.size() > 0) {
                    Iterator<String> it = this.Ii.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.d.callMethod(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.d.callMethod(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.d.callMethod(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.mCurrentResources = new Resources(assetManager, this.mCurrentResources.getDisplayMetrics(), this.mCurrentResources.getConfiguration());
            }
            this.Ii.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.mCurrentResources;
    }
}
