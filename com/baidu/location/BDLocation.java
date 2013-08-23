package com.baidu.location;

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

    /* renamed from: a  reason: collision with root package name */
    private String f743a;
    private boolean b;

    /* renamed from: byte  reason: not valid java name */
    private String f36byte;
    private boolean c;

    /* renamed from: case  reason: not valid java name */
    private boolean f37case;

    /* renamed from: char  reason: not valid java name */
    private float f38char;
    private String d;

    /* renamed from: do  reason: not valid java name */
    private int f39do;
    private boolean e;

    /* renamed from: else  reason: not valid java name */
    private double f40else;
    private double f;

    /* renamed from: for  reason: not valid java name */
    private double f41for;

    /* renamed from: goto  reason: not valid java name */
    private String f42goto;

    /* renamed from: if  reason: not valid java name */
    private int f43if;

    /* renamed from: int  reason: not valid java name */
    private boolean f44int;

    /* renamed from: long  reason: not valid java name */
    private float f45long;
    public a mAddr;
    public String mServerString;

    /* renamed from: new  reason: not valid java name */
    private float f46new;

    /* renamed from: try  reason: not valid java name */
    private boolean f47try;

    /* renamed from: void  reason: not valid java name */
    private boolean f48void;

    /* loaded from: classes.dex */
    public class a {

        /* renamed from: if  reason: not valid java name */
        public String f52if = null;

        /* renamed from: new  reason: not valid java name */
        public String f54new = null;

        /* renamed from: int  reason: not valid java name */
        public String f53int = null;

        /* renamed from: byte  reason: not valid java name */
        public String f49byte = null;

        /* renamed from: do  reason: not valid java name */
        public String f50do = null;

        /* renamed from: for  reason: not valid java name */
        public String f51for = null;

        /* renamed from: try  reason: not valid java name */
        public String f55try = null;

        public a() {
        }
    }

    public BDLocation() {
        this.f43if = 0;
        this.d = null;
        this.f40else = Double.MIN_VALUE;
        this.f41for = Double.MIN_VALUE;
        this.c = false;
        this.f = Double.MIN_VALUE;
        this.f44int = false;
        this.f46new = 0.0f;
        this.f47try = false;
        this.f45long = 0.0f;
        this.b = false;
        this.f39do = -1;
        this.f38char = -1.0f;
        this.f42goto = null;
        this.f36byte = null;
        this.f48void = false;
        this.f37case = false;
        this.f743a = null;
        this.mServerString = null;
        this.e = false;
        this.mAddr = new a();
    }

    public BDLocation(double d, double d2, float f) {
        this.f43if = 0;
        this.d = null;
        this.f40else = Double.MIN_VALUE;
        this.f41for = Double.MIN_VALUE;
        this.c = false;
        this.f = Double.MIN_VALUE;
        this.f44int = false;
        this.f46new = 0.0f;
        this.f47try = false;
        this.f45long = 0.0f;
        this.b = false;
        this.f39do = -1;
        this.f38char = -1.0f;
        this.f42goto = null;
        this.f36byte = null;
        this.f48void = false;
        this.f37case = false;
        this.f743a = null;
        this.mServerString = null;
        this.e = false;
        this.mAddr = new a();
        this.f40else = d2;
        this.f41for = d;
        this.f45long = f;
        this.d = j.a();
    }

    public BDLocation(String str) {
        String str2;
        this.f43if = 0;
        this.d = null;
        this.f40else = Double.MIN_VALUE;
        this.f41for = Double.MIN_VALUE;
        this.c = false;
        this.f = Double.MIN_VALUE;
        this.f44int = false;
        this.f46new = 0.0f;
        this.f47try = false;
        this.f45long = 0.0f;
        this.b = false;
        this.f39do = -1;
        this.f38char = -1.0f;
        this.f42goto = null;
        this.f36byte = null;
        this.f48void = false;
        this.f37case = false;
        this.f743a = null;
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
                JSONObject jSONObject3 = jSONObject.getJSONObject("content");
                JSONObject jSONObject4 = jSONObject3.getJSONObject("point");
                setLatitude(Double.parseDouble(jSONObject4.getString("y")));
                setLongitude(Double.parseDouble(jSONObject4.getString("x")));
                setRadius(Float.parseFloat(jSONObject3.getString("radius")));
                setSpeed(Float.parseFloat(jSONObject3.getString("s")));
                setDerect(Float.parseFloat(jSONObject3.getString("d")));
                setSatelliteNumber(Integer.parseInt(jSONObject3.getString("n")));
            } else if (parseInt != 161) {
                if (parseInt == 66 || parseInt == 68) {
                    JSONObject jSONObject5 = jSONObject.getJSONObject("content");
                    JSONObject jSONObject6 = jSONObject5.getJSONObject("point");
                    setLatitude(Double.parseDouble(jSONObject6.getString("y")));
                    setLongitude(Double.parseDouble(jSONObject6.getString("x")));
                    setRadius(Float.parseFloat(jSONObject5.getString("radius")));
                    a(Boolean.valueOf(Boolean.parseBoolean(jSONObject5.getString("isCellChanged"))));
                }
            } else {
                JSONObject jSONObject7 = jSONObject.getJSONObject("content");
                JSONObject jSONObject8 = jSONObject7.getJSONObject("point");
                setLatitude(Double.parseDouble(jSONObject8.getString("y")));
                setLongitude(Double.parseDouble(jSONObject8.getString("x")));
                setRadius(Float.parseFloat(jSONObject7.getString("radius")));
                if (jSONObject7.has("addr")) {
                    String string = jSONObject7.getString("addr");
                    this.mAddr.f55try = string;
                    j.a(f.v, string);
                    String[] split = string.split(",");
                    this.mAddr.f52if = split[0];
                    this.mAddr.f54new = split[1];
                    this.mAddr.f53int = split[2];
                    this.mAddr.f49byte = split[3];
                    this.mAddr.f50do = split[4];
                    this.mAddr.f51for = split[5];
                    if ((this.mAddr.f52if.contains("北京") && this.mAddr.f54new.contains("北京")) || ((this.mAddr.f52if.contains("上海") && this.mAddr.f54new.contains("上海")) || ((this.mAddr.f52if.contains("天津") && this.mAddr.f54new.contains("天津")) || (this.mAddr.f52if.contains("重庆") && this.mAddr.f54new.contains("重庆"))))) {
                        j.a(f.v, "true,beijing");
                        str2 = this.mAddr.f52if;
                    } else {
                        str2 = this.mAddr.f52if + this.mAddr.f54new;
                    }
                    this.mAddr.f55try = str2 + this.mAddr.f53int + this.mAddr.f49byte + this.mAddr.f50do;
                    this.f48void = true;
                } else {
                    this.f48void = false;
                    setAddrStr(null);
                }
                if (jSONObject7.has("poi")) {
                    this.f37case = true;
                    this.f36byte = jSONObject7.getJSONObject("poi").toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.f43if = 0;
            this.f48void = false;
        }
    }

    public BDLocation(String str, double d, double d2, float f, String str2, String str3) {
        this.f43if = 0;
        this.d = null;
        this.f40else = Double.MIN_VALUE;
        this.f41for = Double.MIN_VALUE;
        this.c = false;
        this.f = Double.MIN_VALUE;
        this.f44int = false;
        this.f46new = 0.0f;
        this.f47try = false;
        this.f45long = 0.0f;
        this.b = false;
        this.f39do = -1;
        this.f38char = -1.0f;
        this.f42goto = null;
        this.f36byte = null;
        this.f48void = false;
        this.f37case = false;
        this.f743a = null;
        this.mServerString = null;
        this.e = false;
        this.mAddr = new a();
        this.d = str;
        this.f40else = d;
        this.f41for = d2;
        this.f45long = f;
        this.f42goto = str2;
        this.f743a = str3;
        this.d = j.a();
    }

    private void a(Boolean bool) {
        this.e = bool.booleanValue();
    }

    public String getAddrStr() {
        return this.mAddr.f55try;
    }

    public double getAltitude() {
        return this.f;
    }

    public String getCity() {
        return this.mAddr.f54new;
    }

    public String getCityCode() {
        return this.mAddr.f51for;
    }

    public String getCoorType() {
        return this.f42goto;
    }

    public float getDerect() {
        return this.f38char;
    }

    public String getDistrict() {
        return this.mAddr.f53int;
    }

    public double getLatitude() {
        return this.f40else;
    }

    public int getLocType() {
        return this.f43if;
    }

    public double getLongitude() {
        return this.f41for;
    }

    public String getPoi() {
        return this.f36byte;
    }

    public String getProvince() {
        return this.mAddr.f52if;
    }

    public float getRadius() {
        return this.f45long;
    }

    public int getSatelliteNumber() {
        this.b = true;
        return this.f39do;
    }

    public float getSpeed() {
        return this.f46new;
    }

    public String getStreet() {
        return this.mAddr.f49byte;
    }

    public String getStreetNumber() {
        return this.mAddr.f50do;
    }

    public String getTime() {
        return this.d;
    }

    public boolean hasAddr() {
        return this.f48void;
    }

    public boolean hasAltitude() {
        return this.c;
    }

    public boolean hasPoi() {
        return this.f37case;
    }

    public boolean hasRadius() {
        return this.f47try;
    }

    public boolean hasSateNumber() {
        return this.b;
    }

    public boolean hasSpeed() {
        return this.f44int;
    }

    public boolean isCellChangeFlag() {
        return this.e;
    }

    public void setAddrStr(String str) {
        this.f743a = str;
        this.f48void = true;
    }

    public void setAltitude(double d) {
        this.f = d;
        this.c = true;
    }

    public void setCoorType(String str) {
        this.f42goto = str;
    }

    public void setDerect(float f) {
        this.f38char = f;
    }

    public void setLatitude(double d) {
        this.f40else = d;
    }

    public void setLocType(int i) {
        this.f43if = i;
    }

    public void setLongitude(double d) {
        this.f41for = d;
    }

    public void setRadius(float f) {
        this.f45long = f;
        this.f47try = true;
    }

    public void setSatelliteNumber(int i) {
        this.f39do = i;
    }

    public void setSpeed(float f) {
        this.f46new = f;
        this.f44int = true;
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
