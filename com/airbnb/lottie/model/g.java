package com.airbnb.lottie.model;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.LruCache;
import com.baidu.android.common.logging.Log;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes10.dex */
public class g {
    private static final g EL = new g();
    private final LruCache<String, com.airbnb.lottie.e> EM = new LruCache<>(Log.FILE_LIMETE);

    public static g jC() {
        return EL;
    }

    @VisibleForTesting
    g() {
    }

    @Nullable
    public com.airbnb.lottie.e bm(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.EM.get(str);
    }

    public void a(@Nullable String str, com.airbnb.lottie.e eVar) {
        if (str != null) {
            this.EM.put(str, eVar);
        }
    }
}
