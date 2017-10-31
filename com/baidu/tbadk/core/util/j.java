package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j {
    private StringBuilder aeO;

    public j() {
        this.aeO = null;
        this.aeO = null;
    }

    public void h(String str, Object obj) {
        if (!am.isEmpty(str) && obj != null) {
            try {
                if (this.aeO == null) {
                    this.aeO = new StringBuilder();
                    this.aeO.append(str);
                    this.aeO.append("=");
                    this.aeO.append(obj.toString());
                } else {
                    this.aeO.append("|");
                    this.aeO.append(str);
                    this.aeO.append("=");
                    this.aeO.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aeO != null ? this.aeO.toString() : "";
    }
}
