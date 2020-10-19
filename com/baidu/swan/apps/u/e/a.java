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
    private static final Map<String, a> cKK = new HashMap();
    private Map<String, String> cKL = new HashMap();
    public final b cKM = new b().pa("SwanLaunch").q(auM());
    public final String id;

    public static a oY(String str) {
        a aVar = cKK.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            cKK.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a auK() {
        return this.cKM.auK();
    }

    public b.a oZ(String str) {
        return this.cKM.oZ(str);
    }

    public b.a bP(String str, String str2) {
        return this.cKM.bP(str, str2);
    }

    public synchronized a auL() {
        this.cKM.auP();
        return this;
    }

    private com.baidu.swan.apps.ap.e.b<b> auM() {
        return new com.baidu.swan.apps.ap.e.b<b>() { // from class: com.baidu.swan.apps.u.e.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(b bVar) {
                if (a.DEBUG) {
                    apw();
                }
            }

            private synchronized void apw() {
                E("SwanLaunch", "\n\n\n");
                E("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.cKL.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.cKM.auO()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.cKS) {
                        sb2.append(str).append(" ");
                    }
                    for (String str2 : aVar.msgs) {
                        String auN = a.this.cKM.auN();
                        E(TextUtils.isEmpty(aVar.tag) ? auN : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", auN, sb, sb2, str2));
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
