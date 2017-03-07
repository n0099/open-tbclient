package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif su;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.su = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr == null || !NSGif.rI) {
            return false;
        }
        this.su = NSGif.f(bArr, 0, bArr.length);
        return this.su != null;
    }

    public NSGif ed() {
        return this.su;
    }
}
