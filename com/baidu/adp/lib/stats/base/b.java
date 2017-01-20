package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.e;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    public static File[] c(boolean z, boolean z2) {
        File[] listFiles;
        DiskFileOperate diskFileOperate = new DiskFileOperate(com.baidu.adp.lib.stats.a.eG().eK(), null, DiskFileOperate.Action.INFO);
        diskFileOperate.t(z);
        diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.cz().b(diskFileOperate);
        File[] listFiles2 = (diskFileOperate.cO() == null || diskFileOperate.cO().listFiles() == null) ? null : diskFileOperate.cO().listFiles();
        if (z2) {
            DiskFileOperate diskFileOperate2 = new DiskFileOperate(com.baidu.adp.lib.stats.a.eG().eL(), null, DiskFileOperate.Action.INFO);
            diskFileOperate2.t(z);
            diskFileOperate2.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.cz().b(diskFileOperate2);
            if (diskFileOperate2.cO() != null && (listFiles = diskFileOperate2.cO().listFiles()) != null && listFiles.length != 0) {
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

    public static ArrayList<c> H(boolean z) {
        ArrayList<c> arrayList = new ArrayList<>();
        File[] c = c(z, true);
        if (c != null) {
            for (File file : c) {
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
        e eVar = new e(com.baidu.adp.lib.stats.a.eG().eK(), null, DiskFileOperate.Action.DELETE_FILES, arrayList);
        eVar.t(z);
        eVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.cz().c(eVar);
    }
}
