package com.baidu.mobads.openad.download;

import android.graphics.Bitmap;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public class XAdSimpleMemoryCache {

    /* renamed from: a  reason: collision with root package name */
    private static volatile XAdSimpleMemoryCache f3424a;

    /* renamed from: b  reason: collision with root package name */
    private static WeakHashMap<String, Bitmap> f3425b = new WeakHashMap<>();

    public static XAdSimpleMemoryCache getInstance() {
        if (f3424a == null) {
            synchronized (XAdSimpleMemoryCache.class) {
                if (f3424a == null) {
                    f3424a = new XAdSimpleMemoryCache();
                }
            }
        }
        return f3424a;
    }

    public void put(String str, Bitmap bitmap) {
        if (str != null && bitmap != null) {
            f3425b.put(str, bitmap);
        }
    }

    public Bitmap get(String str) {
        if (str != null) {
            return f3425b.get(str);
        }
        return null;
    }

    public void remove(Object obj) {
        if (obj != null) {
            f3425b.remove(obj);
        }
    }

    public void clearCache() {
        f3425b.clear();
    }
}
