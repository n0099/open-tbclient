package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j {
    private StringBuilder aet;

    public j() {
        this.aet = null;
        this.aet = null;
    }

    public void h(String str, Object obj) {
        if (!am.isEmpty(str) && obj != null) {
            try {
                if (this.aet == null) {
                    this.aet = new StringBuilder();
                    this.aet.append(str);
                    this.aet.append("=");
                    this.aet.append(obj.toString());
                } else {
                    this.aet.append("|");
                    this.aet.append(str);
                    this.aet.append("=");
                    this.aet.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aet != null ? this.aet.toString() : "";
    }
}
