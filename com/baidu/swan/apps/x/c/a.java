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
    private static final Map<String, a> byX = new HashMap();
    private Map<String, String> byY = new HashMap();
    public final b byZ = new b().iO("SwanLaunch").b(Wj());
    public final String id;

    public static a iM(String str) {
        a aVar = byX.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            byX.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a Wh() {
        return this.byZ.Wh();
    }

    public b.a iN(String str) {
        return this.byZ.iN(str);
    }

    public b.a aT(String str, String str2) {
        return this.byZ.aT(str, str2);
    }

    public synchronized a Wi() {
        this.byZ.Wn();
        return this;
    }

    private com.baidu.swan.apps.as.d.b<b> Wj() {
        return new com.baidu.swan.apps.as.d.b<b>() { // from class: com.baidu.swan.apps.x.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(b bVar) {
                if (a.DEBUG) {
                    Wk();
                }
            }

            private synchronized void Wk() {
                z("SwanLaunch", "\n\n\n");
                z("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.byY.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.byZ.Wm()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.bzc) {
                        sb2.append(str).append(HanziToPinyin.Token.SEPARATOR);
                    }
                    for (String str2 : aVar.msgs) {
                        String Wl = a.this.byZ.Wl();
                        z(TextUtils.isEmpty(aVar.tag) ? Wl : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", Wl, sb, sb2, str2));
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
