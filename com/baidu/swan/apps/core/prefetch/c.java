package com.baidu.swan.apps.core.prefetch;

import android.support.annotation.NonNull;
import android.text.TextUtils;
/* loaded from: classes11.dex */
public final class c {
    private static final b cdI = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface b {
        boolean jO(@NonNull String str);
    }

    public static boolean jO(String str) {
        return aby().jO(str);
    }

    private static b aby() {
        return cdI;
    }

    /* loaded from: classes11.dex */
    public static class a implements b {
        private static final String[] cdJ = {"Gz7Grjwr0GhpGSDIhtUk6RB1EiBCRmHK"};

        @Override // com.baidu.swan.apps.core.prefetch.c.b
        public boolean jO(@NonNull String str) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            for (String str2 : cdJ) {
                if (str.startsWith(str2)) {
                    return false;
                }
            }
            return true;
        }
    }
}
