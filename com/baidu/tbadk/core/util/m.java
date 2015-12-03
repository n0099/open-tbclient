package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class m {
    private StringBuilder ZT;

    public m() {
        this.ZT = null;
        this.ZT = null;
    }

    public void h(String str, Object obj) {
        if (!ax.isEmpty(str) && obj != null) {
            try {
                if (this.ZT == null) {
                    this.ZT = new StringBuilder();
                    this.ZT.append(str);
                    this.ZT.append("=");
                    this.ZT.append(obj.toString());
                } else {
                    this.ZT.append("|");
                    this.ZT.append(str);
                    this.ZT.append("=");
                    this.ZT.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.ZT != null ? this.ZT.toString() : "";
    }
}
