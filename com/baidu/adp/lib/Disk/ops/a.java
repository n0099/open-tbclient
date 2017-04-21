package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif rV;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.rV = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr == null || !NSGif.rl) {
            return false;
        }
        this.rV = NSGif.f(bArr, 0, bArr.length);
        return this.rV != null;
    }

    public NSGif ed() {
        return this.rV;
    }
}
