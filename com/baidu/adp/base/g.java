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
    private static g vq = null;
    private Resources vr = null;
    private ArrayList<String> vs = null;
    private HashSet<String> vt = null;

    public static g gd() {
        if (vq == null) {
            synchronized (g.class) {
                if (vq == null) {
                    vq = new g();
                }
            }
        }
        return vq;
    }

    public synchronized void a(Resources resources) {
        this.vr = resources;
    }

    public synchronized void o(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.vr == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.vt == null) {
                this.vt = new HashSet<>();
            }
            if (this.vt.contains(str)) {
                com.baidu.adp.plugin.b.a.mN().f("plugin_load", "repeat_inject_res", str, str2);
            }
            this.vt.add(str);
        }
        if (this.vs == null) {
            this.vs = new ArrayList<>();
        }
        if (!this.vs.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.d.c(this.vr.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.vs.size() > 0) {
                    Iterator<String> it = this.vs.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.vr = new Resources(assetManager, this.vr.getDisplayMetrics(), this.vr.getConfiguration());
            }
            this.vs.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.vr;
    }
}
