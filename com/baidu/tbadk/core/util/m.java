package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class m {
    private StringBuilder Zd;

    public m() {
        this.Zd = null;
        this.Zd = null;
    }

    public void h(String str, Object obj) {
        if (!as.isEmpty(str) && obj != null) {
            try {
                if (this.Zd == null) {
                    this.Zd = new StringBuilder();
                    this.Zd.append(str);
                    this.Zd.append("=");
                    this.Zd.append(obj.toString());
                } else {
                    this.Zd.append("|");
                    this.Zd.append(str);
                    this.Zd.append("=");
                    this.Zd.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.Zd != null ? this.Zd.toString() : "";
    }
}
