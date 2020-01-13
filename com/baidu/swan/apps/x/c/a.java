package com.baidu.swan.apps.x.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.swan.apps.x.c.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes10.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Map<String, a> buO = new HashMap();
    private Map<String, String> buP = new HashMap();
    public final b buQ = new b().iz("SwanLaunch").b(TV());
    public final String id;

    public static a ix(String str) {
        a aVar = buO.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            buO.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a TT() {
        return this.buQ.TT();
    }

    public b.a iy(String str) {
        return this.buQ.iy(str);
    }

    public b.a aJ(String str, String str2) {
        return this.buQ.aJ(str, str2);
    }

    public synchronized a TU() {
        this.buQ.TZ();
        return this;
    }

    private com.baidu.swan.apps.as.d.b<b> TV() {
        return new com.baidu.swan.apps.as.d.b<b>() { // from class: com.baidu.swan.apps.x.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void B(b bVar) {
                if (a.DEBUG) {
                    TW();
                }
            }

            private synchronized void TW() {
                aK("SwanLaunch", "\n\n\n");
                aK("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.buP.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.buQ.TY()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.buT) {
                        sb2.append(str).append(HanziToPinyin.Token.SEPARATOR);
                    }
                    for (String str2 : aVar.msgs) {
                        String TX = a.this.buQ.TX();
                        aK(TextUtils.isEmpty(aVar.tag) ? TX : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", TX, sb, sb2, str2));
                    }
                }
            }

            private void aK(String str, String str2) {
                if (a.DEBUG) {
                    Log.i(str, str2);
                }
            }
        };
    }
}
