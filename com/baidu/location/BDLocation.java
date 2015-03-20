package com.baidu.location;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class BDLocation implements Parcelable, n {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.baidu.location.BDLocation.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BDLocation createFromParcel(Parcel parcel) {
            return new BDLocation(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BDLocation[] newArray(int i) {
            return new BDLocation[i];
        }
    };
    public static final int LOCATION_WHERE_IN_CN = 1;
    public static final int LOCATION_WHERE_OUT_CN = 0;
    public static final int LOCATION_WHERE_UNKNOW = 2;
    public static final int OPERATORS_TYPE_MOBILE = 1;
    public static final int OPERATORS_TYPE_TELECOMU = 3;
    public static final int OPERATORS_TYPE_UNICOM = 2;
    public static final int OPERATORS_TYPE_UNKONW = 0;
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
    private double g0;
    private String g1;
    private boolean g2;
    private boolean g3;
    private String g4;
    private float g5;
    private double g6;
    private boolean g7;
    private a g8;
    private boolean g9;
    private String gY;
    private int gZ;
    private String ha;
    private int hb;
    private float hc;
    private boolean hd;
    private int he;
    private double hf;
    private boolean hg;
    private float hh;
    private String hi;
    private String hj;
    private int hk;

    /* loaded from: classes.dex */
    public class a {

        /* renamed from: if  reason: not valid java name */
        public String f9if = null;

        /* renamed from: new  reason: not valid java name */
        public String f11new = null;

        /* renamed from: int  reason: not valid java name */
        public String f10int = null;

        /* renamed from: byte  reason: not valid java name */
        public String f6byte = null;

        /* renamed from: do  reason: not valid java name */
        public String f7do = null;

        /* renamed from: for  reason: not valid java name */
        public String f8for = null;

        /* renamed from: try  reason: not valid java name */
        public String f12try = null;

        public a() {
        }
    }

    public BDLocation() {
        this.he = 0;
        this.hi = null;
        this.g0 = Double.MIN_VALUE;
        this.hf = Double.MIN_VALUE;
        this.g2 = false;
        this.g6 = Double.MIN_VALUE;
        this.g3 = false;
        this.hh = 0.0f;
        this.g9 = false;
        this.hc = 0.0f;
        this.hg = false;
        this.gZ = -1;
        this.g5 = -1.0f;
        this.hj = null;
        this.hd = false;
        this.gY = null;
        this.g7 = false;
        this.g8 = new a();
        this.g1 = null;
        this.hb = 2;
        this.ha = null;
        this.g4 = "";
    }

    private BDLocation(Parcel parcel) {
        this.he = 0;
        this.hi = null;
        this.g0 = Double.MIN_VALUE;
        this.hf = Double.MIN_VALUE;
        this.g2 = false;
        this.g6 = Double.MIN_VALUE;
        this.g3 = false;
        this.hh = 0.0f;
        this.g9 = false;
        this.hc = 0.0f;
        this.hg = false;
        this.gZ = -1;
        this.g5 = -1.0f;
        this.hj = null;
        this.hd = false;
        this.gY = null;
        this.g7 = false;
        this.g8 = new a();
        this.g1 = null;
        this.hb = 2;
        this.ha = null;
        this.g4 = "";
        this.he = parcel.readInt();
        this.hi = parcel.readString();
        this.g0 = parcel.readDouble();
        this.hf = parcel.readDouble();
        this.g6 = parcel.readDouble();
        this.hh = parcel.readFloat();
        this.hc = parcel.readFloat();
        this.gZ = parcel.readInt();
        this.g5 = parcel.readFloat();
        this.g1 = parcel.readString();
        this.ha = parcel.readString();
        this.g8.f9if = parcel.readString();
        this.g8.f11new = parcel.readString();
        this.g8.f10int = parcel.readString();
        this.g8.f6byte = parcel.readString();
        this.g8.f7do = parcel.readString();
        this.g8.f8for = parcel.readString();
        this.g8.f12try = parcel.readString();
        boolean[] zArr = new boolean[6];
        parcel.readBooleanArray(zArr);
        this.g2 = zArr[0];
        this.g3 = zArr[1];
        this.g9 = zArr[2];
        this.hg = zArr[3];
        this.hd = zArr[4];
        this.g7 = zArr[5];
        this.hk = parcel.readInt();
        this.g4 = parcel.readString();
        this.hb = parcel.readInt();
    }

    public BDLocation(BDLocation bDLocation) {
        this.he = 0;
        this.hi = null;
        this.g0 = Double.MIN_VALUE;
        this.hf = Double.MIN_VALUE;
        this.g2 = false;
        this.g6 = Double.MIN_VALUE;
        this.g3 = false;
        this.hh = 0.0f;
        this.g9 = false;
        this.hc = 0.0f;
        this.hg = false;
        this.gZ = -1;
        this.g5 = -1.0f;
        this.hj = null;
        this.hd = false;
        this.gY = null;
        this.g7 = false;
        this.g8 = new a();
        this.g1 = null;
        this.hb = 2;
        this.ha = null;
        this.g4 = "";
        this.he = bDLocation.he;
        this.hi = bDLocation.hi;
        this.g0 = bDLocation.g0;
        this.hf = bDLocation.hf;
        this.g2 = bDLocation.g2;
        this.g6 = bDLocation.g6;
        this.g3 = bDLocation.g3;
        this.hh = bDLocation.hh;
        this.g9 = bDLocation.g9;
        this.hc = bDLocation.hc;
        this.hg = bDLocation.hg;
        this.gZ = bDLocation.gZ;
        this.g5 = bDLocation.g5;
        this.hj = bDLocation.hj;
        this.hd = bDLocation.hd;
        this.gY = bDLocation.gY;
        this.hb = bDLocation.hb;
        this.g7 = bDLocation.g7;
        this.g8 = new a();
        this.g8.f9if = bDLocation.g8.f9if;
        this.g8.f11new = bDLocation.g8.f11new;
        this.g8.f10int = bDLocation.g8.f10int;
        this.g8.f6byte = bDLocation.g8.f6byte;
        this.g8.f7do = bDLocation.g8.f7do;
        this.g8.f8for = bDLocation.g8.f8for;
        this.g8.f12try = bDLocation.g8.f12try;
        this.g1 = bDLocation.g1;
        this.ha = bDLocation.ha;
        this.hk = bDLocation.hk;
        this.g4 = bDLocation.g4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x024d -> B:89:0x004b). Please submit an issue!!! */
    public BDLocation(String str) {
        this.he = 0;
        this.hi = null;
        this.g0 = Double.MIN_VALUE;
        this.hf = Double.MIN_VALUE;
        this.g2 = false;
        this.g6 = Double.MIN_VALUE;
        this.g3 = false;
        this.hh = 0.0f;
        this.g9 = false;
        this.hc = 0.0f;
        this.hg = false;
        this.gZ = -1;
        this.g5 = -1.0f;
        this.hj = null;
        this.hd = false;
        this.gY = null;
        this.g7 = false;
        this.g8 = new a();
        this.g1 = null;
        this.hb = 2;
        this.ha = null;
        this.g4 = "";
        if (str == null || str.equals("")) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("result");
            int parseInt = Integer.parseInt(jSONObject2.getString("error"));
            setLocType(parseInt);
            setTime(jSONObject2.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
            if (parseInt == 61) {
                JSONObject jSONObject3 = jSONObject.getJSONObject(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
                JSONObject jSONObject4 = jSONObject3.getJSONObject("point");
                setLatitude(Double.parseDouble(jSONObject4.getString("y")));
                setLongitude(Double.parseDouble(jSONObject4.getString("x")));
                setRadius(Float.parseFloat(jSONObject3.getString("radius")));
                setSpeed(Float.parseFloat(jSONObject3.getString("s")));
                setDirection(Float.parseFloat(jSONObject3.getString("d")));
                setSatelliteNumber(Integer.parseInt(jSONObject3.getString("n")));
                if (jSONObject3.has("h")) {
                    try {
                        setAltitude(jSONObject3.getDouble("h"));
                    } catch (Exception e) {
                    }
                }
            } else if (parseInt != 161) {
                if (parseInt == 66 || parseInt == 68) {
                    JSONObject jSONObject5 = jSONObject.getJSONObject(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
                    JSONObject jSONObject6 = jSONObject5.getJSONObject("point");
                    setLatitude(Double.parseDouble(jSONObject6.getString("y")));
                    setLongitude(Double.parseDouble(jSONObject6.getString("x")));
                    setRadius(Float.parseFloat(jSONObject5.getString("radius")));
                    m7if(Boolean.valueOf(Boolean.parseBoolean(jSONObject5.getString("isCellChanged"))));
                }
            } else {
                JSONObject jSONObject7 = jSONObject.getJSONObject(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
                JSONObject jSONObject8 = jSONObject7.getJSONObject("point");
                setLatitude(Double.parseDouble(jSONObject8.getString("y")));
                setLongitude(Double.parseDouble(jSONObject8.getString("x")));
                setRadius(Float.parseFloat(jSONObject7.getString("radius")));
                if (jSONObject7.has("addr")) {
                    String string = jSONObject7.getString("addr");
                    this.g8.f12try = string;
                    String[] split = string.split(",");
                    int length = split.length;
                    if (length > 0) {
                        this.g8.f9if = split[0];
                    }
                    if (length > 1) {
                        this.g8.f11new = split[1];
                    }
                    if (length > 2) {
                        this.g8.f10int = split[2];
                    }
                    if (length > 3) {
                        this.g8.f6byte = split[3];
                    }
                    if (length > 4) {
                        this.g8.f7do = split[4];
                    }
                    if (length > 5) {
                        this.g8.f8for = split[5];
                    }
                    String str2 = ((this.g8.f9if.contains("北京") && this.g8.f11new.contains("北京")) || (this.g8.f9if.contains("上海") && this.g8.f11new.contains("上海")) || ((this.g8.f9if.contains("天津") && this.g8.f11new.contains("天津")) || (this.g8.f9if.contains("重庆") && this.g8.f11new.contains("重庆")))) ? this.g8.f9if : this.g8.f9if + this.g8.f11new;
                    this.g8.f12try = this.g8.f7do != null ? str2 + this.g8.f10int + this.g8.f6byte + this.g8.f7do : str2 + this.g8.f10int + this.g8.f6byte;
                    this.hd = true;
                } else {
                    this.hd = false;
                    setAddrStr(null);
                }
                if (jSONObject7.has("floor")) {
                    this.g1 = jSONObject7.getString("floor");
                    if (TextUtils.isEmpty(this.g1)) {
                        this.g1 = null;
                    }
                }
                if (jSONObject7.has("loctp")) {
                    this.ha = jSONObject7.getString("loctp");
                    if (TextUtils.isEmpty(this.ha)) {
                        this.ha = null;
                    }
                }
                try {
                    if (jSONObject7.has("in_cn")) {
                        m9case(Integer.parseInt(jSONObject7.getString("in_cn")));
                    } else {
                        m9case(1);
                    }
                } catch (Exception e2) {
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            this.he = 0;
            this.hd = false;
        }
    }

    private String bw() {
        return this.g4;
    }

    private static String by() {
        return Build.MODEL;
    }

    /* renamed from: do  reason: not valid java name */
    private String m6do(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        return stringWriter.toString();
    }

    /* renamed from: if  reason: not valid java name */
    private void m7if(Boolean bool) {
        this.g7 = bool.booleanValue();
    }

    protected String bu() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bv() {
        return this.hb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a bx() {
        return this.g8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: byte  reason: not valid java name */
    public void m8byte(int i) {
        this.hk = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: case  reason: not valid java name */
    public void m9case(int i) {
        this.hb = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdUrl(String str) {
        String valueOf = String.valueOf(this.g0);
        String valueOf2 = String.valueOf(this.hf);
        String bw = bw();
        return "http://lba.baidu.com/?a=" + CommonEncrypt.a("ak=" + str + "&lat=" + valueOf + "&lng=" + valueOf2 + "&cu=" + bw + "&mb=" + by());
    }

    public String getAddrStr() {
        return this.g8.f12try;
    }

    public double getAltitude() {
        return this.g6;
    }

    public String getCity() {
        return this.g8.f11new;
    }

    public String getCityCode() {
        return this.g8.f8for;
    }

    public String getCoorType() {
        return this.hj;
    }

    public float getDirection() {
        return this.g5;
    }

    public String getDistrict() {
        return this.g8.f10int;
    }

    public String getFloor() {
        return this.g1;
    }

    public double getLatitude() {
        return this.g0;
    }

    public int getLocType() {
        return this.he;
    }

    public double getLongitude() {
        return this.hf;
    }

    public String getNetworkLocationType() {
        return this.ha;
    }

    public int getOperators() {
        return this.hk;
    }

    public String getProvince() {
        return this.g8.f9if;
    }

    public float getRadius() {
        return this.hc;
    }

    public int getSatelliteNumber() {
        this.hg = true;
        return this.gZ;
    }

    public float getSpeed() {
        return this.hh;
    }

    public String getStreet() {
        return this.g8.f6byte;
    }

    public String getStreetNumber() {
        return this.g8.f7do;
    }

    public String getTime() {
        return this.hi;
    }

    public boolean hasAddr() {
        return this.hd;
    }

    public boolean hasAltitude() {
        return this.g2;
    }

    public boolean hasRadius() {
        return this.g9;
    }

    public boolean hasSateNumber() {
        return this.hg;
    }

    public boolean hasSpeed() {
        return this.g3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: if  reason: not valid java name */
    public void m10if(a aVar) {
        if (aVar != null) {
            this.g8.f12try = aVar.f12try;
            this.g8.f11new = aVar.f11new;
            this.g8.f8for = aVar.f8for;
            this.g8.f10int = aVar.f10int;
            this.g8.f9if = aVar.f9if;
            this.g8.f6byte = aVar.f6byte;
            this.g8.f7do = aVar.f7do;
            this.hd = true;
        }
    }

    public void internalSet(int i, String str) {
        if (str != null && i == 0) {
            this.g4 = str;
        }
    }

    public boolean isCellChangeFlag() {
        return this.g7;
    }

    protected BDLocation q(String str) {
        return null;
    }

    public void setAddrStr(String str) {
        this.gY = str;
        if (str == null) {
            this.hd = false;
        } else {
            this.hd = true;
        }
    }

    public void setAltitude(double d) {
        this.g6 = d;
        this.g2 = true;
    }

    public void setCoorType(String str) {
        this.hj = str;
    }

    public void setDirection(float f) {
        this.g5 = f;
    }

    public void setLatitude(double d) {
        this.g0 = d;
    }

    public void setLocType(int i) {
        this.he = i;
    }

    public void setLongitude(double d) {
        this.hf = d;
    }

    public void setNetworkLocationType(String str) {
        this.ha = str;
    }

    public void setRadius(float f) {
        this.hc = f;
        this.g9 = true;
    }

    public void setSatelliteNumber(int i) {
        this.gZ = i;
    }

    public void setSpeed(float f) {
        this.hh = f;
        this.g3 = true;
    }

    public void setTime(String str) {
        this.hi = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.he);
        parcel.writeString(this.hi);
        parcel.writeDouble(this.g0);
        parcel.writeDouble(this.hf);
        parcel.writeDouble(this.g6);
        parcel.writeFloat(this.hh);
        parcel.writeFloat(this.hc);
        parcel.writeInt(this.gZ);
        parcel.writeFloat(this.g5);
        parcel.writeString(this.g1);
        parcel.writeString(this.ha);
        parcel.writeString(this.g8.f9if);
        parcel.writeString(this.g8.f11new);
        parcel.writeString(this.g8.f10int);
        parcel.writeString(this.g8.f6byte);
        parcel.writeString(this.g8.f7do);
        parcel.writeString(this.g8.f8for);
        parcel.writeString(this.g8.f12try);
        parcel.writeBooleanArray(new boolean[]{this.g2, this.g3, this.g9, this.hg, this.hd, this.g7});
        parcel.writeInt(this.hk);
        parcel.writeString(this.g4);
        parcel.writeInt(this.hb);
    }
}
