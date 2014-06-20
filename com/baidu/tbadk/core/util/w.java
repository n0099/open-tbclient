package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class w {
    private StringBuilder a;

    public w() {
        this.a = null;
        this.a = null;
    }

    public void a(String str, Object obj) {
        if (!bg.c(str) && obj != null) {
            try {
                if (this.a == null) {
                    this.a = new StringBuilder();
                    this.a.append(str);
                    this.a.append("=");
                    this.a.append(obj.toString());
                } else {
                    this.a.append("|");
                    this.a.append(str);
                    this.a.append("=");
                    this.a.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e("FieldBuilder", "append", e.getMessage());
            }
        }
    }

    public String toString() {
        return this.a != null ? this.a.toString() : "";
    }
}
