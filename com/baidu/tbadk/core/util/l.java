package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class l {
    private StringBuilder ZE;

    public l() {
        this.ZE = null;
        this.ZE = null;
    }

    public void n(String str, Object obj) {
        if (!az.isEmpty(str) && obj != null) {
            try {
                if (this.ZE == null) {
                    this.ZE = new StringBuilder();
                    this.ZE.append(str);
                    this.ZE.append("=");
                    this.ZE.append(obj.toString());
                } else {
                    this.ZE.append("|");
                    this.ZE.append(str);
                    this.ZE.append("=");
                    this.ZE.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.ZE != null ? this.ZE.toString() : "";
    }
}
