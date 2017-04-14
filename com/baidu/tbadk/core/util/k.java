package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class k {
    private StringBuilder aen;

    public k() {
        this.aen = null;
        this.aen = null;
    }

    public void n(String str, Object obj) {
        if (!au.isEmpty(str) && obj != null) {
            try {
                if (this.aen == null) {
                    this.aen = new StringBuilder();
                    this.aen.append(str);
                    this.aen.append("=");
                    this.aen.append(obj.toString());
                } else {
                    this.aen.append("|");
                    this.aen.append(str);
                    this.aen.append("=");
                    this.aen.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aen != null ? this.aen.toString() : "";
    }
}
