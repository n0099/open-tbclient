package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class r {
    private StringBuilder Dp;

    public r() {
        this.Dp = null;
        this.Dp = null;
    }

    public void g(String str, Object obj) {
        if (!az.aA(str) && obj != null) {
            try {
                if (this.Dp == null) {
                    this.Dp = new StringBuilder();
                    this.Dp.append(str);
                    this.Dp.append("=");
                    this.Dp.append(obj.toString());
                } else {
                    this.Dp.append("|");
                    this.Dp.append(str);
                    this.Dp.append("=");
                    this.Dp.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.Dp != null ? this.Dp.toString() : "";
    }
}
