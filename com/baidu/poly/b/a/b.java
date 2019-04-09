package com.baidu.poly.b.a;

import android.graphics.Bitmap;
import android.util.LruCache;
/* loaded from: classes2.dex */
public class b {
    private LruCache<String, Bitmap> agR = new LruCache<String, Bitmap>(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8) { // from class: com.baidu.poly.b.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: c */
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getByteCount() / 1024;
        }
    };

    public Bitmap db(String str) {
        return dc(com.baidu.poly.b.b.b.df(str));
    }

    public void b(String str, Bitmap bitmap) {
        String df = com.baidu.poly.b.b.b.df(str);
        if (dc(df) == null) {
            this.agR.put(df, bitmap);
        }
    }

    private Bitmap dc(String str) {
        return this.agR.get(str);
    }
}
