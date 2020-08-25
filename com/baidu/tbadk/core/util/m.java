package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes2.dex */
public class m {
    private StringBuilder builder;

    public m() {
        this.builder = null;
        this.builder = null;
    }

    public void append(String str, Object obj) {
        if (!at.isEmpty(str) && obj != null) {
            try {
                if (this.builder == null) {
                    this.builder = new StringBuilder();
                    this.builder.append(str);
                    this.builder.append(ETAG.EQUAL);
                    this.builder.append(obj.toString());
                } else {
                    this.builder.append("|");
                    this.builder.append(str);
                    this.builder.append(ETAG.EQUAL);
                    this.builder.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.builder != null ? this.builder.toString() : "";
    }
}
