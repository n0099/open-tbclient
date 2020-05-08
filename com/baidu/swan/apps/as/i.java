package com.baidu.swan.apps.as;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.as.ac;
import java.io.File;
import java.util.List;
/* loaded from: classes11.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Nullable
    public static File aoQ() {
        List<ac.a> storageList = ac.getStorageList();
        if (storageList == null || storageList.size() <= 0) {
            return null;
        }
        File file = new File(storageList.get(0).mPath, "/debug/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
