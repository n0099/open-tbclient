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
    private static g uB = null;
    private Resources uC = null;
    private ArrayList<String> uD = null;
    private HashSet<String> uE = null;

    public static g fK() {
        if (uB == null) {
            synchronized (g.class) {
                if (uB == null) {
                    uB = new g();
                }
            }
        }
        return uB;
    }

    public synchronized void a(Resources resources) {
        this.uC = resources;
    }

    public synchronized void o(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.uC == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.uE == null) {
                this.uE = new HashSet<>();
            }
            if (this.uE.contains(str)) {
                com.baidu.adp.plugin.b.a.mG().f("plugin_load", "repeat_inject_res", str, str2);
            }
            this.uE.add(str);
        }
        if (this.uD == null) {
            this.uD = new ArrayList<>();
        }
        if (!this.uD.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.d.c(this.uC.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.uD.size() > 0) {
                    Iterator<String> it = this.uD.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.uC = new Resources(assetManager, this.uC.getDisplayMetrics(), this.uC.getConfiguration());
            }
            this.uD.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.uC;
    }
}
