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
    private static final Map<String, a> cmL = new HashMap();
    private Map<String, String> cmM = new HashMap();
    public final b cmN = new b().lu("SwanLaunch").i(ais());
    public final String id;

    public static a ls(String str) {
        a aVar = cmL.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            cmL.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a aiq() {
        return this.cmN.aiq();
    }

    public b.a lt(String str) {
        return this.cmN.lt(str);
    }

    public b.a bv(String str, String str2) {
        return this.cmN.bv(str, str2);
    }

    public synchronized a air() {
        this.cmN.aiw();
        return this;
    }

    private com.baidu.swan.apps.aq.e.b<b> ais() {
        return new com.baidu.swan.apps.aq.e.b<b>() { // from class: com.baidu.swan.apps.v.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(b bVar) {
                if (a.DEBUG) {
                    ait();
                }
            }

            private synchronized void ait() {
                D("SwanLaunch", "\n\n\n");
                D("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.cmM.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.cmN.aiv()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.cmQ) {
                        sb2.append(str).append(" ");
                    }
                    for (String str2 : aVar.msgs) {
                        String aiu = a.this.cmN.aiu();
                        D(TextUtils.isEmpty(aVar.tag) ? aiu : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", aiu, sb, sb2, str2));
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
