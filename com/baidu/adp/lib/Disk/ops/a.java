package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif zt;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.zt = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean q(byte[] bArr) {
        if (bArr == null || !NSGif.yM) {
            return false;
        }
        this.zt = NSGif.h(bArr, 0, bArr.length);
        return this.zt != null;
    }

    public NSGif hU() {
        return this.zt;
    }
}
