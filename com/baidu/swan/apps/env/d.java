package com.baidu.swan.apps.env;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Nullable
    public static Set<String> af(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return j(106, list);
    }

    @Nullable
    public static Set<String> j(int i, List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (com.baidu.swan.apps.process.messaging.service.c cVar : com.baidu.swan.apps.process.messaging.service.e.ayg().ayi()) {
            String appId = cVar.getAppId();
            if (cVar.axT() && cVar.axR() && list.contains(appId)) {
                com.baidu.swan.apps.process.messaging.a.axs().a(new com.baidu.swan.apps.process.messaging.c(i).a(cVar.cJz));
                hashSet.add(appId);
                if (DEBUG) {
                    Log.i("PurgerUtils", "sent msg(" + i + ") to active swan(" + appId + ")");
                }
            }
        }
        return hashSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(@NonNull File file, @NonNull String str, @NonNull String str2, Set<String> set, boolean z, @Nullable com.baidu.swan.config.e.a<Pair<String, File>> aVar) {
        File[] listFiles;
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
            Set<String> set2 = set;
            for (File file2 : listFiles) {
                String name = file2.getName();
                if (!name.isEmpty() && file2.isFile() && name.startsWith(str) && name.endsWith(str2)) {
                    int length = name.length();
                    int length2 = str.length();
                    int length3 = str2.length();
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
                                if (aVar == null) {
                                    aVar.run(Pair.create(str + substring, file2));
                                } else {
                                    file2.delete();
                                }
                            } else {
                                if (!set2.contains(substring)) {
                                }
                                if (DEBUG) {
                                }
                                if (aVar == null) {
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void a(@NonNull File file, @NonNull String str, @NonNull String str2, Set<String> set, boolean z) {
        a(file, str, str2, set, z, null);
    }
}
