package com.baidu.poly.a.e;

import android.graphics.Bitmap;
import android.util.LruCache;
/* loaded from: classes9.dex */
public class b {
    private LruCache<String, Bitmap> bHn = new a(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8);

    /* loaded from: classes9.dex */
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

    private Bitmap io(String str) {
        return this.bHn.get(str);
    }

    public void e(String str, Bitmap bitmap) {
        String g = com.baidu.poly.a.g.b.g(str);
        if (io(g) == null) {
            this.bHn.put(g, bitmap);
        }
    }

    public Bitmap ip(String str) {
        return io(com.baidu.poly.a.g.b.g(str));
    }
}
