package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j {
    private StringBuilder afj;

    public j() {
        this.afj = null;
        this.afj = null;
    }

    public void h(String str, Object obj) {
        if (!am.isEmpty(str) && obj != null) {
            try {
                if (this.afj == null) {
                    this.afj = new StringBuilder();
                    this.afj.append(str);
                    this.afj.append("=");
                    this.afj.append(obj.toString());
                } else {
                    this.afj.append("|");
                    this.afj.append(str);
                    this.afj.append("=");
                    this.afj.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.afj != null ? this.afj.toString() : "";
    }
}
