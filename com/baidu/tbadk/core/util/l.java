package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class l {
    private StringBuilder bIz;

    public l() {
        this.bIz = null;
        this.bIz = null;
    }

    public void l(String str, Object obj) {
        if (!ap.isEmpty(str) && obj != null) {
            try {
                if (this.bIz == null) {
                    this.bIz = new StringBuilder();
                    this.bIz.append(str);
                    this.bIz.append("=");
                    this.bIz.append(obj.toString());
                } else {
                    this.bIz.append("|");
                    this.bIz.append(str);
                    this.bIz.append("=");
                    this.bIz.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.bIz != null ? this.bIz.toString() : "";
    }
}
