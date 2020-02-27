package com.baidu.swan.apps.env;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes11.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Nullable
    public static Set<String> R(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return e(106, list);
    }

    @Nullable
    public static Set<String> e(int i, List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (com.baidu.swan.apps.process.messaging.service.c cVar : com.baidu.swan.apps.process.messaging.service.e.abs().abu()) {
            String appId = cVar.getAppId();
            if (cVar.abj() && cVar.abh() && list.contains(appId)) {
                com.baidu.swan.apps.process.messaging.a.aaJ().a(new com.baidu.swan.apps.process.messaging.c(i).a(cVar.bJy));
                hashSet.add(appId);
                if (DEBUG) {
                    Log.i("PurgerUtils", "sent msg(" + i + ") to active swan(" + appId + ")");
                }
            }
        }
        return hashSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(@NonNull String str, Set<String> set, boolean z) {
        File[] listFiles;
        File file = new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/");
        if ((file.exists() || file.isDirectory()) && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
            Set<String> set2 = set;
            for (File file2 : listFiles) {
                String name = file2.getName();
                if (!name.isEmpty() && file2.isFile() && name.startsWith(str) && name.endsWith(".xml")) {
                    int length = name.length();
                    int length2 = str.length();
                    int length3 = ".xml".length();
                    if (length >= length2 + length3) {
                        String substring = name.substring(length2, length - length3);
                        if (set2 == null) {
                            set2 = Collections.emptySet();
                        }
                        if (!TextUtils.isEmpty(substring)) {
                            if (z) {
                                if (set2.contains(substring)) {
                                }
                                if (DEBUG) {
                                    Log.i("PurgerUtils", "clearByDeleteFiles : " + substring);
                                }
                                file2.delete();
                            } else {
                                if (!set2.contains(substring)) {
                                }
                                if (DEBUG) {
                                }
                                file2.delete();
                            }
                        }
                    }
                }
            }
        }
    }
}
