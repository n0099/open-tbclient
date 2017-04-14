package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif rQ;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.rQ = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr == null || !NSGif.rg) {
            return false;
        }
        this.rQ = NSGif.f(bArr, 0, bArr.length);
        return this.rQ != null;
    }

    public NSGif ec() {
        return this.rQ;
    }
}
