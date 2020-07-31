package com.baidu.swan.apps.core.prefetch;

import android.support.annotation.NonNull;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class c {
    private static final b cfp = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface b {
        boolean kh(@NonNull String str);
    }

    public static boolean kh(String str) {
        return acA().kh(str);
    }

    private static b acA() {
        return cfp;
    }

    /* loaded from: classes7.dex */
    public static class a implements b {
        private static final String[] cfq = {"Gz7Grjwr0GhpGSDIhtUk6RB1EiBCRmHK"};

        @Override // com.baidu.swan.apps.core.prefetch.c.b
        public boolean kh(@NonNull String str) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            for (String str2 : cfq) {
                if (str.startsWith(str2)) {
                    return false;
                }
            }
            return true;
        }
    }
}
