package com.baidu.poly.a.e;

import android.graphics.Bitmap;
import android.util.LruCache;
/* loaded from: classes6.dex */
public class b {
    private LruCache<String, Bitmap> bFi = new a(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8);

    /* loaded from: classes6.dex */
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

    private Bitmap hU(String str) {
        return this.bFi.get(str);
    }

    public void e(String str, Bitmap bitmap) {
        String g = com.baidu.poly.a.g.b.g(str);
        if (hU(g) == null) {
            this.bFi.put(g, bitmap);
        }
    }

    public Bitmap hV(String str) {
        return hU(com.baidu.poly.a.g.b.g(str));
    }
}
