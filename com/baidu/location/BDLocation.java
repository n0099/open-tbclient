package com.baidu.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.messages.DuPaBInfoMsg;
import com.baidu.location.Address;
import com.baidu.location.d.j;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
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
    public Bundle O;
    public int P;
    public int Q;

    /* renamed from: a  reason: collision with root package name */
    public int f6456a;

    /* renamed from: b  reason: collision with root package name */
    public String f6457b;

    /* renamed from: c  reason: collision with root package name */
    public double f6458c;

    /* renamed from: d  reason: collision with root package name */
    public double f6459d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6460e;

    /* renamed from: f  reason: collision with root package name */
    public double f6461f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6462g;

    /* renamed from: h  reason: collision with root package name */
    public float f6463h;
    public boolean i;
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
        this.f6456a = 0;
        this.f6457b = null;
        this.f6458c = Double.MIN_VALUE;
        this.f6459d = Double.MIN_VALUE;
        this.f6460e = false;
        this.f6461f = Double.MIN_VALUE;
        this.f6462g = false;
        this.f6463h = 0.0f;
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

    public BDLocation(Parcel parcel) {
        this.f6456a = 0;
        this.f6457b = null;
        this.f6458c = Double.MIN_VALUE;
        this.f6459d = Double.MIN_VALUE;
        this.f6460e = false;
        this.f6461f = Double.MIN_VALUE;
        this.f6462g = false;
        this.f6463h = 0.0f;
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
        this.f6456a = parcel.readInt();
        this.f6457b = parcel.readString();
        this.f6458c = parcel.readDouble();
        this.f6459d = parcel.readDouble();
        this.f6461f = parcel.readDouble();
        this.f6463h = parcel.readFloat();
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
            this.f6460e = zArr[0];
            this.f6462g = zArr[1];
            this.i = zArr[2];
            this.k = zArr[3];
            this.o = zArr[4];
            this.t = zArr[5];
            this.y = zArr[6];
        } catch (Exception unused) {
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

    public /* synthetic */ BDLocation(Parcel parcel, a aVar) {
        this(parcel);
    }

    public BDLocation(BDLocation bDLocation) {
        this.f6456a = 0;
        ArrayList arrayList = null;
        this.f6457b = null;
        this.f6458c = Double.MIN_VALUE;
        this.f6459d = Double.MIN_VALUE;
        this.f6460e = false;
        this.f6461f = Double.MIN_VALUE;
        this.f6462g = false;
        this.f6463h = 0.0f;
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
        this.f6456a = bDLocation.f6456a;
        this.f6457b = bDLocation.f6457b;
        this.f6458c = bDLocation.f6458c;
        this.f6459d = bDLocation.f6459d;
        this.f6460e = bDLocation.f6460e;
        this.f6461f = bDLocation.f6461f;
        this.f6462g = bDLocation.f6462g;
        this.f6463h = bDLocation.f6463h;
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
        if (bDLocation.L != null) {
            arrayList = new ArrayList();
            for (int i = 0; i < bDLocation.L.size(); i++) {
                Poi poi = bDLocation.L.get(i);
                arrayList.add(new Poi(poi.getId(), poi.getName(), poi.getRank()));
            }
        }
        this.L = arrayList;
        this.M = bDLocation.M;
        this.O = bDLocation.O;
        this.Q = bDLocation.Q;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:295:? */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0343 A[Catch: Exception -> 0x0568, Error -> 0x056c, TRY_LEAVE, TryCatch #3 {Error -> 0x056c, blocks: (B:7:0x008d, B:8:0x008f, B:11:0x00cb, B:13:0x0123, B:14:0x012c, B:16:0x0132, B:17:0x013e, B:18:0x0142, B:21:0x0149, B:22:0x014e, B:25:0x0157, B:27:0x0188, B:29:0x0192, B:31:0x019c, B:32:0x019f, B:33:0x01a1, B:35:0x01a7, B:36:0x01b7, B:38:0x01bd, B:39:0x01de, B:40:0x01e0, B:42:0x01e8, B:44:0x01f2, B:45:0x01f4, B:47:0x01fc, B:49:0x0208, B:50:0x020a, B:52:0x0212, B:56:0x021c, B:58:0x0224, B:60:0x022c, B:62:0x0234, B:64:0x023c, B:66:0x0244, B:68:0x024c, B:70:0x0254, B:72:0x025c, B:74:0x0264, B:76:0x026c, B:78:0x0274, B:80:0x027c, B:82:0x0285, B:84:0x028e, B:86:0x0297, B:88:0x02a0, B:90:0x02a8, B:169:0x0343, B:175:0x037d, B:177:0x0385, B:179:0x0391, B:180:0x0394, B:182:0x039c, B:184:0x03a6, B:185:0x03b1, B:187:0x03b9, B:189:0x03c7, B:190:0x03ca, B:192:0x03d2, B:194:0x03e0, B:195:0x03e3, B:197:0x03eb, B:199:0x03f9, B:200:0x03fc, B:202:0x0404, B:204:0x0410, B:205:0x0414, B:208:0x041d, B:209:0x0427, B:211:0x042f, B:213:0x043d, B:215:0x044d, B:218:0x0455, B:219:0x0458, B:221:0x0461, B:222:0x0473, B:224:0x047b, B:225:0x0483, B:227:0x048b, B:228:0x0493, B:230:0x049b, B:231:0x04a4, B:233:0x04ac, B:235:0x04bc, B:239:0x04d4, B:244:0x04dd, B:246:0x04e5, B:250:0x04f3, B:252:0x04f9, B:253:0x0505, B:254:0x0509, B:258:0x0514, B:249:0x04f0, B:243:0x04da, B:92:0x02b0, B:94:0x02bd, B:98:0x02c6, B:104:0x02d3, B:112:0x02e0, B:120:0x02ec, B:128:0x02f7, B:136:0x0302, B:144:0x030d, B:152:0x031a, B:166:0x0331, B:172:0x0377, B:174:0x037a, B:268:0x0528, B:269:0x052d), top: B:290:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0385 A[Catch: Exception -> 0x0568, Error -> 0x056c, TryCatch #3 {Error -> 0x056c, blocks: (B:7:0x008d, B:8:0x008f, B:11:0x00cb, B:13:0x0123, B:14:0x012c, B:16:0x0132, B:17:0x013e, B:18:0x0142, B:21:0x0149, B:22:0x014e, B:25:0x0157, B:27:0x0188, B:29:0x0192, B:31:0x019c, B:32:0x019f, B:33:0x01a1, B:35:0x01a7, B:36:0x01b7, B:38:0x01bd, B:39:0x01de, B:40:0x01e0, B:42:0x01e8, B:44:0x01f2, B:45:0x01f4, B:47:0x01fc, B:49:0x0208, B:50:0x020a, B:52:0x0212, B:56:0x021c, B:58:0x0224, B:60:0x022c, B:62:0x0234, B:64:0x023c, B:66:0x0244, B:68:0x024c, B:70:0x0254, B:72:0x025c, B:74:0x0264, B:76:0x026c, B:78:0x0274, B:80:0x027c, B:82:0x0285, B:84:0x028e, B:86:0x0297, B:88:0x02a0, B:90:0x02a8, B:169:0x0343, B:175:0x037d, B:177:0x0385, B:179:0x0391, B:180:0x0394, B:182:0x039c, B:184:0x03a6, B:185:0x03b1, B:187:0x03b9, B:189:0x03c7, B:190:0x03ca, B:192:0x03d2, B:194:0x03e0, B:195:0x03e3, B:197:0x03eb, B:199:0x03f9, B:200:0x03fc, B:202:0x0404, B:204:0x0410, B:205:0x0414, B:208:0x041d, B:209:0x0427, B:211:0x042f, B:213:0x043d, B:215:0x044d, B:218:0x0455, B:219:0x0458, B:221:0x0461, B:222:0x0473, B:224:0x047b, B:225:0x0483, B:227:0x048b, B:228:0x0493, B:230:0x049b, B:231:0x04a4, B:233:0x04ac, B:235:0x04bc, B:239:0x04d4, B:244:0x04dd, B:246:0x04e5, B:250:0x04f3, B:252:0x04f9, B:253:0x0505, B:254:0x0509, B:258:0x0514, B:249:0x04f0, B:243:0x04da, B:92:0x02b0, B:94:0x02bd, B:98:0x02c6, B:104:0x02d3, B:112:0x02e0, B:120:0x02ec, B:128:0x02f7, B:136:0x0302, B:144:0x030d, B:152:0x031a, B:166:0x0331, B:172:0x0377, B:174:0x037a, B:268:0x0528, B:269:0x052d), top: B:290:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x039c A[Catch: Exception -> 0x0568, Error -> 0x056c, TryCatch #3 {Error -> 0x056c, blocks: (B:7:0x008d, B:8:0x008f, B:11:0x00cb, B:13:0x0123, B:14:0x012c, B:16:0x0132, B:17:0x013e, B:18:0x0142, B:21:0x0149, B:22:0x014e, B:25:0x0157, B:27:0x0188, B:29:0x0192, B:31:0x019c, B:32:0x019f, B:33:0x01a1, B:35:0x01a7, B:36:0x01b7, B:38:0x01bd, B:39:0x01de, B:40:0x01e0, B:42:0x01e8, B:44:0x01f2, B:45:0x01f4, B:47:0x01fc, B:49:0x0208, B:50:0x020a, B:52:0x0212, B:56:0x021c, B:58:0x0224, B:60:0x022c, B:62:0x0234, B:64:0x023c, B:66:0x0244, B:68:0x024c, B:70:0x0254, B:72:0x025c, B:74:0x0264, B:76:0x026c, B:78:0x0274, B:80:0x027c, B:82:0x0285, B:84:0x028e, B:86:0x0297, B:88:0x02a0, B:90:0x02a8, B:169:0x0343, B:175:0x037d, B:177:0x0385, B:179:0x0391, B:180:0x0394, B:182:0x039c, B:184:0x03a6, B:185:0x03b1, B:187:0x03b9, B:189:0x03c7, B:190:0x03ca, B:192:0x03d2, B:194:0x03e0, B:195:0x03e3, B:197:0x03eb, B:199:0x03f9, B:200:0x03fc, B:202:0x0404, B:204:0x0410, B:205:0x0414, B:208:0x041d, B:209:0x0427, B:211:0x042f, B:213:0x043d, B:215:0x044d, B:218:0x0455, B:219:0x0458, B:221:0x0461, B:222:0x0473, B:224:0x047b, B:225:0x0483, B:227:0x048b, B:228:0x0493, B:230:0x049b, B:231:0x04a4, B:233:0x04ac, B:235:0x04bc, B:239:0x04d4, B:244:0x04dd, B:246:0x04e5, B:250:0x04f3, B:252:0x04f9, B:253:0x0505, B:254:0x0509, B:258:0x0514, B:249:0x04f0, B:243:0x04da, B:92:0x02b0, B:94:0x02bd, B:98:0x02c6, B:104:0x02d3, B:112:0x02e0, B:120:0x02ec, B:128:0x02f7, B:136:0x0302, B:144:0x030d, B:152:0x031a, B:166:0x0331, B:172:0x0377, B:174:0x037a, B:268:0x0528, B:269:0x052d), top: B:290:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03b9 A[Catch: Exception -> 0x0568, Error -> 0x056c, TryCatch #3 {Error -> 0x056c, blocks: (B:7:0x008d, B:8:0x008f, B:11:0x00cb, B:13:0x0123, B:14:0x012c, B:16:0x0132, B:17:0x013e, B:18:0x0142, B:21:0x0149, B:22:0x014e, B:25:0x0157, B:27:0x0188, B:29:0x0192, B:31:0x019c, B:32:0x019f, B:33:0x01a1, B:35:0x01a7, B:36:0x01b7, B:38:0x01bd, B:39:0x01de, B:40:0x01e0, B:42:0x01e8, B:44:0x01f2, B:45:0x01f4, B:47:0x01fc, B:49:0x0208, B:50:0x020a, B:52:0x0212, B:56:0x021c, B:58:0x0224, B:60:0x022c, B:62:0x0234, B:64:0x023c, B:66:0x0244, B:68:0x024c, B:70:0x0254, B:72:0x025c, B:74:0x0264, B:76:0x026c, B:78:0x0274, B:80:0x027c, B:82:0x0285, B:84:0x028e, B:86:0x0297, B:88:0x02a0, B:90:0x02a8, B:169:0x0343, B:175:0x037d, B:177:0x0385, B:179:0x0391, B:180:0x0394, B:182:0x039c, B:184:0x03a6, B:185:0x03b1, B:187:0x03b9, B:189:0x03c7, B:190:0x03ca, B:192:0x03d2, B:194:0x03e0, B:195:0x03e3, B:197:0x03eb, B:199:0x03f9, B:200:0x03fc, B:202:0x0404, B:204:0x0410, B:205:0x0414, B:208:0x041d, B:209:0x0427, B:211:0x042f, B:213:0x043d, B:215:0x044d, B:218:0x0455, B:219:0x0458, B:221:0x0461, B:222:0x0473, B:224:0x047b, B:225:0x0483, B:227:0x048b, B:228:0x0493, B:230:0x049b, B:231:0x04a4, B:233:0x04ac, B:235:0x04bc, B:239:0x04d4, B:244:0x04dd, B:246:0x04e5, B:250:0x04f3, B:252:0x04f9, B:253:0x0505, B:254:0x0509, B:258:0x0514, B:249:0x04f0, B:243:0x04da, B:92:0x02b0, B:94:0x02bd, B:98:0x02c6, B:104:0x02d3, B:112:0x02e0, B:120:0x02ec, B:128:0x02f7, B:136:0x0302, B:144:0x030d, B:152:0x031a, B:166:0x0331, B:172:0x0377, B:174:0x037a, B:268:0x0528, B:269:0x052d), top: B:290:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x03d2 A[Catch: Exception -> 0x0568, Error -> 0x056c, TryCatch #3 {Error -> 0x056c, blocks: (B:7:0x008d, B:8:0x008f, B:11:0x00cb, B:13:0x0123, B:14:0x012c, B:16:0x0132, B:17:0x013e, B:18:0x0142, B:21:0x0149, B:22:0x014e, B:25:0x0157, B:27:0x0188, B:29:0x0192, B:31:0x019c, B:32:0x019f, B:33:0x01a1, B:35:0x01a7, B:36:0x01b7, B:38:0x01bd, B:39:0x01de, B:40:0x01e0, B:42:0x01e8, B:44:0x01f2, B:45:0x01f4, B:47:0x01fc, B:49:0x0208, B:50:0x020a, B:52:0x0212, B:56:0x021c, B:58:0x0224, B:60:0x022c, B:62:0x0234, B:64:0x023c, B:66:0x0244, B:68:0x024c, B:70:0x0254, B:72:0x025c, B:74:0x0264, B:76:0x026c, B:78:0x0274, B:80:0x027c, B:82:0x0285, B:84:0x028e, B:86:0x0297, B:88:0x02a0, B:90:0x02a8, B:169:0x0343, B:175:0x037d, B:177:0x0385, B:179:0x0391, B:180:0x0394, B:182:0x039c, B:184:0x03a6, B:185:0x03b1, B:187:0x03b9, B:189:0x03c7, B:190:0x03ca, B:192:0x03d2, B:194:0x03e0, B:195:0x03e3, B:197:0x03eb, B:199:0x03f9, B:200:0x03fc, B:202:0x0404, B:204:0x0410, B:205:0x0414, B:208:0x041d, B:209:0x0427, B:211:0x042f, B:213:0x043d, B:215:0x044d, B:218:0x0455, B:219:0x0458, B:221:0x0461, B:222:0x0473, B:224:0x047b, B:225:0x0483, B:227:0x048b, B:228:0x0493, B:230:0x049b, B:231:0x04a4, B:233:0x04ac, B:235:0x04bc, B:239:0x04d4, B:244:0x04dd, B:246:0x04e5, B:250:0x04f3, B:252:0x04f9, B:253:0x0505, B:254:0x0509, B:258:0x0514, B:249:0x04f0, B:243:0x04da, B:92:0x02b0, B:94:0x02bd, B:98:0x02c6, B:104:0x02d3, B:112:0x02e0, B:120:0x02ec, B:128:0x02f7, B:136:0x0302, B:144:0x030d, B:152:0x031a, B:166:0x0331, B:172:0x0377, B:174:0x037a, B:268:0x0528, B:269:0x052d), top: B:290:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03eb A[Catch: Exception -> 0x0568, Error -> 0x056c, TryCatch #3 {Error -> 0x056c, blocks: (B:7:0x008d, B:8:0x008f, B:11:0x00cb, B:13:0x0123, B:14:0x012c, B:16:0x0132, B:17:0x013e, B:18:0x0142, B:21:0x0149, B:22:0x014e, B:25:0x0157, B:27:0x0188, B:29:0x0192, B:31:0x019c, B:32:0x019f, B:33:0x01a1, B:35:0x01a7, B:36:0x01b7, B:38:0x01bd, B:39:0x01de, B:40:0x01e0, B:42:0x01e8, B:44:0x01f2, B:45:0x01f4, B:47:0x01fc, B:49:0x0208, B:50:0x020a, B:52:0x0212, B:56:0x021c, B:58:0x0224, B:60:0x022c, B:62:0x0234, B:64:0x023c, B:66:0x0244, B:68:0x024c, B:70:0x0254, B:72:0x025c, B:74:0x0264, B:76:0x026c, B:78:0x0274, B:80:0x027c, B:82:0x0285, B:84:0x028e, B:86:0x0297, B:88:0x02a0, B:90:0x02a8, B:169:0x0343, B:175:0x037d, B:177:0x0385, B:179:0x0391, B:180:0x0394, B:182:0x039c, B:184:0x03a6, B:185:0x03b1, B:187:0x03b9, B:189:0x03c7, B:190:0x03ca, B:192:0x03d2, B:194:0x03e0, B:195:0x03e3, B:197:0x03eb, B:199:0x03f9, B:200:0x03fc, B:202:0x0404, B:204:0x0410, B:205:0x0414, B:208:0x041d, B:209:0x0427, B:211:0x042f, B:213:0x043d, B:215:0x044d, B:218:0x0455, B:219:0x0458, B:221:0x0461, B:222:0x0473, B:224:0x047b, B:225:0x0483, B:227:0x048b, B:228:0x0493, B:230:0x049b, B:231:0x04a4, B:233:0x04ac, B:235:0x04bc, B:239:0x04d4, B:244:0x04dd, B:246:0x04e5, B:250:0x04f3, B:252:0x04f9, B:253:0x0505, B:254:0x0509, B:258:0x0514, B:249:0x04f0, B:243:0x04da, B:92:0x02b0, B:94:0x02bd, B:98:0x02c6, B:104:0x02d3, B:112:0x02e0, B:120:0x02ec, B:128:0x02f7, B:136:0x0302, B:144:0x030d, B:152:0x031a, B:166:0x0331, B:172:0x0377, B:174:0x037a, B:268:0x0528, B:269:0x052d), top: B:290:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0404 A[Catch: Exception -> 0x0568, Error -> 0x056c, TryCatch #3 {Error -> 0x056c, blocks: (B:7:0x008d, B:8:0x008f, B:11:0x00cb, B:13:0x0123, B:14:0x012c, B:16:0x0132, B:17:0x013e, B:18:0x0142, B:21:0x0149, B:22:0x014e, B:25:0x0157, B:27:0x0188, B:29:0x0192, B:31:0x019c, B:32:0x019f, B:33:0x01a1, B:35:0x01a7, B:36:0x01b7, B:38:0x01bd, B:39:0x01de, B:40:0x01e0, B:42:0x01e8, B:44:0x01f2, B:45:0x01f4, B:47:0x01fc, B:49:0x0208, B:50:0x020a, B:52:0x0212, B:56:0x021c, B:58:0x0224, B:60:0x022c, B:62:0x0234, B:64:0x023c, B:66:0x0244, B:68:0x024c, B:70:0x0254, B:72:0x025c, B:74:0x0264, B:76:0x026c, B:78:0x0274, B:80:0x027c, B:82:0x0285, B:84:0x028e, B:86:0x0297, B:88:0x02a0, B:90:0x02a8, B:169:0x0343, B:175:0x037d, B:177:0x0385, B:179:0x0391, B:180:0x0394, B:182:0x039c, B:184:0x03a6, B:185:0x03b1, B:187:0x03b9, B:189:0x03c7, B:190:0x03ca, B:192:0x03d2, B:194:0x03e0, B:195:0x03e3, B:197:0x03eb, B:199:0x03f9, B:200:0x03fc, B:202:0x0404, B:204:0x0410, B:205:0x0414, B:208:0x041d, B:209:0x0427, B:211:0x042f, B:213:0x043d, B:215:0x044d, B:218:0x0455, B:219:0x0458, B:221:0x0461, B:222:0x0473, B:224:0x047b, B:225:0x0483, B:227:0x048b, B:228:0x0493, B:230:0x049b, B:231:0x04a4, B:233:0x04ac, B:235:0x04bc, B:239:0x04d4, B:244:0x04dd, B:246:0x04e5, B:250:0x04f3, B:252:0x04f9, B:253:0x0505, B:254:0x0509, B:258:0x0514, B:249:0x04f0, B:243:0x04da, B:92:0x02b0, B:94:0x02bd, B:98:0x02c6, B:104:0x02d3, B:112:0x02e0, B:120:0x02ec, B:128:0x02f7, B:136:0x0302, B:144:0x030d, B:152:0x031a, B:166:0x0331, B:172:0x0377, B:174:0x037a, B:268:0x0528, B:269:0x052d), top: B:290:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x04e5 A[Catch: Exception -> 0x0568, Error -> 0x056c, TRY_LEAVE, TryCatch #3 {Error -> 0x056c, blocks: (B:7:0x008d, B:8:0x008f, B:11:0x00cb, B:13:0x0123, B:14:0x012c, B:16:0x0132, B:17:0x013e, B:18:0x0142, B:21:0x0149, B:22:0x014e, B:25:0x0157, B:27:0x0188, B:29:0x0192, B:31:0x019c, B:32:0x019f, B:33:0x01a1, B:35:0x01a7, B:36:0x01b7, B:38:0x01bd, B:39:0x01de, B:40:0x01e0, B:42:0x01e8, B:44:0x01f2, B:45:0x01f4, B:47:0x01fc, B:49:0x0208, B:50:0x020a, B:52:0x0212, B:56:0x021c, B:58:0x0224, B:60:0x022c, B:62:0x0234, B:64:0x023c, B:66:0x0244, B:68:0x024c, B:70:0x0254, B:72:0x025c, B:74:0x0264, B:76:0x026c, B:78:0x0274, B:80:0x027c, B:82:0x0285, B:84:0x028e, B:86:0x0297, B:88:0x02a0, B:90:0x02a8, B:169:0x0343, B:175:0x037d, B:177:0x0385, B:179:0x0391, B:180:0x0394, B:182:0x039c, B:184:0x03a6, B:185:0x03b1, B:187:0x03b9, B:189:0x03c7, B:190:0x03ca, B:192:0x03d2, B:194:0x03e0, B:195:0x03e3, B:197:0x03eb, B:199:0x03f9, B:200:0x03fc, B:202:0x0404, B:204:0x0410, B:205:0x0414, B:208:0x041d, B:209:0x0427, B:211:0x042f, B:213:0x043d, B:215:0x044d, B:218:0x0455, B:219:0x0458, B:221:0x0461, B:222:0x0473, B:224:0x047b, B:225:0x0483, B:227:0x048b, B:228:0x0493, B:230:0x049b, B:231:0x04a4, B:233:0x04ac, B:235:0x04bc, B:239:0x04d4, B:244:0x04dd, B:246:0x04e5, B:250:0x04f3, B:252:0x04f9, B:253:0x0505, B:254:0x0509, B:258:0x0514, B:249:0x04f0, B:243:0x04da, B:92:0x02b0, B:94:0x02bd, B:98:0x02c6, B:104:0x02d3, B:112:0x02e0, B:120:0x02ec, B:128:0x02f7, B:136:0x0302, B:144:0x030d, B:152:0x031a, B:166:0x0331, B:172:0x0377, B:174:0x037a, B:268:0x0528, B:269:0x052d), top: B:290:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x04ef  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x04f9 A[Catch: Exception -> 0x0509, Error -> 0x056c, TryCatch #3 {Error -> 0x056c, blocks: (B:7:0x008d, B:8:0x008f, B:11:0x00cb, B:13:0x0123, B:14:0x012c, B:16:0x0132, B:17:0x013e, B:18:0x0142, B:21:0x0149, B:22:0x014e, B:25:0x0157, B:27:0x0188, B:29:0x0192, B:31:0x019c, B:32:0x019f, B:33:0x01a1, B:35:0x01a7, B:36:0x01b7, B:38:0x01bd, B:39:0x01de, B:40:0x01e0, B:42:0x01e8, B:44:0x01f2, B:45:0x01f4, B:47:0x01fc, B:49:0x0208, B:50:0x020a, B:52:0x0212, B:56:0x021c, B:58:0x0224, B:60:0x022c, B:62:0x0234, B:64:0x023c, B:66:0x0244, B:68:0x024c, B:70:0x0254, B:72:0x025c, B:74:0x0264, B:76:0x026c, B:78:0x0274, B:80:0x027c, B:82:0x0285, B:84:0x028e, B:86:0x0297, B:88:0x02a0, B:90:0x02a8, B:169:0x0343, B:175:0x037d, B:177:0x0385, B:179:0x0391, B:180:0x0394, B:182:0x039c, B:184:0x03a6, B:185:0x03b1, B:187:0x03b9, B:189:0x03c7, B:190:0x03ca, B:192:0x03d2, B:194:0x03e0, B:195:0x03e3, B:197:0x03eb, B:199:0x03f9, B:200:0x03fc, B:202:0x0404, B:204:0x0410, B:205:0x0414, B:208:0x041d, B:209:0x0427, B:211:0x042f, B:213:0x043d, B:215:0x044d, B:218:0x0455, B:219:0x0458, B:221:0x0461, B:222:0x0473, B:224:0x047b, B:225:0x0483, B:227:0x048b, B:228:0x0493, B:230:0x049b, B:231:0x04a4, B:233:0x04ac, B:235:0x04bc, B:239:0x04d4, B:244:0x04dd, B:246:0x04e5, B:250:0x04f3, B:252:0x04f9, B:253:0x0505, B:254:0x0509, B:258:0x0514, B:249:0x04f0, B:243:0x04da, B:92:0x02b0, B:94:0x02bd, B:98:0x02c6, B:104:0x02d3, B:112:0x02e0, B:120:0x02ec, B:128:0x02f7, B:136:0x0302, B:144:0x030d, B:152:0x031a, B:166:0x0331, B:172:0x0377, B:174:0x037a, B:268:0x0528, B:269:0x052d), top: B:290:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0505 A[Catch: Exception -> 0x0509, Error -> 0x056c, TRY_LEAVE, TryCatch #3 {Error -> 0x056c, blocks: (B:7:0x008d, B:8:0x008f, B:11:0x00cb, B:13:0x0123, B:14:0x012c, B:16:0x0132, B:17:0x013e, B:18:0x0142, B:21:0x0149, B:22:0x014e, B:25:0x0157, B:27:0x0188, B:29:0x0192, B:31:0x019c, B:32:0x019f, B:33:0x01a1, B:35:0x01a7, B:36:0x01b7, B:38:0x01bd, B:39:0x01de, B:40:0x01e0, B:42:0x01e8, B:44:0x01f2, B:45:0x01f4, B:47:0x01fc, B:49:0x0208, B:50:0x020a, B:52:0x0212, B:56:0x021c, B:58:0x0224, B:60:0x022c, B:62:0x0234, B:64:0x023c, B:66:0x0244, B:68:0x024c, B:70:0x0254, B:72:0x025c, B:74:0x0264, B:76:0x026c, B:78:0x0274, B:80:0x027c, B:82:0x0285, B:84:0x028e, B:86:0x0297, B:88:0x02a0, B:90:0x02a8, B:169:0x0343, B:175:0x037d, B:177:0x0385, B:179:0x0391, B:180:0x0394, B:182:0x039c, B:184:0x03a6, B:185:0x03b1, B:187:0x03b9, B:189:0x03c7, B:190:0x03ca, B:192:0x03d2, B:194:0x03e0, B:195:0x03e3, B:197:0x03eb, B:199:0x03f9, B:200:0x03fc, B:202:0x0404, B:204:0x0410, B:205:0x0414, B:208:0x041d, B:209:0x0427, B:211:0x042f, B:213:0x043d, B:215:0x044d, B:218:0x0455, B:219:0x0458, B:221:0x0461, B:222:0x0473, B:224:0x047b, B:225:0x0483, B:227:0x048b, B:228:0x0493, B:230:0x049b, B:231:0x04a4, B:233:0x04ac, B:235:0x04bc, B:239:0x04d4, B:244:0x04dd, B:246:0x04e5, B:250:0x04f3, B:252:0x04f9, B:253:0x0505, B:254:0x0509, B:258:0x0514, B:249:0x04f0, B:243:0x04da, B:92:0x02b0, B:94:0x02bd, B:98:0x02c6, B:104:0x02d3, B:112:0x02e0, B:120:0x02ec, B:128:0x02f7, B:136:0x0302, B:144:0x030d, B:152:0x031a, B:166:0x0331, B:172:0x0377, B:174:0x037a, B:268:0x0528, B:269:0x052d), top: B:290:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x050d  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0512  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x042f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v145 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BDLocation(String str) {
        boolean z;
        ?? r2;
        Exception exc;
        boolean z2;
        String str2;
        JSONObject jSONObject;
        boolean z3;
        Exception exc2;
        String str3;
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
        int i;
        int i2;
        boolean z4;
        String str19;
        this.f6456a = 0;
        this.f6457b = null;
        this.f6458c = Double.MIN_VALUE;
        this.f6459d = Double.MIN_VALUE;
        this.f6460e = false;
        this.f6461f = Double.MIN_VALUE;
        this.f6462g = false;
        this.f6463h = 0.0f;
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
        String str20 = "";
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
            } catch (Error e2) {
                e2.printStackTrace();
                r2 = 0;
                this.f6456a = r2;
                this.o = r2;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            JSONObject jSONObject3 = jSONObject2.getJSONObject("result");
            int parseInt = Integer.parseInt(jSONObject3.getString("error"));
            setLocType(parseInt);
            setTime(jSONObject3.getString("time"));
            if (parseInt != 61) {
                if (parseInt == 161) {
                    JSONObject jSONObject4 = jSONObject2.getJSONObject("content");
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(Config.EVENT_HEAT_POINT);
                    setLatitude(Double.parseDouble(jSONObject5.getString("y")));
                    setLongitude(Double.parseDouble(jSONObject5.getString("x")));
                    setRadius(Float.parseFloat(jSONObject4.getString("radius")));
                    if (jSONObject4.has("sema")) {
                        JSONObject jSONObject6 = jSONObject4.getJSONObject("sema");
                        if (jSONObject6.has("aptag")) {
                            String string = jSONObject6.getString("aptag");
                            if (TextUtils.isEmpty(string)) {
                                this.q = "";
                            } else {
                                this.q = string;
                            }
                        }
                        if (jSONObject6.has("aptagd")) {
                            JSONArray jSONArray = jSONObject6.getJSONObject("aptagd").getJSONArray("pois");
                            ArrayList arrayList = new ArrayList();
                            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                JSONObject jSONObject7 = jSONArray.getJSONObject(i3);
                                arrayList.add(new Poi(jSONObject7.getString("pid"), jSONObject7.getString("pname"), jSONObject7.getDouble(Config.PRINCIPAL_PART)));
                            }
                            this.L = arrayList;
                        }
                        if (jSONObject6.has("poiregion")) {
                            String string2 = jSONObject6.getString("poiregion");
                            if (!TextUtils.isEmpty(string2)) {
                                this.r = string2;
                            }
                        }
                        if (jSONObject6.has("regular")) {
                            String string3 = jSONObject6.getString("regular");
                            if (!TextUtils.isEmpty(string3)) {
                                this.s = string3;
                            }
                        }
                    }
                    if (jSONObject4.has(DuPaBInfoMsg.B_ADDR)) {
                        try {
                            jSONObject = jSONObject4.getJSONObject(DuPaBInfoMsg.B_ADDR);
                            z3 = true;
                        } catch (Exception unused) {
                            jSONObject = null;
                            z3 = false;
                        }
                        if (jSONObject != null) {
                            str11 = jSONObject.has("city") ? jSONObject.getString("city") : "";
                            str15 = jSONObject.has("city_code") ? jSONObject.getString("city_code") : "";
                            str12 = jSONObject.has("country") ? jSONObject.getString("country") : "";
                            str17 = jSONObject.has("country_code") ? jSONObject.getString("country_code") : "";
                            str14 = jSONObject.has("province") ? jSONObject.getString("province") : "";
                            str16 = jSONObject.has("district") ? jSONObject.getString("district") : "";
                            str13 = jSONObject.has("street") ? jSONObject.getString("street") : "";
                            str18 = jSONObject.has("street_number") ? jSONObject.getString("street_number") : "";
                            if (jSONObject.has("adcode")) {
                                str20 = jSONObject.getString("adcode");
                            }
                        } else {
                            try {
                                String[] split = jSONObject4.getString(DuPaBInfoMsg.B_ADDR).split(",");
                                int length = split.length;
                                if (length > 0) {
                                    str4 = split[0];
                                    i = 1;
                                } else {
                                    i = 1;
                                    str4 = null;
                                }
                                if (length > i) {
                                    try {
                                        str5 = split[i];
                                        i2 = 2;
                                    } catch (Exception e4) {
                                        exc2 = e4;
                                        str3 = null;
                                        str5 = null;
                                        str6 = null;
                                        str7 = null;
                                        str8 = null;
                                        str9 = null;
                                        str10 = null;
                                        exc2.printStackTrace();
                                        str11 = str5;
                                        str12 = str9;
                                        str20 = null;
                                        str13 = str3;
                                        z3 = false;
                                        String str21 = str7;
                                        str14 = str4;
                                        str15 = str8;
                                        str16 = str6;
                                        str17 = str10;
                                        str18 = str21;
                                        if (z3) {
                                        }
                                        if (jSONObject4.has("floor")) {
                                        }
                                        if (jSONObject4.has("indoor")) {
                                        }
                                        if (jSONObject4.has("loctp")) {
                                        }
                                        if (jSONObject4.has("bldgid")) {
                                        }
                                        if (jSONObject4.has("bldg")) {
                                        }
                                        if (jSONObject4.has("ibav")) {
                                        }
                                        if (jSONObject4.has("indoorflags")) {
                                        }
                                        if (jSONObject4.has("gpscs")) {
                                        }
                                        if (jSONObject4.has("in_cn")) {
                                        }
                                        if (this.A == 0) {
                                        }
                                    }
                                } else {
                                    i2 = 2;
                                    str5 = null;
                                }
                                if (length > i2) {
                                    try {
                                        str6 = split[i2];
                                    } catch (Exception e5) {
                                        exc2 = e5;
                                        str3 = null;
                                        str6 = null;
                                        str7 = null;
                                        str8 = null;
                                        str9 = null;
                                        str10 = null;
                                        exc2.printStackTrace();
                                        str11 = str5;
                                        str12 = str9;
                                        str20 = null;
                                        str13 = str3;
                                        z3 = false;
                                        String str212 = str7;
                                        str14 = str4;
                                        str15 = str8;
                                        str16 = str6;
                                        str17 = str10;
                                        str18 = str212;
                                        if (z3) {
                                        }
                                        if (jSONObject4.has("floor")) {
                                        }
                                        if (jSONObject4.has("indoor")) {
                                        }
                                        if (jSONObject4.has("loctp")) {
                                        }
                                        if (jSONObject4.has("bldgid")) {
                                        }
                                        if (jSONObject4.has("bldg")) {
                                        }
                                        if (jSONObject4.has("ibav")) {
                                        }
                                        if (jSONObject4.has("indoorflags")) {
                                        }
                                        if (jSONObject4.has("gpscs")) {
                                        }
                                        if (jSONObject4.has("in_cn")) {
                                        }
                                        if (this.A == 0) {
                                        }
                                    }
                                } else {
                                    str6 = null;
                                }
                                if (length > 3) {
                                    try {
                                        str3 = split[3];
                                    } catch (Exception e6) {
                                        exc2 = e6;
                                        str3 = null;
                                        str7 = null;
                                        str8 = null;
                                        str9 = null;
                                        str10 = null;
                                        exc2.printStackTrace();
                                        str11 = str5;
                                        str12 = str9;
                                        str20 = null;
                                        str13 = str3;
                                        z3 = false;
                                        String str2122 = str7;
                                        str14 = str4;
                                        str15 = str8;
                                        str16 = str6;
                                        str17 = str10;
                                        str18 = str2122;
                                        if (z3) {
                                        }
                                        if (jSONObject4.has("floor")) {
                                        }
                                        if (jSONObject4.has("indoor")) {
                                        }
                                        if (jSONObject4.has("loctp")) {
                                        }
                                        if (jSONObject4.has("bldgid")) {
                                        }
                                        if (jSONObject4.has("bldg")) {
                                        }
                                        if (jSONObject4.has("ibav")) {
                                        }
                                        if (jSONObject4.has("indoorflags")) {
                                        }
                                        if (jSONObject4.has("gpscs")) {
                                        }
                                        if (jSONObject4.has("in_cn")) {
                                        }
                                        if (this.A == 0) {
                                        }
                                    }
                                } else {
                                    str3 = null;
                                }
                                if (length > 4) {
                                    try {
                                        str7 = split[4];
                                    } catch (Exception e7) {
                                        exc2 = e7;
                                        str7 = null;
                                        str8 = null;
                                        str9 = null;
                                        str10 = null;
                                        exc2.printStackTrace();
                                        str11 = str5;
                                        str12 = str9;
                                        str20 = null;
                                        str13 = str3;
                                        z3 = false;
                                        String str21222 = str7;
                                        str14 = str4;
                                        str15 = str8;
                                        str16 = str6;
                                        str17 = str10;
                                        str18 = str21222;
                                        if (z3) {
                                        }
                                        if (jSONObject4.has("floor")) {
                                        }
                                        if (jSONObject4.has("indoor")) {
                                        }
                                        if (jSONObject4.has("loctp")) {
                                        }
                                        if (jSONObject4.has("bldgid")) {
                                        }
                                        if (jSONObject4.has("bldg")) {
                                        }
                                        if (jSONObject4.has("ibav")) {
                                        }
                                        if (jSONObject4.has("indoorflags")) {
                                        }
                                        if (jSONObject4.has("gpscs")) {
                                        }
                                        if (jSONObject4.has("in_cn")) {
                                        }
                                        if (this.A == 0) {
                                        }
                                    }
                                } else {
                                    str7 = null;
                                }
                                if (length > 5) {
                                    try {
                                        str8 = split[5];
                                    } catch (Exception e8) {
                                        exc2 = e8;
                                        str8 = null;
                                        str9 = null;
                                        str10 = null;
                                        exc2.printStackTrace();
                                        str11 = str5;
                                        str12 = str9;
                                        str20 = null;
                                        str13 = str3;
                                        z3 = false;
                                        String str212222 = str7;
                                        str14 = str4;
                                        str15 = str8;
                                        str16 = str6;
                                        str17 = str10;
                                        str18 = str212222;
                                        if (z3) {
                                        }
                                        if (jSONObject4.has("floor")) {
                                        }
                                        if (jSONObject4.has("indoor")) {
                                        }
                                        if (jSONObject4.has("loctp")) {
                                        }
                                        if (jSONObject4.has("bldgid")) {
                                        }
                                        if (jSONObject4.has("bldg")) {
                                        }
                                        if (jSONObject4.has("ibav")) {
                                        }
                                        if (jSONObject4.has("indoorflags")) {
                                        }
                                        if (jSONObject4.has("gpscs")) {
                                        }
                                        if (jSONObject4.has("in_cn")) {
                                        }
                                        if (this.A == 0) {
                                        }
                                    }
                                } else {
                                    str8 = null;
                                }
                                if (length > 6) {
                                    try {
                                        str9 = split[6];
                                    } catch (Exception e9) {
                                        exc2 = e9;
                                        str9 = null;
                                        str10 = null;
                                        exc2.printStackTrace();
                                        str11 = str5;
                                        str12 = str9;
                                        str20 = null;
                                        str13 = str3;
                                        z3 = false;
                                        String str2122222 = str7;
                                        str14 = str4;
                                        str15 = str8;
                                        str16 = str6;
                                        str17 = str10;
                                        str18 = str2122222;
                                        if (z3) {
                                        }
                                        if (jSONObject4.has("floor")) {
                                        }
                                        if (jSONObject4.has("indoor")) {
                                        }
                                        if (jSONObject4.has("loctp")) {
                                        }
                                        if (jSONObject4.has("bldgid")) {
                                        }
                                        if (jSONObject4.has("bldg")) {
                                        }
                                        if (jSONObject4.has("ibav")) {
                                        }
                                        if (jSONObject4.has("indoorflags")) {
                                        }
                                        if (jSONObject4.has("gpscs")) {
                                        }
                                        if (jSONObject4.has("in_cn")) {
                                        }
                                        if (this.A == 0) {
                                        }
                                    }
                                } else {
                                    str9 = null;
                                }
                                if (length > 7) {
                                    try {
                                        str10 = split[7];
                                    } catch (Exception e10) {
                                        exc2 = e10;
                                        str10 = null;
                                        exc2.printStackTrace();
                                        str11 = str5;
                                        str12 = str9;
                                        str20 = null;
                                        str13 = str3;
                                        z3 = false;
                                        String str21222222 = str7;
                                        str14 = str4;
                                        str15 = str8;
                                        str16 = str6;
                                        str17 = str10;
                                        str18 = str21222222;
                                        if (z3) {
                                        }
                                        if (jSONObject4.has("floor")) {
                                        }
                                        if (jSONObject4.has("indoor")) {
                                        }
                                        if (jSONObject4.has("loctp")) {
                                        }
                                        if (jSONObject4.has("bldgid")) {
                                        }
                                        if (jSONObject4.has("bldg")) {
                                        }
                                        if (jSONObject4.has("ibav")) {
                                        }
                                        if (jSONObject4.has("indoorflags")) {
                                        }
                                        if (jSONObject4.has("gpscs")) {
                                        }
                                        if (jSONObject4.has("in_cn")) {
                                        }
                                        if (this.A == 0) {
                                        }
                                    }
                                } else {
                                    str10 = null;
                                }
                                if (length > 8) {
                                    try {
                                        str20 = split[8];
                                    } catch (Exception e11) {
                                        exc2 = e11;
                                        exc2.printStackTrace();
                                        str11 = str5;
                                        str12 = str9;
                                        str20 = null;
                                        str13 = str3;
                                        z3 = false;
                                        String str212222222 = str7;
                                        str14 = str4;
                                        str15 = str8;
                                        str16 = str6;
                                        str17 = str10;
                                        str18 = str212222222;
                                        if (z3) {
                                        }
                                        if (jSONObject4.has("floor")) {
                                        }
                                        if (jSONObject4.has("indoor")) {
                                        }
                                        if (jSONObject4.has("loctp")) {
                                        }
                                        if (jSONObject4.has("bldgid")) {
                                        }
                                        if (jSONObject4.has("bldg")) {
                                        }
                                        if (jSONObject4.has("ibav")) {
                                        }
                                        if (jSONObject4.has("indoorflags")) {
                                        }
                                        if (jSONObject4.has("gpscs")) {
                                        }
                                        if (jSONObject4.has("in_cn")) {
                                        }
                                        if (this.A == 0) {
                                        }
                                    }
                                } else {
                                    str20 = null;
                                }
                                str11 = str5;
                                str12 = str9;
                                str13 = str3;
                                z3 = true;
                            } catch (Exception e12) {
                                exc2 = e12;
                                str3 = null;
                                str4 = null;
                            }
                            String str2122222222 = str7;
                            str14 = str4;
                            str15 = str8;
                            str16 = str6;
                            str17 = str10;
                            str18 = str2122222222;
                        }
                        if (z3) {
                            this.u = new Address.Builder().country(str12).countryCode(str17).province(str14).city(str11).cityCode(str15).district(str16).street(str13).streetNumber(str18).adcode(str20).build();
                            this.o = true;
                        }
                    } else {
                        z4 = false;
                        try {
                            this.o = false;
                            setAddrStr(null);
                        } catch (Exception e13) {
                            e = e13;
                            z = z4;
                            exc = e;
                            z2 = z;
                            exc.printStackTrace();
                            r2 = z2;
                            this.f6456a = r2;
                            this.o = r2;
                        }
                    }
                    if (jSONObject4.has("floor")) {
                        String string4 = jSONObject4.getString("floor");
                        this.v = string4;
                        if (TextUtils.isEmpty(string4)) {
                            this.v = null;
                        }
                    }
                    if (jSONObject4.has("indoor")) {
                        String string5 = jSONObject4.getString("indoor");
                        if (!TextUtils.isEmpty(string5)) {
                            setUserIndoorState(Integer.valueOf(string5).intValue());
                        }
                    }
                    if (jSONObject4.has("loctp")) {
                        String string6 = jSONObject4.getString("loctp");
                        this.B = string6;
                        if (TextUtils.isEmpty(string6)) {
                            this.B = null;
                        }
                    }
                    if (jSONObject4.has("bldgid")) {
                        String string7 = jSONObject4.getString("bldgid");
                        this.w = string7;
                        if (TextUtils.isEmpty(string7)) {
                            this.w = null;
                        }
                    }
                    if (jSONObject4.has("bldg")) {
                        String string8 = jSONObject4.getString("bldg");
                        this.x = string8;
                        if (TextUtils.isEmpty(string8)) {
                            this.x = null;
                        }
                    }
                    if (jSONObject4.has("ibav")) {
                        String string9 = jSONObject4.getString("ibav");
                        if (!TextUtils.isEmpty(string9) && !string9.equals("0")) {
                            this.z = Integer.valueOf(string9).intValue();
                        }
                        this.z = 0;
                    }
                    if (jSONObject4.has("indoorflags")) {
                        try {
                            JSONObject jSONObject8 = jSONObject4.getJSONObject("indoorflags");
                            if (jSONObject8.has(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA)) {
                                int intValue = Integer.valueOf(jSONObject8.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA)).intValue();
                                if (intValue == 0) {
                                    setIndoorLocationSurpport(2);
                                } else if (intValue == 1) {
                                    setIndoorLocationSurpport(1);
                                }
                            }
                            if (jSONObject8.has("support")) {
                                setIndoorLocationSource(Integer.valueOf(jSONObject8.getString("support")).intValue());
                            }
                            if (jSONObject8.has("inbldg")) {
                                this.I = jSONObject8.getString("inbldg");
                            }
                            if (jSONObject8.has("inbldgid")) {
                                this.J = jSONObject8.getString("inbldgid");
                            }
                            if (jSONObject8.has("polygon")) {
                                setIndoorSurpportPolygon(jSONObject8.getString("polygon"));
                            }
                            if (jSONObject8.has("ret_fields")) {
                                try {
                                    for (String str22 : jSONObject8.getString("ret_fields").split("\\|")) {
                                        String[] split2 = str22.split("=");
                                        this.O.putString(split2[0], split2[1]);
                                    }
                                } catch (Exception e14) {
                                    e14.printStackTrace();
                                }
                            }
                        } catch (Exception e15) {
                            e15.printStackTrace();
                        }
                    }
                    if (jSONObject4.has("gpscs")) {
                        setGpsCheckStatus(jSONObject4.getInt("gpscs"));
                    } else {
                        z4 = false;
                        setGpsCheckStatus(0);
                    }
                    try {
                        if (jSONObject4.has("in_cn")) {
                            setLocationWhere(Integer.parseInt(jSONObject4.getString("in_cn")));
                        } else {
                            setLocationWhere(1);
                        }
                    } catch (Exception unused2) {
                    }
                    if (this.A == 0) {
                        str19 = CoordinateType.WGS84;
                    } else {
                        str2 = "gcj02";
                    }
                } else {
                    str2 = "gcj02";
                    if (parseInt != 66 && parseInt != 68) {
                        if (parseInt == 167) {
                            setLocationWhere(2);
                            return;
                        }
                        return;
                    }
                    JSONObject jSONObject9 = jSONObject2.getJSONObject("content");
                    JSONObject jSONObject10 = jSONObject9.getJSONObject(Config.EVENT_HEAT_POINT);
                    setLatitude(Double.parseDouble(jSONObject10.getString("y")));
                    setLongitude(Double.parseDouble(jSONObject10.getString("x")));
                    setRadius(Float.parseFloat(jSONObject9.getString("radius")));
                    a(Boolean.valueOf(Boolean.parseBoolean(jSONObject9.getString("isCellChanged"))));
                }
                setCoorType(str2);
                return;
            }
            JSONObject jSONObject11 = jSONObject2.getJSONObject("content");
            JSONObject jSONObject12 = jSONObject11.getJSONObject(Config.EVENT_HEAT_POINT);
            setLatitude(Double.parseDouble(jSONObject12.getString("y")));
            setLongitude(Double.parseDouble(jSONObject12.getString("x")));
            setRadius(Float.parseFloat(jSONObject11.getString("radius")));
            setSpeed(Float.parseFloat(jSONObject11.getString("s")));
            setDirection(Float.parseFloat(jSONObject11.getString("d")));
            setSatelliteNumber(Integer.parseInt(jSONObject11.getString("n")));
            if (jSONObject11.has("h")) {
                try {
                    setAltitude(jSONObject11.getDouble("h"));
                } catch (Exception unused3) {
                }
            }
            try {
                if (jSONObject11.has("in_cn")) {
                    setLocationWhere(Integer.parseInt(jSONObject11.getString("in_cn")));
                } else {
                    setLocationWhere(1);
                }
            } catch (Exception unused4) {
            }
            if (this.A != 0) {
                setCoorType("gcj02");
                return;
            }
            str19 = CoordinateType.WGS84;
            setCoorType(str19);
        } catch (Exception e16) {
            exc = e16;
            z2 = false;
            exc.printStackTrace();
            r2 = z2;
            this.f6456a = r2;
            this.o = r2;
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
        return this.f6461f;
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
        Bundle bundle = this.O;
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
        return this.f6458c;
    }

    public int getLocType() {
        return this.f6456a;
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
        return this.f6459d;
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
        return this.f6463h;
    }

    public String getStreet() {
        return this.u.street;
    }

    public String getStreetNumber() {
        return this.u.streetNumber;
    }

    public String getTime() {
        return this.f6457b;
    }

    public int getUserIndoorState() {
        return this.E;
    }

    public boolean hasAddr() {
        return this.o;
    }

    public boolean hasAltitude() {
        return this.f6460e;
    }

    public boolean hasRadius() {
        return this.i;
    }

    public boolean hasSateNumber() {
        return this.k;
    }

    public boolean hasSpeed() {
        return this.f6462g;
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
        this.o = str != null;
    }

    public void setAltitude(double d2) {
        if (d2 < 9999.0d) {
            this.f6461f = d2;
            this.f6460e = true;
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

    public void setDirection(float f2) {
        this.m = f2;
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

    public void setLatitude(double d2) {
        this.f6458c = d2;
    }

    public void setLocType(int i) {
        String str;
        this.f6456a = i;
        if (i != 66) {
            if (i != 67) {
                if (i == 161) {
                    str = "NetWork location successful!";
                } else if (i == 162) {
                    str = "NetWork location failed because baidu location service can not decrypt the request query, please check the so file !";
                } else if (i == 167) {
                    str = "NetWork location failed because baidu location service can not caculate the location!";
                } else if (i != 505) {
                    switch (i) {
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

    public void setLocationWhere(int i) {
        this.A = i;
    }

    public void setLongitude(double d2) {
        this.f6459d = d2;
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

    public void setRadius(float f2) {
        this.j = f2;
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

    public void setSpeed(float f2) {
        this.f6463h = f2;
        this.f6462g = true;
    }

    public void setTime(String str) {
        this.f6457b = str;
        setLocationID(j.a(str));
    }

    public void setUserIndoorState(int i) {
        this.E = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f6456a);
        parcel.writeString(this.f6457b);
        parcel.writeDouble(this.f6458c);
        parcel.writeDouble(this.f6459d);
        parcel.writeDouble(this.f6461f);
        parcel.writeFloat(this.f6463h);
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
        parcel.writeBooleanArray(new boolean[]{this.f6460e, this.f6462g, this.i, this.k, this.o, this.t, this.y});
        parcel.writeList(this.L);
        parcel.writeBundle(this.O);
    }
}
