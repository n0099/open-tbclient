package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class k {
    private StringBuilder adG;

    public k() {
        this.adG = null;
        this.adG = null;
    }

    public void n(String str, Object obj) {
        if (!au.isEmpty(str) && obj != null) {
            try {
                if (this.adG == null) {
                    this.adG = new StringBuilder();
                    this.adG.append(str);
                    this.adG.append("=");
                    this.adG.append(obj.toString());
                } else {
                    this.adG.append("|");
                    this.adG.append(str);
                    this.adG.append("=");
                    this.adG.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.adG != null ? this.adG.toString() : "";
    }
}
