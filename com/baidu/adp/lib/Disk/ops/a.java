package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif ww;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.ww = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr == null || !NSGif.vP) {
            return false;
        }
        this.ww = NSGif.h(bArr, 0, bArr.length);
        return this.ww != null;
    }

    public NSGif gB() {
        return this.ww;
    }
}
