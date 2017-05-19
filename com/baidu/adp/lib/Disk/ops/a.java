package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif rW;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.rW = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr == null || !NSGif.rm) {
            return false;
        }
        this.rW = NSGif.f(bArr, 0, bArr.length);
        return this.rW != null;
    }

    public NSGif ed() {
        return this.rW;
    }
}
