package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.resourceLoader.b {
    private DiskFileOperate a = null;

    public void a(DiskFileOperate diskFileOperate) {
        this.a = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.resourceLoader.b
    public void a() {
        if (this.a != null) {
            com.baidu.adp.lib.Disk.d.a().c(this.a);
        }
    }
}
