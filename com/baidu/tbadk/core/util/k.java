package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class k {
    private StringBuilder ady;

    public k() {
        this.ady = null;
        this.ady = null;
    }

    public void n(String str, Object obj) {
        if (!au.isEmpty(str) && obj != null) {
            try {
                if (this.ady == null) {
                    this.ady = new StringBuilder();
                    this.ady.append(str);
                    this.ady.append("=");
                    this.ady.append(obj.toString());
                } else {
                    this.ady.append("|");
                    this.ady.append(str);
                    this.ady.append("=");
                    this.ady.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.ady != null ? this.ady.toString() : "";
    }
}
