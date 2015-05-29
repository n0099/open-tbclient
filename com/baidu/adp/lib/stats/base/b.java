package com.baidu.adp.lib.stats.base;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.f;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    public static File[] E(boolean z) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(com.baidu.adp.lib.h.a.iB().iC(), null, DiskFileOperate.Action.INFO);
        diskFileOperate.q(z);
        diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.fp().b(diskFileOperate);
        if (diskFileOperate.fF() != null) {
            return diskFileOperate.fF().listFiles();
        }
        return null;
    }

    public static ArrayList<c> F(boolean z) {
        ArrayList<c> arrayList = new ArrayList<>();
        File[] E = E(z);
        if (E != null) {
            for (File file : E) {
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
        f fVar = new f(com.baidu.adp.lib.h.a.iB().iC(), null, DiskFileOperate.Action.DELETE_FILES, arrayList);
        fVar.q(z);
        fVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        com.baidu.adp.lib.Disk.d.fp().c(fVar);
    }
}
