package com.alibaba.fastjson.asm;
/* loaded from: classes.dex */
public class MethodCollector {
    public boolean debugInfoPresent;
    public final int ignoreCount;
    public final int paramCount;
    public final StringBuilder result = new StringBuilder();
    public int currentParameter = 0;

    public MethodCollector(int i2, int i3) {
        this.ignoreCount = i2;
        this.paramCount = i3;
        this.debugInfoPresent = i3 == 0;
    }

    public String getResult() {
        return this.result.length() != 0 ? this.result.substring(1) : "";
    }

    public void visitLocalVariable(String str, int i2) {
        int i3 = this.ignoreCount;
        if (i2 < i3 || i2 >= i3 + this.paramCount) {
            return;
        }
        if (!str.equals("arg" + this.currentParameter)) {
            this.debugInfoPresent = true;
        }
        this.result.append(',');
        this.result.append(str);
        this.currentParameter++;
    }
}
