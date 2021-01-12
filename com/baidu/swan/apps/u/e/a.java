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
    private static final Map<String, a> det = new HashMap();
    private Map<String, String> deu = new HashMap();
    public final b dev = new b().oQ("SwanLaunch").q(azf());
    public final String id;

    public static a oO(String str) {
        a aVar = det.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            det.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a azd() {
        return this.dev.azd();
    }

    public b.a oP(String str) {
        return this.dev.oP(str);
    }

    public b.a ca(String str, String str2) {
        return this.dev.ca(str, str2);
    }

    public synchronized a aze() {
        this.dev.azi();
        return this;
    }

    private com.baidu.swan.apps.ao.e.b<b> azf() {
        return new com.baidu.swan.apps.ao.e.b<b>() { // from class: com.baidu.swan.apps.u.e.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(b bVar) {
                if (a.DEBUG) {
                    atQ();
                }
            }

            private synchronized void atQ() {
                D("SwanLaunch", "\n\n\n");
                D("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.deu.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.dev.azh()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.deB) {
                        sb2.append(str).append(" ");
                    }
                    for (String str2 : aVar.msgs) {
                        String azg = a.this.dev.azg();
                        D(TextUtils.isEmpty(aVar.tag) ? azg : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", azg, sb, sb2, str2));
                    }
                }
            }

            private void D(String str, String str2) {
                if (a.DEBUG) {
                    Log.i(str, str2);
                }
            }
        };
    }
}
