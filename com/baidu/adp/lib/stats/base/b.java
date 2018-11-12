package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.e;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    public static File[] e(boolean z, boolean z2) {
        File[] listFiles;
        DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getWriteDir(), null, DiskFileOperate.Action.INFO);
        diskFileOperate.T(z);
        diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.hB().b(diskFileOperate);
        File[] listFiles2 = (diskFileOperate.hO() == null || diskFileOperate.hO().listFiles() == null) ? null : diskFileOperate.hO().listFiles();
        if (z2) {
            DiskFileOperate diskFileOperate2 = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), null, DiskFileOperate.Action.INFO);
            diskFileOperate2.T(z);
            diskFileOperate2.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.hB().b(diskFileOperate2);
            if (diskFileOperate2.hO() != null && (listFiles = diskFileOperate2.hO().listFiles()) != null && listFiles.length != 0) {
                if (listFiles2 == null || listFiles2.length == 0) {
                    return listFiles;
                }
                File[] fileArr = new File[listFiles.length + listFiles2.length];
                System.arraycopy(listFiles2, 0, fileArr, 0, listFiles2.length);
                System.arraycopy(listFiles, 0, fileArr, listFiles2.length, listFiles.length);
                return fileArr;
            }
        }
        return listFiles2;
    }

    public static ArrayList<c> al(boolean z) {
        ArrayList<c> arrayList = new ArrayList<>();
        File[] e = e(z, true);
        if (e != null) {
            for (File file : e) {
                if (file.isFile()) {
                    String name = file.getName();
                    if (!TextUtils.isEmpty(name)) {
                        arrayList.add(new c(name, file.length(), file.lastModified()));
                    }
                }
            }
        }
        return arrayList;
    }

    public static void a(ArrayList<String> arrayList, boolean z) {
        e eVar = new e(BdStatisticsManager.getInstance().getWriteDir(), null, DiskFileOperate.Action.DELETE_FILES, arrayList);
        eVar.T(z);
        eVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.hB().c(eVar);
    }
}
