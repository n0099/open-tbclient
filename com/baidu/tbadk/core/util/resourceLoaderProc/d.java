package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.lib.f.b {
    private DiskFileOperate WK = null;

    public void g(DiskFileOperate diskFileOperate) {
        this.WK = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.b
    public void cancel() {
        if (this.WK != null) {
            com.baidu.adp.lib.Disk.d.fk().d(this.WK);
        }
    }
}
