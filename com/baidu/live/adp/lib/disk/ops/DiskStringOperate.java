package com.baidu.live.adp.lib.disk.ops;

import com.baidu.live.adp.lib.disk.ops.DiskFileOperate;
import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes2.dex */
public class DiskStringOperate extends DiskFileOperate {
    private String mCharsetName;
    private String mContent;

    public DiskStringOperate(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mContent = null;
        this.mCharsetName = "UTF-8";
    }

    public String getCharsetName() {
        return this.mCharsetName;
    }

    public void setCharsetName(String str) {
        this.mCharsetName = str;
    }

    @Override // com.baidu.live.adp.lib.disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        try {
            this.mContent = new String(bArr, this.mCharsetName);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    @Override // com.baidu.live.adp.lib.disk.ops.DiskFileOperate
    public byte[] buildFormatData() {
        if (this.mContent != null) {
            try {
                return this.mContent.getBytes(this.mCharsetName);
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
