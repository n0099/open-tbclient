package com.baidu.swan.apps.core.prefetch;

import android.support.annotation.NonNull;
import android.text.TextUtils;
/* loaded from: classes11.dex */
public final class c {
    private static final b bYS = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface b {
        boolean jG(@NonNull String str);
    }

    public static boolean jG(String str) {
        return aas().jG(str);
    }

    private static b aas() {
        return bYS;
    }

    /* loaded from: classes11.dex */
    public static class a implements b {
        private static final String[] bYT = {"Gz7Grjwr0GhpGSDIhtUk6RB1EiBCRmHK"};

        @Override // com.baidu.swan.apps.core.prefetch.c.b
        public boolean jG(@NonNull String str) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            for (String str2 : bYT) {
                if (str.startsWith(str2)) {
                    return false;
                }
            }
            return true;
        }
    }
}
