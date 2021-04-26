package com.baidu.pass.ecommerce.view.addressdialog;
/* loaded from: classes2.dex */
public enum AddressLevel {
    COUNTRY(0, "country"),
    PROVINCE(1, "province"),
    CITY(2, "city"),
    DISTRICT(3, "county"),
    TOWN(4, "town");
    
    public String name;
    public int value;

    AddressLevel(int i2, String str) {
        this.value = i2;
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }
}
