package com.baidu.smallgame.sdk.c;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes20.dex */
public final class a {
    public static boolean iu(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return s(new File(str));
    }

    public static boolean s(File file) {
        return file != null && file.exists() && file.isFile();
    }
}
