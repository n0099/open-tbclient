package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class k {
    private StringBuilder aeo;

    public k() {
        this.aeo = null;
        this.aeo = null;
    }

    public void n(String str, Object obj) {
        if (!au.isEmpty(str) && obj != null) {
            try {
                if (this.aeo == null) {
                    this.aeo = new StringBuilder();
                    this.aeo.append(str);
                    this.aeo.append("=");
                    this.aeo.append(obj.toString());
                } else {
                    this.aeo.append("|");
                    this.aeo.append(str);
                    this.aeo.append("=");
                    this.aeo.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aeo != null ? this.aeo.toString() : "";
    }
}
