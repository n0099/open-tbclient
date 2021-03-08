package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif LC;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.LC = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr == null || !NSGif.Ll) {
            return false;
        }
        this.LC = NSGif.g(bArr, 0, bArr.length);
        return this.LC != null;
    }

    public NSGif lm() {
        return this.LC;
    }
}
