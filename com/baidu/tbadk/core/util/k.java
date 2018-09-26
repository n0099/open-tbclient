package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class k {
    private StringBuilder aqY;

    public k() {
        this.aqY = null;
        this.aqY = null;
    }

    public void h(String str, Object obj) {
        if (!ao.isEmpty(str) && obj != null) {
            try {
                if (this.aqY == null) {
                    this.aqY = new StringBuilder();
                    this.aqY.append(str);
                    this.aqY.append("=");
                    this.aqY.append(obj.toString());
                } else {
                    this.aqY.append("|");
                    this.aqY.append(str);
                    this.aqY.append("=");
                    this.aqY.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aqY != null ? this.aqY.toString() : "";
    }
}
