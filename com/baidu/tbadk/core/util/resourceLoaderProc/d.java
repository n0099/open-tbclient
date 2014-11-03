package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.lib.f.b {
    private DiskFileOperate GG = null;

    public void g(DiskFileOperate diskFileOperate) {
        this.GG = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.b
    public void cancel() {
        if (this.GG != null) {
            com.baidu.adp.lib.Disk.d.bn().d(this.GG);
        }
    }
}
