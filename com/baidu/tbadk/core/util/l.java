package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class l {
    private StringBuilder Zw;

    public l() {
        this.Zw = null;
        this.Zw = null;
    }

    public void n(String str, Object obj) {
        if (!av.isEmpty(str) && obj != null) {
            try {
                if (this.Zw == null) {
                    this.Zw = new StringBuilder();
                    this.Zw.append(str);
                    this.Zw.append("=");
                    this.Zw.append(obj.toString());
                } else {
                    this.Zw.append("|");
                    this.Zw.append(str);
                    this.Zw.append("=");
                    this.Zw.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.Zw != null ? this.Zw.toString() : "";
    }
}
