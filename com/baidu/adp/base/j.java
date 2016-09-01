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
public class j {
    private static j gi = null;
    private Resources gj = null;
    private ArrayList<String> gk = null;
    private HashSet<String> gl = null;

    public static j aY() {
        if (gi == null) {
            synchronized (j.class) {
                if (gi == null) {
                    gi = new j();
                }
            }
        }
        return gi;
    }

    public synchronized void a(Resources resources) {
        this.gj = resources;
    }

    public synchronized void g(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.gj == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.gl == null) {
                this.gl = new HashSet<>();
            }
            if (this.gl.contains(str)) {
                com.baidu.adp.plugin.b.a.io().e("plugin_load", "repeat_inject_res", str, str2);
            }
            this.gl.add(str);
        }
        if (this.gk == null) {
            this.gk = new ArrayList<>();
        }
        if (!this.gk.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.f.a(this.gj.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.gk.size() > 0) {
                    Iterator<String> it = this.gk.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.gj = new Resources(assetManager, this.gj.getDisplayMetrics(), this.gj.getConfiguration());
            }
            this.gk.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.gj;
    }
}
