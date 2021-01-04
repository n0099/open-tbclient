package com.airbnb.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import com.baidu.android.common.logging.Log;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes3.dex */
public class g {
    private static final g Fp = new g();
    private final LruCache<String, com.airbnb.lottie.d> Fq = new LruCache<>(Log.FILE_LIMETE);

    public static g jb() {
        return Fp;
    }

    @VisibleForTesting
    g() {
    }

    @Nullable
    public com.airbnb.lottie.d bm(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.Fq.get(str);
    }

    public void a(@Nullable String str, com.airbnb.lottie.d dVar) {
        if (str != null) {
            this.Fq.put(str, dVar);
        }
    }
}
