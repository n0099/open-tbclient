package com.baidu.swan.apps.u.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.u.e.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes7.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Map<String, a> cXp = new HashMap();
    private Map<String, String> cXq = new HashMap();
    public final b cXr = new b().pB("SwanLaunch").q(ayy());
    public final String id;

    public static a pz(String str) {
        a aVar = cXp.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            cXp.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a ayw() {
        return this.cXr.ayw();
    }

    public b.a pA(String str) {
        return this.cXr.pA(str);
    }

    public b.a bV(String str, String str2) {
        return this.cXr.bV(str, str2);
    }

    public synchronized a ayx() {
        this.cXr.ayB();
        return this;
    }

    private com.baidu.swan.apps.ap.e.b<b> ayy() {
        return new com.baidu.swan.apps.ap.e.b<b>() { // from class: com.baidu.swan.apps.u.e.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(b bVar) {
                if (a.DEBUG) {
                    atj();
                }
            }

            private synchronized void atj() {
                D("SwanLaunch", "\n\n\n");
                D("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.cXq.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.cXr.ayA()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.cXx) {
                        sb2.append(str).append(" ");
                    }
                    for (String str2 : aVar.msgs) {
                        String ayz = a.this.cXr.ayz();
                        D(TextUtils.isEmpty(aVar.tag) ? ayz : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", ayz, sb, sb2, str2));
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
