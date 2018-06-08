package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif wy;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.wy = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean j(byte[] bArr) {
        if (bArr == null || !NSGif.vR) {
            return false;
        }
        this.wy = NSGif.h(bArr, 0, bArr.length);
        return this.wy != null;
    }

    public NSGif gB() {
        return this.wy;
    }
}
