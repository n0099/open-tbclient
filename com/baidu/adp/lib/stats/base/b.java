package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.e;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    public static File[] f(boolean z, boolean z2) {
        File[] listFiles;
        DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getWriteDir(), null, DiskFileOperate.Action.INFO);
        diskFileOperate.ab(z);
        diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.ll().b(diskFileOperate);
        File[] listFiles2 = (diskFileOperate.lz() == null || diskFileOperate.lz().listFiles() == null) ? null : diskFileOperate.lz().listFiles();
        if (z2) {
            DiskFileOperate diskFileOperate2 = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), null, DiskFileOperate.Action.INFO);
            diskFileOperate2.ab(z);
            diskFileOperate2.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.ll().b(diskFileOperate2);
            if (diskFileOperate2.lz() != null && (listFiles = diskFileOperate2.lz().listFiles()) != null && listFiles.length != 0) {
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

    public static ArrayList<c> aq(boolean z) {
        ArrayList<c> arrayList = new ArrayList<>();
        File[] f = f(z, true);
        if (f != null) {
            for (File file : f) {
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
        eVar.ab(z);
        eVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.ll().c(eVar);
    }
}
