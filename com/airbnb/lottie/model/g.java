package com.airbnb.lottie.model;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.LruCache;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class g {
    private static final g hG = new g();
    private final LruCache<String, com.airbnb.lottie.e> hH = new LruCache<>(10485760);

    public static g cm() {
        return hG;
    }

    @VisibleForTesting
    g() {
    }

    @Nullable
    public com.airbnb.lottie.e Q(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.hH.get(str);
    }

    public void a(@Nullable String str, com.airbnb.lottie.e eVar) {
        if (str != null) {
            this.hH.put(str, eVar);
        }
    }
}
