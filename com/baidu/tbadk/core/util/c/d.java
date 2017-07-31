package com.baidu.tbadk.core.util.c;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.f.a;
/* loaded from: classes.dex */
public class d implements a.InterfaceC0006a {
    private DiskFileOperate ajM = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.ajM = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0006a
    public void cancel() {
        if (this.ajM != null) {
            com.baidu.adp.lib.Disk.d.dS().d(this.ajM);
        }
    }
}
