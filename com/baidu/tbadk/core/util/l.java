package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class l {
    private StringBuilder bIy;

    public l() {
        this.bIy = null;
        this.bIy = null;
    }

    public void l(String str, Object obj) {
        if (!ap.isEmpty(str) && obj != null) {
            try {
                if (this.bIy == null) {
                    this.bIy = new StringBuilder();
                    this.bIy.append(str);
                    this.bIy.append("=");
                    this.bIy.append(obj.toString());
                } else {
                    this.bIy.append("|");
                    this.bIy.append(str);
                    this.bIy.append("=");
                    this.bIy.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.bIy != null ? this.bIy.toString() : "";
    }
}
