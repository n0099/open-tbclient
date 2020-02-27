package com.baidu.swan.apps.ag.c.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.t.e;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends b {
    @Override // com.baidu.swan.apps.ag.c.d.b
    com.baidu.swan.apps.api.b.b ax(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new com.baidu.swan.apps.api.b.b(201, "args params is null");
        }
        if (jSONObject.optLong("fee") < 0) {
            return new com.baidu.swan.apps.api.b.b(201, "fee can't smaller than 0");
        }
        if (jSONObject.optJSONObject("paymentArgs") == null) {
            return new com.baidu.swan.apps.api.b.b(201, "paymentArgs can't be null");
        }
        return null;
    }

    @Override // com.baidu.swan.apps.ag.c.d.b
    boolean aag() {
        return true;
    }

    @Override // com.baidu.swan.apps.ag.c.d.b
    com.baidu.swan.apps.api.b.b a(com.baidu.swan.apps.ag.c.b.b bVar, com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a> bVar2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.swan.apps.ag.c.d.b
    public String aah() {
        return null;
    }

    @Override // com.baidu.swan.apps.ag.c.d.b
    com.baidu.swan.apps.ag.c.b.a b(com.baidu.swan.apps.ag.c.b.b bVar) {
        File file;
        int i;
        if (bVar == null) {
            return null;
        }
        String str = bVar.bIp;
        String str2 = bVar.bIr;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        com.baidu.swan.apps.ag.c.b.a aVar = new com.baidu.swan.apps.ag.c.b.a();
        aVar.appKey = str;
        aVar.bIk = str2;
        if (com.baidu.swan.apps.console.debugger.a.e.LN()) {
            file = e.C0302e.LA();
        } else if (com.baidu.swan.apps.ah.a.a.aaB()) {
            file = e.a.LA();
        } else if (TextUtils.equals(bVar.bIs, "develop")) {
            String gi = com.baidu.swan.apps.e.a.gi(str);
            File TL = com.baidu.swan.apps.t.e.TL();
            String[] list = TL.list();
            if (list == null || TL.length() == 0) {
                return aVar;
            }
            String str3 = gi + "_dev";
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
                        com.baidu.swan.apps.ag.d.a.print(Log.getStackTraceString(e));
                    }
                }
            }
            if (i2 > -1) {
                aVar.appKey = str3 + i2;
                aVar.bIn = true;
                file = new File(TL, aVar.appKey + File.separator + i2);
                aVar.bIl = file.getAbsolutePath();
                aVar.bIm = i2;
            } else {
                aVar.bIn = false;
                aVar.bIl = null;
                file = null;
            }
        } else {
            File file2 = new File(com.baidu.swan.apps.t.e.TL(), str);
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
                        com.baidu.swan.apps.ag.d.a.print(Log.getStackTraceString(e2));
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
                aVar.bIm = i3;
                aVar.bIn = true;
                File file3 = new File(file2, str5);
                aVar.bIl = file3.getAbsolutePath();
                file = file3;
            }
        }
        if (file == null) {
            return aVar;
        }
        File file4 = new File(file, str2);
        if (w(file4)) {
            aVar.bIo = true;
            aVar.bIl = file4.getAbsolutePath();
            return aVar;
        }
        return aVar;
    }

    @Override // com.baidu.swan.apps.ag.c.d.b
    com.baidu.swan.apps.api.b.b a(final String str, final com.baidu.swan.apps.ag.c.b.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.api.b.b(201, "pay args is null");
        }
        SwanAppActivity acz = com.baidu.swan.apps.runtime.d.acA().acz();
        if (acz == null) {
            return new com.baidu.swan.apps.api.b.b(1001, "runtime exception, try reopen this app");
        }
        final com.baidu.swan.apps.core.d.e GA = acz.GA();
        if (GA == null) {
            return new com.baidu.swan.apps.api.b.b(1001, "runtime exception, page manager breakdown");
        }
        com.baidu.swan.apps.ag.d.a.print("jump to fun page");
        com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.ag.c.d.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.model.b bVar2 = new com.baidu.swan.apps.model.b();
                bVar2.mBaseUrl = str;
                bVar2.mParams = com.baidu.swan.apps.ag.c.c.a.a(bVar);
                GA.hb("navigateTo").Y(com.baidu.swan.apps.core.d.e.boe, com.baidu.swan.apps.core.d.e.bog).a("pluginFunPage", bVar2).commit();
            }
        });
        return new com.baidu.swan.apps.api.b.b(0);
    }

    private boolean w(File file) {
        String[] list;
        return file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length > 0;
    }
}
