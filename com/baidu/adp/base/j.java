package com.baidu.adp.base;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class j {
    private static j nx = null;
    private Resources ny = null;
    private ArrayList<String> nz = null;
    private HashSet<String> nA = null;

    public static j dN() {
        if (nx == null) {
            synchronized (j.class) {
                if (nx == null) {
                    nx = new j();
                }
            }
        }
        return nx;
    }

    public synchronized void a(Resources resources) {
        this.ny = resources;
    }

    public synchronized void j(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.ny == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.nA == null) {
                this.nA = new HashSet<>();
            }
            if (this.nA.contains(str)) {
                com.baidu.adp.plugin.b.a.lq().e("plugin_load", "repeat_inject_res", str, str2);
            }
            this.nA.add(str);
        }
        if (this.nz == null) {
            this.nz = new ArrayList<>();
        }
        if (!this.nz.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.f.a(this.ny.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.nz.size() > 0) {
                    Iterator<String> it = this.nz.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.ny = new Resources(assetManager, this.ny.getDisplayMetrics(), this.ny.getConfiguration());
            }
            this.nz.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.ny;
    }
}
