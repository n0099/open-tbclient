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
    private static g sf = null;
    private Resources sg = null;
    private ArrayList<String> sh = null;
    private HashSet<String> si = null;

    public static g eD() {
        if (sf == null) {
            synchronized (g.class) {
                if (sf == null) {
                    sf = new g();
                }
            }
        }
        return sf;
    }

    public synchronized void a(Resources resources) {
        this.sg = resources;
    }

    public synchronized void h(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.sg == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.si == null) {
                this.si = new HashSet<>();
            }
            if (this.si.contains(str)) {
                com.baidu.adp.plugin.b.a.ly().f("plugin_load", "repeat_inject_res", str, str2);
            }
            this.si.add(str);
        }
        if (this.sh == null) {
            this.sh = new ArrayList<>();
        }
        if (!this.sh.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.d.c(this.sg.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.sh.size() > 0) {
                    Iterator<String> it = this.sh.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.sg = new Resources(assetManager, this.sg.getDisplayMetrics(), this.sg.getConfiguration());
            }
            this.sh.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.sg;
    }
}
