package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class l {
    private StringBuilder WD;

    public l() {
        this.WD = null;
        this.WD = null;
    }

    public void n(String str, Object obj) {
        if (!ba.isEmpty(str) && obj != null) {
            try {
                if (this.WD == null) {
                    this.WD = new StringBuilder();
                    this.WD.append(str);
                    this.WD.append("=");
                    this.WD.append(obj.toString());
                } else {
                    this.WD.append("|");
                    this.WD.append(str);
                    this.WD.append("=");
                    this.WD.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.WD != null ? this.WD.toString() : "";
    }
}
