package com.baidu.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.location.Address;
import com.baidu.location.e.l;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.location.CoordinateType;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.webkit.internal.ETAG;
import com.heytap.mcssdk.mode.CommandMessage;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class BDLocation implements Parcelable {
    public static final String BDLOCATION_BD09LL_TO_GCJ02 = "bd09ll2gcj";
    public static final String BDLOCATION_BD09_TO_GCJ02 = "bd092gcj";
    public static final String BDLOCATION_GCJ02_TO_BD09 = "bd09";
    public static final String BDLOCATION_GCJ02_TO_BD09LL = "bd09ll";
    public static final String BDLOCATION_WGS84_TO_GCJ02 = "gps2gcj";
    public static final Parcelable.Creator<BDLocation> CREATOR = new a();
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
    public static final int MOCK_GPS_PROBABILITY_HIGH = 3;
    public static final int MOCK_GPS_PROBABILITY_LOW = 1;
    public static final int MOCK_GPS_PROBABILITY_MIDDLE = 2;
    public static final int MOCK_GPS_PROBABILITY_UNKNOW = -1;
    public static final int MOCK_GPS_PROBABILITY_ZERO = 0;
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
    private String O;
    private Bundle P;
    private int Q;
    private int R;
    private long S;
    private String T;
    private double U;
    private double V;
    private boolean W;
    private PoiRegion X;
    private float Y;
    private double Z;

    /* renamed from: a  reason: collision with root package name */
    private int f1852a;
    private int aa;
    private int ab;
    private BDLocation ac;
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
        this.f1852a = 0;
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
        this.O = null;
        this.P = new Bundle();
        this.Q = 0;
        this.R = 0;
        this.S = 0L;
        this.T = null;
        this.U = Double.MIN_VALUE;
        this.V = Double.MIN_VALUE;
        this.W = false;
        this.X = null;
        this.Y = -1.0f;
        this.Z = -1.0d;
        this.aa = 0;
        this.ab = -1;
    }

    private BDLocation(Parcel parcel) {
        this.f1852a = 0;
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
        this.O = null;
        this.P = new Bundle();
        this.Q = 0;
        this.R = 0;
        this.S = 0L;
        this.T = null;
        this.U = Double.MIN_VALUE;
        this.V = Double.MIN_VALUE;
        this.W = false;
        this.X = null;
        this.Y = -1.0f;
        this.Z = -1.0d;
        this.aa = 0;
        this.ab = -1;
        this.f1852a = parcel.readInt();
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
        String readString9 = parcel.readString();
        this.u = new Address.Builder().country(readString7).countryCode(readString8).province(readString).city(readString2).cityCode(readString6).district(readString3).street(readString4).streetNumber(readString5).adcode(readString9).town(parcel.readString()).build();
        boolean[] zArr = new boolean[8];
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
        this.Q = parcel.readInt();
        this.N = parcel.readString();
        this.R = parcel.readInt();
        this.O = parcel.readString();
        this.T = parcel.readString();
        this.S = parcel.readLong();
        this.U = parcel.readDouble();
        this.V = parcel.readDouble();
        this.Y = parcel.readFloat();
        this.Z = parcel.readDouble();
        this.aa = parcel.readInt();
        this.ab = parcel.readInt();
        this.n = parcel.readString();
        try {
            this.ac = (BDLocation) parcel.readParcelable(BDLocation.class.getClassLoader());
        } catch (Exception e) {
            this.ac = null;
            e.printStackTrace();
        }
        try {
            parcel.readBooleanArray(zArr);
            this.e = zArr[0];
            this.g = zArr[1];
            this.i = zArr[2];
            this.k = zArr[3];
            this.o = zArr[4];
            this.t = zArr[5];
            this.y = zArr[6];
            this.W = zArr[7];
        } catch (Exception e2) {
        }
        ArrayList arrayList = new ArrayList();
        try {
            parcel.readList(arrayList, Poi.class.getClassLoader());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (arrayList.size() == 0) {
            this.L = null;
        } else {
            this.L = arrayList;
        }
        try {
            this.P = parcel.readBundle();
        } catch (Exception e4) {
            e4.printStackTrace();
            this.P = new Bundle();
        }
        try {
            this.X = (PoiRegion) parcel.readParcelable(PoiRegion.class.getClassLoader());
        } catch (Exception e5) {
            this.X = null;
            e5.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ BDLocation(Parcel parcel, a aVar) {
        this(parcel);
    }

    public BDLocation(BDLocation bDLocation) {
        int i = 0;
        this.f1852a = 0;
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
        this.O = null;
        this.P = new Bundle();
        this.Q = 0;
        this.R = 0;
        this.S = 0L;
        this.T = null;
        this.U = Double.MIN_VALUE;
        this.V = Double.MIN_VALUE;
        this.W = false;
        this.X = null;
        this.Y = -1.0f;
        this.Z = -1.0d;
        this.aa = 0;
        this.ab = -1;
        this.f1852a = bDLocation.f1852a;
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
        this.u = new Address.Builder().country(bDLocation.u.country).countryCode(bDLocation.u.countryCode).province(bDLocation.u.province).city(bDLocation.u.city).cityCode(bDLocation.u.cityCode).district(bDLocation.u.district).street(bDLocation.u.street).streetNumber(bDLocation.u.streetNumber).adcode(bDLocation.u.adcode).town(bDLocation.u.town).build();
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
        this.Q = bDLocation.Q;
        this.O = bDLocation.O;
        this.U = bDLocation.U;
        this.V = bDLocation.V;
        this.S = bDLocation.S;
        this.Z = bDLocation.Z;
        this.aa = bDLocation.aa;
        this.ab = bDLocation.ab;
        this.ac = bDLocation.ac;
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
                arrayList.add(new Poi(poi.getId(), poi.getName(), poi.getRank(), poi.getTags(), poi.getAddr()));
                i = i2 + 1;
            }
            this.L = arrayList;
        }
        this.M = bDLocation.M;
        this.P = bDLocation.P;
        this.R = bDLocation.R;
        this.W = bDLocation.W;
        this.X = bDLocation.X;
        this.Y = bDLocation.Y;
    }

    public BDLocation(String str) {
        String string;
        String[] split;
        JSONObject jSONObject;
        boolean z;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        boolean z2;
        this.f1852a = 0;
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
        this.O = null;
        this.P = new Bundle();
        this.Q = 0;
        this.R = 0;
        this.S = 0L;
        this.T = null;
        this.U = Double.MIN_VALUE;
        this.V = Double.MIN_VALUE;
        this.W = false;
        this.X = null;
        this.Y = -1.0f;
        this.Z = -1.0d;
        this.aa = 0;
        this.ab = -1;
        if (str == null || str.equals("")) {
            return;
        }
        try {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                JSONObject jSONObject3 = jSONObject2.getJSONObject("result");
                int parseInt = Integer.parseInt(jSONObject3.getString(BdStatsConstant.StatsType.ERROR));
                setLocType(parseInt);
                setTime(jSONObject3.getString("time"));
                if (parseInt == 61) {
                    JSONObject jSONObject4 = jSONObject2.getJSONObject("content");
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(Config.EVENT_HEAT_POINT);
                    setLatitude(Double.parseDouble(jSONObject5.getString("y")));
                    setLongitude(Double.parseDouble(jSONObject5.getString("x")));
                    setRadius(Float.parseFloat(jSONObject4.getString("radius")));
                    setSpeed(Float.parseFloat(jSONObject4.getString("s")));
                    setDirection(Float.parseFloat(jSONObject4.getString("d")));
                    setSatelliteNumber(Integer.parseInt(jSONObject4.getString("n")));
                    if (jSONObject4.has("is_mock")) {
                        setMockGpsStrategy(jSONObject4.getInt("is_mock"));
                    }
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
                        setCoorType(CoordinateType.WGS84);
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
                    JSONObject jSONObject7 = jSONObject6.getJSONObject(Config.EVENT_HEAT_POINT);
                    setLatitude(Double.parseDouble(jSONObject7.getString("y")));
                    setLongitude(Double.parseDouble(jSONObject7.getString("x")));
                    setRadius(Float.parseFloat(jSONObject6.getString("radius")));
                    a(Boolean.valueOf(Boolean.parseBoolean(jSONObject6.getString("isCellChanged"))));
                    setCoorType("gcj02");
                } else {
                    JSONObject jSONObject8 = jSONObject2.getJSONObject("content");
                    JSONObject jSONObject9 = jSONObject8.getJSONObject(Config.EVENT_HEAT_POINT);
                    setLatitude(Double.parseDouble(jSONObject9.getString("y")));
                    setLongitude(Double.parseDouble(jSONObject9.getString("x")));
                    setRadius(Float.parseFloat(jSONObject8.getString("radius")));
                    if (jSONObject8.has("sema")) {
                        JSONObject jSONObject10 = jSONObject8.getJSONObject("sema");
                        if (jSONObject10.has("aptag")) {
                            String string2 = jSONObject10.getString("aptag");
                            if (TextUtils.isEmpty(string2)) {
                                this.q = "";
                            } else {
                                this.q = string2;
                            }
                        }
                        if (jSONObject10.has("aptagd")) {
                            JSONArray jSONArray = jSONObject10.getJSONObject("aptagd").getJSONArray("pois");
                            ArrayList arrayList = new ArrayList();
                            for (int i = 0; i < jSONArray.length(); i++) {
                                JSONObject jSONObject11 = jSONArray.getJSONObject(i);
                                String string3 = jSONObject11.getString("pname");
                                String string4 = jSONObject11.getString("pid");
                                double d = jSONObject11.getDouble(Config.PRINCIPAL_PART);
                                String str12 = "";
                                String string5 = jSONObject11.has(CommandMessage.TYPE_TAGS) ? jSONObject11.getString(CommandMessage.TYPE_TAGS) : "";
                                if (jSONObject11.has("addr")) {
                                    str12 = jSONObject11.getString("addr");
                                }
                                arrayList.add(new Poi(string4, string3, d, string5, str12));
                            }
                            this.L = arrayList;
                        }
                        if (jSONObject10.has("poiregion")) {
                            String string6 = jSONObject10.getString("poiregion");
                            if (!TextUtils.isEmpty(string6)) {
                                this.r = string6;
                            }
                        }
                        if (jSONObject10.has("poi_regions")) {
                            JSONObject jSONObject12 = jSONObject10.getJSONObject("poi_regions");
                            this.X = new PoiRegion(jSONObject12.has("direction_desc") ? jSONObject12.getString("direction_desc") : "", jSONObject12.has("name") ? jSONObject12.getString("name") : "", jSONObject12.has("tag") ? jSONObject12.getString("tag") : "");
                        }
                        if (jSONObject10.has("regular")) {
                            String string7 = jSONObject10.getString("regular");
                            if (!TextUtils.isEmpty(string7)) {
                                this.s = string7;
                            }
                        }
                    }
                    if (jSONObject8.has("addr")) {
                        try {
                            jSONObject = jSONObject8.getJSONObject("addr");
                            z = true;
                        } catch (Exception e3) {
                            jSONObject = null;
                            z = false;
                        }
                        if (jSONObject != null) {
                            str6 = jSONObject.has("city") ? jSONObject.getString("city") : "";
                            str7 = jSONObject.has("city_code") ? jSONObject.getString("city_code") : "";
                            String string8 = jSONObject.has("country") ? jSONObject.getString("country") : "";
                            str4 = jSONObject.has("country_code") ? jSONObject.getString("country_code") : "";
                            str5 = jSONObject.has("province") ? jSONObject.getString("province") : "";
                            str8 = jSONObject.has("district") ? jSONObject.getString("district") : "";
                            str9 = jSONObject.has("street") ? jSONObject.getString("street") : "";
                            str10 = jSONObject.has("street_number") ? jSONObject.getString("street_number") : "";
                            str11 = jSONObject.has("adcode") ? jSONObject.getString("adcode") : "";
                            if (jSONObject.has("town")) {
                                str3 = string8;
                                z2 = z;
                                str2 = jSONObject.getString("town");
                            } else {
                                z2 = z;
                                str2 = null;
                                str3 = string8;
                            }
                        } else {
                            try {
                                String[] split2 = jSONObject8.getString("addr").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                int length = split2.length;
                                r9 = length > 0 ? split2[0] : null;
                                r8 = length > 1 ? split2[1] : null;
                                r6 = length > 2 ? split2[2] : null;
                                r5 = length > 3 ? split2[3] : null;
                                r4 = length > 4 ? split2[4] : null;
                                r7 = length > 5 ? split2[5] : null;
                                r11 = length > 6 ? split2[6] : null;
                                r10 = length > 7 ? split2[7] : null;
                                String str13 = length > 8 ? split2[8] : null;
                                str2 = null;
                                str3 = r11;
                                str4 = r10;
                                str5 = r9;
                                str6 = r8;
                                str7 = r7;
                                str8 = r6;
                                str9 = r5;
                                str10 = r4;
                                str11 = str13;
                                z2 = true;
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                str2 = null;
                                str3 = r11;
                                str4 = r10;
                                str5 = r9;
                                str6 = r8;
                                str7 = r7;
                                str8 = r6;
                                str9 = r5;
                                str10 = r4;
                                str11 = null;
                                z2 = false;
                            }
                        }
                        if (z2) {
                            this.u = new Address.Builder().country(str3).countryCode(str4).province(str5).city(str6).cityCode(str7).district(str8).street(str9).streetNumber(str10).adcode(str11).town(str2).build();
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
                        String string9 = jSONObject8.getString("indoor");
                        if (!TextUtils.isEmpty(string9)) {
                            setUserIndoorState(Integer.valueOf(string9).intValue());
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
                        String string10 = jSONObject8.getString("ibav");
                        if (TextUtils.isEmpty(string10)) {
                            this.z = 0;
                        } else if (string10.equals("0")) {
                            this.z = 0;
                        } else {
                            this.z = Integer.valueOf(string10).intValue();
                        }
                    }
                    if (jSONObject8.has("indoorflags")) {
                        try {
                            JSONObject jSONObject13 = jSONObject8.getJSONObject("indoorflags");
                            if (jSONObject13.has(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA)) {
                                int intValue = Integer.valueOf(jSONObject13.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA)).intValue();
                                if (intValue == 0) {
                                    setIndoorLocationSurpport(2);
                                } else if (intValue == 1) {
                                    setIndoorLocationSurpport(1);
                                }
                            }
                            if (jSONObject13.has("support")) {
                                setIndoorLocationSource(Integer.valueOf(jSONObject13.getString("support")).intValue());
                            }
                            if (jSONObject13.has("inbldg")) {
                                this.I = jSONObject13.getString("inbldg");
                            }
                            if (jSONObject13.has("inbldgid")) {
                                this.J = jSONObject13.getString("inbldgid");
                            }
                            if (jSONObject13.has("polygon")) {
                                setIndoorSurpportPolygon(jSONObject13.getString("polygon"));
                            }
                            if (jSONObject13.has("ret_fields")) {
                                try {
                                    String[] split3 = jSONObject13.getString("ret_fields").split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
                                    for (String str14 : split3) {
                                        String[] split4 = str14.split(ETAG.EQUAL);
                                        if (split4 != null && split4.length >= 2) {
                                            this.P.putString(split4[0], split4[1]);
                                        }
                                    }
                                } catch (Exception e5) {
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
                        setCoorType(CoordinateType.WGS84);
                    } else {
                        setCoorType("gcj02");
                    }
                    if (jSONObject8.has("navi")) {
                        this.T = jSONObject8.getString("navi");
                    }
                    if (jSONObject8.has("navi_client") && (string = jSONObject8.getString("navi_client")) != null) {
                        try {
                            if (string.contains(Constants.ACCEPT_TIME_SEPARATOR_SP) && (split = string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length >= 2) {
                                int intValue2 = Integer.valueOf(split[0]).intValue();
                                Integer.valueOf(split[1]).intValue();
                                if (intValue2 > 0) {
                                    this.W = true;
                                }
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    if (jSONObject8.has("nrl_point")) {
                        try {
                            JSONObject jSONObject14 = jSONObject8.getJSONObject("nrl_point");
                            if (jSONObject14.has("x") && jSONObject14.has("y")) {
                                this.U = Double.parseDouble(jSONObject14.getString("y"));
                                this.V = Double.parseDouble(jSONObject14.getString("x"));
                            }
                        } catch (Throwable th2) {
                            this.U = Double.MIN_VALUE;
                            this.V = Double.MIN_VALUE;
                        }
                    }
                }
            } catch (Exception e8) {
                e8.printStackTrace();
                this.f1852a = 0;
                this.o = false;
            }
        } catch (Error e9) {
            e9.printStackTrace();
            this.f1852a = 0;
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

    public long getDelayTime() {
        return this.S;
    }

    @Deprecated
    public float getDerect() {
        return this.m;
    }

    public float getDirection() {
        return this.m;
    }

    public double getDisToRealLocation() {
        return this.Z;
    }

    public String getDistrict() {
        return this.u.district;
    }

    public Location getExtraLocation(String str) {
        if (this.P != null) {
            Parcelable parcelable = this.P.getParcelable(str);
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
        return this.P.getDoubleArray(str);
    }

    public int getGpsAccuracyStatus() {
        return this.Q;
    }

    public float getGpsBiasProb() {
        return this.Y;
    }

    public int getGpsCheckStatus() {
        return this.R;
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
        return this.f1852a;
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

    public int getMockGpsProbability() {
        return this.ab;
    }

    public int getMockGpsStrategy() {
        return this.aa;
    }

    public String getNetworkLocationType() {
        return this.B;
    }

    public double getNrlLat() {
        return this.U;
    }

    public double getNrlLon() {
        return this.V;
    }

    public String getNrlResult() {
        return this.T;
    }

    public int getOperators() {
        return this.C;
    }

    public List<Poi> getPoiList() {
        return this.L;
    }

    public PoiRegion getPoiRegion() {
        return this.X;
    }

    public String getProvince() {
        return this.u.province;
    }

    public float getRadius() {
        return this.j;
    }

    public BDLocation getReallLocation() {
        if (getMockGpsStrategy() > 0) {
            return this.ac;
        }
        return null;
    }

    public String getRetFields(String str) {
        return this.P.getString(str);
    }

    public String getRoadLocString() {
        return this.O;
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

    public String getTown() {
        return this.u.town;
    }

    public int getUserIndoorState() {
        return this.E;
    }

    public String getVdrJsonString() {
        if (this.P == null || !this.P.containsKey("vdr")) {
            return null;
        }
        return this.P.getString("vdr");
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

    public boolean isInIndoorPark() {
        return this.W;
    }

    public boolean isIndoorLocMode() {
        return this.y;
    }

    public boolean isNrlAvailable() {
        return (this.V == Double.MIN_VALUE || this.U == Double.MIN_VALUE) ? false : true;
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
        if (d < 9999.0d) {
            this.f = d;
            this.e = true;
        }
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

    public void setDelayTime(long j) {
        this.S = j;
    }

    public void setDirection(float f) {
        this.m = f;
    }

    public void setDisToRealLocation(double d) {
        this.Z = d;
    }

    public void setExtraLocation(String str, Location location) {
        if (this.P == null) {
            this.P = new Bundle();
        }
        this.P.putParcelable(str, location);
    }

    public void setFloor(String str) {
        this.v = str;
    }

    public void setFusionLocInfo(String str, double[] dArr) {
        if (this.P == null) {
            this.P = new Bundle();
        }
        this.P.putDoubleArray(str, dArr);
    }

    public void setGpsAccuracyStatus(int i) {
        this.Q = i;
    }

    public void setGpsBiasProb(float f) {
        this.Y = f;
    }

    public void setGpsCheckStatus(int i) {
        this.R = i;
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

    public void setIsInIndoorPark(boolean z) {
        this.W = z;
    }

    public void setLatitude(double d) {
        this.c = d;
    }

    public void setLocType(int i) {
        this.f1852a = i;
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
            case 161:
                setLocTypeDescription("NetWork location successful!");
                return;
            case 162:
                setLocTypeDescription("NetWork location failed because baidu location service can not decrypt the request query, please check the so file !");
                return;
            case 167:
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

    public void setMockGpsProbability(int i) {
        this.ab = i;
    }

    public void setMockGpsStrategy(int i) {
        this.aa = i;
    }

    public void setNetworkLocationType(String str) {
        this.B = str;
    }

    public void setNrlData(String str) {
        this.T = str;
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

    public void setPoiRegion(PoiRegion poiRegion) {
        this.X = poiRegion;
    }

    public void setRadius(float f) {
        this.j = f;
        this.i = true;
    }

    public void setReallLocation(BDLocation bDLocation) {
        if (getMockGpsStrategy() > 0) {
            this.ac = bDLocation;
        }
    }

    public void setRetFields(String str, String str2) {
        if (this.P == null) {
            this.P = new Bundle();
        }
        this.P.putString(str, str2);
    }

    public void setRoadLocString(float f, float f2) {
        String format = ((double) f) > 0.001d ? String.format("%.2f", Float.valueOf(f)) : "";
        String format2 = ((double) f2) > 0.001d ? String.format("%.2f", Float.valueOf(f2)) : "";
        if (this.T != null) {
            this.O = String.format(Locale.US, "%s|%s,%s", this.T, format, format2);
        }
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
        setLocationID(l.a(str));
    }

    public void setUserIndoorState(int i) {
        this.E = i;
    }

    public void setVdrJsonValue(String str) {
        if (this.P == null) {
            this.P = new Bundle();
        }
        this.P.putString("vdr", str);
    }

    public String toString() {
        return "&loctype=" + getLocType() + "&lat=" + getLatitude() + "&lon=" + getLongitude() + "&radius=" + getRadius() + "&biasprob=" + getGpsBiasProb();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1852a);
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
        parcel.writeString(this.u.town);
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
        parcel.writeInt(this.Q);
        parcel.writeString(this.N);
        parcel.writeInt(this.R);
        parcel.writeString(this.O);
        parcel.writeString(this.T);
        parcel.writeLong(this.S);
        parcel.writeDouble(this.U);
        parcel.writeDouble(this.V);
        parcel.writeFloat(this.Y);
        parcel.writeDouble(this.Z);
        parcel.writeInt(this.aa);
        parcel.writeInt(this.ab);
        parcel.writeString(this.n);
        parcel.writeParcelable(this.ac, i);
        parcel.writeBooleanArray(new boolean[]{this.e, this.g, this.i, this.k, this.o, this.t, this.y, this.W});
        parcel.writeList(this.L);
        parcel.writeBundle(this.P);
        parcel.writeParcelable(this.X, i);
    }
}
