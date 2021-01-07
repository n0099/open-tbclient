package com.baidu.swan.apps.ac.c.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.r.d;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d extends b {
    @Override // com.baidu.swan.apps.ac.c.d.b
    com.baidu.swan.apps.api.c.b bA(JSONObject jSONObject) {
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
    boolean aIq() {
        return true;
    }

    @Override // com.baidu.swan.apps.ac.c.d.b
    com.baidu.swan.apps.api.c.b a(com.baidu.swan.apps.ac.c.b.b bVar, com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a> bVar2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.swan.apps.ac.c.d.b
    public String aIr() {
        return null;
    }

    @Override // com.baidu.swan.apps.ac.c.d.b
    com.baidu.swan.apps.ac.c.b.a b(com.baidu.swan.apps.ac.c.b.b bVar) {
        File file;
        if (bVar == null) {
            return null;
        }
        String str = bVar.duX;
        String str2 = bVar.duZ;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        com.baidu.swan.apps.ac.c.b.a aVar = new com.baidu.swan.apps.ac.c.b.a();
        aVar.appKey = str;
        aVar.duS = str2;
        if (com.baidu.swan.apps.console.debugger.a.e.apH()) {
            file = d.e.apu();
        } else if (com.baidu.swan.apps.ad.a.a.aIL()) {
            file = d.a.apu();
        } else if (TextUtils.equals(bVar.dva, "develop")) {
            String mv = com.baidu.swan.apps.f.a.mv(str);
            File aAi = com.baidu.swan.apps.r.d.aAi();
            String[] list = aAi.list();
            if (list == null || aAi.length() == 0) {
                return aVar;
            }
            String str3 = mv + "_dev";
            int i = -1;
            for (String str4 : list) {
                if (!TextUtils.isEmpty(str4) && str4.startsWith(str3)) {
                    try {
                        int parseInt = Integer.parseInt(str4.substring(str3.length()));
                        if (parseInt <= i) {
                            parseInt = i;
                        }
                        i = parseInt;
                    } catch (NumberFormatException e) {
                        com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
                    }
                }
            }
            if (i > -1) {
                aVar.appKey = str3 + i;
                aVar.duV = true;
                file = new File(aAi, aVar.appKey + File.separator + i);
                aVar.duT = file.getAbsolutePath();
                aVar.duU = i;
            } else {
                aVar.duV = false;
                aVar.duT = null;
                file = null;
            }
        } else {
            File file2 = new File(com.baidu.swan.apps.r.d.aAi(), str);
            if (!file2.exists()) {
                return aVar;
            }
            String[] list2 = file2.list();
            if (list2 == null || list2.length == 0) {
                return aVar;
            }
            int i2 = -1;
            String str5 = null;
            for (String str6 : list2) {
                if (!TextUtils.isEmpty(str6)) {
                    int i3 = -1;
                    try {
                        i3 = Integer.parseInt(str6);
                    } catch (NumberFormatException e2) {
                        com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e2));
                    }
                    if (i3 > i2) {
                        str5 = str6;
                        i2 = i3;
                    }
                }
            }
            if (i2 == -1) {
                file = null;
            } else {
                aVar.duU = i2;
                aVar.duV = true;
                File file3 = new File(file2, str5);
                aVar.duT = file3.getAbsolutePath();
                file = file3;
            }
        }
        if (file == null) {
            return aVar;
        }
        File file4 = new File(file, str2);
        if (K(file4)) {
            aVar.duW = true;
            aVar.duT = file4.getAbsolutePath();
            return aVar;
        }
        return aVar;
    }

    @Override // com.baidu.swan.apps.ac.c.d.b
    com.baidu.swan.apps.api.c.b a(final String str, final com.baidu.swan.apps.ac.c.b.b bVar) {
        if (bVar == null) {
            return new com.baidu.swan.apps.api.c.b(201, "pay args is null");
        }
        SwanAppActivity aMf = com.baidu.swan.apps.runtime.d.aMh().aMf();
        if (aMf == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "runtime exception, try reopen this app");
        }
        final f ajt = aMf.ajt();
        if (ajt == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "runtime exception, page manager breakdown");
        }
        com.baidu.swan.apps.ac.d.a.print("jump to fun page");
        com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.ac.c.d.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.model.b bVar2 = new com.baidu.swan.apps.model.b();
                bVar2.mBaseUrl = str;
                bVar2.mParams = com.baidu.swan.apps.ac.c.c.a.a(bVar);
                ajt.nv("navigateTo").ai(f.cUY, f.cVa).a("pluginFunPage", bVar2).commit();
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }

    private boolean K(File file) {
        String[] list;
        return file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length > 0;
    }
}
