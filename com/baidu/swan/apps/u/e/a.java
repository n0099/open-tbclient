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
    private static final Map<String, a> dji = new HashMap();
    private Map<String, String> djj = new HashMap();
    public final b djk = new b().qb("SwanLaunch").q(aCZ());
    public final String id;

    public static a pZ(String str) {
        a aVar = dji.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            dji.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a aCX() {
        return this.djk.aCX();
    }

    public b.a qa(String str) {
        return this.djk.qa(str);
    }

    public b.a cb(String str, String str2) {
        return this.djk.cb(str, str2);
    }

    public synchronized a aCY() {
        this.djk.aDc();
        return this;
    }

    private com.baidu.swan.apps.ao.e.b<b> aCZ() {
        return new com.baidu.swan.apps.ao.e.b<b>() { // from class: com.baidu.swan.apps.u.e.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(b bVar) {
                if (a.DEBUG) {
                    axK();
                }
            }

            private synchronized void axK() {
                D("SwanLaunch", "\n\n\n");
                D("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.djj.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.djk.aDb()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.djq) {
                        sb2.append(str).append(" ");
                    }
                    for (String str2 : aVar.msgs) {
                        String aDa = a.this.djk.aDa();
                        D(TextUtils.isEmpty(aVar.tag) ? aDa : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", aDa, sb, sb2, str2));
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
