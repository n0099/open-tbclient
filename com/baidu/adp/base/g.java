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
    private static g vm = null;
    private Resources vn = null;
    private ArrayList<String> vo = null;
    private HashSet<String> vp = null;

    public static g fZ() {
        if (vm == null) {
            synchronized (g.class) {
                if (vm == null) {
                    vm = new g();
                }
            }
        }
        return vm;
    }

    public synchronized void a(Resources resources) {
        this.vn = resources;
    }

    public synchronized void o(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.vn == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.vp == null) {
                this.vp = new HashSet<>();
            }
            if (this.vp.contains(str)) {
                com.baidu.adp.plugin.b.a.mS().f("plugin_load", "repeat_inject_res", str, str2);
            }
            this.vp.add(str);
        }
        if (this.vo == null) {
            this.vo = new ArrayList<>();
        }
        if (!this.vo.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.d.c(this.vn.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.vo.size() > 0) {
                    Iterator<String> it = this.vo.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.vn = new Resources(assetManager, this.vn.getDisplayMetrics(), this.vn.getConfiguration());
            }
            this.vo.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.vn;
    }
}
