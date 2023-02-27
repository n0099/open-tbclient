package com.baidu.sapi2.utils.enums;
/* loaded from: classes2.dex */
public enum AccountType {
    NORMAL(0),
    INCOMPLETE_USER(1),
    UNKNOWN(2);
    
    public int type;

    public int getType() {
        return this.type;
    }

    AccountType(int i) {
        this.type = i;
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
}
