package com.baidu.sapi2.utils.enums;
/* loaded from: classes.dex */
public enum AccountType {
    NORMAL(0),
    INCOMPLETE_USER(1),
    UNKNOWN(2);
    
    private int a;

    AccountType(int i) {
        this.a = i;
    }

    public int getType() {
        return this.a;
    }

    public static AccountType getAccountType(int i) {
        switch (i) {
            case 0:
                return NORMAL;
            case 1:
                return INCOMPLETE_USER;
            default:
                return UNKNOWN;
        }
    }
}
