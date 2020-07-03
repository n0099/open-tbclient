package com.baidu.poly.a.d;

import android.graphics.Bitmap;
import android.util.LruCache;
/* loaded from: classes11.dex */
public class b {
    private LruCache<String, Bitmap> bzo = new a(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8);

    /* loaded from: classes11.dex */
    class a extends LruCache<String, Bitmap> {
        a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: d */
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getByteCount() / 1024;
        }
    }

    private Bitmap gB(String str) {
        return this.bzo.get(str);
    }

    public void e(String str, Bitmap bitmap) {
        String g = com.baidu.poly.a.f.b.g(str);
        if (gB(g) == null) {
            this.bzo.put(g, bitmap);
        }
    }

    public Bitmap gC(String str) {
        return gB(com.baidu.poly.a.f.b.g(str));
    }
}
