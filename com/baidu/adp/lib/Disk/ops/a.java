package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif gd;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.gd = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean j(byte[] bArr) {
        if (bArr == null || !NSGif.fz) {
            return false;
        }
        this.gd = NSGif.e(bArr, 0, bArr.length);
        return this.gd != null;
    }

    public NSGif cj() {
        return this.gd;
    }
}
