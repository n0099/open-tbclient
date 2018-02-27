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
    private static g aby = null;
    private Resources abz = null;
    private ArrayList<String> abA = null;
    private HashSet<String> abB = null;

    public static g jL() {
        if (aby == null) {
            synchronized (g.class) {
                if (aby == null) {
                    aby = new g();
                }
            }
        }
        return aby;
    }

    public synchronized void b(Resources resources) {
        this.abz = resources;
    }

    public synchronized void g(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.abz == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.abB == null) {
                this.abB = new HashSet<>();
            }
            if (this.abB.contains(str)) {
                com.baidu.adp.plugin.b.a.qF().f("plugin_load", "repeat_inject_res", str, str2);
            }
            this.abB.add(str);
        }
        if (this.abA == null) {
            this.abA = new ArrayList<>();
        }
        if (!this.abA.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.d.c(this.abz.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.abA.size() > 0) {
                    Iterator<String> it = this.abA.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.abz = new Resources(assetManager, this.abz.getDisplayMetrics(), this.abz.getConfiguration());
            }
            this.abA.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.abz;
    }
}
