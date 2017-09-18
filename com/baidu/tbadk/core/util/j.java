package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j {
    private StringBuilder afi;

    public j() {
        this.afi = null;
        this.afi = null;
    }

    public void h(String str, Object obj) {
        if (!am.isEmpty(str) && obj != null) {
            try {
                if (this.afi == null) {
                    this.afi = new StringBuilder();
                    this.afi.append(str);
                    this.afi.append("=");
                    this.afi.append(obj.toString());
                } else {
                    this.afi.append("|");
                    this.afi.append(str);
                    this.afi.append("=");
                    this.afi.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.afi != null ? this.afi.toString() : "";
    }
}
