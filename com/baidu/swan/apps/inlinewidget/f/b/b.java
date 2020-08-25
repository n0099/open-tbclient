package com.baidu.swan.apps.inlinewidget.f.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.inlinewidget.f.b.a.c;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes8.dex */
public class b {
    private static final com.baidu.swan.apps.inlinewidget.f.b.a.a cuv = new com.baidu.swan.apps.inlinewidget.f.b.a.b();
    private static volatile com.baidu.swan.apps.inlinewidget.f.b.a.a cuw = cuv;

    @NonNull
    public static com.baidu.swan.apps.inlinewidget.f.b.a.a aok() {
        return cuw;
    }

    private static void a(@NonNull com.baidu.swan.apps.inlinewidget.f.b.a.a aVar) {
        cuw = aVar;
    }

    public static void nc(String str) {
        a(new c(str));
    }

    public static void aol() {
        a(cuv);
    }

    public static void aom() {
        aok().aoo();
    }

    public static void aon() {
        aok().aoo();
    }

    /* loaded from: classes8.dex */
    public static class a implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void I(HybridUbcFlow hybridUbcFlow) {
            b.aok().ew(TextUtils.equals(hybridUbcFlow.avw().optString("type"), "3") || hybridUbcFlow.na("na_first_meaningful_paint"));
        }
    }
}
