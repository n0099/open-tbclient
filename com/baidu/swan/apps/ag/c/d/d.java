package com.baidu.swan.apps.ag.c.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.t.e;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes9.dex */
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
    boolean Xv() {
        return true;
    }

    @Override // com.baidu.swan.apps.ag.c.d.b
    com.baidu.swan.apps.api.b.b a(com.baidu.swan.apps.ag.c.b.b bVar, com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a> bVar2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.swan.apps.ag.c.d.b
    public String Xw() {
        return null;
    }

    @Override // com.baidu.swan.apps.ag.c.d.b
    com.baidu.swan.apps.ag.c.b.a b(com.baidu.swan.apps.ag.c.b.b bVar) {
        File file;
        int i;
        if (bVar == null) {
            return null;
        }
        String str = bVar.bDz;
        String str2 = bVar.bDB;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        com.baidu.swan.apps.ag.c.b.a aVar = new com.baidu.swan.apps.ag.c.b.a();
        aVar.appKey = str;
        aVar.bDu = str2;
        if (com.baidu.swan.apps.console.debugger.a.e.Jc()) {
            file = e.C0290e.IP();
        } else if (com.baidu.swan.apps.ah.a.a.XQ()) {
            file = e.a.IP();
        } else if (TextUtils.equals(bVar.bDC, "develop")) {
            String fQ = com.baidu.swan.apps.e.a.fQ(str);
            File Rb = com.baidu.swan.apps.t.e.Rb();
            String[] list = Rb.list();
            if (list == null || Rb.length() == 0) {
                return aVar;
            }
            String str3 = fQ + "_dev";
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
                aVar.bDx = true;
                file = new File(Rb, aVar.appKey + File.separator + i2);
                aVar.bDv = file.getAbsolutePath();
                aVar.bDw = i2;
            } else {
                aVar.bDx = false;
                aVar.bDv = null;
                file = null;
            }
        } else {
            File file2 = new File(com.baidu.swan.apps.t.e.Rb(), str);
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
                aVar.bDw = i3;
                aVar.bDx = true;
                File file3 = new File(file2, str5);
                aVar.bDv = file3.getAbsolutePath();
                file = file3;
            }
        }
        if (file == null) {
            return aVar;
        }
        File file4 = new File(file, str2);
        if (v(file4)) {
            aVar.bDy = true;
            aVar.bDv = file4.getAbsolutePath();
            return aVar;
        }
        return aVar;
    }

    @Override // com.baidu.swan.apps.ag.c.d.b
    com.baidu.swan.apps.api.b.b a(final String str, final com.baidu.swan.apps.ag.c.b.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.api.b.b(201, "pay args is null");
        }
        SwanAppActivity ZO = com.baidu.swan.apps.runtime.d.ZP().ZO();
        if (ZO == null) {
            return new com.baidu.swan.apps.api.b.b(1001, "runtime exception, try reopen this app");
        }
        final com.baidu.swan.apps.core.d.e DP = ZO.DP();
        if (DP == null) {
            return new com.baidu.swan.apps.api.b.b(1001, "runtime exception, page manager breakdown");
        }
        com.baidu.swan.apps.ag.d.a.print("jump to fun page");
        com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.ag.c.d.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.model.b bVar2 = new com.baidu.swan.apps.model.b();
                bVar2.mBaseUrl = str;
                bVar2.mParams = com.baidu.swan.apps.ag.c.c.a.a(bVar);
                DP.gJ("navigateTo").U(com.baidu.swan.apps.core.d.e.bjf, com.baidu.swan.apps.core.d.e.bjh).a("pluginFunPage", bVar2).commit();
            }
        });
        return new com.baidu.swan.apps.api.b.b(0);
    }

    private boolean v(File file) {
        String[] list;
        return file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length > 0;
    }
}
