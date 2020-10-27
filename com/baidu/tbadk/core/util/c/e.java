package com.baidu.tbadk.core.util.c;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.e.a;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0021a {
    private DiskFileOperate eJD = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.eJD = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0021a
    public void cancel() {
        if (this.eJD != null) {
            com.baidu.adp.lib.Disk.d.lL().d(this.eJD);
        }
    }
}
