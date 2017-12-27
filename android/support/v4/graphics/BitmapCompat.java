package android.support.v4.graphics;

import android.graphics.Bitmap;
import android.os.Build;
/* loaded from: classes2.dex */
public final class BitmapCompat {
    static final b wp;

    /* loaded from: classes2.dex */
    interface b {
        int getAllocationByteCount(Bitmap bitmap);

        boolean hasMipMap(Bitmap bitmap);

        void setHasMipMap(Bitmap bitmap, boolean z);
    }

    /* loaded from: classes2.dex */
    static class a implements b {
        a() {
        }

        @Override // android.support.v4.graphics.BitmapCompat.b
        public boolean hasMipMap(Bitmap bitmap) {
            return false;
        }

        @Override // android.support.v4.graphics.BitmapCompat.b
        public void setHasMipMap(Bitmap bitmap, boolean z) {
        }

        @Override // android.support.v4.graphics.BitmapCompat.b
        public int getAllocationByteCount(Bitmap bitmap) {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
    }

    /* loaded from: classes2.dex */
    static class c extends a {
        c() {
        }

        @Override // android.support.v4.graphics.BitmapCompat.a, android.support.v4.graphics.BitmapCompat.b
        public int getAllocationByteCount(Bitmap bitmap) {
            return android.support.v4.graphics.a.getAllocationByteCount(bitmap);
        }
    }

    /* loaded from: classes2.dex */
    static class d extends c {
        d() {
        }

        @Override // android.support.v4.graphics.BitmapCompat.a, android.support.v4.graphics.BitmapCompat.b
        public boolean hasMipMap(Bitmap bitmap) {
            return android.support.v4.graphics.b.hasMipMap(bitmap);
        }

        @Override // android.support.v4.graphics.BitmapCompat.a, android.support.v4.graphics.BitmapCompat.b
        public void setHasMipMap(Bitmap bitmap, boolean z) {
            android.support.v4.graphics.b.setHasMipMap(bitmap, z);
        }
    }

    /* loaded from: classes2.dex */
    static class e extends d {
        e() {
        }

        @Override // android.support.v4.graphics.BitmapCompat.c, android.support.v4.graphics.BitmapCompat.a, android.support.v4.graphics.BitmapCompat.b
        public int getAllocationByteCount(Bitmap bitmap) {
            return android.support.v4.graphics.c.getAllocationByteCount(bitmap);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            wp = new e();
        } else if (i >= 18) {
            wp = new d();
        } else if (i >= 12) {
            wp = new c();
        } else {
            wp = new a();
        }
    }

    public static boolean hasMipMap(Bitmap bitmap) {
        return wp.hasMipMap(bitmap);
    }

    public static void setHasMipMap(Bitmap bitmap, boolean z) {
        wp.setHasMipMap(bitmap, z);
    }

    public static int getAllocationByteCount(Bitmap bitmap) {
        return wp.getAllocationByteCount(bitmap);
    }

    private BitmapCompat() {
    }
}
