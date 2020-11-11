package com.baidu.poly.a.e;

import android.graphics.Bitmap;
import android.util.LruCache;
/* loaded from: classes6.dex */
public class b {
    private LruCache<String, Bitmap> ccd = new a(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8);

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

    private Bitmap jw(String str) {
        return this.ccd.get(str);
    }

    public void e(String str, Bitmap bitmap) {
        String g = com.baidu.poly.a.g.b.g(str);
        if (jw(g) == null) {
            this.ccd.put(g, bitmap);
        }
    }

    public Bitmap jx(String str) {
        return jw(com.baidu.poly.a.g.b.g(str));
    }
}
