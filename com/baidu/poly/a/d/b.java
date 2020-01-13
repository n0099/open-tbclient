package com.baidu.poly.a.d;

import android.graphics.Bitmap;
import android.util.LruCache;
/* loaded from: classes10.dex */
public class b {
    private LruCache<String, Bitmap> aMd = new a(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8);

    /* loaded from: classes10.dex */
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

    private Bitmap ew(String str) {
        return this.aMd.get(str);
    }

    public void e(String str, Bitmap bitmap) {
        String h = com.baidu.poly.a.f.b.h(str);
        if (ew(h) == null) {
            this.aMd.put(h, bitmap);
        }
    }

    public Bitmap ex(String str) {
        return ew(com.baidu.poly.a.f.b.h(str));
    }
}
