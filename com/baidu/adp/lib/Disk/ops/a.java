package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif kF;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.kF = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr == null || !NSGif.jT) {
            return false;
        }
        this.kF = NSGif.f(bArr, 0, bArr.length);
        return this.kF != null;
    }

    public NSGif cW() {
        return this.kF;
    }
}
