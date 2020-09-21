package com.baidu.swan.apps.inlinewidget.f.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.inlinewidget.f.b.a.c;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes3.dex */
public class b {
    private static final com.baidu.swan.apps.inlinewidget.f.b.a.a cwA = new com.baidu.swan.apps.inlinewidget.f.b.a.b();
    private static volatile com.baidu.swan.apps.inlinewidget.f.b.a.a cwB = cwA;

    @NonNull
    public static com.baidu.swan.apps.inlinewidget.f.b.a.a aoU() {
        return cwB;
    }

    private static void a(@NonNull com.baidu.swan.apps.inlinewidget.f.b.a.a aVar) {
        cwB = aVar;
    }

    public static void nw(String str) {
        a(new c(str));
    }

    public static void aoV() {
        a(cwA);
    }

    public static void aoW() {
        aoU().aoY();
    }

    public static void aoX() {
        aoU().aoY();
    }

    /* loaded from: classes3.dex */
    public static class a implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void J(HybridUbcFlow hybridUbcFlow) {
            b.aoU().ev(TextUtils.equals(hybridUbcFlow.awf().optString("type"), "3") || hybridUbcFlow.nu("na_first_meaningful_paint"));
        }
    }
}
