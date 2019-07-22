package com.baidu.swan.apps.scheme.actions.i;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.install.e;
import com.baidu.swan.apps.install.subpackage.SubPackageAPSInfo;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class g {
    private static volatile g aTK;
    private HashMap<String, a> aTL = new HashMap<>();

    /* loaded from: classes2.dex */
    public interface a {
        void cJ(int i);

        void ff(String str);
    }

    private g() {
    }

    public static g MX() {
        if (aTK == null) {
            synchronized (g.class) {
                if (aTK == null) {
                    aTK = new g();
                }
            }
        }
        return aTK;
    }

    public void a(com.baidu.swan.apps.ae.b bVar, String str, String str2, a aVar) {
        boolean z = true;
        if (aVar != null) {
            if (bVar == null || TextUtils.isEmpty(str)) {
                aVar.cJ(2110);
            } else if (bVar.gF(str)) {
                aVar.ff(str2);
            } else {
                String gJ = bVar.gJ(str);
                if (TextUtils.isEmpty(gJ)) {
                    aVar.cJ(2111);
                } else if (bVar.gG(gJ)) {
                    aVar.ff(str2);
                } else {
                    if (!bVar.gH(gJ)) {
                        z = false;
                    } else if (bVar.gI(gJ)) {
                        aVar.ff(str2);
                        bVar.t(gJ, true);
                        return;
                    }
                    String gK = bVar.gK(gJ);
                    if (TextUtils.isEmpty(gK)) {
                        aVar.cJ(2112);
                        return;
                    }
                    com.baidu.swan.apps.process.messaging.client.a DA = bVar.DA();
                    if (DA != null) {
                        SubPackageAPSInfo subPackageAPSInfo = new SubPackageAPSInfo();
                        String a2 = a(aVar);
                        subPackageAPSInfo.mAppId = bVar.id;
                        subPackageAPSInfo.mAppVersion = bVar.getVersion();
                        subPackageAPSInfo.mKey = gK;
                        subPackageAPSInfo.ayL = com.baidu.swan.apps.w.e.GF().Go();
                        subPackageAPSInfo.ayM = gJ;
                        subPackageAPSInfo.atF = str2;
                        subPackageAPSInfo.ayO = a2;
                        subPackageAPSInfo.ayP = z;
                        DA.a(6, subPackageAPSInfo);
                        this.aTL.put(a2, aVar);
                        return;
                    }
                    aVar.cJ(2113);
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
                subPackageAPSInfo.ayL = str5;
                subPackageAPSInfo.ayM = str3;
                subPackageAPSInfo.atF = str6;
                subPackageAPSInfo.ayO = a2;
                aVar.a(6, subPackageAPSInfo);
                this.aTL.put(a2, aVar2);
                return;
            }
            aVar2.cJ(2113);
        }
    }

    public void w(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SubPackageAPSInfo subPackageAPSInfo = (SubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (subPackageAPSInfo != null && (aVar = this.aTL.get(subPackageAPSInfo.ayO)) != null) {
                com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
                if (Md != null) {
                    Md.t(subPackageAPSInfo.ayM, true);
                }
                aVar.ff(subPackageAPSInfo.atF);
                this.aTL.remove(subPackageAPSInfo.ayO);
            }
        }
    }

    public void x(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SubPackageAPSInfo subPackageAPSInfo = (SubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (subPackageAPSInfo != null && (aVar = this.aTL.get(subPackageAPSInfo.ayO)) != null) {
                aVar.cJ(subPackageAPSInfo.mResultCode);
                this.aTL.remove(subPackageAPSInfo.ayO);
            }
        }
    }

    public static boolean c(com.baidu.swan.apps.v.b.b bVar, e.g gVar) {
        if (gVar == null) {
            return false;
        }
        return b(bVar, gVar.ayq);
    }

    public static boolean b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.ae.a.c cVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.getPage())) {
            return false;
        }
        String iq = aa.iq(bVar.getPage());
        if (!TextUtils.isEmpty(iq) && iq.startsWith(File.separator)) {
            iq = iq.substring(1);
        }
        if (cVar == null || cVar.aQX == null) {
            return false;
        }
        if (cVar.aQX.gQ(iq)) {
            return false;
        }
        String str = cVar.aQY.aRm.get(iq);
        return (TextUtils.isEmpty(str) || com.baidu.swan.apps.database.subpackage.a.CK().m(bVar.getAppId(), bVar.getVersion(), str)) ? false : true;
    }

    private String a(a aVar) {
        return aVar != null ? aVar.toString() : "";
    }
}
