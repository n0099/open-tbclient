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
    private static volatile f aQm;
    private HashMap<String, a> aQn = new HashMap<>();

    /* loaded from: classes2.dex */
    public interface a {
        void cF(int i);

        void eQ(String str);
    }

    private f() {
    }

    public static f JJ() {
        if (aQm == null) {
            synchronized (f.class) {
                if (aQm == null) {
                    aQm = new f();
                }
            }
        }
        return aQm;
    }

    public void a(com.baidu.swan.apps.ae.b bVar, String str, String str2, a aVar) {
        if (aVar != null) {
            if (bVar == null || TextUtils.isEmpty(str)) {
                aVar.cF(2110);
            } else if (bVar.gg(str)) {
                aVar.eQ(str2);
            } else {
                String gi = bVar.gi(str);
                if (TextUtils.isEmpty(gi)) {
                    aVar.cF(2111);
                } else if (bVar.gh(gi)) {
                    aVar.eQ(str2);
                } else {
                    String gj = bVar.gj(gi);
                    if (TextUtils.isEmpty(gj)) {
                        aVar.cF(2112);
                        return;
                    }
                    com.baidu.swan.apps.process.messaging.client.a BP = bVar.BP();
                    if (BP != null) {
                        SubPackageAPSInfo subPackageAPSInfo = new SubPackageAPSInfo();
                        String a2 = a(aVar);
                        subPackageAPSInfo.mAppId = bVar.id;
                        subPackageAPSInfo.mAppVersion = bVar.getVersion();
                        subPackageAPSInfo.mKey = gj;
                        subPackageAPSInfo.axr = com.baidu.swan.apps.w.e.Ea().DJ();
                        subPackageAPSInfo.axs = gi;
                        subPackageAPSInfo.asO = str2;
                        subPackageAPSInfo.axu = a2;
                        BP.a(6, subPackageAPSInfo);
                        this.aQn.put(a2, aVar);
                        return;
                    }
                    aVar.cF(2113);
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
                subPackageAPSInfo.axr = str5;
                subPackageAPSInfo.axs = str3;
                subPackageAPSInfo.asO = str6;
                subPackageAPSInfo.axu = a2;
                aVar.a(6, subPackageAPSInfo);
                this.aQn.put(a2, aVar2);
                return;
            }
            aVar2.cF(2113);
        }
    }

    public void v(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SubPackageAPSInfo subPackageAPSInfo = (SubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (subPackageAPSInfo != null && (aVar = this.aQn.get(subPackageAPSInfo.axu)) != null) {
                com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
                if (IV != null) {
                    IV.s(subPackageAPSInfo.axs, true);
                }
                aVar.eQ(subPackageAPSInfo.asO);
                this.aQn.remove(subPackageAPSInfo.axu);
            }
        }
    }

    public void w(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            SubPackageAPSInfo subPackageAPSInfo = (SubPackageAPSInfo) bundle.getParcelable("ai_apps_data");
            if (subPackageAPSInfo != null && (aVar = this.aQn.get(subPackageAPSInfo.axu)) != null) {
                aVar.cF(subPackageAPSInfo.mResultCode);
                this.aQn.remove(subPackageAPSInfo.axu);
            }
        }
    }

    public static boolean c(com.baidu.swan.apps.v.b.b bVar, c.g gVar) {
        if (gVar == null) {
            return false;
        }
        return b(bVar, gVar.axd);
    }

    public static boolean b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.ae.a.c cVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.axM)) {
            return false;
        }
        String hG = y.hG(bVar.axM);
        if (!TextUtils.isEmpty(hG) && hG.startsWith(File.separator)) {
            hG = hG.substring(1);
        }
        if (cVar == null || cVar.aOk == null) {
            return false;
        }
        if (cVar.aOk.gp(hG)) {
            return false;
        }
        String str = cVar.aOl.aOz.get(hG);
        return (TextUtils.isEmpty(str) || com.baidu.swan.apps.database.subpackage.a.AT().m(bVar.mAppId, bVar.mVersion, str)) ? false : true;
    }

    private String a(a aVar) {
        return aVar != null ? aVar.toString() : "";
    }
}
