package com.baidu.nps.stub.pkginfo;

import android.app.Application;
import android.content.pm.PackageInfo;
import com.baidu.nps.stub.context.ContextHolderImpl;
import d.a.x.i.c;
import d.a.x.i.e;
/* loaded from: classes2.dex */
public class PackageInfoHolder {
    public static PackageInfo getPackageInfo(String str, int i2) {
        Application applicationContext = ContextHolderImpl.getApplicationContext();
        return e.a(c.d(applicationContext, str + ".apk").getAbsolutePath(), i2);
    }
}
