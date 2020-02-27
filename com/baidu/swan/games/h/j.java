package com.baidu.swan.games.h;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class j {
    public static void anP() {
        if (com.baidu.swan.apps.storage.c.h.afp().getBoolean("swan_game_data_migration", true)) {
            com.baidu.swan.apps.storage.c.h.afp().putBoolean("swan_game_data_migration", false);
            if (com.baidu.swan.apps.v.a.DEBUG) {
                Log.d("DataMigrationUtils", "before migrate " + System.currentTimeMillis());
            }
            anQ();
            if (com.baidu.swan.apps.v.a.DEBUG) {
                Log.d("DataMigrationUtils", "in migrate " + System.currentTimeMillis());
            }
            anR();
            if (com.baidu.swan.apps.v.a.DEBUG) {
                Log.d("DataMigrationUtils", "end migrate " + System.currentTimeMillis());
            }
        }
    }

    private static void anQ() {
        File[] listFiles;
        String dv = l.dv(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(dv)) {
            File file = new File(dv);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        String str = file2.getAbsolutePath() + File.separator + "aigames/sandbox";
                        File file3 = new File(str);
                        if (file3.exists() && file3.isDirectory()) {
                            String str2 = dv + File.separator + "swangame/anonymous/sandbox";
                            if (!file3.renameTo(new File(str2))) {
                                l.bK(str, str2);
                                l.oZ(str);
                            }
                        }
                    }
                }
            }
        }
    }

    private static void anR() {
        String absolutePath;
        File[] listFiles = com.baidu.swan.games.v.b.apJ().listFiles();
        if (listFiles != null) {
            ArrayList arrayList = new ArrayList();
            for (File file : listFiles) {
                String name = file.getName();
                if (name.startsWith("aigame_storage_") && !name.endsWith("_anonymous.xml")) {
                    arrayList.add(file);
                }
            }
            Collections.sort(arrayList, new Comparator<File>() { // from class: com.baidu.swan.games.h.j.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
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
                        com.baidu.swan.d.c.safeDeleteFile(file3);
                    }
                    if (!file2.renameTo(file3)) {
                        com.baidu.swan.d.c.copyFile(file2, file3);
                        com.baidu.swan.d.c.safeDeleteFile(file2);
                    }
                }
            }
        }
    }
}
