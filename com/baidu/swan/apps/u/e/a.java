package com.baidu.swan.apps.u.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.u.e.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes25.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Map<String, a> den = new HashMap();
    private Map<String, String> deo = new HashMap();
    public final b dep = new b().qi("SwanLaunch").q(aBH());
    public final String id;

    public static a qg(String str) {
        a aVar = den.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            den.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a aBF() {
        return this.dep.aBF();
    }

    public b.a qh(String str) {
        return this.dep.qh(str);
    }

    public b.a cc(String str, String str2) {
        return this.dep.cc(str, str2);
    }

    public synchronized a aBG() {
        this.dep.aBK();
        return this;
    }

    private com.baidu.swan.apps.ap.e.b<b> aBH() {
        return new com.baidu.swan.apps.ap.e.b<b>() { // from class: com.baidu.swan.apps.u.e.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(b bVar) {
                if (a.DEBUG) {
                    awr();
                }
            }

            private synchronized void awr() {
                D("SwanLaunch", "\n\n\n");
                D("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.deo.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.dep.aBJ()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.dew) {
                        sb2.append(str).append(" ");
                    }
                    for (String str2 : aVar.msgs) {
                        String aBI = a.this.dep.aBI();
                        D(TextUtils.isEmpty(aVar.tag) ? aBI : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", aBI, sb, sb2, str2));
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
