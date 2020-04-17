package com.baidu.smallgame.sdk.c;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes11.dex */
public final class a {
    public static boolean gh(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return n(new File(str));
    }

    public static boolean n(File file) {
        return file != null && file.exists() && file.isFile();
    }
}
