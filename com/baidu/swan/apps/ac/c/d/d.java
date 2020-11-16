package com.baidu.swan.apps.ac.c.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.r.d;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends b {
    @Override // com.baidu.swan.apps.ac.c.d.b
    com.baidu.swan.apps.api.c.b bq(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new com.baidu.swan.apps.api.c.b(201, "args params is null");
        }
        if (jSONObject.optLong("fee") < 0) {
            return new com.baidu.swan.apps.api.c.b(201, "fee can't smaller than 0");
        }
        if (jSONObject.optJSONObject("paymentArgs") == null) {
            return new com.baidu.swan.apps.api.c.b(201, "paymentArgs can't be null");
        }
        return null;
    }

    @Override // com.baidu.swan.apps.ac.c.d.b
    boolean aDO() {
        return true;
    }

    @Override // com.baidu.swan.apps.ac.c.d.b
    com.baidu.swan.apps.api.c.b a(com.baidu.swan.apps.ac.c.b.b bVar, com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a> bVar2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.swan.apps.ac.c.d.b
    public String aDP() {
        return null;
    }

    @Override // com.baidu.swan.apps.ac.c.d.b
    com.baidu.swan.apps.ac.c.b.a b(com.baidu.swan.apps.ac.c.b.b bVar) {
        File file;
        int i;
        if (bVar == null) {
            return null;
        }
        String str = bVar.diZ;
        String str2 = bVar.djb;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        com.baidu.swan.apps.ac.c.b.a aVar = new com.baidu.swan.apps.ac.c.b.a();
        aVar.appKey = str;
        aVar.diU = str2;
        if (com.baidu.swan.apps.console.debugger.a.e.all()) {
            file = d.e.akY();
        } else if (com.baidu.swan.apps.ad.a.a.aEj()) {
            file = d.a.akY();
        } else if (TextUtils.equals(bVar.djc, "develop")) {
            String lV = com.baidu.swan.apps.f.a.lV(str);
            File avI = com.baidu.swan.apps.r.d.avI();
            String[] list = avI.list();
            if (list == null || avI.length() == 0) {
                return aVar;
            }
            String str3 = lV + "_dev";
            int i2 = -1;
            for (String str4 : list) {
                if (!TextUtils.isEmpty(str4) && str4.startsWith(str3)) {
                    try {
                        int parseInt = Integer.parseInt(str4.substring(str3.length()));
                        if (parseInt <= i2) {
                            parseInt = i2;
                        }
                        i2 = parseInt;
                    } catch (NumberFormatException e) {
                        com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
                    }
                }
            }
            if (i2 > -1) {
                aVar.appKey = str3 + i2;
                aVar.diX = true;
                file = new File(avI, aVar.appKey + File.separator + i2);
                aVar.diV = file.getAbsolutePath();
                aVar.diW = i2;
            } else {
                aVar.diX = false;
                aVar.diV = null;
                file = null;
            }
        } else {
            File file2 = new File(com.baidu.swan.apps.r.d.avI(), str);
            if (!file2.exists()) {
                return aVar;
            }
            String[] list2 = file2.list();
            if (list2 == null || list2.length == 0) {
                return aVar;
            }
            int i3 = -1;
            int length = list2.length;
            int i4 = 0;
            String str5 = null;
            while (i4 < length) {
                String str6 = list2[i4];
                if (TextUtils.isEmpty(str6)) {
                    i = i3;
                } else {
                    int i5 = -1;
                    try {
                        i5 = Integer.parseInt(str6);
                    } catch (NumberFormatException e2) {
                        com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e2));
                    }
                    if (i5 > i3) {
                        str5 = str6;
                        i = i5;
                    } else {
                        i = i3;
                    }
                }
                i4++;
                i3 = i;
            }
            if (i3 == -1) {
                file = null;
            } else {
                aVar.diW = i3;
                aVar.diX = true;
                File file3 = new File(file2, str5);
                aVar.diV = file3.getAbsolutePath();
                file = file3;
            }
        }
        if (file == null) {
            return aVar;
        }
        File file4 = new File(file, str2);
        if (I(file4)) {
            aVar.diY = true;
            aVar.diV = file4.getAbsolutePath();
            return aVar;
        }
        return aVar;
    }

    @Override // com.baidu.swan.apps.ac.c.d.b
    com.baidu.swan.apps.api.c.b a(final String str, final com.baidu.swan.apps.ac.c.b.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.api.c.b(201, "pay args is null");
        }
        SwanAppActivity aGG = com.baidu.swan.apps.runtime.d.aGI().aGG();
        if (aGG == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "runtime exception, try reopen this app");
        }
        final f afe = aGG.afe();
        if (afe == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "runtime exception, page manager breakdown");
        }
        com.baidu.swan.apps.ac.d.a.print("jump to fun page");
        com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.ac.c.d.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.model.b bVar2 = new com.baidu.swan.apps.model.b();
                bVar2.mBaseUrl = str;
                bVar2.mParams = com.baidu.swan.apps.ac.c.c.a.a(bVar);
                afe.mV("navigateTo").al(f.cJi, f.cJk).a("pluginFunPage", bVar2).commit();
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }

    private boolean I(File file) {
        String[] list;
        return file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length > 0;
    }
}
