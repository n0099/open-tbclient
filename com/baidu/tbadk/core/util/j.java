package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j {
    private StringBuilder agk;

    public j() {
        this.agk = null;
        this.agk = null;
    }

    public void h(String str, Object obj) {
        if (!an.isEmpty(str) && obj != null) {
            try {
                if (this.agk == null) {
                    this.agk = new StringBuilder();
                    this.agk.append(str);
                    this.agk.append("=");
                    this.agk.append(obj.toString());
                } else {
                    this.agk.append("|");
                    this.agk.append(str);
                    this.agk.append("=");
                    this.agk.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.agk != null ? this.agk.toString() : "";
    }
}
