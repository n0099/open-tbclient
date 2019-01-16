package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes.dex */
public class k {
    private StringBuilder aAD;

    public k() {
        this.aAD = null;
        this.aAD = null;
    }

    public void h(String str, Object obj) {
        if (!ao.isEmpty(str) && obj != null) {
            try {
                if (this.aAD == null) {
                    this.aAD = new StringBuilder();
                    this.aAD.append(str);
                    this.aAD.append(ETAG.EQUAL);
                    this.aAD.append(obj.toString());
                } else {
                    this.aAD.append("|");
                    this.aAD.append(str);
                    this.aAD.append(ETAG.EQUAL);
                    this.aAD.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aAD != null ? this.aAD.toString() : "";
    }
}
