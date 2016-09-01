package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class l {
    private StringBuilder Zr;

    public l() {
        this.Zr = null;
        this.Zr = null;
    }

    public void n(String str, Object obj) {
        if (!ba.isEmpty(str) && obj != null) {
            try {
                if (this.Zr == null) {
                    this.Zr = new StringBuilder();
                    this.Zr.append(str);
                    this.Zr.append("=");
                    this.Zr.append(obj.toString());
                } else {
                    this.Zr.append("|");
                    this.Zr.append(str);
                    this.Zr.append("=");
                    this.Zr.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.Zr != null ? this.Zr.toString() : "";
    }
}
