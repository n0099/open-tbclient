package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif gb;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.gb = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean j(byte[] bArr) {
        if (bArr == null || !NSGif.fx) {
            return false;
        }
        this.gb = NSGif.e(bArr, 0, bArr.length);
        return this.gb != null;
    }

    public NSGif cl() {
        return this.gb;
    }
}
