package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {
    private NSGif oQ;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.oQ = null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr == null || !NSGif.oz) {
            return false;
        }
        this.oQ = NSGif.e(bArr, 0, bArr.length);
        return this.oQ != null;
    }

    public NSGif fn() {
        return this.oQ;
    }
}
