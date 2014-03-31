package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public final class v {
    private StringBuilder a;

    public v() {
        this.a = null;
        this.a = null;
    }

    public final void a(String str, Object obj) {
        if (!bc.c(str) && obj != null) {
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
                com.baidu.adp.lib.util.f.b("FieldBuilder", "append", e.getMessage());
            }
        }
    }

    public final void a(v vVar) {
        if (vVar != null) {
            if (this.a == null) {
                this.a = new StringBuilder();
                this.a.append(vVar.toString());
                return;
            }
            this.a.append("|");
            this.a.append(vVar.toString());
        }
    }

    public final String toString() {
        return this.a != null ? this.a.toString() : "";
    }
}
