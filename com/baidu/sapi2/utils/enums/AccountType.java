package com.baidu.sapi2.utils.enums;
/* loaded from: classes15.dex */
public enum AccountType {
    NORMAL(0),
    INCOMPLETE_USER(1),
    UNKNOWN(2);
    

    /* renamed from: a  reason: collision with root package name */
    private int f5112a;

    AccountType(int i) {
        this.f5112a = i;
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
        return this.f5112a;
    }
}
