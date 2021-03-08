package com.baidu.swan.apps.inlinewidget.f.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.f.b.a.c;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes8.dex */
public class b {
    private static final com.baidu.swan.apps.inlinewidget.f.b.a.a dgb = new com.baidu.swan.apps.inlinewidget.f.b.a.b();
    private static volatile com.baidu.swan.apps.inlinewidget.f.b.a.a dgc = dgb;

    @NonNull
    public static com.baidu.swan.apps.inlinewidget.f.b.a.a awA() {
        return dgc;
    }

    private static void a(@NonNull com.baidu.swan.apps.inlinewidget.f.b.a.a aVar) {
        dgc = aVar;
    }

    public static void oz(String str) {
        a(new c(str));
    }

    public static void awB() {
        a(dgb);
    }

    public static void awC() {
        awA().awE();
    }

    public static void awD() {
        awA().awE();
    }

    /* loaded from: classes8.dex */
    public static class a implements com.baidu.swan.apps.ao.e.b<HybridUbcFlow> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public void N(HybridUbcFlow hybridUbcFlow) {
            b.awA().fM(TextUtils.equals(hybridUbcFlow.aDK().optString("type"), "3") || hybridUbcFlow.ox("na_first_meaningful_paint"));
        }
    }
}
