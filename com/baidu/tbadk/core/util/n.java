package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class n {
    private StringBuilder Tk;

    public n() {
        this.Tk = null;
        this.Tk = null;
    }

    public void h(String str, Object obj) {
        if (!bd.isEmpty(str) && obj != null) {
            try {
                if (this.Tk == null) {
                    this.Tk = new StringBuilder();
                    this.Tk.append(str);
                    this.Tk.append("=");
                    this.Tk.append(obj.toString());
                } else {
                    this.Tk.append("|");
                    this.Tk.append(str);
                    this.Tk.append("=");
                    this.Tk.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toString() {
        return this.Tk != null ? this.Tk.toString() : "";
    }
}
