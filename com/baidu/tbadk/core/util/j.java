package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j {
    private StringBuilder aVa;

    public j() {
        this.aVa = null;
        this.aVa = null;
    }

    public void h(String str, Object obj) {
        if (!am.isEmpty(str) && obj != null) {
            try {
                if (this.aVa == null) {
                    this.aVa = new StringBuilder();
                    this.aVa.append(str);
                    this.aVa.append("=");
                    this.aVa.append(obj.toString());
                } else {
                    this.aVa.append("|");
                    this.aVa.append(str);
                    this.aVa.append("=");
                    this.aVa.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aVa != null ? this.aVa.toString() : "";
    }
}
