package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class l {
    private StringBuilder bRU;

    public l() {
        this.bRU = null;
        this.bRU = null;
    }

    public void o(String str, Object obj) {
        if (!aq.isEmpty(str) && obj != null) {
            try {
                if (this.bRU == null) {
                    this.bRU = new StringBuilder();
                    this.bRU.append(str);
                    this.bRU.append("=");
                    this.bRU.append(obj.toString());
                } else {
                    this.bRU.append("|");
                    this.bRU.append(str);
                    this.bRU.append("=");
                    this.bRU.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.bRU != null ? this.bRU.toString() : "";
    }
}
