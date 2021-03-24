package com.baidu.nps.stub.pkginfo;

import android.app.Application;
import android.content.pm.PackageInfo;
import com.baidu.nps.stub.context.ContextHolderImpl;
import com.baidu.nps.utils.Constant;
import d.b.z.h.c;
import d.b.z.h.d;
/* loaded from: classes2.dex */
public class PackageInfoHolder {
    public static PackageInfo getPackageInfo(String str, int i) {
        Application applicationContext = ContextHolderImpl.getApplicationContext();
        return d.a(c.d(applicationContext, str + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).getAbsolutePath(), i);
    }
}
