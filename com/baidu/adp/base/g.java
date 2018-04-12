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
    private static g lL = null;
    private Resources lM = null;
    private ArrayList<String> lN = null;
    private HashSet<String> lO = null;

    public static g bP() {
        if (lL == null) {
            synchronized (g.class) {
                if (lL == null) {
                    lL = new g();
                }
            }
        }
        return lL;
    }

    public synchronized void a(Resources resources) {
        this.lM = resources;
    }

    public synchronized void g(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.lM == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.lO == null) {
                this.lO = new HashSet<>();
            }
            if (this.lO.contains(str)) {
                com.baidu.adp.plugin.b.a.iK().f("plugin_load", "repeat_inject_res", str, str2);
            }
            this.lO.add(str);
        }
        if (this.lN == null) {
            this.lN = new ArrayList<>();
        }
        if (!this.lN.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.d.c(this.lM.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.lN.size() > 0) {
                    Iterator<String> it = this.lN.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.lM = new Resources(assetManager, this.lM.getDisplayMetrics(), this.lM.getConfiguration());
            }
            this.lN.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.lM;
    }
}
