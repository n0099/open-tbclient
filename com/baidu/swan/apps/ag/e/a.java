package com.baidu.swan.apps.ag.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.swancore.b;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.d.c;
import com.baidu.swan.pms.model.h;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static void E(String str, int i) {
        File hM;
        String[] list;
        if (!TextUtils.isEmpty(str) && i >= 0 && (hM = e.hM(str)) != null && (list = hM.list()) != null && list.length > i) {
            List asList = Arrays.asList(list);
            try {
                Collections.sort(asList, new Comparator<String>() { // from class: com.baidu.swan.apps.ag.e.a.1
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
                com.baidu.swan.apps.ag.d.a.print(Log.getStackTraceString(e));
            }
            int size = asList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 >= i) {
                    String str2 = (String) asList.get(i2);
                    c.deleteFile(e.ax(str, str2));
                    m(str, Long.parseLong(str2));
                    com.baidu.swan.apps.ag.d.a.print("delete plugin name = " + str + " ; version = " + str2);
                }
            }
        }
    }

    private static void m(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            h hVar = new h();
            hVar.cwO = str;
            hVar.versionName = b.ay(j);
            com.baidu.swan.pms.database.a.aqM().f(hVar);
        }
    }
}
