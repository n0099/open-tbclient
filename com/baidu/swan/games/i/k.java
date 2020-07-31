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
/* loaded from: classes7.dex */
public class k {
    public static void aEJ() {
        if (com.baidu.swan.apps.storage.c.h.auW().getBoolean("swan_game_data_migration", true)) {
            com.baidu.swan.apps.storage.c.h.auW().putBoolean("swan_game_data_migration", false);
            if (com.baidu.swan.apps.s.a.DEBUG) {
                Log.d("DataMigrationUtils", "before migrate " + System.currentTimeMillis());
            }
            aEK();
            if (com.baidu.swan.apps.s.a.DEBUG) {
                Log.d("DataMigrationUtils", "in migrate " + System.currentTimeMillis());
            }
            aEL();
            if (com.baidu.swan.apps.s.a.DEBUG) {
                Log.d("DataMigrationUtils", "end migrate " + System.currentTimeMillis());
            }
        }
    }

    private static void aEK() {
        File[] listFiles;
        String dq = n.dq(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(dq)) {
            File file = new File(dq);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        String str = file2.getAbsolutePath() + File.separator + "aigames/sandbox";
                        File file3 = new File(str);
                        if (file3.exists() && file3.isDirectory()) {
                            String str2 = dq + File.separator + "swangame/anonymous/sandbox";
                            if (!file3.renameTo(new File(str2))) {
                                n.cu(str, str2);
                                n.sV(str);
                            }
                        }
                    }
                }
            }
        }
    }

    private static void aEL() {
        String absolutePath;
        File[] listFiles = com.baidu.swan.games.w.b.aGE().listFiles();
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
                        com.baidu.swan.d.d.safeDeleteFile(file3);
                    }
                    if (!file2.renameTo(file3)) {
                        com.baidu.swan.d.d.copyFile(file2, file3);
                        com.baidu.swan.d.d.safeDeleteFile(file2);
                    }
                }
            }
        }
    }
}
