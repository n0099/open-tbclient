package com.airbnb.lottie.model;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.LruCache;
import com.baidu.android.common.logging.Log;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class g {
    private static final g Dl = new g();
    private final LruCache<String, com.airbnb.lottie.e> Dm = new LruCache<>(Log.FILE_LIMETE);

    public static g hJ() {
        return Dl;
    }

    @VisibleForTesting
    g() {
    }

    @Nullable
    public com.airbnb.lottie.e bg(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.Dm.get(str);
    }

    public void a(@Nullable String str, com.airbnb.lottie.e eVar) {
        if (str != null) {
            this.Dm.put(str, eVar);
        }
    }
}
