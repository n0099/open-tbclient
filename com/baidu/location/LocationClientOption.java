package com.baidu.location;
/* loaded from: classes.dex */
public final class LocationClientOption {
    public static final int MIN_SCAN_SPAN = 1000;
    public static final int MIN_SCAN_SPAN_NETWORK = 3000;

    /* renamed from: byte  reason: not valid java name */
    protected static final int f13byte = 1;

    /* renamed from: try  reason: not valid java name */
    protected static final int f14try = 3;

    /* renamed from: void  reason: not valid java name */
    protected static final int f15void = 2;
    protected boolean a;
    protected boolean b;
    protected float c;

    /* renamed from: case  reason: not valid java name */
    protected String f16case;

    /* renamed from: char  reason: not valid java name */
    protected boolean f17char;
    protected int d;

    /* renamed from: do  reason: not valid java name */
    protected String f18do;
    protected boolean e;

    /* renamed from: else  reason: not valid java name */
    protected String f19else;
    protected LocationMode f;

    /* renamed from: for  reason: not valid java name */
    protected boolean f20for;
    protected boolean g;

    /* renamed from: goto  reason: not valid java name */
    protected boolean f21goto;
    protected int h;

    /* renamed from: if  reason: not valid java name */
    protected String f22if;

    /* renamed from: int  reason: not valid java name */
    protected int f23int;

    /* renamed from: long  reason: not valid java name */
    protected int f24long;

    /* renamed from: new  reason: not valid java name */
    protected boolean f25new;

    /* loaded from: classes.dex */
    public enum LocationMode {
        Hight_Accuracy,
        Battery_Saving,
        Device_Sensors
    }

    public LocationClientOption() {
        this.f18do = BDGeofence.COORD_TYPE_GCJ;
        this.f19else = "detail";
        this.f20for = false;
        this.f23int = 0;
        this.d = a0.F;
        this.f22if = "SDK2.0";
        this.h = 1;
        this.f21goto = false;
        this.a = true;
        this.f25new = false;
        this.e = false;
        this.c = 500.0f;
        this.f24long = 3;
        this.f16case = "com.baidu.location.service_v2.9";
        this.b = false;
        this.f17char = false;
        this.g = false;
    }

    public LocationClientOption(LocationClientOption locationClientOption) {
        this.f18do = BDGeofence.COORD_TYPE_GCJ;
        this.f19else = "detail";
        this.f20for = false;
        this.f23int = 0;
        this.d = a0.F;
        this.f22if = "SDK2.0";
        this.h = 1;
        this.f21goto = false;
        this.a = true;
        this.f25new = false;
        this.e = false;
        this.c = 500.0f;
        this.f24long = 3;
        this.f16case = "com.baidu.location.service_v2.9";
        this.b = false;
        this.f17char = false;
        this.g = false;
        this.f18do = locationClientOption.f18do;
        this.f19else = locationClientOption.f19else;
        this.f20for = locationClientOption.f20for;
        this.f23int = locationClientOption.f23int;
        this.d = locationClientOption.d;
        this.f22if = locationClientOption.f22if;
        this.h = locationClientOption.h;
        this.f21goto = locationClientOption.f21goto;
        this.e = locationClientOption.e;
        this.c = locationClientOption.c;
        this.f24long = locationClientOption.f24long;
        this.f16case = locationClientOption.f16case;
        this.a = locationClientOption.a;
        this.b = locationClientOption.b;
        this.f17char = locationClientOption.f17char;
        this.g = locationClientOption.g;
        this.f = locationClientOption.f;
    }

    public void SetIgnoreCacheException(boolean z) {
        this.b = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a() {
        return this.a;
    }

    public boolean equals(LocationClientOption locationClientOption) {
        return this.f18do.equals(locationClientOption.f18do) && this.f19else.equals(locationClientOption.f19else) && this.f20for == locationClientOption.f20for && this.f23int == locationClientOption.f23int && this.d == locationClientOption.d && this.f22if.equals(locationClientOption.f22if) && this.f21goto == locationClientOption.f21goto && this.h == locationClientOption.h && this.f24long == locationClientOption.f24long && this.e == locationClientOption.e && this.c == locationClientOption.c && this.a == locationClientOption.a && this.b == locationClientOption.b && this.f17char == locationClientOption.f17char && this.g == locationClientOption.g && this.f == locationClientOption.f;
    }

    public String getAddrType() {
        return this.f19else;
    }

    public String getCoorType() {
        return this.f18do;
    }

    public LocationMode getLocationMode() {
        return this.f;
    }

    public String getProdName() {
        return this.f22if;
    }

    public int getScanSpan() {
        return this.f23int;
    }

    public int getTimeOut() {
        return this.d;
    }

    public boolean isLocationNotify() {
        return this.f21goto;
    }

    public boolean isOpenGps() {
        return this.f20for;
    }

    public void setAddrType(String str) {
        this.f19else = str;
        if ("all".equals(this.f19else)) {
            setIsNeedAddress(true);
        } else {
            setIsNeedAddress(false);
        }
    }

    public void setCoorType(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals(BDGeofence.COORD_TYPE_GCJ) || lowerCase.equals(BDGeofence.COORD_TYPE_BD09) || lowerCase.equals(BDGeofence.COORD_TYPE_BD09LL)) {
            this.f18do = lowerCase;
        }
    }

    public void setIgnoreKillProcess(boolean z) {
        this.f17char = z;
    }

    public void setIsNeedAddress(boolean z) {
        if (z) {
            this.f19else = "all";
        } else {
            this.f19else = "noaddr";
        }
    }

    public void setLocationMode(LocationMode locationMode) {
        switch (locationMode) {
            case Hight_Accuracy:
                this.f20for = true;
                break;
            case Battery_Saving:
                this.f20for = false;
                break;
            case Device_Sensors:
                this.h = 3;
                this.f20for = true;
                break;
            default:
                throw new IllegalArgumentException("Illegal this mode : " + locationMode);
        }
        this.f = locationMode;
    }

    public void setLocationNotify(boolean z) {
        this.f21goto = z;
    }

    public void setNeedDeviceDirect(boolean z) {
        this.g = z;
    }

    public void setOpenGps(boolean z) {
        this.f20for = z;
    }

    public void setProdName(String str) {
        if (str.length() > 64) {
            str = str.substring(0, 64);
        }
        this.f22if = str;
    }

    public void setScanSpan(int i) {
        this.f23int = i;
    }

    public void setTimeOut(int i) {
        this.d = i;
    }
}
