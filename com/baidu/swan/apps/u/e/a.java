package com.baidu.swan.apps.u.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.u.e.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes10.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Map<String, a> cTg = new HashMap();
    private Map<String, String> cTh = new HashMap();
    public final b cTi = new b().pt("SwanLaunch").q(awG());
    public final String id;

    public static a pr(String str) {
        a aVar = cTg.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            cTg.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a awE() {
        return this.cTi.awE();
    }

    public b.a ps(String str) {
        return this.cTi.ps(str);
    }

    public b.a bW(String str, String str2) {
        return this.cTi.bW(str, str2);
    }

    public synchronized a awF() {
        this.cTi.awJ();
        return this;
    }

    private com.baidu.swan.apps.ap.e.b<b> awG() {
        return new com.baidu.swan.apps.ap.e.b<b>() { // from class: com.baidu.swan.apps.u.e.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(b bVar) {
                if (a.DEBUG) {
                    arq();
                }
            }

            private synchronized void arq() {
                E("SwanLaunch", "\n\n\n");
                E("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.cTh.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.cTi.awI()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.cTo) {
                        sb2.append(str).append(" ");
                    }
                    for (String str2 : aVar.msgs) {
                        String awH = a.this.cTi.awH();
                        E(TextUtils.isEmpty(aVar.tag) ? awH : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", awH, sb, sb2, str2));
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
