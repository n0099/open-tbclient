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
    private static volatile g bnm;
    private HashMap<String, a> bnn = new HashMap<>();

    /* loaded from: classes2.dex */
    public interface a {
        void dF(int i);

        void fO(String str);
    }

    private g() {
    }

    public static g RR() {
        if (bnm == null) {
            synchronized (g.class) {
                if (bnm == null) {
                    bnm = new g();
                }
            }
        }
        return bnm;
    }

    public void a(com.baidu.swan.apps.ae.b bVar, String str, String str2, a aVar) {
        boolean z = true;
        if (aVar != null) {
            if (bVar == null || TextUtils.isEmpty(str)) {
                aVar.dF(2110);
            } else if (bVar.hl(str)) {
                aVar.fO(str2);
            } else {
                String hp = bVar.hp(str);
                if (TextUtils.isEmpty(hp)) {
                    aVar.dF(2111);
                } else if (bVar.hm(hp)) {
                    aVar.fO(str2);
                } else {
                    if (!bVar.hn(hp)) {
                        z = false;
                    } else if (bVar.ho(hp)) {
                        aVar.fO(str2);
                        bVar.w(hp, true);
                        return;
                    }
                    String hq = bVar.hq(hp);
                    if (TextUtils.isEmpty(hq)) {
                        aVar.dF(2112);
                        return;
                    }
                    com.baidu.swan.apps.process.messaging.client.a Iy = bVar.Iy();
                    if (Iy != null) {
                        SubPackageAPSInfo subPackageAPSInfo = new SubPackageAPSInfo();
                        String a2 = a(aVar);
                        subPackageAPSInfo.mAppId = bVar.id;
                        subPackageAPSInfo.mAppVersion = bVar.getVersion();
                        subPackageAPSInfo.mKey = hq;
                        subPackageAPSInfo.aSz = com.baidu.swan.apps.w.e.LD().Lm();
                        subPackageAPSInfo.aSA = hp;
                        subPackageAPSInfo.aNu = str2;
                        subPackageAPSInfo.mCallbackKey = a2;
                        subPackageAPSInfo.aSC = z;
                        Iy.a(6, subPackageAPSInfo);
                        this.bnn.put(a2, aVar);
                        return;
                    }
                    aVar.dF(2113);
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
                subPackageAPSInfo.aSz = str5;
                subPackageAPSInfo.aSA = str3;
                subPackageAPSInfo.aNu = str6;
                subPackageAPSInfo.mCallbackKey = a2;
                aVar.a(6, subPackageAPSInfo);
                this.bnn.put(a2, aVar2);
                return;
            }
            aVar2.dF(2113);
        }
    }

    public void w(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SubPackageAPSInfo subPackageAPSInfo = (SubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (subPackageAPSInfo != null && (aVar = this.bnn.get(subPackageAPSInfo.mCallbackKey)) != null) {
                com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
                if (QZ != null) {
                    QZ.w(subPackageAPSInfo.aSA, true);
                }
                aVar.fO(subPackageAPSInfo.aNu);
                this.bnn.remove(subPackageAPSInfo.mCallbackKey);
            }
        }
    }

    public void x(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SubPackageAPSInfo subPackageAPSInfo = (SubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (subPackageAPSInfo != null && (aVar = this.bnn.get(subPackageAPSInfo.mCallbackKey)) != null) {
                aVar.dF(subPackageAPSInfo.mResultCode);
                this.bnn.remove(subPackageAPSInfo.mCallbackKey);
            }
        }
    }

    public static boolean c(com.baidu.swan.apps.v.b.b bVar, e.g gVar) {
        if (gVar == null) {
            return false;
        }
        return b(bVar, gVar.aSe);
    }

    public static boolean b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.ae.a.c cVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.getPage())) {
            return false;
        }
        String iV = aa.iV(bVar.getPage());
        if (!TextUtils.isEmpty(iV) && iV.startsWith(File.separator)) {
            iV = iV.substring(1);
        }
        if (cVar == null || cVar.bkz == null) {
            return false;
        }
        if (cVar.bkz.hw(iV)) {
            return false;
        }
        String str = cVar.bkA.bkO.get(iV);
        return (TextUtils.isEmpty(str) || com.baidu.swan.apps.database.subpackage.a.HI().q(bVar.getAppId(), bVar.getVersion(), str)) ? false : true;
    }

    private String a(a aVar) {
        return aVar != null ? aVar.toString() : "";
    }
}
