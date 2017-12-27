package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j {
    private StringBuilder aTt;

    public j() {
        this.aTt = null;
        this.aTt = null;
    }

    public void h(String str, Object obj) {
        if (!am.isEmpty(str) && obj != null) {
            try {
                if (this.aTt == null) {
                    this.aTt = new StringBuilder();
                    this.aTt.append(str);
                    this.aTt.append("=");
                    this.aTt.append(obj.toString());
                } else {
                    this.aTt.append("|");
                    this.aTt.append(str);
                    this.aTt.append("=");
                    this.aTt.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aTt != null ? this.aTt.toString() : "";
    }
}
