package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.lib.f.b {
    private DiskFileOperate Xv = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.Xv = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.b
    public void cancel() {
        if (this.Xv != null) {
            com.baidu.adp.lib.Disk.d.fp().d(this.Xv);
        }
    }
}
