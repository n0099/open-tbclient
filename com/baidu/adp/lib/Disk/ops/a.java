package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif xe;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.xe = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean i(byte[] bArr) {
        if (bArr == null || !NSGif.ww) {
            return false;
        }
        this.xe = NSGif.h(bArr, 0, bArr.length);
        return this.xe != null;
    }

    public NSGif gO() {
        return this.xe;
    }
}
