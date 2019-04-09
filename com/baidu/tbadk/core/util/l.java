package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class l {
    private StringBuilder bIC;

    public l() {
        this.bIC = null;
        this.bIC = null;
    }

    public void l(String str, Object obj) {
        if (!ap.isEmpty(str) && obj != null) {
            try {
                if (this.bIC == null) {
                    this.bIC = new StringBuilder();
                    this.bIC.append(str);
                    this.bIC.append("=");
                    this.bIC.append(obj.toString());
                } else {
                    this.bIC.append("|");
                    this.bIC.append(str);
                    this.bIC.append("=");
                    this.bIC.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.bIC != null ? this.bIC.toString() : "";
    }
}
