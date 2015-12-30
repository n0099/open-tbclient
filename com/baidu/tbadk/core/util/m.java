package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class m {
    private StringBuilder aax;

    public m() {
        this.aax = null;
        this.aax = null;
    }

    public void h(String str, Object obj) {
        if (!ax.isEmpty(str) && obj != null) {
            try {
                if (this.aax == null) {
                    this.aax = new StringBuilder();
                    this.aax.append(str);
                    this.aax.append("=");
                    this.aax.append(obj.toString());
                } else {
                    this.aax.append("|");
                    this.aax.append(str);
                    this.aax.append("=");
                    this.aax.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aax != null ? this.aax.toString() : "";
    }
}
