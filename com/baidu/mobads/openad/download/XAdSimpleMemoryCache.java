package com.baidu.mobads.openad.download;

import android.graphics.Bitmap;
import java.util.WeakHashMap;
/* loaded from: classes2.dex */
public class XAdSimpleMemoryCache {

    /* renamed from: a  reason: collision with root package name */
    public static volatile XAdSimpleMemoryCache f8415a;

    /* renamed from: b  reason: collision with root package name */
    public static WeakHashMap<String, Bitmap> f8416b = new WeakHashMap<>();

    public static XAdSimpleMemoryCache getInstance() {
        if (f8415a == null) {
            synchronized (XAdSimpleMemoryCache.class) {
                if (f8415a == null) {
                    f8415a = new XAdSimpleMemoryCache();
                }
            }
        }
        return f8415a;
    }

    public void clearCache() {
        f8416b.clear();
    }

    public Bitmap get(String str) {
        if (str != null) {
            return f8416b.get(str);
        }
        return null;
    }

    public void put(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return;
        }
        f8416b.put(str, bitmap);
    }

    public void remove(Object obj) {
        if (obj != null) {
            f8416b.remove(obj);
        }
    }
}
