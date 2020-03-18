package com.baidu.swan.support.v4.c;

import android.graphics.Paint;
import android.os.Build;
import android.view.View;
/* loaded from: classes11.dex */
public class f {
    static final k cEb;

    /* loaded from: classes11.dex */
    interface k {
        boolean canScrollVertically(View view, int i);

        int getLayerType(View view);

        boolean hasOverlappingRendering(View view);

        void setLayerType(View view, int i, Paint paint);

        void setSaveFromParentEnabled(View view, boolean z);
    }

    /* loaded from: classes11.dex */
    static class a implements k {
        a() {
        }

        @Override // com.baidu.swan.support.v4.c.f.k
        public boolean canScrollVertically(View view, int i) {
            return false;
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

    /* loaded from: classes11.dex */
    static class b extends a {
        b() {
        }
    }

    /* loaded from: classes11.dex */
    static class c extends b {
        c() {
        }
    }

    /* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
    static class e extends d {
        static boolean cEc = false;

        e() {
        }

        @Override // com.baidu.swan.support.v4.c.f.a, com.baidu.swan.support.v4.c.f.k
        public boolean canScrollVertically(View view, int i) {
            return com.baidu.swan.support.v4.c.h.canScrollVertically(view, i);
        }
    }

    /* renamed from: com.baidu.swan.support.v4.c.f$f  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    static class C0368f extends e {
        C0368f() {
        }

        @Override // com.baidu.swan.support.v4.c.f.a, com.baidu.swan.support.v4.c.f.k
        public boolean hasOverlappingRendering(View view) {
            return com.baidu.swan.support.v4.c.i.hasOverlappingRendering(view);
        }
    }

    /* loaded from: classes11.dex */
    static class g extends C0368f {
        g() {
        }
    }

    /* loaded from: classes11.dex */
    static class h extends g {
        h() {
        }
    }

    /* loaded from: classes11.dex */
    static class i extends h {
        i() {
        }
    }

    /* loaded from: classes11.dex */
    static class j extends i {
        j() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            cEb = new j();
        } else {
            cEb = new i();
        }
    }

    public static boolean canScrollVertically(View view, int i2) {
        return cEb.canScrollVertically(view, i2);
    }

    public static void setLayerType(View view, int i2, Paint paint) {
        cEb.setLayerType(view, i2, paint);
    }

    public static int getLayerType(View view) {
        return cEb.getLayerType(view);
    }

    public static void setSaveFromParentEnabled(View view, boolean z) {
        cEb.setSaveFromParentEnabled(view, z);
    }

    public static boolean hasOverlappingRendering(View view) {
        return cEb.hasOverlappingRendering(view);
    }
}
