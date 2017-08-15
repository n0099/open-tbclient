package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j {
    private StringBuilder afZ;

    public j() {
        this.afZ = null;
        this.afZ = null;
    }

    public void n(String str, Object obj) {
        if (!al.isEmpty(str) && obj != null) {
            try {
                if (this.afZ == null) {
                    this.afZ = new StringBuilder();
                    this.afZ.append(str);
                    this.afZ.append("=");
                    this.afZ.append(obj.toString());
                } else {
                    this.afZ.append("|");
                    this.afZ.append(str);
                    this.afZ.append("=");
                    this.afZ.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.afZ != null ? this.afZ.toString() : "";
    }
}
