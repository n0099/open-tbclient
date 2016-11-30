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
public class j {
    private static j gj = null;
    private Resources gk = null;
    private ArrayList<String> gl = null;
    private HashSet<String> gm = null;

    public static j aY() {
        if (gj == null) {
            synchronized (j.class) {
                if (gj == null) {
                    gj = new j();
                }
            }
        }
        return gj;
    }

    public synchronized void a(Resources resources) {
        this.gk = resources;
    }

    public synchronized void g(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        PackageInfo packageInfo;
        synchronized (this) {
            if (TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("param resPath is null");
            }
            if (this.gk == null) {
                throw new RuntimeException("hostResources is null");
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.gm == null) {
                    this.gm = new HashSet<>();
                }
                if (this.gm.contains(str)) {
                    com.baidu.adp.plugin.b.a.io().e("plugin_load", "repeat_inject_res", str, str2);
                }
                this.gm.add(str);
            }
            if (this.gl == null) {
                this.gl = new ArrayList<>();
            }
            if (!this.gl.contains(str2)) {
                if (Build.VERSION.SDK_INT >= 24) {
                    com.baidu.adp.plugin.util.f.a(this.gk.getAssets(), "addAssetPath", new Object[]{str2});
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
                    com.baidu.adp.plugin.util.f.a(this.gk.getAssets(), "addAssetPath", new Object[]{str2});
                } else {
                    AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                    if (this.gl.size() > 0) {
                        Iterator<String> it = this.gl.iterator();
                        while (it.hasNext()) {
                            com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{it.next()});
                        }
                    }
                    com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{str2});
                    com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                    this.gk = new Resources(assetManager, this.gk.getDisplayMetrics(), this.gk.getConfiguration());
                }
                this.gl.add(str2);
            }
        }
    }

    public synchronized Resources getResources() {
        return this.gk;
    }
}
