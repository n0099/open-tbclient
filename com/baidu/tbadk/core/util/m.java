package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class m {
    private StringBuilder YY;

    public m() {
        this.YY = null;
        this.YY = null;
    }

    public void h(String str, Object obj) {
        if (!aq.isEmpty(str) && obj != null) {
            try {
                if (this.YY == null) {
                    this.YY = new StringBuilder();
                    this.YY.append(str);
                    this.YY.append("=");
                    this.YY.append(obj.toString());
                } else {
                    this.YY.append("|");
                    this.YY.append(str);
                    this.YY.append("=");
                    this.YY.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.YY != null ? this.YY.toString() : "";
    }
}
