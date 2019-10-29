package com.baidu.swan.apps.v.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.swan.apps.v.c.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Map<String, a> aTp = new HashMap();
    private Map<String, String> aTq = new HashMap();
    public final b aTr = new b().fH("SwanLaunch").c(KY());
    public final String id;

    public static a fF(String str) {
        a aVar = aTp.get(str);
        if (aVar == null) {
            a aVar2 = new a(str);
            aTp.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private a(String str) {
        this.id = str;
    }

    public b.a KW() {
        return this.aTr.KW();
    }

    public b.a fG(String str) {
        return this.aTr.fG(str);
    }

    public b.a as(String str, String str2) {
        return this.aTr.as(str, str2);
    }

    public synchronized a KX() {
        this.aTr.Lc();
        return this;
    }

    public a at(String str, String str2) {
        this.aTq.put(str, str2);
        return this;
    }

    private com.baidu.swan.apps.an.d.a<b> KY() {
        return new com.baidu.swan.apps.an.d.a<b>() { // from class: com.baidu.swan.apps.v.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void B(b bVar) {
                if (a.DEBUG) {
                    KZ();
                }
            }

            private synchronized void KZ() {
                au("SwanLaunch", "\n\n\n");
                au("SwanLaunch", ">>>>>> SWAN Launch Log For " + a.this.id);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : a.this.aTq.entrySet()) {
                    sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                }
                for (b.a aVar : a.this.aTr.Lb()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : aVar.aTu) {
                        sb2.append(str).append(HanziToPinyin.Token.SEPARATOR);
                    }
                    for (String str2 : aVar.msgs) {
                        String La = a.this.aTr.La();
                        au(TextUtils.isEmpty(aVar.tag) ? La : aVar.tag, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", La, sb, sb2, str2));
                    }
                }
            }

            private void au(String str, String str2) {
                if (a.DEBUG) {
                    Log.i(str, str2);
                }
            }
        };
    }
}
