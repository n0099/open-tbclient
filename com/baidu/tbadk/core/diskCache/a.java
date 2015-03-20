package com.baidu.tbadk.core.diskCache;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import java.io.File;
/* loaded from: classes.dex */
class a extends DiskFileOperate implements com.baidu.adp.lib.Disk.a {
    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
    }

    @Override // com.baidu.adp.lib.Disk.a
    public boolean c(File file) {
        return file != null && file.lastModified() + 259200000 < System.currentTimeMillis();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void l(boolean z) {
        super.l(z);
        ImagesInvalidServiceStatic.stopService();
        ImagesInvalidReceiver.broadcast(z);
    }
}
