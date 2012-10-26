package com.baidu.location;
/* loaded from: classes.dex */
public final class LocationClientOption {
    public static final int GpsFirst = 1;
    public static final int MIN_SCAN_SPAN = 1000;
    public static final int NetWorkFirst = 2;
    protected int a;

    /* renamed from: byte  reason: not valid java name */
    protected String f40byte;

    /* renamed from: case  reason: not valid java name */
    protected boolean f41case;

    /* renamed from: char  reason: not valid java name */
    protected String f42char;

    /* renamed from: do  reason: not valid java name */
    protected float f43do;

    /* renamed from: else  reason: not valid java name */
    protected boolean f44else;

    /* renamed from: for  reason: not valid java name */
    protected boolean f45for;

    /* renamed from: goto  reason: not valid java name */
    protected int f46goto;

    /* renamed from: if  reason: not valid java name */
    protected boolean f47if;

    /* renamed from: int  reason: not valid java name */
    protected int f48int;

    /* renamed from: long  reason: not valid java name */
    protected int f49long;

    /* renamed from: new  reason: not valid java name */
    protected String f50new;

    /* renamed from: try  reason: not valid java name */
    protected String f51try;

    /* renamed from: void  reason: not valid java name */
    protected boolean f52void;

    public LocationClientOption() {
        this.f51try = "gcj02";
        this.f42char = "detail";
        this.f41case = false;
        this.f48int = 0;
        this.f49long = 12000;
        this.f50new = "SDK2.0";
        this.f46goto = 1;
        this.f52void = false;
        this.f45for = true;
        this.f44else = false;
        this.f47if = false;
        this.f43do = 500.0f;
        this.a = 3;
        this.f40byte = "com.baidu.location.service_v2.6";
    }

    public LocationClientOption(LocationClientOption locationClientOption) {
        this.f51try = "gcj02";
        this.f42char = "detail";
        this.f41case = false;
        this.f48int = 0;
        this.f49long = 12000;
        this.f50new = "SDK2.0";
        this.f46goto = 1;
        this.f52void = false;
        this.f45for = true;
        this.f44else = false;
        this.f47if = false;
        this.f43do = 500.0f;
        this.a = 3;
        this.f40byte = "com.baidu.location.service_v2.6";
        this.f51try = locationClientOption.f51try;
        this.f42char = locationClientOption.f42char;
        this.f41case = locationClientOption.f41case;
        this.f48int = locationClientOption.f48int;
        this.f49long = locationClientOption.f49long;
        this.f50new = locationClientOption.f50new;
        this.f52void = locationClientOption.f52void;
        this.f47if = locationClientOption.f47if;
        this.f43do = locationClientOption.f43do;
        this.a = locationClientOption.a;
        this.f40byte = locationClientOption.f40byte;
        this.f45for = locationClientOption.f45for;
    }

    public void disableCache(boolean z) {
        this.f45for = z;
    }

    public boolean equals(LocationClientOption locationClientOption) {
        return this.f51try.equals(locationClientOption.f51try) && this.f42char.equals(locationClientOption.f42char) && this.f41case == locationClientOption.f41case && this.f48int == locationClientOption.f48int && this.f49long == locationClientOption.f49long && this.f50new.equals(locationClientOption.f50new) && this.f52void == locationClientOption.f52void && this.a == locationClientOption.a && this.f47if == locationClientOption.f47if && this.f43do == locationClientOption.f43do && this.f45for == locationClientOption.f45for;
    }

    public String getAddrType() {
        return this.f42char;
    }

    public String getCoorType() {
        return this.f51try;
    }

    public float getPoiDistance() {
        return this.f43do;
    }

    public boolean getPoiExtranInfo() {
        return this.f47if;
    }

    public int getPoiNumber() {
        return this.a;
    }

    public int getPriority() {
        return this.f46goto;
    }

    public String getProdName() {
        return this.f50new;
    }

    public int getScanSpan() {
        return this.f48int;
    }

    public String getServiceName() {
        return this.f40byte;
    }

    public int getTimeOut() {
        return this.f49long;
    }

    public boolean isDisableCache() {
        return this.f45for;
    }

    public boolean isLocationNotify() {
        return this.f52void;
    }

    public boolean isOpenGps() {
        return this.f41case;
    }

    public boolean isPoiOn() {
        return this.f44else;
    }

    public void setAddrType(String str) {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        this.f42char = str;
    }

    public void setCoorType(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals("gcj02") || lowerCase.equals("bd09") || lowerCase.equals("bd09ll")) {
            this.f51try = lowerCase;
        }
    }

    public void setLocationNotify(boolean z) {
        this.f52void = z;
    }

    public void setOpenGps(boolean z) {
        this.f41case = z;
    }

    public void setPoi(boolean z) {
        this.f44else = z;
    }

    public void setPoiDistance(float f) {
        this.f43do = f;
    }

    public void setPoiExtraInfo(boolean z) {
        this.f47if = z;
    }

    public void setPoiNumber(int i) {
        if (i > 10) {
            i = 10;
        }
        this.a = i;
    }

    public void setPriority(int i) {
        if (i == 1 || i == 2) {
            this.f46goto = i;
        }
    }

    public void setProdName(String str) {
        if (str.length() > 64) {
            str = str.substring(0, 64);
        }
        this.f50new = str;
    }

    public void setScanSpan(int i) {
        this.f48int = i;
    }

    public void setServiceName(String str) {
        this.f40byte = str;
    }

    public void setTimeOut(int i) {
        this.f49long = i;
    }
}
