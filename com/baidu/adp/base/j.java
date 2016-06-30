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
    private static j ds = null;
    private Resources dt = null;
    private ArrayList<String> du = null;
    private HashSet<String> dv = null;

    public static j ad() {
        if (ds == null) {
            synchronized (j.class) {
                if (ds == null) {
                    ds = new j();
                }
            }
        }
        return ds;
    }

    public synchronized void a(Resources resources) {
        this.dt = resources;
    }

    public synchronized void g(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.dt == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.dv == null) {
                this.dv = new HashSet<>();
            }
            if (this.dv.contains(str)) {
                com.baidu.adp.plugin.b.a.hu().e("plugin_load", "repeat_inject_res", str, str2);
            }
            this.dv.add(str);
        }
        if (this.du == null) {
            this.du = new ArrayList<>();
        }
        if (!this.du.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.f.a(this.dt.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.du.size() > 0) {
                    Iterator<String> it = this.du.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.dt = new Resources(assetManager, this.dt.getDisplayMetrics(), this.dt.getConfiguration());
            }
            this.du.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.dt;
    }
}
