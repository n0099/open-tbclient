package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class r {
    private StringBuilder Do;

    public r() {
        this.Do = null;
        this.Do = null;
    }

    public void g(String str, Object obj) {
        if (!ay.aA(str) && obj != null) {
            try {
                if (this.Do == null) {
                    this.Do = new StringBuilder();
                    this.Do.append(str);
                    this.Do.append("=");
                    this.Do.append(obj.toString());
                } else {
                    this.Do.append("|");
                    this.Do.append(str);
                    this.Do.append("=");
                    this.Do.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.Do != null ? this.Do.toString() : "";
    }
}
