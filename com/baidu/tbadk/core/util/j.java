package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j {
    private StringBuilder aeD;

    public j() {
        this.aeD = null;
        this.aeD = null;
    }

    public void n(String str, Object obj) {
        if (!al.isEmpty(str) && obj != null) {
            try {
                if (this.aeD == null) {
                    this.aeD = new StringBuilder();
                    this.aeD.append(str);
                    this.aeD.append("=");
                    this.aeD.append(obj.toString());
                } else {
                    this.aeD.append("|");
                    this.aeD.append(str);
                    this.aeD.append("=");
                    this.aeD.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aeD != null ? this.aeD.toString() : "";
    }
}
