package com.baidu.poly.b.a;

import android.graphics.Bitmap;
import android.util.LruCache;
/* loaded from: classes2.dex */
public class b {
    private LruCache<String, Bitmap> aig = new LruCache<String, Bitmap>(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8) { // from class: com.baidu.poly.b.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: c */
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getByteCount() / 1024;
        }
    };

    public Bitmap dn(String str) {
        return m12do(com.baidu.poly.b.b.b.dr(str));
    }

    public void b(String str, Bitmap bitmap) {
        String dr = com.baidu.poly.b.b.b.dr(str);
        if (m12do(dr) == null) {
            this.aig.put(dr, bitmap);
        }
    }

    /* renamed from: do  reason: not valid java name */
    private Bitmap m12do(String str) {
        return this.aig.get(str);
    }
}
