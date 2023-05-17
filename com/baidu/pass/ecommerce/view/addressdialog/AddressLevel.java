package com.baidu.pass.ecommerce.view.addressdialog;
/* loaded from: classes3.dex */
public enum AddressLevel {
    COUNTRY(0, "country"),
    PROVINCE(1, "province"),
    CITY(2, "city"),
    DISTRICT(3, "county"),
    TOWN(4, "town");
    
    public String name;
    public int value;

    AddressLevel(int i, String str) {
        this.value = i;
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }
}
