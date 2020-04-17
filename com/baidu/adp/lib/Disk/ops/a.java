package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif HZ;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.HZ = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr == null || !NSGif.HH) {
            return false;
        }
        this.HZ = NSGif.g(bArr, 0, bArr.length);
        return this.HZ != null;
    }

    public NSGif jT() {
        return this.HZ;
    }
}
