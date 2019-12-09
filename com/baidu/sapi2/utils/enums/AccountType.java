package com.baidu.sapi2.utils.enums;
/* loaded from: classes2.dex */
public enum AccountType {
    NORMAL(0),
    INCOMPLETE_USER(1),
    UNKNOWN(2);
    
    private int b;

    AccountType(int i) {
        this.b = i;
    }

    public static AccountType getAccountType(int i) {
        if (i != 0) {
            if (i != 1) {
                return UNKNOWN;
            }
            return INCOMPLETE_USER;
        }
        return NORMAL;
    }

    public int getType() {
        return this.b;
    }
}
