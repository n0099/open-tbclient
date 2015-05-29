package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif rH;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.rH = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr == null || !NSGif.qX) {
            return false;
        }
        this.rH = NSGif.e(bArr, 0, bArr.length);
        return this.rH != null;
    }

    public NSGif fM() {
        return this.rH;
    }
}
