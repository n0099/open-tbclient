package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.lib.f.b {
    private DiskFileOperate GF = null;

    public void g(DiskFileOperate diskFileOperate) {
        this.GF = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.b
    public void cancel() {
        if (this.GF != null) {
            com.baidu.adp.lib.Disk.d.bn().d(this.GF);
        }
    }
}
