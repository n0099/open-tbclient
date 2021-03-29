package com.baidu.mobads.openad.download;

import android.graphics.Bitmap;
import java.util.WeakHashMap;
/* loaded from: classes2.dex */
public class XAdSimpleMemoryCache {

    /* renamed from: a  reason: collision with root package name */
    public static volatile XAdSimpleMemoryCache f8416a;

    /* renamed from: b  reason: collision with root package name */
    public static WeakHashMap<String, Bitmap> f8417b = new WeakHashMap<>();

    public static XAdSimpleMemoryCache getInstance() {
        if (f8416a == null) {
            synchronized (XAdSimpleMemoryCache.class) {
                if (f8416a == null) {
                    f8416a = new XAdSimpleMemoryCache();
                }
            }
        }
        return f8416a;
    }

    public void clearCache() {
        f8417b.clear();
    }

    public Bitmap get(String str) {
        if (str != null) {
            return f8417b.get(str);
        }
        return null;
    }

    public void put(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return;
        }
        f8417b.put(str, bitmap);
    }

    public void remove(Object obj) {
        if (obj != null) {
            f8417b.remove(obj);
        }
    }
}
