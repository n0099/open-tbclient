package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes.dex */
public class k {
    private StringBuilder aAb;

    public k() {
        this.aAb = null;
        this.aAb = null;
    }

    public void h(String str, Object obj) {
        if (!ao.isEmpty(str) && obj != null) {
            try {
                if (this.aAb == null) {
                    this.aAb = new StringBuilder();
                    this.aAb.append(str);
                    this.aAb.append(ETAG.EQUAL);
                    this.aAb.append(obj.toString());
                } else {
                    this.aAb.append("|");
                    this.aAb.append(str);
                    this.aAb.append(ETAG.EQUAL);
                    this.aAb.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aAb != null ? this.aAb.toString() : "";
    }
}
