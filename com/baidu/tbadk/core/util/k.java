package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes.dex */
public class k {
    private StringBuilder aAE;

    public k() {
        this.aAE = null;
        this.aAE = null;
    }

    public void h(String str, Object obj) {
        if (!ao.isEmpty(str) && obj != null) {
            try {
                if (this.aAE == null) {
                    this.aAE = new StringBuilder();
                    this.aAE.append(str);
                    this.aAE.append(ETAG.EQUAL);
                    this.aAE.append(obj.toString());
                } else {
                    this.aAE.append("|");
                    this.aAE.append(str);
                    this.aAE.append(ETAG.EQUAL);
                    this.aAE.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.aAE != null ? this.aAE.toString() : "";
    }
}
