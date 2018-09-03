package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class k {
    private StringBuilder aos;

    public k() {
        this.aos = null;
        this.aos = null;
    }

    public void h(String str, Object obj) {
        if (!ap.isEmpty(str) && obj != null) {
            try {
                if (this.aos == null) {
                    this.aos = new StringBuilder();
                    this.aos.append(str);
                    this.aos.append("=");
                    this.aos.append(obj.toString());
                } else {
                    this.aos.append("|");
                    this.aos.append(str);
                    this.aos.append("=");
                    this.aos.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aos != null ? this.aos.toString() : "";
    }
}
