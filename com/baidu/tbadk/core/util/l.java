package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class l {
    private StringBuilder aac;

    public l() {
        this.aac = null;
        this.aac = null;
    }

    public void n(String str, Object obj) {
        if (!ax.isEmpty(str) && obj != null) {
            try {
                if (this.aac == null) {
                    this.aac = new StringBuilder();
                    this.aac.append(str);
                    this.aac.append("=");
                    this.aac.append(obj.toString());
                } else {
                    this.aac.append("|");
                    this.aac.append(str);
                    this.aac.append("=");
                    this.aac.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aac != null ? this.aac.toString() : "";
    }
}
