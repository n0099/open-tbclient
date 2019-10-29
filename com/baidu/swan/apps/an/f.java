package com.baidu.swan.apps.an;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.an.x;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Nullable
    public static File Uf() {
        List<x.a> Ut = x.Ut();
        if (Ut == null || Ut.size() <= 0) {
            return null;
        }
        File file = new File(Ut.get(0).mPath, "baidu/aiapps/debug/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
