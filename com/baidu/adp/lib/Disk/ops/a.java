package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif Kk;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.Kk = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr == null || !NSGif.JT) {
            return false;
        }
        this.Kk = NSGif.g(bArr, 0, bArr.length);
        return this.Kk != null;
    }

    public NSGif ln() {
        return this.Kk;
    }
}
