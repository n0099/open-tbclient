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
    private static g sO = null;
    private Resources sP = null;
    private ArrayList<String> sQ = null;
    private HashSet<String> sR = null;

    public static g eS() {
        if (sO == null) {
            synchronized (g.class) {
                if (sO == null) {
                    sO = new g();
                }
            }
        }
        return sO;
    }

    public synchronized void a(Resources resources) {
        this.sP = resources;
    }

    public synchronized void h(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.sP == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.sR == null) {
                this.sR = new HashSet<>();
            }
            if (this.sR.contains(str)) {
                com.baidu.adp.plugin.b.a.lM().f("plugin_load", "repeat_inject_res", str, str2);
            }
            this.sR.add(str);
        }
        if (this.sQ == null) {
            this.sQ = new ArrayList<>();
        }
        if (!this.sQ.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.d.c(this.sP.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.sQ.size() > 0) {
                    Iterator<String> it = this.sQ.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.sP = new Resources(assetManager, this.sP.getDisplayMetrics(), this.sP.getConfiguration());
            }
            this.sQ.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.sP;
    }
}
