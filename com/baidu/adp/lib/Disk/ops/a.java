package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif tF;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.tF = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean n(byte[] bArr) {
        if (bArr == null || !NSGif.sV) {
            return false;
        }
        this.tF = NSGif.h(bArr, 0, bArr.length);
        return this.tF != null;
    }

    public NSGif em() {
        return this.tF;
    }
}
