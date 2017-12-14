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
    private static g mQ = null;
    private Resources mS = null;
    private ArrayList<String> mT = null;
    private HashSet<String> mU = null;

    public static g cg() {
        if (mQ == null) {
            synchronized (g.class) {
                if (mQ == null) {
                    mQ = new g();
                }
            }
        }
        return mQ;
    }

    public synchronized void a(Resources resources) {
        this.mS = resources;
    }

    public synchronized void g(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.mS == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.mU == null) {
                this.mU = new HashSet<>();
            }
            if (this.mU.contains(str)) {
                com.baidu.adp.plugin.b.a.jf().c("plugin_load", "repeat_inject_res", str, str2);
            }
            this.mU.add(str);
        }
        if (this.mT == null) {
            this.mT = new ArrayList<>();
        }
        if (!this.mT.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.d.c(this.mS.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.mT.size() > 0) {
                    Iterator<String> it = this.mT.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.mS = new Resources(assetManager, this.mS.getDisplayMetrics(), this.mS.getConfiguration());
            }
            this.mT.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.mS;
    }
}
