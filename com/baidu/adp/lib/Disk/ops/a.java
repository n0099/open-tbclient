package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif wq;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.wq = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean i(byte[] bArr) {
        if (bArr == null || !NSGif.vH) {
            return false;
        }
        this.wq = NSGif.h(bArr, 0, bArr.length);
        return this.wq != null;
    }

    public NSGif gA() {
        return this.wq;
    }
}
