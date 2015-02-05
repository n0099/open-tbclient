package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.lib.f.b {
    private DiskFileOperate Lg = null;

    public void g(DiskFileOperate diskFileOperate) {
        this.Lg = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.b
    public void cancel() {
        if (this.Lg != null) {
            com.baidu.adp.lib.Disk.d.bM().d(this.Lg);
        }
    }
}
