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
    private static final Map<String, a> cYZ = new HashMap();
    private Map<String, String> cZa = new HashMap();
    public final b cZb = new b().pH("SwanLaunch").q(azg());
    public final String id;

    public static a pF(String str) {
        a aVar = cYZ.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            cYZ.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a aze() {
        return this.cZb.aze();
    }

    public b.a pG(String str) {
        return this.cZb.pG(str);
    }

    public b.a bW(String str, String str2) {
        return this.cZb.bW(str, str2);
    }

    public synchronized a azf() {
        this.cZb.azj();
        return this;
    }

    private com.baidu.swan.apps.ap.e.b<b> azg() {
        return new com.baidu.swan.apps.ap.e.b<b>() { // from class: com.baidu.swan.apps.u.e.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(b bVar) {
                if (a.DEBUG) {
                    atR();
                }
            }

            private synchronized void atR() {
                E("SwanLaunch", "\n\n\n");
                E("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.cZa.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.cZb.azi()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.cZh) {
                        sb2.append(str).append(" ");
                    }
                    for (String str2 : aVar.msgs) {
                        String azh = a.this.cZb.azh();
                        E(TextUtils.isEmpty(aVar.tag) ? azh : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", azh, sb, sb2, str2));
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
