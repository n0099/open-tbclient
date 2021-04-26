package com.baidu.sapi2.utils.enums;
/* loaded from: classes2.dex */
public enum AccountType {
    NORMAL(0),
    INCOMPLETE_USER(1),
    UNKNOWN(2);
    
    public int type;

    AccountType(int i2) {
        this.type = i2;
    }

    public static AccountType getAccountType(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                return UNKNOWN;
            }
            return INCOMPLETE_USER;
        }
        return NORMAL;
    }

    public int getType() {
        return this.type;
    }
}
