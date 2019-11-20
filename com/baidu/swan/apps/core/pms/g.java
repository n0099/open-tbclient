package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import java.util.Set;
/* loaded from: classes2.dex */
public abstract class g extends com.baidu.swan.pms.a.f {
    @Override // com.baidu.swan.pms.a.f, com.baidu.swan.pms.a.d
    @NonNull
    public Bundle a(@NonNull Bundle bundle, Set<String> set) {
        Bundle a = super.a(bundle, set);
        if (set.contains("swan_pms_buffer")) {
            a.putInt("swan_pms_buffer", a.Gg());
        }
        return a;
    }
}
