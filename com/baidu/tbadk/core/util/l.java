package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class l {
    private StringBuilder bQn;

    public l() {
        this.bQn = null;
        this.bQn = null;
    }

    public void o(String str, Object obj) {
        if (!ap.isEmpty(str) && obj != null) {
            try {
                if (this.bQn == null) {
                    this.bQn = new StringBuilder();
                    this.bQn.append(str);
                    this.bQn.append("=");
                    this.bQn.append(obj.toString());
                } else {
                    this.bQn.append("|");
                    this.bQn.append(str);
                    this.bQn.append("=");
                    this.bQn.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.bQn != null ? this.bQn.toString() : "";
    }
}
