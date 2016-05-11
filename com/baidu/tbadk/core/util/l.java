package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class l {
    private StringBuilder VE;

    public l() {
        this.VE = null;
        this.VE = null;
    }

    public void h(String str, Object obj) {
        if (!ay.isEmpty(str) && obj != null) {
            try {
                if (this.VE == null) {
                    this.VE = new StringBuilder();
                    this.VE.append(str);
                    this.VE.append("=");
                    this.VE.append(obj.toString());
                } else {
                    this.VE.append("|");
                    this.VE.append(str);
                    this.VE.append("=");
                    this.VE.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.VE != null ? this.VE.toString() : "";
    }
}
