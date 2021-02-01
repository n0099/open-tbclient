package com.baidu.poly.a.e;

import android.graphics.Bitmap;
import android.util.LruCache;
/* loaded from: classes4.dex */
public class b {
    private LruCache<String, Bitmap> cny = new a(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8);

    /* loaded from: classes4.dex */
    class a extends LruCache<String, Bitmap> {
        a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getByteCount() / 1024;
        }
    }

    private Bitmap jn(String str) {
        return this.cny.get(str);
    }

    public void d(String str, Bitmap bitmap) {
        String g = com.baidu.poly.a.g.b.g(str);
        if (jn(g) == null) {
            this.cny.put(g, bitmap);
        }
    }

    public Bitmap jo(String str) {
        return jn(com.baidu.poly.a.g.b.g(str));
    }
}
