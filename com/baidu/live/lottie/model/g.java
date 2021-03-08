package com.baidu.live.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import com.baidu.android.common.logging.Log;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes9.dex */
public class g {
    private static final g buP = new g();
    private final LruCache<String, com.baidu.live.lottie.e> GJ = new LruCache<>(Log.FILE_LIMETE);

    public static g Nu() {
        return buP;
    }

    @VisibleForTesting
    g() {
    }

    @Nullable
    public com.baidu.live.lottie.e hu(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.GJ.get(str);
    }

    public void a(@Nullable String str, com.baidu.live.lottie.e eVar) {
        if (str != null) {
            this.GJ.put(str, eVar);
        }
    }
}
