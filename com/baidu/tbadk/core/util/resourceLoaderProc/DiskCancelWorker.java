package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import d.b.c.e.a.d;
import d.b.c.e.l.b;
/* loaded from: classes3.dex */
public class DiskCancelWorker implements b.a {
    public DiskFileOperate operate = null;

    @Override // d.b.c.e.l.b.a
    public void cancel() {
        if (this.operate != null) {
            d.g().e(this.operate);
        }
    }

    public DiskFileOperate getOperate() {
        return this.operate;
    }

    public void setOperate(DiskFileOperate diskFileOperate) {
        this.operate = diskFileOperate;
    }
}
