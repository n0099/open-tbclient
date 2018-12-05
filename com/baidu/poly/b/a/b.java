package com.baidu.poly.b.a;

import android.graphics.Bitmap;
import android.util.LruCache;
/* loaded from: classes2.dex */
public class b {
    private LruCache<String, Bitmap> ahX = new LruCache<String, Bitmap>(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8) { // from class: com.baidu.poly.b.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: c */
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getByteCount() / 1024;
        }
    };

    public Bitmap dm(String str) {
        return dn(com.baidu.poly.b.b.b.dq(str));
    }

    public void b(String str, Bitmap bitmap) {
        String dq = com.baidu.poly.b.b.b.dq(str);
        if (dn(dq) == null) {
            this.ahX.put(dq, bitmap);
        }
    }

    private Bitmap dn(String str) {
        return this.ahX.get(str);
    }
}
