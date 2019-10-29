package com.baidu.live.tbadk.core.util;

import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes6.dex */
public class FieldBuilder {
    private static final String EQ = "=";
    private static final String SE = "|";
    private StringBuilder builder;

    public FieldBuilder() {
        this.builder = null;
        this.builder = null;
    }

    public void append(String str, Object obj) {
        if (!StringHelper.isEmpty(str) && obj != null) {
            try {
                if (this.builder == null) {
                    this.builder = new StringBuilder();
                    this.builder.append(str);
                    this.builder.append(EQ);
                    this.builder.append(obj.toString());
                } else {
                    this.builder.append(SE);
                    this.builder.append(str);
                    this.builder.append(EQ);
                    this.builder.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void merge(FieldBuilder fieldBuilder) {
        if (fieldBuilder != null) {
            if (this.builder == null) {
                this.builder = new StringBuilder();
                this.builder.append(fieldBuilder.toString());
                return;
            }
            this.builder.append(SE);
            this.builder.append(fieldBuilder.toString());
        }
    }

    public String toString() {
        return this.builder != null ? this.builder.toString() : "";
    }
}
