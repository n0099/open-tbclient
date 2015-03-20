package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.lib.f.b {
    private DiskFileOperate WI = null;

    public void g(DiskFileOperate diskFileOperate) {
        this.WI = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.b
    public void cancel() {
        if (this.WI != null) {
            com.baidu.adp.lib.Disk.d.fk().d(this.WI);
        }
    }
}
