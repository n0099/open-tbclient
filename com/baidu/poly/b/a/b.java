package com.baidu.poly.b.a;

import android.graphics.Bitmap;
import android.util.LruCache;
/* loaded from: classes2.dex */
public class b {
    private LruCache<String, Bitmap> agK = new LruCache<String, Bitmap>(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8) { // from class: com.baidu.poly.b.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: c */
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getByteCount() / 1024;
        }
    };

    public Bitmap cZ(String str) {
        return da(com.baidu.poly.b.b.b.dd(str));
    }

    public void b(String str, Bitmap bitmap) {
        String dd = com.baidu.poly.b.b.b.dd(str);
        if (da(dd) == null) {
            this.agK.put(dd, bitmap);
        }
    }

    private Bitmap da(String str) {
        return this.agK.get(str);
    }
}
