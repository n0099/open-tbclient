package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif rL;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.rL = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean x(byte[] bArr) {
        if (bArr == null || !NSGif.rb) {
            return false;
        }
        this.rL = NSGif.e(bArr, 0, bArr.length);
        return this.rL != null;
    }

    public NSGif fM() {
        return this.rL;
    }
}
