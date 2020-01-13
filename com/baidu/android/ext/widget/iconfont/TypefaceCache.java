package com.baidu.android.ext.widget.iconfont;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
/* loaded from: classes12.dex */
public final class TypefaceCache {
    private static final LruCache<String, Typeface> sCache = new LruCache<>(10);

    public static Typeface getTypeface(Context context, int i) {
        if (i <= 0 || context == null) {
            return null;
        }
        return getTypeface(context, context.getResources().getString(i));
    }

    public static Typeface getTypeface(Context context, String str) {
        Typeface cache;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Typeface cache2 = getCache(str);
        if (cache2 == null && context != null) {
            synchronized (TypefaceCache.class) {
                cache = getCache(str);
                if (cache == null) {
                    try {
                        cache = Typeface.createFromAsset(context.getResources().getAssets(), str);
                    } catch (Exception e) {
                        e.printStackTrace();
                        cache = null;
                    }
                    if (cache != null) {
                        sCache.put(str, cache);
                    }
                }
            }
            return cache;
        }
        return cache2;
    }

    private static Typeface getCache(String str) {
        return sCache.get(str);
    }
}
