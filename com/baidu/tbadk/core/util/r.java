package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class r {
    private StringBuilder HB;

    public r() {
        this.HB = null;
        this.HB = null;
    }

    public void h(String str, Object obj) {
        if (!ba.isEmpty(str) && obj != null) {
            try {
                if (this.HB == null) {
                    this.HB = new StringBuilder();
                    this.HB.append(str);
                    this.HB.append("=");
                    this.HB.append(obj.toString());
                } else {
                    this.HB.append("|");
                    this.HB.append(str);
                    this.HB.append("=");
                    this.HB.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.HB != null ? this.HB.toString() : "";
    }
}
