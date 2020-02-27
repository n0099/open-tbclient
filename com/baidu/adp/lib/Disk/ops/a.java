package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif oU;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.oU = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr == null || !NSGif.oD) {
            return false;
        }
        this.oU = NSGif.e(bArr, 0, bArr.length);
        return this.oU != null;
    }

    public NSGif fo() {
        return this.oU;
    }
}
