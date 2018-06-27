package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class k {
    private StringBuilder aoP;

    public k() {
        this.aoP = null;
        this.aoP = null;
    }

    public void h(String str, Object obj) {
        if (!ap.isEmpty(str) && obj != null) {
            try {
                if (this.aoP == null) {
                    this.aoP = new StringBuilder();
                    this.aoP.append(str);
                    this.aoP.append("=");
                    this.aoP.append(obj.toString());
                } else {
                    this.aoP.append("|");
                    this.aoP.append(str);
                    this.aoP.append("=");
                    this.aoP.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aoP != null ? this.aoP.toString() : "";
    }
}
