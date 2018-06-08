package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class k {
    private StringBuilder aoq;

    public k() {
        this.aoq = null;
        this.aoq = null;
    }

    public void h(String str, Object obj) {
        if (!ao.isEmpty(str) && obj != null) {
            try {
                if (this.aoq == null) {
                    this.aoq = new StringBuilder();
                    this.aoq.append(str);
                    this.aoq.append("=");
                    this.aoq.append(obj.toString());
                } else {
                    this.aoq.append("|");
                    this.aoq.append(str);
                    this.aoq.append("=");
                    this.aoq.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aoq != null ? this.aoq.toString() : "";
    }
}
