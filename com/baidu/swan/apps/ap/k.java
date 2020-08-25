package com.baidu.swan.apps.ap;

import android.support.annotation.Nullable;
import com.baidu.swan.apps.ap.af;
import java.io.File;
import java.util.List;
/* loaded from: classes8.dex */
public class k {
    @Nullable
    public static File aEJ() {
        List<af.a> storageList = com.baidu.swan.apps.u.a.a.getStorageList();
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
