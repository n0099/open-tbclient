package com.baidu.adp.lib.stats.upload;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    public static BdUploadingLogInfo a(com.baidu.adp.lib.stats.base.a aVar) {
        ArrayList arrayList;
        long j;
        ArrayList<com.baidu.adp.lib.stats.base.c> b = b(aVar);
        BdUploadingLogInfo bdUploadingLogInfo = new BdUploadingLogInfo(com.baidu.adp.lib.h.a.iB().iC(), aVar.ij(), aVar.ik());
        if (b != null && b.size() > 0) {
            if (b.size() > 1) {
                Collections.sort(b, new com.baidu.adp.lib.stats.base.d());
            }
            ArrayList arrayList2 = new ArrayList();
            int size = b.size();
            int i = 0;
            long j2 = 0;
            while (i < size) {
                com.baidu.adp.lib.stats.base.c cVar = b.get(i);
                long j3 = j2 + cVar.wX;
                arrayList2.add(cVar);
                if (j3 >= 102400) {
                    bdUploadingLogInfo.add(arrayList2);
                    arrayList = new ArrayList();
                    j = 0;
                } else {
                    arrayList = arrayList2;
                    j = j3;
                }
                i++;
                j2 = j;
                arrayList2 = arrayList;
            }
            if (arrayList2.size() > 0) {
                bdUploadingLogInfo.add(arrayList2);
            }
        }
        return bdUploadingLogInfo;
    }

    private static ArrayList<com.baidu.adp.lib.stats.base.c> b(com.baidu.adp.lib.stats.base.a aVar) {
        ArrayList<com.baidu.adp.lib.stats.base.c> arrayList;
        ArrayList<com.baidu.adp.lib.stats.base.c> arrayList2 = new ArrayList<>();
        File[] E = com.baidu.adp.lib.stats.base.b.E(aVar.ij());
        if (E != null) {
            for (File file : E) {
                if (file.isFile()) {
                    String name = file.getName();
                    if (!TextUtils.isEmpty(name) && name.startsWith(aVar.il()) && name.contains("Uploading")) {
                        arrayList2.add(new com.baidu.adp.lib.stats.base.c(name, file.length(), file.lastModified()));
                    }
                }
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<com.baidu.adp.lib.stats.base.c> arrayList3 = new ArrayList<>();
        ArrayList arrayList4 = new ArrayList();
        if (aVar.il() != "stat") {
            Iterator<com.baidu.adp.lib.stats.base.c> it = arrayList2.iterator();
            while (it.hasNext()) {
                com.baidu.adp.lib.stats.base.c next = it.next();
                if (next != null) {
                    long j = next.wY;
                    if (j != 0 && j + 2592000000L < currentTimeMillis) {
                        arrayList4.add(next.mFileName);
                    } else {
                        arrayList3.add(next);
                    }
                }
            }
            arrayList = arrayList3;
        } else {
            arrayList = arrayList2;
        }
        if (arrayList4.size() > 0) {
            com.baidu.adp.lib.stats.base.b.a(arrayList4, aVar.ij());
        }
        return arrayList;
    }
}
