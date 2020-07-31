package com.baidu.smallgame.sdk.c;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes10.dex */
public final class a {
    public static boolean gZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return r(new File(str));
    }

    public static boolean r(File file) {
        return file != null && file.exists() && file.isFile();
    }
}
