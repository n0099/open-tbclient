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
    private static g sR = null;
    private Resources sS = null;
    private ArrayList<String> sT = null;
    private HashSet<String> sU = null;

    public static g eZ() {
        if (sR == null) {
            synchronized (g.class) {
                if (sR == null) {
                    sR = new g();
                }
            }
        }
        return sR;
    }

    public synchronized void a(Resources resources) {
        this.sS = resources;
    }

    public synchronized void h(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.sS == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.sU == null) {
                this.sU = new HashSet<>();
            }
            if (this.sU.contains(str)) {
                com.baidu.adp.plugin.b.a.mc().f("plugin_load", "repeat_inject_res", str, str2);
            }
            this.sU.add(str);
        }
        if (this.sT == null) {
            this.sT = new ArrayList<>();
        }
        if (!this.sT.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.d.c(this.sS.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.sT.size() > 0) {
                    Iterator<String> it = this.sT.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.sS = new Resources(assetManager, this.sS.getDisplayMetrics(), this.sS.getConfiguration());
            }
            this.sT.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.sS;
    }
}
