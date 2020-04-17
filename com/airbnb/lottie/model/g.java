package com.airbnb.lottie.model;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.LruCache;
import com.baidu.android.common.logging.Log;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class g {
    private static final g Di = new g();
    private final LruCache<String, com.airbnb.lottie.e> Dj = new LruCache<>(Log.FILE_LIMETE);

    public static g hJ() {
        return Di;
    }

    @VisibleForTesting
    g() {
    }

    @Nullable
    public com.airbnb.lottie.e bg(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.Dj.get(str);
    }

    public void a(@Nullable String str, com.airbnb.lottie.e eVar) {
        if (str != null) {
            this.Dj.put(str, eVar);
        }
    }
}
