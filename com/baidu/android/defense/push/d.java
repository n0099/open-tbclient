package com.baidu.android.defense.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d extends f {
    public d(String str, Context context) {
        super(str, context);
    }

    private boolean a(com.baidu.android.defense.b.a aVar) {
        com.baidu.android.defense.b.a aVar2;
        if (aVar == null || TextUtils.isEmpty(aVar.a())) {
            return false;
        }
        Iterator<PackageInfo> it = this.c.getPackageManager().getInstalledPackages(0).iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar2 = null;
                break;
            }
            PackageInfo next = it.next();
            if (next.packageName == aVar.a()) {
                com.baidu.android.defense.b.a aVar3 = new com.baidu.android.defense.b.a();
                aVar3.a(next.packageName);
                aVar3.a(next.versionCode);
                aVar2 = aVar3;
                break;
            }
        }
        if (aVar2 != null && aVar.b() != 0 && aVar2.b() != aVar.b()) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.android.defense.push.f, com.baidu.android.defense.push.a
    public boolean a() {
        if (this.b) {
            if (this.d != null) {
                Iterator it = this.d.iterator();
                while (it.hasNext()) {
                    com.baidu.android.defense.b.a aVar = (com.baidu.android.defense.b.a) it.next();
                    if (a(aVar)) {
                        com.baidu.android.defense.b.b.a(this.c).a(true, aVar);
                    }
                }
            }
            return true;
        }
        return false;
    }
}
