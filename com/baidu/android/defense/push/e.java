package com.baidu.android.defense.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e extends h {
    public e(String str, Context context) {
        super(str, context);
    }

    private boolean a(com.baidu.android.defense.pkgmanager.c cVar) {
        com.baidu.android.defense.pkgmanager.c cVar2;
        if (cVar == null || TextUtils.isEmpty(cVar.a())) {
            return false;
        }
        Iterator<PackageInfo> it = this.d.getPackageManager().getInstalledPackages(0).iterator();
        while (true) {
            if (!it.hasNext()) {
                cVar2 = null;
                break;
            }
            PackageInfo next = it.next();
            if (next.packageName == cVar.a()) {
                com.baidu.android.defense.pkgmanager.c cVar3 = new com.baidu.android.defense.pkgmanager.c();
                cVar3.a(next.packageName);
                cVar3.a(next.versionCode);
                cVar2 = cVar3;
                break;
            }
        }
        if (cVar2 != null && cVar.b() != 0 && cVar2.b() != cVar.b()) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.android.defense.push.h, com.baidu.android.defense.push.n
    public boolean b() {
        if (this.c) {
            if (this.a != null) {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    com.baidu.android.defense.pkgmanager.c cVar = (com.baidu.android.defense.pkgmanager.c) it.next();
                    if (a(cVar)) {
                        com.baidu.android.defense.pkgmanager.d.a(this.d).a(true, cVar);
                    }
                }
            }
            return true;
        }
        return false;
    }
}
