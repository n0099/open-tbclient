package com.baidu.swan.apps.u.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.u.e.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes8.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Map<String, a> cwE = new HashMap();
    private Map<String, String> cwF = new HashMap();
    public final b cwG = new b().nT("SwanLaunch").q(arq());
    public final String id;

    public static a nR(String str) {
        a aVar = cwE.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            cwE.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a aro() {
        return this.cwG.aro();
    }

    public b.a nS(String str) {
        return this.cwG.nS(str);
    }

    public b.a bK(String str, String str2) {
        return this.cwG.bK(str, str2);
    }

    public synchronized a arp() {
        this.cwG.art();
        return this;
    }

    private com.baidu.swan.apps.ap.e.b<b> arq() {
        return new com.baidu.swan.apps.ap.e.b<b>() { // from class: com.baidu.swan.apps.u.e.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void I(b bVar) {
                if (a.DEBUG) {
                    ama();
                }
            }

            private synchronized void ama() {
                E("SwanLaunch", "\n\n\n");
                E("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.cwF.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.cwG.ars()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.cwM) {
                        sb2.append(str).append(" ");
                    }
                    for (String str2 : aVar.msgs) {
                        String arr = a.this.cwG.arr();
                        E(TextUtils.isEmpty(aVar.tag) ? arr : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", arr, sb, sb2, str2));
                    }
                }
            }

            private void E(String str, String str2) {
                if (a.DEBUG) {
                    Log.i(str, str2);
                }
            }
        };
    }
}
