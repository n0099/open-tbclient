package com.baidu.tbadk.core.util.c;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.e.a;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0020a {
    private DiskFileOperate eoV = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.eoV = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0020a
    public void cancel() {
        if (this.eoV != null) {
            com.baidu.adp.lib.Disk.d.lK().d(this.eoV);
        }
    }
}
