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
    private static g mS = null;
    private Resources mT = null;
    private ArrayList<String> mU = null;
    private HashSet<String> mV = null;

    public static g cg() {
        if (mS == null) {
            synchronized (g.class) {
                if (mS == null) {
                    mS = new g();
                }
            }
        }
        return mS;
    }

    public synchronized void a(Resources resources) {
        this.mT = resources;
    }

    public synchronized void g(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.mT == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.mV == null) {
                this.mV = new HashSet<>();
            }
            if (this.mV.contains(str)) {
                com.baidu.adp.plugin.b.a.ji().c("plugin_load", "repeat_inject_res", str, str2);
            }
            this.mV.add(str);
        }
        if (this.mU == null) {
            this.mU = new ArrayList<>();
        }
        if (!this.mU.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.d.c(this.mT.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.mU.size() > 0) {
                    Iterator<String> it = this.mU.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.mT = new Resources(assetManager, this.mT.getDisplayMetrics(), this.mT.getConfiguration());
            }
            this.mU.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.mT;
    }
}
