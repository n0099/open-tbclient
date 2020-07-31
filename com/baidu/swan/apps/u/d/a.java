package com.baidu.swan.apps.u.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.u.d.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes7.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Map<String, a> coS = new HashMap();
    private Map<String, String> coT = new HashMap();
    public final b coU = new b().lV("SwanLaunch").j(ajJ());
    public final String id;

    public static a lT(String str) {
        a aVar = coS.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            coS.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a ajH() {
        return this.coU.ajH();
    }

    public b.a lU(String str) {
        return this.coU.lU(str);
    }

    public b.a bx(String str, String str2) {
        return this.coU.bx(str, str2);
    }

    public synchronized a ajI() {
        this.coU.ajM();
        return this;
    }

    private com.baidu.swan.apps.aq.e.b<b> ajJ() {
        return new com.baidu.swan.apps.aq.e.b<b>() { // from class: com.baidu.swan.apps.u.d.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(b bVar) {
                if (a.DEBUG) {
                    aeU();
                }
            }

            private synchronized void aeU() {
                C("SwanLaunch", "\n\n\n");
                C("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.coT.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.coU.ajL()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.cpa) {
                        sb2.append(str).append(" ");
                    }
                    for (String str2 : aVar.msgs) {
                        String ajK = a.this.coU.ajK();
                        C(TextUtils.isEmpty(aVar.tag) ? ajK : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", ajK, sb, sb2, str2));
                    }
                }
            }

            private void C(String str, String str2) {
                if (a.DEBUG) {
                    Log.i(str, str2);
                }
            }
        };
    }
}
