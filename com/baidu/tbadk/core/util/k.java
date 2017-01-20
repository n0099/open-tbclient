package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class k {
    private StringBuilder YK;

    public k() {
        this.YK = null;
        this.YK = null;
    }

    public void n(String str, Object obj) {
        if (!at.isEmpty(str) && obj != null) {
            try {
                if (this.YK == null) {
                    this.YK = new StringBuilder();
                    this.YK.append(str);
                    this.YK.append("=");
                    this.YK.append(obj.toString());
                } else {
                    this.YK.append("|");
                    this.YK.append(str);
                    this.YK.append("=");
                    this.YK.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.YK != null ? this.YK.toString() : "";
    }
}
