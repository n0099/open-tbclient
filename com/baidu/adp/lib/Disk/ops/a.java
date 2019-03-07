package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif zu;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.zu = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean q(byte[] bArr) {
        if (bArr == null || !NSGif.yN) {
            return false;
        }
        this.zu = NSGif.h(bArr, 0, bArr.length);
        return this.zu != null;
    }

    public NSGif hU() {
        return this.zu;
    }
}
