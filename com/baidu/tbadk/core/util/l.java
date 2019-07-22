package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class l {
    private StringBuilder bRn;

    public l() {
        this.bRn = null;
        this.bRn = null;
    }

    public void o(String str, Object obj) {
        if (!aq.isEmpty(str) && obj != null) {
            try {
                if (this.bRn == null) {
                    this.bRn = new StringBuilder();
                    this.bRn.append(str);
                    this.bRn.append("=");
                    this.bRn.append(obj.toString());
                } else {
                    this.bRn.append("|");
                    this.bRn.append(str);
                    this.bRn.append("=");
                    this.bRn.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.bRn != null ? this.bRn.toString() : "";
    }
}
