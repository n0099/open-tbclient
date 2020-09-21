package com.baidu.adp.lib.stats.upload;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.base.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    public static BdUploadingLogInfo d(com.baidu.adp.lib.stats.base.a aVar) {
        ArrayList arrayList;
        ArrayList<com.baidu.adp.lib.stats.base.d> e = e(aVar);
        BdUploadingLogInfo bdUploadingLogInfo = new BdUploadingLogInfo(BdStatisticsManager.getInstance().getTrackLogWriteDir(), aVar.nN(), aVar.nO());
        if (e != null && e.size() > 0) {
            if (e.size() > 1) {
                Collections.sort(e, new e());
            }
            ArrayList arrayList2 = new ArrayList();
            int size = e.size();
            int i = 0;
            long j = 0;
            while (i < size) {
                com.baidu.adp.lib.stats.base.d dVar = e.get(i);
                j += dVar.Og;
                arrayList2.add(dVar);
                if (j >= 20480) {
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

    private static ArrayList<com.baidu.adp.lib.stats.base.d> e(com.baidu.adp.lib.stats.base.a aVar) {
        ArrayList arrayList = new ArrayList();
        File[] au = com.baidu.adp.lib.stats.base.c.au(aVar.nN());
        if (au != null) {
            for (File file : au) {
                if (file.isFile()) {
                    String name = file.getName();
                    if (!TextUtils.isEmpty(name) && name.startsWith(aVar.nP()) && name.contains("Uploading")) {
                        arrayList.add(new com.baidu.adp.lib.stats.base.d(name, file.length(), file.lastModified()));
                    }
                }
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<com.baidu.adp.lib.stats.base.d> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.stats.base.d dVar = (com.baidu.adp.lib.stats.base.d) it.next();
            if (dVar != null) {
                long j = dVar.Oh;
                if (j != 0 && j + 604800000 < currentTimeMillis) {
                    arrayList3.add(dVar.mFileName);
                } else {
                    arrayList2.add(dVar);
                }
            }
        }
        if (arrayList3.size() > 0) {
            com.baidu.adp.lib.stats.base.c.a(arrayList3, aVar.nN());
        }
        return arrayList2;
    }
}
