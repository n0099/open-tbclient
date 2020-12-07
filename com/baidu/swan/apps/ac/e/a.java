package com.baidu.swan.apps.ac.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.swancore.b;
import com.baidu.swan.pms.model.h;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes25.dex */
public class a {
    public static void U(String str, int i) {
        File pu;
        String[] list;
        if (!TextUtils.isEmpty(str) && i >= 0 && (pu = d.pu(str)) != null && (list = pu.list()) != null && list.length > i) {
            List asList = Arrays.asList(list);
            try {
                Collections.sort(asList, new Comparator<String>() { // from class: com.baidu.swan.apps.ac.e.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    public int compare(String str2, String str3) {
                        long parseLong = Long.parseLong(str2);
                        long parseLong2 = Long.parseLong(str3);
                        if (parseLong > parseLong2) {
                            return -1;
                        }
                        if (parseLong < parseLong2) {
                            return 1;
                        }
                        return 0;
                    }
                });
            } catch (NumberFormatException e) {
                com.baidu.swan.apps.ac.d.a.print(Log.getStackTraceString(e));
            }
            int size = asList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 >= i) {
                    String str2 = (String) asList.get(i2);
                    com.baidu.swan.c.d.deleteFile(d.bQ(str, str2));
                    s(str, Long.parseLong(str2));
                    com.baidu.swan.apps.ac.d.a.print("delete plugin name = " + str + " ; version = " + str2);
                }
            }
        }
    }

    private static void s(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            h hVar = new h();
            hVar.emZ = str;
            hVar.versionName = b.cR(j);
            com.baidu.swan.pms.database.a.bdF().f(hVar);
        }
    }
}
