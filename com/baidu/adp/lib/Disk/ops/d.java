package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class d extends DiskFileOperate {
    private String mContent;
    private String zA;

    public d(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mContent = null;
        this.zA = "UTF-8";
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean q(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        try {
            this.mContent = new String(bArr, this.zA);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] hK() {
        if (this.mContent != null) {
            try {
                return this.mContent.getBytes(this.zA);
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
