package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j {
    private StringBuilder aUO;

    public j() {
        this.aUO = null;
        this.aUO = null;
    }

    public void h(String str, Object obj) {
        if (!am.isEmpty(str) && obj != null) {
            try {
                if (this.aUO == null) {
                    this.aUO = new StringBuilder();
                    this.aUO.append(str);
                    this.aUO.append("=");
                    this.aUO.append(obj.toString());
                } else {
                    this.aUO.append("|");
                    this.aUO.append(str);
                    this.aUO.append("=");
                    this.aUO.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aUO != null ? this.aUO.toString() : "";
    }
}
