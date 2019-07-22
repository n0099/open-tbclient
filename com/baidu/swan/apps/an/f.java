package com.baidu.swan.apps.an;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.an.x;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Nullable
    public static File Pl() {
        List<x.a> Pz = x.Pz();
        if (Pz == null || Pz.size() <= 0) {
            return null;
        }
        File file = new File(Pz.get(0).wX, "baidu/aiapps/debug/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
