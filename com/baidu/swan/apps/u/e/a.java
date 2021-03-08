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
    private static final Map<String, a> dig = new HashMap();
    private Map<String, String> dih = new HashMap();
    public final b dii = new b().pp("SwanLaunch").q(azG());
    public final String id;

    public static a pn(String str) {
        a aVar = dig.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            dig.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a azE() {
        return this.dii.azE();
    }

    public b.a po(String str) {
        return this.dii.po(str);
    }

    public b.a bU(String str, String str2) {
        return this.dii.bU(str, str2);
    }

    public synchronized a azF() {
        this.dii.azJ();
        return this;
    }

    private com.baidu.swan.apps.ao.e.b<b> azG() {
        return new com.baidu.swan.apps.ao.e.b<b>() { // from class: com.baidu.swan.apps.u.e.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void N(b bVar) {
                if (a.DEBUG) {
                    aur();
                }
            }

            private synchronized void aur() {
                B("SwanLaunch", "\n\n\n");
                B("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.dih.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.dii.azI()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.dio) {
                        sb2.append(str).append(" ");
                    }
                    for (String str2 : aVar.msgs) {
                        String azH = a.this.dii.azH();
                        B(TextUtils.isEmpty(aVar.tag) ? azH : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", azH, sb, sb2, str2));
                    }
                }
            }

            private void B(String str, String str2) {
                if (a.DEBUG) {
                    Log.i(str, str2);
                }
            }
        };
    }
}
