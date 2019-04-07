package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class l {
    private StringBuilder bIB;

    public l() {
        this.bIB = null;
        this.bIB = null;
    }

    public void l(String str, Object obj) {
        if (!ap.isEmpty(str) && obj != null) {
            try {
                if (this.bIB == null) {
                    this.bIB = new StringBuilder();
                    this.bIB.append(str);
                    this.bIB.append("=");
                    this.bIB.append(obj.toString());
                } else {
                    this.bIB.append("|");
                    this.bIB.append(str);
                    this.bIB.append("=");
                    this.bIB.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.bIB != null ? this.bIB.toString() : "";
    }
}
