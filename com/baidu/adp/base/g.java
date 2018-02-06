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
    private static g abE = null;
    private Resources abF = null;
    private ArrayList<String> abG = null;
    private HashSet<String> abH = null;

    public static g jL() {
        if (abE == null) {
            synchronized (g.class) {
                if (abE == null) {
                    abE = new g();
                }
            }
        }
        return abE;
    }

    public synchronized void b(Resources resources) {
        this.abF = resources;
    }

    public synchronized void g(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.abF == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.abH == null) {
                this.abH = new HashSet<>();
            }
            if (this.abH.contains(str)) {
                com.baidu.adp.plugin.b.a.qF().f("plugin_load", "repeat_inject_res", str, str2);
            }
            this.abH.add(str);
        }
        if (this.abG == null) {
            this.abG = new ArrayList<>();
        }
        if (!this.abG.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.d.c(this.abF.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.abG.size() > 0) {
                    Iterator<String> it = this.abG.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.abF = new Resources(assetManager, this.abF.getDisplayMetrics(), this.abF.getConfiguration());
            }
            this.abG.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.abF;
    }
}
