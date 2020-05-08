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
    private static final Map<String, a> bXw = new HashMap();
    private Map<String, String> bXx = new HashMap();
    public final b bXy = new b().ka("SwanLaunch").b(aec());
    public final String id;

    public static a jY(String str) {
        a aVar = bXw.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            bXw.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a aea() {
        return this.bXy.aea();
    }

    public b.a jZ(String str) {
        return this.bXy.jZ(str);
    }

    public b.a bc(String str, String str2) {
        return this.bXy.bc(str, str2);
    }

    public synchronized a aeb() {
        this.bXy.aeg();
        return this;
    }

    private com.baidu.swan.apps.as.d.b<b> aec() {
        return new com.baidu.swan.apps.as.d.b<b>() { // from class: com.baidu.swan.apps.x.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void F(b bVar) {
                if (a.DEBUG) {
                    aed();
                }
            }

            private synchronized void aed() {
                D("SwanLaunch", "\n\n\n");
                D("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.bXx.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.bXy.aef()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.bXB) {
                        sb2.append(str).append(" ");
                    }
                    for (String str2 : aVar.msgs) {
                        String aee = a.this.bXy.aee();
                        D(TextUtils.isEmpty(aVar.tag) ? aee : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", aee, sb, sb2, str2));
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
