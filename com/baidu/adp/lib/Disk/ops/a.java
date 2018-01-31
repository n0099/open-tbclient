package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif afV;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.afV = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean h(byte[] bArr) {
        if (bArr == null || !NSGif.afm) {
            return false;
        }
        this.afV = NSGif.h(bArr, 0, bArr.length);
        return this.afV != null;
    }

    public NSGif lG() {
        return this.afV;
    }
}
