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
    private static volatile g aUi;
    private HashMap<String, a> aUj = new HashMap<>();

    /* loaded from: classes2.dex */
    public interface a {
        void cK(int i);

        void fh(String str);
    }

    private g() {
    }

    public static g Nb() {
        if (aUi == null) {
            synchronized (g.class) {
                if (aUi == null) {
                    aUi = new g();
                }
            }
        }
        return aUi;
    }

    public void a(com.baidu.swan.apps.ae.b bVar, String str, String str2, a aVar) {
        boolean z = true;
        if (aVar != null) {
            if (bVar == null || TextUtils.isEmpty(str)) {
                aVar.cK(2110);
            } else if (bVar.gH(str)) {
                aVar.fh(str2);
            } else {
                String gL = bVar.gL(str);
                if (TextUtils.isEmpty(gL)) {
                    aVar.cK(2111);
                } else if (bVar.gI(gL)) {
                    aVar.fh(str2);
                } else {
                    if (!bVar.gJ(gL)) {
                        z = false;
                    } else if (bVar.gK(gL)) {
                        aVar.fh(str2);
                        bVar.t(gL, true);
                        return;
                    }
                    String gM = bVar.gM(gL);
                    if (TextUtils.isEmpty(gM)) {
                        aVar.cK(2112);
                        return;
                    }
                    com.baidu.swan.apps.process.messaging.client.a DE = bVar.DE();
                    if (DE != null) {
                        SubPackageAPSInfo subPackageAPSInfo = new SubPackageAPSInfo();
                        String a2 = a(aVar);
                        subPackageAPSInfo.mAppId = bVar.id;
                        subPackageAPSInfo.mAppVersion = bVar.getVersion();
                        subPackageAPSInfo.mKey = gM;
                        subPackageAPSInfo.azj = com.baidu.swan.apps.w.e.GJ().Gs();
                        subPackageAPSInfo.azk = gL;
                        subPackageAPSInfo.aud = str2;
                        subPackageAPSInfo.azm = a2;
                        subPackageAPSInfo.azn = z;
                        DE.a(6, subPackageAPSInfo);
                        this.aUj.put(a2, aVar);
                        return;
                    }
                    aVar.cK(2113);
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
                subPackageAPSInfo.azj = str5;
                subPackageAPSInfo.azk = str3;
                subPackageAPSInfo.aud = str6;
                subPackageAPSInfo.azm = a2;
                aVar.a(6, subPackageAPSInfo);
                this.aUj.put(a2, aVar2);
                return;
            }
            aVar2.cK(2113);
        }
    }

    public void w(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SubPackageAPSInfo subPackageAPSInfo = (SubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (subPackageAPSInfo != null && (aVar = this.aUj.get(subPackageAPSInfo.azm)) != null) {
                com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
                if (Mh != null) {
                    Mh.t(subPackageAPSInfo.azk, true);
                }
                aVar.fh(subPackageAPSInfo.aud);
                this.aUj.remove(subPackageAPSInfo.azm);
            }
        }
    }

    public void x(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SubPackageAPSInfo subPackageAPSInfo = (SubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (subPackageAPSInfo != null && (aVar = this.aUj.get(subPackageAPSInfo.azm)) != null) {
                aVar.cK(subPackageAPSInfo.mResultCode);
                this.aUj.remove(subPackageAPSInfo.azm);
            }
        }
    }

    public static boolean c(com.baidu.swan.apps.v.b.b bVar, e.g gVar) {
        if (gVar == null) {
            return false;
        }
        return b(bVar, gVar.ayO);
    }

    public static boolean b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.ae.a.c cVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.getPage())) {
            return false;
        }
        String is = aa.is(bVar.getPage());
        if (!TextUtils.isEmpty(is) && is.startsWith(File.separator)) {
            is = is.substring(1);
        }
        if (cVar == null || cVar.aRv == null) {
            return false;
        }
        if (cVar.aRv.gS(is)) {
            return false;
        }
        String str = cVar.aRw.aRK.get(is);
        return (TextUtils.isEmpty(str) || com.baidu.swan.apps.database.subpackage.a.CO().m(bVar.getAppId(), bVar.getVersion(), str)) ? false : true;
    }

    private String a(a aVar) {
        return aVar != null ? aVar.toString() : "";
    }
}
