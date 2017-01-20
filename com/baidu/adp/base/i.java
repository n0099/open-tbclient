package com.baidu.adp.base;

import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class i {
    private static i gg = null;
    private Resources gh = null;
    private ArrayList<String> gi = null;
    private HashSet<String> gj = null;

    public static i aY() {
        if (gg == null) {
            synchronized (i.class) {
                if (gg == null) {
                    gg = new i();
                }
            }
        }
        return gg;
    }

    public synchronized void a(Resources resources) {
        this.gh = resources;
    }

    public synchronized void g(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        PackageInfo packageInfo;
        synchronized (this) {
            if (TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("param resPath is null");
            }
            if (this.gh == null) {
                throw new RuntimeException("hostResources is null");
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.gj == null) {
                    this.gj = new HashSet<>();
                }
                if (this.gj.contains(str)) {
                    com.baidu.adp.plugin.b.a.im().e("plugin_load", "repeat_inject_res", str, str2);
                }
                this.gj.add(str);
            }
            if (this.gi == null) {
                this.gi = new ArrayList<>();
            }
            if (!this.gi.contains(str2)) {
                if (Build.VERSION.SDK_INT >= 24) {
                    com.baidu.adp.plugin.util.f.a(this.gh.getAssets(), "addAssetPath", new Object[]{str2});
                    String[] strArr = BdBaseApplication.getInst().getApplicationInfo().sharedLibraryFiles;
                    int length = (strArr != null ? strArr.length : 0) + 1;
                    String[] strArr2 = new String[length];
                    if (strArr != null) {
                        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                    }
                    try {
                        Method declaredMethod = Class.forName("android.webkit.WebViewFactory").getDeclaredMethod("getLoadedPackageInfo", new Class[0]);
                        declaredMethod.setAccessible(true);
                        Object invoke = declaredMethod.invoke(null, new Object[0]);
                        if ((invoke instanceof PackageInfo) && (packageInfo = (PackageInfo) invoke) != null) {
                            strArr2[length - 1] = packageInfo.applicationInfo.sourceDir;
                            BdBaseApplication.getInst().getApplicationInfo().sharedLibraryFiles = strArr2;
                        }
                    } catch (Exception e) {
                    }
                } else if (Build.VERSION.SDK_INT >= 20) {
                    com.baidu.adp.plugin.util.f.a(this.gh.getAssets(), "addAssetPath", new Object[]{str2});
                } else {
                    AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                    if (this.gi.size() > 0) {
                        Iterator<String> it = this.gi.iterator();
                        while (it.hasNext()) {
                            com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{it.next()});
                        }
                    }
                    com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{str2});
                    com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                    this.gh = new Resources(assetManager, this.gh.getDisplayMetrics(), this.gh.getConfiguration());
                }
                this.gi.add(str2);
            }
        }
    }

    public synchronized Resources getResources() {
        return this.gh;
    }
}
