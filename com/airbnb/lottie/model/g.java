package com.airbnb.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import com.baidu.android.common.logging.Log;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public class g {
    private static final g GI = new g();
    private final LruCache<String, com.airbnb.lottie.d> GJ = new LruCache<>(Log.FILE_LIMETE);

    public static g ja() {
        return GI;
    }

    @VisibleForTesting
    g() {
    }

    @Nullable
    public com.airbnb.lottie.d bq(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.GJ.get(str);
    }

    public void a(@Nullable String str, com.airbnb.lottie.d dVar) {
        if (str != null) {
            this.GJ.put(str, dVar);
        }
    }
}
