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
    private static g mP = null;
    private Resources mQ = null;
    private ArrayList<String> mS = null;
    private HashSet<String> mT = null;

    public static g cg() {
        if (mP == null) {
            synchronized (g.class) {
                if (mP == null) {
                    mP = new g();
                }
            }
        }
        return mP;
    }

    public synchronized void a(Resources resources) {
        this.mQ = resources;
    }

    public synchronized void g(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.mQ == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.mT == null) {
                this.mT = new HashSet<>();
            }
            if (this.mT.contains(str)) {
                com.baidu.adp.plugin.b.a.jj().c("plugin_load", "repeat_inject_res", str, str2);
            }
            this.mT.add(str);
        }
        if (this.mS == null) {
            this.mS = new ArrayList<>();
        }
        if (!this.mS.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.d.c(this.mQ.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.mS.size() > 0) {
                    Iterator<String> it = this.mS.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.mQ = new Resources(assetManager, this.mQ.getDisplayMetrics(), this.mQ.getConfiguration());
            }
            this.mS.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.mQ;
    }
}
