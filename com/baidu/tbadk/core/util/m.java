package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class m {
    private StringBuilder Zb;

    public m() {
        this.Zb = null;
        this.Zb = null;
    }

    public void h(String str, Object obj) {
        if (!ar.isEmpty(str) && obj != null) {
            try {
                if (this.Zb == null) {
                    this.Zb = new StringBuilder();
                    this.Zb.append(str);
                    this.Zb.append("=");
                    this.Zb.append(obj.toString());
                } else {
                    this.Zb.append("|");
                    this.Zb.append(str);
                    this.Zb.append("=");
                    this.Zb.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.Zb != null ? this.Zb.toString() : "";
    }
}
