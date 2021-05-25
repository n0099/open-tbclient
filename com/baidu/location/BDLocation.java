package com.baidu.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.messages.DuPaBInfoMsg;
import com.baidu.location.Address;
import com.baidu.location.e.k;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.wallet.core.beans.BeanConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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
    public int A;
    public String B;
    public int C;
    public String D;
    public int E;
    public int F;
    public int G;
    public int H;
    public String I;
    public String J;
    public String K;
    public List<Poi> L;
    public String M;
    public String N;
    public String O;
    public Bundle P;
    public int Q;
    public int R;
    public long S;
    public String T;
    public double U;
    public double V;
    public boolean W;

    /* renamed from: a  reason: collision with root package name */
    public int f6394a;

    /* renamed from: b  reason: collision with root package name */
    public String f6395b;

    /* renamed from: c  reason: collision with root package name */
    public double f6396c;

    /* renamed from: d  reason: collision with root package name */
    public double f6397d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6398e;

    /* renamed from: f  reason: collision with root package name */
    public double f6399f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6400g;

    /* renamed from: h  reason: collision with root package name */
    public float f6401h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6402i;
    public float j;
    public boolean k;
    public int l;
    public float m;
    public String n;
    public boolean o;
    public String p;
    public String q;
    public String r;
    public String s;
    public boolean t;
    public Address u;
    public String v;
    public String w;
    public String x;
    public boolean y;
    public int z;

    public BDLocation() {
        this.f6394a = 0;
        this.f6395b = null;
        this.f6396c = Double.MIN_VALUE;
        this.f6397d = Double.MIN_VALUE;
        this.f6398e = false;
        this.f6399f = Double.MIN_VALUE;
        this.f6400g = false;
        this.f6401h = 0.0f;
        this.f6402i = false;
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
    }

    public BDLocation(Parcel parcel) {
        this.f6394a = 0;
        this.f6395b = null;
        this.f6396c = Double.MIN_VALUE;
        this.f6397d = Double.MIN_VALUE;
        this.f6398e = false;
        this.f6399f = Double.MIN_VALUE;
        this.f6400g = false;
        this.f6401h = 0.0f;
        this.f6402i = false;
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
        this.f6394a = parcel.readInt();
        this.f6395b = parcel.readString();
        this.f6396c = parcel.readDouble();
        this.f6397d = parcel.readDouble();
        this.f6399f = parcel.readDouble();
        this.f6401h = parcel.readFloat();
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
        try {
            parcel.readBooleanArray(zArr);
            this.f6398e = zArr[0];
            this.f6400g = zArr[1];
            this.f6402i = zArr[2];
            this.k = zArr[3];
            this.o = zArr[4];
            this.t = zArr[5];
            this.y = zArr[6];
            this.W = zArr[7];
        } catch (Exception unused) {
        }
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, Poi.class.getClassLoader());
        if (arrayList.size() == 0) {
            this.L = null;
        } else {
            this.L = arrayList;
        }
        try {
            this.P = parcel.readBundle();
        } catch (Exception e2) {
            e2.printStackTrace();
            this.P = new Bundle();
        }
    }

    public /* synthetic */ BDLocation(Parcel parcel, a aVar) {
        this(parcel);
    }

    public BDLocation(BDLocation bDLocation) {
        this.f6394a = 0;
        ArrayList arrayList = null;
        this.f6395b = null;
        this.f6396c = Double.MIN_VALUE;
        this.f6397d = Double.MIN_VALUE;
        this.f6398e = false;
        this.f6399f = Double.MIN_VALUE;
        this.f6400g = false;
        this.f6401h = 0.0f;
        this.f6402i = false;
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
        this.f6394a = bDLocation.f6394a;
        this.f6395b = bDLocation.f6395b;
        this.f6396c = bDLocation.f6396c;
        this.f6397d = bDLocation.f6397d;
        this.f6398e = bDLocation.f6398e;
        this.f6399f = bDLocation.f6399f;
        this.f6400g = bDLocation.f6400g;
        this.f6401h = bDLocation.f6401h;
        this.f6402i = bDLocation.f6402i;
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
        this.Q = bDLocation.Q;
        this.O = bDLocation.O;
        this.U = bDLocation.U;
        this.V = bDLocation.V;
        this.S = bDLocation.S;
        this.N = bDLocation.N;
        if (bDLocation.L != null) {
            arrayList = new ArrayList();
            for (int i2 = 0; i2 < bDLocation.L.size(); i2++) {
                Poi poi = bDLocation.L.get(i2);
                arrayList.add(new Poi(poi.getId(), poi.getName(), poi.getRank()));
            }
        }
        this.L = arrayList;
        this.M = bDLocation.M;
        this.P = bDLocation.P;
        this.R = bDLocation.R;
        this.W = bDLocation.W;
    }

    /* JADX WARN: Removed duplicated region for block: B:171:0x039e A[Catch: Exception -> 0x0646, Error -> 0x064a, TryCatch #4 {Error -> 0x064a, blocks: (B:7:0x009e, B:8:0x00a0, B:11:0x00da, B:13:0x0132, B:14:0x013b, B:16:0x0141, B:17:0x014d, B:18:0x0151, B:21:0x0158, B:22:0x015d, B:25:0x0167, B:27:0x0198, B:29:0x01a2, B:31:0x01ac, B:32:0x01af, B:33:0x01b1, B:35:0x01b7, B:36:0x01c7, B:38:0x01cd, B:39:0x01f2, B:41:0x01f9, B:43:0x0201, B:45:0x020d, B:46:0x020f, B:48:0x0217, B:50:0x0223, B:52:0x0228, B:55:0x0232, B:59:0x023c, B:61:0x0244, B:63:0x024d, B:65:0x0255, B:67:0x025e, B:69:0x0266, B:71:0x026f, B:73:0x0277, B:75:0x0280, B:77:0x0288, B:79:0x0291, B:81:0x0299, B:83:0x02a2, B:85:0x02ab, B:87:0x02b9, B:89:0x02c2, B:91:0x02ce, B:93:0x02d6, B:171:0x039e, B:173:0x03da, B:175:0x03e2, B:177:0x03ee, B:178:0x03f1, B:180:0x03f9, B:182:0x0403, B:183:0x040e, B:185:0x0416, B:187:0x0424, B:188:0x0427, B:190:0x042f, B:192:0x043d, B:193:0x0440, B:195:0x0448, B:197:0x0456, B:198:0x0459, B:200:0x0461, B:202:0x046d, B:203:0x0471, B:206:0x047a, B:207:0x0484, B:209:0x048c, B:211:0x049a, B:213:0x04aa, B:216:0x04b2, B:217:0x04b5, B:219:0x04be, B:220:0x04d0, B:222:0x04d8, B:223:0x04e0, B:225:0x04e8, B:226:0x04f0, B:228:0x04f8, B:229:0x0501, B:231:0x0509, B:233:0x0519, B:237:0x0531, B:242:0x053a, B:244:0x0542, B:246:0x0550, B:248:0x0556, B:249:0x0562, B:250:0x0566, B:253:0x056d, B:255:0x0574, B:257:0x057c, B:258:0x0584, B:260:0x058c, B:270:0x05ba, B:271:0x05bd, B:280:0x05f1, B:245:0x054c, B:241:0x0537, B:96:0x02f3, B:98:0x02fe, B:102:0x0307, B:108:0x0314, B:116:0x0321, B:124:0x032e, B:132:0x033a, B:140:0x0346, B:148:0x0356, B:156:0x0368, B:169:0x038a, B:172:0x03d1, B:288:0x0605, B:289:0x060a), top: B:311:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03e2 A[Catch: Exception -> 0x0646, Error -> 0x064a, TryCatch #4 {Error -> 0x064a, blocks: (B:7:0x009e, B:8:0x00a0, B:11:0x00da, B:13:0x0132, B:14:0x013b, B:16:0x0141, B:17:0x014d, B:18:0x0151, B:21:0x0158, B:22:0x015d, B:25:0x0167, B:27:0x0198, B:29:0x01a2, B:31:0x01ac, B:32:0x01af, B:33:0x01b1, B:35:0x01b7, B:36:0x01c7, B:38:0x01cd, B:39:0x01f2, B:41:0x01f9, B:43:0x0201, B:45:0x020d, B:46:0x020f, B:48:0x0217, B:50:0x0223, B:52:0x0228, B:55:0x0232, B:59:0x023c, B:61:0x0244, B:63:0x024d, B:65:0x0255, B:67:0x025e, B:69:0x0266, B:71:0x026f, B:73:0x0277, B:75:0x0280, B:77:0x0288, B:79:0x0291, B:81:0x0299, B:83:0x02a2, B:85:0x02ab, B:87:0x02b9, B:89:0x02c2, B:91:0x02ce, B:93:0x02d6, B:171:0x039e, B:173:0x03da, B:175:0x03e2, B:177:0x03ee, B:178:0x03f1, B:180:0x03f9, B:182:0x0403, B:183:0x040e, B:185:0x0416, B:187:0x0424, B:188:0x0427, B:190:0x042f, B:192:0x043d, B:193:0x0440, B:195:0x0448, B:197:0x0456, B:198:0x0459, B:200:0x0461, B:202:0x046d, B:203:0x0471, B:206:0x047a, B:207:0x0484, B:209:0x048c, B:211:0x049a, B:213:0x04aa, B:216:0x04b2, B:217:0x04b5, B:219:0x04be, B:220:0x04d0, B:222:0x04d8, B:223:0x04e0, B:225:0x04e8, B:226:0x04f0, B:228:0x04f8, B:229:0x0501, B:231:0x0509, B:233:0x0519, B:237:0x0531, B:242:0x053a, B:244:0x0542, B:246:0x0550, B:248:0x0556, B:249:0x0562, B:250:0x0566, B:253:0x056d, B:255:0x0574, B:257:0x057c, B:258:0x0584, B:260:0x058c, B:270:0x05ba, B:271:0x05bd, B:280:0x05f1, B:245:0x054c, B:241:0x0537, B:96:0x02f3, B:98:0x02fe, B:102:0x0307, B:108:0x0314, B:116:0x0321, B:124:0x032e, B:132:0x033a, B:140:0x0346, B:148:0x0356, B:156:0x0368, B:169:0x038a, B:172:0x03d1, B:288:0x0605, B:289:0x060a), top: B:311:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03f9 A[Catch: Exception -> 0x0646, Error -> 0x064a, TryCatch #4 {Error -> 0x064a, blocks: (B:7:0x009e, B:8:0x00a0, B:11:0x00da, B:13:0x0132, B:14:0x013b, B:16:0x0141, B:17:0x014d, B:18:0x0151, B:21:0x0158, B:22:0x015d, B:25:0x0167, B:27:0x0198, B:29:0x01a2, B:31:0x01ac, B:32:0x01af, B:33:0x01b1, B:35:0x01b7, B:36:0x01c7, B:38:0x01cd, B:39:0x01f2, B:41:0x01f9, B:43:0x0201, B:45:0x020d, B:46:0x020f, B:48:0x0217, B:50:0x0223, B:52:0x0228, B:55:0x0232, B:59:0x023c, B:61:0x0244, B:63:0x024d, B:65:0x0255, B:67:0x025e, B:69:0x0266, B:71:0x026f, B:73:0x0277, B:75:0x0280, B:77:0x0288, B:79:0x0291, B:81:0x0299, B:83:0x02a2, B:85:0x02ab, B:87:0x02b9, B:89:0x02c2, B:91:0x02ce, B:93:0x02d6, B:171:0x039e, B:173:0x03da, B:175:0x03e2, B:177:0x03ee, B:178:0x03f1, B:180:0x03f9, B:182:0x0403, B:183:0x040e, B:185:0x0416, B:187:0x0424, B:188:0x0427, B:190:0x042f, B:192:0x043d, B:193:0x0440, B:195:0x0448, B:197:0x0456, B:198:0x0459, B:200:0x0461, B:202:0x046d, B:203:0x0471, B:206:0x047a, B:207:0x0484, B:209:0x048c, B:211:0x049a, B:213:0x04aa, B:216:0x04b2, B:217:0x04b5, B:219:0x04be, B:220:0x04d0, B:222:0x04d8, B:223:0x04e0, B:225:0x04e8, B:226:0x04f0, B:228:0x04f8, B:229:0x0501, B:231:0x0509, B:233:0x0519, B:237:0x0531, B:242:0x053a, B:244:0x0542, B:246:0x0550, B:248:0x0556, B:249:0x0562, B:250:0x0566, B:253:0x056d, B:255:0x0574, B:257:0x057c, B:258:0x0584, B:260:0x058c, B:270:0x05ba, B:271:0x05bd, B:280:0x05f1, B:245:0x054c, B:241:0x0537, B:96:0x02f3, B:98:0x02fe, B:102:0x0307, B:108:0x0314, B:116:0x0321, B:124:0x032e, B:132:0x033a, B:140:0x0346, B:148:0x0356, B:156:0x0368, B:169:0x038a, B:172:0x03d1, B:288:0x0605, B:289:0x060a), top: B:311:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0416 A[Catch: Exception -> 0x0646, Error -> 0x064a, TryCatch #4 {Error -> 0x064a, blocks: (B:7:0x009e, B:8:0x00a0, B:11:0x00da, B:13:0x0132, B:14:0x013b, B:16:0x0141, B:17:0x014d, B:18:0x0151, B:21:0x0158, B:22:0x015d, B:25:0x0167, B:27:0x0198, B:29:0x01a2, B:31:0x01ac, B:32:0x01af, B:33:0x01b1, B:35:0x01b7, B:36:0x01c7, B:38:0x01cd, B:39:0x01f2, B:41:0x01f9, B:43:0x0201, B:45:0x020d, B:46:0x020f, B:48:0x0217, B:50:0x0223, B:52:0x0228, B:55:0x0232, B:59:0x023c, B:61:0x0244, B:63:0x024d, B:65:0x0255, B:67:0x025e, B:69:0x0266, B:71:0x026f, B:73:0x0277, B:75:0x0280, B:77:0x0288, B:79:0x0291, B:81:0x0299, B:83:0x02a2, B:85:0x02ab, B:87:0x02b9, B:89:0x02c2, B:91:0x02ce, B:93:0x02d6, B:171:0x039e, B:173:0x03da, B:175:0x03e2, B:177:0x03ee, B:178:0x03f1, B:180:0x03f9, B:182:0x0403, B:183:0x040e, B:185:0x0416, B:187:0x0424, B:188:0x0427, B:190:0x042f, B:192:0x043d, B:193:0x0440, B:195:0x0448, B:197:0x0456, B:198:0x0459, B:200:0x0461, B:202:0x046d, B:203:0x0471, B:206:0x047a, B:207:0x0484, B:209:0x048c, B:211:0x049a, B:213:0x04aa, B:216:0x04b2, B:217:0x04b5, B:219:0x04be, B:220:0x04d0, B:222:0x04d8, B:223:0x04e0, B:225:0x04e8, B:226:0x04f0, B:228:0x04f8, B:229:0x0501, B:231:0x0509, B:233:0x0519, B:237:0x0531, B:242:0x053a, B:244:0x0542, B:246:0x0550, B:248:0x0556, B:249:0x0562, B:250:0x0566, B:253:0x056d, B:255:0x0574, B:257:0x057c, B:258:0x0584, B:260:0x058c, B:270:0x05ba, B:271:0x05bd, B:280:0x05f1, B:245:0x054c, B:241:0x0537, B:96:0x02f3, B:98:0x02fe, B:102:0x0307, B:108:0x0314, B:116:0x0321, B:124:0x032e, B:132:0x033a, B:140:0x0346, B:148:0x0356, B:156:0x0368, B:169:0x038a, B:172:0x03d1, B:288:0x0605, B:289:0x060a), top: B:311:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x042f A[Catch: Exception -> 0x0646, Error -> 0x064a, TryCatch #4 {Error -> 0x064a, blocks: (B:7:0x009e, B:8:0x00a0, B:11:0x00da, B:13:0x0132, B:14:0x013b, B:16:0x0141, B:17:0x014d, B:18:0x0151, B:21:0x0158, B:22:0x015d, B:25:0x0167, B:27:0x0198, B:29:0x01a2, B:31:0x01ac, B:32:0x01af, B:33:0x01b1, B:35:0x01b7, B:36:0x01c7, B:38:0x01cd, B:39:0x01f2, B:41:0x01f9, B:43:0x0201, B:45:0x020d, B:46:0x020f, B:48:0x0217, B:50:0x0223, B:52:0x0228, B:55:0x0232, B:59:0x023c, B:61:0x0244, B:63:0x024d, B:65:0x0255, B:67:0x025e, B:69:0x0266, B:71:0x026f, B:73:0x0277, B:75:0x0280, B:77:0x0288, B:79:0x0291, B:81:0x0299, B:83:0x02a2, B:85:0x02ab, B:87:0x02b9, B:89:0x02c2, B:91:0x02ce, B:93:0x02d6, B:171:0x039e, B:173:0x03da, B:175:0x03e2, B:177:0x03ee, B:178:0x03f1, B:180:0x03f9, B:182:0x0403, B:183:0x040e, B:185:0x0416, B:187:0x0424, B:188:0x0427, B:190:0x042f, B:192:0x043d, B:193:0x0440, B:195:0x0448, B:197:0x0456, B:198:0x0459, B:200:0x0461, B:202:0x046d, B:203:0x0471, B:206:0x047a, B:207:0x0484, B:209:0x048c, B:211:0x049a, B:213:0x04aa, B:216:0x04b2, B:217:0x04b5, B:219:0x04be, B:220:0x04d0, B:222:0x04d8, B:223:0x04e0, B:225:0x04e8, B:226:0x04f0, B:228:0x04f8, B:229:0x0501, B:231:0x0509, B:233:0x0519, B:237:0x0531, B:242:0x053a, B:244:0x0542, B:246:0x0550, B:248:0x0556, B:249:0x0562, B:250:0x0566, B:253:0x056d, B:255:0x0574, B:257:0x057c, B:258:0x0584, B:260:0x058c, B:270:0x05ba, B:271:0x05bd, B:280:0x05f1, B:245:0x054c, B:241:0x0537, B:96:0x02f3, B:98:0x02fe, B:102:0x0307, B:108:0x0314, B:116:0x0321, B:124:0x032e, B:132:0x033a, B:140:0x0346, B:148:0x0356, B:156:0x0368, B:169:0x038a, B:172:0x03d1, B:288:0x0605, B:289:0x060a), top: B:311:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0448 A[Catch: Exception -> 0x0646, Error -> 0x064a, TryCatch #4 {Error -> 0x064a, blocks: (B:7:0x009e, B:8:0x00a0, B:11:0x00da, B:13:0x0132, B:14:0x013b, B:16:0x0141, B:17:0x014d, B:18:0x0151, B:21:0x0158, B:22:0x015d, B:25:0x0167, B:27:0x0198, B:29:0x01a2, B:31:0x01ac, B:32:0x01af, B:33:0x01b1, B:35:0x01b7, B:36:0x01c7, B:38:0x01cd, B:39:0x01f2, B:41:0x01f9, B:43:0x0201, B:45:0x020d, B:46:0x020f, B:48:0x0217, B:50:0x0223, B:52:0x0228, B:55:0x0232, B:59:0x023c, B:61:0x0244, B:63:0x024d, B:65:0x0255, B:67:0x025e, B:69:0x0266, B:71:0x026f, B:73:0x0277, B:75:0x0280, B:77:0x0288, B:79:0x0291, B:81:0x0299, B:83:0x02a2, B:85:0x02ab, B:87:0x02b9, B:89:0x02c2, B:91:0x02ce, B:93:0x02d6, B:171:0x039e, B:173:0x03da, B:175:0x03e2, B:177:0x03ee, B:178:0x03f1, B:180:0x03f9, B:182:0x0403, B:183:0x040e, B:185:0x0416, B:187:0x0424, B:188:0x0427, B:190:0x042f, B:192:0x043d, B:193:0x0440, B:195:0x0448, B:197:0x0456, B:198:0x0459, B:200:0x0461, B:202:0x046d, B:203:0x0471, B:206:0x047a, B:207:0x0484, B:209:0x048c, B:211:0x049a, B:213:0x04aa, B:216:0x04b2, B:217:0x04b5, B:219:0x04be, B:220:0x04d0, B:222:0x04d8, B:223:0x04e0, B:225:0x04e8, B:226:0x04f0, B:228:0x04f8, B:229:0x0501, B:231:0x0509, B:233:0x0519, B:237:0x0531, B:242:0x053a, B:244:0x0542, B:246:0x0550, B:248:0x0556, B:249:0x0562, B:250:0x0566, B:253:0x056d, B:255:0x0574, B:257:0x057c, B:258:0x0584, B:260:0x058c, B:270:0x05ba, B:271:0x05bd, B:280:0x05f1, B:245:0x054c, B:241:0x0537, B:96:0x02f3, B:98:0x02fe, B:102:0x0307, B:108:0x0314, B:116:0x0321, B:124:0x032e, B:132:0x033a, B:140:0x0346, B:148:0x0356, B:156:0x0368, B:169:0x038a, B:172:0x03d1, B:288:0x0605, B:289:0x060a), top: B:311:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0461 A[Catch: Exception -> 0x0646, Error -> 0x064a, TryCatch #4 {Error -> 0x064a, blocks: (B:7:0x009e, B:8:0x00a0, B:11:0x00da, B:13:0x0132, B:14:0x013b, B:16:0x0141, B:17:0x014d, B:18:0x0151, B:21:0x0158, B:22:0x015d, B:25:0x0167, B:27:0x0198, B:29:0x01a2, B:31:0x01ac, B:32:0x01af, B:33:0x01b1, B:35:0x01b7, B:36:0x01c7, B:38:0x01cd, B:39:0x01f2, B:41:0x01f9, B:43:0x0201, B:45:0x020d, B:46:0x020f, B:48:0x0217, B:50:0x0223, B:52:0x0228, B:55:0x0232, B:59:0x023c, B:61:0x0244, B:63:0x024d, B:65:0x0255, B:67:0x025e, B:69:0x0266, B:71:0x026f, B:73:0x0277, B:75:0x0280, B:77:0x0288, B:79:0x0291, B:81:0x0299, B:83:0x02a2, B:85:0x02ab, B:87:0x02b9, B:89:0x02c2, B:91:0x02ce, B:93:0x02d6, B:171:0x039e, B:173:0x03da, B:175:0x03e2, B:177:0x03ee, B:178:0x03f1, B:180:0x03f9, B:182:0x0403, B:183:0x040e, B:185:0x0416, B:187:0x0424, B:188:0x0427, B:190:0x042f, B:192:0x043d, B:193:0x0440, B:195:0x0448, B:197:0x0456, B:198:0x0459, B:200:0x0461, B:202:0x046d, B:203:0x0471, B:206:0x047a, B:207:0x0484, B:209:0x048c, B:211:0x049a, B:213:0x04aa, B:216:0x04b2, B:217:0x04b5, B:219:0x04be, B:220:0x04d0, B:222:0x04d8, B:223:0x04e0, B:225:0x04e8, B:226:0x04f0, B:228:0x04f8, B:229:0x0501, B:231:0x0509, B:233:0x0519, B:237:0x0531, B:242:0x053a, B:244:0x0542, B:246:0x0550, B:248:0x0556, B:249:0x0562, B:250:0x0566, B:253:0x056d, B:255:0x0574, B:257:0x057c, B:258:0x0584, B:260:0x058c, B:270:0x05ba, B:271:0x05bd, B:280:0x05f1, B:245:0x054c, B:241:0x0537, B:96:0x02f3, B:98:0x02fe, B:102:0x0307, B:108:0x0314, B:116:0x0321, B:124:0x032e, B:132:0x033a, B:140:0x0346, B:148:0x0356, B:156:0x0368, B:169:0x038a, B:172:0x03d1, B:288:0x0605, B:289:0x060a), top: B:311:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0542 A[Catch: Exception -> 0x0646, Error -> 0x064a, TryCatch #4 {Error -> 0x064a, blocks: (B:7:0x009e, B:8:0x00a0, B:11:0x00da, B:13:0x0132, B:14:0x013b, B:16:0x0141, B:17:0x014d, B:18:0x0151, B:21:0x0158, B:22:0x015d, B:25:0x0167, B:27:0x0198, B:29:0x01a2, B:31:0x01ac, B:32:0x01af, B:33:0x01b1, B:35:0x01b7, B:36:0x01c7, B:38:0x01cd, B:39:0x01f2, B:41:0x01f9, B:43:0x0201, B:45:0x020d, B:46:0x020f, B:48:0x0217, B:50:0x0223, B:52:0x0228, B:55:0x0232, B:59:0x023c, B:61:0x0244, B:63:0x024d, B:65:0x0255, B:67:0x025e, B:69:0x0266, B:71:0x026f, B:73:0x0277, B:75:0x0280, B:77:0x0288, B:79:0x0291, B:81:0x0299, B:83:0x02a2, B:85:0x02ab, B:87:0x02b9, B:89:0x02c2, B:91:0x02ce, B:93:0x02d6, B:171:0x039e, B:173:0x03da, B:175:0x03e2, B:177:0x03ee, B:178:0x03f1, B:180:0x03f9, B:182:0x0403, B:183:0x040e, B:185:0x0416, B:187:0x0424, B:188:0x0427, B:190:0x042f, B:192:0x043d, B:193:0x0440, B:195:0x0448, B:197:0x0456, B:198:0x0459, B:200:0x0461, B:202:0x046d, B:203:0x0471, B:206:0x047a, B:207:0x0484, B:209:0x048c, B:211:0x049a, B:213:0x04aa, B:216:0x04b2, B:217:0x04b5, B:219:0x04be, B:220:0x04d0, B:222:0x04d8, B:223:0x04e0, B:225:0x04e8, B:226:0x04f0, B:228:0x04f8, B:229:0x0501, B:231:0x0509, B:233:0x0519, B:237:0x0531, B:242:0x053a, B:244:0x0542, B:246:0x0550, B:248:0x0556, B:249:0x0562, B:250:0x0566, B:253:0x056d, B:255:0x0574, B:257:0x057c, B:258:0x0584, B:260:0x058c, B:270:0x05ba, B:271:0x05bd, B:280:0x05f1, B:245:0x054c, B:241:0x0537, B:96:0x02f3, B:98:0x02fe, B:102:0x0307, B:108:0x0314, B:116:0x0321, B:124:0x032e, B:132:0x033a, B:140:0x0346, B:148:0x0356, B:156:0x0368, B:169:0x038a, B:172:0x03d1, B:288:0x0605, B:289:0x060a), top: B:311:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x054c A[Catch: Exception -> 0x0646, Error -> 0x064a, TRY_LEAVE, TryCatch #4 {Error -> 0x064a, blocks: (B:7:0x009e, B:8:0x00a0, B:11:0x00da, B:13:0x0132, B:14:0x013b, B:16:0x0141, B:17:0x014d, B:18:0x0151, B:21:0x0158, B:22:0x015d, B:25:0x0167, B:27:0x0198, B:29:0x01a2, B:31:0x01ac, B:32:0x01af, B:33:0x01b1, B:35:0x01b7, B:36:0x01c7, B:38:0x01cd, B:39:0x01f2, B:41:0x01f9, B:43:0x0201, B:45:0x020d, B:46:0x020f, B:48:0x0217, B:50:0x0223, B:52:0x0228, B:55:0x0232, B:59:0x023c, B:61:0x0244, B:63:0x024d, B:65:0x0255, B:67:0x025e, B:69:0x0266, B:71:0x026f, B:73:0x0277, B:75:0x0280, B:77:0x0288, B:79:0x0291, B:81:0x0299, B:83:0x02a2, B:85:0x02ab, B:87:0x02b9, B:89:0x02c2, B:91:0x02ce, B:93:0x02d6, B:171:0x039e, B:173:0x03da, B:175:0x03e2, B:177:0x03ee, B:178:0x03f1, B:180:0x03f9, B:182:0x0403, B:183:0x040e, B:185:0x0416, B:187:0x0424, B:188:0x0427, B:190:0x042f, B:192:0x043d, B:193:0x0440, B:195:0x0448, B:197:0x0456, B:198:0x0459, B:200:0x0461, B:202:0x046d, B:203:0x0471, B:206:0x047a, B:207:0x0484, B:209:0x048c, B:211:0x049a, B:213:0x04aa, B:216:0x04b2, B:217:0x04b5, B:219:0x04be, B:220:0x04d0, B:222:0x04d8, B:223:0x04e0, B:225:0x04e8, B:226:0x04f0, B:228:0x04f8, B:229:0x0501, B:231:0x0509, B:233:0x0519, B:237:0x0531, B:242:0x053a, B:244:0x0542, B:246:0x0550, B:248:0x0556, B:249:0x0562, B:250:0x0566, B:253:0x056d, B:255:0x0574, B:257:0x057c, B:258:0x0584, B:260:0x058c, B:270:0x05ba, B:271:0x05bd, B:280:0x05f1, B:245:0x054c, B:241:0x0537, B:96:0x02f3, B:98:0x02fe, B:102:0x0307, B:108:0x0314, B:116:0x0321, B:124:0x032e, B:132:0x033a, B:140:0x0346, B:148:0x0356, B:156:0x0368, B:169:0x038a, B:172:0x03d1, B:288:0x0605, B:289:0x060a), top: B:311:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0556 A[Catch: Exception -> 0x0566, Error -> 0x064a, TryCatch #4 {Error -> 0x064a, blocks: (B:7:0x009e, B:8:0x00a0, B:11:0x00da, B:13:0x0132, B:14:0x013b, B:16:0x0141, B:17:0x014d, B:18:0x0151, B:21:0x0158, B:22:0x015d, B:25:0x0167, B:27:0x0198, B:29:0x01a2, B:31:0x01ac, B:32:0x01af, B:33:0x01b1, B:35:0x01b7, B:36:0x01c7, B:38:0x01cd, B:39:0x01f2, B:41:0x01f9, B:43:0x0201, B:45:0x020d, B:46:0x020f, B:48:0x0217, B:50:0x0223, B:52:0x0228, B:55:0x0232, B:59:0x023c, B:61:0x0244, B:63:0x024d, B:65:0x0255, B:67:0x025e, B:69:0x0266, B:71:0x026f, B:73:0x0277, B:75:0x0280, B:77:0x0288, B:79:0x0291, B:81:0x0299, B:83:0x02a2, B:85:0x02ab, B:87:0x02b9, B:89:0x02c2, B:91:0x02ce, B:93:0x02d6, B:171:0x039e, B:173:0x03da, B:175:0x03e2, B:177:0x03ee, B:178:0x03f1, B:180:0x03f9, B:182:0x0403, B:183:0x040e, B:185:0x0416, B:187:0x0424, B:188:0x0427, B:190:0x042f, B:192:0x043d, B:193:0x0440, B:195:0x0448, B:197:0x0456, B:198:0x0459, B:200:0x0461, B:202:0x046d, B:203:0x0471, B:206:0x047a, B:207:0x0484, B:209:0x048c, B:211:0x049a, B:213:0x04aa, B:216:0x04b2, B:217:0x04b5, B:219:0x04be, B:220:0x04d0, B:222:0x04d8, B:223:0x04e0, B:225:0x04e8, B:226:0x04f0, B:228:0x04f8, B:229:0x0501, B:231:0x0509, B:233:0x0519, B:237:0x0531, B:242:0x053a, B:244:0x0542, B:246:0x0550, B:248:0x0556, B:249:0x0562, B:250:0x0566, B:253:0x056d, B:255:0x0574, B:257:0x057c, B:258:0x0584, B:260:0x058c, B:270:0x05ba, B:271:0x05bd, B:280:0x05f1, B:245:0x054c, B:241:0x0537, B:96:0x02f3, B:98:0x02fe, B:102:0x0307, B:108:0x0314, B:116:0x0321, B:124:0x032e, B:132:0x033a, B:140:0x0346, B:148:0x0356, B:156:0x0368, B:169:0x038a, B:172:0x03d1, B:288:0x0605, B:289:0x060a), top: B:311:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0562 A[Catch: Exception -> 0x0566, Error -> 0x064a, TRY_LEAVE, TryCatch #4 {Error -> 0x064a, blocks: (B:7:0x009e, B:8:0x00a0, B:11:0x00da, B:13:0x0132, B:14:0x013b, B:16:0x0141, B:17:0x014d, B:18:0x0151, B:21:0x0158, B:22:0x015d, B:25:0x0167, B:27:0x0198, B:29:0x01a2, B:31:0x01ac, B:32:0x01af, B:33:0x01b1, B:35:0x01b7, B:36:0x01c7, B:38:0x01cd, B:39:0x01f2, B:41:0x01f9, B:43:0x0201, B:45:0x020d, B:46:0x020f, B:48:0x0217, B:50:0x0223, B:52:0x0228, B:55:0x0232, B:59:0x023c, B:61:0x0244, B:63:0x024d, B:65:0x0255, B:67:0x025e, B:69:0x0266, B:71:0x026f, B:73:0x0277, B:75:0x0280, B:77:0x0288, B:79:0x0291, B:81:0x0299, B:83:0x02a2, B:85:0x02ab, B:87:0x02b9, B:89:0x02c2, B:91:0x02ce, B:93:0x02d6, B:171:0x039e, B:173:0x03da, B:175:0x03e2, B:177:0x03ee, B:178:0x03f1, B:180:0x03f9, B:182:0x0403, B:183:0x040e, B:185:0x0416, B:187:0x0424, B:188:0x0427, B:190:0x042f, B:192:0x043d, B:193:0x0440, B:195:0x0448, B:197:0x0456, B:198:0x0459, B:200:0x0461, B:202:0x046d, B:203:0x0471, B:206:0x047a, B:207:0x0484, B:209:0x048c, B:211:0x049a, B:213:0x04aa, B:216:0x04b2, B:217:0x04b5, B:219:0x04be, B:220:0x04d0, B:222:0x04d8, B:223:0x04e0, B:225:0x04e8, B:226:0x04f0, B:228:0x04f8, B:229:0x0501, B:231:0x0509, B:233:0x0519, B:237:0x0531, B:242:0x053a, B:244:0x0542, B:246:0x0550, B:248:0x0556, B:249:0x0562, B:250:0x0566, B:253:0x056d, B:255:0x0574, B:257:0x057c, B:258:0x0584, B:260:0x058c, B:270:0x05ba, B:271:0x05bd, B:280:0x05f1, B:245:0x054c, B:241:0x0537, B:96:0x02f3, B:98:0x02fe, B:102:0x0307, B:108:0x0314, B:116:0x0321, B:124:0x032e, B:132:0x033a, B:140:0x0346, B:148:0x0356, B:156:0x0368, B:169:0x038a, B:172:0x03d1, B:288:0x0605, B:289:0x060a), top: B:311:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x056a  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0571  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x057c A[Catch: Exception -> 0x0646, Error -> 0x064a, TryCatch #4 {Error -> 0x064a, blocks: (B:7:0x009e, B:8:0x00a0, B:11:0x00da, B:13:0x0132, B:14:0x013b, B:16:0x0141, B:17:0x014d, B:18:0x0151, B:21:0x0158, B:22:0x015d, B:25:0x0167, B:27:0x0198, B:29:0x01a2, B:31:0x01ac, B:32:0x01af, B:33:0x01b1, B:35:0x01b7, B:36:0x01c7, B:38:0x01cd, B:39:0x01f2, B:41:0x01f9, B:43:0x0201, B:45:0x020d, B:46:0x020f, B:48:0x0217, B:50:0x0223, B:52:0x0228, B:55:0x0232, B:59:0x023c, B:61:0x0244, B:63:0x024d, B:65:0x0255, B:67:0x025e, B:69:0x0266, B:71:0x026f, B:73:0x0277, B:75:0x0280, B:77:0x0288, B:79:0x0291, B:81:0x0299, B:83:0x02a2, B:85:0x02ab, B:87:0x02b9, B:89:0x02c2, B:91:0x02ce, B:93:0x02d6, B:171:0x039e, B:173:0x03da, B:175:0x03e2, B:177:0x03ee, B:178:0x03f1, B:180:0x03f9, B:182:0x0403, B:183:0x040e, B:185:0x0416, B:187:0x0424, B:188:0x0427, B:190:0x042f, B:192:0x043d, B:193:0x0440, B:195:0x0448, B:197:0x0456, B:198:0x0459, B:200:0x0461, B:202:0x046d, B:203:0x0471, B:206:0x047a, B:207:0x0484, B:209:0x048c, B:211:0x049a, B:213:0x04aa, B:216:0x04b2, B:217:0x04b5, B:219:0x04be, B:220:0x04d0, B:222:0x04d8, B:223:0x04e0, B:225:0x04e8, B:226:0x04f0, B:228:0x04f8, B:229:0x0501, B:231:0x0509, B:233:0x0519, B:237:0x0531, B:242:0x053a, B:244:0x0542, B:246:0x0550, B:248:0x0556, B:249:0x0562, B:250:0x0566, B:253:0x056d, B:255:0x0574, B:257:0x057c, B:258:0x0584, B:260:0x058c, B:270:0x05ba, B:271:0x05bd, B:280:0x05f1, B:245:0x054c, B:241:0x0537, B:96:0x02f3, B:98:0x02fe, B:102:0x0307, B:108:0x0314, B:116:0x0321, B:124:0x032e, B:132:0x033a, B:140:0x0346, B:148:0x0356, B:156:0x0368, B:169:0x038a, B:172:0x03d1, B:288:0x0605, B:289:0x060a), top: B:311:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x058c A[Catch: Exception -> 0x0646, Error -> 0x064a, TRY_LEAVE, TryCatch #4 {Error -> 0x064a, blocks: (B:7:0x009e, B:8:0x00a0, B:11:0x00da, B:13:0x0132, B:14:0x013b, B:16:0x0141, B:17:0x014d, B:18:0x0151, B:21:0x0158, B:22:0x015d, B:25:0x0167, B:27:0x0198, B:29:0x01a2, B:31:0x01ac, B:32:0x01af, B:33:0x01b1, B:35:0x01b7, B:36:0x01c7, B:38:0x01cd, B:39:0x01f2, B:41:0x01f9, B:43:0x0201, B:45:0x020d, B:46:0x020f, B:48:0x0217, B:50:0x0223, B:52:0x0228, B:55:0x0232, B:59:0x023c, B:61:0x0244, B:63:0x024d, B:65:0x0255, B:67:0x025e, B:69:0x0266, B:71:0x026f, B:73:0x0277, B:75:0x0280, B:77:0x0288, B:79:0x0291, B:81:0x0299, B:83:0x02a2, B:85:0x02ab, B:87:0x02b9, B:89:0x02c2, B:91:0x02ce, B:93:0x02d6, B:171:0x039e, B:173:0x03da, B:175:0x03e2, B:177:0x03ee, B:178:0x03f1, B:180:0x03f9, B:182:0x0403, B:183:0x040e, B:185:0x0416, B:187:0x0424, B:188:0x0427, B:190:0x042f, B:192:0x043d, B:193:0x0440, B:195:0x0448, B:197:0x0456, B:198:0x0459, B:200:0x0461, B:202:0x046d, B:203:0x0471, B:206:0x047a, B:207:0x0484, B:209:0x048c, B:211:0x049a, B:213:0x04aa, B:216:0x04b2, B:217:0x04b5, B:219:0x04be, B:220:0x04d0, B:222:0x04d8, B:223:0x04e0, B:225:0x04e8, B:226:0x04f0, B:228:0x04f8, B:229:0x0501, B:231:0x0509, B:233:0x0519, B:237:0x0531, B:242:0x053a, B:244:0x0542, B:246:0x0550, B:248:0x0556, B:249:0x0562, B:250:0x0566, B:253:0x056d, B:255:0x0574, B:257:0x057c, B:258:0x0584, B:260:0x058c, B:270:0x05ba, B:271:0x05bd, B:280:0x05f1, B:245:0x054c, B:241:0x0537, B:96:0x02f3, B:98:0x02fe, B:102:0x0307, B:108:0x0314, B:116:0x0321, B:124:0x032e, B:132:0x033a, B:140:0x0346, B:148:0x0356, B:156:0x0368, B:169:0x038a, B:172:0x03d1, B:288:0x0605, B:289:0x060a), top: B:311:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x059a A[Catch: all -> 0x05b8, TryCatch #16 {all -> 0x05b8, blocks: (B:262:0x0594, B:264:0x059a, B:266:0x05b5), top: B:332:0x0594 }] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x048c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:320:0x05c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:343:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v46 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BDLocation(String str) {
        boolean z;
        Exception exc;
        ?? r2;
        String str2;
        String str3;
        JSONObject jSONObject;
        boolean z2;
        Exception exc2;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        int i2;
        int i3;
        String str21;
        String str22;
        String str23;
        String string;
        this.f6394a = 0;
        this.f6395b = null;
        this.f6396c = Double.MIN_VALUE;
        this.f6397d = Double.MIN_VALUE;
        this.f6398e = false;
        this.f6399f = Double.MIN_VALUE;
        this.f6400g = false;
        this.f6401h = 0.0f;
        this.f6402i = false;
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
        if (str != null) {
            String str24 = "";
            if (str.equals(str24)) {
                return;
            }
            try {
                try {
                } catch (Error e2) {
                    e2.printStackTrace();
                    r2 = 0;
                    this.f6394a = r2;
                    this.o = r2;
                }
            } catch (Exception e3) {
                z = false;
                exc = e3;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                JSONObject jSONObject3 = jSONObject2.getJSONObject("result");
                int parseInt = Integer.parseInt(jSONObject3.getString("error"));
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
                    if (jSONObject4.has("h")) {
                        try {
                            setAltitude(jSONObject4.getDouble("h"));
                        } catch (Exception unused) {
                        }
                    }
                    try {
                        if (jSONObject4.has("in_cn")) {
                            setLocationWhere(Integer.parseInt(jSONObject4.getString("in_cn")));
                        } else {
                            setLocationWhere(1);
                        }
                    } catch (Exception unused2) {
                    }
                    if (this.A != 0) {
                        setCoorType("gcj02");
                        return;
                    }
                    str2 = CoordinateType.WGS84;
                } else if (parseInt == 161) {
                    JSONObject jSONObject6 = jSONObject2.getJSONObject("content");
                    JSONObject jSONObject7 = jSONObject6.getJSONObject(Config.EVENT_HEAT_POINT);
                    setLatitude(Double.parseDouble(jSONObject7.getString("y")));
                    setLongitude(Double.parseDouble(jSONObject7.getString("x")));
                    setRadius(Float.parseFloat(jSONObject6.getString("radius")));
                    if (jSONObject6.has("sema")) {
                        JSONObject jSONObject8 = jSONObject6.getJSONObject("sema");
                        if (jSONObject8.has("aptag")) {
                            String string2 = jSONObject8.getString("aptag");
                            if (TextUtils.isEmpty(string2)) {
                                this.q = str24;
                            } else {
                                this.q = string2;
                            }
                        }
                        if (jSONObject8.has("aptagd")) {
                            JSONArray jSONArray = jSONObject8.getJSONObject("aptagd").getJSONArray("pois");
                            ArrayList arrayList = new ArrayList();
                            int i4 = 0;
                            while (i4 < jSONArray.length()) {
                                JSONObject jSONObject9 = jSONArray.getJSONObject(i4);
                                arrayList.add(new Poi(jSONObject9.getString("pid"), jSONObject9.getString("pname"), jSONObject9.getDouble(Config.PRINCIPAL_PART)));
                                i4++;
                                str24 = str24;
                            }
                            str3 = str24;
                            this.L = arrayList;
                        } else {
                            str3 = str24;
                        }
                        if (jSONObject8.has("poiregion")) {
                            String string3 = jSONObject8.getString("poiregion");
                            if (!TextUtils.isEmpty(string3)) {
                                this.r = string3;
                            }
                        }
                        if (jSONObject8.has("regular")) {
                            String string4 = jSONObject8.getString("regular");
                            if (!TextUtils.isEmpty(string4)) {
                                this.s = string4;
                            }
                        }
                    } else {
                        str3 = str24;
                    }
                    if (jSONObject6.has(DuPaBInfoMsg.B_ADDR)) {
                        try {
                            jSONObject = jSONObject6.getJSONObject(DuPaBInfoMsg.B_ADDR);
                            z2 = true;
                        } catch (Exception unused3) {
                            jSONObject = null;
                            z2 = false;
                        }
                        if (jSONObject != null) {
                            String string5 = jSONObject.has("city") ? jSONObject.getString("city") : str3;
                            str20 = jSONObject.has("city_code") ? jSONObject.getString("city_code") : str3;
                            str18 = jSONObject.has("country") ? jSONObject.getString("country") : str3;
                            str15 = jSONObject.has("country_code") ? jSONObject.getString("country_code") : str3;
                            str17 = jSONObject.has("province") ? jSONObject.getString("province") : str3;
                            String string6 = jSONObject.has("district") ? jSONObject.getString("district") : str3;
                            if (jSONObject.has("street")) {
                                str19 = jSONObject.getString("street");
                                str23 = string5;
                            } else {
                                str23 = string5;
                                str19 = str3;
                            }
                            String string7 = jSONObject.has("street_number") ? jSONObject.getString("street_number") : str3;
                            if (jSONObject.has("adcode")) {
                                String string8 = jSONObject.getString("adcode");
                                str14 = string6;
                                str9 = string7;
                                str16 = string8;
                                str13 = str23;
                                str12 = "y";
                            } else {
                                str14 = string6;
                                str13 = str23;
                                str9 = string7;
                                str12 = "y";
                                str16 = str3;
                            }
                        } else {
                            try {
                                String[] split = jSONObject6.getString(DuPaBInfoMsg.B_ADDR).split(",");
                                int length = split.length;
                                if (length > 0) {
                                    str5 = split[0];
                                    i2 = 1;
                                } else {
                                    i2 = 1;
                                    str5 = null;
                                }
                                if (length > i2) {
                                    try {
                                        str6 = split[i2];
                                        i3 = 2;
                                    } catch (Exception e4) {
                                        exc2 = e4;
                                        str4 = null;
                                        str6 = null;
                                        str7 = null;
                                        str8 = null;
                                        str9 = null;
                                        str10 = null;
                                        str11 = null;
                                        exc2.printStackTrace();
                                        str12 = "y";
                                        str13 = str6;
                                        str14 = str7;
                                        str15 = str11;
                                        str16 = null;
                                        str17 = str5;
                                        str18 = str8;
                                        z2 = false;
                                        String str25 = str10;
                                        str19 = str4;
                                        str20 = str25;
                                        if (z2) {
                                        }
                                        if (jSONObject6.has("floor")) {
                                        }
                                        if (jSONObject6.has("indoor")) {
                                        }
                                        if (jSONObject6.has("loctp")) {
                                        }
                                        if (jSONObject6.has("bldgid")) {
                                        }
                                        if (jSONObject6.has("bldg")) {
                                        }
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.A == 0 ? CoordinateType.WGS84 : "gcj02");
                                        if (jSONObject6.has(BeanConstants.CHANNEL_ID_NAVI)) {
                                        }
                                        if (jSONObject6.has("navi_client")) {
                                        }
                                        if (jSONObject6.has("nrl_point")) {
                                        }
                                    }
                                } else {
                                    i3 = 2;
                                    str6 = null;
                                }
                                if (length > i3) {
                                    try {
                                        str7 = split[i3];
                                    } catch (Exception e5) {
                                        exc2 = e5;
                                        str4 = null;
                                        str7 = null;
                                        str8 = null;
                                        str9 = null;
                                        str10 = null;
                                        str11 = null;
                                        exc2.printStackTrace();
                                        str12 = "y";
                                        str13 = str6;
                                        str14 = str7;
                                        str15 = str11;
                                        str16 = null;
                                        str17 = str5;
                                        str18 = str8;
                                        z2 = false;
                                        String str252 = str10;
                                        str19 = str4;
                                        str20 = str252;
                                        if (z2) {
                                        }
                                        if (jSONObject6.has("floor")) {
                                        }
                                        if (jSONObject6.has("indoor")) {
                                        }
                                        if (jSONObject6.has("loctp")) {
                                        }
                                        if (jSONObject6.has("bldgid")) {
                                        }
                                        if (jSONObject6.has("bldg")) {
                                        }
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.A == 0 ? CoordinateType.WGS84 : "gcj02");
                                        if (jSONObject6.has(BeanConstants.CHANNEL_ID_NAVI)) {
                                        }
                                        if (jSONObject6.has("navi_client")) {
                                        }
                                        if (jSONObject6.has("nrl_point")) {
                                        }
                                    }
                                } else {
                                    str7 = null;
                                }
                                if (length > 3) {
                                    try {
                                        str4 = split[3];
                                    } catch (Exception e6) {
                                        exc2 = e6;
                                        str4 = null;
                                        str8 = null;
                                        str9 = null;
                                        str10 = null;
                                        str11 = null;
                                        exc2.printStackTrace();
                                        str12 = "y";
                                        str13 = str6;
                                        str14 = str7;
                                        str15 = str11;
                                        str16 = null;
                                        str17 = str5;
                                        str18 = str8;
                                        z2 = false;
                                        String str2522 = str10;
                                        str19 = str4;
                                        str20 = str2522;
                                        if (z2) {
                                        }
                                        if (jSONObject6.has("floor")) {
                                        }
                                        if (jSONObject6.has("indoor")) {
                                        }
                                        if (jSONObject6.has("loctp")) {
                                        }
                                        if (jSONObject6.has("bldgid")) {
                                        }
                                        if (jSONObject6.has("bldg")) {
                                        }
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.A == 0 ? CoordinateType.WGS84 : "gcj02");
                                        if (jSONObject6.has(BeanConstants.CHANNEL_ID_NAVI)) {
                                        }
                                        if (jSONObject6.has("navi_client")) {
                                        }
                                        if (jSONObject6.has("nrl_point")) {
                                        }
                                    }
                                } else {
                                    str4 = null;
                                }
                                if (length > 4) {
                                    try {
                                        str9 = split[4];
                                    } catch (Exception e7) {
                                        exc2 = e7;
                                        str8 = null;
                                        str9 = null;
                                        str10 = null;
                                        str11 = null;
                                        exc2.printStackTrace();
                                        str12 = "y";
                                        str13 = str6;
                                        str14 = str7;
                                        str15 = str11;
                                        str16 = null;
                                        str17 = str5;
                                        str18 = str8;
                                        z2 = false;
                                        String str25222 = str10;
                                        str19 = str4;
                                        str20 = str25222;
                                        if (z2) {
                                        }
                                        if (jSONObject6.has("floor")) {
                                        }
                                        if (jSONObject6.has("indoor")) {
                                        }
                                        if (jSONObject6.has("loctp")) {
                                        }
                                        if (jSONObject6.has("bldgid")) {
                                        }
                                        if (jSONObject6.has("bldg")) {
                                        }
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.A == 0 ? CoordinateType.WGS84 : "gcj02");
                                        if (jSONObject6.has(BeanConstants.CHANNEL_ID_NAVI)) {
                                        }
                                        if (jSONObject6.has("navi_client")) {
                                        }
                                        if (jSONObject6.has("nrl_point")) {
                                        }
                                    }
                                } else {
                                    str9 = null;
                                }
                                if (length > 5) {
                                    try {
                                        str10 = split[5];
                                    } catch (Exception e8) {
                                        exc2 = e8;
                                        str8 = null;
                                        str10 = null;
                                        str11 = null;
                                        exc2.printStackTrace();
                                        str12 = "y";
                                        str13 = str6;
                                        str14 = str7;
                                        str15 = str11;
                                        str16 = null;
                                        str17 = str5;
                                        str18 = str8;
                                        z2 = false;
                                        String str252222 = str10;
                                        str19 = str4;
                                        str20 = str252222;
                                        if (z2) {
                                        }
                                        if (jSONObject6.has("floor")) {
                                        }
                                        if (jSONObject6.has("indoor")) {
                                        }
                                        if (jSONObject6.has("loctp")) {
                                        }
                                        if (jSONObject6.has("bldgid")) {
                                        }
                                        if (jSONObject6.has("bldg")) {
                                        }
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.A == 0 ? CoordinateType.WGS84 : "gcj02");
                                        if (jSONObject6.has(BeanConstants.CHANNEL_ID_NAVI)) {
                                        }
                                        if (jSONObject6.has("navi_client")) {
                                        }
                                        if (jSONObject6.has("nrl_point")) {
                                        }
                                    }
                                } else {
                                    str10 = null;
                                }
                                if (length > 6) {
                                    try {
                                        str8 = split[6];
                                        str21 = str4;
                                    } catch (Exception e9) {
                                        exc2 = e9;
                                        str8 = null;
                                        str11 = null;
                                        exc2.printStackTrace();
                                        str12 = "y";
                                        str13 = str6;
                                        str14 = str7;
                                        str15 = str11;
                                        str16 = null;
                                        str17 = str5;
                                        str18 = str8;
                                        z2 = false;
                                        String str2522222 = str10;
                                        str19 = str4;
                                        str20 = str2522222;
                                        if (z2) {
                                        }
                                        if (jSONObject6.has("floor")) {
                                        }
                                        if (jSONObject6.has("indoor")) {
                                        }
                                        if (jSONObject6.has("loctp")) {
                                        }
                                        if (jSONObject6.has("bldgid")) {
                                        }
                                        if (jSONObject6.has("bldg")) {
                                        }
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.A == 0 ? CoordinateType.WGS84 : "gcj02");
                                        if (jSONObject6.has(BeanConstants.CHANNEL_ID_NAVI)) {
                                        }
                                        if (jSONObject6.has("navi_client")) {
                                        }
                                        if (jSONObject6.has("nrl_point")) {
                                        }
                                    }
                                } else {
                                    str21 = str4;
                                    str8 = null;
                                }
                                if (length > 7) {
                                    try {
                                        str11 = split[7];
                                    } catch (Exception e10) {
                                        exc2 = e10;
                                        str4 = str21;
                                        str11 = null;
                                        exc2.printStackTrace();
                                        str12 = "y";
                                        str13 = str6;
                                        str14 = str7;
                                        str15 = str11;
                                        str16 = null;
                                        str17 = str5;
                                        str18 = str8;
                                        z2 = false;
                                        String str25222222 = str10;
                                        str19 = str4;
                                        str20 = str25222222;
                                        if (z2) {
                                        }
                                        if (jSONObject6.has("floor")) {
                                        }
                                        if (jSONObject6.has("indoor")) {
                                        }
                                        if (jSONObject6.has("loctp")) {
                                        }
                                        if (jSONObject6.has("bldgid")) {
                                        }
                                        if (jSONObject6.has("bldg")) {
                                        }
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.A == 0 ? CoordinateType.WGS84 : "gcj02");
                                        if (jSONObject6.has(BeanConstants.CHANNEL_ID_NAVI)) {
                                        }
                                        if (jSONObject6.has("navi_client")) {
                                        }
                                        if (jSONObject6.has("nrl_point")) {
                                        }
                                    }
                                } else {
                                    str11 = null;
                                }
                                if (length > 8) {
                                    try {
                                        str22 = split[8];
                                    } catch (Exception e11) {
                                        exc2 = e11;
                                        str4 = str21;
                                        exc2.printStackTrace();
                                        str12 = "y";
                                        str13 = str6;
                                        str14 = str7;
                                        str15 = str11;
                                        str16 = null;
                                        str17 = str5;
                                        str18 = str8;
                                        z2 = false;
                                        String str252222222 = str10;
                                        str19 = str4;
                                        str20 = str252222222;
                                        if (z2) {
                                        }
                                        if (jSONObject6.has("floor")) {
                                        }
                                        if (jSONObject6.has("indoor")) {
                                        }
                                        if (jSONObject6.has("loctp")) {
                                        }
                                        if (jSONObject6.has("bldgid")) {
                                        }
                                        if (jSONObject6.has("bldg")) {
                                        }
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.A == 0 ? CoordinateType.WGS84 : "gcj02");
                                        if (jSONObject6.has(BeanConstants.CHANNEL_ID_NAVI)) {
                                        }
                                        if (jSONObject6.has("navi_client")) {
                                            try {
                                                if (string.contains(",")) {
                                                }
                                            } catch (Throwable th) {
                                                th.printStackTrace();
                                            }
                                        }
                                        if (jSONObject6.has("nrl_point")) {
                                        }
                                    }
                                } else {
                                    str22 = null;
                                }
                                str14 = str7;
                                str20 = str10;
                                str19 = str21;
                                str12 = "y";
                                str17 = str5;
                                str18 = str8;
                                z2 = true;
                                str16 = str22;
                                str13 = str6;
                                str15 = str11;
                            } catch (Exception e12) {
                                exc2 = e12;
                                str4 = null;
                                str5 = null;
                            }
                        }
                        if (z2) {
                            this.u = new Address.Builder().country(str18).countryCode(str15).province(str17).city(str13).cityCode(str20).district(str14).street(str19).streetNumber(str9).adcode(str16).build();
                            this.o = true;
                        }
                    } else {
                        str12 = "y";
                        this.o = false;
                        setAddrStr(null);
                    }
                    if (jSONObject6.has("floor")) {
                        String string9 = jSONObject6.getString("floor");
                        this.v = string9;
                        if (TextUtils.isEmpty(string9)) {
                            this.v = null;
                        }
                    }
                    if (jSONObject6.has("indoor")) {
                        String string10 = jSONObject6.getString("indoor");
                        if (!TextUtils.isEmpty(string10)) {
                            setUserIndoorState(Integer.valueOf(string10).intValue());
                        }
                    }
                    if (jSONObject6.has("loctp")) {
                        String string11 = jSONObject6.getString("loctp");
                        this.B = string11;
                        if (TextUtils.isEmpty(string11)) {
                            this.B = null;
                        }
                    }
                    if (jSONObject6.has("bldgid")) {
                        String string12 = jSONObject6.getString("bldgid");
                        this.w = string12;
                        if (TextUtils.isEmpty(string12)) {
                            this.w = null;
                        }
                    }
                    if (jSONObject6.has("bldg")) {
                        String string13 = jSONObject6.getString("bldg");
                        this.x = string13;
                        if (TextUtils.isEmpty(string13)) {
                            this.x = null;
                        }
                    }
                    if (jSONObject6.has("ibav")) {
                        String string14 = jSONObject6.getString("ibav");
                        if (!TextUtils.isEmpty(string14) && !string14.equals("0")) {
                            this.z = Integer.valueOf(string14).intValue();
                        }
                        this.z = 0;
                    }
                    if (jSONObject6.has("indoorflags")) {
                        try {
                            JSONObject jSONObject10 = jSONObject6.getJSONObject("indoorflags");
                            if (jSONObject10.has(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA)) {
                                int intValue = Integer.valueOf(jSONObject10.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA)).intValue();
                                if (intValue == 0) {
                                    setIndoorLocationSurpport(2);
                                } else if (intValue == 1) {
                                    setIndoorLocationSurpport(1);
                                }
                            }
                            if (jSONObject10.has("support")) {
                                setIndoorLocationSource(Integer.valueOf(jSONObject10.getString("support")).intValue());
                            }
                            if (jSONObject10.has("inbldg")) {
                                this.I = jSONObject10.getString("inbldg");
                            }
                            if (jSONObject10.has("inbldgid")) {
                                this.J = jSONObject10.getString("inbldgid");
                            }
                            if (jSONObject10.has("polygon")) {
                                setIndoorSurpportPolygon(jSONObject10.getString("polygon"));
                            }
                            if (jSONObject10.has("ret_fields")) {
                                try {
                                    for (String str26 : jSONObject10.getString("ret_fields").split("\\|")) {
                                        String[] split2 = str26.split("=");
                                        this.P.putString(split2[0], split2[1]);
                                    }
                                } catch (Exception e13) {
                                    e13.printStackTrace();
                                }
                            }
                        } catch (Exception e14) {
                            e14.printStackTrace();
                        }
                    }
                    if (jSONObject6.has("gpscs")) {
                        setGpsCheckStatus(jSONObject6.getInt("gpscs"));
                    } else {
                        setGpsCheckStatus(0);
                    }
                    try {
                        if (jSONObject6.has("in_cn")) {
                            setLocationWhere(Integer.parseInt(jSONObject6.getString("in_cn")));
                        } else {
                            setLocationWhere(1);
                        }
                    } catch (Exception unused4) {
                    }
                    setCoorType(this.A == 0 ? CoordinateType.WGS84 : "gcj02");
                    if (jSONObject6.has(BeanConstants.CHANNEL_ID_NAVI)) {
                        this.T = jSONObject6.getString(BeanConstants.CHANNEL_ID_NAVI);
                    }
                    if (jSONObject6.has("navi_client") && (string = jSONObject6.getString("navi_client")) != null) {
                        if (string.contains(",")) {
                            String[] split3 = string.split(",");
                            int intValue2 = Integer.valueOf(split3[0]).intValue();
                            Integer.valueOf(split3[1]).intValue();
                            if (intValue2 > 0) {
                                this.W = true;
                            }
                        }
                    }
                    if (jSONObject6.has("nrl_point")) {
                        try {
                            JSONObject jSONObject11 = jSONObject6.getJSONObject("nrl_point");
                            if (jSONObject11.has("x")) {
                                String str27 = str12;
                                if (jSONObject11.has(str27)) {
                                    this.U = Double.parseDouble(jSONObject11.getString(str27));
                                    this.V = Double.parseDouble(jSONObject11.getString("x"));
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Throwable unused5) {
                            this.U = Double.MIN_VALUE;
                            this.V = Double.MIN_VALUE;
                            return;
                        }
                    }
                    return;
                } else {
                    str2 = "gcj02";
                    if (parseInt != 66 && parseInt != 68) {
                        if (parseInt == 167) {
                            setLocationWhere(2);
                            return;
                        }
                        return;
                    }
                    JSONObject jSONObject12 = jSONObject2.getJSONObject("content");
                    JSONObject jSONObject13 = jSONObject12.getJSONObject(Config.EVENT_HEAT_POINT);
                    setLatitude(Double.parseDouble(jSONObject13.getString("y")));
                    setLongitude(Double.parseDouble(jSONObject13.getString("x")));
                    setRadius(Float.parseFloat(jSONObject12.getString("radius")));
                    a(Boolean.valueOf(Boolean.parseBoolean(jSONObject12.getString("isCellChanged"))));
                }
                setCoorType(str2);
            } catch (Exception e15) {
                exc = e15;
                z = false;
                exc.printStackTrace();
                r2 = z;
                this.f6394a = r2;
                this.o = r2;
            }
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
        return this.f6399f;
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

    public String getDistrict() {
        return this.u.district;
    }

    public Location getExtraLocation(String str) {
        Bundle bundle = this.P;
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable(str);
            if (parcelable instanceof Location) {
                return (Location) parcelable;
            }
            return null;
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
        return this.f6396c;
    }

    public int getLocType() {
        return this.f6394a;
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
        return this.f6397d;
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

    public String getProvince() {
        return this.u.province;
    }

    public float getRadius() {
        return this.j;
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
        return this.f6401h;
    }

    public String getStreet() {
        return this.u.street;
    }

    public String getStreetNumber() {
        return this.u.streetNumber;
    }

    public String getTime() {
        return this.f6395b;
    }

    public int getUserIndoorState() {
        return this.E;
    }

    public String getVdrJsonString() {
        Bundle bundle = this.P;
        if (bundle == null || !bundle.containsKey("vdr")) {
            return null;
        }
        return this.P.getString("vdr");
    }

    public boolean hasAddr() {
        return this.o;
    }

    public boolean hasAltitude() {
        return this.f6398e;
    }

    public boolean hasRadius() {
        return this.f6402i;
    }

    public boolean hasSateNumber() {
        return this.k;
    }

    public boolean hasSpeed() {
        return this.f6400g;
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
        this.o = str != null;
    }

    public void setAltitude(double d2) {
        if (d2 < 9999.0d) {
            this.f6399f = d2;
            this.f6398e = true;
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

    public void setDirection(float f2) {
        this.m = f2;
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

    public void setGpsAccuracyStatus(int i2) {
        this.Q = i2;
    }

    public void setGpsCheckStatus(int i2) {
        this.R = i2;
    }

    public void setIndoorLocMode(boolean z) {
        this.y = z;
    }

    public void setIndoorLocationSource(int i2) {
        this.H = i2;
    }

    public void setIndoorLocationSurpport(int i2) {
        this.F = i2;
    }

    public void setIndoorNetworkState(int i2) {
        this.G = i2;
    }

    public void setIndoorSurpportPolygon(String str) {
        this.K = str;
    }

    public void setLatitude(double d2) {
        this.f6396c = d2;
    }

    public void setLocType(int i2) {
        String str;
        this.f6394a = i2;
        if (i2 != 66) {
            if (i2 != 67) {
                if (i2 == 161) {
                    str = "NetWork location successful!";
                } else if (i2 == 162) {
                    str = "NetWork location failed because baidu location service can not decrypt the request query, please check the so file !";
                } else if (i2 == 167) {
                    str = "NetWork location failed because baidu location service can not caculate the location!";
                } else if (i2 != 505) {
                    switch (i2) {
                        case 61:
                            setLocTypeDescription("GPS location successful!");
                            setUserIndoorState(0);
                            return;
                        case 62:
                            str = "Location failed beacuse we can not get any loc information!";
                            break;
                        case 63:
                            break;
                        default:
                            str = "UnKnown!";
                            break;
                    }
                } else {
                    str = "NetWork location failed because baidu location service check the key is unlegal, please check the key in AndroidManifest.xml !";
                }
            }
            str = "Offline location failed, please check the net (wifi/cell)!";
        } else {
            str = "Offline location successful!";
        }
        setLocTypeDescription(str);
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

    public void setLocationWhere(int i2) {
        this.A = i2;
    }

    public void setLongitude(double d2) {
        this.f6397d = d2;
    }

    public void setNetworkLocationType(String str) {
        this.B = str;
    }

    public void setNrlData(String str) {
        this.T = str;
    }

    public void setOperators(int i2) {
        this.C = i2;
    }

    public void setParkAvailable(int i2) {
        this.z = i2;
    }

    public void setPoiList(List<Poi> list) {
        this.L = list;
    }

    public void setRadius(float f2) {
        this.j = f2;
        this.f6402i = true;
    }

    public void setRetFields(String str, String str2) {
        if (this.P == null) {
            this.P = new Bundle();
        }
        this.P.putString(str, str2);
    }

    public void setRoadLocString(float f2, float f3) {
        String format = ((double) f2) > 0.001d ? String.format("%.2f", Float.valueOf(f2)) : "";
        String format2 = ((double) f3) > 0.001d ? String.format("%.2f", Float.valueOf(f3)) : "";
        String str = this.T;
        if (str != null) {
            this.O = String.format(Locale.US, "%s|%s,%s", str, format, format2);
        }
    }

    public void setSatelliteNumber(int i2) {
        this.l = i2;
    }

    public void setSpeed(float f2) {
        this.f6401h = f2;
        this.f6400g = true;
    }

    public void setTime(String str) {
        this.f6395b = str;
        setLocationID(k.a(str));
    }

    public void setUserIndoorState(int i2) {
        this.E = i2;
    }

    public void setVdrJsonValue(String str) {
        if (this.P == null) {
            this.P = new Bundle();
        }
        this.P.putString("vdr", str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f6394a);
        parcel.writeString(this.f6395b);
        parcel.writeDouble(this.f6396c);
        parcel.writeDouble(this.f6397d);
        parcel.writeDouble(this.f6399f);
        parcel.writeFloat(this.f6401h);
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
        parcel.writeInt(this.Q);
        parcel.writeString(this.N);
        parcel.writeInt(this.R);
        parcel.writeString(this.O);
        parcel.writeString(this.T);
        parcel.writeLong(this.S);
        parcel.writeDouble(this.U);
        parcel.writeDouble(this.V);
        parcel.writeBooleanArray(new boolean[]{this.f6398e, this.f6400g, this.f6402i, this.k, this.o, this.t, this.y, this.W});
        parcel.writeList(this.L);
        parcel.writeBundle(this.P);
    }
}
