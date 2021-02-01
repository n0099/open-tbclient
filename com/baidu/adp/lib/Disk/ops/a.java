package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif Kj;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.Kj = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr == null || !NSGif.JS) {
            return false;
        }
        this.Kj = NSGif.g(bArr, 0, bArr.length);
        return this.Kj != null;
    }

    public NSGif lm() {
        return this.Kj;
    }
}
