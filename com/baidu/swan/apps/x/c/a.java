package com.baidu.swan.apps.x.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.swan.apps.x.c.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Map<String, a> byZ = new HashMap();
    private Map<String, String> bza = new HashMap();
    public final b bzb = new b().iO("SwanLaunch").b(Wl());
    public final String id;

    public static a iM(String str) {
        a aVar = byZ.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            byZ.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a Wj() {
        return this.bzb.Wj();
    }

    public b.a iN(String str) {
        return this.bzb.iN(str);
    }

    public b.a aT(String str, String str2) {
        return this.bzb.aT(str, str2);
    }

    public synchronized a Wk() {
        this.bzb.Wp();
        return this;
    }

    private com.baidu.swan.apps.as.d.b<b> Wl() {
        return new com.baidu.swan.apps.as.d.b<b>() { // from class: com.baidu.swan.apps.x.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(b bVar) {
                if (a.DEBUG) {
                    Wm();
                }
            }

            private synchronized void Wm() {
                z("SwanLaunch", "\n\n\n");
                z("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.bza.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.bzb.Wo()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.bze) {
                        sb2.append(str).append(HanziToPinyin.Token.SEPARATOR);
                    }
                    for (String str2 : aVar.msgs) {
                        String Wn = a.this.bzb.Wn();
                        z(TextUtils.isEmpty(aVar.tag) ? Wn : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", Wn, sb, sb2, str2));
                    }
                }
            }

            private void z(String str, String str2) {
                if (a.DEBUG) {
                    Log.i(str, str2);
                }
            }
        };
    }
}
