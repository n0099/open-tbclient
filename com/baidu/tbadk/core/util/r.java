package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class r {
    private StringBuilder HK;

    public r() {
        this.HK = null;
        this.HK = null;
    }

    public void h(String str, Object obj) {
        if (!bf.isEmpty(str) && obj != null) {
            try {
                if (this.HK == null) {
                    this.HK = new StringBuilder();
                    this.HK.append(str);
                    this.HK.append("=");
                    this.HK.append(obj.toString());
                } else {
                    this.HK.append("|");
                    this.HK.append(str);
                    this.HK.append("=");
                    this.HK.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.HK != null ? this.HK.toString() : "";
    }
}
