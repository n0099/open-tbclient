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
    private static final Map<String, a> azD = new HashMap();
    private Map<String, String> azE = new HashMap();
    public final b azF = new b().eY("SwanLaunch").c(Ga());
    public final String id;

    public static a eW(String str) {
        a aVar = azD.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            azD.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a FY() {
        return this.azF.FY();
    }

    public b.a eX(String str) {
        return this.azF.eX(str);
    }

    public b.a ak(String str, String str2) {
        return this.azF.ak(str, str2);
    }

    public synchronized a FZ() {
        this.azF.Ge();
        return this;
    }

    public a al(String str, String str2) {
        this.azE.put(str, str2);
        return this;
    }

    private com.baidu.swan.apps.an.d.a<b> Ga() {
        return new com.baidu.swan.apps.an.d.a<b>() { // from class: com.baidu.swan.apps.v.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void D(b bVar) {
                if (a.DEBUG) {
                    Gb();
                }
            }

            private synchronized void Gb() {
                am("SwanLaunch", "\n\n\n");
                am("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.azE.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.azF.Gd()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.azI) {
                        sb2.append(str).append(" ");
                    }
                    for (String str2 : aVar.msgs) {
                        String Gc = a.this.azF.Gc();
                        am(TextUtils.isEmpty(aVar.tag) ? Gc : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", Gc, sb, sb2, str2));
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
