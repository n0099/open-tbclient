package com.baidu.location;

import com.baidu.android.pushservice.PushConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class BDLocation {
    public static final int TypeCacheLocation = 65;
    public static final int TypeCriteriaException = 62;
    public static final int TypeGpsLocation = 61;
    public static final int TypeNetWorkException = 63;
    public static final int TypeNetWorkLocation = 161;
    public static final int TypeNone = 0;
    public static final int TypeOffLineLocation = 66;
    public static final int TypeOffLineLocationFail = 67;
    public static final int TypeOffLineLocationNetworkFail = 68;
    public static final int TypeServerError = 167;
    private String a;
    private boolean b;

    /* renamed from: byte  reason: not valid java name */
    private String f0byte;
    private boolean c;

    /* renamed from: case  reason: not valid java name */
    private boolean f1case;

    /* renamed from: char  reason: not valid java name */
    private float f2char;
    private String d;

    /* renamed from: do  reason: not valid java name */
    private int f3do;
    private boolean e;

    /* renamed from: else  reason: not valid java name */
    private double f4else;
    private double f;

    /* renamed from: for  reason: not valid java name */
    private double f5for;

    /* renamed from: goto  reason: not valid java name */
    private String f6goto;

    /* renamed from: if  reason: not valid java name */
    private int f7if;

    /* renamed from: int  reason: not valid java name */
    private boolean f8int;

    /* renamed from: long  reason: not valid java name */
    private float f9long;
    public a mAddr;
    public String mServerString;

    /* renamed from: new  reason: not valid java name */
    private float f10new;

    /* renamed from: try  reason: not valid java name */
    private boolean f11try;

    /* renamed from: void  reason: not valid java name */
    private boolean f12void;

    /* loaded from: classes.dex */
    public class a {

        /* renamed from: if  reason: not valid java name */
        public String f16if = null;

        /* renamed from: new  reason: not valid java name */
        public String f18new = null;

        /* renamed from: int  reason: not valid java name */
        public String f17int = null;

        /* renamed from: byte  reason: not valid java name */
        public String f13byte = null;

        /* renamed from: do  reason: not valid java name */
        public String f14do = null;

        /* renamed from: for  reason: not valid java name */
        public String f15for = null;

        /* renamed from: try  reason: not valid java name */
        public String f19try = null;

        public a() {
        }
    }

    public BDLocation() {
        this.f7if = 0;
        this.d = null;
        this.f4else = Double.MIN_VALUE;
        this.f5for = Double.MIN_VALUE;
        this.c = false;
        this.f = Double.MIN_VALUE;
        this.f8int = false;
        this.f10new = 0.0f;
        this.f11try = false;
        this.f9long = 0.0f;
        this.b = false;
        this.f3do = -1;
        this.f2char = -1.0f;
        this.f6goto = null;
        this.f0byte = null;
        this.f12void = false;
        this.f1case = false;
        this.a = null;
        this.mServerString = null;
        this.e = false;
        this.mAddr = new a();
    }

    public BDLocation(double d, double d2, float f) {
        this.f7if = 0;
        this.d = null;
        this.f4else = Double.MIN_VALUE;
        this.f5for = Double.MIN_VALUE;
        this.c = false;
        this.f = Double.MIN_VALUE;
        this.f8int = false;
        this.f10new = 0.0f;
        this.f11try = false;
        this.f9long = 0.0f;
        this.b = false;
        this.f3do = -1;
        this.f2char = -1.0f;
        this.f6goto = null;
        this.f0byte = null;
        this.f12void = false;
        this.f1case = false;
        this.a = null;
        this.mServerString = null;
        this.e = false;
        this.mAddr = new a();
        this.f4else = d2;
        this.f5for = d;
        this.f9long = f;
        this.d = j.a();
    }

    public BDLocation(String str) {
        String str2;
        this.f7if = 0;
        this.d = null;
        this.f4else = Double.MIN_VALUE;
        this.f5for = Double.MIN_VALUE;
        this.c = false;
        this.f = Double.MIN_VALUE;
        this.f8int = false;
        this.f10new = 0.0f;
        this.f11try = false;
        this.f9long = 0.0f;
        this.b = false;
        this.f3do = -1;
        this.f2char = -1.0f;
        this.f6goto = null;
        this.f0byte = null;
        this.f12void = false;
        this.f1case = false;
        this.a = null;
        this.mServerString = null;
        this.e = false;
        this.mAddr = new a();
        if (str == null || str.equals("")) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("result");
            int parseInt = Integer.parseInt(jSONObject2.getString("error"));
            setLocType(parseInt);
            setTime(jSONObject2.getString("time"));
            if (parseInt == 61) {
                JSONObject jSONObject3 = jSONObject.getJSONObject(PushConstants.EXTRA_CONTENT);
                JSONObject jSONObject4 = jSONObject3.getJSONObject("point");
                setLatitude(Double.parseDouble(jSONObject4.getString("y")));
                setLongitude(Double.parseDouble(jSONObject4.getString("x")));
                setRadius(Float.parseFloat(jSONObject3.getString("radius")));
                setSpeed(Float.parseFloat(jSONObject3.getString("s")));
                setDerect(Float.parseFloat(jSONObject3.getString("d")));
                setSatelliteNumber(Integer.parseInt(jSONObject3.getString("n")));
            } else if (parseInt != 161) {
                if (parseInt == 66 || parseInt == 68) {
                    JSONObject jSONObject5 = jSONObject.getJSONObject(PushConstants.EXTRA_CONTENT);
                    JSONObject jSONObject6 = jSONObject5.getJSONObject("point");
                    setLatitude(Double.parseDouble(jSONObject6.getString("y")));
                    setLongitude(Double.parseDouble(jSONObject6.getString("x")));
                    setRadius(Float.parseFloat(jSONObject5.getString("radius")));
                    a(Boolean.valueOf(Boolean.parseBoolean(jSONObject5.getString("isCellChanged"))));
                }
            } else {
                JSONObject jSONObject7 = jSONObject.getJSONObject(PushConstants.EXTRA_CONTENT);
                JSONObject jSONObject8 = jSONObject7.getJSONObject("point");
                setLatitude(Double.parseDouble(jSONObject8.getString("y")));
                setLongitude(Double.parseDouble(jSONObject8.getString("x")));
                setRadius(Float.parseFloat(jSONObject7.getString("radius")));
                if (jSONObject7.has("addr")) {
                    String string = jSONObject7.getString("addr");
                    this.mAddr.f19try = string;
                    j.a(f.v, string);
                    String[] split = string.split(",");
                    this.mAddr.f16if = split[0];
                    this.mAddr.f18new = split[1];
                    this.mAddr.f17int = split[2];
                    this.mAddr.f13byte = split[3];
                    this.mAddr.f14do = split[4];
                    this.mAddr.f15for = split[5];
                    if ((this.mAddr.f16if.contains("北京") && this.mAddr.f18new.contains("北京")) || ((this.mAddr.f16if.contains("上海") && this.mAddr.f18new.contains("上海")) || ((this.mAddr.f16if.contains("天津") && this.mAddr.f18new.contains("天津")) || (this.mAddr.f16if.contains("重庆") && this.mAddr.f18new.contains("重庆"))))) {
                        j.a(f.v, "true,beijing");
                        str2 = this.mAddr.f16if;
                    } else {
                        str2 = this.mAddr.f16if + this.mAddr.f18new;
                    }
                    this.mAddr.f19try = str2 + this.mAddr.f17int + this.mAddr.f13byte + this.mAddr.f14do;
                    this.f12void = true;
                } else {
                    this.f12void = false;
                    setAddrStr(null);
                }
                if (jSONObject7.has("poi")) {
                    this.f1case = true;
                    this.f0byte = jSONObject7.getJSONObject("poi").toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.f7if = 0;
            this.f12void = false;
        }
    }

    public BDLocation(String str, double d, double d2, float f, String str2, String str3) {
        this.f7if = 0;
        this.d = null;
        this.f4else = Double.MIN_VALUE;
        this.f5for = Double.MIN_VALUE;
        this.c = false;
        this.f = Double.MIN_VALUE;
        this.f8int = false;
        this.f10new = 0.0f;
        this.f11try = false;
        this.f9long = 0.0f;
        this.b = false;
        this.f3do = -1;
        this.f2char = -1.0f;
        this.f6goto = null;
        this.f0byte = null;
        this.f12void = false;
        this.f1case = false;
        this.a = null;
        this.mServerString = null;
        this.e = false;
        this.mAddr = new a();
        this.d = str;
        this.f4else = d;
        this.f5for = d2;
        this.f9long = f;
        this.f6goto = str2;
        this.a = str3;
        this.d = j.a();
    }

    private void a(Boolean bool) {
        this.e = bool.booleanValue();
    }

    public String getAddrStr() {
        return this.mAddr.f19try;
    }

    public double getAltitude() {
        return this.f;
    }

    public String getCity() {
        return this.mAddr.f18new;
    }

    public String getCityCode() {
        return this.mAddr.f15for;
    }

    public String getCoorType() {
        return this.f6goto;
    }

    public float getDerect() {
        return this.f2char;
    }

    public String getDistrict() {
        return this.mAddr.f17int;
    }

    public double getLatitude() {
        return this.f4else;
    }

    public int getLocType() {
        return this.f7if;
    }

    public double getLongitude() {
        return this.f5for;
    }

    public String getPoi() {
        return this.f0byte;
    }

    public String getProvince() {
        return this.mAddr.f16if;
    }

    public float getRadius() {
        return this.f9long;
    }

    public int getSatelliteNumber() {
        this.b = true;
        return this.f3do;
    }

    public float getSpeed() {
        return this.f10new;
    }

    public String getStreet() {
        return this.mAddr.f13byte;
    }

    public String getStreetNumber() {
        return this.mAddr.f14do;
    }

    public String getTime() {
        return this.d;
    }

    public boolean hasAddr() {
        return this.f12void;
    }

    public boolean hasAltitude() {
        return this.c;
    }

    public boolean hasPoi() {
        return this.f1case;
    }

    public boolean hasRadius() {
        return this.f11try;
    }

    public boolean hasSateNumber() {
        return this.b;
    }

    public boolean hasSpeed() {
        return this.f8int;
    }

    public boolean isCellChangeFlag() {
        return this.e;
    }

    public void setAddrStr(String str) {
        this.a = str;
        this.f12void = true;
    }

    public void setAltitude(double d) {
        this.f = d;
        this.c = true;
    }

    public void setCoorType(String str) {
        this.f6goto = str;
    }

    public void setDerect(float f) {
        this.f2char = f;
    }

    public void setLatitude(double d) {
        this.f4else = d;
    }

    public void setLocType(int i) {
        this.f7if = i;
    }

    public void setLongitude(double d) {
        this.f5for = d;
    }

    public void setRadius(float f) {
        this.f9long = f;
        this.f11try = true;
    }

    public void setSatelliteNumber(int i) {
        this.f3do = i;
    }

    public void setSpeed(float f) {
        this.f10new = f;
        this.f8int = true;
    }

    public void setTime(String str) {
        this.d = str;
    }

    public String toJsonString() {
        return null;
    }

    public BDLocation toNewLocation(String str) {
        return null;
    }
}
