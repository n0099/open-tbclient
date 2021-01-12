package com.baidu.live.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import com.baidu.android.common.logging.Log;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes9.dex */
public class g {
    private static final g bpM = new g();
    private final LruCache<String, com.baidu.live.lottie.e> Fo = new LruCache<>(Log.FILE_LIMETE);

    public static g LT() {
        return bpM;
    }

    @VisibleForTesting
    g() {
    }

    @Nullable
    public com.baidu.live.lottie.e gP(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.Fo.get(str);
    }

    public void a(@Nullable String str, com.baidu.live.lottie.e eVar) {
        if (str != null) {
            this.Fo.put(str, eVar);
        }
    }
}
