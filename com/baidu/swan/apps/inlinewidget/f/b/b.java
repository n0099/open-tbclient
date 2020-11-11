package com.baidu.swan.apps.inlinewidget.f.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.inlinewidget.f.b.a.c;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes10.dex */
public class b {
    private static final com.baidu.swan.apps.inlinewidget.f.b.a.a cWV = new com.baidu.swan.apps.inlinewidget.f.b.a.b();
    private static volatile com.baidu.swan.apps.inlinewidget.f.b.a.a cWW = cWV;

    @NonNull
    public static com.baidu.swan.apps.inlinewidget.f.b.a.a awb() {
        return cWW;
    }

    private static void a(@NonNull com.baidu.swan.apps.inlinewidget.f.b.a.a aVar) {
        cWW = aVar;
    }

    public static void oR(String str) {
        a(new c(str));
    }

    public static void awc() {
        a(cWV);
    }

    public static void awd() {
        awb().awf();
    }

    public static void awe() {
        awb().awf();
    }

    /* loaded from: classes10.dex */
    public static class a implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void M(HybridUbcFlow hybridUbcFlow) {
            b.awb().fn(TextUtils.equals(hybridUbcFlow.aDk().optString("type"), "3") || hybridUbcFlow.oP("na_first_meaningful_paint"));
        }
    }
}
