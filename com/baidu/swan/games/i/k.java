package com.baidu.swan.games.i;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class k {
    public static void aNx() {
        if (com.baidu.swan.apps.storage.c.h.aDf().getBoolean("swan_game_data_migration", true)) {
            com.baidu.swan.apps.storage.c.h.aDf().putBoolean("swan_game_data_migration", false);
            if (com.baidu.swan.apps.s.a.DEBUG) {
                Log.d("DataMigrationUtils", "before migrate " + System.currentTimeMillis());
            }
            aNy();
            if (com.baidu.swan.apps.s.a.DEBUG) {
                Log.d("DataMigrationUtils", "in migrate " + System.currentTimeMillis());
            }
            aNz();
            if (com.baidu.swan.apps.s.a.DEBUG) {
                Log.d("DataMigrationUtils", "end migrate " + System.currentTimeMillis());
            }
        }
    }

    private static void aNy() {
        File[] listFiles;
        String dw = n.dw(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(dw)) {
            File file = new File(dw);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        String str = file2.getAbsolutePath() + File.separator + "aigames/sandbox";
                        File file3 = new File(str);
                        if (file3.exists() && file3.isDirectory()) {
                            String str2 = dw + File.separator + "swangame/anonymous/sandbox";
                            if (!file3.renameTo(new File(str2))) {
                                n.cO(str, str2);
                                n.vm(str);
                            }
                        }
                    }
                }
            }
        }
    }

    private static void aNz() {
        String absolutePath;
        File[] listFiles = com.baidu.swan.games.w.b.aPv().listFiles();
        if (listFiles != null) {
            ArrayList arrayList = new ArrayList();
            for (File file : listFiles) {
                String name = file.getName();
                if (name.startsWith("aigame_storage_") && !name.endsWith("_anonymous.xml")) {
                    arrayList.add(file);
                }
            }
            Collections.sort(arrayList, new Comparator<File>() { // from class: com.baidu.swan.games.i.k.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: c */
                public int compare(File file2, File file3) {
                    return Long.compare(file2.lastModified(), file3.lastModified());
                }
            });
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                File file2 = (File) it.next();
                String str = absolutePath.substring(0, absolutePath.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) + "_anonymous.xml";
                if (!file2.getAbsolutePath().equals(str)) {
                    File file3 = new File(str);
                    if (file3.exists()) {
                        com.baidu.swan.c.d.safeDeleteFile(file3);
                    }
                    if (!file2.renameTo(file3)) {
                        com.baidu.swan.c.d.copyFile(file2, file3);
                        com.baidu.swan.c.d.safeDeleteFile(file2);
                    }
                }
            }
        }
    }
}
