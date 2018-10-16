package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif zs;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.zs = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean q(byte[] bArr) {
        if (bArr == null || !NSGif.yN) {
            return false;
        }
        this.zs = NSGif.h(bArr, 0, bArr.length);
        return this.zs != null;
    }

    public NSGif hW() {
        return this.zs;
    }
}
