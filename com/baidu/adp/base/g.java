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
public class g {
    private static g pf = null;
    private Resources pg = null;
    private ArrayList<String> ph = null;
    private HashSet<String> pi = null;
    private String pj = null;

    public static g cr() {
        if (pf == null) {
            synchronized (g.class) {
                if (pf == null) {
                    pf = new g();
                }
            }
        }
        return pf;
    }

    public synchronized void a(Resources resources) {
        this.pg = resources;
    }

    public synchronized void g(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        Context context;
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("param resPath is null");
        }
        if (this.pg == null) {
            throw new RuntimeException("hostResources is null");
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.pi == null) {
                this.pi = new HashSet<>();
            }
            if (this.pi.contains(str)) {
                com.baidu.adp.plugin.b.a.jr().e("plugin_load", "repeat_inject_res", str, str2);
            }
            this.pi.add(str);
        }
        if (this.ph == null) {
            this.ph = new ArrayList<>();
        }
        if (!this.ph.contains(str2)) {
            if (Build.VERSION.SDK_INT >= 24) {
                com.baidu.adp.plugin.util.d.c(this.pg.getAssets(), "addAssetPath", new Object[]{str2});
                if (TextUtils.isEmpty(this.pj)) {
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
                                this.pj = str3;
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 20) {
                com.baidu.adp.plugin.util.d.c(this.pg.getAssets(), "addAssetPath", new Object[]{str2});
            } else {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                if (this.ph.size() > 0) {
                    Iterator<String> it = this.ph.iterator();
                    while (it.hasNext()) {
                        com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{it.next()});
                    }
                }
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{str2});
                com.baidu.adp.plugin.util.d.c(assetManager, "addAssetPath", new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                this.pg = new Resources(assetManager, this.pg.getDisplayMetrics(), this.pg.getConfiguration());
            }
            this.ph.add(str2);
        }
    }

    public synchronized Resources getResources() {
        return this.pg;
    }
}
