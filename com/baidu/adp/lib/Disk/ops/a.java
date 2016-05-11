package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif hI;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.hI = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean h(byte[] bArr) {
        if (bArr == null || !NSGif.gY) {
            return false;
        }
        this.hI = NSGif.e(bArr, 0, bArr.length);
        return this.hI != null;
    }

    public NSGif cb() {
        return this.hI;
    }
}
