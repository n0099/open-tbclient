package com.baidu.poly.a.d;

import android.graphics.Bitmap;
import android.util.LruCache;
/* loaded from: classes11.dex */
public class b {
    private LruCache<String, Bitmap> buw = new a(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8);

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

    private Bitmap gt(String str) {
        return this.buw.get(str);
    }

    public void e(String str, Bitmap bitmap) {
        String g = com.baidu.poly.a.f.b.g(str);
        if (gt(g) == null) {
            this.buw.put(g, bitmap);
        }
    }

    public Bitmap gu(String str) {
        return gt(com.baidu.poly.a.f.b.g(str));
    }
}
