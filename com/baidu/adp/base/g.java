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
    private static g abG = null;
    private Resources abH = null;
    private ArrayList<String> abI = null;
    private HashSet<String> abJ = null;

    public static g jL() {
        if (abG == null) {
            synchronized (g.class) {
                if (abG == null) {
                    abG = new g();
                }
            }
        }
        return abG;
    }

    public synchronized void b(Resources resources) {
        this.abH = resources;
    }

    public synchronized void g(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.abH == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.abJ == null) {
                this.abJ = new HashSet<>();
            }
            if (this.abJ.contains(str)) {
                com.baidu.adp.plugin.b.a.qE().f("plugin_load", "repeat_inject_res", str, str2);
            }
            this.abJ.add(str);
        }
        if (this.abI == null) {
            this.abI = new ArrayList<>();
        }
        if (!this.abI.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.d.c(this.abH.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.abI.size() > 0) {
                    Iterator<String> it = this.abI.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.abH = new Resources(assetManager, this.abH.getDisplayMetrics(), this.abH.getConfiguration());
            }
            this.abI.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.abH;
    }
}
