package com.baidu.swan.apps.inlinewidget.f.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.f.b.a.c;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes9.dex */
public class b {
    private static final com.baidu.swan.apps.inlinewidget.f.b.a.a deA = new com.baidu.swan.apps.inlinewidget.f.b.a.b();
    private static volatile com.baidu.swan.apps.inlinewidget.f.b.a.a deB = deA;

    @NonNull
    public static com.baidu.swan.apps.inlinewidget.f.b.a.a awx() {
        return deB;
    }

    private static void a(@NonNull com.baidu.swan.apps.inlinewidget.f.b.a.a aVar) {
        deB = aVar;
    }

    public static void os(String str) {
        a(new c(str));
    }

    public static void awy() {
        a(deA);
    }

    public static void awz() {
        awx().awB();
    }

    public static void awA() {
        awx().awB();
    }

    /* loaded from: classes9.dex */
    public static class a implements com.baidu.swan.apps.ao.e.b<HybridUbcFlow> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public void L(HybridUbcFlow hybridUbcFlow) {
            b.awx().fM(TextUtils.equals(hybridUbcFlow.aDH().optString("type"), "3") || hybridUbcFlow.oq("na_first_meaningful_paint"));
        }
    }
}
