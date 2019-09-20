package com.baidu.swan.apps.v.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.v.c.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Map<String, a> aAb = new HashMap();
    private Map<String, String> aAc = new HashMap();
    public final b aAd = new b().fa("SwanLaunch").c(Ge());
    public final String id;

    public static a eY(String str) {
        a aVar = aAb.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            aAb.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a Gc() {
        return this.aAd.Gc();
    }

    public b.a eZ(String str) {
        return this.aAd.eZ(str);
    }

    public b.a ak(String str, String str2) {
        return this.aAd.ak(str, str2);
    }

    public synchronized a Gd() {
        this.aAd.Gi();
        return this;
    }

    public a al(String str, String str2) {
        this.aAc.put(str, str2);
        return this;
    }

    private com.baidu.swan.apps.an.d.a<b> Ge() {
        return new com.baidu.swan.apps.an.d.a<b>() { // from class: com.baidu.swan.apps.v.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void D(b bVar) {
                if (a.DEBUG) {
                    Gf();
                }
            }

            private synchronized void Gf() {
                am("SwanLaunch", "\n\n\n");
                am("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.aAc.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.aAd.Gh()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.aAg) {
                        sb2.append(str).append(" ");
                    }
                    for (String str2 : aVar.msgs) {
                        String Gg = a.this.aAd.Gg();
                        am(TextUtils.isEmpty(aVar.tag) ? Gg : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", Gg, sb, sb2, str2));
                    }
                }
            }

            private void am(String str, String str2) {
                if (a.DEBUG) {
                    Log.i(str, str2);
                }
            }
        };
    }
}
