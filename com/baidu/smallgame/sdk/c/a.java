package com.baidu.smallgame.sdk.c;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes5.dex */
public final class a {
    public static boolean jz(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return p(new File(str));
    }

    public static boolean p(File file) {
        return file != null && file.exists() && file.isFile();
    }
}
