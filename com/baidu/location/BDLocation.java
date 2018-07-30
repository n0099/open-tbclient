package com.baidu.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.location.Address;
import com.baidu.location.d.g;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class BDLocation implements Parcelable {
    public static final String BDLOCATION_BD09LL_TO_GCJ02 = "bd09ll2gcj";
    public static final String BDLOCATION_BD09_TO_GCJ02 = "bd092gcj";
    public static final String BDLOCATION_GCJ02_TO_BD09 = "bd09";
    public static final String BDLOCATION_GCJ02_TO_BD09LL = "bd09ll";
    public static final String BDLOCATION_WGS84_TO_GCJ02 = "gps2gcj";
    public static final Parcelable.Creator<BDLocation> CREATOR = new Parcelable.Creator<BDLocation>() { // from class: com.baidu.location.BDLocation.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BDLocation createFromParcel(Parcel parcel) {
            return new BDLocation(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BDLocation[] newArray(int i) {
            return new BDLocation[i];
        }
    };
    public static final int GPS_ACCURACY_BAD = 3;
    public static final int GPS_ACCURACY_GOOD = 1;
    public static final int GPS_ACCURACY_MID = 2;
    public static final int GPS_ACCURACY_UNKNOWN = 0;
    public static final int GPS_RECTIFY_INDOOR = 1;
    public static final int GPS_RECTIFY_NONE = 0;
    public static final int GPS_RECTIFY_OUTDOOR = 2;
    public static final int INDOOR_LOCATION_NEARBY_SURPPORT_TRUE = 2;
    public static final int INDOOR_LOCATION_SOURCE_BLUETOOTH = 4;
    public static final int INDOOR_LOCATION_SOURCE_MAGNETIC = 2;
    public static final int INDOOR_LOCATION_SOURCE_SMALLCELLSTATION = 8;
    public static final int INDOOR_LOCATION_SOURCE_UNKNOWN = 0;
    public static final int INDOOR_LOCATION_SOURCE_WIFI = 1;
    public static final int INDOOR_LOCATION_SURPPORT_FALSE = 0;
    public static final int INDOOR_LOCATION_SURPPORT_TRUE = 1;
    public static final int INDOOR_NETWORK_STATE_HIGH = 2;
    public static final int INDOOR_NETWORK_STATE_LOW = 0;
    public static final int INDOOR_NETWORK_STATE_MIDDLE = 1;
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
    public static final int TypeServerCheckKeyError = 505;
    public static final int TypeServerDecryptError = 162;
    public static final int TypeServerError = 167;
    public static final int USER_INDDOR_TRUE = 1;
    public static final int USER_INDOOR_FALSE = 0;
    public static final int USER_INDOOR_UNKNOW = -1;
    private int A;
    private String B;
    private int C;
    private String D;
    private int E;
    private int F;
    private int G;
    private int H;
    private String I;
    private String J;
    private String K;
    private List<Poi> L;
    private String M;
    private String N;
    private Bundle O;
    private int P;
    private int Q;
    private int a;
    private String b;
    private double c;
    private double d;
    private boolean e;
    private double f;
    private boolean g;
    private float h;
    private boolean i;
    private float j;
    private boolean k;
    private int l;
    private float m;
    private String n;
    private boolean o;
    private String p;
    private String q;
    private String r;
    private String s;
    private boolean t;
    private Address u;
    private String v;
    private String w;
    private String x;
    private boolean y;
    private int z;

    public BDLocation() {
        this.a = 0;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.k = false;
        this.l = -1;
        this.m = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = new Address.Builder().build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 1;
        this.B = null;
        this.D = "";
        this.E = -1;
        this.F = 0;
        this.G = 2;
        this.H = 0;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = new Bundle();
        this.P = 0;
        this.Q = 0;
    }

    private BDLocation(Parcel parcel) {
        this.a = 0;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.k = false;
        this.l = -1;
        this.m = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = new Address.Builder().build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 1;
        this.B = null;
        this.D = "";
        this.E = -1;
        this.F = 0;
        this.G = 2;
        this.H = 0;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = new Bundle();
        this.P = 0;
        this.Q = 0;
        this.a = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.readDouble();
        this.d = parcel.readDouble();
        this.f = parcel.readDouble();
        this.h = parcel.readFloat();
        this.j = parcel.readFloat();
        this.l = parcel.readInt();
        this.m = parcel.readFloat();
        this.v = parcel.readString();
        this.z = parcel.readInt();
        this.w = parcel.readString();
        this.x = parcel.readString();
        this.B = parcel.readString();
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        String readString4 = parcel.readString();
        String readString5 = parcel.readString();
        String readString6 = parcel.readString();
        parcel.readString();
        String readString7 = parcel.readString();
        String readString8 = parcel.readString();
        this.u = new Address.Builder().country(readString7).countryCode(readString8).province(readString).city(readString2).cityCode(readString6).district(readString3).street(readString4).streetNumber(readString5).adcode(parcel.readString()).build();
        boolean[] zArr = new boolean[7];
        this.C = parcel.readInt();
        this.D = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readString();
        this.s = parcel.readString();
        this.A = parcel.readInt();
        this.M = parcel.readString();
        this.E = parcel.readInt();
        this.F = parcel.readInt();
        this.G = parcel.readInt();
        this.H = parcel.readInt();
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readString();
        this.P = parcel.readInt();
        this.N = parcel.readString();
        this.Q = parcel.readInt();
        try {
            parcel.readBooleanArray(zArr);
            this.e = zArr[0];
            this.g = zArr[1];
            this.i = zArr[2];
            this.k = zArr[3];
            this.o = zArr[4];
            this.t = zArr[5];
            this.y = zArr[6];
        } catch (Exception e) {
        }
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, Poi.class.getClassLoader());
        if (arrayList.size() == 0) {
            this.L = null;
        } else {
            this.L = arrayList;
        }
        this.O = parcel.readBundle();
    }

    public BDLocation(BDLocation bDLocation) {
        int i = 0;
        this.a = 0;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.k = false;
        this.l = -1;
        this.m = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = new Address.Builder().build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 1;
        this.B = null;
        this.D = "";
        this.E = -1;
        this.F = 0;
        this.G = 2;
        this.H = 0;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = new Bundle();
        this.P = 0;
        this.Q = 0;
        this.a = bDLocation.a;
        this.b = bDLocation.b;
        this.c = bDLocation.c;
        this.d = bDLocation.d;
        this.e = bDLocation.e;
        this.f = bDLocation.f;
        this.g = bDLocation.g;
        this.h = bDLocation.h;
        this.i = bDLocation.i;
        this.j = bDLocation.j;
        this.k = bDLocation.k;
        this.l = bDLocation.l;
        this.m = bDLocation.m;
        this.n = bDLocation.n;
        this.o = bDLocation.o;
        this.p = bDLocation.p;
        this.t = bDLocation.t;
        this.u = new Address.Builder().country(bDLocation.u.country).countryCode(bDLocation.u.countryCode).province(bDLocation.u.province).city(bDLocation.u.city).cityCode(bDLocation.u.cityCode).district(bDLocation.u.district).street(bDLocation.u.street).streetNumber(bDLocation.u.streetNumber).adcode(bDLocation.u.adcode).build();
        this.v = bDLocation.v;
        this.w = bDLocation.w;
        this.x = bDLocation.x;
        this.A = bDLocation.A;
        this.z = bDLocation.z;
        this.y = bDLocation.y;
        this.B = bDLocation.B;
        this.C = bDLocation.C;
        this.D = bDLocation.D;
        this.q = bDLocation.q;
        this.r = bDLocation.r;
        this.s = bDLocation.s;
        this.E = bDLocation.E;
        this.F = bDLocation.F;
        this.G = bDLocation.F;
        this.H = bDLocation.H;
        this.I = bDLocation.I;
        this.J = bDLocation.J;
        this.K = bDLocation.K;
        this.P = bDLocation.P;
        this.N = bDLocation.N;
        if (bDLocation.L == null) {
            this.L = null;
        } else {
            ArrayList arrayList = new ArrayList();
            while (true) {
                int i2 = i;
                if (i2 >= bDLocation.L.size()) {
                    break;
                }
                Poi poi = bDLocation.L.get(i2);
                arrayList.add(new Poi(poi.getId(), poi.getName(), poi.getRank()));
                i = i2 + 1;
            }
            this.L = arrayList;
        }
        this.M = bDLocation.M;
        this.O = bDLocation.O;
        this.Q = bDLocation.Q;
    }

    public BDLocation(String str) {
        boolean z;
        JSONObject jSONObject;
        String str2;
        boolean z2;
        this.a = 0;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.k = false;
        this.l = -1;
        this.m = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = new Address.Builder().build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 1;
        this.B = null;
        this.D = "";
        this.E = -1;
        this.F = 0;
        this.G = 2;
        this.H = 0;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = new Bundle();
        this.P = 0;
        this.Q = 0;
        if (str == null || str.equals("")) {
            return;
        }
        try {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                JSONObject jSONObject3 = jSONObject2.getJSONObject("result");
                int parseInt = Integer.parseInt(jSONObject3.getString("error"));
                setLocType(parseInt);
                setTime(jSONObject3.getString("time"));
                if (parseInt == 61) {
                    JSONObject jSONObject4 = jSONObject2.getJSONObject("content");
                    JSONObject jSONObject5 = jSONObject4.getJSONObject("point");
                    setLatitude(Double.parseDouble(jSONObject5.getString("y")));
                    setLongitude(Double.parseDouble(jSONObject5.getString("x")));
                    setRadius(Float.parseFloat(jSONObject4.getString("radius")));
                    setSpeed(Float.parseFloat(jSONObject4.getString(NotifyType.SOUND)));
                    setDirection(Float.parseFloat(jSONObject4.getString("d")));
                    setSatelliteNumber(Integer.parseInt(jSONObject4.getString("n")));
                    if (jSONObject4.has("h")) {
                        try {
                            setAltitude(jSONObject4.getDouble("h"));
                        } catch (Exception e) {
                        }
                    }
                    try {
                        if (jSONObject4.has("in_cn")) {
                            setLocationWhere(Integer.parseInt(jSONObject4.getString("in_cn")));
                        } else {
                            setLocationWhere(1);
                        }
                    } catch (Exception e2) {
                    }
                    if (this.A == 0) {
                        setCoorType("wgs84");
                    } else {
                        setCoorType("gcj02");
                    }
                } else if (parseInt != 161) {
                    if (parseInt != 66 && parseInt != 68) {
                        if (parseInt == 167) {
                            setLocationWhere(2);
                            return;
                        }
                        return;
                    }
                    JSONObject jSONObject6 = jSONObject2.getJSONObject("content");
                    JSONObject jSONObject7 = jSONObject6.getJSONObject("point");
                    setLatitude(Double.parseDouble(jSONObject7.getString("y")));
                    setLongitude(Double.parseDouble(jSONObject7.getString("x")));
                    setRadius(Float.parseFloat(jSONObject6.getString("radius")));
                    a(Boolean.valueOf(Boolean.parseBoolean(jSONObject6.getString("isCellChanged"))));
                    setCoorType("gcj02");
                } else {
                    JSONObject jSONObject8 = jSONObject2.getJSONObject("content");
                    JSONObject jSONObject9 = jSONObject8.getJSONObject("point");
                    setLatitude(Double.parseDouble(jSONObject9.getString("y")));
                    setLongitude(Double.parseDouble(jSONObject9.getString("x")));
                    setRadius(Float.parseFloat(jSONObject8.getString("radius")));
                    if (jSONObject8.has("sema")) {
                        JSONObject jSONObject10 = jSONObject8.getJSONObject("sema");
                        if (jSONObject10.has("aptag")) {
                            String string = jSONObject10.getString("aptag");
                            if (TextUtils.isEmpty(string)) {
                                this.q = "";
                            } else {
                                this.q = string;
                            }
                        }
                        if (jSONObject10.has("aptagd")) {
                            JSONArray jSONArray = jSONObject10.getJSONObject("aptagd").getJSONArray("pois");
                            ArrayList arrayList = new ArrayList();
                            for (int i = 0; i < jSONArray.length(); i++) {
                                JSONObject jSONObject11 = jSONArray.getJSONObject(i);
                                arrayList.add(new Poi(jSONObject11.getString(Info.kBaiduPIDKey), jSONObject11.getString("pname"), jSONObject11.getDouble("pr")));
                            }
                            this.L = arrayList;
                        }
                        if (jSONObject10.has("poiregion")) {
                            String string2 = jSONObject10.getString("poiregion");
                            if (!TextUtils.isEmpty(string2)) {
                                this.r = string2;
                            }
                        }
                        if (jSONObject10.has("regular")) {
                            String string3 = jSONObject10.getString("regular");
                            if (!TextUtils.isEmpty(string3)) {
                                this.s = string3;
                            }
                        }
                    }
                    if (jSONObject8.has("addr")) {
                        try {
                            z = true;
                            jSONObject = jSONObject8.getJSONObject("addr");
                        } catch (Exception e3) {
                            z = false;
                            jSONObject = null;
                        }
                        if (jSONObject != null) {
                            r6 = jSONObject.has("city") ? jSONObject.getString("city") : "";
                            r5 = jSONObject.has("city_code") ? jSONObject.getString("city_code") : "";
                            r9 = jSONObject.has("country") ? jSONObject.getString("country") : "";
                            r8 = jSONObject.has("country_code") ? jSONObject.getString("country_code") : "";
                            r7 = jSONObject.has("province") ? jSONObject.getString("province") : "";
                            r4 = jSONObject.has("district") ? jSONObject.getString("district") : "";
                            r3 = jSONObject.has("street") ? jSONObject.getString("street") : "";
                            r2 = jSONObject.has("street_number") ? jSONObject.getString("street_number") : "";
                            if (jSONObject.has("adcode")) {
                                boolean z3 = z;
                                str2 = jSONObject.getString("adcode");
                                z2 = z3;
                            } else {
                                boolean z4 = z;
                                str2 = "";
                                z2 = z4;
                            }
                        } else {
                            try {
                                String[] split = jSONObject8.getString("addr").split(",");
                                int length = split.length;
                                r7 = length > 0 ? split[0] : null;
                                r6 = length > 1 ? split[1] : null;
                                r4 = length > 2 ? split[2] : null;
                                r3 = length > 3 ? split[3] : null;
                                r2 = length > 4 ? split[4] : null;
                                r5 = length > 5 ? split[5] : null;
                                r9 = length > 6 ? split[6] : null;
                                r8 = length > 7 ? split[7] : null;
                                str2 = length > 8 ? split[8] : null;
                                z2 = true;
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                str2 = null;
                                z2 = false;
                            }
                        }
                        if (z2) {
                            this.u = new Address.Builder().country(r9).countryCode(r8).province(r7).city(r6).cityCode(r5).district(r4).street(r3).streetNumber(r2).adcode(str2).build();
                            this.o = true;
                        }
                    } else {
                        this.o = false;
                        setAddrStr(null);
                    }
                    if (jSONObject8.has("floor")) {
                        this.v = jSONObject8.getString("floor");
                        if (TextUtils.isEmpty(this.v)) {
                            this.v = null;
                        }
                    }
                    if (jSONObject8.has("indoor")) {
                        String string4 = jSONObject8.getString("indoor");
                        if (!TextUtils.isEmpty(string4)) {
                            setUserIndoorState(Integer.valueOf(string4).intValue());
                        }
                    }
                    if (jSONObject8.has("loctp")) {
                        this.B = jSONObject8.getString("loctp");
                        if (TextUtils.isEmpty(this.B)) {
                            this.B = null;
                        }
                    }
                    if (jSONObject8.has("bldgid")) {
                        this.w = jSONObject8.getString("bldgid");
                        if (TextUtils.isEmpty(this.w)) {
                            this.w = null;
                        }
                    }
                    if (jSONObject8.has("bldg")) {
                        this.x = jSONObject8.getString("bldg");
                        if (TextUtils.isEmpty(this.x)) {
                            this.x = null;
                        }
                    }
                    if (jSONObject8.has("ibav")) {
                        String string5 = jSONObject8.getString("ibav");
                        if (TextUtils.isEmpty(string5)) {
                            this.z = 0;
                        } else if (string5.equals("0")) {
                            this.z = 0;
                        } else {
                            this.z = Integer.valueOf(string5).intValue();
                        }
                    }
                    if (jSONObject8.has("indoorflags")) {
                        try {
                            JSONObject jSONObject12 = jSONObject8.getJSONObject("indoorflags");
                            if (jSONObject12.has(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA)) {
                                int intValue = Integer.valueOf(jSONObject12.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA)).intValue();
                                if (intValue == 0) {
                                    setIndoorLocationSurpport(2);
                                } else if (intValue == 1) {
                                    setIndoorLocationSurpport(1);
                                }
                            }
                            if (jSONObject12.has("support")) {
                                setIndoorLocationSource(Integer.valueOf(jSONObject12.getString("support")).intValue());
                            }
                            if (jSONObject12.has("inbldg")) {
                                this.I = jSONObject12.getString("inbldg");
                            }
                            if (jSONObject12.has("inbldgid")) {
                                this.J = jSONObject12.getString("inbldgid");
                            }
                            if (jSONObject12.has("polygon")) {
                                setIndoorSurpportPolygon(jSONObject12.getString("polygon"));
                            }
                            if (jSONObject12.has("ret_fields")) {
                                try {
                                    String[] split2 = jSONObject12.getString("ret_fields").split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
                                    for (String str3 : split2) {
                                        String[] split3 = str3.split("=");
                                        this.O.putString(split3[0], split3[1]);
                                    }
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                            }
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (jSONObject8.has("gpscs")) {
                        setGpsCheckStatus(jSONObject8.getInt("gpscs"));
                    } else {
                        setGpsCheckStatus(0);
                    }
                    try {
                        if (jSONObject8.has("in_cn")) {
                            setLocationWhere(Integer.parseInt(jSONObject8.getString("in_cn")));
                        } else {
                            setLocationWhere(1);
                        }
                    } catch (Exception e7) {
                    }
                    if (this.A == 0) {
                        setCoorType("wgs84");
                    } else {
                        setCoorType("gcj02");
                    }
                }
            } catch (Exception e8) {
                e8.printStackTrace();
                this.a = 0;
                this.o = false;
            }
        } catch (Error e9) {
            e9.printStackTrace();
            this.a = 0;
            this.o = false;
        }
    }

    private void a(Boolean bool) {
        this.t = bool.booleanValue();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.u.adcode;
    }

    public String getAddrStr() {
        return this.u.address;
    }

    public Address getAddress() {
        return this.u;
    }

    public double getAltitude() {
        return this.f;
    }

    public String getBuildingID() {
        return this.w;
    }

    public String getBuildingName() {
        return this.x;
    }

    public String getCity() {
        return this.u.city;
    }

    public String getCityCode() {
        return this.u.cityCode;
    }

    public String getCoorType() {
        return this.n;
    }

    public String getCountry() {
        return this.u.country;
    }

    public String getCountryCode() {
        return this.u.countryCode;
    }

    @Deprecated
    public float getDerect() {
        return this.m;
    }

    public float getDirection() {
        return this.m;
    }

    public String getDistrict() {
        return this.u.district;
    }

    public Location getExtraLocation(String str) {
        if (this.O != null) {
            Parcelable parcelable = this.O.getParcelable(str);
            if (parcelable instanceof Location) {
                return (Location) parcelable;
            }
        }
        return null;
    }

    public String getFloor() {
        return this.v;
    }

    public double[] getFusionLocInfo(String str) {
        return this.O.getDoubleArray(str);
    }

    public int getGpsAccuracyStatus() {
        return this.P;
    }

    public int getGpsCheckStatus() {
        return this.Q;
    }

    public int getIndoorLocationSource() {
        return this.H;
    }

    public int getIndoorLocationSurpport() {
        return this.F;
    }

    public String getIndoorLocationSurpportBuidlingID() {
        return this.J;
    }

    public String getIndoorLocationSurpportBuidlingName() {
        return this.I;
    }

    public int getIndoorNetworkState() {
        return this.G;
    }

    public String getIndoorSurpportPolygon() {
        return this.K;
    }

    public double getLatitude() {
        return this.c;
    }

    public int getLocType() {
        return this.a;
    }

    public String getLocTypeDescription() {
        return this.M;
    }

    public String getLocationDescribe() {
        return this.q;
    }

    public String getLocationID() {
        return this.N;
    }

    public int getLocationWhere() {
        return this.A;
    }

    public double getLongitude() {
        return this.d;
    }

    public String getNetworkLocationType() {
        return this.B;
    }

    public int getOperators() {
        return this.C;
    }

    public List<Poi> getPoiList() {
        return this.L;
    }

    public String getProvince() {
        return this.u.province;
    }

    public float getRadius() {
        return this.j;
    }

    public String getRetFields(String str) {
        return this.O.getString(str);
    }

    public int getSatelliteNumber() {
        this.k = true;
        return this.l;
    }

    @Deprecated
    public String getSemaAptag() {
        return this.q;
    }

    public float getSpeed() {
        return this.h;
    }

    public String getStreet() {
        return this.u.street;
    }

    public String getStreetNumber() {
        return this.u.streetNumber;
    }

    public String getTime() {
        return this.b;
    }

    public int getUserIndoorState() {
        return this.E;
    }

    public boolean hasAddr() {
        return this.o;
    }

    public boolean hasAltitude() {
        return this.e;
    }

    public boolean hasRadius() {
        return this.i;
    }

    public boolean hasSateNumber() {
        return this.k;
    }

    public boolean hasSpeed() {
        return this.g;
    }

    public boolean isCellChangeFlag() {
        return this.t;
    }

    public boolean isIndoorLocMode() {
        return this.y;
    }

    public int isParkAvailable() {
        return this.z;
    }

    public void setAddr(Address address) {
        if (address != null) {
            this.u = address;
            this.o = true;
        }
    }

    public void setAddrStr(String str) {
        this.p = str;
        if (str == null) {
            this.o = false;
        } else {
            this.o = true;
        }
    }

    public void setAltitude(double d) {
        this.f = d;
        this.e = true;
    }

    public void setBuildingID(String str) {
        this.w = str;
    }

    public void setBuildingName(String str) {
        this.x = str;
    }

    public void setCoorType(String str) {
        this.n = str;
    }

    public void setDirection(float f) {
        this.m = f;
    }

    public void setExtraLocation(String str, Location location) {
        if (this.O == null) {
            this.O = new Bundle();
        }
        this.O.putParcelable(str, location);
    }

    public void setFloor(String str) {
        this.v = str;
    }

    public void setFusionLocInfo(String str, double[] dArr) {
        if (this.O == null) {
            this.O = new Bundle();
        }
        this.O.putDoubleArray(str, dArr);
    }

    public void setGpsAccuracyStatus(int i) {
        this.P = i;
    }

    public void setGpsCheckStatus(int i) {
        this.Q = i;
    }

    public void setIndoorLocMode(boolean z) {
        this.y = z;
    }

    public void setIndoorLocationSource(int i) {
        this.H = i;
    }

    public void setIndoorLocationSurpport(int i) {
        this.F = i;
    }

    public void setIndoorNetworkState(int i) {
        this.G = i;
    }

    public void setIndoorSurpportPolygon(String str) {
        this.K = str;
    }

    public void setLatitude(double d) {
        this.c = d;
    }

    public void setLocType(int i) {
        this.a = i;
        switch (i) {
            case 61:
                setLocTypeDescription("GPS location successful!");
                setUserIndoorState(0);
                return;
            case 62:
                setLocTypeDescription("Location failed beacuse we can not get any loc information!");
                return;
            case 63:
            case 67:
                setLocTypeDescription("Offline location failed, please check the net (wifi/cell)!");
                return;
            case 66:
                setLocTypeDescription("Offline location successful!");
                return;
            case TypeNetWorkLocation /* 161 */:
                setLocTypeDescription("NetWork location successful!");
                return;
            case TypeServerDecryptError /* 162 */:
                setLocTypeDescription("NetWork location failed because baidu location service can not decrypt the request query, please check the so file !");
                return;
            case TypeServerError /* 167 */:
                setLocTypeDescription("NetWork location failed because baidu location service can not caculate the location!");
                return;
            case 505:
                setLocTypeDescription("NetWork location failed because baidu location service check the key is unlegal, please check the key in AndroidManifest.xml !");
                return;
            default:
                setLocTypeDescription("UnKnown!");
                return;
        }
    }

    public void setLocTypeDescription(String str) {
        this.M = str;
    }

    public void setLocationDescribe(String str) {
        this.q = str;
    }

    public void setLocationID(String str) {
        this.N = str;
    }

    public void setLocationWhere(int i) {
        this.A = i;
    }

    public void setLongitude(double d) {
        this.d = d;
    }

    public void setNetworkLocationType(String str) {
        this.B = str;
    }

    public void setOperators(int i) {
        this.C = i;
    }

    public void setParkAvailable(int i) {
        this.z = i;
    }

    public void setPoiList(List<Poi> list) {
        this.L = list;
    }

    public void setRadius(float f) {
        this.j = f;
        this.i = true;
    }

    public void setRetFields(String str, String str2) {
        if (this.O == null) {
            this.O = new Bundle();
        }
        this.O.putString(str, str2);
    }

    public void setSatelliteNumber(int i) {
        this.l = i;
    }

    public void setSpeed(float f) {
        this.h = f;
        this.g = true;
    }

    public void setTime(String str) {
        this.b = str;
        setLocationID(g.a(str));
    }

    public void setUserIndoorState(int i) {
        this.E = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeDouble(this.c);
        parcel.writeDouble(this.d);
        parcel.writeDouble(this.f);
        parcel.writeFloat(this.h);
        parcel.writeFloat(this.j);
        parcel.writeInt(this.l);
        parcel.writeFloat(this.m);
        parcel.writeString(this.v);
        parcel.writeInt(this.z);
        parcel.writeString(this.w);
        parcel.writeString(this.x);
        parcel.writeString(this.B);
        parcel.writeString(this.u.province);
        parcel.writeString(this.u.city);
        parcel.writeString(this.u.district);
        parcel.writeString(this.u.street);
        parcel.writeString(this.u.streetNumber);
        parcel.writeString(this.u.cityCode);
        parcel.writeString(this.u.address);
        parcel.writeString(this.u.country);
        parcel.writeString(this.u.countryCode);
        parcel.writeString(this.u.adcode);
        parcel.writeInt(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeInt(this.A);
        parcel.writeString(this.M);
        parcel.writeInt(this.E);
        parcel.writeInt(this.F);
        parcel.writeInt(this.G);
        parcel.writeInt(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
        parcel.writeInt(this.P);
        parcel.writeString(this.N);
        parcel.writeInt(this.Q);
        parcel.writeBooleanArray(new boolean[]{this.e, this.g, this.i, this.k, this.o, this.t, this.y});
        parcel.writeList(this.L);
        parcel.writeBundle(this.O);
    }
}
