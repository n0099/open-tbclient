package com.baidu.loginshare;
/* loaded from: classes.dex */
public enum LoginShareEvent {
    VALID,
    INVALID;

    /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
    public static LoginShareEvent[] a() {
        LoginShareEvent[] values = values();
        int length = values.length;
        LoginShareEvent[] loginShareEventArr = new LoginShareEvent[length];
        System.arraycopy(values, 0, loginShareEventArr, 0, length);
        return loginShareEventArr;
    }
}
