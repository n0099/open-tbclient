package com.baidu.adp.lib.stats.upload;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.base.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {
    public static BdUploadingLogInfo a(com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        ArrayList arrayList;
        ArrayList<com.baidu.adp.lib.stats.base.c> b = b(aVar, z);
        BdUploadingLogInfo bdUploadingLogInfo = new BdUploadingLogInfo(BdStatisticsManager.getInstance().getWriteDir(), aVar.gC(), aVar.gD());
        if (b != null && b.size() > 0) {
            if (b.size() > 1) {
                Collections.sort(b, new d());
            }
            ArrayList arrayList2 = new ArrayList();
            int size = b.size();
            int i = 0;
            long j = 0;
            while (i < size) {
                com.baidu.adp.lib.stats.base.c cVar = b.get(i);
                j += cVar.qu;
                arrayList2.add(cVar);
                if (j >= 102400) {
                    bdUploadingLogInfo.add(arrayList2);
                    arrayList = new ArrayList();
                    j = 0;
                } else {
                    arrayList = arrayList2;
                }
                i++;
                arrayList2 = arrayList;
            }
            if (arrayList2.size() > 0) {
                bdUploadingLogInfo.add(arrayList2);
            }
        }
        return bdUploadingLogInfo;
    }

    private static ArrayList<com.baidu.adp.lib.stats.base.c> b(com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        ArrayList<com.baidu.adp.lib.stats.base.c> arrayList;
        ArrayList<com.baidu.adp.lib.stats.base.c> arrayList2 = new ArrayList<>();
        File[] c = com.baidu.adp.lib.stats.base.b.c(aVar.gC(), z);
        if (c != null) {
            for (File file : c) {
                if (file.isFile()) {
                    String name = file.getName();
                    if (!TextUtils.isEmpty(name) && name.startsWith(aVar.gE()) && name.contains("Uploading")) {
                        long length = file.length();
                        if (z && file.getPath().contains("/notUpload")) {
                            name = "notUpload/" + file.getName();
                        }
                        arrayList2.add(new com.baidu.adp.lib.stats.base.c(name, length, file.lastModified()));
                    }
                }
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<com.baidu.adp.lib.stats.base.c> arrayList3 = new ArrayList<>();
        ArrayList arrayList4 = new ArrayList();
        if (aVar.gE() != "stat") {
            Iterator<com.baidu.adp.lib.stats.base.c> it = arrayList2.iterator();
            while (it.hasNext()) {
                com.baidu.adp.lib.stats.base.c next = it.next();
                if (next != null) {
                    long j = next.qv;
                    if (j != 0 && j + 604800000 < currentTimeMillis) {
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
            com.baidu.adp.lib.stats.base.b.a(arrayList4, aVar.gC());
        }
        return arrayList;
    }
}
