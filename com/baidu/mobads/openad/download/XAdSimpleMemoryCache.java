package com.baidu.mobads.openad.download;

import android.graphics.Bitmap;
import java.util.WeakHashMap;
/* loaded from: classes4.dex */
public class XAdSimpleMemoryCache {

    /* renamed from: a  reason: collision with root package name */
    private static volatile XAdSimpleMemoryCache f2439a;
    private static WeakHashMap<String, Bitmap> b = new WeakHashMap<>();

    public static XAdSimpleMemoryCache getInstance() {
        if (f2439a == null) {
            synchronized (XAdSimpleMemoryCache.class) {
                if (f2439a == null) {
                    f2439a = new XAdSimpleMemoryCache();
                }
            }
        }
        return f2439a;
    }

    public void put(String str, Bitmap bitmap) {
        if (str != null && bitmap != null) {
            b.put(str, bitmap);
        }
    }

    public Bitmap get(String str) {
        if (str != null) {
            return b.get(str);
        }
        return null;
    }

    public void remove(Object obj) {
        if (obj != null) {
            b.remove(obj);
        }
    }

    public void clearCache() {
        b.clear();
    }
}
