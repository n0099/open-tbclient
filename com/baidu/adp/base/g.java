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
    private static g sh = null;
    private Resources si = null;
    private ArrayList<String> sj = null;
    private HashSet<String> sk = null;

    public static g eD() {
        if (sh == null) {
            synchronized (g.class) {
                if (sh == null) {
                    sh = new g();
                }
            }
        }
        return sh;
    }

    public synchronized void a(Resources resources) {
        this.si = resources;
    }

    public synchronized void h(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.si == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.sk == null) {
                this.sk = new HashSet<>();
            }
            if (this.sk.contains(str)) {
                com.baidu.adp.plugin.b.a.ly().f("plugin_load", "repeat_inject_res", str, str2);
            }
            this.sk.add(str);
        }
        if (this.sj == null) {
            this.sj = new ArrayList<>();
        }
        if (!this.sj.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.d.c(this.si.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.sj.size() > 0) {
                    Iterator<String> it = this.sj.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.si = new Resources(assetManager, this.si.getDisplayMetrics(), this.si.getConfiguration());
            }
            this.sj.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.si;
    }
}
