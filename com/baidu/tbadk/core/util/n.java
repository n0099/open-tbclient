package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class n {
    private StringBuilder Tm;

    public n() {
        this.Tm = null;
        this.Tm = null;
    }

    public void h(String str, Object obj) {
        if (!bd.isEmpty(str) && obj != null) {
            try {
                if (this.Tm == null) {
                    this.Tm = new StringBuilder();
                    this.Tm.append(str);
                    this.Tm.append("=");
                    this.Tm.append(obj.toString());
                } else {
                    this.Tm.append("|");
                    this.Tm.append(str);
                    this.Tm.append("=");
                    this.Tm.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.Tm != null ? this.Tm.toString() : "";
    }
}
