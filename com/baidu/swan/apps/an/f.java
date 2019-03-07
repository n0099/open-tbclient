package com.baidu.swan.apps.an;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.an.v;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;

    @Nullable
    public static File LR() {
        List<v.a> Me = v.Me();
        if (Me == null || Me.size() <= 0) {
            return null;
        }
        File file = new File(Me.get(0).mPath, "baidu/aiapps/debug/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
