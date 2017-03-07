package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class k {
    private StringBuilder adZ;

    public k() {
        this.adZ = null;
        this.adZ = null;
    }

    public void n(String str, Object obj) {
        if (!au.isEmpty(str) && obj != null) {
            try {
                if (this.adZ == null) {
                    this.adZ = new StringBuilder();
                    this.adZ.append(str);
                    this.adZ.append("=");
                    this.adZ.append(obj.toString());
                } else {
                    this.adZ.append("|");
                    this.adZ.append(str);
                    this.adZ.append("=");
                    this.adZ.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.adZ != null ? this.adZ.toString() : "";
    }
}
