package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j {
    private StringBuilder aTs;

    public j() {
        this.aTs = null;
        this.aTs = null;
    }

    public void h(String str, Object obj) {
        if (!am.isEmpty(str) && obj != null) {
            try {
                if (this.aTs == null) {
                    this.aTs = new StringBuilder();
                    this.aTs.append(str);
                    this.aTs.append("=");
                    this.aTs.append(obj.toString());
                } else {
                    this.aTs.append("|");
                    this.aTs.append(str);
                    this.aTs.append("=");
                    this.aTs.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aTs != null ? this.aTs.toString() : "";
    }
}
