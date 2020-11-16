package com.baidu.smallgame.sdk.c;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes6.dex */
public final class a {
    public static boolean kb(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return p(new File(str));
    }

    public static boolean p(File file) {
        return file != null && file.exists() && file.isFile();
    }
}
