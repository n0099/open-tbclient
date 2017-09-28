package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j {
    private StringBuilder aeF;

    public j() {
        this.aeF = null;
        this.aeF = null;
    }

    public void h(String str, Object obj) {
        if (!am.isEmpty(str) && obj != null) {
            try {
                if (this.aeF == null) {
                    this.aeF = new StringBuilder();
                    this.aeF.append(str);
                    this.aeF.append("=");
                    this.aeF.append(obj.toString());
                } else {
                    this.aeF.append("|");
                    this.aeF.append(str);
                    this.aeF.append("=");
                    this.aeF.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aeF != null ? this.aeF.toString() : "";
    }
}
