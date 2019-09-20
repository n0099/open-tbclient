package com.baidu.poly.b.a;

import android.graphics.Bitmap;
import android.util.LruCache;
/* loaded from: classes2.dex */
public class b {
    private LruCache<String, Bitmap> ahV = new LruCache<String, Bitmap>(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8) { // from class: com.baidu.poly.b.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: c */
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getByteCount() / 1024;
        }
    };

    public Bitmap cT(String str) {
        return cU(com.baidu.poly.b.b.b.cX(str));
    }

    public void b(String str, Bitmap bitmap) {
        String cX = com.baidu.poly.b.b.b.cX(str);
        if (cU(cX) == null) {
            this.ahV.put(cX, bitmap);
        }
    }

    private Bitmap cU(String str) {
        return this.ahV.get(str);
    }
}
