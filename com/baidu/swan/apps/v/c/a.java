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
    private static final Map<String, a> ayW = new HashMap();
    private Map<String, String> ayX = new HashMap();
    public final b ayY = new b().eU("SwanLaunch").c(Fq());
    public final String id;

    public static a eS(String str) {
        a aVar = ayW.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            ayW.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a Fo() {
        return this.ayY.Fo();
    }

    public b.a eT(String str) {
        return this.ayY.eT(str);
    }

    public b.a ak(String str, String str2) {
        return this.ayY.ak(str, str2);
    }

    public synchronized a Fp() {
        this.ayY.Fu();
        return this;
    }

    public a al(String str, String str2) {
        this.ayX.put(str, str2);
        return this;
    }

    private com.baidu.swan.apps.an.d.a<b> Fq() {
        return new com.baidu.swan.apps.an.d.a<b>() { // from class: com.baidu.swan.apps.v.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void D(b bVar) {
                if (a.DEBUG) {
                    Fr();
                }
            }

            private synchronized void Fr() {
                am("SwanLaunch", "\n\n\n");
                am("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.ayX.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.ayY.Ft()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.azb) {
                        sb2.append(str).append(" ");
                    }
                    for (String str2 : aVar.msgs) {
                        String Fs = a.this.ayY.Fs();
                        am(TextUtils.isEmpty(aVar.tag) ? Fs : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", Fs, sb, sb2, str2));
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
