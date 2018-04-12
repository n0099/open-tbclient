package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif qj;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.qj = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean j(byte[] bArr) {
        if (bArr == null || !NSGif.pD) {
            return false;
        }
        this.qj = NSGif.h(bArr, 0, bArr.length);
        return this.qj != null;
    }

    public NSGif dK() {
        return this.qj;
    }
}
