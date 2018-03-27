package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j {
    private StringBuilder aUQ;

    public j() {
        this.aUQ = null;
        this.aUQ = null;
    }

    public void h(String str, Object obj) {
        if (!am.isEmpty(str) && obj != null) {
            try {
                if (this.aUQ == null) {
                    this.aUQ = new StringBuilder();
                    this.aUQ.append(str);
                    this.aUQ.append("=");
                    this.aUQ.append(obj.toString());
                } else {
                    this.aUQ.append("|");
                    this.aUQ.append(str);
                    this.aUQ.append("=");
                    this.aUQ.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aUQ != null ? this.aUQ.toString() : "";
    }
}
