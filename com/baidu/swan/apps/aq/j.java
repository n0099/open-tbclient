package com.baidu.swan.apps.aq;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.aq.ad;
import java.io.File;
import java.util.List;
/* loaded from: classes11.dex */
public class j {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Nullable
    public static File aux() {
        List<ad.a> storageList = ad.getStorageList();
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
