package com.baidu.swan.pms.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Arrays;
import java.util.HashSet;
/* loaded from: classes2.dex */
public final class g {
    @NonNull
    public static Bundle a(@NonNull d dVar, @NonNull String... strArr) {
        return a(dVar, null, strArr);
    }

    @NonNull
    public static Bundle a(@NonNull d dVar, @Nullable Bundle bundle, String... strArr) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (bundle.getLong("timestamp", -1L) < 0) {
            bundle.putLong("timestamp", System.currentTimeMillis());
        }
        return dVar.a(bundle, new HashSet(Arrays.asList(strArr)));
    }
}
