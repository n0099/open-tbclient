package com.baidu.swan.apps.u.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.u.e.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes3.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Map<String, a> cyF = new HashMap();
    private Map<String, String> cyG = new HashMap();
    public final b cyH = new b().oo("SwanLaunch").q(asa());
    public final String id;

    public static a ol(String str) {
        a aVar = cyF.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            cyF.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a arY() {
        return this.cyH.arY();
    }

    public b.a om(String str) {
        return this.cyH.om(str);
    }

    public b.a bK(String str, String str2) {
        return this.cyH.bK(str, str2);
    }

    public synchronized a arZ() {
        this.cyH.asd();
        return this;
    }

    private com.baidu.swan.apps.ap.e.b<b> asa() {
        return new com.baidu.swan.apps.ap.e.b<b>() { // from class: com.baidu.swan.apps.u.e.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void J(b bVar) {
                if (a.DEBUG) {
                    amK();
                }
            }

            private synchronized void amK() {
                E("SwanLaunch", "\n\n\n");
                E("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.cyG.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.cyH.asc()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.cyN) {
                        sb2.append(str).append(" ");
                    }
                    for (String str2 : aVar.msgs) {
                        String asb = a.this.cyH.asb();
                        E(TextUtils.isEmpty(aVar.tag) ? asb : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", asb, sb, sb2, str2));
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
