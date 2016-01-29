package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class l {
    private StringBuilder aaT;

    public l() {
        this.aaT = null;
        this.aaT = null;
    }

    public void i(String str, Object obj) {
        if (!aw.isEmpty(str) && obj != null) {
            try {
                if (this.aaT == null) {
                    this.aaT = new StringBuilder();
                    this.aaT.append(str);
                    this.aaT.append("=");
                    this.aaT.append(obj.toString());
                } else {
                    this.aaT.append("|");
                    this.aaT.append(str);
                    this.aaT.append("=");
                    this.aaT.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aaT != null ? this.aaT.toString() : "";
    }
}
