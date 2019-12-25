package com.baidu.swan.pms.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Arrays;
import java.util.HashSet;
/* loaded from: classes9.dex */
public final class h {
    @NonNull
    public static Bundle a(@NonNull e eVar, @NonNull String... strArr) {
        return a(eVar, null, strArr);
    }

    @NonNull
    public static Bundle a(@NonNull e eVar, @Nullable Bundle bundle, String... strArr) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (bundle.getLong("timestamp", -1L) < 0) {
            bundle.putLong("timestamp", System.currentTimeMillis());
        }
        return eVar.a(bundle, new HashSet(Arrays.asList(strArr)));
    }
}
