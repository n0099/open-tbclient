package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif dY;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.dY = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean i(byte[] bArr) {
        if (bArr == null || !NSGif.ds) {
            return false;
        }
        this.dY = NSGif.c(bArr, 0, bArr.length);
        return this.dY != null;
    }

    public NSGif bK() {
        return this.dY;
    }
}
