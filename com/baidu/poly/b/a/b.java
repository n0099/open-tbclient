package com.baidu.poly.b.a;

import android.graphics.Bitmap;
import android.util.LruCache;
/* loaded from: classes2.dex */
public class b {
    private LruCache<String, Bitmap> aBb = new LruCache<String, Bitmap>(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8) { // from class: com.baidu.poly.b.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: d */
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getByteCount() / 1024;
        }
    };

    public Bitmap dD(String str) {
        return dE(com.baidu.poly.b.b.b.dH(str));
    }

    public void c(String str, Bitmap bitmap) {
        String dH = com.baidu.poly.b.b.b.dH(str);
        if (dE(dH) == null) {
            this.aBb.put(dH, bitmap);
        }
    }

    private Bitmap dE(String str) {
        return this.aBb.get(str);
    }
}
