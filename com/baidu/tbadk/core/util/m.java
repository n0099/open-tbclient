package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class m {
    private StringBuilder aeh;

    public m() {
        this.aeh = null;
        this.aeh = null;
    }

    public void n(String str, Object obj) {
        if (!aw.isEmpty(str) && obj != null) {
            try {
                if (this.aeh == null) {
                    this.aeh = new StringBuilder();
                    this.aeh.append(str);
                    this.aeh.append("=");
                    this.aeh.append(obj.toString());
                } else {
                    this.aeh.append("|");
                    this.aeh.append(str);
                    this.aeh.append("=");
                    this.aeh.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aeh != null ? this.aeh.toString() : "";
    }
}
