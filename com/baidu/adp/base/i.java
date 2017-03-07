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
    private static i nY = null;
    private Resources nZ = null;
    private ArrayList<String> oa = null;
    private HashSet<String> ob = null;

    public static i ch() {
        if (nY == null) {
            synchronized (i.class) {
                if (nY == null) {
                    nY = new i();
                }
            }
        }
        return nY;
    }

    public synchronized void a(Resources resources) {
        this.nZ = resources;
    }

    public synchronized void g(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        PackageInfo packageInfo;
        synchronized (this) {
            if (TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("param resPath is null");
            }
            if (this.nZ == null) {
                throw new RuntimeException("hostResources is null");
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.ob == null) {
                    this.ob = new HashSet<>();
                }
                if (this.ob.contains(str)) {
                    com.baidu.adp.plugin.b.a.jg().e("plugin_load", "repeat_inject_res", str, str2);
                }
                this.ob.add(str);
            }
            if (this.oa == null) {
                this.oa = new ArrayList<>();
            }
            if (!this.oa.contains(str2)) {
                if (Build.VERSION.SDK_INT >= 24) {
                    com.baidu.adp.plugin.util.f.a(this.nZ.getAssets(), "addAssetPath", new Object[]{str2});
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
                    com.baidu.adp.plugin.util.f.a(this.nZ.getAssets(), "addAssetPath", new Object[]{str2});
                } else {
                    AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                    if (this.oa.size() > 0) {
                        Iterator<String> it = this.oa.iterator();
                        while (it.hasNext()) {
                            com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{it.next()});
                        }
                    }
                    com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{str2});
                    com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                    this.nZ = new Resources(assetManager, this.nZ.getDisplayMetrics(), this.nZ.getConfiguration());
                }
                this.oa.add(str2);
            }
        }
    }

    public synchronized Resources getResources() {
        return this.nZ;
    }
}
