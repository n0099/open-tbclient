package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import d.b.c.e.p.k;
/* loaded from: classes3.dex */
public class FieldBuilder {
    public static final String EQ = "=";
    public static final String SE = "|";
    public StringBuilder builder;

    public FieldBuilder() {
        this.builder = null;
        this.builder = null;
    }

    public void append(String str, Object obj) {
        if (k.isEmpty(str) || obj == null) {
            return;
        }
        try {
            if (this.builder == null) {
                StringBuilder sb = new StringBuilder();
                this.builder = sb;
                sb.append(str);
                this.builder.append("=");
                this.builder.append(obj.toString());
            } else {
                this.builder.append(SE);
                this.builder.append(str);
                this.builder.append("=");
                this.builder.append(obj.toString());
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void merge(FieldBuilder fieldBuilder) {
        if (fieldBuilder == null) {
            return;
        }
        StringBuilder sb = this.builder;
        if (sb == null) {
            StringBuilder sb2 = new StringBuilder();
            this.builder = sb2;
            sb2.append(fieldBuilder.toString());
            return;
        }
        sb.append(SE);
        this.builder.append(fieldBuilder.toString());
    }

    public String toString() {
        StringBuilder sb = this.builder;
        return sb != null ? sb.toString() : "";
    }
}
