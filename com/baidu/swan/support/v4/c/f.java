package com.baidu.swan.support.v4.c;

import android.graphics.Paint;
import android.os.Build;
import android.view.View;
/* loaded from: classes2.dex */
public class f {
    static final k bvt;

    /* loaded from: classes2.dex */
    interface k {
        int getLayerType(View view);

        boolean hasOverlappingRendering(View view);

        void setLayerType(View view, int i, Paint paint);

        void setSaveFromParentEnabled(View view, boolean z);
    }

    /* loaded from: classes2.dex */
    static class a implements k {
        a() {
        }

        @Override // com.baidu.swan.support.v4.c.f.k
        public void setLayerType(View view, int i, Paint paint) {
        }

        @Override // com.baidu.swan.support.v4.c.f.k
        public int getLayerType(View view) {
            return 0;
        }

        @Override // com.baidu.swan.support.v4.c.f.k
        public boolean hasOverlappingRendering(View view) {
            return true;
        }

        @Override // com.baidu.swan.support.v4.c.f.k
        public void setSaveFromParentEnabled(View view, boolean z) {
        }
    }

    /* loaded from: classes2.dex */
    static class b extends a {
        b() {
        }
    }

    /* loaded from: classes2.dex */
    static class c extends b {
        c() {
        }
    }

    /* loaded from: classes2.dex */
    static class d extends c {
        d() {
        }

        @Override // com.baidu.swan.support.v4.c.f.a, com.baidu.swan.support.v4.c.f.k
        public void setLayerType(View view, int i, Paint paint) {
            com.baidu.swan.support.v4.c.g.setLayerType(view, i, paint);
        }

        @Override // com.baidu.swan.support.v4.c.f.a, com.baidu.swan.support.v4.c.f.k
        public int getLayerType(View view) {
            return com.baidu.swan.support.v4.c.g.getLayerType(view);
        }

        @Override // com.baidu.swan.support.v4.c.f.a, com.baidu.swan.support.v4.c.f.k
        public void setSaveFromParentEnabled(View view, boolean z) {
            com.baidu.swan.support.v4.c.g.setSaveFromParentEnabled(view, z);
        }
    }

    /* loaded from: classes2.dex */
    static class e extends d {
        static boolean bvu = false;

        e() {
        }
    }

    /* renamed from: com.baidu.swan.support.v4.c.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0232f extends e {
        C0232f() {
        }

        @Override // com.baidu.swan.support.v4.c.f.a, com.baidu.swan.support.v4.c.f.k
        public boolean hasOverlappingRendering(View view) {
            return com.baidu.swan.support.v4.c.h.hasOverlappingRendering(view);
        }
    }

    /* loaded from: classes2.dex */
    static class g extends C0232f {
        g() {
        }
    }

    /* loaded from: classes2.dex */
    static class h extends g {
        h() {
        }
    }

    /* loaded from: classes2.dex */
    static class i extends h {
        i() {
        }
    }

    /* loaded from: classes2.dex */
    static class j extends i {
        j() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            bvt = new j();
        } else {
            bvt = new i();
        }
    }

    public static void setLayerType(View view, int i2, Paint paint) {
        bvt.setLayerType(view, i2, paint);
    }

    public static int getLayerType(View view) {
        return bvt.getLayerType(view);
    }

    public static void setSaveFromParentEnabled(View view, boolean z) {
        bvt.setSaveFromParentEnabled(view, z);
    }

    public static boolean hasOverlappingRendering(View view) {
        return bvt.hasOverlappingRendering(view);
    }
}
