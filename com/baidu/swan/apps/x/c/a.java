package com.baidu.swan.apps.x.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.x.c.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Map<String, a> bXq = new HashMap();
    private Map<String, String> bXr = new HashMap();
    public final b bXs = new b().ka("SwanLaunch").b(aed());
    public final String id;

    public static a jY(String str) {
        a aVar = bXq.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            bXq.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a aeb() {
        return this.bXs.aeb();
    }

    public b.a jZ(String str) {
        return this.bXs.jZ(str);
    }

    public b.a bc(String str, String str2) {
        return this.bXs.bc(str, str2);
    }

    public synchronized a aec() {
        this.bXs.aeh();
        return this;
    }

    private com.baidu.swan.apps.as.d.b<b> aed() {
        return new com.baidu.swan.apps.as.d.b<b>() { // from class: com.baidu.swan.apps.x.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void E(b bVar) {
                if (a.DEBUG) {
                    aee();
                }
            }

            private synchronized void aee() {
                D("SwanLaunch", "\n\n\n");
                D("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.bXr.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.bXs.aeg()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.bXv) {
                        sb2.append(str).append(" ");
                    }
                    for (String str2 : aVar.msgs) {
                        String aef = a.this.bXs.aef();
                        D(TextUtils.isEmpty(aVar.tag) ? aef : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", aef, sb, sb2, str2));
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
