package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class m {
    private StringBuilder Zh;

    public m() {
        this.Zh = null;
        this.Zh = null;
    }

    public void h(String str, Object obj) {
        if (!as.isEmpty(str) && obj != null) {
            try {
                if (this.Zh == null) {
                    this.Zh = new StringBuilder();
                    this.Zh.append(str);
                    this.Zh.append("=");
                    this.Zh.append(obj.toString());
                } else {
                    this.Zh.append("|");
                    this.Zh.append(str);
                    this.Zh.append("=");
                    this.Zh.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.Zh != null ? this.Zh.toString() : "";
    }
}
