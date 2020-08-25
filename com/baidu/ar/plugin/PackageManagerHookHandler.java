package com.baidu.ar.plugin;

import android.content.pm.PackageInfo;
import android.util.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
/* loaded from: classes20.dex */
public class PackageManagerHookHandler implements InvocationHandler {
    private Object mBase;
    private PluginPackageParser mPPP;

    public PackageManagerHookHandler(Object obj, PluginPackageParser pluginPackageParser) {
        this.mBase = obj;
        this.mPPP = pluginPackageParser;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (method.getName().equals("getPackageInfo") && objArr[0] == "com.google.ar.core") {
            PackageInfo packageInfo = new PackageInfo();
            packageInfo.packageName = "com.google.ar.core";
            packageInfo.versionCode = 190128146;
            packageInfo.versionName = "1.7.190120000";
            if (this.mPPP != null) {
                Log.i("andrew", "get Package info flag:" + objArr[1]);
                packageInfo = this.mPPP.getPackageInfo(((Integer) objArr[1]).intValue());
            }
            Log.d("andrew", "method:" + method.getName() + " called with args:" + Arrays.toString(objArr) + ";package info:" + packageInfo);
            return packageInfo;
        }
        return method.invoke(this.mBase, objArr);
    }
}
