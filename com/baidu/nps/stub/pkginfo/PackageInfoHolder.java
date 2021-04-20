package com.baidu.nps.stub.pkginfo;

import android.app.Application;
import android.content.pm.PackageInfo;
import com.baidu.nps.stub.context.ContextHolderImpl;
import d.b.w.h.c;
import d.b.w.h.d;
/* loaded from: classes2.dex */
public class PackageInfoHolder {
    public static PackageInfo getPackageInfo(String str, int i) {
        Application applicationContext = ContextHolderImpl.getApplicationContext();
        return d.a(c.d(applicationContext, str + ".apk").getAbsolutePath(), i);
    }
}
