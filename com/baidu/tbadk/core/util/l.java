package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class l {
    private StringBuilder VU;

    public l() {
        this.VU = null;
        this.VU = null;
    }

    public void h(String str, Object obj) {
        if (!ba.isEmpty(str) && obj != null) {
            try {
                if (this.VU == null) {
                    this.VU = new StringBuilder();
                    this.VU.append(str);
                    this.VU.append("=");
                    this.VU.append(obj.toString());
                } else {
                    this.VU.append("|");
                    this.VU.append(str);
                    this.VU.append("=");
                    this.VU.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.VU != null ? this.VU.toString() : "";
    }
}
