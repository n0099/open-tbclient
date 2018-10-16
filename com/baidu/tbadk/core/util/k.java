package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes.dex */
public class k {
    private StringBuilder avO;

    public k() {
        this.avO = null;
        this.avO = null;
    }

    public void h(String str, Object obj) {
        if (!ao.isEmpty(str) && obj != null) {
            try {
                if (this.avO == null) {
                    this.avO = new StringBuilder();
                    this.avO.append(str);
                    this.avO.append(ETAG.EQUAL);
                    this.avO.append(obj.toString());
                } else {
                    this.avO.append("|");
                    this.avO.append(str);
                    this.avO.append(ETAG.EQUAL);
                    this.avO.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.avO != null ? this.avO.toString() : "";
    }
}
