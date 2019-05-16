package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class l {
    private StringBuilder bQm;

    public l() {
        this.bQm = null;
        this.bQm = null;
    }

    public void o(String str, Object obj) {
        if (!ap.isEmpty(str) && obj != null) {
            try {
                if (this.bQm == null) {
                    this.bQm = new StringBuilder();
                    this.bQm.append(str);
                    this.bQm.append("=");
                    this.bQm.append(obj.toString());
                } else {
                    this.bQm.append("|");
                    this.bQm.append(str);
                    this.bQm.append("=");
                    this.bQm.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.bQm != null ? this.bQm.toString() : "";
    }
}
