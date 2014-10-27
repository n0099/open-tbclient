package com.baidu.tbadk.core.diskCache;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import java.io.File;
/* loaded from: classes.dex */
class c extends DiskFileOperate implements com.baidu.adp.lib.Disk.a {
    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
    }

    @Override // com.baidu.adp.lib.Disk.a
    public boolean b(File file) {
        return file != null && file.lastModified() + 259200000 < System.currentTimeMillis();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void h(boolean z) {
        super.h(z);
        ImagesInvalidService.stopService();
        ImagesInvalidReceiver.broadcast(z);
    }
}
