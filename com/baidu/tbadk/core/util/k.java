package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes.dex */
public class k {
    private StringBuilder awB;

    public k() {
        this.awB = null;
        this.awB = null;
    }

    public void h(String str, Object obj) {
        if (!ao.isEmpty(str) && obj != null) {
            try {
                if (this.awB == null) {
                    this.awB = new StringBuilder();
                    this.awB.append(str);
                    this.awB.append(ETAG.EQUAL);
                    this.awB.append(obj.toString());
                } else {
                    this.awB.append("|");
                    this.awB.append(str);
                    this.awB.append(ETAG.EQUAL);
                    this.awB.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.awB != null ? this.awB.toString() : "";
    }
}
