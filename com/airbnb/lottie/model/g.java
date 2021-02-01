package com.airbnb.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import com.baidu.android.common.logging.Log;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes4.dex */
public class g {
    private static final g Fn = new g();
    private final LruCache<String, com.airbnb.lottie.d> Fo = new LruCache<>(Log.FILE_LIMETE);

    public static g ja() {
        return Fn;
    }

    @VisibleForTesting
    g() {
    }

    @Nullable
    public com.airbnb.lottie.d bm(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.Fo.get(str);
    }

    public void a(@Nullable String str, com.airbnb.lottie.d dVar) {
        if (str != null) {
            this.Fo.put(str, dVar);
        }
    }
}
