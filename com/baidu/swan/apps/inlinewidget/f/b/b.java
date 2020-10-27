package com.baidu.swan.apps.inlinewidget.f.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.inlinewidget.f.b.a.c;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes10.dex */
public class b {
    private static final com.baidu.swan.apps.inlinewidget.f.b.a.a cRc = new com.baidu.swan.apps.inlinewidget.f.b.a.b();
    private static volatile com.baidu.swan.apps.inlinewidget.f.b.a.a cRd = cRc;

    @NonNull
    public static com.baidu.swan.apps.inlinewidget.f.b.a.a atB() {
        return cRd;
    }

    private static void a(@NonNull com.baidu.swan.apps.inlinewidget.f.b.a.a aVar) {
        cRd = aVar;
    }

    public static void oD(String str) {
        a(new c(str));
    }

    public static void atC() {
        a(cRc);
    }

    public static void atD() {
        atB().atF();
    }

    public static void atE() {
        atB().atF();
    }

    /* loaded from: classes10.dex */
    public static class a implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void M(HybridUbcFlow hybridUbcFlow) {
            b.atB().fe(TextUtils.equals(hybridUbcFlow.aAK().optString("type"), "3") || hybridUbcFlow.oB("na_first_meaningful_paint"));
        }
    }
}
