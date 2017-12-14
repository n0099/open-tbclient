package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j {
    private StringBuilder aff;

    public j() {
        this.aff = null;
        this.aff = null;
    }

    public void h(String str, Object obj) {
        if (!am.isEmpty(str) && obj != null) {
            try {
                if (this.aff == null) {
                    this.aff = new StringBuilder();
                    this.aff.append(str);
                    this.aff.append("=");
                    this.aff.append(obj.toString());
                } else {
                    this.aff.append("|");
                    this.aff.append(str);
                    this.aff.append("=");
                    this.aff.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aff != null ? this.aff.toString() : "";
    }
}
