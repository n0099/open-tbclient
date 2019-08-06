package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class l {
    private StringBuilder bRt;

    public l() {
        this.bRt = null;
        this.bRt = null;
    }

    public void o(String str, Object obj) {
        if (!aq.isEmpty(str) && obj != null) {
            try {
                if (this.bRt == null) {
                    this.bRt = new StringBuilder();
                    this.bRt.append(str);
                    this.bRt.append("=");
                    this.bRt.append(obj.toString());
                } else {
                    this.bRt.append("|");
                    this.bRt.append(str);
                    this.bRt.append("=");
                    this.bRt.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.bRt != null ? this.bRt.toString() : "";
    }
}
