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
    private static g GK = null;
    private Resources mCurrentResources = null;
    private ArrayList<String> GL = null;
    private HashSet<String> GM = null;

    public static g jE() {
        if (GK == null) {
            synchronized (g.class) {
                if (GK == null) {
                    GK = new g();
                }
            }
        }
        return GK;
    }

    public synchronized void setHostResources(Resources resources) {
        this.mCurrentResources = resources;
    }

    public synchronized void o(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.mCurrentResources == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.GM == null) {
                this.GM = new HashSet<>();
            }
            if (this.GM.contains(str)) {
                com.baidu.adp.plugin.b.a.nX().f("plugin_load", "repeat_inject_res", str, str2);
            }
            this.GM.add(str);
        }
        if (this.GL == null) {
            this.GL = new ArrayList<>();
        }
        if (!this.GL.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.d.callMethod(this.mCurrentResources.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.GL.size() > 0) {
                    Iterator<String> it = this.GL.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.d.callMethod(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.d.callMethod(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.d.callMethod(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.mCurrentResources = new Resources(assetManager, this.mCurrentResources.getDisplayMetrics(), this.mCurrentResources.getConfiguration());
            }
            this.GL.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.mCurrentResources;
    }
}
