package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class r {
    private StringBuilder HH;

    public r() {
        this.HH = null;
        this.HH = null;
    }

    public void h(String str, Object obj) {
        if (!bf.isEmpty(str) && obj != null) {
            try {
                if (this.HH == null) {
                    this.HH = new StringBuilder();
                    this.HH.append(str);
                    this.HH.append("=");
                    this.HH.append(obj.toString());
                } else {
                    this.HH.append("|");
                    this.HH.append(str);
                    this.HH.append("=");
                    this.HH.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.HH != null ? this.HH.toString() : "";
    }
}
