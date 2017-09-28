package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif rr;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.rr = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean h(byte[] bArr) {
        if (bArr == null || !NSGif.qJ) {
            return false;
        }
        this.rr = NSGif.h(bArr, 0, bArr.length);
        return this.rr != null;
    }

    public NSGif eb() {
        return this.rr;
    }
}
