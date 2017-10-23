package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif rs;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.rs = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean h(byte[] bArr) {
        if (bArr == null || !NSGif.qK) {
            return false;
        }
        this.rs = NSGif.h(bArr, 0, bArr.length);
        return this.rs != null;
    }

    public NSGif eb() {
        return this.rs;
    }
}
