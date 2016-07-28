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
    private static j dV = null;
    private Resources dW = null;
    private ArrayList<String> dX = null;
    private HashSet<String> dY = null;

    public static j ad() {
        if (dV == null) {
            synchronized (j.class) {
                if (dV == null) {
                    dV = new j();
                }
            }
        }
        return dV;
    }

    public synchronized void a(Resources resources) {
        this.dW = resources;
    }

    public synchronized void g(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.dW == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.dY == null) {
                this.dY = new HashSet<>();
            }
            if (this.dY.contains(str)) {
                com.baidu.adp.plugin.b.a.ht().e("plugin_load", "repeat_inject_res", str, str2);
            }
            this.dY.add(str);
        }
        if (this.dX == null) {
            this.dX = new ArrayList<>();
        }
        if (!this.dX.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.f.a(this.dW.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.dX.size() > 0) {
                    Iterator<String> it = this.dX.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.dW = new Resources(assetManager, this.dW.getDisplayMetrics(), this.dW.getConfiguration());
            }
            this.dX.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.dW;
    }
}
