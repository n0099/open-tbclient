package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j {
    private StringBuilder afX;

    public j() {
        this.afX = null;
        this.afX = null;
    }

    public void n(String str, Object obj) {
        if (!al.isEmpty(str) && obj != null) {
            try {
                if (this.afX == null) {
                    this.afX = new StringBuilder();
                    this.afX.append(str);
                    this.afX.append("=");
                    this.afX.append(obj.toString());
                } else {
                    this.afX.append("|");
                    this.afX.append(str);
                    this.afX.append("=");
                    this.afX.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.afX != null ? this.afX.toString() : "";
    }
}
