package com.baidu.swan.apps.binding.model;
/* loaded from: classes3.dex */
public class JSTypeMismatchException extends Exception {
    public int actualType;
    public Object name;
    public int requiredType;

    public JSTypeMismatchException(String str, int i, int i2, String str2) {
        super(str2);
        this.name = str;
        this.actualType = i;
        this.requiredType = i2;
    }
}
