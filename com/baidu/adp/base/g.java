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
    private static g sP = null;
    private Resources sQ = null;
    private ArrayList<String> sR = null;
    private HashSet<String> sS = null;

    public static g eS() {
        if (sP == null) {
            synchronized (g.class) {
                if (sP == null) {
                    sP = new g();
                }
            }
        }
        return sP;
    }

    public synchronized void a(Resources resources) {
        this.sQ = resources;
    }

    public synchronized void h(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.sQ == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.sS == null) {
                this.sS = new HashSet<>();
            }
            if (this.sS.contains(str)) {
                com.baidu.adp.plugin.b.a.lM().f("plugin_load", "repeat_inject_res", str, str2);
            }
            this.sS.add(str);
        }
        if (this.sR == null) {
            this.sR = new ArrayList<>();
        }
        if (!this.sR.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.d.c(this.sQ.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.sR.size() > 0) {
                    Iterator<String> it = this.sR.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.sQ = new Resources(assetManager, this.sQ.getDisplayMetrics(), this.sQ.getConfiguration());
            }
            this.sR.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.sQ;
    }
}
