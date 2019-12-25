package com.baidu.swan.apps.x.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.swan.apps.x.c.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Map<String, a> btZ = new HashMap();
    private Map<String, String> bua = new HashMap();
    public final b bub = new b().iw("SwanLaunch").b(Ty());
    public final String id;

    public static a iu(String str) {
        a aVar = btZ.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            btZ.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a Tw() {
        return this.bub.Tw();
    }

    public b.a iv(String str) {
        return this.bub.iv(str);
    }

    public b.a aI(String str, String str2) {
        return this.bub.aI(str, str2);
    }

    public synchronized a Tx() {
        this.bub.TC();
        return this;
    }

    private com.baidu.swan.apps.as.d.b<b> Ty() {
        return new com.baidu.swan.apps.as.d.b<b>() { // from class: com.baidu.swan.apps.x.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void B(b bVar) {
                if (a.DEBUG) {
                    Tz();
                }
            }

            private synchronized void Tz() {
                aJ("SwanLaunch", "\n\n\n");
                aJ("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.bua.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.bub.TB()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.bue) {
                        sb2.append(str).append(HanziToPinyin.Token.SEPARATOR);
                    }
                    for (String str2 : aVar.msgs) {
                        String TA = a.this.bub.TA();
                        aJ(TextUtils.isEmpty(aVar.tag) ? TA : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", TA, sb, sb2, str2));
                    }
                }
            }

            private void aJ(String str, String str2) {
                if (a.DEBUG) {
                    Log.i(str, str2);
                }
            }
        };
    }
}
