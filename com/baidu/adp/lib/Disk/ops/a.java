package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif g;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.g = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean b(byte[] bArr) {
        if (bArr == null || !NSGif.a) {
            return false;
        }
        this.g = NSGif.a(bArr, 0, bArr.length);
        return this.g != null;
    }

    public NSGif u() {
        return this.g;
    }
}
