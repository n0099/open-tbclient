package com.baidu.smallgame.sdk.c;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes11.dex */
public final class a {
    public static boolean existsFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return existsFile(new File(str));
    }

    public static boolean existsFile(File file) {
        return file != null && file.exists() && file.isFile();
    }
}
