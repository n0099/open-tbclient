package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import org.apache.commons.io.Charsets;
/* loaded from: classes.dex */
public class e extends DiskFileOperate {
    private String g;
    private String h;

    public e(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.g = null;
        this.h = Charsets.UTF_8.displayName();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean b(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        try {
            this.g = new String(bArr, this.h);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] f() {
        if (this.g != null) {
            try {
                return this.g.getBytes(this.h);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    public String u() {
        return this.g;
    }

    public void a(String str) {
        this.g = str;
    }
}
