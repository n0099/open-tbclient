package com.baidu.tbadk.core.util.d;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.e.b;
/* loaded from: classes.dex */
public class d implements b.a {
    private DiskFileOperate fcQ = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.fcQ = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.e.b.a
    public void cancel() {
        if (this.fcQ != null) {
            com.baidu.adp.lib.Disk.d.lg().d(this.fcQ);
        }
    }
}
