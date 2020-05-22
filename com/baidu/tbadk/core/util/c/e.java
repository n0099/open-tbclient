package com.baidu.tbadk.core.util.c;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.e.a;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0021a {
    private DiskFileOperate dPC = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.dPC = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0021a
    public void cancel() {
        if (this.dPC != null) {
            com.baidu.adp.lib.Disk.d.jR().d(this.dPC);
        }
    }
}
