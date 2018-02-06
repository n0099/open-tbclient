package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif afT;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.afT = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean h(byte[] bArr) {
        if (bArr == null || !NSGif.afk) {
            return false;
        }
        this.afT = NSGif.h(bArr, 0, bArr.length);
        return this.afT != null;
    }

    public NSGif lG() {
        return this.afT;
    }
}
