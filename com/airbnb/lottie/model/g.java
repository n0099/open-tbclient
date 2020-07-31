package com.airbnb.lottie.model;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.LruCache;
import com.baidu.android.common.logging.Log;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes20.dex */
public class g {
    private static final g DO = new g();
    private final LruCache<String, com.airbnb.lottie.e> DQ = new LruCache<>(Log.FILE_LIMETE);

    public static g hZ() {
        return DO;
    }

    @VisibleForTesting
    g() {
    }

    @Nullable
    public com.airbnb.lottie.e bh(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.DQ.get(str);
    }

    public void a(@Nullable String str, com.airbnb.lottie.e eVar) {
        if (str != null) {
            this.DQ.put(str, eVar);
        }
    }
}
