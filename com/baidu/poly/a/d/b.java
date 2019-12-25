package com.baidu.poly.a.d;

import android.graphics.Bitmap;
import android.util.LruCache;
/* loaded from: classes9.dex */
public class b {
    private LruCache<String, Bitmap> aLl = new a(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8);

    /* loaded from: classes9.dex */
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

    private Bitmap et(String str) {
        return this.aLl.get(str);
    }

    public void e(String str, Bitmap bitmap) {
        String h = com.baidu.poly.a.f.b.h(str);
        if (et(h) == null) {
            this.aLl.put(h, bitmap);
        }
    }

    public Bitmap eu(String str) {
        return et(com.baidu.poly.a.f.b.h(str));
    }
}
