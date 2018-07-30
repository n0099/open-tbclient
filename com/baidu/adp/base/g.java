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
    private static g rX = null;
    private Resources rY = null;
    private ArrayList<String> rZ = null;
    private HashSet<String> sa = null;

    public static g eC() {
        if (rX == null) {
            synchronized (g.class) {
                if (rX == null) {
                    rX = new g();
                }
            }
        }
        return rX;
    }

    public synchronized void a(Resources resources) {
        this.rY = resources;
    }

    public synchronized void h(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.rY == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.sa == null) {
                this.sa = new HashSet<>();
            }
            if (this.sa.contains(str)) {
                com.baidu.adp.plugin.b.a.lA().f("plugin_load", "repeat_inject_res", str, str2);
            }
            this.sa.add(str);
        }
        if (this.rZ == null) {
            this.rZ = new ArrayList<>();
        }
        if (!this.rZ.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.d.c(this.rY.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.rZ.size() > 0) {
                    Iterator<String> it = this.rZ.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.rY = new Resources(assetManager, this.rY.getDisplayMetrics(), this.rY.getConfiguration());
            }
            this.rZ.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.rY;
    }
}
