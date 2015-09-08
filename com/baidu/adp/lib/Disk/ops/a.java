package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif rB;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.rB = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean x(byte[] bArr) {
        if (bArr == null || !NSGif.qS) {
            return false;
        }
        this.rB = NSGif.f(bArr, 0, bArr.length);
        return this.rB != null;
    }

    public NSGif fE() {
        return this.rB;
    }
}
