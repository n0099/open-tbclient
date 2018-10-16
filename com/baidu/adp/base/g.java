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
    private static g vo = null;
    private Resources vp = null;
    private ArrayList<String> vq = null;
    private HashSet<String> vr = null;

    public static g gd() {
        if (vo == null) {
            synchronized (g.class) {
                if (vo == null) {
                    vo = new g();
                }
            }
        }
        return vo;
    }

    public synchronized void a(Resources resources) {
        this.vp = resources;
    }

    public synchronized void o(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.vp == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.vr == null) {
                this.vr = new HashSet<>();
            }
            if (this.vr.contains(str)) {
                com.baidu.adp.plugin.b.a.mQ().f("plugin_load", "repeat_inject_res", str, str2);
            }
            this.vr.add(str);
        }
        if (this.vq == null) {
            this.vq = new ArrayList<>();
        }
        if (!this.vq.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.d.c(this.vp.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.vq.size() > 0) {
                    Iterator<String> it = this.vq.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.vp = new Resources(assetManager, this.vp.getDisplayMetrics(), this.vp.getConfiguration());
            }
            this.vq.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.vp;
    }
}
