package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif kE;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.kE = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr == null || !NSGif.jS) {
            return false;
        }
        this.kE = NSGif.f(bArr, 0, bArr.length);
        return this.kE != null;
    }

    public NSGif cW() {
        return this.kE;
    }
}
