package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class k {
    private StringBuilder aor;

    public k() {
        this.aor = null;
        this.aor = null;
    }

    public void h(String str, Object obj) {
        if (!ap.isEmpty(str) && obj != null) {
            try {
                if (this.aor == null) {
                    this.aor = new StringBuilder();
                    this.aor.append(str);
                    this.aor.append("=");
                    this.aor.append(obj.toString());
                } else {
                    this.aor.append("|");
                    this.aor.append(str);
                    this.aor.append("=");
                    this.aor.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aor != null ? this.aor.toString() : "";
    }
}
