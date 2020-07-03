package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif IS;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.IS = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr == null || !NSGif.Iw) {
            return false;
        }
        this.IS = NSGif.g(bArr, 0, bArr.length);
        return this.IS != null;
    }

    public NSGif kl() {
        return this.IS;
    }
}
