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
    private static volatile g aTa;
    private HashMap<String, a> aTb = new HashMap<>();

    /* loaded from: classes2.dex */
    public interface a {
        void cI(int i);

        void fa(String str);
    }

    private g() {
    }

    public static g Mj() {
        if (aTa == null) {
            synchronized (g.class) {
                if (aTa == null) {
                    aTa = new g();
                }
            }
        }
        return aTa;
    }

    public void a(com.baidu.swan.apps.ae.b bVar, String str, String str2, a aVar) {
        boolean z = true;
        if (aVar != null) {
            if (bVar == null || TextUtils.isEmpty(str)) {
                aVar.cI(2110);
            } else if (bVar.gy(str)) {
                aVar.fa(str2);
            } else {
                String gC = bVar.gC(str);
                if (TextUtils.isEmpty(gC)) {
                    aVar.cI(2111);
                } else if (bVar.gz(gC)) {
                    aVar.fa(str2);
                } else {
                    if (!bVar.gA(gC)) {
                        z = false;
                    } else if (bVar.gB(gC)) {
                        aVar.fa(str2);
                        bVar.s(gC, true);
                        return;
                    }
                    String gD = bVar.gD(gC);
                    if (TextUtils.isEmpty(gD)) {
                        aVar.cI(2112);
                        return;
                    }
                    com.baidu.swan.apps.process.messaging.client.a CR = bVar.CR();
                    if (CR != null) {
                        SubPackageAPSInfo subPackageAPSInfo = new SubPackageAPSInfo();
                        String a2 = a(aVar);
                        subPackageAPSInfo.mAppId = bVar.id;
                        subPackageAPSInfo.mAppVersion = bVar.getVersion();
                        subPackageAPSInfo.mKey = gD;
                        subPackageAPSInfo.aye = com.baidu.swan.apps.w.e.FV().FE();
                        subPackageAPSInfo.ayf = gC;
                        subPackageAPSInfo.atc = str2;
                        subPackageAPSInfo.ayh = a2;
                        subPackageAPSInfo.ayi = z;
                        CR.a(6, subPackageAPSInfo);
                        this.aTb.put(a2, aVar);
                        return;
                    }
                    aVar.cI(2113);
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
                subPackageAPSInfo.aye = str5;
                subPackageAPSInfo.ayf = str3;
                subPackageAPSInfo.atc = str6;
                subPackageAPSInfo.ayh = a2;
                aVar.a(6, subPackageAPSInfo);
                this.aTb.put(a2, aVar2);
                return;
            }
            aVar2.cI(2113);
        }
    }

    public void w(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SubPackageAPSInfo subPackageAPSInfo = (SubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (subPackageAPSInfo != null && (aVar = this.aTb.get(subPackageAPSInfo.ayh)) != null) {
                com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
                if (Lq != null) {
                    Lq.s(subPackageAPSInfo.ayf, true);
                }
                aVar.fa(subPackageAPSInfo.atc);
                this.aTb.remove(subPackageAPSInfo.ayh);
            }
        }
    }

    public void x(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SubPackageAPSInfo subPackageAPSInfo = (SubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (subPackageAPSInfo != null && (aVar = this.aTb.get(subPackageAPSInfo.ayh)) != null) {
                aVar.cI(subPackageAPSInfo.mResultCode);
                this.aTb.remove(subPackageAPSInfo.ayh);
            }
        }
    }

    public static boolean c(com.baidu.swan.apps.v.b.b bVar, e.g gVar) {
        if (gVar == null) {
            return false;
        }
        return b(bVar, gVar.axJ);
    }

    public static boolean b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.ae.a.c cVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.getPage())) {
            return false;
        }
        String ij = aa.ij(bVar.getPage());
        if (!TextUtils.isEmpty(ij) && ij.startsWith(File.separator)) {
            ij = ij.substring(1);
        }
        if (cVar == null || cVar.aQn == null) {
            return false;
        }
        if (cVar.aQn.gJ(ij)) {
            return false;
        }
        String str = cVar.aQo.aQC.get(ij);
        return (TextUtils.isEmpty(str) || com.baidu.swan.apps.database.subpackage.a.Cb().m(bVar.getAppId(), bVar.getVersion(), str)) ? false : true;
    }

    private String a(a aVar) {
        return aVar != null ? aVar.toString() : "";
    }
}
