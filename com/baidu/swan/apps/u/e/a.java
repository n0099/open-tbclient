package com.baidu.swan.apps.u.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.u.e.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Map<String, a> dgE = new HashMap();
    private Map<String, String> dgF = new HashMap();
    public final b dgG = new b().pi("SwanLaunch").q(azD());
    public final String id;

    public static a pg(String str) {
        a aVar = dgE.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            dgE.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a azB() {
        return this.dgG.azB();
    }

    public b.a ph(String str) {
        return this.dgG.ph(str);
    }

    public b.a bU(String str, String str2) {
        return this.dgG.bU(str, str2);
    }

    public synchronized a azC() {
        this.dgG.azG();
        return this;
    }

    private com.baidu.swan.apps.ao.e.b<b> azD() {
        return new com.baidu.swan.apps.ao.e.b<b>() { // from class: com.baidu.swan.apps.u.e.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(b bVar) {
                if (a.DEBUG) {
                    auo();
                }
            }

            private synchronized void auo() {
                B("SwanLaunch", "\n\n\n");
                B("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.dgF.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.dgG.azF()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.dgM) {
                        sb2.append(str).append(" ");
                    }
                    for (String str2 : aVar.msgs) {
                        String azE = a.this.dgG.azE();
                        B(TextUtils.isEmpty(aVar.tag) ? azE : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", azE, sb, sb2, str2));
                    }
                }
            }

            private void B(String str, String str2) {
                if (a.DEBUG) {
                    Log.i(str, str2);
                }
            }
        };
    }
}
