package com.baidu.location;

import com.baidu.channelrtc.medialivesender.LiveSenderControl;
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
        this.f50long = LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_12;
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
        this.f50long = LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_12;
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

    public void disableCache(boolean z) {
        this.f46for = z;
    }

    public boolean equals(LocationClientOption locationClientOption) {
        return this.f52try.equals(locationClientOption.f52try) && this.f43char.equals(locationClientOption.f43char) && this.f42case == locationClientOption.f42case && this.f49int == locationClientOption.f49int && this.f50long == locationClientOption.f50long && this.f51new.equals(locationClientOption.f51new) && this.f53void == locationClientOption.f53void && this.f47goto == locationClientOption.f47goto && this.a == locationClientOption.a && this.f48if == locationClientOption.f48if && this.f44do == locationClientOption.f44do && this.f46for == locationClientOption.f46for;
    }

    public String getAddrType() {
        return this.f43char;
    }

    public String getCoorType() {
        return this.f52try;
    }

    public float getPoiDistance() {
        return this.f44do;
    }

    public boolean getPoiExtranInfo() {
        return this.f48if;
    }

    public int getPoiNumber() {
        return this.a;
    }

    public int getPriority() {
        return this.f47goto;
    }

    public String getProdName() {
        return this.f51new;
    }

    public int getScanSpan() {
        return this.f49int;
    }

    public String getServiceName() {
        return this.f41byte;
    }

    public int getTimeOut() {
        return this.f50long;
    }

    public boolean isDisableCache() {
        return this.f46for;
    }

    public boolean isLocationNotify() {
        return this.f53void;
    }

    public boolean isOpenGps() {
        return this.f42case;
    }

    public void setAddrType(String str) {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        this.f43char = str;
    }

    public void setCoorType(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals("gcj02") || lowerCase.equals("bd09") || lowerCase.equals("bd09ll")) {
            this.f52try = lowerCase;
        }
    }

    public void setLocationNotify(boolean z) {
        this.f53void = z;
    }

    public void setOpenGps(boolean z) {
        this.f42case = z;
    }

    public void setPoiDistance(float f) {
        this.f44do = f;
    }

    public void setPoiExtraInfo(boolean z) {
        this.f48if = z;
    }

    public void setPoiNumber(int i) {
        if (i > 10) {
            i = 10;
        }
        this.a = i;
    }

    public void setPriority(int i) {
        if (i == 1 || i == 2) {
            this.f47goto = i;
        }
    }

    public void setProdName(String str) {
        if (str.length() > 64) {
            str = str.substring(0, 64);
        }
        this.f51new = str;
    }

    public void setScanSpan(int i) {
        this.f49int = i;
    }

    public void setServiceName(String str) {
        this.f41byte = str;
    }

    public void setTimeOut(int i) {
        this.f50long = i;
    }
}
