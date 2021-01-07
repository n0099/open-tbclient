package com.baidu.swan.apps.inlinewidget.f.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.f.b.a.c;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes9.dex */
public class b {
    private static final com.baidu.swan.apps.inlinewidget.f.b.a.a dhb = new com.baidu.swan.apps.inlinewidget.f.b.a.b();
    private static volatile com.baidu.swan.apps.inlinewidget.f.b.a.a dhc = dhb;

    @NonNull
    public static com.baidu.swan.apps.inlinewidget.f.b.a.a azT() {
        return dhc;
    }

    private static void a(@NonNull com.baidu.swan.apps.inlinewidget.f.b.a.a aVar) {
        dhc = aVar;
    }

    public static void pl(String str) {
        a(new c(str));
    }

    public static void azU() {
        a(dhb);
    }

    public static void azV() {
        azT().azX();
    }

    public static void azW() {
        azT().azX();
    }

    /* loaded from: classes9.dex */
    public static class a implements com.baidu.swan.apps.ao.e.b<HybridUbcFlow> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public void L(HybridUbcFlow hybridUbcFlow) {
            b.azT().fO(TextUtils.equals(hybridUbcFlow.aHf().optString("type"), "3") || hybridUbcFlow.pj("na_first_meaningful_paint"));
        }
    }
}
