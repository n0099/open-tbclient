package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif zv;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.zv = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean p(byte[] bArr) {
        if (bArr == null || !NSGif.yQ) {
            return false;
        }
        this.zv = NSGif.h(bArr, 0, bArr.length);
        return this.zv != null;
    }

    public NSGif hV() {
        return this.zv;
    }
}
