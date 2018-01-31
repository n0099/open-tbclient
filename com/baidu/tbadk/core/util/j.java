package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j {
    private StringBuilder aTv;

    public j() {
        this.aTv = null;
        this.aTv = null;
    }

    public void h(String str, Object obj) {
        if (!am.isEmpty(str) && obj != null) {
            try {
                if (this.aTv == null) {
                    this.aTv = new StringBuilder();
                    this.aTv.append(str);
                    this.aTv.append("=");
                    this.aTv.append(obj.toString());
                } else {
                    this.aTv.append("|");
                    this.aTv.append(str);
                    this.aTv.append("=");
                    this.aTv.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aTv != null ? this.aTv.toString() : "";
    }
}
