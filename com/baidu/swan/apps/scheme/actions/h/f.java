package com.baidu.swan.apps.scheme.actions.h;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.apps.an.y;
import com.baidu.swan.apps.install.c;
import com.baidu.swan.apps.install.subpackage.SubPackageAPSInfo;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class f {
    private static volatile f aQh;
    private HashMap<String, a> aQi = new HashMap<>();

    /* loaded from: classes2.dex */
    public interface a {
        void cG(int i);

        void eP(String str);
    }

    private f() {
    }

    public static f JL() {
        if (aQh == null) {
            synchronized (f.class) {
                if (aQh == null) {
                    aQh = new f();
                }
            }
        }
        return aQh;
    }

    public void a(com.baidu.swan.apps.ae.b bVar, String str, String str2, a aVar) {
        if (aVar != null) {
            if (bVar == null || TextUtils.isEmpty(str)) {
                aVar.cG(2110);
            } else if (bVar.gf(str)) {
                aVar.eP(str2);
            } else {
                String gh = bVar.gh(str);
                if (TextUtils.isEmpty(gh)) {
                    aVar.cG(2111);
                } else if (bVar.gg(gh)) {
                    aVar.eP(str2);
                } else {
                    String gi = bVar.gi(gh);
                    if (TextUtils.isEmpty(gi)) {
                        aVar.cG(2112);
                        return;
                    }
                    com.baidu.swan.apps.process.messaging.client.a BR = bVar.BR();
                    if (BR != null) {
                        SubPackageAPSInfo subPackageAPSInfo = new SubPackageAPSInfo();
                        String a2 = a(aVar);
                        subPackageAPSInfo.mAppId = bVar.id;
                        subPackageAPSInfo.mAppVersion = bVar.getVersion();
                        subPackageAPSInfo.mKey = gi;
                        subPackageAPSInfo.axm = com.baidu.swan.apps.w.e.Ec().DL();
                        subPackageAPSInfo.axn = gh;
                        subPackageAPSInfo.asI = str2;
                        subPackageAPSInfo.axp = a2;
                        BR.a(6, subPackageAPSInfo);
                        this.aQi.put(a2, aVar);
                        return;
                    }
                    aVar.cG(2113);
                }
            }
        }
    }

    public void a(com.baidu.swan.apps.process.messaging.client.a aVar, String str, String str2, String str3, String str4, String str5, String str6, a aVar2) {
        if (aVar2 != null) {
            if (aVar != null) {
                SubPackageAPSInfo subPackageAPSInfo = new SubPackageAPSInfo();
                String a2 = a(aVar2);
                subPackageAPSInfo.mAppId = str;
                subPackageAPSInfo.mAppVersion = str2;
                subPackageAPSInfo.mKey = str4;
                subPackageAPSInfo.axm = str5;
                subPackageAPSInfo.axn = str3;
                subPackageAPSInfo.asI = str6;
                subPackageAPSInfo.axp = a2;
                aVar.a(6, subPackageAPSInfo);
                this.aQi.put(a2, aVar2);
                return;
            }
            aVar2.cG(2113);
        }
    }

    public void v(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SubPackageAPSInfo subPackageAPSInfo = (SubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (subPackageAPSInfo != null && (aVar = this.aQi.get(subPackageAPSInfo.axp)) != null) {
                com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
                if (IX != null) {
                    IX.s(subPackageAPSInfo.axn, true);
                }
                aVar.eP(subPackageAPSInfo.asI);
                this.aQi.remove(subPackageAPSInfo.axp);
            }
        }
    }

    public void w(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SubPackageAPSInfo subPackageAPSInfo = (SubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (subPackageAPSInfo != null && (aVar = this.aQi.get(subPackageAPSInfo.axp)) != null) {
                aVar.cG(subPackageAPSInfo.mResultCode);
                this.aQi.remove(subPackageAPSInfo.axp);
            }
        }
    }

    public static boolean c(com.baidu.swan.apps.v.b.b bVar, c.g gVar) {
        if (gVar == null) {
            return false;
        }
        return b(bVar, gVar.awY);
    }

    public static boolean b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.ae.a.c cVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.axH)) {
            return false;
        }
        String hF = y.hF(bVar.axH);
        if (!TextUtils.isEmpty(hF) && hF.startsWith(File.separator)) {
            hF = hF.substring(1);
        }
        if (cVar == null || cVar.aOf == null) {
            return false;
        }
        if (cVar.aOf.go(hF)) {
            return false;
        }
        String str = cVar.aOg.aOu.get(hF);
        return (TextUtils.isEmpty(str) || com.baidu.swan.apps.database.subpackage.a.AV().m(bVar.mAppId, bVar.mVersion, str)) ? false : true;
    }

    private String a(a aVar) {
        return aVar != null ? aVar.toString() : "";
    }
}
