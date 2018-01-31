package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class d extends DiskFileOperate {
    private String agc;
    private String mContent;

    public d(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mContent = null;
        this.agc = HTTP.UTF_8;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean h(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        try {
            this.mContent = new String(bArr, this.agc);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] lu() {
        if (this.mContent != null) {
            try {
                return this.mContent.getBytes(this.agc);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }
}
