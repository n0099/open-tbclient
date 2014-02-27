package com.baidu.location;
/* loaded from: classes.dex */
public final class LocationClientOption {
    public static final int GpsFirst = 1;
    public static final int MIN_SCAN_SPAN = 1000;
    public static final int NetWorkFirst = 2;
    protected int a;

    /* renamed from: byte  reason: not valid java name */
    protected String f41byte;

    /* renamed from: case  reason: not valid java name */
    protected boolean f42case;

    /* renamed from: char  reason: not valid java name */
    protected String f43char;

    /* renamed from: do  reason: not valid java name */
    protected float f44do;

    /* renamed from: else  reason: not valid java name */
    protected boolean f45else;

    /* renamed from: for  reason: not valid java name */
    protected boolean f46for;

    /* renamed from: goto  reason: not valid java name */
    protected int f47goto;

    /* renamed from: if  reason: not valid java name */
    protected boolean f48if;

    /* renamed from: int  reason: not valid java name */
    protected int f49int;

    /* renamed from: long  reason: not valid java name */
    protected int f50long;

    /* renamed from: new  reason: not valid java name */
    protected String f51new;

    /* renamed from: try  reason: not valid java name */
    protected String f52try;

    /* renamed from: void  reason: not valid java name */
    protected boolean f53void;

    public LocationClientOption() {
        this.f52try = "gcj02";
        this.f43char = "detail";
        this.f42case = false;
        this.f49int = 0;
        this.f50long = 12000;
        this.f51new = "SDK2.0";
        this.f47goto = 1;
        this.f53void = false;
        this.f46for = true;
        this.f45else = false;
        this.f48if = false;
        this.f44do = 500.0f;
        this.a = 3;
        this.f41byte = "com.baidu.location.service_v2.9";
    }

    public LocationClientOption(LocationClientOption locationClientOption) {
        this.f52try = "gcj02";
        this.f43char = "detail";
        this.f42case = false;
        this.f49int = 0;
        this.f50long = 12000;
        this.f51new = "SDK2.0";
        this.f47goto = 1;
        this.f53void = false;
        this.f46for = true;
        this.f45else = false;
        this.f48if = false;
        this.f44do = 500.0f;
        this.a = 3;
        this.f41byte = "com.baidu.location.service_v2.9";
        this.f52try = locationClientOption.f52try;
        this.f43char = locationClientOption.f43char;
        this.f42case = locationClientOption.f42case;
        this.f49int = locationClientOption.f49int;
        this.f50long = locationClientOption.f50long;
        this.f51new = locationClientOption.f51new;
        this.f47goto = locationClientOption.f47goto;
        this.f53void = locationClientOption.f53void;
        this.f48if = locationClientOption.f48if;
        this.f44do = locationClientOption.f44do;
        this.a = locationClientOption.a;
        this.f41byte = locationClientOption.f41byte;
        this.f46for = locationClientOption.f46for;
    }

    public final void disableCache(boolean z) {
        this.f46for = z;
    }

    public final boolean equals(LocationClientOption locationClientOption) {
        return this.f52try.equals(locationClientOption.f52try) && this.f43char.equals(locationClientOption.f43char) && this.f42case == locationClientOption.f42case && this.f49int == locationClientOption.f49int && this.f50long == locationClientOption.f50long && this.f51new.equals(locationClientOption.f51new) && this.f53void == locationClientOption.f53void && this.f47goto == locationClientOption.f47goto && this.a == locationClientOption.a && this.f48if == locationClientOption.f48if && this.f44do == locationClientOption.f44do && this.f46for == locationClientOption.f46for;
    }

    public final String getAddrType() {
        return this.f43char;
    }

    public final String getCoorType() {
        return this.f52try;
    }

    public final float getPoiDistance() {
        return this.f44do;
    }

    public final boolean getPoiExtranInfo() {
        return this.f48if;
    }

    public final int getPoiNumber() {
        return this.a;
    }

    public final int getPriority() {
        return this.f47goto;
    }

    public final String getProdName() {
        return this.f51new;
    }

    public final int getScanSpan() {
        return this.f49int;
    }

    public final String getServiceName() {
        return this.f41byte;
    }

    public final int getTimeOut() {
        return this.f50long;
    }

    public final boolean isDisableCache() {
        return this.f46for;
    }

    public final boolean isLocationNotify() {
        return this.f53void;
    }

    public final boolean isOpenGps() {
        return this.f42case;
    }

    public final void setAddrType(String str) {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        this.f43char = str;
    }

    public final void setCoorType(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals("gcj02") || lowerCase.equals("bd09") || lowerCase.equals("bd09ll")) {
            this.f52try = lowerCase;
        }
    }

    public final void setLocationNotify(boolean z) {
        this.f53void = z;
    }

    public final void setOpenGps(boolean z) {
        this.f42case = z;
    }

    public final void setPoiDistance(float f) {
        this.f44do = f;
    }

    public final void setPoiExtraInfo(boolean z) {
        this.f48if = z;
    }

    public final void setPoiNumber(int i) {
        if (i > 10) {
            i = 10;
        }
        this.a = i;
    }

    public final void setPriority(int i) {
        if (i == 1 || i == 2) {
            this.f47goto = i;
        }
    }

    public final void setProdName(String str) {
        if (str.length() > 64) {
            str = str.substring(0, 64);
        }
        this.f51new = str;
    }

    public final void setScanSpan(int i) {
        this.f49int = i;
    }

    public final void setServiceName(String str) {
        this.f41byte = str;
    }

    public final void setTimeOut(int i) {
        this.f50long = i;
    }
}
