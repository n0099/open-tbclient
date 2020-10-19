package com.baidu.swan.apps.inlinewidget.f.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.inlinewidget.f.b.a.c;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes10.dex */
public class b {
    private static final com.baidu.swan.apps.inlinewidget.f.b.a.a cIG = new com.baidu.swan.apps.inlinewidget.f.b.a.b();
    private static volatile com.baidu.swan.apps.inlinewidget.f.b.a.a cIH = cIG;

    @NonNull
    public static com.baidu.swan.apps.inlinewidget.f.b.a.a arG() {
        return cIH;
    }

    private static void a(@NonNull com.baidu.swan.apps.inlinewidget.f.b.a.a aVar) {
        cIH = aVar;
    }

    public static void oj(String str) {
        a(new c(str));
    }

    public static void arH() {
        a(cIG);
    }

    public static void arI() {
        arG().arK();
    }

    public static void arJ() {
        arG().arK();
    }

    /* loaded from: classes10.dex */
    public static class a implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void M(HybridUbcFlow hybridUbcFlow) {
            b.arG().eR(TextUtils.equals(hybridUbcFlow.ayQ().optString("type"), "3") || hybridUbcFlow.oh("na_first_meaningful_paint"));
        }
    }
}
