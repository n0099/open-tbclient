package com.baidu.swan.apps.inlinewidget.f.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.inlinewidget.f.b.a.c;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes7.dex */
public class b {
    private static final com.baidu.swan.apps.inlinewidget.f.b.a.a cVl = new com.baidu.swan.apps.inlinewidget.f.b.a.b();
    private static volatile com.baidu.swan.apps.inlinewidget.f.b.a.a cVm = cVl;

    @NonNull
    public static com.baidu.swan.apps.inlinewidget.f.b.a.a avt() {
        return cVm;
    }

    private static void a(@NonNull com.baidu.swan.apps.inlinewidget.f.b.a.a aVar) {
        cVm = aVar;
    }

    public static void oL(String str) {
        a(new c(str));
    }

    public static void avu() {
        a(cVl);
    }

    public static void avv() {
        avt().avx();
    }

    public static void avw() {
        avt().avx();
    }

    /* loaded from: classes7.dex */
    public static class a implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void M(HybridUbcFlow hybridUbcFlow) {
            b.avt().fq(TextUtils.equals(hybridUbcFlow.aCC().optString("type"), "3") || hybridUbcFlow.oJ("na_first_meaningful_paint"));
        }
    }
}
