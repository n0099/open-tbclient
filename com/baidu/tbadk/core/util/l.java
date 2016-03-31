package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class l {
    private StringBuilder aaf;

    public l() {
        this.aaf = null;
        this.aaf = null;
    }

    public void h(String str, Object obj) {
        if (!ay.isEmpty(str) && obj != null) {
            try {
                if (this.aaf == null) {
                    this.aaf = new StringBuilder();
                    this.aaf.append(str);
                    this.aaf.append("=");
                    this.aaf.append(obj.toString());
                } else {
                    this.aaf.append("|");
                    this.aaf.append(str);
                    this.aaf.append("=");
                    this.aaf.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aaf != null ? this.aaf.toString() : "";
    }
}
