package com.baidu.swan.apps.binding.model;
/* loaded from: classes2.dex */
public class JSTypeMismatchException extends Exception {
    public int actualType;
    public Object name;
    public int requiredType;

    public JSTypeMismatchException(String str, int i2, int i3, String str2) {
        super(str2);
        this.name = str;
        this.actualType = i2;
        this.requiredType = i3;
    }
}
