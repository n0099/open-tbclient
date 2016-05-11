package com.baidu.adp.plugin.packageManager.a;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
/* loaded from: classes.dex */
public class a extends i {
    int errorCode;
    String errorMsg;
    String pkgName;
    int priority;
    PluginPackageManager.PluginStatus vH;
    String vI;
    boolean vJ;

    public String getPkgName() {
        return this.pkgName;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String in() {
        return this.vI;
    }
}
