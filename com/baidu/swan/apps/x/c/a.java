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
    private static final Map<String, a> bzk = new HashMap();
    private Map<String, String> bzl = new HashMap();
    public final b bzm = new b().iN("SwanLaunch").b(Wo());
    public final String id;

    public static a iL(String str) {
        a aVar = bzk.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            bzk.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a Wm() {
        return this.bzm.Wm();
    }

    public b.a iM(String str) {
        return this.bzm.iM(str);
    }

    public b.a aS(String str, String str2) {
        return this.bzm.aS(str, str2);
    }

    public synchronized a Wn() {
        this.bzm.Ws();
        return this;
    }

    private com.baidu.swan.apps.as.d.b<b> Wo() {
        return new com.baidu.swan.apps.as.d.b<b>() { // from class: com.baidu.swan.apps.x.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(b bVar) {
                if (a.DEBUG) {
                    Wp();
                }
            }

            private synchronized void Wp() {
                z("SwanLaunch", "\n\n\n");
                z("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.bzl.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.bzm.Wr()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.bzp) {
                        sb2.append(str).append(HanziToPinyin.Token.SEPARATOR);
                    }
                    for (String str2 : aVar.msgs) {
                        String Wq = a.this.bzm.Wq();
                        z(TextUtils.isEmpty(aVar.tag) ? Wq : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", Wq, sb, sb2, str2));
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
