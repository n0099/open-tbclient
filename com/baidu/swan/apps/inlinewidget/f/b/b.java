package com.baidu.swan.apps.inlinewidget.f.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.f.b.a.c;
import com.baidu.swan.apps.performance.HybridUbcFlow;
/* loaded from: classes8.dex */
public class b {
    private static final com.baidu.swan.apps.inlinewidget.f.b.a.a dcm = new com.baidu.swan.apps.inlinewidget.f.b.a.b();
    private static volatile com.baidu.swan.apps.inlinewidget.f.b.a.a dcn = dcm;

    @NonNull
    public static com.baidu.swan.apps.inlinewidget.f.b.a.a avZ() {
        return dcn;
    }

    private static void a(@NonNull com.baidu.swan.apps.inlinewidget.f.b.a.a aVar) {
        dcn = aVar;
    }

    public static void nY(String str) {
        a(new c(str));
    }

    public static void awa() {
        a(dcm);
    }

    public static void awb() {
        avZ().awd();
    }

    public static void awc() {
        avZ().awd();
    }

    /* loaded from: classes8.dex */
    public static class a implements com.baidu.swan.apps.ao.e.b<HybridUbcFlow> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public void L(HybridUbcFlow hybridUbcFlow) {
            b.avZ().fK(TextUtils.equals(hybridUbcFlow.aDl().optString("type"), "3") || hybridUbcFlow.nW("na_first_meaningful_paint"));
        }
    }
}
