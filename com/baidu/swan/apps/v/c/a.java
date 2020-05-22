package com.baidu.swan.apps.v.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.v.c.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Map<String, a> chW = new HashMap();
    private Map<String, String> chX = new HashMap();
    public final b chY = new b().lm("SwanLaunch").i(ahm());
    public final String id;

    public static a lk(String str) {
        a aVar = chW.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            chW.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a ahk() {
        return this.chY.ahk();
    }

    public b.a ll(String str) {
        return this.chY.ll(str);
    }

    public b.a bt(String str, String str2) {
        return this.chY.bt(str, str2);
    }

    public synchronized a ahl() {
        this.chY.ahq();
        return this;
    }

    private com.baidu.swan.apps.aq.e.b<b> ahm() {
        return new com.baidu.swan.apps.aq.e.b<b>() { // from class: com.baidu.swan.apps.v.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(b bVar) {
                if (a.DEBUG) {
                    ahn();
                }
            }

            private synchronized void ahn() {
                D("SwanLaunch", "\n\n\n");
                D("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.chX.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.chY.ahp()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.cib) {
                        sb2.append(str).append(" ");
                    }
                    for (String str2 : aVar.msgs) {
                        String aho = a.this.chY.aho();
                        D(TextUtils.isEmpty(aVar.tag) ? aho : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", aho, sb, sb2, str2));
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
