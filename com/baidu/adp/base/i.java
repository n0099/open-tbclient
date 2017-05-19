package com.baidu.adp.base;

import android.content.Context;
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
    private static i nx = null;
    private Resources ny = null;
    private ArrayList<String> nz = null;
    private HashSet<String> nA = null;
    private String nB = null;

    public static i cg() {
        if (nx == null) {
            synchronized (i.class) {
                if (nx == null) {
                    nx = new i();
                }
            }
        }
        return nx;
    }

    public synchronized void a(Resources resources) {
        this.ny = resources;
    }

    public synchronized void g(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        Context context;
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
                com.baidu.adp.plugin.b.a.jk().e("plugin_load", "repeat_inject_res", str, str2);
            }
            this.nA.add(str);
        }
        if (this.nz == null) {
            this.nz = new ArrayList<>();
        }
        if (!this.nz.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 24) {
                com.baidu.adp.plugin.util.f.a(this.ny.getAssets(), "addAssetPath", new Object[]{str2});
                if (TextUtils.isEmpty(this.nB)) {
                    try {
                        Method declaredMethod = Class.forName("android.webkit.WebViewFactory").getDeclaredMethod("getWebViewContextAndSetProvider", new Class[0]);
                        declaredMethod.setAccessible(true);
                        Object invoke = declaredMethod.invoke(null, new Object[0]);
                        if ((invoke instanceof Context) && (context = (Context) invoke) != null) {
                            String str3 = context.getApplicationInfo().sourceDir;
                            if (!TextUtils.isEmpty(str3)) {
                                String[] strArr = BdBaseApplication.getInst().getApplicationInfo().sharedLibraryFiles;
                                int length = (strArr != null ? strArr.length : 0) + 1;
                                String[] strArr2 = new String[length];
                                if (strArr != null) {
                                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                                }
                                strArr2[length - 1] = str3;
                                BdBaseApplication.getInst().getApplicationInfo().sharedLibraryFiles = strArr2;
                                this.nB = str3;
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 20) {
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
