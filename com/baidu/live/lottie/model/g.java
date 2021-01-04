package com.baidu.live.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import com.baidu.android.common.logging.Log;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes10.dex */
public class g {
    private static final g buA = new g();
    private final LruCache<String, com.baidu.live.lottie.e> Fq = new LruCache<>(Log.FILE_LIMETE);

    public static g PO() {
        return buA;
    }

    @VisibleForTesting
    g() {
    }

    @Nullable
    public com.baidu.live.lottie.e ia(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.Fq.get(str);
    }

    public void a(@Nullable String str, com.baidu.live.lottie.e eVar) {
        if (str != null) {
            this.Fq.put(str, eVar);
        }
    }
}
