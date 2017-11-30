package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j {
    private StringBuilder afl;

    public j() {
        this.afl = null;
        this.afl = null;
    }

    public void h(String str, Object obj) {
        if (!am.isEmpty(str) && obj != null) {
            try {
                if (this.afl == null) {
                    this.afl = new StringBuilder();
                    this.afl.append(str);
                    this.afl.append("=");
                    this.afl.append(obj.toString());
                } else {
                    this.afl.append("|");
                    this.afl.append(str);
                    this.afl.append("=");
                    this.afl.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.afl != null ? this.afl.toString() : "";
    }
}
