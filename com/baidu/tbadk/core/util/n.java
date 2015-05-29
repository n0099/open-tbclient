package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class n {
    private StringBuilder TV;

    public n() {
        this.TV = null;
        this.TV = null;
    }

    public void h(String str, Object obj) {
        if (!bb.isEmpty(str) && obj != null) {
            try {
                if (this.TV == null) {
                    this.TV = new StringBuilder();
                    this.TV.append(str);
                    this.TV.append("=");
                    this.TV.append(obj.toString());
                } else {
                    this.TV.append("|");
                    this.TV.append(str);
                    this.TV.append("=");
                    this.TV.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.TV != null ? this.TV.toString() : "";
    }
}
