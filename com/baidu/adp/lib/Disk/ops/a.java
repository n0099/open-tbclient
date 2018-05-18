package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif qi;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.qi = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean j(byte[] bArr) {
        if (bArr == null || !NSGif.pC) {
            return false;
        }
        this.qi = NSGif.h(bArr, 0, bArr.length);
        return this.qi != null;
    }

    public NSGif dK() {
        return this.qi;
    }
}
