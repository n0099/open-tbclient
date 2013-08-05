package com.baidu.location;
/* loaded from: classes.dex */
public final class LocationClientOption {
    public static final int GpsFirst = 1;
    public static final int MIN_SCAN_SPAN = 1000;
    public static final int NetWorkFirst = 2;

    /* renamed from: a  reason: collision with root package name */
    protected int f729a;

    /* renamed from: byte  reason: not valid java name */
    protected String f77byte;

    /* renamed from: case  reason: not valid java name */
    protected boolean f78case;

    /* renamed from: char  reason: not valid java name */
    protected String f79char;

    /* renamed from: do  reason: not valid java name */
    protected float f80do;

    /* renamed from: else  reason: not valid java name */
    protected boolean f81else;

    /* renamed from: for  reason: not valid java name */
    protected boolean f82for;

    /* renamed from: goto  reason: not valid java name */
    protected int f83goto;

    /* renamed from: if  reason: not valid java name */
    protected boolean f84if;

    /* renamed from: int  reason: not valid java name */
    protected int f85int;

    /* renamed from: long  reason: not valid java name */
    protected int f86long;

    /* renamed from: new  reason: not valid java name */
    protected String f87new;

    /* renamed from: try  reason: not valid java name */
    protected String f88try;

    /* renamed from: void  reason: not valid java name */
    protected boolean f89void;

    public LocationClientOption() {
        this.f88try = "gcj02";
        this.f79char = "detail";
        this.f78case = false;
        this.f85int = 0;
        this.f86long = 12000;
        this.f87new = "SDK2.0";
        this.f83goto = 1;
        this.f89void = false;
        this.f82for = true;
        this.f81else = false;
        this.f84if = false;
        this.f80do = 500.0f;
        this.f729a = 3;
        this.f77byte = "com.baidu.location.service_v2.9";
    }

    public LocationClientOption(LocationClientOption locationClientOption) {
        this.f88try = "gcj02";
        this.f79char = "detail";
        this.f78case = false;
        this.f85int = 0;
        this.f86long = 12000;
        this.f87new = "SDK2.0";
        this.f83goto = 1;
        this.f89void = false;
        this.f82for = true;
        this.f81else = false;
        this.f84if = false;
        this.f80do = 500.0f;
        this.f729a = 3;
        this.f77byte = "com.baidu.location.service_v2.9";
        this.f88try = locationClientOption.f88try;
        this.f79char = locationClientOption.f79char;
        this.f78case = locationClientOption.f78case;
        this.f85int = locationClientOption.f85int;
        this.f86long = locationClientOption.f86long;
        this.f87new = locationClientOption.f87new;
        this.f83goto = locationClientOption.f83goto;
        this.f89void = locationClientOption.f89void;
        this.f84if = locationClientOption.f84if;
        this.f80do = locationClientOption.f80do;
        this.f729a = locationClientOption.f729a;
        this.f77byte = locationClientOption.f77byte;
        this.f82for = locationClientOption.f82for;
    }

    public void disableCache(boolean z) {
        this.f82for = z;
    }

    public boolean equals(LocationClientOption locationClientOption) {
        return this.f88try.equals(locationClientOption.f88try) && this.f79char.equals(locationClientOption.f79char) && this.f78case == locationClientOption.f78case && this.f85int == locationClientOption.f85int && this.f86long == locationClientOption.f86long && this.f87new.equals(locationClientOption.f87new) && this.f89void == locationClientOption.f89void && this.f83goto == locationClientOption.f83goto && this.f729a == locationClientOption.f729a && this.f84if == locationClientOption.f84if && this.f80do == locationClientOption.f80do && this.f82for == locationClientOption.f82for;
    }

    public String getAddrType() {
        return this.f79char;
    }

    public String getCoorType() {
        return this.f88try;
    }

    public float getPoiDistance() {
        return this.f80do;
    }

    public boolean getPoiExtranInfo() {
        return this.f84if;
    }

    public int getPoiNumber() {
        return this.f729a;
    }

    public int getPriority() {
        return this.f83goto;
    }

    public String getProdName() {
        return this.f87new;
    }

    public int getScanSpan() {
        return this.f85int;
    }

    public String getServiceName() {
        return this.f77byte;
    }

    public int getTimeOut() {
        return this.f86long;
    }

    public boolean isDisableCache() {
        return this.f82for;
    }

    public boolean isLocationNotify() {
        return this.f89void;
    }

    public boolean isOpenGps() {
        return this.f78case;
    }

    public void setAddrType(String str) {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        this.f79char = str;
    }

    public void setCoorType(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals("gcj02") || lowerCase.equals("bd09") || lowerCase.equals("bd09ll")) {
            this.f88try = lowerCase;
        }
    }

    public void setLocationNotify(boolean z) {
        this.f89void = z;
    }

    public void setOpenGps(boolean z) {
        this.f78case = z;
    }

    public void setPoiDistance(float f) {
        this.f80do = f;
    }

    public void setPoiExtraInfo(boolean z) {
        this.f84if = z;
    }

    public void setPoiNumber(int i) {
        if (i > 10) {
            i = 10;
        }
        this.f729a = i;
    }

    public void setPriority(int i) {
        if (i == 1 || i == 2) {
            this.f83goto = i;
        }
    }

    public void setProdName(String str) {
        if (str.length() > 64) {
            str = str.substring(0, 64);
        }
        this.f87new = str;
    }

    public void setScanSpan(int i) {
        this.f85int = i;
    }

    public void setServiceName(String str) {
        this.f77byte = str;
    }

    public void setTimeOut(int i) {
        this.f86long = i;
    }
}
