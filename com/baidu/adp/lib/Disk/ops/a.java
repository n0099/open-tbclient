package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif JE;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.JE = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr == null || !NSGif.Jn) {
            return false;
        }
        this.JE = NSGif.g(bArr, 0, bArr.length);
        return this.JE != null;
    }

    public NSGif lO() {
        return this.JE;
    }
}
