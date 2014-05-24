package com.baidu.tbadk.core.diskCache;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
class c extends DiskFileOperate implements com.baidu.adp.lib.Disk.a {
    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
    }

    @Override // com.baidu.adp.lib.Disk.a
    public boolean a(File file) {
        return file != null && file.lastModified() + 259200000 < System.currentTimeMillis();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void c(boolean z) {
        BdLog.d("success = " + z);
        super.c(z);
        ImagesInvalidService.stopService();
        ImagesInvalidReceiver.broadcast(z);
    }
}
