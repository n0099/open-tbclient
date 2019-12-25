package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif oT;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.oT = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr == null || !NSGif.oC) {
            return false;
        }
        this.oT = NSGif.e(bArr, 0, bArr.length);
        return this.oT != null;
    }

    public NSGif fn() {
        return this.oT;
    }
}
