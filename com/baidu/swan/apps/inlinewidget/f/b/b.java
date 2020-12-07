package com.baidu.swan.apps.inlinewidget.f.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.inlinewidget.f.b.a.c;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes25.dex */
public class b {
    private static final com.baidu.swan.apps.inlinewidget.f.b.a.a dch = new com.baidu.swan.apps.inlinewidget.f.b.a.b();
    private static volatile com.baidu.swan.apps.inlinewidget.f.b.a.a dci = dch;

    @NonNull
    public static com.baidu.swan.apps.inlinewidget.f.b.a.a ayB() {
        return dci;
    }

    private static void a(@NonNull com.baidu.swan.apps.inlinewidget.f.b.a.a aVar) {
        dci = aVar;
    }

    public static void ps(String str) {
        a(new c(str));
    }

    public static void ayC() {
        a(dch);
    }

    public static void ayD() {
        ayB().ayF();
    }

    public static void ayE() {
        ayB().ayF();
    }

    /* loaded from: classes25.dex */
    public static class a implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void M(HybridUbcFlow hybridUbcFlow) {
            b.ayB().fF(TextUtils.equals(hybridUbcFlow.aFK().optString("type"), "3") || hybridUbcFlow.pq("na_first_meaningful_paint"));
        }
    }
}
