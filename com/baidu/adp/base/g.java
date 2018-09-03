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
    private static g rY = null;
    private Resources rZ = null;
    private ArrayList<String> sa = null;
    private HashSet<String> sb = null;

    public static g eC() {
        if (rY == null) {
            synchronized (g.class) {
                if (rY == null) {
                    rY = new g();
                }
            }
        }
        return rY;
    }

    public synchronized void a(Resources resources) {
        this.rZ = resources;
    }

    public synchronized void h(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.rZ == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.sb == null) {
                this.sb = new HashSet<>();
            }
            if (this.sb.contains(str)) {
                com.baidu.adp.plugin.b.a.lA().f("plugin_load", "repeat_inject_res", str, str2);
            }
            this.sb.add(str);
        }
        if (this.sa == null) {
            this.sa = new ArrayList<>();
        }
        if (!this.sa.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.d.c(this.rZ.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.sa.size() > 0) {
                    Iterator<String> it = this.sa.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.rZ = new Resources(assetManager, this.rZ.getDisplayMetrics(), this.rZ.getConfiguration());
            }
            this.sa.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.rZ;
    }
}
